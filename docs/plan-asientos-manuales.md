# Plan de implementación — Endpoints de asientos contables manuales (GL_Journal)

**Estado:** **CA-1 resuelto (opción A)** el 2026-08-10 con evidencia de la instancia productiva de referencia
(§12.5). Ya no queda ninguna decisión abierta: el plan está listo para ejecutarse tal cual.
**Fecha:** agosto 2026 · última revisión 2026-08-10
**Alcance:** funcionalidad **genérica de la API**, para cualquier instancia Libertya.
**Origen del pedido:** proyecto Cintolo MRP (repo hermano, `/home/julian/libertya/git/cintolo-mrp`) — es el
disparador y el primer consumidor, no el destinatario del diseño. Ver §1 para el contexto histórico; de la §2
en adelante el documento trata la funcionalidad como genérica.
**Verificado** contra el código del core, los genéricos de este repo y la BD `libertya_qa` el 2026-08-07 — la
evidencia y las correcciones resultantes están en la **sección 12**. Las secciones 1 a 11 ya están corregidas.

---

## 0. Cómo usar este documento

Este documento es autocontenido: contiene el contexto del pedido, el análisis del modelo de Libertya
involucrado, el contrato de API propuesto, las decisiones de diseño con su justificación, y el plan de
implementación paso a paso con los archivos concretos a tocar.

### Si estás retomando esto en una sesión nueva

1. **CA-1 está resuelto: opción A** — la línea identifica la cuenta con `c_elementvalue_id`, y acepta
   opcionalmente un `c_validcombination_id` ya armado. La evidencia que lo cerró está en §12.5. No hay
   decisiones abiertas.
2. Leé las secciones **3 a 5**: las reglas del core que hay que respetar, el contrato y las decisiones de
   diseño con su porqué. La §1 es contexto histórico, se puede saltear.
3. La sección **6 es el plan ejecutable**, paso a paso, con los archivos concretos.
4. La sección **12 es la evidencia**: qué se verificó contra el código y contra la BD, y qué correcciones
   salieron de ahí. Si algo del plan te parece raro, la respuesta probablemente esté ahí.
5. La sección 7 tiene código de referencia externo (proyecto `lyws`) que **conviene mirar pero no copiar tal
   cual** — está explicado por qué.

**Estado del trabajo:** fases 1 y 2 implementadas (2026-08-10). La guía de uso de los endpoints, pensada para
que la lea una IA que va a consumirlos, está en **`docs/asientos-manuales-api.md`**.

**Antes de codear, ojo con estas cinco** — son las que no se ven leyendo las clases del modelo y ya costaron
una vuelta de revisión:

| | Qué |
|---|---|
| 1 | `C_ConversionType_ID` es NOT NULL sin default en ningún lado — el cliente lo tiene que mandar (§3.5) |
| 2 | `processEntity` no puede ejecutar `RC`/`RA`/`RE` — solo `CO`/`VO`/`CL` (§3.4, `PENDIENTES.md` P1) |
| 3 | El suspense balancing está activo: el core **no** rechaza asientos descuadrados (§3.1, §12.4) |
| 4 | `TEST_DATE` de `CommonIntegrationTests` cae en período cerrado para `GLJ` — usar 2024-01-10 (§8, §12.2) |
| 5 | En el diccionario la obligatoriedad está al revés del contrato: `C_ValidCombination_ID` es `ismandatory='Y'` y `C_ElementValue_ID` es `'N'`. No rompe nada (el core completa la combinación antes del INSERT) pero define qué sale en el `required:` generado (§12.5) |

---

## 1. Contexto y origen del pedido

**Cintolo MRP** es un sistema de administración de la producción que se está construyendo de cero para
Cintolo Hermanos (reemplaza un AS400) y convive con Libertya como ERP. Su DFD define **9 puntos de
integración** con Libertya, que fueron validados contra esta API — spec OpenAPI, código fuente de este repo,
y smoke tests con credenciales reales contra la instancia de Cintolo.

El **punto 8, "Contabilidad de costos e inventario (MRP → ERP)"**, resultó **sin endpoint**:

> No existe ningún endpoint de asiento contable / libro diario. Lo único con "journal" en el nombre es
> `posjournal`, que es la caja diaria de punto de venta — no tiene relación con asientos contables.
> Confirmado contra el spec (0 resultados de `journal`/`account`/`gl`/`asiento` entre los 129 paths, salvo
> `posjournal*`), contra el código fuente de este repo (no hay ningún controller de asiento), y con un smoke
> test real.

Fuente completa del relevamiento (en el otro repo):
`cintolo-mrp/docs/analisis-api-libertya/Analisis_API_REST_Libertya_Cintolo.md`, secciones 2, 6 y 7.
El smoke test que lo comprueba: `cintolo-mrp/tools/validacion-api-libertya/validaciones/punto_08_contabilidad.py`.

La respuesta funcional del lado de Libertya (Nacho, agosto 2026) fue:

> "Si no hay endpoints para publicar asientos contables hay que crearlos, como hicimos en su momento para
> SOAP dentro del proyecto de Cintolo."

Ese antecedente SOAP existe y está identificado — ver sección 7.

### Decisión de alcance ya tomada (agosto 2026)

Se consultó con el equipo de Cintolo MRP qué necesitan exactamente. La respuesta:

> **Hay que poder hacer asientos manuales.** El resto se procesa por los distintos documentos.

Esto es coherente con cómo funciona Libertya/Adempiere: `M_InOut`, `M_Inventory`, `C_Invoice` y `C_Movement`
se contabilizan solos por el motor de posting (`Doc_*` → `Fact_Acct`). Y el punto 3 del DFD ya quedó resuelto
así: los ajustes de stock del MRP van por `inouts`/`inventories`, que ya existen en esta API.

Lo que **no tiene documento origen en el ERP** — absorción de mano de obra y gastos indirectos, variaciones
de costo estándar vs. real, WIP, cierre mensual de costos — vive entero en el MRP y solo puede volcarse a
Libertya como **asiento manual**. Eso es lo que hay que construir acá.

---

## 2. Alcance

### Incluido

1. **Recurso `journals`** (`GL_Journal` + `GL_JournalLine`): alta de asiento completo (cabecera + líneas) en
   una sola transacción, consulta, modificación y borrado en borrador, y procesado (completar / anular /
   revertir / reactivar).
2. **Recurso `journallines`** suelto, para corregir líneas de un asiento en borrador.
3. **Maestros contables de solo lectura**, imprescindibles para que el cliente pueda armar un asiento válido
   sin hardcodear IDs internos de Libertya: `elementvalues` (plan de cuentas), `acctschemas`, `glcategories`,
   `periods`.

### Excluido, y por qué

| Fuera de alcance | Motivo |
|---|---|
| `GL_JournalBatch` (lote de asientos) | Solo agrega numeración y agrupación. En `lyws` se empezó y se abandonó explícitamente por innecesario (ver sección 7), y en dos años no hizo falta. Si aparece la necesidad, se agrega después con el mismo patrón. |
| `C_ValidCombination` como recurso REST | El cliente no debe conocer combinaciones contables. Se resuelve del lado servidor — ver decisión **D1**. |
| Escritura sobre maestros contables (`C_ElementValue`, `C_AcctSchema`, `C_Period`) | El plan de cuentas y el calendario los administra Libertya. El MRP solo los consulta. |
| Forzar el posteo a `Fact_Acct` desde la API | El posteo lo maneja el Accounting Processor de Libertya, y es **diferido** (§12.3). |
| Recurso `factaccts` (lectura de asientos posteados, para conciliación) | Valioso pero no bloqueante. Ver **fase 4**. |

---

## 3. El modelo del core y sus reglas (lo que la API tiene que respetar)

Jerarquía: `GL_JournalBatch` (lote, opcional — fuera de alcance) → **`GL_Journal`** (asiento) →
**`GL_JournalLine`** (renglón Debe/Haber).

Clases del core, en `/home/julian/libertya/git/libertya/base/src/org/openXpertya/model/`:
`MJournal.java`, `MJournalLine.java`, `X_GL_Journal.java`, `X_GL_JournalLine.java`, `MAccount.java`.

### 3.1 Validaciones de cabecera — `MJournal.prepareIt()` (`MJournal.java:477`)

Todas estas fallan el `Complete` y hay que poder devolverlas como error entendible (409):

| Validación | Mensaje del core |
|---|---|
| Debe existir un período para `DateAcct` | `@PeriodNotFound@` |
| El período debe estar **abierto** para el `DocBaseType` del `C_DocType_ID` | `@PeriodClosed@` |
| El período encontrado debe coincidir con `C_Period_ID` si es período estándar | `@PeriodNotValid@` |
| Debe haber al menos una línea | `@NoLines@` |
| **Debe = Haber**, salvo que el esquema contable tenga `IsUseSuspenseBalancing` | `@UnbalancedJornal@` |
| Si `ControlAmt ≠ 0`, debe coincidir con `TotalDr` | `@ControlAmtError@` |
| Ninguna línea puede ser de cuenta `DocControlled` | `@DocControlledError@` |

> ⚠️ **El control Debe = Haber NO está activo en estas instancias.** `c_acctschema_gl.usesuspensebalancing = 'Y'`
> en los tres esquemas contables de `libertya_qa` (incluido el 1010016). Con eso, `prepareIt` **no** emite
> `@UnbalancedJornal@`: completa el asiento y manda la diferencia a la cuenta de balanceo suspenso.
> Prueba real en la BD: el asiento 1010471 tiene `totaldr=500 / totalcr=0`, quedó `docstatus='CO'`, `posted='Y'`
> y generó dos `Fact_Acct` — la línea real y una contrapartida automática a `1.01.01.03 CUENTA PUENTE DE
> COMPROBACION`. Ver decisión **D7**: la API valida el balanceo por su cuenta.

`MJournal.beforeSave()` (`MJournal.java:902`) además:
- Rechaza `ControlAmt < 0`.
- **Autocompleta `C_Period_ID` a partir de `DateAcct`** → el cliente no necesita mandarlo.

Defaults del constructor de registro nuevo (`MJournal.java:57-92`): `CurrencyRate=1`, `DateAcct=hoy`,
`DateDoc=hoy`, `DocAction=CO`, `DocStatus=DR`, `PostingType=A` (Actual), `TotalDr=TotalCr=0`,
`IsApproved/IsPrinted/Posted/Processed=false`.

### 3.2 Validaciones de línea — `MJournalLine.beforeSave()`

- **Exactamente una** de `AmtSourceDr` / `AmtSourceCr` distinta de cero (la otra en 0). Las dos en cero, o
  las dos con valor → error de save.
- `CurrencyRate` se resuelve solo vía `MConversionRate` contra la moneda del esquema contable; si no
  encuentra, queda en 1.
- `AmtAcctDr` / `AmtAcctCr` se calculan solos (`rate × AmtSource`, con el scale del esquema).
- `Line` se autonumera de a 10 si viene en 0.
- Necesita `C_ValidCombination_ID` **o** `C_ElementValue_ID`; si no hay ninguno → `@NoElementValue@`.
- Si vienen los dos y no coinciden, resetea el `C_ValidCombination_ID` para rebuscarlo.
- `afterSave` / `afterDelete` recalculan `TotalDr`/`TotalCr` de la cabecera por SQL. **El cliente no manda
  totales.**

### 3.3 Hallazgo clave: el core ya resuelve la combinación válida

Esto simplifica mucho la fase 1 y conviene tenerlo presente antes de portar nada de `lyws`.

`MJournalLine.beforeSave()` ya hace **buscar-o-crear** la `C_ValidCombination` a partir de
`C_ElementValue_ID`: si la línea trae cuenta pero no combinación, busca con `MAccount.get(...)` en el
esquema contable del client y, si no existe, crea una nueva `MAccount` y la asigna.

**Consecuencia práctica:**

- Si el asiento **no necesita dimensiones analíticas** (solo cuenta contable), alcanza con que el cliente
  mande `c_elementvalue_id` en cada línea. **No hace falta escribir ninguna lógica de combinaciones.**
- La lógica de `lyws` aporta valor **solo si hacen falta dimensiones** (organización, producto, entidad
  comercial, proyecto, campaña), porque el core crea la combinación con `AD_Org_ID = 0` y todas las
  dimensiones en 0.

Por eso el plan separa fase 1 (sin dimensiones, cero lógica custom) de fase 3 (con dimensiones, ahí sí se
porta lo de `lyws`). La fase 1 igual deja la puerta abierta: acepta `c_validcombination_id` para el cliente
avanzado que ya sepa qué combinación quiere (**D1**).

### 3.4 DocActions soportadas por `MJournal` — y cuáles puede exponer la API

`MJournal` implementa `completeIt` (`MJournal.java:618`), `voidIt` (`:675`), `closeIt` (`:720`),
`reverseCorrectIt` (`:775`), `reverseAccrualIt` (`:795`), `reActivateIt` (`:821`).

**Pero el genérico de este repo solo puede expresar tres de ellas.** `AbstractRepository.processEntity`
(`AbstractRepository.java:801`) valida después de procesar que `action == docstatus` y hace rollback si no
coinciden. Como el `DocumentEngine` deja un `DocStatus` distinto del `action` en los casos de reversión:

| `action` | `DocStatus` resultante | Resultado por el genérico |
|---|---|---|
| `CO` | `CO` | ✅ funciona |
| `VO` | `VO` | ✅ funciona |
| `CL` | `CL` | ✅ funciona |
| `RC` | `RE` (Reversed) — `DocumentEngine.java:626` | ❌ 409 + **rollback de la reversión** |
| `RA` | `RE` — `DocumentEngine.java:654` | ❌ 409 + rollback |
| `RE` (ReActivate) | `IP` (InProgress) — `DocumentEngine.java:682` | ❌ 409 + rollback |

Para `RE` hay un segundo problema: el pre-check de `processEntity` (`:793`) rechaza reactivar un asiento
reversado (`docstatus='RE'`) con *"la acción ya coincide con el estado actual"*.

**Decisión: la fase 1 expone únicamente `CO`, `VO` y `CL`.** El antecedente SOAP tampoco implementó reversión
ni reactivación (solo create / complete / void / delete en borrador) y alcanzó para dos años de producción.

⚠️ **Pero anular no es lo mismo que revertir, y para contabilidad la diferencia importa.** `MJournal.voidIt`
(`MJournal.java:675-711`) **borra la contabilidad** (`MFactAcct.delete`) y **pone todas las líneas en cero**:
el asiento queda como una cáscara vacía, sin rastro de lo que decía. La práctica contable para corregir un
asiento ya contabilizado es el **contra-asiento** (`RC`), que deja los dos asientos visibles y auditables. En
una instancia con auditoría o con períodos ya reportados, `VO` puede directamente no ser aceptable.

O sea: `RC` no es un lujo, es la operación correcta para corregir. Queda fuera de la fase 1 porque arreglarlo
implica tocar `processEntity`, que es **compartido por todos los documentos** (facturas, pedidos, pagos) — es
un bug latente del genérico que los asientos son simplemente los primeros en necesitar, no algo específico de
`GL_Journal`.

Está documentado aparte en **`docs/PENDIENTES.md` → P1**, con el diagnóstico y el arreglo propuesto. **No
bloquea nada de este plan.** Lo único que hay que hacer acá es **documentar la limitación en la descripción
del endpoint**, para que nadie asuma que `VO` es una reversión contable.

### 3.5 Columnas que el cliente está obligado a mandar

`GL_Journal` y `GL_JournalLine` son más estrictas que los documentos ya implementados en esta API. Estas
columnas son **NOT NULL sin default en la BD, sin default en el diccionario, y sin valor asignado por el
constructor del modelo** — o sea que no las cubre nadie:

| Tabla | Columna | Por qué |
|---|---|---|
| `GL_Journal` | `C_ConversionType_ID` | `MJournal.java:71` la tiene comentada. Comparar: `C_Invoice.c_conversiontype_id` **sí** es nullable, por eso esto no aparece en facturas/pedidos. |
| `GL_JournalLine` | `C_ConversionType_ID` | `MJournalLine.java:66`, ídem |
| `GL_Journal` | `Description` | `MJournal.java` no la setea; NOT NULL sin default |

`PO.saveNew()` omite del INSERT las columnas nulas (`PO.java:2508-2510`, *"Don't insert NULL values (allows
Database defaults)"*), así que llega un NULL y la BD lo rechaza. `AbstractRepository.setDefaultValue` tampoco
lo salva: solo aplica defaults del diccionario que no empiecen con `@`, y el de `C_ConversionType_ID` está
vacío. (Detalle: `PO.isMandatoryOK()` existe pero **nunca se invoca**, así que el error sale como PSQLException
cruda, no como `@FillMandatory@`.)

Las tres son `ismandatory='Y'` en el diccionario, así que **`genSchema` las incluye solas** en el schema y en
el bloque `required:`. No hay que hacer nada especial: solo documentar que son obligatorias en el payload —
igual que hacía el WS SOAP, que tampoco aplicaba defaults (`GeneralHandler.setValues` con
`setDefaultValues=false`) y cuyos clientes mandaban `c_conversiontype_id=114` en cabecera y en cada línea.

En cambio **sí** están cubiertas por el constructor o por la BD, y el cliente no las manda: `DateAcct`,
`DateDoc`, `PostingType`, `DocStatus`, `DocAction`, `CurrencyRate`, `TotalDr`, `TotalCr`, `IsApproved`,
`IsPrinted`, `Posted`, `Processed`, `IsReActivated`, `DocumentNo` (secuencia, `PO.java:2424-2444`),
`C_Period_ID` (`MJournal.beforeSave`), y en la línea `DateAcct`, `Line`, `IsGenerated`, `AmtAcctDr/Cr` y
`C_ValidCombination_ID` (`MJournalLine.beforeSave`).

> Los defaults del constructor **sobreviven** al mapeo genérico: `loadValueToPO`
> (`AbstractRepository.java:612`) no pisa con `null` un valor que el PO ya tiene seteado.

---

## 4. Contrato de API propuesto

### 4.1 Endpoints

| Método | Path | Body / Query | Respuesta |
|---|---|---|---|
| `POST` | `/v1.0/journals` | `JournalDocument` + `?complete` `?validatebalance` | `200` + `GL_Journal_ID` (text/plain) · `409` |
| `GET` | `/v1.0/journals` | `filter`,`fields`,`sort`,`limit`,`page` | `200` + `[Journal]` |
| `GET` | `/v1.0/journals/{id}` | — | `200` + `JournalDocument` · `404` |
| `PUT` | `/v1.0/journals/{id}` | `Journal` | `200` · `404` · `409` |
| `DELETE` | `/v1.0/journals/{id}` | — | `204` · `404` · `409` |
| `PUT` | `/v1.0/journals/{id}/process` | `?action=CO\|VO\|CL` (ver §3.4) | `200` · `404` · `409` |
| `GET/POST` | `/v1.0/journallines` | ídem patrón estándar | |
| `GET/PUT/DELETE` | `/v1.0/journallines/{id}` | | |
| `GET` | `/v1.0/elementvalues` · `/{id}` | solo lectura | plan de cuentas |
| `GET` | `/v1.0/acctschemas` · `/{id}` | solo lectura | esquemas contables |
| `GET` | `/v1.0/glcategories` · `/{id}` | solo lectura | categorías de asiento |
| `GET` | `/v1.0/periods` · `/{id}` | solo lectura | períodos contables |

**Sobre el nombre `journals`:** es distinto y no colisiona con el `posjournals` existente (caja de POS,
`C_POSJournal`), que es un recurso sin relación. Vale la pena aclararlo en la descripción del tag para que
nadie los confunda — la confusión ya ocurrió una vez durante el relevamiento del punto 8.

### 4.2 Ejemplo de alta

```
POST /v1.0/journals
Authorization: Bearer <jwt>
Content-Type: application/json
```

Los IDs son los **reales de la instancia QA** (compañía 1010016), tomados de los asientos que dejó el WS SOAP
— ver §12.2. No son inventados.

```json
{
  "header": {
    "ad_org_id": 1010053,
    "c_acctschema_id": 1010016,
    "c_doctype_id": 1010506,
    "c_currency_id": 118,
    "gl_category_id": 1010098,
    "c_conversiontype_id": 114,
    "dateacct": "2024-01-10 00:00:00",
    "datedoc": "2024-01-10 00:00:00",
    "postingtype": "A",
    "description": "MRP - Absorcion MO enero 2024"
  },
  "lines": [
    {
      "ad_org_id": 1010053,
      "c_elementvalue_id": 1012830,
      "c_currency_id": 118,
      "c_conversiontype_id": 114,
      "amtsourcedr": 158340.55,
      "amtsourcecr": 0,
      "description": "MO aplicada centro 100"
    },
    {
      "ad_org_id": 1010053,
      "c_elementvalue_id": 1012839,
      "c_currency_id": 118,
      "c_conversiontype_id": 114,
      "amtsourcedr": 0,
      "amtsourcecr": 158340.55,
      "description": "MO absorbida"
    }
  ]
}
```

Respuesta `200`: `1023456` (el `GL_Journal_ID`).

**Obligatorios y fáciles de olvidar** (§3.5): `c_conversiontype_id` en cabecera **y en cada línea**, y
`description` en la cabecera. Sin ellos el INSERT falla contra la BD.

Lo que el cliente **no manda**: `c_period_id` (se deriva de `dateacct`), `totaldr`/`totalcr` (los recalcula
el modelo), `line` (autonumerado), `amtacctdr`/`amtacctcr` y `currencyrate` (calculados), `docstatus`
(default `DR`), `posted`/`processed`, `documentno` (secuencia).

`ad_org_id` y `dateacct` de las líneas son opcionales: si no vienen, el service las hereda de la cabecera
(igual que hacía el WS SOAP en `JournalDocumentHandler.java:198-199`).

### 4.3 Notas de contrato

- **`GET /v1.0/journals/{id}` devuelve el documento completo** (cabecera + líneas), igual que
  `inventories/{id}` — no solo la cabecera. El listado `GET /v1.0/journals` devuelve solo cabeceras.
  ⚠️ `performRetrieve` debe setear un `limit` explícito en el `QueryParams` de las líneas: si se deja en
  `null`, `retrieveAllEntities` aplica `DEFAULT_LIMIT=100` (`AbstractRepository.java:326`) y **trunca el
  asiento en silencio**. Un cierre mensual de costos del MRP puede superar las 100 líneas sin esfuerzo.
  Ordenar además por `line`.
- Los errores usan los códigos que ya mapea `AbstractController`: `ModelException` → **409**,
  `AuthException` → **401**, `NotFoundException` → **404**. **Nunca devolver 200 con un error adentro.**
- **El mensaje del core no llega literal**, hay dos transformaciones antes del body:
  1. `processEntity` lo pasa por `Msg.parseTranslation` (`AbstractRepository.java:797`) → `@PeriodClosed@`
     sale traducido si existe el `AD_Message`.
  2. En el `POST`, `AbstractService.create` lo envuelve: `"Error creando documento: " + e.getMessage()`
     (`AbstractService.java:83`).

  Los tests deben asertar el status y un substring del texto real, nunca el literal `@Xxx@`.
  Corolario: en el `POST` una `AuthException` también sale como **409**, no 401, porque `create()` catchea
  `Exception` y la reenvuelve en `ModelException`.
- `additionalvalues` / `referencedvalues` funcionan solos por el genérico de `AbstractRepository` — no hay
  que hacer nada especial.

---

## 5. Decisiones de diseño

### D1 — La línea acepta cuenta y/o combinación, con al menos una obligatoria

> ✅ **Cerrada el 2026-08-10 (CA-1, opción A)**, con la evidencia de la instancia productiva de referencia en
> §12.5: todas las líneas que creó el WS SOAP llevan `c_elementvalue_id`, y las combinaciones resultantes
> salen con `ad_org_id=0` y sin dimensiones — exactamente lo que produce el core sin escribir lógica propia.

La línea acepta `c_elementvalue_id` y/o `c_validcombination_id`, y exige que venga **al menos uno**.

**Motivo:** un consumidor razona en términos de plan de cuentas, que es lo estable y lo que la fase 2 expone;
la combinación contable es un ID interno que varía por instancia y que puede directamente no existir todavía.
Además la validación sale gratis — `MJournalLine.beforeSave` ya falla con `@NoElementValue@` si no viene
ninguno — y el core resuelve la combinación solo a partir de la cuenta (§3.3). Aceptar los dos no cierra
ninguna puerta: quien necesite control fino manda la combinación armada.

### D2 — Fase 1 sin dimensiones analíticas

La fase 1 no implementa lógica propia de `C_ValidCombination`: acepta `c_elementvalue_id` (y opcionalmente un
`c_validcombination_id` ya armado) y deja que el core resuelva la combinación. **Motivo:** el core cubre
entero el caso sin dimensiones (§3.3), así que la fase 1 sale sin escribir una línea de lógica contable, y
cualquier error ahí crea `C_ValidCombination` basura en la base de una instancia productiva. La imputación
por dimensiones es una extensión natural y está planificada como fase 3 — no es un descarte, es un corte.

### D3 — El `complete` debe poder decidirse por request

Hoy `AbstractService.shouldComplete()` lee una propiedad **global**
(`org.libertya.api.service.doc.complete` en `application.properties`). Para asientos eso no alcanza: un
asiento de cierre de costos probablemente quiera revisión humana antes de completarse, mientras que una
factura sí se completa sola.

Propuesta: `POST /v1.0/journals?complete=true|false`, con el valor global como default cuando el param no
viene.

⚠️ **Implementación obligada: un overload `AbstractService.create(info, document, boolean complete)`**, con el
`create(info, document)` actual delegando en él (`create(info, doc, shouldComplete())`). No toca a los demás
services.

**No** sobrescribir `shouldComplete()` con un flag guardado en el service: los services son singletons Spring
(`@Service`), así que un campo mutable es un *data race* entre requests concurrentes — un `POST` podría
terminar completando (o no) el asiento de otro. El precedente SOAP va en la misma dirección: pasaba el
booleano como argumento de la operación (`journalCreate(data, boolean completeJournal)`), nunca como estado.

### D4 — Idempotencia: la resuelve el consumidor, pero la API tiene que documentar cómo

Si un consumidor reintenta un `POST` por timeout, no puede duplicar el asiento. **No hace falta lógica nueva
en la API**: alcanza con que grabe su propia referencia en el asiento y consulte antes de insertar.

```
GET /v1.0/journals?filter=description LIKE 'CIERRE-COSTOS-202608%'
```

`description` alcanza y es lo que se documenta: es obligatoria de todos modos (§3.5), así que siempre hay
dónde poner la marca. Se documenta la **convención** (prefijo estable elegido por el consumidor + un
identificador propio), no un formato impuesto por la API.

La trazabilidad de *cuándo* y *por dónde* entró el asiento **ya viene gratis** y no necesita ningún campo
nuevo: `Created` guarda el timestamp y `CreatedBy` el usuario, que en una integración es el usuario de la API.
Ambos los devuelve el `GET` por el mecanismo genérico de columnas.

Si alguna instancia quiere una columna dedicada, la puede agregar en su diccionario y la API la expone sola
por ese mismo mecanismo — pero **no es parte de esta implementación** y no se nombra por cliente.

En SOAP esto se resolvía con las operaciones `...ByColumn` (completar/anular/consultar por columna +
criterio); acá el equivalente es el query param `filter`, que ya existe.

### D5 — Maestros contables de solo lectura

Sin `elementvalues` el consumidor tiene que hardcodear IDs internos de Libertya, que además **cambian de una
instancia a otra**: un asiento armado contra los IDs de una base no sirve en la siguiente. Se exponen con
`get` únicamente, siguiendo el precedente de `paths/storages.yaml`.

`periods` merece mención aparte: permite **validar que el período esté abierto antes de mandar el asiento**, y
así dar un mensaje propio en vez de comerse un 409.

### D6 — Sin `GL_JournalBatch`

Ver §2. Si se necesita después, es el mismo patrón `AbstractService` con un nivel más de anidamiento.

### D7 — Qué hacer con un asiento descuadrado (Debe ≠ Haber)

Un asiento contable tiene que cerrar: la suma del Debe debe igualar la del Haber. Lo esperable es que el core
rechace con `@UnbalancedJornal@`. **Pero no lo hace**, porque `usesuspensebalancing` está en `Y`: en vez de
rechazar, completa el asiento y **empareja la diferencia contra la cuenta puente de comprobación** definida en
el esquema contable (§3.1, con prueba real en §12.4).

Eso es una decisión deliberada del ERP — la cuenta puente existe justamente para entradas importadas que no
cierran — pero para un API tiene un costado feo: un bug de cálculo del consumidor no se manifiesta como un
409, sino como un descuadre silencioso que queda escondido en la contabilidad y que alguien va a tener que
encontrar y desarmar meses después.

**Decisión: por defecto la API NO valida** — respeta lo que el esquema contable tenga configurado, igual que
la UI del ERP. La validación es **opt-in**, para la instancia que la quiera.

Motivo: el comportamiento de cuenta puente es una decisión deliberada de quien configuró la contabilidad, y
una API genérica no debería pisarla. Que la API se comporte distinto que el ERP para el mismo dato es peor
que el riesgo que evita.

Se configura igual que el resto de las opciones de comportamiento del proyecto — propiedad global con
override por request, misma forma que **D3**:

```properties
# application.properties — validar Debe = Haber antes de insertar un asiento (Y/N). Por defecto N.
org.libertya.api.service.journal.validate-balance=${JOURNAL_VALIDATE_BALANCE:N}
```

```
POST /v1.0/journals?validatebalance=true      # fuerza la validación para este request
POST /v1.0/journals?validatebalance=false     # la saltea para este request
POST /v1.0/journals                           # usa el valor de la propiedad
```

Cuando está activa, `JournalService.performCreate` suma `amtsourcedr` y `amtsourcecr` de las líneas y
devuelve **409 antes de insertar nada** si no coinciden.

**Transparencia con la validación apagada:** un asiento descuadrado se completa, pero queda visible — el
`GET /v1.0/journals/{id}` devuelve `totaldr` y `totalcr` distintos, porque `prepareIt` los recalcula desde las
líneas. Un consumidor que quiera chequear puede hacerlo sin que la API le imponga nada.

---

## 6. Plan de implementación

### Fase 1 — Recurso `journals` (núcleo)

Sigue exactamente el patrón de documento ya existente. **`Inventory` es el análogo más cercano** (cabecera +
líneas + DocAction, sin impuestos): mirar `InventoryService`, `InventoryRepository`,
`InventoryLineRepository`, `InventoryController` y sus yaml antes de empezar.

#### 1.1 Schemas desde metadata

Agregar a `utils/genSchema.sh`:

```sh
generateSchema Journal      GL_Journal      journal.yaml      "('description', 'controlamt', 'c_conversiontype_id', 'gl_journalbatch_id', 'gl_category_id', 'c_acctschema_id')"
generateSchema JournalLine  GL_JournalLine  journalline.yaml  "('description', 'c_elementvalue_id', 'c_validcombination_id', 'line', 'qty', 'c_uom_id', 'c_conversiontype_id')"
```

⚠️ El 4º parámetro es necesario porque `genSchema.sql` **solo incluye columnas con `ismandatory='Y'`** salvo
las que se listen explícitamente. Sin eso, el cliente no podría mandar ni `description` ni
`c_elementvalue_id`. **Verificar contra el diccionario real cuáles de esas columnas ya son mandatory** (las
que lo sean se incluyen igual; listarlas de más no rompe nada).

`genSchema.sh` corre contra una BD Libertya viva (ver la config al principio del script: `DB_NAME`,
`USER_NAME`). Si no hay BD a mano, los `model/*.yaml` se pueden escribir a mano siguiendo el formato de
`model/inventory.yaml`.

#### 1.2 Documento compuesto (a mano)

Crear `src/main/resources/model/journal_doc.yaml`, calcado de `model/inventory_doc.yaml`:

```yaml
components:
  schemas:
    JournalDocument:
      type: object
      properties:
        header:
          $ref: '../model/journal.yaml#/components/schemas/Journal'
        lines:
          type: array
          items:
            $ref: '../model/journalline.yaml#/components/schemas/JournalLine'
```

#### 1.3 Paths

Crear en `src/main/resources/paths/`, copiando de los equivalentes de inventory:

- `journals.yaml` — `get` (filter/fields/sort/limit/page → `[Journal]`) + `post` (body `JournalDocument`).
  Agregar acá los query params opcionales `complete` (**D3**) y `validatebalance` (**D7**), ambos con la
  propiedad global como default cuando no vienen.
- `journals_id.yaml` — `get` → `JournalDocument`, `put` (body `Journal`), `delete`.
- `journals_id_process.yaml` — `put` con query param `action`. Copiar de `inventories_id_process.yaml` y
  documentar en la descripción los valores válidos: **`CO`, `VO`, `CL` únicamente** (§3.4).
- `journallines.yaml` / `journallines_id.yaml` — copiar de `inventorylines*.yaml`.

Registrar los paths en `src/main/resources/ly-rest-api.yaml`:

```yaml
  /v1.0/journals:
    $ref: ./paths/journals.yaml
  /v1.0/journals/{id}:
    $ref: ./paths/journals_id.yaml
  /v1.0/journals/{id}/process:
    $ref: ./paths/journals_id_process.yaml
  /v1.0/journallines:
    $ref: ./paths/journallines.yaml
  /v1.0/journallines/{id}:
    $ref: ./paths/journallines_id.yaml
```

#### 1.4 Regenerar stubs

```sh
cd utils && ./genClasses.sh
```

Genera `stub/iface/JournalApi`, `stub/iface/JournalLineApi` y `stub/model/{Journal,JournalLine,JournalDocument}`.
**No editar nada bajo `stub/` a mano.**

> **Dato útil:** el codegen emite `@NotNull` sobre los campos `required`, pero el proyecto **no** tiene
> `spring-boot-starter-validation` (solo `javax.validation:validation-api`, ver `build.gradle`), así que no
> hay implementación de Bean Validation y esas anotaciones son inertes en runtime. Por eso
> `InventoryIntegrationTest` puede crear un inventario mandando 6 campos. **No hay que podar el bloque
> `required:` generado** por miedo a un 400.

#### 1.5 Repositories

```java
// repository/JournalRepository.java
public JournalRepository() { tableName = X_GL_Journal.Table_Name; iface = Journal::new; }

// repository/JournalLineRepository.java
public JournalLineRepository() { tableName = X_GL_JournalLine.Table_Name; iface = JournalLine::new; }
```

Nada más — todo el CRUD, la paginación, el mapeo reflexivo contra `M_Column`, los defaults y el
`DocAction` los da `AbstractRepository`.

#### 1.6 Service

`service/JournalService.java extends AbstractService`, calcado de `InventoryService`:

- `getRepository()` → `journalRepository`.
- `performCreate(info, document, trxName)`:
  1. **Si la validación de balanceo está activa** (propiedad o query param, **D7**): sumar Debe y Haber de las
     líneas del payload y tirar `ModelException` si no cuadran. Por defecto está apagada.
  2. Insertar cabecera, obtener el id.
  3. Por cada línea: setear `gl_journal_id`, y heredar de la cabecera `ad_org_id` y `dateacct` si vienen
     nulos (§4.2).
  4. Insertar líneas.

  **Todo con el mismo `trxName`** — `AbstractService.create()` ya maneja commit/rollback. Es imprescindible:
  `MJournalLine.beforeSave` recarga el journal desde la BD (`new MJournal(ctx, getGL_Journal_ID(), trxName)`)
  para resolver el esquema contable y la fecha, así que la cabecera tiene que ser visible en esa transacción.
- `performRetrieve(info, id)`: cabecera + líneas filtrando `gl_journal_id=<id>`, **con `limit` explícito y
  `sort` por `line`** (§4.3).
- Recibir el `complete` por parámetro según **D3** (overload de `create`, no estado en el service).

#### 1.7 Controllers

`controller/JournalController.java implements JournalApi extends AbstractController` y
`controller/JournalLineController.java`, calcados de `InventoryController` / los controllers de línea:
métodos de una línea delegando a `insertAction`, `retrieveAction`, `retrieveAllAction`, `updateAction`,
`deleteAction`, `processAction`.

### Fase 2 — Maestros contables de solo lectura

Mismo circuito, más simple (sin service, sin documento compuesto):

```sh
generateSchema ElementValue  C_ElementValue  elementvalue.yaml  "('description', 'accounttype', 'accountsign', 'issummary', 'isdoccontrolled', 'c_element_id', 'validfrom', 'validto')"
generateSchema AcctSchema    C_AcctSchema    acctschema.yaml    "('description', 'c_currency_id', 'costingmethod', 'costinglevel', 'isaccrual')"
generateSchema GLCategory    GL_Category     glcategory.yaml    "('description', 'categorytype', 'isdefault')"
generateSchema Period        C_Period        period.yaml        "('description', 'periodtype', 'periodno', 'startdate', 'enddate', 'c_year_id')"
```

Paths solo con `get` (patrón `paths/storages.yaml`), + repository + controller por cada uno. Registrar en
`ly-rest-api.yaml` como `/v1.0/elementvalues`, `/v1.0/acctschemas`, `/v1.0/glcategories`, `/v1.0/periods`
(y sus `/{id}`).

Sin esto la fase 1 es usable pero el cliente tiene que hardcodear IDs — **conviene entregar 1 y 2 juntas**.

### Fase 3 — Dimensiones analíticas (cuando aparezca el primer consumidor que las necesite)

Se hace cuando aparezca un consumidor que necesite imputar por producto / entidad comercial / proyecto /
campaña / organización. El core no cubre este caso (§3.3): crea la combinación con todas las dimensiones en 0.
Acá sí se porta la lógica de `lyws` (sección 7), con las correcciones indicadas.

Contrato: campos opcionales en la línea (`m_product_id`, `c_bpartner_id`, `c_project_id`, `c_campaign_id`),
y el service resuelve-o-crea la `C_ValidCombination` **dentro de la misma transacción** antes de insertar la
línea.

### Fase 4 — Conciliación (subió de prioridad: el posteo es diferido)

Recurso `factaccts` de solo lectura (`Fact_Acct`), para que el MRP verifique qué se contabilizó realmente y
concilie su mayor de costos contra el del ERP.

Ya no es opcional-a-futuro: **quedó verificado que el posteo es diferido** (§12.3). El `Complete` deja el
asiento en `posted='N'` y es el Accounting Processor el que lo postea segundos o minutos después. O sea que el
`200` del `POST` **no significa que el asiento esté en `Fact_Acct`**, y sin este recurso el MRP no tiene forma
de enterarse de que se contabilizó. Sigue sin bloquear las fases 1 y 2, pero hay que planificarla.

---

## 7. Código de referencia: `lyws` (el antecedente SOAP)

**Ubicación:** `/home/julian/libertya/git/lyws`
**Archivos:** `src/org/libertya/ws/handler/JournalDocumentHandler.java` (implementado y funcionando),
`src/org/libertya/ws/handler/JournalBatchCRUDHandler.java` (incompleto a propósito).
Commits: `a11bea6` ("Logica para manejo de Journals completada...") y `f9dbf2c` ("Logica para valid
combinations en el alta de lineas de diario"), 2023-11-23.
Hay además un proyecto SoapUI contra ese WS en `/home/julian/libertya/CintoloWS-soapui-project.xml`.

Este es el desarrollo al que se refiere el comentario "como hicimos en su momento para SOAP dentro del
proyecto de Cintolo".

### Qué preguntas cerró (revisión del 2026-08-07)

- **Qué campos hay que mandar.** `journalCreate` usa el overload de 3 args de `setValues`
  (`GeneralHandler.java:249-251`), que resuelve a `setValues(po, map, newRecord, force=false,
  setDefaultValues=false)`: **lyws no aplica ningún default**, solo escribe lo que el cliente mandó. Confirma
  §3.5 — el `c_conversiontype_id` lo mandaba el cliente, no había ningún mecanismo que lo completara.
- **Qué DocActions hacen falta de verdad.** lyws implementó create / complete / void / delete-en-borrador /
  retrieve, y **nada de reversión ni reactivación**. Base empírica de la decisión de §3.4.
- **Cómo pasar el flag de completar.** Como argumento de la operación, no como configuración global (**D3**).
- **Que el reload manual no aplica acá.** Ver el punto siguiente.

### Qué sirve

- **El flujo de `journalCreate`** (`JournalDocumentHandler.java:160`): crear cabecera → líneas →
  **recargar el journal desde la BD** → `DocumentEngine.processAndSave(Complete)` → commit. El comentario en
  el código dice *"Recargar Journal, sino no se completa el documento"* — detalle no obvio que puede
  aparecer también acá. En este repo el `complete` lo hace `AbstractRepository.process()`, así que puede no
  aplicar; **si el complete falla raro, mirar esto primero.**
- **`getValidCombinationIDFromLine`** (`:50`) y **`getExistentVC`** (`:106`): la lógica de buscar-o-crear la
  combinación válida a partir de cuenta + producto + EC + proyecto + campaña + organización. Es la pieza de
  valor real, **para la fase 3**.
- **La convención de nombres por línea** (`vc_elementvalue`, `vc_productvalue`, `vc_bpartnervalue`,
  `vc_projectvalue`, `vc_campaignvalue`) como base del contrato de dimensiones.

### Qué NO copiar

1. **SQL por concatenación de strings.** `getExistentVC` (`:110-135`) arma el `WHERE` interpolando valores
   directamente. Acá va con `PreparedStatement` parametrizado.
2. **Transacción separada para la ValidCombination.** `getValidCombinationIDFromLine` crea una `Trx` nueva y
   la commitea (`:60` y `:92`). Si después falla el asiento, quedan `C_ValidCombination` huérfanas en la
   base. En este repo `AbstractService.create()` corre todo bajo una `Trx` con rollback: **crear la
   combinación dentro de esa misma transacción**.
3. **`Env.getCtx()` global** (`:61`, `:174`). Acá el contexto es por request (`UserInfo.getCtx()`, ver
   `AbstractRepository.getCtx(info)`); usar el global rompe el aislamiento client/org que impone
   `ClientOrgAuth`.
4. **`JournalBatchCRUDHandler` completo.** Está marcado como incompleto en su propio javadoc
   (`JournalBatchCRUDHandler.java:30`) y tiene un bug real: el loop interno de líneas itera sobre la lista de
   journals en vez de las líneas del journal (`:88`), y el result devuelve strings vacíos (`:111`). Motivo
   extra para dejar `GL_JournalBatch` fuera de alcance.
5. **Error dentro de una respuesta exitosa**: `journalCreate` devuelve `new ResultBean(true, msg, null)` ante
   una excepción (`:232`) — limitación de SOAP. Acá sale gratis hacerlo bien: `AbstractController` ya mapea
   `ModelException` → 409. **No agregar envelopes de error.**

---

## 8. Tests

> **Diferidos.** La prioridad es tener los endpoints andando y probarlos a mano contra la instancia de
> pruebas. Los tests automatizados se escriben después, con este capítulo como especificación — no se
> descarta nada de lo que sigue, solo se posterga.
>
> Mientras tanto, la verificación es **manual contra la instancia de pruebas**: recorrer los casos de la tabla
> de abajo con `curl` o Postman y confirmar los códigos de respuesta. Los valores concretos para armar los
> requests están en §12.2 y el ejemplo completo en §4.2.

Cuando se hagan: crear `src/test/java/org/libertya/api/JournalIntegrationTests.java`, calcado de
`InventoryIntegrationTest.java`, extendiendo `CommonIntegrationTests`.

**Precondiciones**: compañía `1010016` / organización `1010053`, usuario `AdminLibertya` y
`org.libertya.api.service.doc.complete=Y`, todo ya documentado en `CommonIntegrationTests`.

⚠️ **Pero NO usar `TEST_DATE`.** `CommonIntegrationTests.TEST_DATE = "2023-06-01"` y en `libertya_qa` el
período `jun-23` (1010519) está **cerrado para `GLJ`**. Los únicos períodos abiertos para `GLJ` en la compañía
1010016 son `ene-24` (1010514) y `ENE-DIC 2025` (1010568). El test de asientos necesita su propia constante:

```java
/** Distinta de TEST_DATE: el periodo de TEST_DATE esta cerrado para GLJ. Ver plan-asientos-manuales.md §12.2 */
public static final String TEST_DATE_GLJ = "2024-01-10 00:00:00";
```

`2024-01-10` está probado empíricamente: es la fecha de los tres asientos que el WS SOAP creó y completó en
esa base. (Alternativa: cualquier fecha de 2025, que además tiene un único período cubriendo el año y evita la
ambigüedad de los dos calendarios solapados que existen sobre enero-2024.)

Casos mínimos:

| # | Caso | Esperado |
|---|---|---|
| 1 | Alta de asiento balanceado (2 líneas, Dr = Cr) con `c_elementvalue_id` | `200` + id |
| 2 | `GET /journals/{id}` del creado | `200`, `docstatus=CO`, 2 líneas, `totaldr == totalcr` |
| 3a | Alta **descuadrada** (Dr ≠ Cr), sin validación (comportamiento por defecto) | `200` — se completa y la diferencia va a la cuenta puente. Verificar que el `GET` muestra `totaldr != totalcr` |
| 3b | Alta **descuadrada** con `?validatebalance=true` | `409` (**D7**), y **no queda ningún `GL_Journal` creado** |
| 4 | Alta con línea que tiene Dr **y** Cr distintos de cero | `409` |
| 5 | Alta sin líneas | `409` |
| 6 | Alta con `dateacct` en período cerrado (p.ej. `2023-06-01`) | `409` |
| 7 | Alta sin `c_elementvalue_id` ni `c_validcombination_id` | `409` |
| 8 | Alta **sin `c_conversiontype_id`** (§3.5) | `409` |
| 9 | `PUT /journals/{id}/process?action=VO` sobre el creado | `200`, queda anulado |
| 10 | `PUT /journals/{id}/process?action=RC` | `409` — fuera de alcance, documentado en §3.4 |
| 11 | `GET/PUT/DELETE` sobre id inexistente | `404` |
| 12 | Cualquier operación con token inválido | `403` |
| 13 | `DELETE` sobre un asiento de otro `AD_Client_ID` | error de autorización |
| 14 | Asiento de **>100 líneas**, luego `GET /journals/{id}` | vuelven **todas** las líneas (§4.3) |
| 15 | `GET /elementvalues?filter=value LIKE '4%'` (fase 2) | `200` + lista no vacía |

**Cómo asertar los errores:** por status + substring del mensaje real, nunca por el literal `@Xxx@` — ver
§4.3. Y ojo con el caso 13: `ClientOrgAuth` valida **solo compañía, no organización** (`ClientOrgAuth.java`),
así que no tiene sentido un caso equivalente con otra org.

Ojo para cuando se escriban: `./gradlew build` los corre y **falla sin una BD Libertya QA alcanzable y
pre-cargada** — no son tests unitarios.

---

## 9. Criterios de aceptación

Verificados **a mano contra la instancia de pruebas** (los tests automatizados vienen después, §8).

- [ ] Se puede publicar un asiento de N líneas en una sola llamada y recibir el `GL_Journal_ID`.
- [ ] Un asiento inválido (sin líneas, período cerrado, cuenta faltante, sin `c_conversiontype_id`,
      con Debe y Haber a la vez en la misma línea) devuelve **409 con un mensaje entendible**, no 200, y
      **no deja registros a medias** en la base.
- [ ] Con `?validatebalance=true` un asiento descuadrado se rechaza; sin el parámetro se comporta como el ERP
      (**D7**).
- [ ] Se puede recuperar el asiento completo (cabecera + líneas) por id, **sin truncar en 100 líneas**.
- [ ] Se puede anular un asiento ya completado vía `/process?action=VO`, y la descripción del endpoint aclara
      que **anular no es revertir** (§3.4).
- [ ] Se pueden resolver códigos de cuenta contra `elementvalues` sin hardcodear IDs.
- [ ] Se puede verificar que un período está abierto antes de mandar el asiento.
- [ ] El contrato documenta el mecanismo de idempotencia (**D4**) y que **el `200` no implica que el asiento
      esté posteado** (§12.3).
- [ ] `./gradlew build` sigue pasando (no se rompió nada de lo existente).

---

## 10. Cuestiones abiertas

### CA-1 — ¿Cómo identifica la línea a qué cuenta imputa? — **RESUELTA: opción A** (2026-08-10)

> ✅ **Decisión: opción A.** La línea identifica la cuenta con `c_elementvalue_id` y acepta opcionalmente un
> `c_validcombination_id` ya armado. Criterio: **paridad con `lyws`**, que es el antecedente que el cliente
> ya usó dos años en producción. Confirmado contra la instancia productiva de referencia — §12.5.
>
> Se deja el análisis completo porque documenta por qué la alternativa era razonable y qué habría costado.

Cambia el contrato de `GL_JournalLine`, por eso se cerró antes de generar los schemas.

Recordatorio de cómo funciona el modelo: una línea de asiento no apunta a una cuenta, apunta a una
**combinación contable** (`C_ValidCombination`) = cuenta + dimensiones opcionales (organización, producto,
entidad comercial, proyecto, campaña). La cuenta sola (`C_ElementValue`) es el plan de cuentas.

**Las dos posturas:**

| | Contrato | Consecuencias |
|---|---|---|
| **A. Los dos campos, al menos uno obligatorio** (lo que está escrito hoy en **D1**/**D2**) | La línea acepta `c_elementvalue_id` y/o `c_validcombination_id` | Cero código propio: `MJournalLine.beforeSave` ya lo exige y falla con `@NoElementValue@` si no viene ninguno. El consumidor puede trabajar contra el plan de cuentas, que es lo que expone la fase 2 |
| **B. `c_validcombination_id` obligatorio** | La línea exige la combinación armada | Hay que agregar un `GET /v1.0/validcombinations` de solo lectura a la fase 2, porque hoy el consumidor **no tiene de dónde sacar ese ID** — está excluido como recurso REST (§2) |

**Argumentos para A:**

- La cuenta es lo estable y lo que tiene sentido para un humano: tiene `value` (`1.01.01.06`) y nombre, y la
  fase 2 la expone, así que un consumidor resuelve `"4.1.1" → id` por código.
- La combinación es un ID interno que **cambia por instancia** y que **puede no existir**: se crean por
  demanda, así que si nadie imputó nunca a esa cuenta no hay ninguna fila que pasar, y el consumidor queda
  bloqueado sin recurso.
- Aceptar los dos no cuesta nada y no cierra ninguna puerta.

**Argumento para B** (es real, no es simetría de cortesía): cuando el core crea la combinación sola, la crea
con **`AD_Org_ID = 0` y todas las dimensiones en cero**, y la busca contra **`as[0]` — el primer esquema
contable del client, no el `c_acctschema_id` del asiento** (`MJournalLine.beforeSave`, ver el bloque
`MAccount.get(getCtx(), getAD_Client_ID(), 0, acctSchemaID, ...)`). En una instancia con un solo esquema da
igual; en una multi-esquema puede resolver contra el equivocado. Ahí pasar la combinación explícita es lo
correcto.

> ⚠️ **Dato a tener presente en esa conversación: en `lyws` era al revés de lo que suele recordarse.** La
> **cuenta era obligatoria** y la **combinación opcional**. En `JournalDocumentHandler.journalCreate`:
> ```java
> // :201  — se lee siempre, sin chequear null: si no viene, revienta
> aJournalLine.setC_ElementValue_ID(Integer.valueOf(line.get("vc_elementvalue")));
>
> // :204  — la combinación solo si NO vino armada
> if(line.get("c_validcombination_id") == null || line.get("c_validcombination_id").equalsIgnoreCase("")) {
>     aJournalLine.setC_ValidCombination_ID(getValidCombinationIDFromLine(line));
> }
> ```
> Lo confirman los datos en la BD: las líneas de los asientos 1010471 y 1010472 (creados por `journalCreate`)
> tienen `c_elementvalue_id` cargado — 1012830 y 1012839 —, mientras que las del 1010473 ("LOTE DE PRUEBA")
> lo tienen en NULL, señal de que entraron por otro camino y no por `journalCreate`.
>
> O sea que **el precedente SOAP es la opción A**, incluso más estricta: exigía la cuenta y calculaba la
> combinación del lado del servidor.

**Resolución:** se eligió **A**, y el plan ya estaba escrito así, con lo cual no hubo nada que ajustar.

**Si en el futuro hay que darlo vuelta (pasar a B), el costo es bajo y está acotado**, porque la decisión
**no aparece en ninguna línea de Java**: los repositories son un constructor, el mapeo JSON↔columna lo hace
`AbstractRepository` por reflexión, y `JournalService.performCreate` no nombra ninguno de los dos campos.
Además el `journalline.yaml` generado es **idéntico bajo A y bajo B** (§12.5). Haría falta:

1. un guard en `performCreate` que rechace líneas sin `c_validcombination_id` (~5 líneas + `ModelException`),
2. actualizar los textos de `journals.yaml` / `journalline.yaml`,
3. nada más — el recurso `validcombinations` de solo lectura **ya se entregó en la fase 2**, justamente como
   cobertura de este escenario.

El costo real de un cambio A→B no está en la API sino **del lado del consumidor**: si ya salió a producción
mandando la cuenta, exigirle la combinación es un breaking change. B→A nunca rompe a nadie, porque A acepta
los dos.

### Cerradas

- **CA-6 — ¿Qué hace la API con un asiento descuadrado?** Resuelta: **no valida por defecto**, la validación
  es opt-in por propiedad + query param. Ver **D7**.
- **CA-9 — ¿Cuándo se arregla `RC`/`RA`/`RE` en `processEntity`?** Movida a `docs/PENDIENTES.md` (**P1**): es
  un bug del genérico que afecta a todos los documentos, no algo de asientos. No bloquea nada de este plan.
- **La imputación por dimensiones analíticas** (producto / EC / proyecto / campaña) es la **fase 3** y se hace
  cuando aparezca el primer consumidor que la necesite. Esto ya no es discusión: lo que quedó abierto de CA-1
  es solo **cómo identifica la línea la cuenta** en la fase 1, arriba.
- **CA-2 — Campo de referencia externa para idempotencia.** Resuelta: convención de prefijo en `description`
  (**D4**). La trazabilidad de cuándo y por dónde entró el asiento ya la dan `Created` y `CreatedBy` sin
  agregar nada.
- **CA-3 — ¿El `Complete` postea a `Fact_Acct` en el momento?** **No: es diferido.** Ver §12.3. Sube la
  prioridad de la fase 4.
- **CA-4 — Valores contables de la instancia.** Relevados de la QA con datos reales para poder escribir los
  tests y un ejemplo que funcione (§12.2). No hay nada que relevar por instancia de destino: **ningún
  consumidor debe hardcodear estos IDs**, para eso está la fase 2.
- **CA-5 — ¿`postingtype`?** Siempre **`A`** (Actual) por defecto. La columna queda expuesta igual, así que
  una instancia que necesite `B` (Budget) o `S` (Statistical) lo puede mandar.
- **CA-7 — ¿Está corriendo el Accounting Processor?** En una instalación normal está siempre activo. Queda
  como nota de despliegue, no como riesgo: si en alguna instancia estuviera apagado, los asientos quedarían en
  `posted='N'` hasta que se prenda.
- **CA-8 — Valores de la instancia productiva.** Sin sentido: ver CA-4.

---

## 11. Referencias

### En este repo

| Qué | Dónde |
|---|---|
| Patrón de documento a copiar | `service/InventoryService.java`, `controller/InventoryController.java`, `repository/Inventory*Repository.java` |
| Yaml a copiar | `resources/paths/inventories*.yaml`, `resources/model/inventory*.yaml` |
| Recurso de solo lectura (ejemplo) | `resources/paths/storages.yaml` |
| Genéricos CRUD / DocAction | `repository/AbstractRepository.java` |
| Mapeo de excepciones a HTTP | `controller/AbstractController.java` |
| Transacción de documento | `service/AbstractService.java` |
| Codegen | `utils/genSchema.sh`, `utils/genSchema.sql`, `utils/genClasses.sh` |
| Test de referencia | `src/test/java/org/libertya/api/InventoryIntegrationTest.java`, `CommonIntegrationTests.java` |
| Arquitectura general | `CLAUDE.md` |

### Fuera de este repo

| Qué | Dónde |
|---|---|
| Modelo y reglas del core | `/home/julian/libertya/git/libertya/base/src/org/openXpertya/model/MJournal.java`, `MJournalLine.java`, `X_GL_Journal*.java`, `MAccount.java` |
| Antecedente SOAP | `/home/julian/libertya/git/lyws/src/org/libertya/ws/handler/JournalDocumentHandler.java` |
| Proyecto SoapUI del WS de Cintolo | `/home/julian/libertya/CintoloWS-soapui-project.xml` |
| Relevamiento de los 9 puntos de integración | `/home/julian/libertya/git/cintolo-mrp/docs/analisis-api-libertya/Analisis_API_REST_Libertya_Cintolo.md` |
| Smoke test del punto 8 | `/home/julian/libertya/git/cintolo-mrp/tools/validacion-api-libertya/validaciones/punto_08_contabilidad.py` |

---

## 12. Verificación contra código y BD (2026-08-07)

Todo lo de esta sección está comprobado contra el código del core, los genéricos de este repo y la base
`libertya_qa` (localhost). Las secciones 1-11 ya incorporan las correcciones; esto es la evidencia.

### 12.1 Correcciones aplicadas al plan original

| # | Qué decía el plan | Qué se verificó | Dónde quedó |
|---|---|---|---|
| 1 | El cliente manda cuenta, fechas y montos | Falta `C_ConversionType_ID` (cabecera y línea): NOT NULL sin default en BD, sin default en diccionario, sin valor en el constructor del modelo. El ejemplo original no habría funcionado. | §3.5, §4.2 |
| 2 | `/process` acepta `CO VO RC RA RE CL` | Solo `CO`, `VO`, `CL` sobreviven a `processEntity`; `RC`/`RA`/`RE` dan 409 y **rollback**. lyws tampoco las implementó nunca. | §3.4, §4.1 |
| 3 | D3: "sobrescribir `shouldComplete()` con un flag por invocación" | Los services son singletons → *data race*. Va overload de `create(...)`. | D3 |
| 4 | Test: desbalanceado → 409 `@UnbalancedJornal@` | `usesuspensebalancing='Y'` → el core lo **acepta** y lo postea contra la cuenta puente. | §3.1, D7, §8 |
| 5 | Precondición: período abierto para `TEST_DATE` | `TEST_DATE` (2023-06) está **cerrado** para GLJ en la QA. | §8 |
| 6 | `DELETE` → 200 | `deleteAction` devuelve **204**. | §4.1 |
| 7 | "El mensaje del core viaja como texto plano" | Pasa por `Msg.parseTranslation` y por el wrapper `"Error creando documento: "`. | §4.3 |
| 8 | `performRetrieve` calcado de `InventoryService` | Trunca en 100 líneas por el `DEFAULT_LIMIT`. | §4.3, §6.1.6 |
| 9 | IDs de ejemplo | Eran inventados (`c_acctschema_id: 1000000` no existe). Reemplazados por los reales. | §4.2, §12.2 |

**Verificado y correcto, no tocar:** §3.1 y §3.2 (validaciones del core, exactas); §3.3 y por lo tanto **D2**;
el autocompletado de `C_Period_ID`; que los defaults del constructor sobreviven al mapeo genérico; que
`DocumentNo` se autonumera; que las clases están en `OXP.jar` y `M_Table.getClass("GL_Journal")` resuelve a
`MJournal` (implementa `DocAction`, el cast de `processEntity` no rompe); el 4º parámetro de `generateSchema`;
que `@NotNull` es inerte; y que el *"recargar el journal"* de lyws no aplica acá.

Dos detalles menores: `C_ElementValue_ID` es `ismandatory='N'` en `GL_JournalLine`, así que **listarlo en el
filtro de `genSchema` no es opcional sino imprescindible** — el plan ya lo tenía bien. Y `genSchema.sh`
apunta a `libertya_rel_22ar_for_api`, que no existe en este equipo; la base disponible es `libertya_qa`.

### 12.2 Valores reales de la instancia QA (cierra CA-4 y CA-5)

Tomados de los tres asientos que el WS SOAP creó y completó el 2024-01-10: `GL_Journal` 1010471, 1010472 y
1010473. **No son inferencias: es el payload que efectivamente funcionó.**

| Campo | Valor | Nota |
|---|---|---|
| `AD_Client_ID` / `AD_Org_ID` | 1010016 / 1010053 | los mismos de `CommonIntegrationTests` |
| `C_DocType_ID` | **1010506** ("Asiento") | no tiene `docnosequence_id`; los `DocumentNo` salieron 1000000/1000001/1000002 de la secuencia de tabla. Funciona. Alternativa con secuencia propia: 1010503 "Diario del Mayor". |
| `C_AcctSchema_ID` | **1010016** | moneda 118 |
| `C_Currency_ID` | **118** (ARS) | ⚠️ `CommonIntegrationTests.DEFAULT_CURRENCY_ID` es 102 (EUR, de otra compañía) — no copiarlo |
| `GL_Category_ID` | **1010098** ("Standard", `isdefault='Y'`) | está 1010100 "Manual" si se quiere separar los asientos del MRP |
| `C_ConversionType_ID` | **114** | único activo en la base (`S` / Directa) |
| `PostingType` | **`A`** | cierra CA-5 |
| `DateAcct` | 2024-01-10 | dentro de `ene-24` (1010514), abierto para GLJ |

Períodos abiertos para `GLJ` en la compañía 1010016: **solo** `ene-24` (1010514) y `ENE-DIC 2025` (1010568).
Ojo que sobre enero-2024 hay **dos períodos solapados** de calendarios distintos (1010514 abierto, 1010536
cerrado); 2025 tiene uno solo y es menos ambiguo.

Cuentas usadas por esos asientos, si sirven para los tests: `C_ElementValue_ID` 1012830 y 1012839.

### 12.3 El posteo a `Fact_Acct` es diferido (cierra CA-3)

`MJournal.completeIt` (`MJournal.java:618-654`) **no postea nada**: aprueba, marca `Processed`, setea
`DocAction=Close` y devuelve. El posteo lo hace el Accounting Processor por su cuenta. Los timestamps de los
asientos reales lo confirman:

| Asiento | Completado (`updated`) | Primer `Fact_Acct` | Delta |
|---|---|---|---|
| 1010472 | 12:53:04 | 12:53:18 | 14 s |
| 1010473 | 12:56:30 | 12:56:34 | 4 s |
| 1010471 | 12:51:16 | 13:03:13 | **12 min** |

Si el posteo fuera sincrónico, el `Fact_Acct` tendría el timestamp de la misma transacción.

**Consecuencias:** el `200` del `POST` no garantiza que el asiento esté contabilizado — hay que documentarlo
en el contrato — y la **fase 4 sube de prioridad**, porque es la única forma de que un consumidor confirme que
su asiento llegó a `Fact_Acct`.

Nota de despliegue: esta API corre standalone, sin servidor de aplicación Libertya, así que el posteo depende
del Accounting Processor del ERP. En una instalación normal está siempre activo; si alguna instancia lo
tuviera apagado, los asientos quedarían en `posted='N'` hasta que se prenda.

### 12.4 Prueba del suspense balancing

`c_acctschema_gl.usesuspensebalancing = 'Y'` en los tres esquemas de la QA (1000005, 1000008, 1010016).

El asiento **1010471** tiene `totaldr=500` / `totalcr=0` — descuadrado — y quedó `docstatus='CO'`,
`posted='Y'`, con dos `Fact_Acct`:

| Cuenta | Debe | Haber |
|---|---|---|
| `1.01.01.06 DIFERENCIAS DE CAJA` | 500.00 | 0.00 |
| `1.01.01.03 CUENTA PUENTE DE COMPROBACION` | 0.00 | 500.00 |

`MJournal.prepareIt` solo emite `@UnbalancedJornal@` si `!gl.isUseSuspenseBalancing()`
(`MJournal.java:564-572`). De ahí sale **D7**.

---

## 12.5 Verificación contra la instancia productiva de referencia (2026-08-10) — cierra CA-1

`libertya_qa` **no** es la base donde se probó `lyws`. La verificación se repitió contra la instancia
productiva del cliente donde sí se hicieron esas pruebas (`libertya_prod`, PostgreSQL 12.13), **solo con
SELECTs**. Es la base de Cintolo: `c_acctschema` tiene ahí una columna `cintolo_onlineaccounting`.

### La tanda de pruebas del WS

21 asientos de enero 2024, cliente 1010016, org 1010053, usuario `AdminLibertya`, con descripciones
`"Asiento de prueba Web Service"`, `"Asiento de Prueba"` y `"Prueba 2"` — coinciden con los commits de `lyws`
de 2023-11. IDs `1010614`–`1010650`, todos con `c_doctype_id=1010506`, `gl_category_id=1010098`,
`c_conversiontype_id=114`, `postingtype='A'`, `c_period_id=1010632`.

### El dato que cierra CA-1

Las **62 líneas** de esos asientos tienen **todas** `c_elementvalue_id` cargado, y sus combinaciones son:

```
account_id = c_elementvalue_id | ad_org_id = 0 | m_product_id, c_bpartner_id, c_project_id,
c_campaign_id, c_activity_id, c_salesregion_id, ad_orgtrx_id = NULL | c_acctschema_id = 1010016
```

La correlación inversa también se cumple: las **únicas 6 líneas de toda la base sin `c_elementvalue_id`** son
de asientos cargados por la UI (`1000247` "LOTE OCTUBRE" de 2008, `1010555` "Asiento contable 1" de 2023-05,
`1010655` "devengamiento de impuestos" de 2024-02). O sea: **WS → cuenta cargada; UI → solo combinación.**

**Sin combinaciones duplicadas** para cuentas reales: el único grupo duplicado en `c_validcombination` es
`account_id=0` (33 filas de 2010-01-06 creadas por `Supervisor`, **no referenciadas por ninguna línea de
asiento**). La lógica buscar-o-crear no generó basura.

**Consecuencia:** el resultado de la fase 1 —mandar solo `c_elementvalue_id` y dejar que
`MJournalLine.beforeSave` resuelva la combinación— es **idéntico fila por fila** a lo que dejó el WS SOAP en
producción. La paridad con `lyws` no requiere la fase 3.

### Premisas del plan revalidadas en prod

- `c_acctschema_gl.usesuspensebalancing='Y'` en los tres esquemas → **D7 sigue en pie**.
- El cliente 1010016 tiene **un solo esquema contable** (los otros dos son de otros clients, y
  `getClientAcctSchema` filtra por client) → el argumento del `as[0]` a favor de la opción B **no aplica** en
  la instancia de referencia.
- `c_conversiontype_id` NOT NULL sin default en cabecera y línea → confirmado; todas las filas llevan `114`.
- `gl_journal.description` NOT NULL → confirmado.

### Tres hallazgos nuevos

**1. 11 de los 21 asientos del WS son cabeceras huérfanas.** `1010614`–`1010619` y `1010624`–`1010629`:
`docstatus='DR'`, **0 líneas**, `totaldr`/`totalcr` en 0. El flujo SOAP commiteaba la cabecera y después
fallaba en las líneas, dejando basura en la base. La decisión de crear cabecera + líneas bajo una sola `Trx`
con rollback (§6.1.6, §7 "qué no copiar" #2) **evita exactamente esto**, y ahora está justificada con datos.

**2. En el diccionario la obligatoriedad está al revés del contrato.**

| Columna | `ad_column.ismandatory` | BD |
|---|---|---|
| `GL_JournalLine.C_ValidCombination_ID` | `Y` | NOT NULL |
| `GL_JournalLine.C_ElementValue_ID` | `N` | nullable |

No rompe la opción A: `MJournalLine.beforeSave` (`:372-391`) completa la combinación **antes** del INSERT, y
las filas de prod lo prueban de punta a punta. Pero tiene dos consecuencias concretas:

- `c_elementvalue_id` **tiene que ir en la lista explícita de columnas** del `generateSchema`, si no el campo
  directamente no existe en el schema (`genSchema.sql:26` filtra por `ismandatory='Y'`).
- `c_validcombination_id` cae en el bloque `required:` generado (`genSchema.sql:54`). **No es un problema de
  runtime** —el proyecto no tiene Bean Validation, ver §6.1.4— y es el mismo ruido que ya arrastra el resto de
  la API: `inventoryline.yaml` lista `m_inventoryline_id`, `created` y `updated` como `required`. Se deja como
  está por consistencia con el codegen, y **se aclara en la descripción del endpoint** porque es justo el
  campo del que trata CA-1.

  Corolario útil: el `journalline.yaml` generado es **idéntico bajo la opción A y bajo la B**. Dar vuelta la
  decisión no obliga a regenerar nada.

**3. `gl_journal.c_currency_id` es nullable**, y la mayoría de las cabeceras del WS lo dejaron en NULL y
completaron igual. En la línea, en cambio, `c_currency_id` **sí** es NOT NULL.

> ⚠️ **Pero conviene mandarlo igual, y esto salió de la prueba real (§12.6):** si la cabecera queda con
> `c_currency_id` NULL, la reversión (`RC`) falla con un error de foreign key —`Key (c_currency_id)=(0) is not
> present in table "c_currency"`— porque el asiento de reversión copia la cabecera y el NULL se convierte en 0.
> El ejemplo de §4.2 lo manda, y la guía de uso lo recomienda explícitamente.

---

## 12.6 Prueba de humo de la implementación (2026-08-10)

La API se levantó contra `libertya_qa` y se ejercitó el flujo completo con `curl`. Resultado: **el asiento que
produce la fase 1 es igual, columna por columna, al que dejó el WS SOAP en producción.**

Asiento `1010542`, creado con `POST /v1.0/journals?complete=false&validatebalance=true` mandando en cada línea
solo `c_elementvalue_id`, `c_currency_id`, `c_conversiontype_id` y los importes:

| | line | ad_org_id | dateacct | c_elementvalue_id | c_validcombination_id | vc.account_id | vc.ad_org_id | dimensiones |
|---|---|---|---|---|---|---|---|---|
| | 10 | 1010053 | 2024-01-10 | 1012825 | 1034424 | 1012825 | 0 | todas NULL |
| | 20 | 1010053 | 2024-01-10 | 1012826 | 1034428 | 1012826 | 0 | todas NULL |

Lo que resolvió el modelo sin que el cliente lo mandara: `c_validcombination_id`, `ad_org_id` y `dateacct` de
las líneas (heredados de la cabecera por el service), `line` (10, 20), `c_period_id` (1010536),
`totaldr`/`totalcr` (1500.50 cada uno), `amtacctdr`/`amtacctcr`, `currencyrate` (1.0) y `documentno` (1000003).

Verificado además:

| Prueba | Resultado |
|---|---|
| `GET /v1.0/journals/{id}` | devuelve cabecera + las 2 líneas |
| `POST ...?validatebalance=true` con Debe≠Haber | **409** con el detalle de la diferencia, sin insertar nada |
| `PUT /{id}/process?action=CO` | **200**, `docstatus='CO'`, `posted='N'` — confirma que el posteo es diferido (§12.3) |
| `PUT /{id}/process?action=RC` | **409** (fuera de alcance, §3.4) |
| `POST` + `DELETE` de un borrador | **204**, el asiento desaparece de la base |
| `GET` de los 5 maestros | OK, con `referencedvalues` resueltos por el genérico |

> Nota de despliegue para correr el jar a mano: además de `JasperReports-ngroovy.jar` hay que sumar al
> `-Dloader.path` los jars de `/ServidorOXP/lib/` que el fat-jar no incluye —`postgresql.jar`, `ojdbc14.jar`
> (`DB.getConnectionRW` referencia `oracle.jdbc.OracleConnection` aunque no se use Oracle),
> `javax.mail1.5.6.jar` y `activation.jar` (los usa la generación del token)—. `./gradlew bootRun` no
> funciona por lo mismo.
