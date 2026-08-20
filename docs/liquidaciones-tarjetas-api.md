# Liquidaciones de tarjetas — guía de uso de los endpoints

**Para quién es este documento:** para alguien —persona o agente de IA— que tiene que **consumir** estos
endpoints desde afuera. No explica cómo están implementados; para eso está
`docs/conciliador-ce/plan-endpoints-lyrestapi.md`.

**Qué resuelven:** materializar en Libertya la conciliación de cobros electrónicos que ya resolvió un sistema
externo. Dos operaciones, en este orden: **resolver o crear** la liquidación de tarjetas
(`C_CreditCardSettlement`) junto a su filtro, y **colgar cada cupón** (`C_CouponsSettlements`) apuntando a su
cobro (`C_Payment`).

> ⚠️ **Estos endpoints asumen el core de Tehuelche.** Las reglas R6 y R7 —las que impiden que un mismo cobro
> quede cargado en dos liquidaciones— viven en `MCouponsSettlements`, una clase que **sólo existe en el core
> de Tehuelche**. Sobre una instalación con el core público el ERP **no rechazaría** el doble impacto y
> pasaría en silencio. Ver la sección 8.

---

## 1. Lo mínimo para que funcione

Si sólo vas a leer una sección, que sea esta.

```bash
# 1) Token (las credenciales van como HEADERS, no como body)
TOKEN=$(curl -s -X POST "$BASE/token" \
  -H "username: <usuario>" -H "password: <clave>" \
  -H "clientid: <id_compañía>" -H "orgid: <id_organización>")

# 2) ¿La liquidación ya existe? (el 97% de las veces, sí)
curl -G "$BASE/v1.0/creditcardsettlements" -H "Authorization: $TOKEN" \
  --data-urlencode "filter=settlementno='1145280' AND paymentdate >= '2026-07-07' AND paymentdate < '2026-07-08'"

# 3) Si no existe: crearla con su filtro, en una sola transacción
curl -X POST "$BASE/v1.0/creditcardsettlements/full" \
  -H "Authorization: $TOKEN" -H "Content-Type: application/json" \
  -d '{
    "header": {
      "ad_org_id": 1010053,
      "c_bpartner_id": 1012145,
      "c_currency_id": 118,
      "settlementno": "1145280",
      "paymentdate": "2026-07-07 00:00:00",
      "docstatus": "DR",
      "docaction": "CO"
    },
    "filter": { "m_entidadfinanciera_id": 1010228 }
  }'
# -> 200 con {"c_creditcardsettlement_id":..., "c_creditcardcouponfilter_id":..., "children":[...]}

# 4) Colgar los cupones, de a lotes de 200
curl -X POST "$BASE/v1.0/couponssettlements/bulk" \
  -H "Authorization: $TOKEN" -H "Content-Type: application/json" \
  -d '{
    "c_creditcardsettlement_id": 1000325,
    "c_creditcardcouponfilter_id": 1000325,
    "coupons": [
      { "ad_org_id": 1010053, "c_currency_id": 118,
        "m_entidadfinanciera_id": 1010228, "m_entidadfinancieraplan_id": 1010213,
        "c_payment_id": 1012120, "amount": 1500.50, "include": true,
        "trxdate": "2026-07-05 00:00:00" }
    ]
  }'
# -> 200 con un resultado POR CUPÓN. Ver sección 4: un 200 NO significa que se crearon todos.
```

**Los IDs del ejemplo son de una instancia concreta y NO sirven en otra base.** Resolvelos con los endpoints
de la sección 7 — nunca los hardcodees.

---

## 2. Las cinco cosas que más se olvidan

1. **El filtro no es opcional.** `C_CouponsSettlements.c_creditcardcouponfilter_id` es `NOT NULL` en la base:
   un cupón sin filtro directamente no entra. Por eso existe `/full`, que crea cabecera y filtro juntos.
2. **`settlementno` sólo puede ser numérico.** La regla R1 del modelo valida `\^?\d*\^?`. Una clave compuesta
   interna del estilo `P|113497|30059091|2026-07-07` es rechazada con 409. Hay que mandar el número de
   liquidación del adquirente.
3. **Para filtrar por día hay que usar un rango, no un cast.** Ver la sección 3, que es una trampa silenciosa.
4. **`include` viene en `'N'` por defecto** y el total de la liquidación (`couponstotalamount`) sólo suma los
   cupones con `include='Y'`. Si querés que el cupón participe del total, mandalo explícito.
5. **La liquidación queda en borrador (`DR`) y esta API no la completa.** Ver la sección 6.

---

## 3. El filtro de búsqueda: sintaxis y una trampa

El parámetro `filter` **es un fragmento de cláusula `WHERE` de SQL** que se concatena tal cual. No es una
lista de pares `campo=valor`.

- Los caracteres `"`, `--` y `;` se eliminan antes de usarlo. **Un punto y coma no separa condiciones**: hay
  que usar `AND`.
- Los literales de texto y fecha van entre comillas simples.
- Como lo armás vos, **los valores los tenés que citar y escapar vos**.

### La trampa: `::date` devuelve cero filas en silencio

```
# ✅ funciona
filter=settlementno='1145280' AND paymentdate >= '2026-07-07' AND paymentdate < '2026-07-08'

# ❌ NO funciona, y no da ningún error: devuelve []
filter=settlementno='1145280' AND paymentdate::date='2026-07-07'
```

Libertya reescribe el SQL antes de ejecutarlo (`org.openXpertya.dbPort.Convert`) y esa conversión rompe la
comparación de una expresión de tipo `date` contra un literal. El mismo SQL corrido directo contra la base sí
trae el registro. **Verificado el 2026-08-20.** La forma de rango además es la única que puede aprovechar un
índice sobre `paymentdate`.

### El límite por defecto es 100

Si no mandás `limit`, se devuelven como máximo 100 filas **y el resto se trunca sin aviso**. Una liquidación
puede tener cientos de cupones (el máximo histórico ronda los 3.500), así que paginá explícitamente con
`limit` y `page`.

---

## 4. El lote de cupones (`/bulk`): un 200 no quiere decir que se crearon todos

Es el endpoint que más se ejecuta, y el que tiene la semántica menos obvia.

**No hay rollback del lote.** Cada cupón se inserta en su propia transacción y la respuesta trae un resultado
por cada uno:

```json
{ "c_creditcardsettlement_id": 1000325,
  "creados": 2, "ya_existian": 1, "conflictos": 0,
  "resultados": [
    {"c_payment_id": 1012315, "estado": "creado",     "c_couponssettlements_id": 998001},
    {"c_payment_id": 1012316, "estado": "ya_existia", "c_couponssettlements_id": 774100},
    {"c_payment_id": 1012317, "estado": "conflicto",  "c_couponssettlements_id": 615002,
     "c_creditcardsettlement_id_en_conflicto": 99120, "motivo": "R7: el cobro ya esta cargado en otra liquidacion"}
  ]}
```

| `estado` | Qué pasó | Qué hacer |
|---|---|---|
| `creado` | el cupón se insertó en esta llamada | registrar el impacto |
| `ya_existia` | el cobro ya estaba colgado de **esta misma** liquidación | nada; es el caso normal de un reintento |
| `conflicto` | el cobro está en **otra** liquidación (R7), o el modelo lo rechazó (R6) | mirar `c_creditcardsettlement_id_en_conflicto` |
| `error` | falló por algo que no es una regla conocida | leer `motivo` |

**Por qué así:** las colisiones de R7 son esperables, no excepcionales — los procesos de importación del ERP
siguen activos y escribiendo sobre las mismas tablas. Si el lote fuera atómico, un solo cupón en conflicto
tiraría abajo los otros 699 que estaban bien.

**Es idempotente.** Reenviar el mismo lote no duplica nada: todo vuelve como `ya_existia` con su ID.

**Tope de 200 cupones por lote** (configurable con
`org.libertya.api.service.couponssettlements.bulk-max-size`). Por encima se responde 409 con un mensaje
explícito; **no se trunca en silencio.** Doscientos cubre el percentil 99 de las liquidaciones reales.

### La guarda previa: `/exists`

```bash
curl -X POST "$BASE/v1.0/couponssettlements/exists" \
  -H "Authorization: $TOKEN" -H "Content-Type: application/json" \
  -d '{"c_payment_ids":[1012120,1012121,1012122]}'
```

Devuelve **sólo** los cobros que ya están colgados de alguna liquidación. Los que no aparecen están libres.
Es una consulta, no una escritura: usa `POST` porque la lista puede tener cientos de elementos. Tope de 1000
(`org.libertya.api.service.couponssettlements.exists-max-size`).

> ⚠️ Que un cobro **no** figure acá no garantiza que siga libre cuando lo intentes colgar: entre la consulta
> y el `POST` puede haber corrido un proceso de importación del ERP. **La respuesta de `/bulk` es la única
> verdad definitiva.**

El campo `isactive` de cada item existe por un motivo: la regla R7 del modelo **no mira ese campo**, así que
un cupón desactivado igual bloquea a su cobro. Un item con `isactive=false` explica un rechazo que de otro
modo parecería inexplicable.

---

## 5. Campos obligatorios que no tienen valor por defecto

Son los que la base rechaza si no vienen, y no están todos marcados como obligatorios en el diccionario.

### Cabecera (`C_CreditCardSettlement`)

| Campo | ¿Obligatorio? | Nota |
|---|---|---|
| `c_bpartner_id` | **sí** | el adquirente. Entra en la unicidad de R2 |
| `docstatus` | **sí** | mandar `"DR"` |
| `docaction` | **sí** | mandar `"CO"` |
| `settlementno` | en la práctica sí | **sólo numérico** (R1) |
| `paymentdate` | en la práctica sí | `"YYYY-MM-DD HH:MM:SS"` |
| `c_currency_id` | en la práctica sí | |
| `ad_org_id` | sí | |

**No mandes** `couponstotalamount`, `commissionamount`, `ivaamount`, `netamount`, `withholding`, `perception`
ni `expenses`: los recalcula el modelo desde las filas hijas y los cupones. Tampoco `processed` ni `posted`.

### Filtro (`C_CreditCardCouponFilter`)

| Campo | ¿Obligatorio? | Nota |
|---|---|---|
| `c_creditcardsettlement_id` | **sí** | lo completa `/full` |
| `c_currency_id` | **sí** | si usás `/full` y no lo mandás, se hereda de la cabecera |
| `m_numerocomercio_id` | no | el modelo lo copia de la cabecera al guardar |

**No mandes** `importcuponesfidelius`: la importación de cupones desde `i_fidelius_*` es un proceso aparte del
ERP que esta API no dispara, y no tiene nada que ver con colgar cupones.

### Cupón (`C_CouponsSettlements`)

| Campo | ¿Obligatorio? | Nota |
|---|---|---|
| `c_creditcardsettlement_id` | **sí** | en `/bulk` puede ir una sola vez en la cabecera del lote |
| `c_creditcardcouponfilter_id` | **sí** | ídem |
| `c_currency_id` | **sí** | sin default |
| `m_entidadfinanciera_id` | **sí** | sin default |
| `m_entidadfinancieraplan_id` | **sí** | sin default |
| `c_payment_id` | en la práctica sí | R6 lo exige para `include` o `isreconciled` en `'Y'` |
| `amount`, `trxdate` | en la práctica sí | sin ellos el cupón no significa nada |
| `include` | recomendado | viene en `'N'`; sólo los `'Y'` suman al total |

---

## 6. Lo que esta API NO hace: completar

**No se expone la acción de completar la liquidación.** No hay `POST /creditcardsettlements/{id}/process`.

Completar dispara `completeIt()`, que exige que la liquidación **cuadre** dentro de la tolerancia configurada
y **crea un `C_Payment` por el neto**. Ninguna de las dos cosas puede decidirlas una integración, así que ese
paso queda en manos de una persona desde la ventana del ERP.

Consecuencias, para tenerlas presentes:

- La liquidación **existe y tiene sus cupones colgados**, que es lo que cierra la brecha entre el sistema
  externo y Libertya. Eso ya sirve al negocio.
- **No genera asiento contable** hasta que alguien la complete. Conviene que Finanzas sepa que ese paso queda
  pendiente.
- Una liquidación en `DR` **se puede borrar**, a diferencia de una completada: el error es reversible mientras
  no se complete.

### Bajas: qué se puede borrar y qué no

| Operación | Resultado |
|---|---|
| `DELETE /couponssettlements/{id}` de un cupón **conciliado** | 409 (regla R8) |
| `DELETE /creditcardcouponfilters/{id}` de un filtro **con cupones** | 409 |
| `DELETE /creditcardsettlements/{id}` de una liquidación **con cupones** | 409 |
| `DELETE /creditcardsettlements/{id}` sin cupones | borra en cascada filtros y filas hijas de conceptos |

> La guarda del filtro no es burocracia: la foreign key de los cupones contra el filtro es `ON DELETE
> CASCADE`, así que **borrar el filtro se llevaría todos sus cupones directamente desde la base, sin pasar
> por el modelo** — salteando R8, que impide borrar un cupón conciliado. Verificado contra la base: un cupón
> con `isreconciled='Y'` desaparece sin ruido. Por eso esta API lo bloquea.

---

## 7. Cómo resolver los IDs sin hardcodearlos

| Necesitás | Endpoint |
|---|---|
| Entidad comercial (el adquirente) | `GET /v1.0/bpartners?filter=...` |
| Moneda | `GET /v1.0/currencies` |
| Entidad financiera | `GET /v1.0/entidadesfinancieras` |
| Plan de entidad financiera | `GET /v1.0/entidadfinancieraplanes` |
| Cobro (`C_Payment`) | `GET /v1.0/payments?filter=...` |
| Liquidación existente | `GET /v1.0/creditcardsettlements?filter=...` |
| Filtro de una liquidación | `GET /v1.0/creditcardcouponfilters?filter=c_creditcardsettlement_id=NNN` |

---

## 8. La advertencia sobre el core: R6 y R7 sólo existen en Tehuelche

Vale la pena repetirlo porque es la única de estas advertencias que **no se manifiesta como un error**.

| Regla | Qué impide | ¿En el core público? |
|---|---|---|
| R6 | marcar `include`/`isreconciled` en `'Y'` sin `c_payment_id` | ❌ |
| R7 | que un mismo `c_payment_id` esté en dos liquidaciones | ❌ |

`MCouponsSettlements` del core público **no tiene `beforeSave`**. Sobre esa instalación un cobro puede quedar
cargado en dos liquidaciones y el doble impacto pasa en silencio.

**Consecuencia para el consumidor:** las guardas propias (registro de impacto por cobro + `/exists` en vivo)
**no son opcionales**. No se pueden delegar enteras en la invariante del ERP.

Además, el jar de Tehuelche **exige el diccionario de Tehuelche**: `generateAllChildrens()` consulta la tabla
`M_NumeroComercio`, que no existe en una base que no sea la de Tehuelche. Contra cualquier otra base el alta
de la cabecera falla con `relation "m_numerocomercio" does not exist`.

---

## 9. Propiedades de configuración

Las dos tienen default en línea, así que un `application.properties` viejo sigue arrancando.

| Propiedad | Default | Qué controla |
|---|---:|---|
| `org.libertya.api.service.couponssettlements.bulk-max-size` | 200 | tope de cupones por lote en `/bulk` |
| `org.libertya.api.service.couponssettlements.exists-max-size` | 1000 | tope de cobros por consulta en `/exists` |
