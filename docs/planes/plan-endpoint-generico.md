# Plan de implementación — Endpoint genérico por tabla (`/v1.0/generic/{table}`)

**Estado:** implementado el 2026-09-29 (sin commitear). Los desvíos respecto de este plan y la verificación
están en la **§12**, incluido el smoke con una customización real (§9.2).
**Fecha:** 2026-09-29
**Alcance:** funcionalidad **genérica de la API**, para cualquier instancia Libertya, con o sin customizaciones.
**Verificado** contra el código de este repo, el código del core (`/home/julian/libertya/git/libertya`), el
`PropertiesLauncher` del jar armado y las bases locales `libertya_rel_22ar_for_api_25` y `ly_core_teh`. La
evidencia está en la §3 y la §9.

---

## 0. Cómo usar este documento

Es autocontenido: el problema, las decisiones ya tomadas (y las descartadas, con su porqué), por qué funciona
contra el core, el contrato, el plan paso a paso con los archivos a tocar, y cómo verificarlo.

### Si estás retomando esto en una sesión nueva

1. Leé la **§2 (decisiones tomadas)** antes que nada. Varias cosas que parecen "faltantes" —seguridad por
   tabla, roles, un POST único con la acción en el body, atomicidad entre llamadas— **se descartaron a
   propósito**. No las reabras sin consultarlo.
2. La **§3** explica por qué el core ya resuelve la clase de una tabla custom sin que lyrestapi la conozca.
   Es la base de todo el diseño.
3. La **§5** es el contrato y la **§7** el plan ejecutable.
4. La **§9** tiene los casos de prueba concretos, incluidos una tabla custom real y una tabla de plugin cuyas
   clases **no** están en el jar.

### Antes de codear, ojo con estas

| | Qué |
|---|---|
| 1 | **Nunca correr `utils/genClasses.sh` tal cual**: vacía los `model/*.yaml` y pisa stubs de otras entidades. Correr solo el bloque de swagger-codegen hacia un directorio temporal y copiar únicamente los archivos nuevos (§7.1) |
| 2 | Los repositories son **singletons de Spring**. `AbstractRepository` guarda `tableName` y `pkColumns` como campos: el genérico **no puede** asignarlos por request (data race, mismo problema que documenta `AbstractService.java:32-34`). Todo tiene que viajar por parámetro |
| 3 | `SchemaUtils.getColumnResolver` cachea **por el nombre de tabla recibido** y hace NPE si la tabla no existe (`SchemaUtils.java:47-52`). Validar y canonicalizar el nombre **antes** de tocarlo (§6 D2) |
| 4 | `processEntity` solo puede ejecutar `CO`, `VO` y `CL`: `RC`/`RA`/`RE` fallan con 409 + rollback (`docs/PENDIENTES.md` P1). El genérico lo hereda |
| 5 | Los tests de integración autentican **solo** contra `libertya_rel_22ar_for_api_25` (`DB_NAME=...`). En smoke tests manuales con el fat jar, **una operación de modelo por arranque**: el pool de conexiones se agota a las ~4 operaciones |
| 6 | Si se agrega alguna propiedad nueva, **con default en línea** en el `@Value` (ver CLAUDE.md). El plan no requiere ninguna |

---

## 1. Problema y objetivo

Libertya tiene customizaciones por cliente, privadas, que agregan tablas, modelos (`M<Tabla>`) y lógica de
documento (`DocAction`). Hoy, para exponer una entidad por API hay que escribir en este repo su yaml, su stub,
su repository y su controller. Para una entidad custom eso significa **meter código de un cliente en un
proyecto genérico**, que es justo lo que se quiere evitar.

**Objetivo:** un único conjunto de endpoints que opere sobre **cualquier tabla** de `AD_Table` indicada por
nombre en la URL, delegando toda la lógica de negocio al modelo que el core resuelva para esa tabla. Tiene que
cubrir tanto maestros (CRUD) como documentos (CRUD + procesar para cambiar el estado).

---

## 2. Decisiones tomadas (2026-09-29)

| # | Decisión | Por qué |
|---|---|---|
| DT-1 | **URLs de recurso por tabla** (`GET/POST/PUT/DELETE /v1.0/generic/{table}[/{id}]` + `PUT .../{id}/process`). **No** un POST único con acción/tabla/datos en el body | Cada operación reutiliza tal cual los helpers de `AbstractController`: mapeo de errores, paginación (`X-Total-Count`, headers `prev`/`next` armados desde la URL), log de `EventLogAspect` y validación de parámetros por swagger. Con un POST único habría que rehacer todo eso dentro de un sobre de respuesta común, y validar a mano qué campos aplican a cada acción. Además, el contrato queda igual al del resto de la API |
| DT-2 | **Sin endpoint de lote (batch) en esta etapa** | Con las operaciones sueltas un documento se puede crear, recibir líneas y completarse. Lo único que agrega el lote es **atomicidad entre llamadas**. Queda como fase futura, solo si aparece un documento custom que la necesite (§10) |
| DT-3 | **Seguridad por tabla fuera de alcance** (whitelist, columnas protegidas) | Decisión de producto de esta etapa. Aplican los mismos controles que el resto de la API: JWT, `ClientOrgAuth` (compañía) y `filterByClient` en los listados. **Consecuencia conocida y aceptada:** el endpoint permite operar sobre cualquier tabla, incluidas las `AD_*` |
| DT-4 | **Roles fuera de alcance** (`MRole`) | Igual que DT-3 |
| DT-5 | **Las clases custom llegan por el OXP.jar de la instancia**, vía `loader.path` en el arranque. **No** hay código custom en este repo | Las customizaciones viven dentro del OXP.jar de cada instancia. Detalle y cuidados en la §4 |

---

## 3. Por qué funciona: el core ya resuelve la clase de modelo en runtime

`AbstractRepository` **nunca usa la clase concreta del modelo**. Todo pasa por nombre de tabla y metadata:

- Obtiene el PO con `M_Table.get(ctx, tableName).getPO(...)` (`AbstractRepository.java:85`, `:859`).
- Setea valores por nombre de columna, guiado por `M_Column` (`loadValueToPO`, `:722`; `setValue`, `:747`).
- Procesa casteando a `DocAction` y llamando a `DocumentEngine.processAndSave` (`processEntity`, `:928`).
- Ya existe una vía dinámica, `additionalvalues`, que escribe columnas arbitrarias sin DTO (`:703-709`).

Lo único atado a cada entidad es el **DTO tipado** que genera swagger (`iface = Invoice::new`). El genérico lo
reemplaza por un `Map<String,Object>`.

Del lado del core (`libertya/base/src/org/openXpertya/model/M_Table.java`):

- **`getClass(tableName)` (`:288`)** busca primero el componente dueño de la tabla con `getTableOwnerPackage`
  (`:889`): `AD_Table → AD_ComponentVersion → AD_Component.packagename`, si `corelevel != 0`. Después prueba
  `<package>.model.M<Clase>` y `<package>.model.LP_<Tabla>`, y como último recurso `X_<Tabla>` en
  `openXpertya.model` y `org.openXpertya.model`. Si no encuentra ninguna, devuelve `null`.
- **No existe `GenericPO`** (a diferencia de ADempiere). Si la clase no está en el classpath, `getPO` devuelve
  `null`: **la tabla no se puede operar**. Por eso DT-5 es condición necesaria.
- **`get(ctx, tableName)` (`:180`)** busca con `UPPER(TableName)=?`, o sea que no distingue mayúsculas.
- **`getKeyColumnsAsArray()` (`:520`)** devuelve la columna `IsKey`, o si no hay, las `IsParent` (PK compuesta).
- Los **plugins sobre tablas existentes** (`MPluginPO`, `MPluginDocAction`) se descubren desde `AD_Plugin` y
  corren dentro de `PO.save()` (`PO.java:1824`, `:1895`) y del `DocumentEngine`. La lógica custom de un
  `beforeSave` o un `completeIt` corre sin que lyrestapi sepa que existe.

**Verificado con una customización real** (`ly_core_teh` + `/OXP-teh/OXP.jar`, 2026-09-29):

| Tabla | Componente | Clase resuelta | Tipo |
|---|---|---|---|
| `C_HTE_BPartner_Org_Config` | `com.hipertehuelche.erp` | `com.hipertehuelche.erp.model.MHTEBPartnerOrgConfig` | maestro |
| `C_CreditDebitAllocation` | `com.hipertehuelche.erp` | `com.hipertehuelche.erp.model.MCreditDebitAllocation` — `implements DocAction` | documento |

---

## 4. Despliegue: el OXP.jar de la instancia

### Qué se configura (y dónde **no**)

**No se configura en `application.properties`**: Spring lo lee *después* de que la JVM armó el classpath, así
que es tarde para cambiarlo. Se usa el mismo mecanismo que ya se usa para JasperReports: `loader.path` del
`PropertiesLauncher`, que se pasa como `-Dloader.path=...`, como variable de entorno `LOADER_PATH` o en un
`loader.properties`. La propiedad de sistema tiene prioridad sobre la variable de entorno.

```bash
java -Dloader.path=/ruta/instancia/lib/OXP.jar,/lyrestapi/JasperReports-ngroovy.jar \
     -jar lyrestapi-1.0.0.jar \
     --spring.config.location=file:/lyrestapi/application.properties
```

**Orden verificado** (desensamblando `PropertiesLauncher$ClassPathArchives` del jar armado, Spring Boot 2.7):
primero agrega lo de `loader.path` y después lo embebido en `BOOT-INF/lib` (`addNestedEntries`). Las clases del
OXP.jar de la instancia **ganan** sobre las del embebido.

### Cuidados

1. **Quedan dos cores en el classpath.** El `build.gradle` embebe el OXP.jar de `$OXP_HOME` con
   `implementation`. Si a la instancia le falta una clase que el embebido sí tiene, se toma del embebido sin
   aviso y el core queda mezclado. Para diagnosticarlo, el paso 7.6 loguea al arrancar de qué jar se cargó el
   core. La solución prolija, fuera de este alcance, sería un build con OXP.jar como `compileOnly` (como
   JasperReports); cambia el empaquetado de **todos** los despliegues, así que es otra decisión.
2. **Solo OXP.jar, no OXPXLib.jar.** OXPXLib son dependencias de terceros, no customizaciones. Uno que traiga
   `org/slf4j/impl` choca con Logback y la app no arranca. El embebido está verificado; no reemplazarlo.
3. **La compatibilidad binaria no se verifica al compilar.** lyrestapi se compila contra el OXP.jar de
   `$OXP_HOME`. Si el de la instancia es de otra versión y cambió la firma de algo que lyrestapi usa, salta un
   `NoSuchMethodError` recién al ejecutar ese camino.
4. **El jar y la base tienen que ser de la misma instancia**: el OXP.jar de una customización espera su
   diccionario y sus `AD_Plugin`.
5. **Docker:** el `ENTRYPOINT` actual fija `-Dloader.path=/JasperReports-ngroovy.jar`, que tiene prioridad
   sobre `LOADER_PATH`. Para sumar el OXP.jar de la instancia hay que sobreescribir el entrypoint o cambiar el
   `Dockerfile`. Es configuración de despliegue, no parte de la implementación: consultarlo antes.

---

## 5. Contrato de API

### 5.1 Endpoints

`{table}` es el `TableName` de `AD_Table`, sin distinguir mayúsculas (`C_Campaign` = `c_campaign`). `{id}` es el
valor de la PK simple (`<Tabla>_ID`).

| Método | Ruta | Qué hace | Respuesta OK |
|---|---|---|---|
| `GET` | `/v1.0/generic/{table}` | Listado. Query: `filter`, `fields`, `sort`, `limit`, `page`, `includeTotal` | `200` array de objetos + headers `prev`/`next` (y `X-Total-Count` si `includeTotal=true`) |
| `GET` | `/v1.0/generic/{table}/{id}` | Detalle. Query: `fields` | `200` objeto |
| `POST` | `/v1.0/generic/{table}` | Alta. **No** completa documentos (D8) | `200` `text/plain` con el id |
| `PUT` | `/v1.0/generic/{table}/{id}` | Modificación parcial: solo las claves enviadas | `200` vacío |
| `DELETE` | `/v1.0/generic/{table}/{id}` | Baja | `204` |
| `PUT` | `/v1.0/generic/{table}/{id}/process?action=CO` | Procesa un documento. Acciones: `CO`, `VO`, `CL` (P1) | `200` `text/plain` con el mensaje del proceso |

**Errores**, con el mismo mapeo que el resto de la API:

| Código | Cuándo |
|---|---|
| `404` | La tabla no existe en `AD_Table`, o el registro no existe |
| `409` | Error de modelo (`ModelException`): el `save()`/`processIt()` falló, la tabla existe pero no hay clase de modelo (D9), no es documento y se pidió `process` (D7), es una vista y se pidió una escritura (D6), la PK es compuesta (D5), o hay una clave del body que no es columna (D4) |
| `401` | Token inválido, o el registro es de otra compañía (`ClientOrgAuth`) |

### 5.2 Formato de los datos

- **Body y respuesta:** un objeto JSON **plano**, una clave por columna.
- **Claves de salida:** nombre exacto de columna en minúscula (`c_bpartner_id`, `dateacct`), igual que los DTO
  tipados.
- **Claves de entrada:** se aceptan el nombre exacto en minúscula y la forma legacy normalizada
  (`cbpartnerid`), porque se resuelven con el `ColumnResolver` existente.
- **Tipos de salida:** los mismos que los DTO. Enteros y montos como número, `YesNo` como `true`/`false`, y
  fechas como el `toString()` del `Timestamp` (`"2024-01-10 00:00:00.0"`).
- **Tipos de entrada:** fechas como hoy lo acepta `convertValue` (`yyyy-MM-dd`, `yyyy-MM-dd HH:mm`, timestamp
  completo); `YesNo` como `true`/`false`.
- **Poner una columna en null en un `PUT`:** el valor configurado en `restapi.libertya.app.nullValue` (por
  defecto `"[NULL]"`), igual que el resto de la API.
- **Valores referenciados:** si `#USE_REFERENCED_VALUES=Y`, la respuesta incluye `referencedvalues:
  [{"key": "c_bpartner_id__value", "value": "..."}]`, con la misma forma que los DTO.
- **No hay `additionalvalues`:** todas las columnas ya van como claves.
- Se omiten las columnas `Binary` e `Image` (`shouldSkipColumn`, `AbstractRepository.java:579`).

### 5.3 Ejemplos

Maestro, con una tabla del core que hoy no tiene endpoint (ilustrativo; las columnas obligatorias las define
el diccionario de cada instancia):

```http
POST /v1.0/generic/C_Campaign
{"value": "CAMP-01", "name": "Campaña de prueba"}

→ 200  1010234
```

```http
GET /v1.0/generic/C_Campaign/1010234?fields=value,name,isactive

→ 200  {"value": "CAMP-01", "name": "Campaña de prueba", "isactive": true}
```

Documento, como flujo de varias llamadas. `GL_Journal` es el mejor candidato porque sus reglas ya están
documentadas; las columnas obligatorias están en `docs/planes/plan-asientos-manuales.md` §3.5:

```http
POST /v1.0/generic/GL_Journal          {"description": "...", "c_conversiontype_id": ..., "dateacct": "2024-01-10", ...}
→ 200  1012345

POST /v1.0/generic/GL_JournalLine      {"gl_journal_id": 1012345, "ad_org_id": ..., "dateacct": "2024-01-10", "c_elementvalue_id": ..., "amtsourcedr": 100, ...}
POST /v1.0/generic/GL_JournalLine      {"gl_journal_id": 1012345, "ad_org_id": ..., "dateacct": "2024-01-10", "c_elementvalue_id": ..., "amtsourcecr": 100, ...}

PUT  /v1.0/generic/GL_Journal/1012345/process?action=CO
→ 200  <mensaje del proceso>
```

**Cada llamada es su propia transacción (DT-2).** Si falla la segunda línea, la cabecera y la primera línea
quedan en borrador: el consumidor corrige y reintenta, o borra. Hay que decirlo en la guía de uso (§7.7).

**El genérico no hereda la lógica de los services.** Lo que un `XxxService` hace además del modelo, como
copiar `ad_org_id`/`dateacct` de la cabecera a las líneas en `JournalService`, no pasa acá. El consumidor
manda esos valores, o los resuelve el `beforeSave` del modelo si lo hace.

---

## 6. Decisiones de diseño

**D1 — Ruta `/v1.0/generic/...`.** `/v1.0/tables` ya existe (es `AD_Table`, `TableController`), así que no se
reutiliza.

**D2 — Resolución de la tabla, siempre primero.** Antes de cualquier otra cosa:
`M_Table.get(ctx, raw)` → si es `null`, `404`. Desde ahí se usa **`table.getTableName()` (canónico)**, nunca
el nombre crudo de la URL: el `ColumnResolver` cachea por nombre, y el nombre termina concatenado en SQL
(`getAllKeys`, `countAll`). Conviene encapsularlo en una sola función que devuelva un descriptor inmutable:
`TableSpec{tableName, keyColumn, isView, isDocument}`.

**D3 — Descriptor por request, no estado en el singleton.** El `TableSpec` viaja por parámetro. No se asigna
`this.tableName` ni `this.pkColumns` (§0, fila 2). En el genérico `pkColumns` queda siempre en `null`, y así
los helpers existentes siguen el camino de PK simple (`getPO`, `getAllKeys`).

**D4 — Claves del body estrictas.** A diferencia de `additionalvalues` (que ignora en silencio lo que no
resuelve), una clave que no es columna de la tabla devuelve `409` y nombra la clave. Motivo: sin DTO no hay
nada que detecte un error de tipeo (`c_bpartnr_id`), y ignorarlo produce registros incompletos sin error.
Escribir una columna virtual también da `409`. La columna PK del body se **ignora** (el id sale del path o
lo asigna el modelo), para que un consumidor pueda devolver en un `PUT` lo que recibió en un `GET`.

**D5 — Solo PK simple en esta etapa.** Si `getKeyColumnsAsArray()` no devuelve exactamente una columna `IsKey`
(p. ej. `C_InvoiceTax`, que usa `IsParent`), `409` "PK compuesta no soportada por el endpoint genérico". Ver §10.

**D6 — Vistas solo lectura.** `AD_Table.IsView='Y'` → `GET` sí; `POST`/`PUT`/`DELETE`/`process` `409`.

**D7 — Process solo para documentos.** Si el PO no es `instanceof DocAction`, `409` "La tabla X no es un
documento". Sin este guard, `processEntity` tira `ClassCastException` y la respuesta sería un 500. Las
acciones soportadas son las de `processEntity` hoy: `CO`, `VO`, `CL` (P1).

**D8 — El alta no completa.** `AbstractService.create()` completa si `org.libertya.api.service.doc.complete=Y`,
pero ahí cabecera y líneas llegan juntas. En el genérico la cabecera llega sola: completarla al crearla
fallaría o completaría un documento vacío. Completar es siempre un `process` explícito.

**D9 — Tabla sin clase de modelo → error explícito.** Si `M_Table.getClass(tableName)` devuelve `null`, `409`
con un mensaje que diga qué pasó y qué revisar, en lugar del genérico "No se pudo crear un registro nuevo":

> No se encontró la clase de modelo para la tabla C_LYEIElectronicInvoiceConfig (componente
> org.libertya.locale.ar.electronicInvoice). Verificar que el OXP.jar de la instancia esté en loader.path.

El paquete sale de la misma consulta que usa `getTableOwnerPackage` (privada en el core; replicar la SQL).

**D10 — Sin completar ni validar "de más".** El genérico ejecuta solo la lógica del modelo (`beforeSave`,
`afterSave`, `DocAction`, plugins). La lógica que vive en **callouts** de la ventana no corre, igual que en los
endpoints tipados. Queda documentado en la guía de uso.

---

## 7. Plan de implementación

Todo lo que se toca de las clases base es **aditivo**: los endpoints existentes no cambian de comportamiento.

### 7.1 Contrato (yaml + stub)

1. `src/main/resources/model/genericrecord.yaml` → schema `GenericRecord`: `type: object`,
   `additionalProperties: true`.
2. Paths, siguiendo el formato de `paths/journallines.yaml`, con tag `generic`:
   - `paths/generic_table.yaml` — `get` (listado) y `post` (alta)
   - `paths/generic_table_id.yaml` — `get`, `put`, `delete`
   - `paths/generic_table_id_process.yaml` — `put` con `action` en query, como `invoices_id_process.yaml`
3. `$ref`s en `ly-rest-api.yaml` para `/v1.0/generic/{table}`, `/v1.0/generic/{table}/{id}` y
   `/v1.0/generic/{table}/{id}/process`.
4. Stub: correr **solo** el bloque de swagger-codegen de `utils/genClasses.sh`, con salida a un directorio
   temporal, y copiar a `stub/` **únicamente** `GenericApi.java` (y `GenericRecord.java` si se genera).
   Después, `git status` no debe mostrar ningún archivo preexistente de `stub/` modificado.
   **Verificar la firma generada:** con `additionalProperties: true`, swagger-codegen 3 suele generar
   `class GenericRecord extends HashMap<String, Object>`, que sirve tal cual. Si genera otra cosa, ajustar el
   yaml antes de seguir.

### 7.2 `AbstractRepository` — ganchos aditivos

- **Escritura desde un `Map`:** al principio de `loadPOFromEntity` (`:684`), si `source instanceof Map`,
  delegar a un nuevo `loadPOFromMap(info, aPO, map, ignoreNulls, inserting)`. Este recorre las entradas y
  llama a `loadValueToPO(info, aPO, resolver, key, value, inserting)` (`:717`), como ya hace el bloque de
  `additionalvalues`, y agrega las validaciones de D4. Ningún DTO existente es un `Map`, así que los endpoints
  tipados no cambian. Con esto `insertEntity`, `updateEntity`, `deleteEntity` y `processEntity` se reutilizan
  **sin tocarlos**, pasándoles el `tableName` canónico.
- **Conteo con tabla explícita:** `countAll(info, tableName, params)`. El actual (`:392`) usa `this.tableName`,
  así que pasa a delegar en el nuevo.
- **Lectura a `Map`:** nuevo `loadRecordFromPO(info, tableName, int id, String fields)` →
  `Optional<Map<String,Object>>`. Mismas reglas que `loadEntityFromPO` (`:510`): `getPO`, chequeo de
  `getID()==0`, `ClientOrgAuth`. Recorre `M_Table.getColumns(false)`, salteando `shouldSkipColumn`, filtra por
  `fields` con `getFilterFields` y convierte los tipos como en §5.2.
- **Valores referenciados:** extraer la consulta de `setReferencedValue` (`:232`) a un método que **devuelva**
  la lista de pares (`List<Propertiesmap>`). `setReferencedValue` lo sigue usando igual, y el genérico lo usa
  para armar `referencedvalues`.

### 7.3 `GenericRepository` (nuevo, `repository/`)

`@Repository public class GenericRepository extends AbstractRepository`, **sin** asignar `tableName`, `iface`
ni `pkColumns`:

- `TableSpec resolveTable(UserInfo info, String raw)` → implementa D2, D5, D9. Tira `NotFoundException` o
  `ModelException`.
- Métodos públicos que reciben la tabla cruda, la resuelven, aplican D6/D7 y delegan en los helpers protegidos
  con el nombre canónico:
  - `retrieve(info, table, id, fields)` → `loadRecordFromPO`
  - `retrieveAll(info, table, params)` → `retrieveAllEntities(info, spec.tableName, ids -> loadRecordFromPO(...), params)`
  - `countAll(info, table, params)`
  - `insert(info, table, map)` → `insertEntity(info, spec.tableName, map, null)`
  - `update(info, table, id, map)` → `updateEntity(info, new int[]{id}, spec.tableName, map, true)`
  - `delete(info, table, id)` → `deleteEntity(info, spec.tableName, new int[]{id})`
  - `process(info, table, id, action)` → `processEntity(info, spec.tableName, new int[]{id}, action, null)`
- **Ojo con el registro existente:** `WindowSchemaRepository` recibe `List<AbstractRepository>` e indexa por
  `getTableName()`, ignorando los `null`. El `GenericRepository` devuelve `null` ahí, así que queda afuera
  solo. Verificarlo con un test o un vistazo al arranque.

### 7.4 `AbstractController` y las interfaces de acción — aditivo

- `ActivityRetrieveInterface.perform` y `ActivityInsertInterface.perform`: agregar `NotFoundException` al
  `throws`, porque una tabla inexistente tiene que dar 404 también en alta y detalle. Agregar una excepción
  chequeada a la interfaz no rompe los lambdas existentes.
- `insertAction`: agregar el `catch (NotFoundException)` → `404`. `retrieveAction` ya atrapa `Exception` → 404.
- `retrieveAllAction`: agregar una sobrecarga que reciba dos lambdas (lista y conteo) en lugar de un
  `AbstractRepository`, con la misma lógica de headers, y que atrape `NotFoundException` → 404. La versión
  actual pasa a delegar en ella, sin cambio de comportamiento.

### 7.5 `GenericController` (nuevo, `controller/`)

`GenericController extends AbstractController implements GenericApi`. Métodos de una línea, como
`JournalLineController`:

```java
return insertAction(request, (info) -> repository.insert(info, table, body));
return retrieveAllAction(request, (info, p) -> repository.retrieveAll(info, table, p),
                                  (info, p) -> repository.countAll(info, table, p), query(filter, fields, sort, limit, page));
return processAction(request, (info) -> repository.process(info, table, id, action));
```

`EventLogAspect` lo loguea solo, porque intercepta todo `controller.*`.

### 7.6 Diagnóstico del core cargado (chico, recomendado)

En `StartupLYService.init()`, loguear una línea con el jar desde el que se cargó el core:
`M_Table.class.getProtectionDomain().getCodeSource().getLocation()`. Con dos OXP.jar en el classpath (§4,
cuidado 1), es la forma de confirmar cuál se usa sin adivinar.

### 7.7 Documentación

- `docs/referencia/endpoint-generico-api.md`: guía para **consumir** el endpoint, en el estilo de
  `docs/referencia/asientos-manuales-api.md` (escrita para que la lea una IA integradora). Debe cubrir el formato de
  claves y tipos, el flujo de documento en varias llamadas, que no hay atomicidad entre llamadas, que los
  callouts no corren, las acciones de process soportadas y los errores.
- `CLAUDE.md`: una sección corta que apunte a los dos documentos y a la §4 (despliegue con `loader.path`).

---

## 8. Criterios de aceptación

1. Con el OXP.jar embebido y `libertya_rel_22ar_for_api_25`, se puede hacer el CRUD completo de una tabla del
   core **sin endpoint propio** (`C_Campaign` o `M_Shipper`; ambas tienen clase `M` en el core y no están en
   `table-endpoints.properties`).
2. El flujo de documento `GL_Journal` → dos `GL_JournalLine` → `process?action=CO` deja el asiento en `CO`.
   No se exige paridad total con `POST /v1.0/journals`: `JournalService` completa en las líneas el `ad_org_id`
   y la `dateacct` de la cabecera cuando no vienen (`JournalService.java:105-110`), y el genérico no, porque
   no conoce la relación cabecera-línea. En el genérico las líneas tienen que traerlos explícitos.
3. Para un registro que ya tiene endpoint tipado, `GET /v1.0/generic/C_BPartner/{id}` devuelve, en las
   columnas comunes, los mismos valores que `GET /v1.0/bpartners/{id}`.
4. Con el OXP.jar de una instancia customizada en `loader.path`, el CRUD de un maestro custom y el
   alta + `CO` de un documento custom funcionan **sin ningún cambio de código** (§9.2).
5. Los casos negativos de §9.1 devuelven el código y el mensaje esperados.
6. `./gradlew test` completo (no solo los tests nuevos) pasa igual que antes del cambio.
7. `git status` en `stub/` muestra solo archivos nuevos.

---

## 9. Tests y verificación

### 9.1 Integración (`GenericIntegrationTests`, contra `libertya_rel_22ar_for_api_25`)

Siguiendo el patrón de `CommonIntegrationTests` (`TestRestTemplate`, token de `AdminLibertya`, compañía
1010016 / org 1010053):

| Caso | Esperado |
|---|---|
| CRUD de `C_Campaign` (o `M_Shipper`): alta, detalle, listado con `filter`, `PUT` parcial, baja | 200 / 200 / 200 / 200 / 204; después de la baja el detalle da 404 |
| Flujo `GL_Journal` + líneas + `CO`. Fecha **2024-01-10**, porque `TEST_DATE` cae en período cerrado para `GLJ` (`plan-asientos-manuales.md` §8, §12.2) | `docstatus = CO` |
| Paridad `C_BPartner` genérico vs. tipado | mismos valores en las columnas comunes |
| Tabla inexistente (`GET /v1.0/generic/NoExiste`) | 404 |
| Tabla de plugin **sin clase en el jar**: `C_LYEIElectronicInvoiceConfig` (componente `org.libertya.locale.ar.electronicInvoice`). Verificado el 2026-09-29: el OXP.jar embebido no tiene ninguna clase de ese paquete ni `X_` para esas tablas | 409 con el mensaje de D9 |
| `process` sobre un maestro (`C_Campaign`) | 409 "no es un documento" |
| Escritura sobre una vista (`C_Allocation_Detail_V`) | 409 |
| PK compuesta (`C_InvoiceTax`) | 409 |
| Clave inexistente en el body (`{"nmae": "x"}`) | 409 que nombra `nmae` |
| `includeTotal=true` en el listado | header `X-Total-Count` presente |

### 9.2 Smoke manual con una customización real (no automatizable hoy)

Base local `ly_core_teh` + jars de `/OXP-teh` (credenciales en la memoria del proyecto,
`bases-locales-y-tests`). Arrancar el fat jar con el OXP.jar de la customización por delante:

```bash
java -Dloader.path=/OXP-teh/OXP.jar,libs/JasperReports-ngroovy.jar \
     -jar build/libs/lyrestapi-1.0.0.jar --spring.config.location=file:/ruta/application.properties
```

1. Confirmar en el log de arranque (7.6) que el core se cargó desde `/OXP-teh/OXP.jar`.
2. **Maestro custom:** alta y detalle de `C_HTE_BPartner_Org_Config` (clase `MHTEBPartnerOrgConfig`).
3. **Documento custom:** alta de `C_CreditDebitAllocation` y `process?action=CO` (clase
   `MCreditDebitAllocation implements DocAction`).
4. Verificar cada resultado con `psql`.

**Una operación de modelo por arranque de la app:** corriendo el fat jar a mano, el pool se agota a las ~4
operaciones y después todo falla con `@NoDBConnection@` o con `null` dentro de los arrays. Levantar, hacer
*la* llamada, matar el proceso **por PID** (no con `pkill -f`) y verificar.

---

## 10. Fuera de alcance / fases futuras

| Tema | Cuándo retomarlo |
|---|---|
| **Lote transaccional** (`POST /v1.0/generic/batch`, operaciones con referencias entre sí, una sola Trx) | Cuando un documento custom necesite atomicidad (cabecera + líneas o nada). Es la versión genérica de `AbstractService.create()` |
| **Seguridad por tabla y rol** (whitelist, columnas protegidas como `DocStatus`/`Processed`/`Posted`, `MRole.isTableAccess`/`addAccessSQL`) | Antes de exponer el endpoint a integradores externos. `ColumnLookupRepository.java:197` ya usa `MRole.addAccessSQL` y sirve de referencia |
| **`RC`/`RA`/`RE` en `process`** | Es `docs/PENDIENTES.md` P1, que tiene el arreglo propuesto. Afecta a todos los documentos, no solo al genérico |
| **PK compuesta** | Cuando aparezca una tabla custom que la use. `{id}` pasaría a ser la lista de valores de las columnas `IsParent`, en el orden de `getKeyColumnsAsArray()` |
| **Endpoint de schema** (`GET /v1.0/generic/{table}/schema`: columnas, tipos, obligatoriedad, referencias desde `AD_Column`) | Cuando un consumidor necesite descubrir el contrato de una tabla custom sin mirar la base |
| **Ventanas custom** | `WindowSchemaRepository` asigna el `dataEndpoint` desde `table-endpoints.properties`. Para las tablas sin mapeo podría devolver `/v1.0/generic/{TableName}` |
| **Ejecución de `AD_Process` custom** | Pieza aparte: `ProcessInfo` + `startProcess` con parámetros validados contra `AD_Process_Para`, como hace `InvoiceService` con `LaunchInvoice` |
| **Build con OXP.jar `compileOnly`** | Si la mezcla silenciosa de dos cores (§4, cuidado 1) llega a causar un problema real |

---

## 11. Referencias

**En este repo**
- `src/main/java/org/libertya/api/repository/AbstractRepository.java` — genéricos de CRUD y process
- `src/main/java/org/libertya/api/controller/AbstractController.java` — helpers de acción y paginación
- `src/main/java/org/libertya/api/util/SchemaUtils.java` — `ColumnResolver` y su caché
- `src/main/java/org/libertya/api/controller/JournalLineController.java` — patrón de controller a seguir
- `src/main/resources/paths/journallines.yaml`, `invoices_id_process.yaml` — patrón de yaml
- `docs/PENDIENTES.md` — P1 (process), P2 (codegen)
- `docs/planes/plan-asientos-manuales.md` — reglas de `GL_Journal` usadas en los tests

**Fuera de este repo**
- `libertya/base/src/org/openXpertya/model/M_Table.java` — `get` (`:180`), `getClass` (`:288`),
  `getKeyColumnsAsArray` (`:520`), `getTableOwnerPackage` (`:889`)
- `libertya/base/src/org/openXpertya/model/PO.java` — hooks de plugins en `save()` (`:1824`, `:1895`)
- `libertya/base/src/org/openXpertya/process/DocumentEngine.java` — handlers `PluginDocAction*`

---

## 12. Implementación (2026-09-29)

### 12.1 Qué se tocó

| Archivo | Qué |
|---|---|
| `resources/model/genericrecord.yaml`, `resources/paths/generic_table*.yaml`, `ly-rest-api.yaml` | Contrato (§7.1) |
| `stub/iface/GenericApi.java`, `stub/model/GenericRecord.java` | Generados con swagger-codegen hacia un directorio temporal; se copiaron solo estos dos. `GenericRecord extends HashMap<String, Object>` y los bodies llegan como `Map<String, Object>` |
| `repository/GenericRepository.java` | Nuevo: `resolveTable` → `TableSpec` + los métodos `*Record` (nombres distintos de los heredados, para no mezclar sobrecargas con `retrieve`/`insert`/`update` de `AbstractRepository`) |
| `repository/AbstractRepository.java` | Aditivo: `loadPOFromMap`, `loadRecordFromPO`, `getReferencedValues`, `countAll`/`getAllKeys`/`retrieveAllEntities` con tabla y clave explícitas |
| `controller/GenericController.java` | Nuevo |
| `controller/AbstractController.java`, `Activity*Interface.java` | `NotFoundException` en alta y detalle; sobrecarga de `retrieveAllAction` con dos lambdas (`ActivityRetrieveAllInterface`, `ActivityCountInterface`) |
| `exception/NotFoundException.java` | Constructor con mensaje. Los 404 devuelven `e.getMessage()`, que es `null` en todos los usos previos |
| `service/StartupLYService.java` | Log de arranque con el jar desde el que se cargó el core (§7.6) |
| `test/.../GenericIntegrationTests.java` | 19 casos, solo tablas del core |
| `docs/referencia/endpoint-generico-api.md` | Guía de uso (§7.7) |

### 12.2 Desvíos respecto del plan, y por qué

1. **La clave viaja explícita, no siempre es `<Tabla>_ID`.** En las vistas no lo es (`RV_BPartner` usa
   `C_BPartner_ID`), y además **`PO.load(int)` arma el WHERE con `<Tabla>_ID` fijo** (`PO.java:1260`), así que
   `M_Table.getPO(int)` nunca encuentra esos registros. El listado pasa la clave a `getAllKeys`, y la lectura usa
   `M_Table.getPO(whereClause)`, que carga por `ResultSet` y resuelve la clave desde `POInfo` (`setKeyInfo`).
2. **D5 más estricto:** además de simple, la clave tiene que ser **numérica** (`AD_Language` es alfanumérica).
   Y las tablas cuya clave no es `<Tabla>_ID` quedan **de solo lectura**, porque `updateEntity`, `deleteEntity` y
   `processEntity` cargan por id. En el core de la base de tests es una sola: `AD_PInstance_Log` (`Log_ID`).
3. **En el `GET` de detalle, D5 y D9 salen `404`, no `409`.** `retrieveAction` mapea cualquier excepción a
   `404` con el mensaje en el body. No se cambió para no alterar los endpoints tipados. El listado y las
   escrituras sí dan `409`. Está en la guía de uso.
4. **El `404` del `GET` de detalle se declara sin `content`.** Declarado como `text/plain`, el `produces`
   generado incluye `text/plain`, y como el cliente lo pide primero Spring no encuentra conversor para el `Map`
   (`HttpMessageNotWritableException`, 500).
5. **Salida:** se omiten los `null`, igual que los DTO (`spring.jackson.default-property-inclusion=NON_NULL`).
   `referencedvalues` solo aparece si hay alguno.
6. **Entrada:** además de D4, se ignora `referencedvalues` (para reenviar un `GET`), `Y`/`N` se aceptan como
   Sí/No, y son `409` las dos claves para la misma columna (`description` y `Description`) y los objetos o listas
   como valor. El tipo se convierte con la clase Java de `POInfo`, no con el `DisplayType`, igual que hacen los DTO.
7. **Alta con `#USE_DEFAULTS=Y`:** los valores por defecto del diccionario se aplican también a las columnas que
   **no** vinieron en el body. Es lo que hacen los endpoints tipados, que recorren todas las propiedades del DTO.
8. **Guardas de null en `deleteEntity` y `processEntity`.** Con `id=0` inexistente, `getPO` devuelve `null` y
   había NPE → 500 (y `processEntity` dejaba la Trx abierta). Ahora es 404. **Afecta también a los tipados, solo
   en ese caso.**
9. **`setReferencedValue` ahora cierra su `PreparedStatement` y su `ResultSet`**, que antes quedaban abiertos.
10. **Tests:** la vista es `RV_BPartner` y no `C_Allocation_Detail_V`, que no tiene clase `X_` en el jar y daba
    D9 antes que D6. La tabla sin clase se busca dinámicamente entre las de componentes no core, en lugar de
    nombrar un plugin. La paridad elige el socio por SQL, porque `DEFAULT_BPARTNER_ID` (1012145) **no existe** en
    `libertya_rel_22ar_for_api_25`.

### 12.3 Verificación

- **Compilación (2026-09-30):** el `main` necesita un core con el commit `e1259b8a` (2026-09-04), que agregó
  `MField.getAD_Field_ID()` y que usan `WindowCalloutExecutor` y `WindowFieldStateEngine`. Con los jars
  regenerados en `/ServidorOXP/lib` compila tal cual, sin parches. (El día anterior se había verificado sobre una
  copia descartable con esas llamadas reemplazadas por `0`, porque ningún jar local tenía el commit.)
- `GenericIntegrationTests` contra `libertya_rel_22ar_for_api_25`: **19/19**. En la base quedó el asiento en `CO`
  con las líneas 10 y 20 y la combinación contable resuelta por el modelo.
- Suite completa: **421 tests, 64 fallas**. Son **las mismas 64** que fallan en `HEAD` sin estos cambios
  (402 tests), comparadas test por test. Son de la base de tests, no del código: datos (`BPartnerTrxDisabled`,
  período cerrado, conversiones duplicadas, socio por defecto inexistente) y un esquema de 2022 más viejo que el
  core (`InventoryTypeRequired`, ver `docs/compatibilidad-core.md` §6.2).
- **Smoke con una customización real (§9.2, 2026-09-30).** Fat jar con el core nuevo embebido, el `OXP.jar` de la
  instancia por delante en `loader.path` y la base de esa instancia. El log de arranque confirmó que el core se
  cargó desde el jar de la instancia. Resultados:
  - **Maestro custom:** alta, detalle y baja OK. El alta duplicada la rechazó el `beforeSave` de la clase custom con
    su propio mensaje.
  - **Documento custom:** el alta incompleta la rechazó el `beforeSave` custom con su mensaje, y `process?action=CO`
    sobre un documento custom ya completado respondió *"ya coincide con el estado actual CO"*, o sea que se
    reconoció la clase custom como `DocAction`. **No se completó un documento custom de punta a punta:** la base
    de esa instancia es una copia parcial sin los comprobantes que el documento necesita, y completar los que hay
    habría modificado stock. Nada de lo probado quedó en la base.
- Criterios de §8: 1, 2, 3, 5, 6 y 7 cumplidos; el 4 cumplido salvo el `CO` de punta a punta de un documento custom.

### 12.4 Compatibilidad binaria con el `OXP.jar` de la instancia (§4, cuidado 3), verificada

Con el `OXP.jar` de una instancia **anterior** a `e1259b8a` por delante en `loader.path`, la app arranca y el
genérico funciona, pero `POST /v1.0/tabs/{id}/new-record` (y `evaluate` / `callout`, que usan el mismo código)
responde **500** con `NoSuchMethodError: org.openXpertya.model.MField.getAD_Field_ID()I`. La misma llamada con el
core embebido responde 200. No hay aviso al arrancar: falla recién al usar esos endpoints, y como es un `Error` y
no una `Exception`, los `catch` de los controllers no lo atrapan. Regla: **el `OXP.jar` de una instancia que se
ponga en `loader.path` tiene que estar construido sobre un core que incluya todo lo que lyrestapi usa del core**.
