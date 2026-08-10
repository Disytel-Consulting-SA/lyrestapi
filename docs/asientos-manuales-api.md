# Asientos contables manuales — guía de uso de los endpoints

**Para quién es este documento:** para alguien —persona o agente de IA— que tiene que **consumir** estos
endpoints desde afuera. No explica cómo están implementados; para eso está `docs/plan-asientos-manuales.md`.

**Qué resuelven:** cargar en Libertya asientos contables manuales (`GL_Journal`), es decir movimientos
contables que **no tienen un documento origen en el ERP**. Facturas, remitos, inventarios y movimientos se
contabilizan solos por el motor de posting: **esos no van por acá**. Lo que va por acá es lo que vive fuera del
ERP — absorción de mano de obra, gastos indirectos, variaciones de costo estándar contra real, WIP, cierres
mensuales de costos.

> ⚠️ `/v1.0/journals` **no tiene nada que ver** con `/v1.0/posjournals`, que es la caja diaria de punto de
> venta. La confusión ya pasó una vez.

---

## 1. Lo mínimo para que funcione

Si solo vas a leer una sección, que sea esta.

```bash
# 1) Token (las credenciales van como HEADERS, no como body)
TOKEN=$(curl -s -X POST "$BASE/token" \
  -H "username: <usuario>" -H "password: <clave>" \
  -H "clientid: <id_compañía>" -H "orgid: <id_organización>")

# 2) Asiento completo (cabecera + líneas) en un solo POST
curl -X POST "$BASE/v1.0/journals?validatebalance=true" \
  -H "Authorization: Bearer $TOKEN" -H "Content-Type: application/json" \
  -d '{
    "header": {
      "ad_org_id": 1010053,
      "c_acctschema_id": 1010016,
      "c_doctype_id": 1010506,
      "gl_category_id": 1010098,
      "c_currency_id": 118,
      "c_conversiontype_id": 114,
      "dateacct": "2024-01-10 00:00:00",
      "datedoc": "2024-01-10 00:00:00",
      "postingtype": "A",
      "description": "MRP - Absorcion MO enero 2024"
    },
    "lines": [
      { "c_elementvalue_id": 1012825, "c_currency_id": 118, "c_conversiontype_id": 114,
        "amtsourcedr": 1500.50, "amtsourcecr": 0, "description": "MO aplicada centro 100" },
      { "c_elementvalue_id": 1012826, "c_currency_id": 118, "c_conversiontype_id": 114,
        "amtsourcedr": 0, "amtsourcecr": 1500.50, "description": "MO absorbida" }
    ]
  }'
# -> 200 con el GL_Journal_ID en texto plano, por ejemplo: 1010542
```

**Los IDs del ejemplo son de la instancia de QA y NO sirven en otra base.** Resolvelos con los endpoints de la
sección 5 — nunca los hardcodees.

### Las cinco reglas que más se olvidan

1. **`c_conversiontype_id` va en la cabecera Y en cada línea.** Es NOT NULL y no tiene valor por defecto en
   ningún lado. Sin él la base rechaza el INSERT con un error de PostgreSQL crudo.
2. **`description` es obligatoria en la cabecera.** Ídem: NOT NULL sin default.
3. **`c_currency_id` es obligatoria en cada línea.** En la cabecera es opcional, pero **mandala igual**
   (ver sección 7, "currency en la cabecera").
4. **Exactamente uno de `amtsourcedr` / `amtsourcecr` distinto de cero por línea.** Los dos en cero, o los dos
   con valor, y la línea es rechazada.
5. **La cuenta se indica con `c_elementvalue_id`**, no con la combinación contable. Ver sección 3.

---

## 2. Qué mandás y qué NO mandás

### Cabecera (`header`)

| Campo | ¿Obligatorio? | Nota |
|---|---|---|
| `ad_org_id` | sí | organización |
| `c_acctschema_id` | sí | `GET /v1.0/acctschemas` |
| `c_doctype_id` | sí | tipo de documento con `docbasetype='GLJ'` |
| `gl_category_id` | sí | `GET /v1.0/glcategories` |
| `c_conversiontype_id` | **sí** | sin default; hay que mandarlo |
| `description` | **sí** | sin default; hay que mandarlo |
| `dateacct` | sí | fecha contable, `"YYYY-MM-DD HH:MM:SS"`. Define el período |
| `datedoc` | sí | fecha del documento |
| `postingtype` | sí | `A` = Actual (lo normal). `B` = Budget, `S` = Statistical |
| `c_currency_id` | técnicamente no | **mandala igual**, ver sección 7 |

### Línea (`lines[]`)

| Campo | ¿Obligatorio? | Nota |
|---|---|---|
| `c_elementvalue_id` | sí (ver sección 3) | la cuenta contable |
| `c_currency_id` | **sí** | NOT NULL en la línea |
| `c_conversiontype_id` | **sí** | sin default |
| `amtsourcedr` / `amtsourcecr` | sí | exactamente uno distinto de cero |
| `description` | no | recomendado |
| `ad_org_id` | no | si no viene, se hereda de la cabecera |
| `dateacct` | no | si no viene, se hereda de la cabecera |
| `c_validcombination_id` | no | ver sección 3 |

### Lo que NO tenés que mandar: lo calcula el modelo

`c_period_id` (se deriva de `dateacct`) · `totaldr` / `totalcr` (se recalculan desde las líneas) · `line`
(autonumerado de a 10) · `amtacctdr` / `amtacctcr` y `currencyrate` (se calculan contra la moneda del esquema
contable) · `docstatus` · `documentno` (secuencia) · `posted` · `processed` · `c_validcombination_id`.

> ⚠️ **Trampa del schema:** en el OpenAPI, `c_validcombination_id` aparece dentro del bloque `required` de
> `JournalLine`, y `amtacctdr`, `amtacctcr`, `currencyrate`, `line`, `created`, `updated` y otros también.
> **Eso es ruido del generador**, que arma ese bloque desde el diccionario de Libertya. La API **no valida
> nada de eso** y esos campos no van en el payload. Guiate por las tablas de arriba, no por el `required` del
> schema. (Lo mismo pasa en el resto de los recursos de esta API.)

---

## 3. Cómo se indica la cuenta (leer antes de armar las líneas)

En Libertya una línea de asiento no apunta a una cuenta sino a una **combinación contable**
(`C_ValidCombination`) = cuenta + dimensiones analíticas opcionales (organización, producto, entidad comercial,
proyecto, campaña).

**Lo que tenés que hacer: mandar `c_elementvalue_id` y listo.** El modelo de Libertya busca —o crea— la
combinación por vos, con la organización y todas las dimensiones en cero. No hace falta que conozcas ni
consultes ninguna combinación.

Es exactamente lo que hacía la integración SOAP anterior, y produce las mismas filas.

**`c_validcombination_id` es opcional** y solo tiene sentido si necesitás imputar **con dimensiones
analíticas** (por producto, por proyecto, etc.). En ese caso tenés que buscar la combinación en
`GET /v1.0/validcombinations` y mandarla armada. Ojo con dos cosas:

- Las combinaciones **se crean por demanda**: si nadie imputó nunca a esa cuenta con esa dimensión, **no
  existe** y no hay ninguna fila para pasar. La API no las crea a pedido.
- Si mandás los dos campos y no coinciden (la combinación no corresponde a esa cuenta), el modelo descarta la
  combinación y la vuelve a resolver desde la cuenta.

Si no mandás ninguno de los dos, la línea es rechazada.

---

## 4. Endpoints

### Asientos

| Método | Path | Para qué |
|---|---|---|
| `POST` | `/v1.0/journals` | crear asiento completo (cabecera + líneas) en una transacción |
| `GET` | `/v1.0/journals` | listar cabeceras (`filter`, `fields`, `sort`, `limit`, `page`) |
| `GET` | `/v1.0/journals/{id}` | **documento completo**: cabecera + todas las líneas, ordenadas y sin truncar |
| `PUT` | `/v1.0/journals/{id}` | modificar la cabecera (solo en borrador) |
| `DELETE` | `/v1.0/journals/{id}` | borrar (solo en borrador) |
| `PUT` | `/v1.0/journals/{id}/process?action=` | `CO` \| `VO` \| `CL` |

### Líneas sueltas (para corregir un asiento en borrador)

`GET`/`POST` `/v1.0/journallines` · `GET`/`PUT`/`DELETE` `/v1.0/journallines/{id}`

En el `POST` hay que indicar el `gl_journal_id`. Los totales de la cabecera se recalculan solos al agregar,
modificar o borrar una línea.

### Query params del `POST /v1.0/journals`

| Param | Default | Qué hace |
|---|---|---|
| `complete` | valor global de `org.libertya.api.service.doc.complete` | `false` deja el asiento en borrador (`DR`) para revisarlo; `true` lo completa |
| `validatebalance` | valor global de `org.libertya.api.service.journal.validate-balance` (de fábrica `N`) | `true` valida Debe = Haber **antes de insertar nada** y responde 409 si no cuadra |

**Recomendación fuerte para integraciones automáticas: `validatebalance=true`.** Ver sección 7.

---

## 5. Maestros de solo lectura — para no hardcodear IDs

Los IDs internos de Libertya **cambian de una instancia a otra**. Un asiento armado contra los IDs de una base
no sirve en la siguiente. Estos endpoints existen para resolverlos en runtime:

| Endpoint | Para qué | Campo estable para buscar |
|---|---|---|
| `GET /v1.0/elementvalues` | plan de cuentas | `value` (`1.01.01.01`) y `name` |
| `GET /v1.0/acctschemas` | esquemas contables | `name` |
| `GET /v1.0/glcategories` | categorías de asiento | `name`, `isdefault` |
| `GET /v1.0/periods` | períodos contables | `startdate` / `enddate` |
| `GET /v1.0/validcombinations` | combinaciones contables | solo si imputás con dimensiones (sección 3) |

Todos aceptan `filter`, `fields`, `sort`, `limit`, `page`, y todos tienen su `/{id}`.

```bash
# Resolver una cuenta por su codigo legible
curl -s -H "Authorization: Bearer $TOKEN" \
  "$BASE/v1.0/elementvalues?filter=value%3D%274.1.1%27&fields=c_elementvalue_id,value,name"

# Cuentas imputables (excluye las de agrupacion)
curl -s -H "Authorization: Bearer $TOKEN" \
  "$BASE/v1.0/elementvalues?filter=issummary%3D%27N%27&limit=500"
```

> **Cuentas de agrupación:** las que tienen `issummary=true` son títulos del plan de cuentas y **no admiten
> imputación**. Filtrá siempre por `issummary='N'`.

> **Período abierto:** conviene chequear `GET /v1.0/periods` antes de mandar un asiento con fecha vieja. Si el
> período está cerrado el `POST` responde 409, y es más claro detectarlo antes.

---

## 6. Procesar: completar, anular, cerrar

```bash
curl -X PUT "$BASE/v1.0/journals/1010542/process?action=CO" -H "Authorization: Bearer $TOKEN"
```

| Acción | Qué hace |
|---|---|
| `CO` | Completar |
| `VO` | Anular |
| `CL` | Cerrar |

**No están disponibles `RC` (contra-asiento), `RA` ni `RE` (reactivar)**, por una limitación del procesado
genérico de documentos de esta API (`docs/PENDIENTES.md` P1). Devuelven 409.

> 🔴 **`VO` NO es una reversión contable.** Anular **borra los registros contables y pone todas las líneas en
> cero**: el asiento queda como una cáscara vacía, sin rastro de lo que decía.
>
> Para corregir un asiento ya contabilizado, lo correcto contablemente es el **contra-asiento**: crear un
> asiento nuevo con Debe y Haber invertidos. Quedan los dos visibles y auditables. En una instancia con
> auditoría o con períodos ya reportados, `VO` puede directamente no ser aceptable.

### Completar ≠ contabilizar

`docstatus='CO'` **no** significa que el asiento ya esté en `Fact_Acct`. El posteo lo hace el **Accounting
Processor** del ERP de forma **diferida** — segundos o minutos después. El asiento queda con `posted='N'` hasta
entonces.

Si tu proceso necesita confirmar que se contabilizó, tenés que consultarlo después; el `200` del `POST` no
alcanza como prueba.

---

## 7. Trampas conocidas

### El asiento descuadrado NO es rechazado por el ERP

Si el Debe no iguala al Haber, lo esperable sería un error. **No pasa.** El esquema contable tiene habilitado
el *suspense balancing*: en vez de rechazar, el ERP completa el asiento e imputa la diferencia contra la
**cuenta puente de comprobación**.

Eso es una decisión deliberada del ERP (la cuenta puente existe justamente para entradas importadas que no
cierran), pero para una integración es feo: un bug de cálculo del lado del consumidor no se manifiesta como un
error sino como un **descuadre silencioso escondido en la contabilidad**, que alguien va a tener que encontrar
y desarmar meses después.

Por eso: **mandá `validatebalance=true`**. La API suma los importes y responde 409 antes de insertar nada:

```
HTTP 409
Asiento descuadrado: el total del Debe (1500.5) no coincide con el total del Haber (1000.0). Diferencia: 500.5
```

Si preferís no validar, al menos verificá después: `GET /v1.0/journals/{id}` devuelve `totaldr` y `totalcr`
recalculados desde las líneas.

### `c_currency_id` en la cabecera

La columna es nullable y el asiento se crea y se completa igual sin ella. **Pero mandala.** Si queda en NULL,
cualquier operación que copie la cabecera —una reversión hecha después desde la UI del ERP— falla con un error
de foreign key, porque el NULL se convierte en 0 y no existe una moneda con id 0.

### El `required` del schema OpenAPI miente

Ya está dicho en la sección 2, pero es la confusión más probable si generás un cliente desde el spec: el bloque
`required` sale del diccionario de Libertya, no del contrato real. **No hay Bean Validation en esta API**, así
que ningún campo de esa lista es verificado. Un `POST` con los 9 campos de cabecera y 5 por línea funciona.

### Mensajes de error

- `ModelException` → **409** · `AuthException` → **401** · no encontrado → **404**.
- En el `POST`, el mensaje del modelo viene envuelto: `"Error creando documento: ..."`.
- Los mensajes del core pasan por el traductor de Libertya, así que **no esperes literales tipo `@PeriodClosed@`**
  — buscá un substring del texto traducido.
- Corolario: en el `POST` un error de autorización también sale como **409**, no 401.

---

## 8. Idempotencia: la resolvés vos

La API **no** deduplica. Si reintentás un `POST` por timeout, creás dos asientos.

No hace falta nada especial: usá `description` como marca. Es obligatoria de todos modos, así que siempre hay
dónde poner un identificador propio.

```bash
# Antes de insertar, chequear si ya existe
curl -s -H "Authorization: Bearer $TOKEN" \
  "$BASE/v1.0/journals?filter=description%20LIKE%20%27CIERRE-COSTOS-202608%25%27&fields=gl_journal_id,description"
```

Convención sugerida: un prefijo estable elegido por vos + un identificador único de tu lado, por ejemplo
`CIERRE-COSTOS-202608 | lote 4471`.

La trazabilidad de cuándo y por dónde entró el asiento ya viene gratis: `created` y `createdby` los devuelve el
`GET` sin que haya que agregar ningún campo.

---

## 9. Ejemplo completo de punta a punta

```bash
BASE=http://localhost:8080

# 1) Token
TOKEN=$(curl -s -X POST "$BASE/token" \
  -H "username: AdminLibertya" -H "password: ***" \
  -H "clientid: 1010016" -H "orgid: 1010053")

# 2) Resolver los IDs de esta instancia (NO hardcodear)
curl -s -H "Authorization: Bearer $TOKEN" "$BASE/v1.0/acctschemas?fields=c_acctschema_id,name"
curl -s -H "Authorization: Bearer $TOKEN" "$BASE/v1.0/glcategories?filter=isdefault%3D%27Y%27"
curl -s -H "Authorization: Bearer $TOKEN" \
  "$BASE/v1.0/elementvalues?filter=value%20IN%20(%271.01.01.01%27,%271.01.01.02%27)&fields=c_elementvalue_id,value"

# 3) Crear en borrador, validando el balanceo
ID=$(curl -s -X POST "$BASE/v1.0/journals?complete=false&validatebalance=true" \
  -H "Authorization: Bearer $TOKEN" -H "Content-Type: application/json" -d @asiento.json)

# 4) Revisar lo que quedó
curl -s -H "Authorization: Bearer $TOKEN" "$BASE/v1.0/journals/$ID"

# 5) Completar
curl -s -X PUT "$BASE/v1.0/journals/$ID/process?action=CO" -H "Authorization: Bearer $TOKEN"

# 6) Mas tarde: verificar que el Accounting Processor lo posteo
curl -s -H "Authorization: Bearer $TOKEN" "$BASE/v1.0/journals/$ID?fields=gl_journal_id,docstatus,posted"
```

Respuesta del paso 4, recortada — así queda un asiento bien formado:

```json
{
  "header": {
    "gl_journal_id": 1010542, "documentno": "1000003", "docstatus": "DR", "posted": "false",
    "c_period_id": 1010536, "totaldr": 1500.5, "totalcr": 1500.5,
    "description": "MRP - Absorcion MO enero 2024",
    "created": "2026-08-10 09:19:35.97719", "createdby": 1010717
  },
  "lines": [
    { "line": 10, "c_elementvalue_id": 1012825, "c_validcombination_id": 1034424,
      "amtsourcedr": 1500.5, "amtsourcecr": 0.0, "amtacctdr": 1500.5, "currencyrate": 1.0 },
    { "line": 20, "c_elementvalue_id": 1012826, "c_validcombination_id": 1034428,
      "amtsourcedr": 0.0, "amtsourcecr": 1500.5, "amtacctcr": 1500.5, "currencyrate": 1.0 }
  ]
}
```

Fijate qué apareció solo: `c_validcombination_id`, `line`, `c_period_id`, `totaldr`/`totalcr`,
`amtacctdr`/`amtacctcr`, `currencyrate` y `documentno`. Nada de eso se envió.

---

## 10. Lo que esta API todavía no hace

| | Estado |
|---|---|
| Lotes de asientos (`GL_JournalBatch`) | fuera de alcance. Solo agrega numeración y agrupación |
| Crear combinaciones contables con dimensiones desde la API | no implementado. Hoy solo se pueden **consultar** las existentes |
| Contra-asiento / reversión (`RC`, `RA`) y reactivación (`RE`) | no disponibles (`docs/PENDIENTES.md` P1) |
| Leer lo efectivamente contabilizado (`Fact_Acct`) | no implementado. Hace falta para conciliar contra el mayor del ERP |
| Forzar el posteo desde la API | no, y no está previsto: lo maneja el Accounting Processor |

---

## Referencias

| Qué | Dónde |
|---|---|
| Diseño, decisiones y evidencia | `docs/plan-asientos-manuales.md` |
| Bug del genérico que bloquea `RC`/`RA`/`RE` | `docs/PENDIENTES.md` → P1 |
| Spec OpenAPI viva | `GET /api-docs` · Swagger UI en `/swagger-ui` |
| Arquitectura del proyecto | `CLAUDE.md` |
