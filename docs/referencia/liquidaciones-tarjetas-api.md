# Liquidaciones de tarjetas — guía de uso de los endpoints

**Para quién es este documento:** para alguien —persona o agente de IA— que tiene que **consumir** estos
endpoints desde afuera. No explica cómo están implementados; para eso está
`docs/planes/plan-liquidaciones-tarjetas.md`.

**Qué resuelven:** materializar en Libertya la conciliación de cobros electrónicos que ya resolvió un sistema
externo. Tres operaciones, en este orden: **resolver o crear** la liquidación de tarjetas
(`C_CreditCardSettlement`) junto a su filtro, **colgar cada cupón** (`C_CouponsSettlements`) apuntando a su
cobro (`C_Payment`), y **cargar los importes de los conceptos** —IVA, percepciones, retenciones, comisiones y
otros costos— sobre las filas que el propio modelo ya generó (sección 8).

> ⚠️ **Hay reglas que dependen del core que ejecuta la API.** El core público de Libertya no impide que un
> mismo cobro quede cargado en dos liquidaciones (`POST /couponssettlements` lo acepta) y, al completar, exige
> que la liquidación cuadre en forma exacta, sin tolerancia. Una instalación con un core customizado puede
> sumar reglas propias —rechazar el cobro repetido, admitir una tolerancia—, y esas reglas sólo rigen si es su
> core el que está cargado. `/couponssettlements/bulk`, en cambio, no cuelga un cobro que ya está en otra
> liquidación en ninguna instalación. Ver la sección 10.

---

## 1. Lo mínimo para que funcione

Si sólo vas a leer una sección, que sea esta.

```bash
# 1) Token (las credenciales van como HEADERS, no como body)
TOKEN=$(curl -s -X POST "$BASE/token" \
  -H "username: <usuario>" -H "password: <clave>" \
  -H "clientid: <id_compañía>" -H "orgid: <id_organización>")

# 2) ¿La liquidación ya existe? (muchas veces sí: los procesos de importación del ERP también las crean)
curl -G "$BASE/v1.0/creditcardsettlements" -H "Authorization: $TOKEN" \
  --data-urlencode "filter=settlementno='1145280' AND paymentdate >= '2026-07-07' AND paymentdate < '2026-07-08'"

# 3) Si no existe: ¿contra qué entidad comercial se emite? La de la entidad financiera de los cupones
curl -G "$BASE/v1.0/entidadesfinancieras" -H "Authorization: $TOKEN" \
  --data-urlencode "filter=m_entidadfinanciera_id=1010228" \
  --data-urlencode "fields=m_entidadfinanciera_id,c_bpartner_id"
# -> el c_bpartner_id del resultado es el que va en la cabecera. Ver sección 7.

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
      "additionalvalues": [ { "key": "x_codigo_externo", "value": "ABC-123" } ]
    },
    "filter": { "m_entidadfinanciera_id": 1010228 }
  }'
# -> 200 con {"c_creditcardsettlement_id":..., "c_creditcardcouponfilter_id":..., "children":[...]}
# additionalvalues va sólo si tu instalación tiene columnas propias en la cabecera
# (x_codigo_externo es un nombre inventado). Ver sección 7.

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
6. **El `c_bpartner_id` de la cabecera es el de la entidad financiera.** No lo deduzcas de la tarjeta ni lo
   armes con una tabla propia: sale de `M_EntidadFinanciera.c_bpartner_id`, que es de donde lo toman los
   importadores del ERP, y es por esa relación que el core encuentra la cuenta bancaria al completar. Ver la
   sección 7.

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
puede tener cientos o miles de cupones, así que paginá explícitamente con `limit` y `page`.

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
| `conflicto` | el cobro está en **otra** liquidación (R7), o el core de la instalación rechazó el cupón con una regla propia (R6/R7) | mirar `c_creditcardsettlement_id_en_conflicto` y `motivo` |
| `error` | falló por algo que no es una regla conocida | leer `motivo` |

**El conflicto por R7 vale en cualquier instalación.** Antes de insertar, el lote consulta qué cobros ya están
colgados de alguna liquidación, y uno que está en **otra** no se cuelga: vuelve como `conflicto` con el motivo
`R7: el cobro ya esta cargado en otra liquidacion`, aunque el core cargado no tenga esa regla. Si además el core
de la instalación rechaza un cupón con sus propias reglas (sección 10), también vuelve como `conflicto`.

**Por qué así:** las colisiones de R7 son esperables, no excepcionales — los procesos de importación del ERP
siguen activos y escribiendo sobre las mismas tablas. Si el lote fuera atómico, un solo cupón en conflicto
tiraría abajo los otros 699 que estaban bien.

**Es idempotente.** Reenviar el mismo lote no duplica nada: todo vuelve como `ya_existia` con su ID.

**Tope de 200 cupones por lote** (configurable con
`org.libertya.api.service.couponssettlements.bulk-max-size`). Por encima se responde 409 con un mensaje
explícito; **no se trunca en silencio.** Doscientos alcanza para la gran mayoría de las liquidaciones en una
sola llamada; una más grande se parte en varios lotes.

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

El campo `isactive` de cada item existe por un motivo: ni la consulta previa de `/bulk` ni la regla R7 de un
core que la tenga **miran ese campo**, así que un cupón desactivado igual bloquea a su cobro. Un item con
`isactive=false` explica un rechazo que de otro modo parecería inexplicable.

---

## 5. Campos obligatorios que no tienen valor por defecto

Son los que la base rechaza si no vienen, y no están todos marcados como obligatorios en el diccionario.

### Cabecera (`C_CreditCardSettlement`)

| Campo | ¿Obligatorio? | Nota |
|---|---|---|
| `c_bpartner_id` | **sí** | la entidad comercial de la entidad financiera (sección 7). Entra en la unicidad de R2 |
| `docstatus` | **sí** | mandar `"DR"` |
| `docaction` | **sí** | mandar `"CO"` |
| `settlementno` | en la práctica sí | **sólo numérico** (R1) |
| `paymentdate` | en la práctica sí | `"YYYY-MM-DD HH:MM:SS"` |
| `c_currency_id` | en la práctica sí | |
| `ad_org_id` | sí | |
| `additionalvalues` | no | columnas propias de tu instalación, si las tiene. Ver sección 7 |

**Columnas propias de tu instalación.** Si la cabecera tiene columnas que no figuran en el schema —por
ejemplo, datos que el core de la instalación usa al completar—, van dentro de `additionalvalues`. **Un campo
suelto que no está en el schema se descarta sin error**: la llamada devuelve 200 y la columna queda vacía. Ver
sección 7.

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
| `ad_org_id`, `c_bpartner_id` | no | si usás `/full` y no los mandás, se heredan de la cabecera |
| `additionalvalues` | no | columnas propias de tu instalación, si las tiene. Ver sección 7 |

Si no mandás el bloque `filter`, `/full` crea uno heredando `ad_org_id`, `c_currency_id` y `c_bpartner_id` de
la cabecera. Las columnas propias de la instalación **no se heredan**: si el filtro las necesita, mandalas en
el `additionalvalues` del bloque `filter` (o las completa el modelo de tu instalación al guardar, si lo hace).

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
| `c_payment_id` | en la práctica sí | un cupón sin cobro no concilia nada. Un core con la regla R6 lo exige para `include` o `isreconciled` en `'Y'` (sección 10) |
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
| Que la liquidación **cuadre**: `amount` contra la suma de `netamount` + `ivaamount` + `perception` + `withholding` + `commissionamount` + `expenses`. En el core público la comparación es **exacta, sin tolerancia**; un core customizado puede admitir una (sección 10) | `CreditCardSettlementAmountsMismatch` |
| Cuenta bancaria de liquidación (`c_bankaccount_settlement_id`) configurada en la entidad financiera activa cuyo `c_bpartner_id` es el de la cabecera | `SettlementBankAccountNotConfigured` |

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

## 7. La entidad comercial de la cabecera, y lo propio de cada instalación

### 7.1 De dónde sale el `c_bpartner_id`

Para armar la cabecera hace falta un `c_bpartner_id`: la entidad comercial contra la que se emite la
liquidación. En el core público sale de la **entidad financiera** (`M_EntidadFinanciera.c_bpartner_id`, que es
obligatorio en esa tabla):

```bash
curl -G "$BASE/v1.0/entidadesfinancieras" -H "Authorization: $TOKEN" \
  --data-urlencode "filter=m_entidadfinanciera_id=1010228" \
  --data-urlencode "fields=m_entidadfinanciera_id,c_bpartner_id,c_bankaccount_settlement_id"
```

Dos motivos para tomarlo de ahí:

- **Es lo que hace el ERP.** El importador de liquidaciones del core (`customImport/fidelius/jobs/ImportTarjeta.java`)
  busca la entidad financiera del comercio y le pone a la cabecera el `c_bpartner_id` de esa entidad
  financiera.
- **Es lo que usa `CO`.** Al completar, el core busca la cuenta bancaria del cobro que genera
  (`c_bankaccount_settlement_id`) entre las entidades financieras **activas con ese mismo `c_bpartner_id`**
  (la modificada más recientemente). Si la cabecera apunta a una entidad comercial que no es la de ninguna
  entidad financiera activa, `CO` falla con `SettlementBankAccountNotConfigured` (sección 6).

Si en vez del id tenés el número de comercio, la entidad financiera se busca por su número de establecimiento
(`establishmentnumber`). Puede haber más de una con el mismo número —una por tarjeta— y el importador elige la
de la tarjeta que se liquida (`financingservice` de la entidad financiera); no asumas que la primera es la
correcta.

Si tu instalación resuelve la entidad comercial con un maestro propio (y su core lo usa al completar), seguí la
regla de tu instalación: ese maestro se lee como explica la sección 7.3.

### 7.2 Columnas propias de una instalación: `additionalvalues`

Los schemas de estos endpoints traen sólo columnas del core público. Si tu instalación agregó columnas a estas
tablas —una customización, un plugin—, se escriben y se leen por **`additionalvalues`**, una lista de pares
`{"key": ..., "value": ...}` que tienen todos los DTO de la API.

**Para escribir:**

```json
"additionalvalues": [
  { "key": "x_codigo_externo",      "value": "ABC-123" },
  { "key": "x_sucursal_externa_id", "value": "1000005" }
]
```

- `key` es el nombre de la columna en minúscula, con o sin guiones bajos (`x_sucursal_externa_id` o
  `xsucursalexternaid`).
- `value` va siempre como texto, también los números y los ids.
- Si la columna no existe en tu instalación, el par se ignora sin error.

> ⚠️ **Mandar la columna como un campo suelto no la graba.** `{"header": {..., "x_codigo_externo": "ABC-123"}}`
> responde **200** y la columna queda vacía: un campo JSON que no está en el schema se descarta en silencio. Va
> dentro de `additionalvalues` o no va.

**Para leer:** el `GET` devuelve en `additionalvalues` las columnas de la tabla que no son campos del schema y
tienen valor.

- Las claves vienen **normalizadas**: en minúscula y **sin guiones bajos** (`xsucursalexternaid`), salvo que dos
  columnas de la tabla colisionen al normalizar, en cuyo caso cada una viene con su nombre propio. Para buscar
  una clave, normalizá vos también.
- Los valores vienen como texto.
- Con `fields`, `additionalvalues` sólo viene si lo pedís por nombre:
  `fields=c_creditcardsettlement_id,additionalvalues`.

**Las referencias de esas columnas.** Si la API está configurada con valores referenciados, una columna propia
que apunta a otra tabla trae además, en `referencedvalues`, el `<columna>__value` y el `<columna>__detail` del
registro al que apunta —acá las claves **sí** conservan los guiones bajos: `x_sucursal_externa_id__detail`—.
Sin `fields`, vienen para todas esas columnas; con `fields`, sólo para las que nombres:
`fields=additionalvalues,x_sucursal_externa_id`.

### 7.3 Tablas propias de una instalación: el endpoint genérico

Esta API no tiene endpoints tipados para tablas que no son del core público. Si tu instalación tiene un
maestro propio relacionado con las liquidaciones (por ejemplo, uno que determina la entidad comercial o las
cuentas de cada comercio), leelo con el endpoint genérico:

```bash
curl -G "$BASE/v1.0/generic/<TablaPropia>" -H "Authorization: $TOKEN" \
  --data-urlencode "filter=isactive='Y'"
```

La guía es `docs/referencia/endpoint-generico-api.md`. Ojo con una cosa: si es una tabla de plugin, su clase
vive en el `OXP.jar` de la instalación, y si la API se desplegó sin él el genérico responde *"No se encontró la
clase de modelo"* (§6 de esa guía). No es un problema del request: avisá a quien administra el despliegue.

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

> ⚠️ **La retención de IIBB sufrida no es un esquema fijo.** El core la resuelve en el momento de importar,
> según la jurisdicción del comercio que se está liquidando. Cómo replicar esa resolución con estos endpoints
> está en la sección 12.

### El flujo completo

```bash
# 1) Traducir el concepto del sistema externo a un id de Libertya
GET /v1.0/retencionschemas?filter=retencionapplication='S' AND isactive='Y'
# -> {"c_retencionschema_id": 1010152, "name": "Retencion Impuesto IVA Sufrida", "value": "IVA Sufrida", ...}

# 2) Buscar la fila de ESA liquidación para ESE concepto
GET /v1.0/withholdingsettlements?filter=c_creditcardsettlement_id=1000330
# -> una fila en cero por esquema; buscar la de c_retencionschema_id=1010152

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
antes de caer a la `X_` generada, y las cinco `M` existen en el `OXP.jar` del core público. Es decir que no hay
nada que configurar mal del lado de la API — pero **si el total de la cabecera no cambia después de un `PUT`
que devolvió 200, el problema está en el core cargado**, no acá. Es la primera cosa a verificar en un ambiente
nuevo.

> Verificado en agosto de 2026: un `PUT` de importe en `ivasettlements`, `withholdingsettlements` y
> `perceptionssettlements` actualizó `ivaamount`, `withholding` y `perception` respectivamente.
> `commissionconcepts` y `expenseconcepts` no se pudieron ejercitar porque esa base no tenía conceptos de
> tarjeta cargados, pero sus clases `M` son estructuralmente idénticas a las otras tres.

Recordar que **esto no completa la liquidación** (sección 6): los importes quedan cargados y el documento
sigue en `DR`.

---

## 9. Cómo resolver los IDs sin hardcodearlos

| Necesitás | Endpoint |
|---|---|
| **Entidad comercial de la cabecera** | `GET /v1.0/entidadesfinancieras?filter=...` → su `c_bpartner_id` — ver sección 7 |
| Moneda | `GET /v1.0/currencies` |
| Entidad financiera | `GET /v1.0/entidadesfinancieras` |
| Plan de entidad financiera | `GET /v1.0/entidadfinancieraplanes` |
| Cobro (`C_Payment`) | `GET /v1.0/payments?filter=...` |
| Liquidación existente | `GET /v1.0/creditcardsettlements?filter=...` |
| Filtro de una liquidación | `GET /v1.0/creditcardcouponfilters?filter=c_creditcardsettlement_id=NNN` |
| **Esquema de retención sufrida** | `GET /v1.0/retencionschemas?filter=retencionapplication='S'` — ver sección 8 |
| **Esquema de retención de IIBB por jurisdicción** | `entidadesfinancieras` → `retencionschemas`, y si tu core cae a otros niveles, `orginfos` / `bpartnerlocations` → `locations` — ver sección 12 |
| Tipo de retención (`'B'` = IIBB) | `GET /v1.0/retenciontypes?filter=retentiontype='B'` — ver sección 12 |
| Domicilio de la organización (`AD_OrgInfo`) | `GET /v1.0/orginfos/{ad_org_id}` — ver sección 12 |
| **Concepto de tarjeta** (comisión / otros) | `GET /v1.0/cardsettlementconcepts?filter=type='CO'` — ver sección 8 |
| Impuesto (IVA / percepción) | `GET /v1.0/taxes` |
| Tabla propia de tu instalación | `GET /v1.0/generic/{tabla}` — ver sección 7 |

---

## 10. Reglas que dependen del core de la instalación

Vale la pena repetirlo porque son advertencias que **no se manifiestan como un error**.

La API no agrega reglas de negocio propias sobre los cupones: delega en el core que tiene cargado. Las reglas
del core público valen en cualquier instalación —R1 (`settlementno` numérico), la unicidad de R2, la generación
de las filas hijas (`generateAllChildrens()`) y las guardas de borrado de R8—. Una instalación con un core
customizado puede sumar las suyas, y esas **sólo rigen si la API corre con su core**.

| Regla | Qué impide | Core público | Core customizado |
|---|---|---|---|
| R6 | marcar `include`/`isreconciled` en `'Y'` sin `c_payment_id` | ❌ | si su core la tiene |
| R7 | que un mismo `c_payment_id` esté en dos liquidaciones | ❌ en `POST /couponssettlements`. ✅ en `/bulk`, porque lo controla la API (sección 4) | si su core la tiene, también en el `POST` |
| Tolerancia al completar | rechazar por centavos una liquidación que casi cuadra | ❌: la cuadratura es exacta | puede admitir una tolerancia |

`MCouponsSettlements` del core público **no tiene `beforeSave`**. Sobre esa instalación, `POST
/couponssettlements` deja cargar un cobro en dos liquidaciones y el doble impacto pasa en silencio.

**Consecuencia para el consumidor:** las guardas propias (registro de impacto por cobro + `/exists` en vivo)
**no son opcionales**. No se pueden delegar enteras en una invariante del ERP que puede no estar. Y si colgás
cupones de a uno con el `POST`, la única protección contra el doble impacto en un core público es la tuya; con
`/bulk` la API la aplica igual.

### Qué core está corriendo

La API embebe un core. Una instalación con un core customizado corre lyrestapi compilada contra el core
público, con el `OXP.jar` de la instalación primero en `-Dloader.path` (ver `docs/compatibilidad-core.md` §3,
caso 3, y `docs/planes/plan-endpoint-generico.md` §4, con sus cuidados). Ese jar es el del build
(`lib/OXP.jar.default`), no el `lib/OXP.jar` instalado, con el que la API no arranca
(`docs/compatibilidad-core.md` §6.7). Para saber cuál quedó cargado, mirá la línea de arranque
`Core de Libertya cargado desde: ...` en el log.

Un core customizado además **exige su propio diccionario**: si su modelo consulta tablas o columnas propias,
contra otra base el alta de la cabecera falla con un `relation "..." does not exist`. El jar y la base tienen
que ser de la misma instalación.

### Qué se probó contra el core público

El 2026-11-02 los 17 tests de `CreditCardSettlementIntegrationTests` pasaron contra el core público (26.09
`dev`, build 20261028) sobre la base de tests `libertya_rel_22ar_for_api_25`, con
`org.libertya.tests.use-dynamic-defaults=true` (la entidad comercial por defecto ya no existe en esa base).
Ejercitan `/full`, el alta de un cupón, `/bulk` (incluido el conflicto de un cobro en otra liquidación),
`/exists`, las bajas rechazadas, completar (`CO`) y anular (`VO`). Las reglas propias de un core customizado
se verifican en la instalación que las tiene, no en este repo.

---

## 11. Propiedades de configuración

Las dos tienen default en línea, así que un `application.properties` viejo sigue arrancando.

| Propiedad | Default | Qué controla |
|---|---:|---|
| `org.libertya.api.service.couponssettlements.bulk-max-size` | 200 | tope de cupones por lote en `/bulk` |
| `org.libertya.api.service.couponssettlements.exists-max-size` | 1000 | tope de cobros por consulta en `/exists` |

---

## 12. La retención de IIBB: el esquema depende de la jurisdicción del comercio

```
GET /v1.0/retenciontypes                GET /v1.0/retenciontypes/{id}
GET /v1.0/orginfos                      GET /v1.0/orginfos/{ad_org_id}
GET /v1.0/locations                     GET /v1.0/locations/{id}            (ya existían)
GET /v1.0/bpartnerlocations             GET /v1.0/bpartnerlocations/{id}    (ya existían)
```

### El problema

Para casi todos los conceptos de una liquidación, el esquema o impuesto de destino se elige **una vez** y se
reusa. La retención de **IIBB sufrida** es la excepción: `generateAllChildrens()` deja en
`withholdingsettlements` una fila por cada esquema de retención sufrida activo, con el `c_region_id` del
esquema, así que una liquidación tiene una fila de IIBB **por provincia**, y el importe va en la de la
jurisdicción del comercio que se está liquidando.

El importador del core público (`getRetencionSchemaByNroEst`, en `customImport/fidelius/jobs/Import.java`,
usado desde `ImportTarjeta.java`; hay uno igual en `customImport/centralPos/jobs/Import.java`) elige esa
jurisdicción así:

1. Busca la **entidad financiera** del comercio por su número de establecimiento (la misma búsqueda de la
   sección 7.1).
2. Toma su **región**: `M_EntidadFinanciera.C_Region_ID`.
3. Con esa región, busca un `C_RetencionSchema` activo, sufrido (`retencionapplication='S'`) y con ese
   `c_region_id`, entre los de tipo IIBB (`retentiontype='B'`).

Si la entidad financiera no tiene región, o no hay esquema para ella, y hay importe de IIBB, el importador
**rechaza el registro** (*"No existe retención de IIBB sufrida, para la región configurada en la
E.Financiera"*): no cae a un esquema por defecto.

**Una instalación puede resolverlo de otra forma.** Hay cores customizados que, si la entidad financiera no
tiene región, caen a la de la **organización** (`AD_OrgInfo.C_Location_ID` → `C_Location.C_Region_ID`) y
después a la del **domicilio de la entidad comercial** de esa entidad financiera (`C_BPartner_Location` →
`C_Location.C_Region_ID`). Para esos dos niveles están `orginfos`, `locations` y `bpartnerlocations`. Replicá la
cadena de **tu** core: un consumidor que aplica niveles que su core no aplica impacta retenciones que el ERP
habría rechazado.

Esta API no resuelve la cadena del lado del servidor a propósito: son lookups de una fila, cacheables, y así
el consumidor puede decidir qué hacer en cada nivel que falle.

### Los dos maestros nuevos

**`retenciontypes`** (`C_RetencionType`): traduce el código de negocio `retentiontype` (`'B'` Ingresos Brutos,
`'G'` Ganancias, `'I'` IVA, `'J'` SIJP, `'S'` SUSS) a los `c_retenciontype_id` que `C_RetencionSchema`
referencia.

> ⚠️ **No es uno solo.** Puede haber varios tipos activos con `retentiontype='B'` —por ejemplo uno general y
> otros por provincia—, y el esquema de una provincia puede colgar de cualquiera de ellos. Tomar el primero y
> filtrar `retencionschemas` con `c_retenciontype_id = X` **puede devolver vacío para la mayoría de las
> provincias**. Hay que usar `IN (...)` con todos, o la subconsulta de abajo.

**`orginfos`** (`AD_OrgInfo`): la información adicional de la organización, donde vive el domicilio
(`c_location_id`), el CUIT y el almacén por defecto.

> `AD_OrgInfo` **no tiene un ID propio**: es una extensión 1 a 1 de `AD_Org` y su clave primaria es
> `ad_org_id`. Por eso `GET /v1.0/orginfos/{id}` recibe directamente el **`ad_org_id`** — no hace falta pasar
> por `filter` (aunque `?filter=ad_org_id=X` también funciona y devuelve una lista de uno).

### La cadena completa

Para una liquidación cuyos cupones ya tienen su `m_entidadfinanciera_id`:

```bash
# 1) La región de la entidad financiera. Es el único nivel que usa el core público.
GET /v1.0/entidadesfinancieras?filter=m_entidadfinanciera_id=1010228&fields=m_entidadfinanciera_id,c_region_id,c_bpartner_id
# -> [{"m_entidadfinanciera_id": 1010228, "c_region_id": <región>, "c_bpartner_id": 1043088}]
# c_region_id vino -> región resuelta. Saltar al paso 4.
# Vino null -> con el core público no hay jurisdicción: no impactar (ver abajo).

# 2) Sólo si tu core cae a la organización: la región de la sucursal. El {id} es el ad_org_id.
GET /v1.0/orginfos/1010053
# -> {"ad_org_id": 1010053, "c_location_id": <domicilio>, ...}
GET /v1.0/locations/<domicilio>
# -> {"c_location_id": ..., "c_region_id": ..., "regionname": ..., "city": ...}
# c_region_id vino -> resuelto. Si no, sigue.

# 3) Sólo si tu core cae al domicilio del bpartner de la entidad financiera (paso 1).
GET /v1.0/bpartnerlocations?filter=c_bpartner_id=1043088&fields=c_bpartner_location_id,c_location_id
# -> [{"c_bpartner_location_id": ..., "c_location_id": ...}]   (tomar el criterio de tu core si hay varios)
GET /v1.0/locations/<c_location_id>
# -> c_region_id, o null: sin jurisdicción resuelta. NO inventar una.

# 4) Con la región: el esquema. Una sola llamada, con los tipos IIBB resueltos por subconsulta.
GET /v1.0/retencionschemas?filter=retencionapplication='S' AND isactive='Y' AND c_region_id=<región>
        AND c_retenciontype_id IN (SELECT c_retenciontype_id FROM c_retenciontype WHERE retentiontype='B' AND isactive='Y')
# -> [{"c_retencionschema_id": ..., "name": "Retención IIBB <provincia>", "c_region_id": <región>, "c_retenciontype_id": ...}]
```

El paso 4 en dos llamadas, si se prefiere no meter una subconsulta en el `filter` (el resultado de la
primera es un catálogo chico, cacheable por corrida):

```bash
GET /v1.0/retenciontypes?filter=retentiontype='B' AND isactive='Y'&fields=c_retenciontype_id
# -> la lista de ids; puede haber varios
GET /v1.0/retencionschemas?filter=retencionapplication='S' AND isactive='Y' AND c_region_id=<región>
        AND c_retenciontype_id IN (<los ids de arriba>)
```

Con la región en `null` en todos los niveles que aplica tu core, o sin ningún esquema activo para esa
combinación, el resultado correcto es **no impactar ese concepto y decirlo** — nunca caer a un esquema por
defecto. El core, en ese caso, tampoco lo hace.

### Tres trampas del contrato

| Trampa | Qué pasa | Qué hacer |
|---|---|---|
| **No existe la columna `id`** en ningún recurso | `filter=id=<n>` sobre `locations` no da 404 ni vacío: da **409** con un error de SQL (`column "id" does not exist`), y la respuesta viene como array de un string | Filtrar por la columna real (`c_location_id=...`) o, mejor, pedir `GET /locations/{id}` |
| La clave del tipo de retención es `c_retenciontype_id` | Leer `id` de la respuesta de `retenciontypes` da `null` | Leer `c_retenciontype_id` (la respuesta también lo trae como `cretenciontypeId`) |
| Varios tipos con `retentiontype='B'` | `c_retenciontype_id = <el primero>` puede dejar afuera a la mayoría de las provincias | `IN (...)` con todos, o la subconsulta del paso 4 |

Un detalle más, que no es de la API sino del core público: en `getRetencionSchemaByNroEst` el join con
`C_RetencionType` compara el tipo del esquema consigo mismo (`rs.C_RetencionType_ID = rs.C_RetencionType_ID`),
así que la condición `retentiontype='B'` no llega a filtrar el tipo del esquema: el importador toma el primer
esquema sufrido activo de esa región, sin un orden definido. Si en la región hay un solo esquema sufrido da lo
mismo; si hay más de uno, filtrar por tipo como en el paso 4 es más estricto que el ERP. No es incorrecto, pero
conviene saberlo si alguna vez los dos difieren.

> Los endpoints de la cadena se ejercitaron a mano en septiembre de 2026 contra una base con datos reales:
> `entidadesfinancieras` devuelve `c_region_id`, `orginfos/{ad_org_id}` el `c_location_id` y `locations/{id}`
> el `c_region_id`. Lo que hace el core público con esa región sale de leer su código
> (`getRetencionSchemaByNroEst`), no de una prueba automática.
