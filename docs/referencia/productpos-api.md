# Relación artículo-proveedor (`/v1.0/productpos`) — guía de uso

**Para quién es este documento:** para alguien —persona o agente de IA— que tiene que **consumir** este endpoint
desde afuera. No hace falta conocer el código de la API.

**Qué resuelve:** leer, crear, modificar y borrar las relaciones entre un artículo y sus proveedores (tabla
`M_Product_PO` de Libertya, pestaña *Compras* de la ventana de artículos). Cada relación dice que un artículo se le
compra a una entidad comercial, y puede llevar el código que usa el proveedor, la unidad de medida y los precios de
compra.

**Por qué importa:** desde el core **26.05**, Libertya **rechaza la línea de un remito de compra** (`M_InOut` con
`IsSOTrx = N`) si el artículo no tiene una relación con el proveedor de la cabecera. El error es
`El artículo no pertenece al proveedor`. Si tu integración genera remitos de compra, cada artículo que aparezca en
las líneas tiene que tener su relación con ese proveedor **antes** de crear el remito.

Toda la lógica de negocio la pone el modelo de Libertya (`MProductPO`): la API no agrega validaciones propias,
salvo la de §4.

---

## 1. Lo mínimo para que funcione

```bash
# 1) Token (las credenciales van como HEADERS, no como body)
TOKEN=$(curl -s -X POST "$BASE/token" \
  -H "username: <usuario>" -H "password: <clave>" \
  -H "clientid: <id_compañía>" -H "orgid: <id_organización>")

# 2) Relacionar el artículo 1015401 con el proveedor 1012142
curl -X POST "$BASE/v1.0/productpos" \
  -H "Authorization: $TOKEN" -H "Content-Type: application/json" \
  -d '{"m_product_id": 1015401, "c_bpartner_id": 1012142, "c_uom_id": 100, "vendorproductno": "ART-0001"}'
# -> 200 con la clave en texto plano: 1015401-1012142

# 3) Leerla
curl "$BASE/v1.0/productpos/1015401/1012142" -H "Authorization: $TOKEN"
# -> 200 {"ad_client_id": 1010016, "ad_org_id": 1010053, "c_bpartner_id": 1012142, "c_uom_id": 100,
#         "isactive": true, "iscurrentvendor": true, "m_product_id": 1015401, "vendorproductno": "ART-0001", ...}
```

Los IDs de los ejemplos son de una base de pruebas y **no sirven en otra instancia**.

---

## 2. Endpoints

| Método | Ruta | Qué hace | Respuesta OK |
|---|---|---|---|
| `GET` | `/v1.0/productpos` | Listado. Query: `filter`, `fields`, `sort`, `limit`, `page`, `includeTotal` | `200` array de objetos |
| `GET` | `/v1.0/productpos/{idProduct}/{idBPartner}` | Detalle de una relación | `200` objeto |
| `POST` | `/v1.0/productpos` | Alta | `200` `text/plain` con la clave `"<m_product_id>-<c_bpartner_id>"` |
| `PUT` | `/v1.0/productpos/{idProduct}/{idBPartner}` | Modificación parcial: solo los campos enviados | `200` vacío |
| `DELETE` | `/v1.0/productpos/{idProduct}/{idBPartner}` | Baja | `204` |

**La clave es compuesta:** una relación se identifica por el par artículo + proveedor, en ese orden en la URL
(`/productpos/{m_product_id}/{c_bpartner_id}`). No hay un id propio de la relación.

### Query params del listado

Los mismos que en el resto de la API:

| Param | Qué es | Ejemplo |
|---|---|---|
| `filter` | Fragmento de `WHERE` SQL sobre las columnas de `M_Product_PO`. Siempre se le suma el filtro por compañía | `c_bpartner_id=1012142 AND isactive='Y'` |
| `fields` | Campos a devolver, separados por coma | `m_product_id,vendorproductno` |
| `sort` | Fragmento de `ORDER BY` | `m_product_id` |
| `limit` / `page` | Paginado. Por defecto 100 registros, página 1 | `limit=500&page=2` |
| `includeTotal` | `true` agrega el header `X-Total-Count` con el total que respeta el filtro | `includeTotal=true` |

```bash
# Todos los artículos relacionados con un proveedor, con el total
curl "$BASE/v1.0/productpos?filter=c_bpartner_id=1012142&fields=m_product_id,vendorproductno&limit=500&includeTotal=true" \
  -H "Authorization: $TOKEN"

# Todos los proveedores de un artículo
curl "$BASE/v1.0/productpos?filter=m_product_id=1015401" -H "Authorization: $TOKEN"
```

Ojo: `filter` es SQL, así que un Sí/No se compara con `'Y'`/`'N'` (`isactive='Y'`), aunque en el JSON viaje
como `true`/`false`.

---

## 3. Campos

| Campo | Tipo | Alta | Qué es |
|---|---|---|---|
| `m_product_id` | entero | **obligatorio** | Artículo |
| `c_bpartner_id` | entero | **obligatorio** | Proveedor (entidad comercial) |
| `c_uom_id` | entero | recomendado | Unidad de medida. El modelo **no** la completa sola: si no la mandás queda vacía |
| `vendorproductno` | texto | **obligatorio** | Código del artículo para el proveedor. Ver §5 qué mandar si no hay uno |
| `iscurrentvendor` | Sí/No | opcional, `true` | Proveedor vigente del artículo |
| `isactive` | Sí/No | opcional, `true` | Registro activo. Ver §5: desactivar **no** deshace la relación |
| `c_currency_id` | entero | opcional | Moneda de los precios de compra |
| `pricelist` / `pricepo` | número | opcional | Precio de lista y precio de compra al proveedor |
| `order_min` / `order_pack` | número | opcional | Cantidad mínima de compra y múltiplo de compra |
| `deliverytime_promised` | entero | opcional | Días prometidos de entrega |
| `upc` | texto | opcional | Código de barras. Si no lo mandás, el modelo copia el del artículo |
| `ad_org_id` | entero | opcional | Organización. Por defecto, la del token |

El resto de las columnas de `M_Product_PO` (`manufacturer`, `vendorcategory`, `discontinued`, ...) se leen y se
escriben por `additionalvalues`, una lista de pares `{"key": "<columna>", "value": "<valor>"}`:

```json
{"m_product_id": 1015401, "c_bpartner_id": 1012142, "vendorproductno": "ART-0001",
 "additionalvalues": [{"key": "manufacturer", "value": "ACME"}]}
```

**Lo que recibís:** nombres de campo en minúscula; los campos en `null` **no aparecen**; Sí/No como `true`/`false`;
fechas como `"2026-09-30 12:57:37.79411"`. Las columnas con valor que no son campos del objeto vienen en
`additionalvalues`.

**Lo que mandás en un `PUT`:** solo cambia lo que enviás. Un campo en `null` o ausente significa "no tocar". Para
**vaciar** una columna mandá el texto `"[NULL]"`: directo en los campos de texto, y por `additionalvalues` en los
numéricos, porque un campo entero no acepta texto (`{"additionalvalues": [{"key": "c_uom_id", "value": "[NULL]"}]}`).

---

## 4. La clave no se modifica

`m_product_id` y `c_bpartner_id` identifican la relación. En un `PUT`:

- **con el mismo valor que la URL se aceptan**, así podés reenviar lo que recibiste en un `GET`;
- **con otro valor responde `409`**:
  `No se puede modificar C_BPartner_ID (1012142 -> 1012143): es parte de la clave...`

Para pasar un artículo a otro proveedor: `POST` de la relación nueva y, si corresponde, `DELETE` de la vieja.

---

## 5. Reglas de Libertya que tenés que conocer

1. **Una sola relación por artículo y proveedor.** Un segundo `POST` con el mismo par responde `409`
   `Ya existe un registro con la Entidad Comercial seleccionada.`
2. **Para la validación del remito solo importa que la relación exista.** Libertya no mira `isactive` ni
   `iscurrentvendor`: una relación desactivada **sigue habilitando** el remito. Para que el artículo deje de
   pertenecer al proveedor hay que **borrarla** (`DELETE`).
3. **`vendorproductno` es obligatorio y, por defecto, único por proveedor.** En una base estándar la columna es
   `NOT NULL`: sin el campo, el alta responde `409` (si la API está configurada para mostrar el detalle de la
   base, el mensaje dice `null value in column "vendorproductno" ... violates not-null constraint`). Además,
   Libertya rechaza dos artículos distintos con el mismo código para el mismo proveedor (`409` que nombra el
   artículo que ya lo usa), salvo que la instancia tenga la preferencia `MProductPO_UniqueVendorProductNo = N`.
   **Si no tenés un código real del proveedor, mandá el código del artículo** (su `value`): es único por
   artículo, así que nunca choca. No mandes un texto vacío (`""`): cuenta como un código más y choca con el
   siguiente vacío. Algunas instancias relajaron la restricción de la base y aceptan relaciones sin código, pero
   no conviene depender de eso.
4. **El código de barras no se puede repetir entre artículos.** Si no mandás `upc`, se copia el del artículo, y
   Libertya rechaza la relación si otro artículo de la compañía ya tiene una relación activa con ese mismo código.
5. **`iscurrentvendor` no es excluyente.** Marcar un proveedor como vigente no desmarca a los demás: un artículo
   puede tener varios proveedores vigentes.

---

## 6. Receta: asegurar que un artículo tenga su relación con un proveedor

Es el caso típico antes de generar remitos de compra. Hacelo idempotente consultando antes de crear:

```bash
# 1) ¿Ya existe?
curl -s -o /dev/null -w "%{http_code}" "$BASE/v1.0/productpos/1015401/1012142" -H "Authorization: $TOKEN"

# 2a) 404 -> crearla
curl -X POST "$BASE/v1.0/productpos" -H "Authorization: $TOKEN" -H "Content-Type: application/json" \
  -d '{"m_product_id": 1015401, "c_bpartner_id": 1012142, "c_uom_id": 100, "vendorproductno": "ART-0001"}'

# 2b) 200 -> existe. Si querés alinear datos, PUT solo con lo que cambia
curl -X PUT "$BASE/v1.0/productpos/1015401/1012142" -H "Authorization: $TOKEN" -H "Content-Type: application/json" \
  -d '{"c_uom_id": 100, "iscurrentvendor": true}'
```

Para muchos artículos conviene traer primero todas las relaciones del proveedor en una sola consulta paginada
(§2), y crear solo las que falten.

Si en lugar de consultar preferís intentar el `POST` directamente, un `409` con
`Ya existe un registro con la Entidad Comercial seleccionada.` significa que la relación ya estaba. Cualquier otro
`409` es un error real (ver §5).

---

## 7. Errores

| Código | Cuándo | Mensaje (ejemplo) |
|---|---|---|
| `404` | La relación no existe (`GET`, `PUT`, `DELETE`) | *(vacío)* |
| `409` | Ya existe una relación para ese artículo y proveedor | `Ya existe un registro con la Entidad Comercial seleccionada.` |
| `409` | Falta `vendorproductno` | el error de la base, o `Error: Imposible realizar la operacin solicitada.` (así, sin la ó) si la API oculta el detalle |
| `409` | Se quiso cambiar la clave en un `PUT` | `No se puede modificar C_BPartner_ID (...): es parte de la clave...` |
| `409` | Código de proveedor o código de barras repetido, u otro rechazo del modelo o de la base | el mensaje del ERP |
| `401` | La relación es de otra compañía | `Token de acceso limitado a compañía ...` |
| `403` | Token inválido o ausente | |

En el `GET` de detalle, igual que en el resto de la API, cualquier error sale como `404` con el motivo en el body.

---

## Referencias

- Swagger UI en `/swagger-ui`, tag `productpo`.
- `docs/referencia/endpoint-generico-api.md`: formato de datos y convenciones comunes a toda la API.
