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
> pasaría en silencio. Ver la sección 9.

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

# 3) Si no existe: ¿contra qué entidad comercial se emite? Lo dice el número de comercio
curl -G "$BASE/v1.0/numeroscomercio" -H "Authorization: $TOKEN" \
  --data-urlencode "filter=numerocomercio='29283231' AND adquirente='P' AND financingservice='MA' AND isactive='Y'"
# -> el c_bpartner_id del resultado es el que va en la cabecera. NO se deduce del adquirente. Ver sección 7.

# 4) Crearla con su filtro, en una sola transacción
curl -X POST "$BASE/v1.0/creditcardsettlements/full" \
  -H "Authorization: $TOKEN" -H "Content-Type: application/json" \
  -d '{
    "header": {
      "ad_org_id": 1010053,
      "c_bpartner_id": 1043088,
      "c_currency_id": 118,
      "settlementno": "1145280",
      "paymentdate": "2026-07-07 00:00:00",
      "docstatus": "DR",
      "docaction": "CO",
      "m_numerocomercio_id": 1000005,
      "adquirente": "P",
      "financingservice": "MA",
      "establishmentnumber": "29283231"
    },
    "filter": { "m_entidadfinanciera_id": 1010228 }
  }'
# -> 200 con {"c_creditcardsettlement_id":..., "c_creditcardcouponfilter_id":..., "children":[...]}

# 5) Colgar los cupones, de a lotes de 200
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
de la sección 8 — nunca los hardcodees.

---

## 2. Las seis cosas que más se olvidan

1. **El filtro no es opcional.** `C_CouponsSettlements.c_creditcardcouponfilter_id` es `NOT NULL` en la base:
   un cupón sin filtro directamente no entra. Por eso existe `/full`, que crea cabecera y filtro juntos.
2. **`settlementno` sólo puede ser numérico.** La regla R1 del modelo valida `\^?\d*\^?`. Una clave compuesta
   interna del estilo `P|113497|30059091|2026-07-07` es rechazada con 409. Hay que mandar el número de
   liquidación del adquirente.
3. **Para filtrar por día hay que usar un rango, no un cast.** Ver la sección 3, que es una trampa silenciosa.
4. **`include` viene en `'N'` por defecto** y el total de la liquidación (`couponstotalamount`) sólo suma los
   cupones con `include='Y'`. Si querés que el cupón participe del total, mandalo explícito.
5. **La liquidación queda en borrador (`DR`) y esta API no la completa.** Ver la sección 6.
6. **El `c_bpartner_id` de la cabecera no se deduce del adquirente.** Un mismo adquirente puede operar contra
   varias entidades comerciales; lo único que lo determina es el número de comercio. Ver la sección 7.

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
| `c_bpartner_id` | **sí** | la entidad comercial del adquirente. **Sale del número de comercio, no del adquirente** (sección 7). Entra en la unicidad de R2 |
| `docstatus` | **sí** | mandar `"DR"` |
| `docaction` | **sí** | mandar `"CO"` |
| `settlementno` | en la práctica sí | **sólo numérico** (R1) |
| `paymentdate` | en la práctica sí | `"YYYY-MM-DD HH:MM:SS"` |
| `c_currency_id` | en la práctica sí | |
| `ad_org_id` | sí | |
| `adquirente`, `financingservice`, `establishmentnumber` | no, pero mandalos | son los tres campos del comercio. Ver abajo |
| `m_numerocomercio_id` | no | ídem |

Los cuatro campos del comercio **no son obligatorios, pero conviene mandarlos igual**. Cuando alguien complete
la liquidación desde el ERP, `completeIt()` los usa para resolver el comercio y armar la descripción del
`C_Payment` que genera —número de liquidación, comercio, tarjeta y adquirente—. Si van en blanco el cobro
queda sin esa información y no hay forma de reponerla después. No cuestan nada: ya salieron de la consulta que
resolvió el `c_bpartner_id`.

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

## 7. El número de comercio: de dónde sale el `c_bpartner_id`

```
GET /v1.0/numeroscomercio            (lista, con filter / fields / sort / limit / page)
GET /v1.0/numeroscomercio/{id}
```

Sólo lectura. El maestro se administra desde la ventana del ERP.

### Por qué existe

Para armar la cabecera hace falta un `c_bpartner_id`, y **no se deduce del adquirente**. Sobre los datos
reales del cliente, un mismo adquirente opera contra varias entidades comerciales:

| adquirente | entidades comerciales distintas |
|---|---:|
| `F` (Fiserv) | 6 |
| `P` (Prisma) | 6 |
| `T` (Otros) | 2 |
| el resto | 1 |

Lo único que determina la entidad comercial es el **número de comercio**. De ahí salen también las cuentas
bancarias (`c_bankaccount_id`, `c_bankaccount_settlement_id`) que el ERP usa al completar.

### Los campos

| Campo | Qué es |
|---|---|
| `m_numerocomercio_id` | el id, para mandarlo en la cabecera |
| `numerocomercio` | el número que asigna el adquirente al comercio |
| `adquirente` | código de 1 letra: `P` Prisma, `F` Fiserv, `N` Naranja, `C` Cabal, `A` Amex, `M` Mercado Pago, `G` Galicia, `H` Patagonia 365, `O` Confiable, `T` Otros |
| `financingservice` | código de 2 letras de la tarjeta: `VI`, `MA`, `AM`, `CA`, `NA`, `DI`, `UP`, `MP`, `QR`, ... |
| `c_bpartner_id` | **la entidad comercial que va en la cabecera de la liquidación** |
| `c_bankaccount_id` | cuenta bancaria del comercio |
| `c_bankaccount_settlement_id` | cuenta para el pago que genera el ERP al completar. Suele venir vacía |
| `value` | etiqueta legible, del estilo `29283231-PRISMA-Master` |
| `ad_org_id` | la sucursal a la que pertenece el comercio |

Los códigos de `adquirente` y `financingservice` salen de dos listas del diccionario —`Adquirentes tarjetas`
y `CreditCardTypes`, en `AD_Ref_List`—. **Ojo: `/v1.0/reflists` no te las va a devolver**, porque esas filas
son de `ad_client_id = 0` y el filtro por compañía que aplica la API las deja afuera. Usá la tabla de arriba,
o miralas desde la ventana de referencias del ERP.

La respuesta sí trae `referencedvalues` con el nombre de la sucursal (`ad_org_id__detail`) y de la cuenta
bancaria, sin necesidad de otra llamada.

### ⚠️ La clave natural NO es única

El core resuelve el comercio por la terna `numerocomercio` + `adquirente` + `financingservice`
(`MCreditCardSettlement.getM_NumeroComercio_ID()`), pero **esa terna puede devolver varias filas**: hay
comercios repetidos entre sucursales y algunos repetidos dentro de la misma. Sobre los datos del cliente, 13
ternas están duplicadas, con hasta 4 filas cada una.

**Para lo que importa acá no cambia nada:** en las 13, todas las filas apuntan al **mismo** `c_bpartner_id`.
Pero el consumidor tiene que estar preparado para más de un resultado y no asumir que el primero es "el
correcto" — lo que varía entre ellas es la sucursal.

Si además querés acotar por sucursal, agregá `ad_org_id` al filtro.

### Atajo: desde la entidad financiera

Si ya tenés el `m_entidadfinanciera_id` del cupón, la entidad financiera trae el comercio desnormalizado
(`m_numerocomercio_id`, `adquirente`, `financingservice`, `establishmentnumber`, `c_bpartner_id`), así que
podés saltar en un solo paso:

```bash
curl "$BASE/v1.0/entidadesfinancieras/1010228" -H "Authorization: $TOKEN"
```

**Pero es una copia, no la fuente.** El ERP la sincroniza sólo cuando se *modifica* un comercio existente
(`MNumeroComercio.afterSave`), con lo cual un comercio nuevo nunca se propaga, y sobre los datos del cliente
53 entidades financieras activas no tienen comercio asignado. Úsala como atajo, y ante cualquier duda leé el
maestro.

---

## 8. Cómo resolver los IDs sin hardcodearlos

| Necesitás | Endpoint |
|---|---|
| Entidad comercial (el adquirente) | `GET /v1.0/bpartners?filter=...` |
| Moneda | `GET /v1.0/currencies` |
| Entidad financiera | `GET /v1.0/entidadesfinancieras` |
| Plan de entidad financiera | `GET /v1.0/entidadfinancieraplanes` |
| Cobro (`C_Payment`) | `GET /v1.0/payments?filter=...` |
| **Número de comercio** (y con él el `c_bpartner_id`) | `GET /v1.0/numeroscomercio?filter=...` — ver sección 7 |
| Liquidación existente | `GET /v1.0/creditcardsettlements?filter=...` |
| Filtro de una liquidación | `GET /v1.0/creditcardcouponfilters?filter=c_creditcardsettlement_id=NNN` |

---

## 9. La advertencia sobre el core: R6 y R7 sólo existen en Tehuelche

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

Por lo mismo, **`/v1.0/numeroscomercio` (sección 7) sólo funciona contra Tehuelche.** No es únicamente que la
tabla no exista en otra base: es una tabla de plugin, y su clase Java vive en
`com.hipertehuelche.sucursales.model`. Libertya la resuelve leyendo del diccionario qué componente es dueño de
la tabla (`AD_Component` / `AD_ComponentVersion`), así que si ese registro falta —aunque la tabla y sus filas
estén— la recuperación por id devuelve **404 sin ningún error**, porque `M_Table.getPO()` retorna `null` en vez
de fallar. Es exactamente lo que verifica el test `retrieveDebeResolverLaClaseDelPlugin`.

---

## 10. Propiedades de configuración

Las dos tienen default en línea, así que un `application.properties` viejo sigue arrancando.

| Propiedad | Default | Qué controla |
|---|---:|---|
| `org.libertya.api.service.couponssettlements.bulk-max-size` | 200 | tope de cupones por lote en `/bulk` |
| `org.libertya.api.service.couponssettlements.exists-max-size` | 1000 | tope de cobros por consulta en `/exists` |
