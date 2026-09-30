# Endpoint genérico por tabla — guía de uso

**Para quién es este documento:** para alguien —persona o agente de IA— que tiene que **consumir** estos
endpoints desde afuera. No explica cómo están implementados; para eso está `docs/planes/plan-endpoint-generico.md`.

**Qué resuelve:** leer y escribir **cualquier tabla** de Libertya indicando su nombre en la URL, sin que la API
tenga un endpoint propio para ella. Sirve para tablas del core que no tienen endpoint (`C_Campaign`,
`M_Shipper`, ...) y para las tablas que agregan las customizaciones de cada instancia. Toda la lógica de
negocio la pone el modelo de Libertya de esa tabla (`beforeSave`, `afterSave`, `completeIt`, plugins): la API
no agrega ni saca validaciones.

> **Si la tabla ya tiene un endpoint propio, usá ese.** Los endpoints tipados hacen cosas que el genérico no
> hace (ver §5.3): por ejemplo `POST /v1.0/journals` crea cabecera y líneas en una sola transacción y completa
> en las líneas datos que el genérico te obliga a mandar.

---

## 1. Lo mínimo para que funcione

```bash
# 1) Token (las credenciales van como HEADERS, no como body)
TOKEN=$(curl -s -X POST "$BASE/token" \
  -H "username: <usuario>" -H "password: <clave>" \
  -H "clientid: <id_compañía>" -H "orgid: <id_organización>")

# 2) Alta: un objeto plano, una clave por columna
curl -X POST "$BASE/v1.0/generic/C_Campaign" \
  -H "Authorization: $TOKEN" -H "Content-Type: application/json" \
  -d '{"value": "CAMP-01", "name": "Campaña de prueba"}'
# -> 200 con el id en texto plano, por ejemplo: 1010234

# 3) Lectura
curl "$BASE/v1.0/generic/C_Campaign/1010234?fields=value,name,isactive" -H "Authorization: $TOKEN"
# -> 200 {"value": "CAMP-01", "name": "Campaña de prueba", "isactive": true}
```

### Las reglas que más se olvidan

1. **El nombre de la tabla es el `TableName` de `AD_Table`**, sin distinguir mayúsculas: `C_Campaign` y
   `c_campaign` son lo mismo.
2. **Una clave del body que no es columna de la tabla es un error (`409`)**, no se ignora. Así un error de
   tipeo (`c_bpartnr_id`) no deja un registro incompleto sin avisar.
3. **Las columnas obligatorias las define el diccionario de cada instancia.** La API no te las va a listar
   antes de que falle el alta: ver §7 para descubrirlas.
4. **Cada llamada es su propia transacción.** Un documento se arma en varias llamadas y no hay "todo o nada"
   entre ellas (§5.1).
5. **Crear un documento no lo completa.** Completar es siempre un `process?action=CO` explícito.

---

## 2. Endpoints

| Método | Ruta | Qué hace | Respuesta OK |
|---|---|---|---|
| `GET` | `/v1.0/generic/{table}` | Listado. Query: `filter`, `fields`, `sort`, `limit`, `page`, `includeTotal` | `200` array de objetos |
| `GET` | `/v1.0/generic/{table}/{id}` | Detalle. Query: `fields` | `200` objeto |
| `POST` | `/v1.0/generic/{table}` | Alta | `200` `text/plain` con el id |
| `PUT` | `/v1.0/generic/{table}/{id}` | Modificación parcial: solo las claves enviadas | `200` vacío |
| `DELETE` | `/v1.0/generic/{table}/{id}` | Baja | `204` |
| `PUT` | `/v1.0/generic/{table}/{id}/process?action=CO` | Procesa un documento: `CO`, `VO` o `CL` | `200` `text/plain` con el mensaje del proceso |

`{id}` es el valor de la clave primaria del registro (en general la columna `<Tabla>_ID`).

### Query params del listado

Son los mismos que en el resto de la API:

| Param | Qué es | Ejemplo |
|---|---|---|
| `filter` | Fragmento de `WHERE` SQL sobre las columnas de la tabla. Siempre se le suma el filtro por compañía | `value='CAMP-01'` |
| `fields` | Columnas a devolver, separadas por coma | `value,name,isactive` |
| `sort` | Fragmento de `ORDER BY` | `name DESC` |
| `limit` / `page` | Paginado. Por defecto 100 registros, página 1 | `limit=20&page=3` |
| `includeTotal` | `true` agrega el header `X-Total-Count` con el total que respeta el filtro | `includeTotal=true` |

La respuesta trae además los headers `prev` y `next` con las URLs de las páginas vecinas.

---

## 3. Formato de los datos

### Lo que recibís

- Un objeto JSON **plano**, con una clave por columna: el nombre de la columna **en minúscula**
  (`c_bpartner_id`, `dateacct`), igual que en los endpoints tipados.
- **Las columnas en `null` no aparecen.** Que falte una clave no significa que la columna no exista.
- Tipos: IDs y enteros como número, montos como número decimal, Sí/No como `true`/`false`, y fechas como texto
  con el formato `"2024-01-10 00:00:00.0"`.
- No se devuelven las columnas binarias ni de imagen.
- Si la API está configurada con valores referenciados, viene además `referencedvalues`: una lista de pares
  con el `value` (`c_bpartner_id__value`) y los identificadores (`c_bpartner_id__detail`) del registro al que
  apunta cada columna de referencia. Si usás `fields`, pedilo explícitamente: `fields=c_bpartner_id,referencedvalues`.

### Lo que mandás

- Un objeto JSON plano. Como clave vale el nombre exacto en minúscula (`c_bpartner_id`) y también la forma sin
  guiones bajos (`cbpartnerid`). Mandar las dos para la misma columna es un error.
- Sí/No: `true`/`false` (también se acepta `"Y"`/`"N"`).
- Fechas: `"2024-01-10"`, `"2024-01-10 14:30"` o `"2024-01-10 14:30:00"`.
- Montos: número o texto (`100.50` o `"100.50"`).
- Solo valores simples: un objeto o una lista como valor es un error.
- **Se ignoran** la columna clave (el id sale de la URL o lo asigna el modelo) y `referencedvalues`. Así podés
  reenviar en un `PUT` algo que recibiste en un `GET` sin que falle.
- **Para dejar una columna en `null` en un `PUT`** mandá `"[NULL]"` (o el valor configurado en
  `restapi.libertya.app.nullValue`). Mandar `null` en un `PUT` significa "no tocar esta columna".
- `ad_client_id` y `ad_org_id` los completa la API desde el token si no los mandás. `ad_org_id` se puede mandar
  para crear en otra organización de la misma compañía.

---

## 4. Maestros: CRUD completo

```bash
# Alta
curl -X POST "$BASE/v1.0/generic/C_Campaign" -H "Authorization: $TOKEN" -H "Content-Type: application/json" \
  -d '{"value": "CAMP-01", "name": "Campaña de prueba", "description": "original"}'
# -> 200  1010234

# Buscar por un valor legible, con el total
curl "$BASE/v1.0/generic/C_Campaign?filter=value='CAMP-01'&includeTotal=true" -H "Authorization: $TOKEN"

# Modificación parcial: solo cambia description
curl -X PUT "$BASE/v1.0/generic/C_Campaign/1010234" -H "Authorization: $TOKEN" -H "Content-Type: application/json" \
  -d '{"description": "modificada"}'

# Baja
curl -X DELETE "$BASE/v1.0/generic/C_Campaign/1010234" -H "Authorization: $TOKEN"
# -> 204
```

---

## 5. Documentos: varias llamadas

Una tabla es un **documento** cuando su modelo implementa `DocAction` (facturas, pedidos, asientos, y los
documentos que agregue una customización). Se arma en varias llamadas: cabecera, líneas, y al final `process`.

Ejemplo con un asiento contable (`GL_Journal`). Los IDs son de la instancia de QA y **no sirven en otra base**:

```bash
# 1) Cabecera -> queda en borrador (DR)
curl -X POST "$BASE/v1.0/generic/GL_Journal" -H "Authorization: $TOKEN" -H "Content-Type: application/json" \
  -d '{"ad_org_id": 1010053, "c_acctschema_id": 1010016, "c_doctype_id": 1010506, "c_currency_id": 118,
       "gl_category_id": 1010098, "c_conversiontype_id": 114, "dateacct": "2024-01-10", "datedoc": "2024-01-10",
       "postingtype": "A", "description": "Asiento cargado por el endpoint genérico"}'
# -> 200  1012345

# 2) Líneas, una por llamada, apuntando a la cabecera
curl -X POST "$BASE/v1.0/generic/GL_JournalLine" -H "Authorization: $TOKEN" -H "Content-Type: application/json" \
  -d '{"gl_journal_id": 1012345, "ad_org_id": 1010053, "dateacct": "2024-01-10", "c_elementvalue_id": 1012830,
       "c_currency_id": 118, "c_conversiontype_id": 114, "amtsourcedr": 100, "amtsourcecr": 0}'
curl -X POST "$BASE/v1.0/generic/GL_JournalLine" -H "Authorization: $TOKEN" -H "Content-Type: application/json" \
  -d '{"gl_journal_id": 1012345, "ad_org_id": 1010053, "dateacct": "2024-01-10", "c_elementvalue_id": 1012839,
       "c_currency_id": 118, "c_conversiontype_id": 114, "amtsourcedr": 0, "amtsourcecr": 100}'

# 3) Completar
curl -X PUT "$BASE/v1.0/generic/GL_Journal/1012345/process?action=CO" -H "Authorization: $TOKEN"
# -> 200 con el mensaje del proceso

# 4) Verificar
curl "$BASE/v1.0/generic/GL_Journal/1012345?fields=docstatus,documentno,totaldr,totalcr" -H "Authorization: $TOKEN"
```

### 5.1 No hay atomicidad entre llamadas

Cada llamada se confirma por separado. Si falla la segunda línea, la cabecera y la primera línea **quedan
creadas en borrador**. Lo que te toca hacer:

- corregir el dato y reintentar la línea que falló, o
- borrar lo que quedó (`DELETE` de las líneas y de la cabecera; en general un documento en borrador se puede
  borrar, pero lo decide el modelo de cada tabla).

**No reintentes el flujo completo desde el principio**, porque duplicarías la cabecera. Si tu integración
puede cortarse a mitad de camino, guardá el id de la cabecera apenas lo recibís.

### 5.2 Procesar

| Acción | Qué hace |
|---|---|
| `CO` | Completa el documento |
| `VO` | Anula el documento |
| `CL` | Cierra el documento |

Las acciones de reversión y reactivación del core (`RC`, `RA`, `RE`) **no están disponibles**: responden `409`.
Es una limitación del procesado de documentos de toda la API, no solo del genérico.

`process` sobre una tabla que no es un documento responde `409`.

### 5.3 Lo que el genérico NO hace por vos

- **La lógica que agregan los endpoints tipados no está.** Por ejemplo, `POST /v1.0/journals` copia a las
  líneas el `ad_org_id` y la `dateacct` de la cabecera cuando no vienen; en el genérico las líneas los tienen
  que traer, salvo que el propio modelo los complete.
- **Los callouts de las ventanas no corren.** Lo que en la interfaz de Libertya se autocompleta al elegir un
  valor (por ejemplo, la dirección al elegir una entidad comercial) no pasa acá: mandá esos valores. Esto vale
  igual para los endpoints tipados.
- **El alta no completa**, aunque la API esté configurada para completar documentos al crearlos: en el
  genérico la cabecera llega sola y completarla en ese momento no tiene sentido.

---

## 6. Errores

| Código | Cuándo | Mensaje (ejemplo) |
|---|---|---|
| `404` | La tabla no existe | `No existe la tabla C_Campania` |
| `404` | El registro no existe | *(vacío)* |
| `409` | Una clave del body no es columna de la tabla | `Claves que no son columnas de C_Campaign: nmae` |
| `409` | Se quiso escribir una columna virtual, dos claves para la misma columna, o un objeto como valor | `Claves que no se pueden escribir en C_Campaign: ...` |
| `409` | La tabla es una vista y se pidió una escritura | `La tabla RV_BPartner es una vista: solo admite lectura` |
| `409` | Escritura en una tabla cuya clave no es `<Tabla>_ID` | `La clave de la tabla AD_PInstance_Log es Log_ID y no AD_PInstance_Log_ID: ...` |
| `409` | `process` sobre algo que no es un documento | `La tabla C_Campaign no es un documento: no admite process` |
| `409` | La tabla no tiene clave simple numérica | `La tabla C_InvoiceTax no tiene una clave simple numerica (...)` |
| `409` | No hay clase de modelo para la tabla en esta instancia | `No se encontro la clase de modelo para la tabla X (componente ...)` |
| `409` | El modelo rechazó la operación (`beforeSave`, `completeIt`, restricción de la base) | el mensaje del ERP |
| `401` | El registro es de otra compañía | `Token de acceso limitado a compañía ...` |
| `403` | Token inválido o ausente | |

**Ojo con el `GET` de detalle:** ahí, igual que en el resto de la API, cualquier error sale como `404` con el
motivo en el body. O sea que `GET /v1.0/generic/C_InvoiceTax/1` responde `404` con el mensaje de clave
compuesta, no `409`. Leé el body para distinguir "no existe" de "no se puede operar".

**"No se encontró la clase de modelo":** la tabla existe en el diccionario, pero el código que la maneja no
está cargado en esta API. Pasa con tablas de plugins o customizaciones cuando la API se desplegó sin el
`OXP.jar` de la instancia. No es un problema del request: avisá a quien administra el despliegue.

---

## 7. Cómo descubrir las columnas de una tabla

El genérico no tiene (todavía) un endpoint de schema. Mientras tanto:

```bash
# Un registro existente muestra las columnas con valor
curl "$BASE/v1.0/generic/C_Campaign?limit=1" -H "Authorization: $TOKEN"

# El diccionario completo de la tabla, usando el propio genérico sobre AD_Column
curl "$BASE/v1.0/generic/AD_Column?filter=ad_table_id=(SELECT%20ad_table_id%20FROM%20ad_table%20WHERE%20tablename='C_Campaign')&fields=columnname,ismandatory,defaultvalue,ad_reference_id&limit=500" \
  -H "Authorization: $TOKEN"
```

`ismandatory=true` sin `defaultvalue` es una columna que casi seguro tenés que mandar. El diccionario no
siempre lo dice todo: hay columnas NOT NULL en la base sin marca en el diccionario, y columnas obligatorias
que el modelo completa solo. Ante la duda, probá el alta y leé el `409`.

---

## 8. Qué tablas se pueden operar

- **Cualquier tabla de `AD_Table`**, incluidas las de metadatos (`AD_*`). El endpoint no restringe tablas ni
  columnas: aplican los mismos controles que al resto de la API (token y compañía).
- **Con clave primaria simple y numérica.** Las tablas con clave compuesta (por ejemplo `C_InvoiceTax`) todavía
  no se pueden operar por acá. Varias tienen endpoint tipado: `M_Product_PO` en `/v1.0/productpos` (ver
  `productpos-api.md`), `M_ProductPrice` en `/v1.0/productprices`, `AD_User_Roles` en `/v1.0/userroles`.
- **Con clase de modelo disponible** en la API (ver §6).
- **Las vistas son de solo lectura**, y también las pocas tablas cuya clave no se llama `<Tabla>_ID`.
- **El listado necesita la columna `AD_Client_ID`**, porque siempre filtra por la compañía del token. Las
  pocas tablas de sistema que no la tienen responden `409` en el listado; el detalle por id sí funciona.

---

## 9. Lo que todavía no hace

| Qué | Mientras tanto |
|---|---|
| Crear un documento completo (cabecera + líneas) en una sola transacción | Varias llamadas; ver §5.1 para recuperarse de un corte |
| `RC` / `RA` / `RE` en `process` | No hay alternativa por API |
| Tablas con clave compuesta | Usar el endpoint tipado si existe |
| Endpoint de schema (columnas, tipos, obligatoriedad) | §7 |
| Restringir qué tablas o columnas se pueden escribir | — |

---

## Referencias

- `docs/planes/plan-endpoint-generico.md` — diseño, decisiones y despliegue con el `OXP.jar` de la instancia (§4).
- `docs/referencia/asientos-manuales-api.md` — reglas de `GL_Journal`, útil para el ejemplo de documento.
- Swagger UI en `/swagger-ui`, tag `generic`.
