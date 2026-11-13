# Estado de cuenta — guía de uso del endpoint

**Para quién es este documento:** para alguien —persona o agente de IA— que tiene que **consumir**
`GET /v1.0/bpartners/{id}/accountstatement` desde afuera. No explica cómo está implementado; para eso está
`docs/planes/plan-estado-de-cuenta.md`.

**Qué resuelve:** en una sola llamada, todo lo que una entidad comercial tiene **con saldo**: facturas, cuotas,
cobros y pagos sin imputar y líneas de caja sin imputar, con el saldo de cada comprobante y de cada cuota
**calculado por Libertya**. Es la misma información que el informe *Estado de Cuenta* para clientes con saldo
pendiente, sin escribir nada en la base.

Por qué no alcanza con `/v1.0/invoices`: Libertya no guarda el saldo de una factura, lo calcula a partir de las
imputaciones (`invoiceopen`), y lo pagado **por cuota** no existe en la base: sale de repartir lo imputado entre
las cuotas por orden de vencimiento. `ispaid` tampoco sirve como saldo. Este endpoint devuelve ese cálculo hecho.

---

## 1. Lo mínimo para que funcione

```bash
# 1) Token (las credenciales van como HEADERS, no como body). La respuesta ya empieza con "Bearer "
TOKEN=$(curl -s -X POST "$BASE/token" \
  -H "username: <usuario>" -H "password: <clave>" \
  -H "clientid: <id_compañía>" -H "orgid: <id_organización>")

# 2) Estado de cuenta de una entidad comercial
curl -s "$BASE/v1.0/bpartners/1012450/accountstatement" -H "Authorization: $TOKEN"

# 3) Solo lo de una organización
curl -s "$BASE/v1.0/bpartners/1012450/accountstatement?ad_org_id=1010053" -H "Authorization: $TOKEN"
```

Respuesta (`200`), una fila por partida con saldo. Sin saldo, `[]`:

```json
[
  {"rowtype":"installment","doc_id":1022263,"c_invoicepayschedule_id":1011161,"installmentno":1,
   "installmentcount":1,"c_bpartner_id":1012450,"ad_org_id":1010053,"issotrx":true,"c_doctype_id":1010888,
   "doctypekey":"CIA0001","docbasetype":"ARI","doctypename":"Factura A-0001","doctypeprintname":"Factura A",
   "documentno":"A000100000020","puntodeventa":1,"numerocomprobante":20,"letra":"A",
   "dateinvoiced":"2026-03-05","dateacct":"2026-03-05","duedate":"2026-03-06","c_currency_id":118,
   "iso_code":"ARS","signo":1,"grandtotal":538012.50,"dueamt":538012.50,"paidamt":0.00,"openamt":538012.50,
   "salesrep_id":1010717,"c_paymentterm_id":1010083,"paymentrule":"P"},
  {"rowtype":"installment","doc_id":1022307,"c_invoicepayschedule_id":1011260,"installmentno":1,
   "installmentcount":1,"c_bpartner_id":1012450,"ad_org_id":1010053,"issotrx":true,"c_doctype_id":1010890,
   "doctypekey":"CCNA0001","docbasetype":"ARC","doctypename":"Nota de Credito A-0001",
   "doctypeprintname":"Nota de Credito A","documentno":"A000100000018","puntodeventa":1,"numerocomprobante":18,
   "letra":"A","dateinvoiced":"2026-03-16","dateacct":"2026-03-16","duedate":"2026-03-17","c_currency_id":118,
   "iso_code":"ARS","signo":-1,"grandtotal":-60500.00,"dueamt":-60500.00,"paidamt":0.00,"openamt":-60500.00,
   "salesrep_id":1010717,"c_paymentterm_id":1010083,"paymentrule":"P"}
]
```

La segunda fila es una nota de crédito: **todos** sus importes son negativos (sección 3).

---

## 2. Qué filas vienen

Una lista plana. Cada fila es una de cuatro clases, según `rowtype`:

| `rowtype` | Qué es | `doc_id` es |
|---|---|---|
| `invoice` | Factura (o NC/ND) **sin cuotas válidas**, con saldo | `c_invoice_id` |
| `installment` | **Una cuota** con saldo de una factura con cuotas válidas. Una factura en 3 cuotas con la primera paga trae 2 filas | `c_invoice_id` (la cuota va en `c_invoicepayschedule_id`) |
| `payment` | Cobro (o pago, si la entidad también es proveedor) **sin imputar** | `c_payment_id` |
| `cashline` | Línea de caja **sin imputar** | `c_cashline_id` |

- Solo documentos en estado **`CO`, `CL` o `WC`**. Los anulados (`VO`) no vienen nunca, aunque tengan un resto de
  saldo.
- Solo lo que tiene saldo distinto de cero. Lo que está totalmente imputado no viene.
- **Ventas y compras.** Si la entidad también es proveedor, vienen sus facturas de compra y los pagos que se le
  hicieron, con el signo contrario. Se distinguen por `issotrx` (y por `docbasetype`: `API`/`APC`/`APP`).
- **La entidad no se filtra por activa ni por "es cliente".** Desactivar una entidad no esconde su deuda.
- **Agrupar por comprobante:** las cuotas de una factura comparten `doc_id`. Ojo: los ids de tablas distintas
  pueden coincidir (una factura y un cobro con el mismo número de id); la clave de una fila es
  `(rowtype, doc_id, c_invoicepayschedule_id)`.
- Las líneas de caja sin entidad propia (ventas de contado por libro de caja) se atribuyen a la entidad de la
  factura de la línea.

---

## 3. Importes y signos

| Campo | Qué es |
|---|---|
| `signo` | `1` o `-1`. El signo del tipo de documento (`signo_issotrx`). En las líneas de caja: `1` si sale dinero, `-1` si entra |
| `grandtotal` | Total del comprobante. Factura: su total. Cobro/pago: el importe, con su signo. Línea de caja: el importe |
| `dueamt` | Importe de la cuota. Solo en `installment` |
| `paidamt` | Lo imputado. En las cuotas es **`dueamt − openamt`** |
| `openamt` | **El saldo**, calculado por Libertya |

- **Todos los importes de una fila vienen multiplicados por `signo`.** Positivo es deuda de la entidad; negativo,
  saldo a su favor. Una NC tiene total, cuota, pagado y saldo negativos; un cobro a cuenta, también.
- **Un cobro con importe negativo invierte toda su fila.** Es el contra-movimiento que genera una boleta de depósito
  de cheques: sale con total y saldo positivos, y suele venir de a par con el ingreso de la misma boleta, que es
  negativo. Los dos se cancelan.
- En cobros, pagos y líneas de caja, `grandtotal = paidamt + openamt`. Con imputaciones en otra moneda podría
  diferir en centavos: Libertya convierte lo pagado y el saldo por separado.
- **Saldo de la entidad:** la suma de `openamt` de todas las filas (por moneda).
- **En las cuotas, `dueamt = paidamt + openamt` exacto.** Lo pagado de cada cuota no existe en la base: se deriva
  del saldo que calcula Libertya. Si se necesita el saldo de una cuota como `importe − pagado`, da `openamt`.
- La suma de `openamt` de las cuotas de una factura es el saldo de la factura, siempre que sus cuotas válidas sumen
  el total de la factura.
- **En la moneda del comprobante** (`c_currency_id`, `iso_code`), sin convertir. Los importes no se redondean más
  allá de lo que redondea Libertya (la precisión de la moneda en el saldo).
- Un saldo puede tener el signo contrario al del comprobante si se le imputó de más.

---

## 4. Fechas y demás campos

| Campo | Qué es |
|---|---|
| `dateinvoiced` | Factura: fecha de facturación. Cobro/pago: fecha de la transacción. Línea de caja: fecha del extracto |
| `dateacct` | Fecha contable |
| `duedate` | Factura sin cuotas: vencimiento según el término de pago (contempla los de día fijo). Cuota: su vencimiento. No viene en cobros, pagos ni líneas de caja |
| `installmentno`, `installmentcount` | Número de la cuota y cantidad de cuotas válidas de la factura. La numeración se hace sobre todas las cuotas válidas, ordenadas por vencimiento: la cuota 2 sigue siendo la 2 aunque la 1 esté paga |
| `documentno` | Número de documento. En las líneas de caja, `<nombre de la caja> / <línea>` |
| `puntodeventa`, `numerocomprobante`, `letra` | Solo facturas. `letra` es la letra, no el id |
| `c_doctype_id`, `doctypekey`, `docbasetype`, `doctypename`, `doctypeprintname` | Tipo de documento. En las líneas de caja, el tipo de libro de caja (`CMC`) de la compañía |
| `issotrx` | Factura: venta (`true`) o compra. Cobro/pago: cobro (`true`) o pago. Línea de caja: entrada de dinero (`true`) |
| `salesrep_id`, `c_paymentterm_id`, `paymentrule`, `c_order_id` | Solo facturas: vendedor, término y forma de pago, pedido |

- **Fechas como `yyyy-MM-dd`**, sin hora. (El resto de la API manda `2026-10-01 00:00:00.0`; acá no.)
- **Un campo sin valor no viene en la fila**, no viene como `null` (la API está configurada así). Por ejemplo, un
  cobro no trae `duedate` ni `dueamt`. Leer los campos opcionales con un valor por defecto.

---

## 5. Orden estable: se puede calcular un hash

Las filas vienen ordenadas por `dateacct, doc_id, installmentno, rowtype`, y las claves de cada fila en un orden
fijo (el de las tablas de arriba). **Sin cambios en la base, dos llamadas devuelven exactamente el mismo cuerpo**,
también después de reiniciar la API. Sirve para detectar si cambió la cuenta de una entidad con un hash sobre la
respuesta, sin comparar campo por campo.

Lo que cambia la respuesta: una factura, cobro o línea de caja nueva, una imputación nueva o anulada, y que un
comprobante quede saldado. Ojo: una imputación **no** cambia `c_invoice.updated`, así que mirar `updated` de las
facturas no alcanza para saber si cambió el saldo.

La respuesta no incluye nada que dependa de la fecha del día (días de atraso, importes convertidos a la cotización
de hoy).

> Si dos cuotas válidas de una misma factura vencen el mismo día, Libertya reparte lo imputado entre ellas sin un
> criterio de desempate, y el reparto entre esas dos cuotas podría variar entre llamadas.

---

## 6. Parámetros, seguridad y errores

| Parámetro | Dónde | Obligatorio | Qué hace |
|---|---|---|---|
| `id` | path | sí | `c_bpartner_id` |
| `ad_org_id` | query | no | Solo las filas de esa organización. Sin él, todas las que el rol puede ver. El saldo de cada comprobante no depende de este filtro |

No pagina: devuelve todas las filas con saldo de la entidad.

| Respuesta | Cuándo |
|---|---|
| `200` | Lista de filas, o `[]` si no hay nada con saldo |
| `401` | La entidad es de otra compañía, el rol no la ve, o **el rol no puede leer facturas, cobros o líneas de caja**. El mensaje va en el cuerpo |
| `403` | Sin token o token inválido |
| `404` | La entidad no existe |
| `409` | Error al calcular. El mensaje va en el cuerpo |

- La entidad se valida igual que en `GET /v1.0/bpartners/{id}`.
- **El rol del usuario del token tiene que poder leer `C_Invoice`, `C_Payment` y `C_CashLine`.** Si no puede leer
  alguna, la llamada entera responde `401`: no se devuelve un estado de cuenta sin una de sus partes, porque daría
  un saldo equivocado.
- Si el rol está limitado a algunas organizaciones, solo vienen las filas de esas organizaciones (y lo mismo con
  las restricciones por registro del rol).
- La respuesta es JSON: un `Accept` que solo admita `text/plain` recibe `406`.

---

## 7. Rendimiento

El costo depende de **cuántos comprobantes tuvo la entidad en total**, no de cuántos tiene con saldo: Libertya no
guarda qué facturas están pagas, así que para encontrar las que tienen saldo hay que calcularlo en todas. Como
referencia, una entidad con unas 520 facturas tarda alrededor de 0,5 s. Para sincronizar muchas entidades,
conviene llamar de a una y no en paralelo masivo.

---

## 8. Diferencias con el informe *Estado de Cuenta*

Las filas, cuotas, vencimientos, pagado y saldo coinciden con los del informe (para clientes, saldo pendiente, sin
filtros), salvo:

- no trae las filas de totales;
- **no trae documentos anulados (`VO`)**; algunas versiones del informe muestran facturas de venta anuladas con
  resto de saldo;
- **el total de una NC es negativo**; en el informe sale positivo;
- **el total de un cobro con importe negativo** (contra-movimiento de una boleta de depósito) tiene el mismo signo
  que su saldo; en el informe sale en valor absoluto, con el signo contrario;
- trae también las entidades que no están marcadas como cliente (por ejemplo, solo proveedores);
- el vencimiento de una factura sin cuotas con término de día fijo (por ejemplo "30 días, día 25") sale del término
  de pago; el informe suma los días netos;
- en las líneas de caja trae `issotrx` y un `documentno` legible, y atribuye a la entidad de la factura las líneas
  sin entidad propia.
