# Plan: endpoint de estado de cuenta por cliente

> Estado al 2026-11-13: **implementado** en la rama `estado-de-cuenta` y validado contra `libertya_qa`; qué cambió
> respecto de este plan y la evidencia de la validación están en §11. Quedan las verificaciones en
> `libertya_preprod` de §8. Lo necesita el integrador (canal Kiri) para la cuenta corriente. Se escribió desde la
> sesión del integrador, con lo investigado entre el 2026-11-05 y el 2026-11-13. El mismo 2026-11-13 se revisó en
> este repo, contra el código de los dos cores, las funciones de la base y las bases locales; las decisiones de esa
> revisión están en §3.1. Guía de uso: [`estado-de-cuenta-api.md`](../referencia/estado-de-cuenta-api.md).

## 1. Para qué

El integrador (`../../../integrador`) sincroniza datos de Libertya hacia Kiri, la plataforma de
ventas que va a usar Tehuelche (pedidos y cobranzas de los vendedores, alta de clientes desde la
web). Los maestros 17 y 18 de la integración son la **cuenta corriente**: los comprobantes
pendientes de cada cliente, con sus cuotas y vencimientos. Kiri los muestra en la app, y las
cobranzas que se hagan desde Kiri imputan contra esos comprobantes.

El integrador va a tratar **la cuenta de un cliente como una unidad**. Lee la cuenta, calcula un hash
y, si cambió, en Kiri da de baja todos los comprobantes del cliente y los vuelve a cargar. Para eso
necesita una sola llamada que devuelva, para un cliente, todo lo que tiene saldo, con el saldo de
cada comprobante y de cada cuota **calculado por Libertya**.

## 2. El problema

- **`/v1.0/invoices` no alcanza.** Trae número de documento, punto de venta, número, letra (como
  id), tipo de documento (como id), fechas, total, moneda, vendedor, organización y término de
  pago, pero **no trae el saldo, ni el vencimiento, ni las cuotas**.
- **`ispaid` no sirve como saldo.** En sursoftware, el 2026-11-13, de las 619 facturas de venta en
  `CO`/`CL` con `invoiceopen(c_invoice_id, 0) <> 0`, 524 tienen `ispaid = true`. Antes ya se había
  visto que no coincide en 25 de 169 facturas.
- **Libertya no guarda el saldo: lo calcula.** Las imputaciones (`C_AllocationLine`) se aplican a la
  factura entera, no a una cuota. La función `invoiceopen(factura, cuota)` calcula el saldo como el
  total menos lo imputado; para una cuota, reparte lo imputado entre las cuotas por orden de
  vencimiento. **Lo pagado por cuota no existe en la base**: sale de ese reparto.
- Sumar las imputaciones desde afuera (`/v1.0/allocationlines`) sería copiar la lógica de
  `invoiceopen` en el integrador. Eso es justo lo que no se quiere.

Detalle y números de Tehuelche: [I18 en incompatibilidades.md](../../../integrador/docs/kiri/incompatibilidades.md#i18-cuenta-corriente-sin-saldo-por-comprobante-y-sin-centavos).

## 3. Qué dijo Ignacio y qué se decidió

- **Ignacio (2026-11-11), sobre I18:** *"Esto hace el informe de Estado de Cuenta. Obtenerlo de
  ahí."*
- **Nota de Julian:** *"El informe es EstadoDeCuentaProcess y saca el saldo con invoiceopen.
  Deberíamos generar un endpoint nuevo en lyrestapi."*
- **Opciones evaluadas el 2026-11-11:**

| Opción | Qué es | Por qué sí o por qué no |
|---|---|---|
| **B (elegida)** | Endpoint nuevo, de solo lectura, con la consulta del informe para un cliente | Una sola llamada; el saldo de cada cuota lo calcula Libertya; no se copia lógica; es lo que pidió Ignacio. Estimado: 2 a 4 días |
| A | Un campo de saldo en `/v1.0/invoices` y las cuotas por el genérico (`C_InvoicePaySchedule`) | Medio día a un día, pero el integrador tendría que copiar el reparto de lo pagado entre las cuotas |
| Descartada | Ejecutar el proceso con `/v1.0/processes/{id}/execute` | Escribe en `T_EstadoDeCuenta` en cada llamada |
| Descartada | Columna virtual en `C_Invoice` | Cambia el diccionario del ERP productivo |

### 3.1 Revisión en lyrestapi (2026-11-13)

Se contrastó el plan con `EstadoDeCuentaProcess` de los dos cores, con el código de las funciones de la base y con
`main` (incluidas las mejoras de seguridad de `58c6421`). El enfoque es viable y no usa ninguna API nueva del
core. Decisiones, acordadas con Julian:

| # | Tema | Decisión | Detalle |
|---|---|---|---|
| R1 | Signos | Todos los importes de una fila salen de la tabla base y se multiplican por `signo_issotrx`. El total no se toma de `rv_c_invoice` | §4, §5.2 |
| R2 | Estados | `CO/CL/WC` en todas las partes y en todas las instalaciones, sin parámetro. No se incluye `VO`, aunque el core público lo haga | §4 |
| R3 | Seguridad | Las mismas piezas que el resto de la API: el socio se valida como en `GET /bpartners/{id}` y cada parte se filtra con `filterByRole` | §7.2 |
| R4 | Lo pagado por cuota | `paidamt = dueamt − openamt` | §5.2 |
| R5 | Rendimiento | Se mide por el historial total del cliente, no por sus facturas con saldo | §7.4 |
| R6 | Contrato y stubs | Tag `bpartner`; de `genClasses.sh` se corre solo el bloque de swagger-codegen | §7.1 |
| R7 | Detalles | Vencimiento con `paymenttermduedate()`, socio inactivo, fechas `yyyy-MM-dd`, partes 3 y 4 | §5 |

## 4. Qué hace hoy el informe de Estado de Cuenta

**Código:** `org.openXpertya.process.EstadoDeCuentaProcess`.
- Core de Tehuelche: [`libertya-core-teh/.../EstadoDeCuentaProcess.java`](../../../libertya-core-teh/base/src/org/openXpertya/process/EstadoDeCuentaProcess.java), 776 líneas.
- Core público: [`libertya/.../EstadoDeCuentaProcess.java`](../../../libertya/base/src/org/openXpertya/process/EstadoDeCuentaProcess.java), 826 líneas.
- En Tehuelche es el proceso `1000179`.
- **sursoftware corre el core público**, no el de Tehuelche.

**Cómo funciona.** No hay una consulta guardada que se pueda reusar.
1. Recorre los clientes activos del `ad_client_id` (`isCustomer = 'Y'` si el tipo de cuenta es `C`).
2. Por cada uno arma un SQL concatenando strings (`fillTable()`) que une **cuatro partes** con
   `UNION`.
3. Inserta cada fila en `T_EstadoDeCuenta` y después agrega filas de totales.

**Parámetros que importan y cómo los tiene que fijar el endpoint:**

| Parámetro | En el informe | En el endpoint |
|---|---|---|
| `accountType` | `C` (clientes) o `V` (proveedores). Define `isCustomer`/`isVendor` y el signo | Fijo en `C` |
| `ShowDocuments` | `O` saldo pendiente, `D` por fechas, `X` por fechas solo abiertos | Fijo en `O`: solo lo que tiene saldo |
| `C_BPartner_ID` | Opcional | Obligatorio |
| `AD_Org_ID` | Opcional. Solo filtra qué filas se listan: el saldo no depende de la organización | Opcional (ver §6, D2) |
| `daysdue` / `DateToDays` | Rango de días de vencimiento | Sin filtro: todo |
| `DateAcct` (hasta) | Fecha de corte de las funciones (`getDateToInlineQuery()`) | Siempre `now` |
| `Condition` | Filtra por `paymentrule` (contado, cuenta corriente…) | Sin filtro. Se devuelve `paymentrule` |
| `SalesRep_ID`, `C_BP_Group_ID`, `C_Currency_ID` | Filtros | Sin filtro |

**Las cuatro partes del SQL:**

| # | Qué | Origen | Saldo | Pagado |
|---|---|---|---|---|
| 1 | Facturas **sin** cuotas válidas (`ispayschedulevalid <> 'Y'`) | `rv_c_invoice` + `c_paymentterm` + `c_doctype` | `invoiceopen(i, 0, moneda, tipo_conv, corte)` | `getallocatedamt(i, moneda, tipo_conv, 1, corte)` |
| 2 | Una fila **por cuota** de las facturas con cuotas válidas (`ips.isvalid = 'Y'`) | `rv_c_invoice` (en línea, recortada) + `c_invoicepayschedule` | `invoiceopen(i, ips, moneda, tipo_conv, corte)` | `getallocatedamt(i, moneda, tipo_conv, 1, corte, ips)` |
| 3 | Pagos sin imputar del socio: cobros (pagos a cuenta) y, si el socio también es proveedor, pagos que se le hicieron (`APP`) | `c_payment` | `paymentavailable(p, corte)` | `paymentallocated(p, moneda, corte)` |
| 4 | Líneas de caja sin imputar | `c_cashline` + `c_cash` (inline de `V_DOCUMENTS`; tipo de documento con `doctypekey = 'CMC'`) | `cashlineavailable(cl, corte)` | `abs(amount) − abs(saldo)` |

Detalles que hay que respetar:

- **Saldo distinto de cero:**
  - Parte 1: `invoiceopen(i, 0, corte) <> 0`.
  - Parte 2: además `invoiceopen(i, ips, corte) <> 0`, así que las cuotas pagadas no aparecen.
  - Partes 3 y 4: `paymentavailable(…) <> 0` y `cashlineavailable(…) <> 0`.
- **Estados:** `getDocStatusWhereClause()` = `docstatus IN ('CO','CL','WC')`. En el core público, las
  facturas usan otra cláusula (`getInvoicesStatusWhereClause`): las de venta también admiten `VO`.
  La parte 4 filtra después con `docstatus IN ('CO','CL','WC')`.
  - **Decisión (R2):** el endpoint usa `CO/CL/WC` en las cuatro partes, como el core de Tehuelche. Como la
    consulta es propia, no depende del core instalado: filtra igual en sursoftware que en Tehuelche. `WC` no
    aparece en los datos de sursoftware, así que en la práctica es `CO/CL`.
  - **Por qué no `VO`:** en `libertya_qa`, que es una copia de los datos de sursoftware (§8), hay 9 NC de venta
    anuladas con saldo distinto de cero (clientes 1012407, 1012432, 1013265 y 1013152). Son restos de la
    anulación, no crédito real del cliente. El informe de sursoftware las muestra como saldo a favor, por
    ejemplo −141.194,47 para 1012432. **Hay que avisarle a Ignacio.**
- **Vencimiento:**
  - Factura sin cuotas: `dateinvoiced + netdays` del término de pago. No contempla los términos con
    vencimiento fijo (`isduefixed`): el endpoint usa `paymenttermduedate()` (§5.2).
  - Cuota: `ips.duedate`, que la parte 2 también usa como `datedoc`.
- **El informe NO separa ventas de compras.** Con `accountType = C` filtra el cliente por
  `isCustomer = 'Y'`, pero no filtra `issotrx`. Si el cliente también es proveedor, sus facturas de
  compra entran con el signo contrario, y en la parte 3 entran los pagos que se le hicieron. En Tehuelche
  hay 102 clientes activos que también son proveedores; en `libertya_qa`, 8 clientes tienen facturas de
  compra abiertas.
- **Signo (verificado el 2026-11-13):** cada importe se multiplica por
  `realSign = signoTipoCuenta (C = 1) × dt.signo_issotrx`.
  - `invoiceopen` devuelve `abs(total) − abs(imputado)`: es **positivo también para una NC**. Solo sería
    negativo si `c_invoice.grandtotal < 0`. `getallocatedamt` también devuelve positivo.
  - `signo_issotrx` por tipo de documento: `ARI` +1, `ARC` −1, `ARF` +1, `ARR` −1 (salvo `CRR`, +1),
    `API` −1, `APC` +1, `CMC` +1. En las líneas de caja el signo lo calcula la consulta: +1 si
    `amount < 0`, −1 si no.
  - Por eso el **saldo** de una NC sale negativo, que es lo correcto.
  - El **total** sale mal. El informe lo toma de `rv_c_invoice` (o de su versión en línea), que ya niega
    `grandtotal` cuando la tercera letra de `docbasetype` es `C`. Multiplicado por −1 queda positivo, así que
    una NC tiene total positivo y saldo negativo. El endpoint no copia eso (R1, §5.2).
- **Moneda:** cada importe sale en dos versiones:
  - en la moneda del comprobante (columnas `…multicurrency`);
  - convertido a la moneda de la compañía (`MClientInfo.getC_Currency_ID()`), con `currencybase` /
    `currencyConvert`, y el saldo se recalcula con la cotización a la fecha de corte.
- **Parte 4, tal como la hace el informe:**
  - `V_DOCUMENTS` calcula `issotrx` (`'Y'` si `amount >= 0`), pero la consulta exterior lo pisa con `''`,
    así que en `T_EstadoDeCuenta` siempre queda en falso.
  - El `LEFT JOIN c_bpartner` más el filtro `bp.isCustomer = 'Y'` dejan sin efecto los otros caminos
    (socio de la factura o de la imputación): en la práctica solo entran las líneas con
    `cl.c_bpartner_id` igual al socio. Así quedan afuera las ventas en efectivo por Libro de Caja, que no tienen
    socio propio; el endpoint lo toma de la factura de la línea (§5.2). En `libertya_qa` hay 34 líneas así,
    todas imputadas, así que hoy no cambia ninguna fila.
  - `documentno` es `'@line@' || line`, una etiqueta que traduce la interfaz de Libertya.
  - El tipo de documento `CMC` se une solo por `ad_client_id`. En las bases locales hay uno por
    compañía; si hubiera dos, las filas se duplicarían.
- **Lo que el endpoint no tiene que copiar:**
  - las filas de totales (`TOTAL`, `TOTAL <ISO>`, `TOTAL GENERAL`);
  - el total de `CHEQUES CARTERA`, que es informativo y no es parte del saldo;
  - la escritura en `T_EstadoDeCuenta`;
  - el total tomado de `rv_c_invoice`, por la doble negación de las NC;
  - **la concatenación de parámetros en el SQL**: el endpoint usa parámetros ligados (`?`).

**Diferencias entre los dos cores** (diff del 2026-11-13):
- el público agrega el filtro `FilterInternalEC`;
- el público admite convertir a la fecha del documento (`CurrentAccountQuery`);
- el público usa la cláusula de estados de facturas con `VO`.

La consulta del endpoint es SQL propio, así que no depende de la clase del proceso. Sí depende de
las **funciones de la base** (§7.3).

## 5. Contrato propuesto

### 5.1 Ruta y parámetros

`GET /v1.0/bpartners/{id}/accountstatement`, con tag `bpartner` y `operationId` `getBPartnerAccountStatement`
(R6).

Es un subrecurso de solo lectura, como `/v1.0/invoices/{id}/print`.

| Parámetro | Dónde | Obligatorio | Qué hace |
|---|---|---|---|
| `id` | path | sí | `c_bpartner_id`. Se valida igual que en `GET /v1.0/bpartners/{id}`: si no existe, 404; si es de otra compañía o el rol no lo ve, 401 (§7.2) |
| `ad_org_id` | query | no | Limita las filas a esa organización. Sin él, todas |

Respuesta: `200` con una **lista plana**, una fila por cada partida con saldo (la misma
granularidad que el informe). Si el cliente no tiene saldo, `[]`. Los errores son los del resto de la API:
`401`, `404` y `409` con el mensaje en el cuerpo.

**Por qué plana y no anidada (comprobante → cuotas):**
- es una sola consulta, sin armar objetos;
- se valida fila por fila contra el informe;
- el integrador agrupa por `doc_id`.

**Socio inactivo o que no es cliente (R7):** se devuelve igual lo que tenga saldo; no se filtra por
`bp.isActive` ni por `bp.isCustomer`. El informe solo recorre socios activos con `isCustomer = 'Y'`, pero
desactivar un cliente no debería esconder su deuda. Si el socio es solo proveedor, salen sus comprobantes de
compra, que se distinguen por `issotrx`.

### 5.2 Campos de cada fila

| Campo | Tipo | Partes | Origen / regla |
|---|---|---|---|
| `rowtype` | string | todas | `invoice` (parte 1), `installment` (2), `payment` (3), `cashline` (4) |
| `doc_id` | int | todas | `c_invoice_id`, `c_payment_id` o `c_cashline_id` |
| `c_invoicepayschedule_id` | int / null | 2 | null fuera de la parte 2 |
| `installmentno` | int / null | 2 | Número de la cuota: `row_number()` sobre las cuotas **válidas** de la factura, ordenadas por `duedate` y después por `c_invoicepayschedule_id`. Se calcula **antes** de filtrar las cuotas pagadas, para que la cuota 2 siga siendo la 2 aunque la 1 ya esté paga |
| `installmentcount` | int / null | 2 | Cantidad de cuotas válidas de la factura |
| `c_bpartner_id`, `ad_org_id` | int | todas | En la parte 4 el socio es `COALESCE(cl.c_bpartner_id, socio de la factura de la línea)`: las ventas en efectivo por Libro de Caja no tienen socio propio. Es el mismo criterio del fix OP#8206 del core `dev` (2026-11-12) en `c_alldocumentscc_v` |
| `issotrx` | boolean | todas | Factura: `i.issotrx`. Cobro: `p.isreceipt`. Caja: `amount >= 0`, la regla de `V_DOCUMENTS` (el informe la pierde: §4) |
| `c_doctype_id`, `doctypekey`, `docbasetype`, `doctypename`, `doctypeprintname` | | todas | De `c_doctype`. En la parte 4, el tipo `CMC` de la compañía, elegido de forma determinística si hubiera más de uno |
| `documentno` | string | todas | En la parte 4, `<c_cash.name> / <line>`. El informe usa `'@line@' || line` |
| `puntodeventa`, `numerocomprobante` | int / null | 1, 2 | De `c_invoice` |
| `letra` | string / null | 1, 2 | `c_letra_comprobante.letra` (la letra, no el id) |
| `dateinvoiced` | date | todas | Factura: `dateinvoiced`. Cobro: `datetrx`. Caja: `statementdate` |
| `dateacct` | date | todas | |
| `duedate` | date / null | 1, 2 | Parte 1: `paymenttermduedate(c_paymentterm_id, dateinvoiced)`, que da lo mismo que `dateinvoiced + netdays` salvo en los términos con vencimiento fijo. Parte 2: `ips.duedate` |
| `c_currency_id`, `iso_code` | | todas | Moneda del comprobante |
| `signo` | int | todas | `dt.signo_issotrx` (en la parte 4, el que calcula la consulta: §4) |
| `grandtotal` | decimal | todas | Total del comprobante × `signo`. Factura: `c_invoice.grandtotal`, **no** el de `rv_c_invoice`. Cobro: `abs(payamt)`. Caja: `abs(amount)` |
| `dueamt` | decimal / null | 2 | `ips.dueamt × signo`: importe de la cuota |
| `paidamt` | decimal | todas | Partes 1, 3 y 4: la función del informe × `signo`. Parte 2: `dueamt − openamt` (R4) |
| `openamt` | decimal | todas | Saldo, con la misma función que el informe, × `signo` |
| `salesrep_id` | int / null | 1, 2 | Vendedor de la factura |
| `c_paymentterm_id`, `paymentrule` | | 1, 2 | Para poder filtrar por condición |
| `c_order_id` | int / null | 1, 2 | |

**Signos (R1):** los importes van **como los muestra el informe para `accountType = C`**: positivo es
deuda del cliente y negativo es saldo a favor (notas de crédito, pagos a cuenta). Además se manda
`signo`, para que el integrador lo pueda verificar. A diferencia del informe, **todos los importes de una
fila llevan el mismo signo**: una NC tiene total, cuota, pagado y saldo negativos.

**Lo pagado por cuota (R4):** `invoiceopen` redondea a la precisión de la moneda y lleva a cero todo lo que
esté entre −0,01 y 0,01; `getallocatedamt` no redondea. Con imputaciones en otra moneda,
`dueamt − getallocatedamt(…, ips)` puede diferir de `openamt` en centavos. Como Kiri calcula el saldo como
`ia − pa`, en las cuotas se manda `paidamt = dueamt − openamt`. Es aritmética sobre el saldo que calcula
Libertya, no una copia del reparto. En las 15 cuotas abiertas de `libertya_qa` las dos formas dan lo mismo.

**Importes:** en la moneda del comprobante. `invoiceopen` ya redondea a la precisión de la moneda y el
endpoint no redondea nada más; Kiri admite decimales en la cuota. La conversión a la moneda de la compañía
no hace falta por ahora (D4). Si se agrega, va en campos aparte.

**Fechas (R7):** strings `yyyy-MM-dd`, sin hora. El resto de la API manda `Timestamp.toString()`
(`2026-10-01 00:00:00.0`), pero acá son fechas sin hora y el integrador las pasa a epoch.

**Orden estable (obligatorio):** `dateacct, doc_id, installmentno`. El integrador calcula un hash
sobre la respuesta para detectar cambios: dos llamadas sin cambios en la base tienen que devolver
exactamente lo mismo. El informe ordena solo por `bpartner, dateacct`, lo que no alcanza.
- Por lo mismo, la respuesta no lleva nada que dependa de la fecha del día: ni `daysdue` ni importes
  convertidos con la cotización de hoy.
- Ojo: `invoiceopen` y `getallocatedamt` reparten lo imputado con `ORDER BY DueDate`, sin desempate. Si dos
  cuotas válidas de una factura vencen el mismo día, el reparto puede cambiar entre llamadas. En las bases
  locales no hay ningún caso; hay que contarlos en `libertya_preprod` (§8).

### 5.3 Ejemplo (ilustrativo: los ids y los importes son inventados)

```json
[
  {
    "rowtype": "installment", "doc_id": 1099901, "c_invoicepayschedule_id": 1099902,
    "installmentno": 1, "installmentcount": 1,
    "c_bpartner_id": 1099903, "ad_org_id": 1010053, "issotrx": true,
    "c_doctype_id": 1010810, "doctypekey": "CIB0005", "docbasetype": "ARI",
    "doctypename": "Factura B-0005", "doctypeprintname": "Factura B",
    "documentno": "B000500000123", "puntodeventa": 5, "numerocomprobante": 123, "letra": "B",
    "dateinvoiced": "2026-10-01", "dateacct": "2026-10-01", "duedate": "2026-10-31",
    "c_currency_id": 118, "iso_code": "ARS", "signo": 1,
    "grandtotal": 15230.45, "dueamt": 15230.45, "paidamt": 5000.00, "openamt": 10230.45,
    "salesrep_id": 1099904, "c_paymentterm_id": 1099905, "paymentrule": "P", "c_order_id": null
  }
]
```

## 6. Decisiones abiertas: el endpoint no depende de ellas

Están en el [análisis del integrador](../../../integrador/docs/analisis/kiri-cuenta-corriente-sync.md#decisiones-abiertas).
Las tienen que contestar Ignacio y Kiri, y las preguntas todavía no se enviaron. El endpoint devuelve
todo lo necesario para que cada una se resuelva con un filtro en el integrador:

| # | Qué falta decidir | Qué devuelve el endpoint para no depender de eso |
|---|---|---|
| D1 | ¿Qué comprobantes van a Kiri? ¿Solo facturas y notas de débito, o también notas de crédito y pagos a cuenta? ¿Las facturas de retención? | Las 4 partes, con `rowtype`, `docbasetype`, `doctypekey` e `issotrx` |
| D2 | Con una sola sucursal integrada, ¿la cuenta del cliente en todas las sucursales o solo en esa? | `ad_org_id` en cada fila y el parámetro opcional `ad_org_id`. Ojo: si el rol del usuario de integración está limitado a algunas organizaciones, solo se ven las filas de esas (§7.2) |
| D3 | ¿Qué vendedor va en cada comprobante: el de la factura o el del cliente? | `salesrep_id` de la factura. El del cliente ya lo tiene el integrador |
| D4 | Comprobantes en dólares: excluir, convertir o mandar con moneda | `c_currency_id` e `iso_code`, con los importes en la moneda del comprobante |
| D5 | Endpoint nuevo o agregado a `/invoices` | Decidido: nuevo (este plan) |

## 7. Implementación en lyrestapi

### 7.1 Piezas

Sigue el patrón de [CLAUDE.md](../../CLAUDE.md#adding-a-new-entityendpoint), con dos diferencias: no es una
tabla, así que el esquema se escribe a mano y no sale de la base, y la consulta es propia en lugar de la
lógica genérica de `AbstractRepository`.

| Archivo | Nuevo / modificado | Qué |
|---|---|---|
| `src/main/resources/paths/bpartners_id_accountstatement.yaml` | nuevo | `GET`, tag `bpartner`, `operationId` `getBPartnerAccountStatement`, parámetros `id` y `ad_org_id`, respuestas 200/401/404/409 |
| `src/main/resources/model/accountstatementline.yaml` | nuevo, a mano | Schema `AccountStatementLine` (§5.2), referenciado desde el yaml del path |
| `src/main/resources/ly-rest-api.yaml` | modificado | La ruta `/v1.0/bpartners/{id}/accountstatement` |
| `stub/model/AccountStatementLine.java` | nuevo, generado | DTO de cada fila |
| `stub/iface/BpartnerApi.java` | modificado, generado | Suma el método `getBPartnerAccountStatement` |
| `repository/AccountStatementRepository.java` | nuevo | La consulta de las cuatro partes |
| `controller/BPartnerController.java` | modificado | Inyecta el repositorio nuevo e implementa el método |
| `src/test/java/org/libertya/api/AccountStatementIntegrationTests.java` | nuevo | Tests de §8 |
| `docs/referencia/estado-de-cuenta-api.md` | nuevo | Guía de uso para el integrador |
| `docs/README.md` | modificado | Filas de este plan y de la guía |

No hace falta service: el endpoint es de solo lectura, sin `Trx` y sin `save()`. Tampoco hace falta una
entrada en `docs/compatibilidad-core.md`: no se usa ninguna API nueva del core y las funciones de la base
existen (§7.3).

**Generación de stubs (R6).** No correr `utils/genClasses.sh` entero: en una máquina sin la base a la que
apunta `genSchema.sh`, deja vacíos todos los `model/*.yaml` (`docs/PENDIENTES.md` P2). Hay que correr solo el
bloque de swagger-codegen, con salida a un directorio temporal, y copiar `AccountStatementLine.java` y
`BpartnerApi.java`. Después, verificar con `git diff` que `BpartnerApi.java` solo suma el método nuevo y que
no cambió ningún otro archivo de `stub/`. Los stubs coinciden con los yaml desde la regeneración del
2026-09-21, así que no debería aparecer nada más.

**Por qué el tag `bpartner` y no uno propio.** El manual para desarrolladores pide respetar los tags para que
cada entidad se genere bajo su propia interfaz, y los subrecursos ya siguen esa regla: `/invoices/{id}/print`
está bajo `invoice`. Además, dos controllers no pueden implementar la misma interfaz generada, porque los
mapeos quedarían duplicados. Por eso el método va en `BPartnerController`, como `printInvoice` en
`InvoiceController`.

**Controller.** Delega en `retrieveAction` con un `Optional<List<AccountStatementLine>>`: si está vacío, 404;
`AuthException`, 401; `ModelException`, 409. No usa `retrieveAllAction`, porque el endpoint no pagina y ese
helper agrega encabezados `prev` y `next` que acá no significan nada.

**Repository.** `AccountStatementRepository extends AbstractRepository`, con `tableName = C_BPartner` e
`iface = BPartner::new`.
- Hereda `retrieve()` para validar el socio (§7.2) y `filterByRole()` para filtrar cada parte.
- Ejecuta la consulta con `DB.prepareStatement(sql, null)` y parámetros ligados, como
  `CouponsSettlementsRepository`.
- Los enteros que pueden venir nulos se leen con `getObject`, no con `getInt`, que convierte null en 0.
- La fecha de corte es `now()` en la propia consulta.

### 7.2 Seguridad (R3)

- **El socio** se valida con el `retrieve(info, id)` heredado, el mismo camino que `GET /v1.0/bpartners/{id}`.
  `ClientOrgAuth.validate` controla la compañía, la organización, el acceso a la tabla y las restricciones por
  registro. Si el socio no existe, la respuesta es 404; si es de otra compañía o el rol no lo ve, 401.
- **Cada parte** se filtra con `filterByRole(info, tabla)` sobre su tabla base: `C_Invoice`, `C_Payment` y
  `C_CashLine`. Esa cláusula ya aplica la compañía, las organizaciones del rol y las restricciones por
  registro (`bae6c00`, `351e3c5`, `58c6421`). Con un token sin rol, solo filtra por compañía.
- Las cláusulas de `filterByRole` usan nombres de columna sin alias (`AD_Org_ID IN (…)`), así que en una
  consulta con joins serían ambiguas. Van dentro de un subselect sobre la tabla base, por ejemplo
  `AND i.c_invoice_id IN (SELECT c_invoice_id FROM c_invoice WHERE <filterByRole>)`. Los informes nativos
  (`1c19ad4`) resolvieron lo mismo de otra forma: califican `AD_Client_ID` y `AD_Org_ID` con el nombre de la
  tabla. Acá no alcanza, porque `filterByRole` también trae las restricciones por registro, que pueden
  nombrar cualquier columna.
- Si el rol no puede leer una de esas tablas, la llamada entera responde 401. La parte no se omite en
  silencio, porque un estado de cuenta sin los cobros daría un saldo equivocado.
- **Para el integrador:** el rol del usuario con el que pide el token tiene que poder leer facturas, cobros y
  líneas de caja de las organizaciones que interesan.
- El `ad_client_id` es siempre el del token, como parámetro ligado. Ningún valor de la request se concatena
  en el SQL; lo único que se concatena son las cláusulas que arma `filterByRole` a partir del rol.

### 7.3 Funciones de la base

El informe llama a estas firmas, y el endpoint suma `paymenttermduedate`:
- `invoiceopen(int, int, timestamp)`;
- `invoiceopen(int, int, int, int, timestamp)`;
- `getallocatedamt(int, int, int, int, timestamp)`;
- `getallocatedamt(int, int, int, int, timestamp, int)`;
- `paymentavailable(int, timestamp)`;
- `paymentallocated(int, int, timestamp)`;
- `cashlineavailable(int, timestamp)`;
- `paymenttermduedate(int, timestamptz)`.

**Verificado el 2026-11-13:** todas existen en tres bases locales:
- `ly_core_teh`: diccionario de Tehuelche, `AD_System.Version` 16-11-2020;
- `libertya_rel_22ar_for_api_25`: 03-05-2022;
- `libertya_qa`: 08-05-2026.

**Cambios en el core `dev` posteriores a 26.09** (`data/core/upgrade_from_26.09/preinstall_from_26.09.sql`, revisado
el 2026-11-13): OP#8516 (2026-11-03/04) reescribió `paymentavailable`, `paymentallocated` y `getallocatedamt`
con las mismas firmas. Solo cambia el resultado de los pagos en moneda extranjera con tasa de cambio propia y
de las facturas de proveedor con tasa propia. El endpoint toma estas correcciones sin hacer nada, porque
llama a las funciones; es justamente la ventaja de que el saldo lo calcule Libertya. `EstadoDeCuentaProcess`
no cambió desde octubre. El equipo del core está trabajando sobre la cuenta corriente (OP#8206, OP#8516), así
que conviene que sepan que este endpoint depende de esas funciones.

Que un `grep` en los scripts de `data/` no las encontrara se debía al formato de los scripts. Falta solo
confirmarlo con `\df` en sursoftware y en `libertya_preprod` (con la VPN y solo lectura:
`PGOPTIONS='-c default_transaction_read_only=on'`). Si alguna faltara, se anota en `compatibilidad-core.md`.

### 7.4 Rendimiento (R5)

- **El costo depende del historial, no del saldo.** Libertya no guarda qué facturas están pagas, y `ispaid`
  no sirve (§2). Para encontrar las que tienen saldo, la consulta calcula `invoiceopen` sobre **todas** las
  facturas `CO/CL/WC` del cliente, también las pagadas hace años. Lo que importa es cuántas facturas tuvo el
  cliente en total, no cuántas tiene pendientes.
- **Medido el 2026-11-13 en `libertya_qa`:** las partes 1 y 2 para el cliente 1013152 (518 facturas en total,
  517 con saldo) tardan 0,3 s, unos 0,6 ms por factura. Extrapolando, un cliente con 10.000 facturas tardaría
  unos 6 s; es una estimación, no una medición.
- **En Tehuelche, antes de activar el cron:**
  - medir en `libertya_preprod` con el cliente que más facturas tenga entre los que van a Kiri;
  - confirmar que Consumidor Final, donde se acumulan los tickets del POS, no está entre los clientes que
    sincroniza el integrador.
- Una corrida del cron tarda la suma de las llamadas de todos los clientes sincronizados. Para el cron vale
  más que cada cliente sea rápido que tener una consulta masiva.
- Un endpoint de "clientes cuya cuenta cambió desde X" queda para después, si hace falta. Ojo: una
  imputación no cambia `C_Invoice.updated`.

### 7.5 Empaquetado y despliegue

- **Rama:** se trabaja en una rama creada desde `main` actualizado. `main` se mueve seguido, por ejemplo con los
  informes en PDF del 2026-11. Los archivos que pueden chocar son pocos: `BPartnerController`, `BpartnerApi`,
  `ly-rest-api.yaml` y `docs/README.md`.
- **Compilar con el core público `dev` de `/ServidorOXP/lib`.** Es el único con el que compila `main`
  (`docs/compatibilidad-core.md` §4). El 2026-11-13 ahí está `Versión 26.09 20261028-2019`, que pasa los
  chequeos 1 a 3 de §5. El endpoint no cambia esto: es SQL propio, y del core solo usa lo que `main` ya usa
  (`DB`, `MRole`, `M_Table` y la carga del socio). Después del build hay que confirmar que las clases nuevas
  no referencian nada que falte en el `OXP.jar` de Tehuelche: con `javap -c`, contra `/OXP-teh/OXP.jar`.
- **El jar:** `./gradlew bootJar`, no `build`, porque `build` corre la suite y hoy fallan 64 tests por datos. Sale
  en `build/libs/lyrestapi-1.0.0.jar`.
- **Configuración y base:** el endpoint no agrega propiedades (`@Value`), así que el `application.properties`
  desplegado sirve tal cual. Tampoco requiere cambios en la base.
- **JasperReports:** desde `208ff19` (2026-11), `libs/JasperReports-ngroovy.jar` va embebido en el jar
  (`implementation`), y CLAUDE.md todavía describe el esquema anterior (`compileOnly` más `loader.path`). No es
  parte de este endpoint, pero al empaquetar hay que confirmar cómo arranca el jar.
- **Por instalación:**
  - **sursoftware** (core público): es el entorno de pruebas y recibe un despliegue de Libertya `dev` en cada
    commit, así que su esquema acompaña al core `dev` con el que se compila. Su lyrestapi tiene unas semanas. Se
    despliega el jar con su core embebido. Opcional: regenerar `/ServidorOXP/lib` desde el `dev` del día antes
    del build final. Los cambios de Java posteriores al 28/10 (`VOrdenPagoModel`, `Doc_Invoice`) la API no los
    usa.
  - **Tehuelche:** el mismo jar, con el `OXP.jar.default` de la instalación primero en `loader.path`
    (`compatibilidad-core.md` §6.6 y §6.7), igual que el despliegue en preprod del 2026-11-05. El endpoint no
    cambia nada de ese procedimiento.
- **Antes de usarlo desde el integrador:** el rol del usuario de integración tiene que poder leer facturas,
  cobros y líneas de caja (§7.2).

## 8. Validación

**Contra el informe.** Para cada cliente de prueba, ejecutar el Estado de Cuenta en Libertya
(clientes, saldo pendiente, sin filtros) y comparar fila por fila: comprobante, cuota, vencimiento,
pagado y saldo. Tiene que coincidir todo, salvo estas diferencias esperadas:
- las filas de totales;
- las de compras, si el cliente también es proveedor;
- en sursoftware, que corre el core público, las facturas `VO` con saldo: el informe las muestra y el
  endpoint no (R2);
- el total de las NC, que en el informe sale positivo (R1);
- `issotrx` y `documentno` de las líneas de caja (§4);
- el vencimiento de las facturas sin cuotas con término de vencimiento fijo.

**Invariantes:**
- En una cuota, `dueamt = paidamt + openamt`. Vale por construcción (R4); además conviene comparar
  `paidamt` con `getallocatedamt(…, ips)`: una diferencia de centavos indica imputaciones en otra moneda.
- Para una factura con cuotas, la suma de `openamt` de sus filas es igual a `invoiceopen(i, 0)`, con signo.
- Dos llamadas seguidas devuelven el mismo JSON, byte a byte.
- Un cliente sin saldo devuelve `[]`.
- Un cliente inexistente devuelve 404; uno de otro `ad_client_id`, 401.

**`libertya_qa` (local): donde se desarrolla y valida.** Es una copia de los datos de sursoftware al
2026-06-28: los clientes de la tabla de abajo coinciden (1013152 con 517 facturas con saldo, 1012450 con 5 y
una NC, 1012465 con 2 en USD, 1013150 con 1 en USD de 8). Además tiene lo que sursoftware no:
- facturas abiertas en varias cuotas: clientes 1002050 y 1002128 (5 facturas, 15 cuotas);
- 35 cobros y 25 líneas de caja sin imputar;
- 8 clientes con facturas de compra abiertas;
- las 9 NC anuladas con saldo (R2).

Ojo: tiene las funciones de saldo anteriores a OP#8516 (§7.3), así que los casos en moneda extranjera se validan
en sursoftware, no acá.

Se usa levantando la API con `DB_NAME=libertya_qa`. La password de `AdminLibertya` en esa base no es la de
los tests, así que la suite no corre ahí.

**Tests de integración (`AccountStatementIntegrationTests`).** Corren contra
`libertya_rel_22ar_for_api_25`, la única base local donde autentican. Tiene 13 facturas de venta con saldo
de 5 clientes, sin cuotas múltiples ni NC. Alcanza para:
- los invariantes generales y el orden estable;
- `[]` para un cliente sin saldo;
- 404 para un id inexistente y 401 para un socio de otra compañía.

El cliente de prueba se elige por SQL, no con `DEFAULT_BPARTNER_ID`, que ya no existe en esa base. Las
cuotas múltiples y las NC se validan a mano contra `libertya_qa`.

**Clientes de prueba en sursoftware.** Medido el 2026-11-13 con GET a lyrestapi sobre
`/v1.0/invoices` y `/v1.0/payments`, ventas en `CO`/`CL` con saldo distinto de cero:

| Cliente | Para qué sirve | Qué tiene |
|---|---|---|
| 1012450 | Caso normal más nota de crédito (signos) | 5 facturas con saldo, 1 de ellas NC. Ya está en Kiri |
| 1013265 | Pagos a cuenta | 1 factura y 2 cobros sin imputar. Ya está en Kiri. También tiene NC anuladas con saldo (R2) |
| 1016724 | Caso normal | 7 facturas. Ya está en Kiri |
| 1013304 | Sin saldo: `[]` | 0 facturas. Ya está en Kiri |
| 1013152 | Rendimiento | 517 facturas. Ya está en Kiri. También tiene una NC anulada con saldo (R2) |
| 1012465, 1013150 | Dólares (`c_currency_id = 100`) | 2 facturas en USD, y 1 en USD de 8, respectivamente |
| 1012461 | Notas de crédito | 2 NC con saldo |

Totales en sursoftware:
- 619 facturas de venta con saldo, de 38 clientes, todas de la organización 1010053;
- 612 en ARS (118) y 7 en USD (100);
- 19 cobros sin imputar;
- 4 notas de crédito con saldo;
- **ninguna factura con más de una cuota válida**: el caso de varias cuotas se prueba en `libertya_qa`;
- todas tienen `ispayschedulevalid = 'Y'`, así que salen por la parte 2 (una fila por cuota).

En Tehuelche (base `libertya_preprod`, datos al 2026-08-18):
- las 2.647 facturas de venta a crédito con saldo del último año tienen cuotas válidas;
- las facturas en varias cuotas son casi todas de planes de empleados (4.775 de 6.726);
- hubo 2 facturas en dólares en el año.

Pendiente en `libertya_preprod` (solo lectura), antes de activar el cron:
- el `\df` de §7.3;
- la medición de rendimiento de §7.4;
- contar las facturas con dos cuotas válidas del mismo vencimiento (§5.2).

## 9. Qué hace el integrador con la respuesta (contexto)

No es trabajo de este repo, pero explica los campos. Kiri recibe `currentAccount`, un registro por
comprobante (guía de Kiri §9.7 y §10.9, esquema `CurrentAccountPost` del Swagger):

| Kiri | De la respuesta |
|---|---|
| `k` | `doc_id`. Si también van cobros o líneas de caja, hace falta algo (por ejemplo un prefijo por `rowtype`) para que no choquen ids de tablas distintas: a decidir en el integrador |
| `rk` | `documentno` |
| `c` | `c_bpartner_id` |
| `s` | A decidir (D3) |
| `dc`, `dd` | Código y nombre del tipo de documento. Qué código va en `dc` está sin decidir; `doctypekey` es el candidato |
| `do`, `dn`, `dt` | `puntodeventa` (con ceros a la izquierda), `numerocomprobante` y `letra` |
| `da` | `grandtotal`. La guía dice que Kiri lo redondea a entero; el Swagger muestra decimales. Se prueba aparte. En sursoftware, 576 de las 619 facturas tienen centavos |
| `tc`, `te` | `dateinvoiced` y `duedate` (epoch en ms) |
| `q` | Las cuotas: `{ "01": { k, ia: dueamt, pa: paidamt, qn: installmentno, te: duedate } }` |

Kiri **no tiene campo de saldo**: lo calcula con `ia − pa` de cada cuota. Por eso hacen falta
`dueamt` y `paidamt` de cada cuota, no solo el saldo, y por eso `paidamt` se deriva del saldo (R4).

## 10. Referencias

- Análisis de la cuenta corriente en el integrador:
  [`kiri-cuenta-corriente-sync.md`](../../../integrador/docs/analisis/kiri-cuenta-corriente-sync.md).
- Problema I18, con la investigación del 2026-11-11:
  [`incompatibilidades.md`](../../../integrador/docs/kiri/incompatibilidades.md#i18-cuenta-corriente-sin-saldo-por-comprobante-y-sin-centavos).
- Contrato de Kiri:
  - [guía](../../../integrador/docs/kiri/GUIA_INTEGRACION_ERP_KIRI.html), §9.7 y §10.9;
  - [Swagger](../../../integrador/docs/kiri/API_DOCUMENTATION.yaml), `CurrentAccountPost`.
- Estado del proyecto Kiri:
  [`docs/kiri/README.md`](../../../integrador/docs/kiri/README.md).
- En este repo:
  - generación de stubs y tags: [manual para desarrolladores](../referencia/Libertya%20REST%20API%20-%20Manual%20para%20desarrolladores.md)
    y [`PENDIENTES.md`](../PENDIENTES.md) P2;
  - restricciones de acceso del rol: `AbstractRepository.filterByRole`, `ClientOrgAuth`, `RecordAccessFilter`.

## 11. Implementación (2026-11-13): qué cambió respecto del plan

Implementado en la rama `estado-de-cuenta`, creada desde `main` en `af7a0dc`. Las decisiones R1 a R7 se
respetaron tal cual. Las piezas son las de §7.1, más `config/AccountStatementJsonConfig.java` (§11.1, punto 2).

### 11.1 Cambios y agregados

1. **Las respuestas de error del yaml no declaran `content`.** Con `text/plain`, el método generado producía
   `application/json` y `text/plain`; un cliente que pide `Accept: text/plain, application/json` (lo hace
   `TestRestTemplate`) recibía 500, porque Spring elegía `text/plain` y no puede escribir una lista ahí. Con curl
   (`Accept: */*`) no se veía. Ahora produce solo `application/json`, como los demás GET que devuelven JSON
   (`tabs_id_records.yaml`). El mensaje de error sigue viajando en el cuerpo; un `Accept: text/plain` solo da 406.
2. **Mixin de Jackson para `AccountStatementLine`.** Los DTO generados serializan, además de `c_bpartner_id`, una
   clave `cbpartnerId` derivada del getter `getCBpartnerId()`, y lo mismo con cada campo `c_xxx_id`. Pasa en toda la
   API (`/invoices` también). El problema para este endpoint es que **el orden de esas claves cambia en cada
   arranque de la JVM**: dentro de un proceso la respuesta es estable, pero después de reiniciar la API cambian los
   bytes y el hash del integrador cambiaría para todos los clientes. Como el stub no se edita a mano,
   `AccountStatementJsonConfig` registra un mixin solo para este DTO: ignora los getters y fija el orden de las claves
   en el de §5.2. Verificado con tres arranques: mismo cuerpo byte a byte, mientras `/invoices` cambia en cada uno.
   Ver `PENDIENTES.md` P7.
3. **Los campos sin valor no viajan.** `application.properties` tiene `spring.jackson.default-property-inclusion =
   NON_NULL`, así que un campo null se omite en lugar de viajar como `null` (el ejemplo de §5.3 muestra
   `"c_order_id": null`). Es lo mismo que en el resto de la API; la guía lo aclara.
4. **Orden:** se agregó `rowtype` como último criterio (`dateacct, doc_id, installmentno, rowtype`), porque los ids
   de tablas distintas pueden coincidir. `dateacct` también sale como `yyyy-MM-dd`.
5. **Token de compañía 0:** para el resto de la API ve todas las compañías (`filterByClient`). La consulta usa la
   compañía del token y, si es 0, la del socio ya validado, para no devolver `[]` en silencio.
6. **Parte 4:** el tipo `CMC` y la moneda van con `LEFT JOIN` (el `CMC` de menor id, si hubiera más de uno), para
   que una compañía sin tipo `CMC` no pierda sus líneas de caja. El filtro del rol va en el mismo subselect que
   elige las líneas del socio (las propias más las sin socio cuya factura es del socio), y en las partes 1 a 3 el
   subselect del rol también filtra por socio: así ninguna parte recorre la tabla entera de la compañía, sea cual
   sea el plan de ejecución.

7. **El total de un cobro es `payamt` con su signo, no `abs(payamt)`** (corrección del 2026-11-13, después de la
   prueba en sursoftware). El plan (§5.2) copiaba el `abs()` del informe. En un cobro con `payamt` negativo, el
   contra-movimiento que genera una boleta de depósito de cheques, el `abs()` le sacaba el signo al total pero no al
   saldo, porque `paymentavailable` devuelve el saldo con el signo de `payamt`: en el cliente 1012420 de sursoftware
   quedaba total −50.000 con saldo +50.000. Sin el `abs()` los tres importes tienen el mismo signo y
   `grandtotal = paidamt + openamt`, también si el cobro negativo estuviera imputado en parte: las imputaciones a
   un cobro negativo también son negativas (24 casos en `libertya_qa`, todos de cobros anulados, que el endpoint no
   muestra). Aplica R1: todos los importes salen de la tabla base. Es una diferencia más con el informe. Los saldos
   no cambian. En las bases locales los únicos cobros negativos con saldo son tres contra-movimientos, y sus filas
   son las únicas que cambiaron.

No hace falta entrada en `compatibilidad-core.md`: las clases nuevas solo referencian `X_C_BPartner`,
`X_C_Invoice`, `X_C_Payment`, `X_C_CashLine` (`Table_Name`) y `DB.prepareStatement(String, String)`, presentes en
`/ServidorOXP/lib/OXP.jar` y en `/OXP-teh/OXP.jar` (verificado con `javap`).

### 11.2 Validación contra `libertya_qa`

**Contra el informe.** Correr `EstadoDeCuentaProcess` escribe en `T_EstadoDeCuenta`, así que se comparó contra una
reproducción de solo lectura del SQL de `fillTable()` del core público (cuenta `C`, saldo pendiente, sin filtros),
con las cláusulas `FROM`/`WHERE` copiadas del código:

- **Compañía 1010016, por HTTP:** 68 socios (todos los que tienen algún documento), 730 filas del endpoint contra 673
  del informe. Las 80 diferencias son todas esperadas: 65 filas solo en el endpoint, de 17 socios que son solo
  proveedores (R7); 8 solo en el informe, facturas `VO` (R2); 5 `grandtotal` de NC (R1); y 2 `grandtotal` de
  contra-movimientos de boletas de depósito (§11.1, punto 7). Pagado, saldo, vencimiento, fecha contable y
  organización coinciden en todas las demás. En las 54 filas de cobros y líneas de caja (en ARS y en USD),
  `grandtotal = paidamt + openamt` exacto.
- **Compañía 1000005 (la de las cuotas múltiples):** no tiene usuarios activos con los que pedir token, así que se
  ejecutó en psql el SQL que arma el repositorio (por reflexión sobre sus métodos, con el filtro de un token sin
  rol). Da lo mismo que el borrador revisado a mano en los tres socios con cuotas, incluida la numeración (una
  factura con las cuotas 1 y 2 pagas trae solo la cuota 3 de 3). Contra el informe: 8 socios, 62 filas de cada
  lado, y 7 diferencias esperadas: 4 totales de NC de compra (R1), el total de un contra-movimiento (punto 7) y 2
  vencimientos de un término de día fijo ("30 Dias (dia 25)": `paymenttermduedate` da el 25 del mismo mes y el
  informe suma 30 días, R7).

**Invariantes de §8:** en todas las cuotas `dueamt = paidamt + openamt`; la suma del saldo de las cuotas de cada
factura es `invoiceopen(i, 0)` con signo; el orden es el declarado; dos llamadas seguidas devuelven el mismo cuerpo
en los 68 socios; un socio sin saldo da `[]`, uno inexistente 404 y uno de otra compañía 401 (igual que
`GET /bpartners/{id}`). Los cinco roles de `AdminLibertya` en 1010016 devuelven lo mismo que el token sin rol.

**Rendimiento:** el cliente 1013152 (517 filas) tarda 0,46 s por HTTP.

**Dos datos de la base que conviene conocer** (el informe hace lo mismo en los dos casos):
- Las NC anuladas con saldo son 9, pero el informe muestra 8: la novena (1022260, cliente 1013265) tiene
  `invoiceopen(i, 0) = −551,25` y su única cuota da 0. `invoiceopen` por cuota no reparte un saldo negativo
  (sobreimputación), así que una factura con cuotas imputada de más no aparece en ninguno de los dos.
- La factura de compra 1011608 (compañía 1000005) tiene cuotas válidas por 10.000 sobre un total de 12.000: la suma
  de sus cuotas no da su saldo. El invariante de §8 vale solo si las cuotas suman el total.

**No probado localmente:** un rol sin acceso a alguna de las tres tablas (el 401) y un rol limitado a
organizaciones que efectivamente separe filas, porque en `libertya_qa` no hay ni roles así ni socios con saldo en
más de una organización, y armarlos requiere modificar la base. Tampoco los pagos en moneda extranjera con las
funciones de OP#8516, que `libertya_qa` no tiene (§7.3): van en sursoftware.

### 11.3 Tests y empaquetado

- `AccountStatementIntegrationTests`: 12 tests (10 propios y los 2 heredados de token) contra
  `libertya_rel_22ar_for_api_25`: 11 pasan y `negativePaymentShouldKeepOneSign` se saltea, porque el único cobro
  negativo con saldo de esa base es de otra compañía; ese caso se validó contra `libertya_qa` (punto 7).
  `BPartnerIntegrationTests` tiene 4 fallas, las mismas que en `main` (el alta del maestro choca con registros
  relacionados: datos).
- Jar con `./gradlew bootJar`, con el core de `/ServidorOXP/lib`, que el 2026-11-13 ya no es el de §7.5 sino
  `Versión 26.09 20261113-1455` (`DB_VERSION` `28-08-2026`). Pasa los chequeos 1 a 3 de `compatibilidad-core.md` §5,
  y el jar embebe exactamente ese `OXP.jar` y ese `OXPXLib.jar`.
- Arranca **sin** `-Dloader.path` (JasperReports va embebido desde `208ff19`) y con `--spring.config.location`
  apuntando al `application.properties` de `main`; la impresión de facturas devuelve el PDF. El endpoint no agrega
  propiedades.
- Al regenerar los stubs con el bloque de swagger-codegen aparecen dos diferencias que no son de este cambio y no
  se copiaron: `ProcessreportApi.java`, que el repo no tiene (`/processes/{id}/report`, de `ecebc57`, tiene un
  controller sin la interfaz generada), y `MenuOption.java`, que difiere solo en espacios.
