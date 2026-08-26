# Liquidaciones de tarjetas — guía de uso de los endpoints

**Para quién es este documento:** para alguien —persona o agente de IA— que tiene que **consumir** estos
endpoints desde afuera. No explica cómo están implementados; para eso está
`docs/conciliador-ce/plan-endpoints-lyrestapi.md`.

**Qué resuelven:** materializar en Libertya la conciliación de cobros electrónicos que ya resolvió un sistema
externo. Tres operaciones, en este orden: **resolver o crear** la liquidación de tarjetas
(`C_CreditCardSettlement`) junto a su filtro, **colgar cada cupón** (`C_CouponsSettlements`) apuntando a su
cobro (`C_Payment`), y **cargar los importes de los conceptos** —IVA, percepciones, retenciones, comisiones y
otros costos— sobre las filas que el propio modelo ya generó (sección 8).

> ⚠️ **Estos endpoints asumen el core de Tehuelche.** Las reglas R6 y R7 —las que impiden que un mismo cobro
> quede cargado en dos liquidaciones— viven en `MCouponsSettlements`, una clase que **sólo existe en el core
> de Tehuelche**. Sobre una instalación con el core público el ERP **no rechazaría** el doble impacto y
> pasaría en silencio. Ver la sección 10.

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
de la sección 9 — nunca los hardcodees.

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
5. **La liquidación queda en borrador (`DR`).** Ni el `POST` ni `/full` completan: completar es una llamada
   aparte y deliberada, y no se puede deshacer sin anular. Ver la sección 6.
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

**No mandes** `couponstotalamount`, `commissionamount`, `ivaamount`, `withholding`, `perception` ni
`expenses`: los recalcula el modelo desde los cupones y desde las filas hijas de conceptos. Tampoco `processed`
ni `posted`.

`amount` y `netamount` **sí se mandan**: no son rollups, el modelo sólo los recalcula al anular o revertir. Y
son justamente los dos que se comparan al completar, así que sin ellos no hay nada que pueda cuadrar.

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

## 6. Completar, anular y cerrar

```
PUT /v1.0/creditcardsettlements/{id}/process?action=CO   # completar
PUT /v1.0/creditcardsettlements/{id}/process?action=VO   # anular
PUT /v1.0/creditcardsettlements/{id}/process?action=CL   # cerrar
```

Es `PUT` y el parámetro es `action`, igual que en el resto de los endpoints de procesado de la API. `RC`, `RA`
y `RE` no están disponibles (`docs/PENDIENTES.md` P1, y además `reActivateIt()` del modelo devuelve `false`).

**Ninguno de los otros endpoints completa nada.** Ni el `POST` de la cabecera ni `/full`: la liquidación queda
en `DR` y completarla es siempre una llamada aparte y deliberada.

### `CO` — completar

Exige tres cosas, y las tres devuelven **409** con el mensaje del core si fallan:

| Requisito | Mensaje |
|---|---|
| Período contable abierto para la fecha de pago | `@PeriodClosed@` |
| Que la liquidación **cuadre**: `amount` contra la suma de `netamount` + `ivaamount` + `perception` + `withholding` + `commissionamount` + `expenses`, dentro de la tolerancia del ERP (`ToleranciaCompletadoLiquidacionesTarjetas`, $0,50 por defecto) | `CreditCardSettlementAmountsMismatch` |
| Cuenta bancaria de liquidación configurada en la entidad financiera | `SettlementBankAccountNotConfigured` |

Si el neto no es cero, completar **genera un `C_Payment` por ese importe y lo completa**: tiene efecto
contable real. El `c_payment_id` **no viene en la respuesta** —que es vacía, como la de todos los endpoints de
procesado—; se lee con un `GET` de la cabecera después de completar.

**Es irreversible en la práctica.** El core no permite reactivar una liquidación completada: el único camino
de vuelta es `VO`, con todo lo que `VO` implica. Conviene tratar esta llamada como definitiva.

**Un `CO` fallido deja la liquidación en `DR`**, no en estado inválido (`IN`) como pasa al completar desde la
ventana del ERP: la API revierte su transacción. Pero **si el fallo ocurre después de la validación de
cuadratura**, el modelo ya borró las filas hijas de conceptos que tenían importe cero, y ese borrado lo hace
fuera de la transacción, así que sobrevive al rollback. Si guardaste los ids de las filas hijas que devolvió
`/full`, volvé a leerlas después de un `CO` fallido.

### ⚠️ `VO` — anular: es destructivo, no es un cambio de estado

Anular una liquidación:

- **borra todos sus cupones** con un `DELETE` directo sobre `C_CouponsSettlements`, sin pasar por la
  validación que impide eliminar un cupón conciliado (R8) y sin importar cuántos sean;
- anula el `C_Payment` generado al completar y borra los registros contables de la liquidación;
- pone en cero los importes de todas las filas hijas de conceptos;
- devuelve los cobros al estado de auditoría "a verificar";
- **le agrega un `^` al `settlementno`**: el número del documento deja de ser el que era.

Si lo que querés es deshacer una liquidación que **todavía está en `DR`**, lo correcto no es `VO` sino
`DELETE /v1.0/creditcardsettlements/{id}`, que es reversible y no toca los cobros.

### `CL` — cerrar

Sólo es válido sobre una liquidación ya completada, y se limita a marcarla como procesada.

### Idempotencia y reintentos

Repetir una acción ya aplicada devuelve **409** con *"la acción CO a aplicar ya coincide con el estado actual
CO"*. **Es el único 409 que un consumidor automático debería leer como éxito.** Lo que no hay que hacer es
reintentar a ciegas ante un timeout: dos `CO` en vuelo sobre la misma liquidación pueden dejar un `C_Payment`
completado y huérfano.

Y una acción que no aplica al estado actual también termina en 409: el core resuelve la acción contra el
estado del documento y, si la pedida no es válida, cae a la que el registro tiene guardada en `docaction`. La
API detecta la discrepancia y revierte, pero no conviene apoyarse en eso — pedí siempre la acción que
corresponde al `docstatus` actual.

### Lo que no cambia por tener el endpoint

- La liquidación en `DR` **ya existe y tiene sus cupones colgados**, que es lo que cierra la brecha entre el
  sistema externo y Libertya. Eso ya sirve al negocio, sin completar nada.
- **No hay asiento contable hasta que alguien complete.** Que ese paso lo dé una integración o una persona es
  una decisión de negocio, no técnica.
- Una liquidación en `DR` se puede borrar; una completada, no.

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

## 8. Los conceptos: IVA, percepciones, retenciones, comisiones y otros costos

```
GET /v1.0/retencionschemas              GET /v1.0/retencionschemas/{id}
GET /v1.0/cardsettlementconcepts        GET /v1.0/cardsettlementconcepts/{id}

GET /v1.0/ivasettlements                GET|PUT /v1.0/ivasettlements/{id}
GET /v1.0/perceptionssettlements        GET|PUT /v1.0/perceptionssettlements/{id}
GET /v1.0/withholdingsettlements        GET|PUT /v1.0/withholdingsettlements/{id}
GET /v1.0/commissionconcepts            GET|PUT /v1.0/commissionconcepts/{id}
GET /v1.0/expenseconcepts               GET|PUT /v1.0/expenseconcepts/{id}
```

### No hace falta crearlos: ya existen

Al crear la cabecera, el modelo ejecuta `generateAllChildrens()` y deja **una fila en cero por cada concepto
activo** del maestro correspondiente. Por eso `POST /creditcardsettlements/full` devuelve un array `children`
con decenas de `{"tablename": ..., "record_id": ...}`: son esas filas, ya creadas.

**Por eso estas cinco tablas no exponen `POST` ni `DELETE`.** El trabajo de una integración es otro:

1. Listar las filas de la liquidación para saber **qué concepto es cada una** (la respuesta de `/full` trae el
   `record_id` pero no la FK al concepto).
2. `PUT` sobre la fila que corresponde, con el importe.

El único caso que queda sin cubrir es un concepto dado de alta en el maestro **después** de creada la
liquidación. Si aparece en la práctica, se agrega el `POST`; hoy no está.

### Qué columna identifica el concepto en cada tabla

| Endpoint | Tabla | El concepto es | Se resuelve con | Total que recalcula en la cabecera |
|---|---|---|---|---|
| `ivasettlements` | `C_IVASettlements` | `c_tax_id` | `GET /v1.0/taxes` | `ivaamount` |
| `perceptionssettlements` | `C_PerceptionsSettlement` | `c_tax_id` | `GET /v1.0/taxes` | `perception` |
| `withholdingsettlements` | `C_WithholdingSettlement` | `c_retencionschema_id` | `GET /v1.0/retencionschemas` | `withholding` |
| `commissionconcepts` | `C_CommissionConcepts` | `c_cardsettlementconcepts_id` | `GET /v1.0/cardsettlementconcepts` | `commissionamount` |
| `expenseconcepts` | `C_ExpenseConcepts` | `c_cardsettlementconcepts_id` | `GET /v1.0/cardsettlementconcepts` | `expenses` |

`C_PerceptionsSettlement` además tiene `internalno`, obligatorio en el diccionario; como la fila viene creada
por el modelo, no hace falta mandarlo en el `PUT`.

### Los dos catálogos: cómo filtrarlos

**Ninguno de los dos filtra del lado del servidor.** El maestro sirve para más de un uso y limitarlo lo
volvería inservible para el resto, así que el filtro va en el parámetro `filter` genérico:

```bash
# Retenciones SUFRIDAS: 'S'.  Las 'E' son las emitidas, no aplican a una liquidación.
GET /v1.0/retencionschemas?filter=retencionapplication='S' AND isactive='Y'

# Conceptos de tarjeta: 'CO' comisiones, 'OT' otros costos.
GET /v1.0/cardsettlementconcepts?filter=type='CO' AND isactive='Y'
```

`c_region_id` viaja en la propia fila del esquema de retención — no hay que resolverlo aparte. Viene `null`
salvo en los esquemas que son por provincia (Ingresos Brutos).

### El flujo completo

```bash
# 1) Traducir el concepto del sistema externo a un id de Libertya
GET /v1.0/retencionschemas?filter=retencionapplication='S' AND isactive='Y'
# -> {"c_retencionschema_id": 1010152, "name": "Retencion Impuesto IVA Sufrida", "value": "IVA Sufrida", ...}

# 2) Buscar la fila de ESA liquidación para ESE concepto
GET /v1.0/withholdingsettlements?filter=c_creditcardsettlement_id=1000330
# -> 34 filas en cero, una por esquema; buscar la de c_retencionschema_id=1010152

# 3) Cargarle el importe
PUT /v1.0/withholdingsettlements/1000594
{"amount": 500.25}
# -> 200, y la cabecera pasa a withholding=500.25 sin ninguna llamada extra
```

### El recalculo de la cabecera lo hace el core, no esta API

Al guardar, `MIVASettlements` / `MPerceptionsSettlement` / `MWithholdingSettlement` / `MCommissionConcepts` /
`MExpenseConcepts` corren su `doAfterSave()`, que suma las filas de la liquidación y actualiza el total en la
cabecera. **No hay que llamar a nada más.**

Esa clase la resuelve `M_Table.getPO()` por convención de nombres: prueba `org.openXpertya.model.M<Tabla>`
antes de caer a la `X_` generada, y las cinco `M` existen en `OXP.jar`. Es decir que no hay nada que
configurar mal del lado de la API — pero **si el total de la cabecera no cambia después de un `PUT` que
devolvió 200, el problema está en el core cargado**, no acá. Es la primera cosa a verificar en un ambiente
nuevo.

> Verificado contra `ly_core_teh` (agosto 2026): `PUT` de un importe en `ivasettlements`,
> `withholdingsettlements` y `perceptionssettlements` de la liquidación 1000330 actualizó `ivaamount`,
> `withholding` y `perception` respectivamente. `commissionconcepts` y `expenseconcepts` no se pudieron
> ejercitar porque esa base no tiene conceptos de tarjeta cargados, pero sus clases `M` son estructuralmente
> idénticas a las otras tres.

Recordar que **esto no completa la liquidación** (sección 6): los importes quedan cargados y el documento
sigue en `DR`.

---

## 9. Cómo resolver los IDs sin hardcodearlos

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
| **Esquema de retención sufrida** | `GET /v1.0/retencionschemas?filter=retencionapplication='S'` — ver sección 8 |
| **Concepto de tarjeta** (comisión / otros) | `GET /v1.0/cardsettlementconcepts?filter=type='CO'` — ver sección 8 |
| Impuesto (IVA / percepción) | `GET /v1.0/taxes` |

---

## 10. La advertencia sobre el core: R6 y R7 sólo existen en Tehuelche

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

## 11. Propiedades de configuración

Las dos tienen default en línea, así que un `application.properties` viejo sigue arrancando.

| Propiedad | Default | Qué controla |
|---|---:|---|
| `org.libertya.api.service.couponssettlements.bulk-max-size` | 200 | tope de cupones por lote en `/bulk` |
| `org.libertya.api.service.couponssettlements.exists-max-size` | 1000 | tope de cobros por consulta en `/exists` |
