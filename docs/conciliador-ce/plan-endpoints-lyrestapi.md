# Plan: endpoints de liquidaciones de tarjetas en lyrestapi

> Escrito el **2026-08-20**. Análisis hecho contra el código real de
> [`../libertya-core-teh`](../../../libertya-core-teh) y
> [`../lyrestapi`](../../../lyrestapi), y contra datos de producción replicados en
> `raw` / `analytics_dev`. **Destino: se pasa a `../lyrestapi/docs/` cuando arranque la
> rama.** Mientras tanto vive acá porque el contexto que lo justifica es del datamart.
>
> El modelo a imitar es `../lyrestapi/docs/plan-asientos-manuales.md`: diseñar, documentar
> la evidencia de cada decisión, después implementar.

## 1. Qué se quiere lograr

Que el **Conciliador de Cobros Electrónicos** pueda materializar en Libertya la
conciliación que el datamart ya resolvió. Dos operaciones, en este orden:

1. **Resolver o crear** la `C_CreditCardSettlement` (la cabecera de la liquidación) junto a
   un `C_CreditCardCouponFilter` por defecto del cual colgar los cupones.
2. **Colgar cada cupón**: un `C_CouponsSettlements` por cobro, apuntando a su `C_Payment`.

Ver [origenes-y-flujo-de-impacto.md](origenes-y-flujo-de-impacto.md) para el flujo completo
y [diagrama-flujo-de-datos.md](diagrama-flujo-de-datos.md) §5 para el árbol de tablas.

---

## 2. El hallazgo que cambia el plan

> **La hipótesis de partida era que `MCreditCardSettlement` está acoplada a las tablas
> `i_fidelius_*` y que por eso haría falta una clase Java genérica nueva en el core.
> Revisado el código, ese acoplamiento no está donde parecía. Para el alcance de este plan
> —crear la cabecera y el filtro— las clases del core ya son genéricas y no hay que tocar
> Libertya.**

La evidencia, toda verificable:

### 2.1 La cabecera ya se crea sin Fidelius

`MCreditCardSettlement` genera sus filas hijas en `doAfterSave` (línea 67):

```java
if (newRecord && generateChildrens && !getDocStatus().equals(DOCSTATUS_Voided)) {
    generateAllChildrens();
}
```

`generateChildrens` es `private boolean generateChildrens = true` (línea 34) con setter
público. Y `generateAllChildrens()` (línea 594) crea una fila en cero **por cada maestro
configurado** — `C_Tax`, `C_RetencionSchema` con `RetencionApplication='S'`,
`C_CardSettlementConcepts` tipo `CO` y `OT`. Sale de los maestros del ERP, no de ningún
archivo de importación.

**Consecuencia:** un `INSERT` genérico sobre `C_CreditCardSettlement` a través de la clase
`M*` ya produce la cabecera con todas sus hijas listas para actualizar.

### 2.2 El import de Fidelius es opt-in y nadie lo dispara al guardar

`MCreditCardCouponFilter.importFromFidelius()` es un método **público que hay que llamar a
propósito**. Los únicos dos llamadores en todo el core:

| Llamador | Estado |
|---|---|
| `process/ImportCuponesFidelius.java:80` | el proceso del botón "Importar cupones" |
| `process/customImport/fidelius/jobs/ImportTarjeta.java:1507` | **comentado** (`// filtro.importFromFidelius();`) |

No se invoca desde `beforeSave` ni desde `doAfterSave`. Además está gateado por la
preferencia `LIQ_TARJETA_IMPORTARCUPONESFROMFIDELIUS`. **Guardar un filtro no importa nada
de Fidelius.**

Lo único que hace `MCreditCardCouponFilter.beforeSave` es copiar el `M_NumeroComercio_ID`
de la cabecera al filtro cuando el filtro es nuevo. Genérico e inofensivo.

### 2.3 Lo único "fidelius" en las clases de liquidación son dos UPDATE de limpieza

En `MCreditCardSettlement`, líneas 128-132 y 1067-1068:

```sql
UPDATE I_FideliusCupones SET is_reconciled='N' ...
UPDATE I_FideliusCupones SET is_reconciled='N', C_CouponsSettlements_ID=0 ...
```

Están en los caminos de **desconciliar y borrar cupones**, no en el de crear. Para un cupón
que no vino de Fidelius, esos UPDATE afectan 0 filas. No molestan, pero conviene saberlos.

### 2.4 Dónde sí está el acoplamiento

En los **procesos de importación**, que no vamos a usar:
`ImportTarjeta.java`, `ImportFideliusSettlements.java`, `ImportCuponesFidelius.java`,
`ImportarPaywayCSV.java`, `FilterCoupons.java`. Ésa es la vía por la que se crean hoy las
liquidaciones, y es la que está atada a `i_fidelius_*`. **El plan la evita entera**: no la
reusa ni la modifica.

### 2.5 Entonces, ¿cuándo sí haría falta una clase nueva en el core?

Sólo si aparece alguna de estas tres, y hoy ninguna aplica al alcance de la fase 1:

| Disparador | Por qué obligaría a tocar el core |
|---|---|
| Cambiar una regla de validación (p. ej. aceptar `SettlementNo` no numérico) | La regla vive en `beforeSave` de la clase `M*` |
| Necesitar una operación atómica que el core no expone (crear cabecera + filtro + N cupones + completar, todo o nada, en una sola transacción de negocio) | Hoy se compone desde lyrestapi; si esa composición creciera en reglas, tendría que bajar al core |
| `completeIt()` con un ajuste de cuadratura automático (pendiente F1) | Es lógica contable nueva, y va en el core sí o sí |

**Recomendación: arrancar sin tocar el core.** Si aparece el disparador, se agrega la clase
—`MCreditCardSettlementBuilder` o similar— con el plan ya hecho y sin haber bloqueado la
fase 1 esperándola.

---

## 3. Contra qué core se compila: TEH, no el público

Tehuelche corre su propio core, [`../libertya-core-teh`](../../../libertya-core-teh), y todo
el dominio de tarjetas tiene lógica propia ahí. **Todo el análisis de §2 y las reglas de §5
están hechos contra el core TEH.**

### 3.1 Lyrestapi no se "genera a partir de un core": enlaza contra sus jars

```gradle
def OXPLIBS = System.getenv("OXP_HOME")
implementation files("$OXPLIBS/lib/OXP.jar")
implementation files("$OXPLIBS/lib/OXPXLib.jar")
```

No compila contra código fuente del core. La pregunta "¿desde qué core genero lyrestapi?" es
en realidad **"¿a qué `OXP_HOME` apunto al compilar, y qué jars hay en el servidor al
correr?"**. Son dos cosas distintas y las dos importan.

### 3.2 Qué tiene TEH que el core público no tiene

Comparación de las clases del dominio (2026-08-20, `libertya` en **`dev`** vs
`libertya-core-teh` en `main`; verificado también contra `fix/op-7344`, con resultados
idénticos):

| Clase | Público | TEH | Líneas distintas |
|---|---:|---:|---:|
| `MCreditCardSettlement` | 1.254 | 1.395 | 153 |
| `MCreditCardCouponFilter` | 50 | 182 | 132 |
| `MCouponsSettlements` | 56 | 92 | 36 |
| `MCreditCardClose` | 630 | 806 | 228 |
| `X_C_CouponsSettlements` | 305 | 305 | **0** |

Y el paquete `com.hipertehuelche` — **242 clases que en el core público no existen**.

**Piezas concretas de las que depende este plan y que son SÓLO de TEH:**

| Pieza | ¿En el público? | Consecuencia de no tenerla |
|---|---|---|
| **R7** — un `C_Payment` no puede estar en dos liquidaciones | ❌ | `MCouponsSettlements` del público **no tiene `beforeSave`**. La invariante que el conciliador trata como "regalo del ERP" simplemente no se aplica |
| **R6** — `Include`/`IsReconciled` exigen `C_Payment_ID` | ❌ | Se pueden marcar cupones conciliados sin pago |
| **Tolerancia configurable** de cuadratura | ❌ | Ver 3.3 |
| `M_NumeroComercio_ID` en la liquidación (13 usos) | ❌ | No existe la tabla ni la clase `MNumeroComercio` (`com.hipertehuelche.sucursales.model`) |
| `importFromFidelius()` y el `beforeSave` del filtro | ❌ | Irrelevante: el plan no los usa |

**Piezas compartidas** (existen igual en los dos): `generateAllChildrens()`, el flag
`generateChildrens`, R1 (`SettlementNo` numérico), R2 (unicidad), R5 (cuenta bancaria), el
rollup `calculateSettlementCouponsTotalAmount()` y el `doAfterSave` de las hijas.

### 3.3 El público valida la cuadratura con igualdad exacta

```java
// core público
boolean validSettlement = amt1.equals(amt2);

// core TEH
BigDecimal difference = amt1.subtract(amt2).abs();
boolean validSettlement = difference.compareTo(getTolerancia()) <= 0;
```

Dos diferencias, y las dos importan:

1. **El público no tiene tolerancia alguna.** Con los datos de hoy cuadra el 5,3 % de las
   liquidaciones de Payway *con* $0,50 de margen; sin margen sería bastante menos.
2. `BigDecimal.equals()` **compara también la escala**: `100.00` y `100.0` no son iguales. Y
   los `setScale(2, ...)` de arriba **descartan su resultado** (`setScale` devuelve un
   BigDecimal nuevo, no muta). O sea que la versión pública es más estricta *y* más frágil.
   La de TEH, con `compareTo`, es la corregida.

### 3.4 La buena noticia: el código de lyrestapi ya es agnóstico

Hoy `../lyrestapi/src` **no tiene una sola referencia a `com.hipertehuelche`**: sólo importa
`org.openXpertya.{model,process,util,db}`. Y `AbstractRepository` no usa getters tipados sino
metadata viva de `M_Column`, y el core mismo accede al número de comercio con
`get_Value("M_NumeroComercio_ID")` — un acceso dinámico que funciona sobre cualquier `PO`
tenga o no la clase generada esa columna.

**Consecuencia: este plan no necesita ninguna API Java exclusiva de TEH.** Necesita el
*comportamiento* de TEH (R6, R7, la tolerancia), que lo aporta el jar en tiempo de ejecución.

### 3.5 Recomendación

> **Compilar contra los jars de TEH, y mantener el código fuente portable. La bifurcación va
> en el destino del build, no en el source.**

| Opción | Veredicto |
|---|---|
| Compilar contra público, correr contra TEH | ❌ Es una combinación que nadie prueba, justo en las clases que más divergen (153 y 132 líneas). No hay ningún beneficio a cambio |
| Compilar y correr contra TEH, con fork del source | 🟡 Funciona, pero el fork no hace falta hoy: el código no necesita API de TEH |
| **Compilar y correr contra TEH, source portable** | ✅ **Recomendada.** `OXP_HOME` apuntando a los jars TEH; sin `import com.hipertehuelche`; columnas propias por nombre, nunca por getter tipado |

En la práctica: **una rama en lyrestapi** (`liquidaciones-tarjetas`) para el desarrollo, que
puede mergear a `main` sin volverlo dependiente de TEH. Lo que sí es específico de Tehuelche
es el *despliegue*: qué `OXP_HOME` se usa para armar el jar.

⚠️ **Y hay que documentarlo en el endpoint**: estas operaciones **asumen R6 y R7**. Si alguien
las desplegara sobre una instalación con core público, el ERP **no rechazaría** un
`C_Payment` cargado en dos liquidaciones, y el doble impacto pasaría en silencio. Es un
argumento más para que las dos guardas del conciliador (tabla `impacto` propia + `GET` en
vivo) no se consideren opcionales: no pueden delegarse enteras en la invariante del ERP.

---

## 4. Dónde va cada pieza de lógica

lyrestapi es un thin layer, pero **"thin" no quiere decir "sin capa de servicio"**. El
proyecto ya tiene el patrón exacto que hace falta, y componer una transacción no es lógica
de negocio: es orquestación.

| Capa de lyrestapi | Qué le toca acá | Precedente en el repo |
|---|---|---|
| `stub/iface` + `stub/model` | DTOs y anotaciones, **autogenerados** desde el YAML | todos |
| `controller/` | Delegación de una línea a los helpers de `AbstractController` | `JournalController` |
| `service/` | **Componer cabecera + filtro en una sola `Trx`**, commit o rollback | `AbstractService.create()`, `InvoiceService`, `JournalService` |
| `repository/` | CRUD genérico sobre el PO, con el `iface` correcto | `JournalRepository` |
| **core de Libertya** | **Nada, en la fase 1** | — |

`AbstractService.create()` ya hace exactamente lo que se necesita: abre `Trx`, llama al
`performCreate()` de la subclase, opcionalmente completa el documento, commitea, y hace
rollback ante cualquier excepción.

### ¿Hay que escribir clases Java nuevas? El inventario exacto

**En `libertya-core-teh`: ninguna.** Es la conclusión de §2, y la decisión de quedarse en
`DR` (§9) la refuerza: lo único que hubiera podido requerir código nuevo en el core era el
ajuste automático de cuadratura para poder completar, y eso queda fuera de alcance.

**En `lyrestapi`: sí, pero casi todo es andamiaje del propio proyecto.** El inventario
completo de la fase 1 + fase 2:

| Archivo | Cómo se produce | Tamaño esperado | ¿Lógica? |
|---|---|---|---|
| `resources/paths/*.yaml` + `resources/model/*.yaml` | `utils/genSchema.sh` desde metadata viva de la base | — | no |
| `stub/iface/*Api.java`, `stub/model/*.java` | `utils/genClasses.sh` (swagger-codegen) | — | **no se editan a mano** |
| `repository/CouponsSettlementsRepository.java` | copiar `JournalRepository` | **~14 líneas** | no |
| `repository/CreditCardSettlementRepository.java` | ídem | **~14 líneas** | no |
| `repository/CreditCardCouponFilterRepository.java` | ídem | **~14 líneas** | no |
| `controller/CouponsSettlementsController.java` | delegación a `AbstractController` | ~40-60 | no |
| `controller/CreditCardSettlementController.java` | ídem | ~30 | no |
| `controller/CreditCardCouponFilterController.java` | ídem | ~30 | no |
| **`service/CouponsSettlementsService.java`** | **a escribir** | ~150 | **sí** |
| **`service/CreditCardSettlementService.java`** | **a escribir** | ~100 | **sí** |

Un repositorio del proyecto es literalmente esto:

```java
@Repository
public class JournalRepository extends AbstractRepository {
    public JournalRepository() {
        tableName = X_GL_Journal.Table_Name;
        iface = Journal::new;
    }
}
```

14 líneas, y los tres de este dominio son iguales.

**Los únicos dos archivos con lógica de verdad**, y qué va en cada uno:

- **`CouponsSettlementsService`** — el `bulk` (recorrer los N cupones, uno por transacción,
  armar el resultado por ítem), el `exists` (una query con `IN`) y el mapeo de R6/R7 a un
  409 **que devuelva el id del registro en conflicto** (el core no lo trae en el mensaje, hay
  que buscarlo).
- **`CreditCardSettlementService`** — el `performCreate()` del `/full`: insertar la cabecera,
  insertar el filtro, devolver los ids de las hijas que creó `generateAllChildrens()`. Todo
  dentro de la `Trx` que `AbstractService` ya abre y commitea.

Para calibrar: `JournalService` tiene 146 líneas e `InvoiceService` 216. Los dos de acá están
en esa liga o por debajo.

> **Lo que NO hay que escribir**, y conviene decirlo explícito porque es la parte que se
> subestima: el CRUD, la paginación, el mapeo JSON ↔ columnas, la resolución de referencias,
> los defaults, la transacción y el manejo de `DocAction` **ya están en `AbstractRepository`
> y `AbstractService`**. No hay que tocar nada de eso.

**Único caso en que aparecería una clase más**: si se decide implementar la supresión del
rollup con `setReconciledFlag` (decisión abierta 6), hace falta un método propio en
`CouponsSettlementsRepository` que no pase por el `insert` genérico. Sigue siendo lyrestapi,
no el core, y es opcional.


### ⚠️ Corrección: el `iface` no es lo que se creía

> La documentación de `../conciliador-ce/docs/diseno/endpoints-lyrestapi-a-desarrollar.md` §2
> advierte que **"el `iface` del repositorio tiene que apuntar a la clase `M*`, no a la
> `X_*`"** y lo declara el primer test a escribir. **Revisado el código el 2026-08-20, eso no
> es así.** Hay que corregirlo allá también, porque manda a resolver un problema que no
> existe y deja sin mirar el que sí.

Lo que hace realmente el `iface`: es la **factory del DTO de JSON**, no del modelo de
Libertya. Se ve en cualquier repositorio del proyecto:

```java
public JournalRepository() {
    tableName = X_GL_Journal.Table_Name;
    iface = Journal::new;               // org.libertya.api.stub.model.Journal — el DTO
}
```

El PO de Libertya lo instancia `AbstractRepository.getPO()` así:

```java
M_Table table = M_Table.get(getCtx(info), tableName);
aPO = table.getPO(id[0], trxName);
```

Y `M_Table.getClass(tableName)` **prueba primero `<paquete>.M<Clase>` y sólo cae a
`X_<Tabla>` si la `M*` no existe** (`M_Table.java:288` en adelante). `getPOclass()` se limita
a comprobar que la clase herede de `PO`.

**Consecuencia: los rollups y `generateAllChildrens()` corren solos.** `MCreditCardSettlement`
y `MCouponsSettlements` existen y heredan de `PO`, así que el core las elige sin que lyrestapi
tenga que pedir nada. No hay que configurar ningún `iface` especial.

### El riesgo que sí queda, y el test que sí hay que escribir

El mecanismo depende de que **las clases `M*` estén en el jar del classpath**. Ahí es donde
se cruza con §3: con los jars del core público las `M*` también existen y se resuelven igual,
pero son **otras clases** — sin R6, sin R7 y sin tolerancia de cuadratura. El síntoma no sería
un error: sería que el ERP acepta en silencio lo que en TEH habría rechazado.

Por eso el primer test sigue valiendo, con otro objetivo: **verificar que el comportamiento
del core que efectivamente está cargado es el de TEH.**

| Verificar | Cómo | Qué prueba |
|---|---|---|
| Los rollups corren | Insertar una fila de `C_CommissionConcepts` y ver que `CommissionAmount` de la cabecera se actualiza | Que se resolvió la `M*` y no la `X_*` |
| Las hijas se crean solas | `POST` de una cabecera y contar filas en las cinco tablas de conceptos | `generateAllChildrens()` |
| **Está cargado el core TEH** | Intentar crear dos `C_CouponsSettlements` con el mismo `C_Payment_ID` y esperar el rechazo | **R7 — si pasa, el jar es del core público** |

El tercero es el importante y el que nadie tenía anotado.

---

## 5. Las reglas del core que el endpoint tiene que respetar

Verificadas en `MCreditCardSettlement.beforeSave` (línea 145 en adelante), que termina en
`return found == 0` — o sea que **todas bloquean el guardado**.

| # | Regla | Mensaje del core | HTTP propuesto |
|---|---|---|---|
| R1 | `SettlementNo` sólo puede ser numérico: `matches("\\^?\\d*\\^?")` | `SettlementNumberMustBeNumeric` | 409 |
| R2 | Unicidad por `C_BPartner_ID` + `SettlementNo` + `PaymentDate::date` | `CreditCardSettlementDuplicated` | **409 devolviendo el `C_CreditCardSettlement_ID` existente** |
| R3 | Marcar `IsReconciled='Y'` exige que no queden cupones sin conciliar | `ExistsNotReconciledSettlementCoupons` | 409 |
| R4 | `completeIt()` exige cuadratura ≤ tolerancia (`ToleranciaCompletadoLiquidacionesTarjetas`, default $0,50) | `CreditCardSettlementAmountsMismatch` | 409 |
| R5 | Al completar, si la entidad financiera no tiene `c_bankaccount_settlement_id`, falla | `SettlementBankAccountNotConfigured` | 409 |

Y en `MCouponsSettlements.beforeSave`:

| # | Regla | HTTP |
|---|---|---|
| R6 | `Include='Y'` o `IsReconciled='Y'` exigen `C_Payment_ID` | 409 |
| R7 | Un `C_Payment_ID` no puede estar en dos liquidaciones | **409 devolviendo el `C_CouponsSettlements_ID` que lo tiene** |
| R8 | Un cupón conciliado no se puede borrar (`beforeDelete`) | 409 |

> **R2 y R7 son las dos importantes para el conciliador.** No alcanza con un 409: el body
> tiene que traer el id del registro que ya existe, porque es exactamente lo que el
> conciliador necesita para resolver sin adivinar. Sin eso tiene que salir a buscarlo con
> un GET extra por cada colisión.

> **R1 tiene consecuencia de diseño**: la `liquidacion_key` del datamart **no sirve** como
> `SettlementNo` (ver §6).

---

## 6. Lo que dicen los datos

Medido el **2026-08-20** contra `analytics_dev` y `raw`.

### 6.1 El `SettlementNo` es `nro_liquidacion`, no `liquidacion_key`

`liquidacion_key` es una clave compuesta interna del datamart (`F|1145280`,
`P|113497|30059091|2026-07-07`). El número que el ERP espera es `nro_liquidacion`:

| Fuente | Eventos con `nro_liquidacion` | Numéricos |
|---|---:|---:|
| fidelius | 1.657.953 | **100 %** |
| payway | 185.954 | **100 %** |
| mercadopago / nave | 0 | — |

Cumple R1 sin transformación. Y en `raw.c_creditcardsettlement_dlt`, 324.060 de 324.069
`settlementno` de producción cumplen el mismo regex, así que la regla es la que efectivamente
rige.

### 6.2 El `GET` importa más que el `POST`

La mayoría de las liquidaciones **ya existen** en el ERP:

| Fuente | Liquidaciones del origen | Ya existen en el ERP | Habría que crear |
|---|---:|---:|---:|
| fidelius | 75.792 | **73.797 (97,4 %)** | 1.995 |
| payway | 15.413 | **12.376 (80,3 %)** | 3.037 |

Cruce por `settlementno` + `paymentdate::date`.

> **Consecuencia directa sobre el orden de trabajo:** el `GET` que resuelve
> `nro_liquidacion` + `fecha_pago` → `C_CreditCardSettlement_ID` desbloquea el 97 % del
> volumen de Fidelius y el 80 % de Payway. El `POST` de creación atiende el resto. Si hubiera
> que elegir uno solo para la primera iteración, es el `GET`.

Mercado Pago y Nave no aparecen en esta tabla porque no tienen liquidación de origen — es el
pendiente T3, y bloquea a los 205.056 cobros del §4 de
[origenes-y-flujo-de-impacto.md](origenes-y-flujo-de-impacto.md).

### 6.3 Estado de las liquidaciones que ya existen

`docstatus` sobre `isactive='Y'`: Payway tiene **365 en `IN`** y 22 en `DR`.

> ⚠️ `../conciliador-ce/docs/PENDIENTES.md` (C9) habla de **818** liquidaciones de Payway en
> `IN`. Hoy se miden 365 con `isactive='Y'`. Antes de usar cualquiera de los dos números,
> reproducir la consulta original: puede ser otra fecha, otro filtro, o que se hayan
> resuelto algunas.

---

## 7. Los endpoints

### Granularidad: ni todo en una llamada, ni una llamada por cupón

La pregunta natural es si la API puede crear la liquidación, el filtro y todos los cupones
de una sola vez. **Técnicamente sí** —`AbstractService` envuelve todo en una `Trx`— pero no
conviene. Tampoco conviene el otro extremo. El corte va en un lugar preciso.

#### Cuántos cupones tiene una liquidación de verdad

Medido el 2026-08-20:

| Fuente | Liquidaciones | Promedio | p50 | p95 | p99 | Máximo |
|---|---:|---:|---:|---:|---:|---:|
| fidelius | 77.266 | 21 | **7** | 86 | 223 | **768** |
| payway | 16.775 | 16 | **4** | 71 | 185 | **623** |
| ERP (histórico) | 280.671 | 26 | — | 98 | — | **3.504** |

La liquidación típica tiene **4 a 7 cupones**. Diseñar para la mediana y explotar en la cola
es exactamente el error que hay que no cometer: el p99 son 223 cupones y el máximo histórico
3.504.

#### Por qué NO todo en una sola llamada

1. **R7 convierte un cupón malo en una liquidación perdida.** Si uno solo de los 700 cupones
   tiene su `C_Payment` ya cargado en otra liquidación, el core lo rechaza y la transacción
   entera hace rollback. Y las colisiones de R7 **son esperables**, no excepcionales: el
   import viejo de Libertya sigue activo y escribiendo. Perder 699 cupones buenos por 1 malo
   es el peor comportamiento posible.
2. **La granularidad de reintento no coincide.** El conciliador registra el impacto **por
   cobro** (tabla `impacto`, con `idempotency_key` por contenido). Si la unidad de escritura
   fuera la liquidación entera, el reintento tendría que ser de la liquidación entera, y la
   idempotencia por cobro deja de servir.
3. **La cola rompe el HTTP.** 3.504 cupones en una transacción con el rollup de abajo es una
   llamada de minutos.

#### Por qué NO una llamada por cupón

En la primera corrida hay ~300.000 cobros esperando. A 50 ms de ida y vuelta cada uno son
más de 4 horas sólo de red.

#### El corte recomendado

| Llamada | Atomicidad | Por qué |
|---|---|---|
| `POST /creditcardsettlements/full` → cabecera + filtro | **Todo o nada** | Son dos filas, siempre. Una cabecera sin filtro es un estado inválido que nadie quiere ver |
| `POST /couponssettlements/bulk` → N cupones de **una** liquidación | **Por cupón, no por lote** | Cada cupón es independiente de los otros; el resultado es una lista de N resultados |

El `bulk` **no hace rollback del lote ante un fallo individual**: devuelve por cada cupón si
se creó, si ya estaba, o por qué falló.

```json
{ "c_creditcardsettlement_id": 123456,
  "resultados": [
    {"c_payment_id": 1012315, "estado": "creado",    "c_couponssettlements_id": 998001},
    {"c_payment_id": 1012316, "estado": "ya_existia","c_couponssettlements_id": 774100},
    {"c_payment_id": 1012317, "estado": "conflicto", "motivo": "R7",
     "c_couponssettlements_id": 615002, "c_creditcardsettlement_id_en_conflicto": 99120}
  ]}
```

`ya_existia` y `conflicto` **no son errores HTTP**: son resultados normales que el conciliador
registra en `impacto` y sigue. El 4xx se reserva para el lote entero mal formado.

Tamaño de lote configurable, con tope sugerido en **200**: cubre el p99 en una sola llamada y
parte el máximo histórico en 18.

#### Un costo del core que hay que conocer: el rollup es O(N²)

`MCouponsSettlements.doAfterSave` llama a `calculateSettlementCouponsTotalAmount()` en **cada**
guardado, y ese método hace:

```sql
UPDATE C_CreditCardSettlement SET CouponsTotalAmount =
  (SELECT SUM(amount) FROM C_CouponsSettlements
    WHERE C_CreditCardSettlement_ID = ... AND include='Y')
```

Insertar N cupones dispara N recálculos que escanean 1, 2, … N filas: **N(N+1)/2 lecturas**.
Para la mediana (7 cupones) es nada. Para 768 son ~295.000 lecturas y 768 UPDATE sobre la
misma fila de cabecera; para 3.504, ~6,1 millones.

**La compuerta existe y está sin usar.** `MCouponsSettlements` tiene:

```java
private boolean reconciledFlag;                     // default false
public void setReconciledFlag(boolean f) {...}
public boolean doAfterSave(...) { if (!reconciledFlag) { ...recalcular... } }
```

Verificado el 2026-08-20: **ningún lugar del core llama a `setReconciledFlag`** — es código
muerto, presente además en el core público, así que activarlo no cambia el comportamiento de
nada más. El `bulk` puede poner el flag en `true` mientras inserta y llamar a
`calculateSettlementCouponsTotalAmount()` **una sola vez al final del lote**.

> Requiere un método propio en el repositorio o el servicio: `AbstractRepository` es genérico
> y no sabe de ese setter.
>
> Si el proceso muriera a mitad del lote, `CouponsTotalAmount` quedaría desactualizado. **No
> es grave**: ese campo no participa de ninguna validación del core (§2 de
> [tolerancia-de-importe.md](tolerancia-de-importe.md) §6), sólo se muestra. El lote siguiente
> lo corrige. Aun así, la optimización es **opcional**: hasta el p99 el costo es irrelevante y
> conviene medirlo antes de agregar código.

#### Entonces, el flujo completo del conciliador

```
1. GET  /creditcardsettlements?filter=settlementno=X;paymentdate=Y   → ¿existe?
2. si no existe:
   POST /creditcardsettlements/full                                   → cabecera + filtro
3. POST /couponssettlements/bulk  (de a 200)                          → N resultados
4. registrar cada resultado en `impacto`
5. NO completar (sin docaction=CO) — ver fase 3
```

Tres tipos de llamada por liquidación, no una ni N.


### Fase 1 — resolver y colgar cupones *(no depende de T1 ni de F1)*

```
GET    /v1.0/creditcardsettlements?filter=settlementno=X;paymentdate=Y
GET    /v1.0/creditcardsettlements/{id}

GET    /v1.0/couponssettlements?filter=c_payment_id=X
POST   /v1.0/couponssettlements
DELETE /v1.0/couponssettlements/{id}

POST   /v1.0/couponssettlements/exists      ← lote de c_payment_id
```

`POST /couponssettlements/exists` no es un lujo: es la guarda de escritura del conciliador
(§2 de [origenes-y-flujo-de-impacto.md](origenes-y-flujo-de-impacto.md)), y se ejecuta una
vez por cobro por corrida. Con ~300.000 cobros pendientes, resolverlo de a uno es la
diferencia entre una corrida de minutos y una de horas.

### Fase 2 — crear la liquidación *(el pedido original)*

```
POST   /v1.0/creditcardsettlements            ← cabecera sola
POST   /v1.0/creditcardsettlements/full       ← cabecera + filtro por defecto, en una Trx
PUT    /v1.0/creditcardsettlements/{id}
GET    /v1.0/creditcardcouponfilters?filter=c_creditcardsettlement_id=X
POST   /v1.0/creditcardcouponfilters
```

**`/full` es el endpoint que pediste.** Es un `AbstractService`, no lógica en el core:

```
performCreate(info, document, trxName):
  1. settlementRepo.insert(cabecera)      → dispara generateAllChildrens()
  2. filterRepo.insert(filtro por defecto, c_creditcardsettlement_id = el de arriba)
  3. devolver { c_creditcardsettlement_id, c_creditcardcouponfilter_id, hijas_creadas[] }
```

Devolver los ids de las filas hijas que creó `generateAllChildrens()` **ahorra un GET por
liquidación** y es gratis: ya están en la transacción.

Campos del filtro por defecto — la tabla completa es chica:
`C_CreditCardSettlement_ID`, `C_BPartner_ID`, `C_Currency_ID`, `M_EntidadFinanciera_ID`,
`M_EntidadFinancieraPlan_ID`, `M_Numerocomercio_ID`, `PaymentBatch`, `TrxDateFrom`,
`TrxDateTo`, `IsProcessed`. El `M_Numerocomercio_ID` **no hace falta mandarlo**: el
`beforeSave` del filtro lo copia de la cabecera.

> **Por qué un filtro por defecto y no colgar los cupones directo de la cabecera:** el core
> recorre los cupones *a través del filtro* en `changeCouponsAuditStatus()`. Un cupón sin
> filtro no aparece en esa consulta, así que al anular la liquidación **no se le revierte el
> estado de auditoría al `C_Payment`**. No rompe nada visible, pero deja el cobro mintiendo.
> En producción el 100 % de las 7.186.854 filas activas de `C_CouponsSettlements` tiene
> filtro.

### Fase 3 — completar *(bloqueada por T1 y F1, no arrancar)*

```
POST /v1.0/creditcardsettlements/{id}/process?docaction=CO|VO|CL
```

`CO` dispara `completeIt()`, exige la cuadratura de R4 y **crea un `C_Payment` por el neto**.
Con los datos de hoy sólo cuadran el 5,3 % de las de Payway y el 67,5 % de las de Fidelius.
**Exponer el endpoint sin resolver T1 es fabricar liquidaciones en `IN`.**

> ✅ **Decidido el 2026-08-20 (Julián): el `POST` de la fase 2 deja la liquidación en `DR` y
> no se expone `docaction=CO`.** Con eso las fases 1 y 2 **dejan de depender de T1 y F1** y se
> pueden construir ya. Ver §9. Esto cierra el punto que
> `../conciliador-ce/docs/PENDIENTES.md` marcaba como abierto al final.

---

## 8. Plan de implementación

Para ejecutar con Claude Code desde `../lyrestapi`, en una rama nueva
(sugerencia: `liquidaciones-tarjetas`).

### Paso 0 — el test de que el core cargado es el que creemos

> Antes de compilar: `OXP_HOME` tiene que apuntar a los jars armados desde
> `libertya-core-teh` (§3.5).

Crear `CreditCardSettlementRepository` (14 líneas, `tableName` + `iface` al DTO) y un test de
integración que verifique las tres cosas de §4:

1. `POST` de una cabecera mínima en `DR` → **aparecen filas hijas** en las cinco tablas de
   conceptos (`generateAllChildrens()`);
2. insertar una fila de `C_CommissionConcepts` con importe → **`CommissionAmount` de la
   cabecera se actualiza solo** (se resolvió la `M*`, no la `X_*`);
3. **crear dos `C_CouponsSettlements` con el mismo `C_Payment_ID` → el ERP tiene que
   rechazar el segundo.**

**El 3 es el que importa.** Si pasa sin error, el jar cargado es del core público y falta R7:
la invariante sobre la que se apoya toda la idempotencia del conciliador no está. Los otros
dos pasan igual en ambos cores.

### Paso 1 — esquema y stubs

Agregar las entidades a `utils/genSchema.sh` y regenerar con `utils/genClasses.sh`.

⚠️ **Verificar que `M_NumeroComercio_ID` aparezca en el schema de `C_CreditCardSettlement`.**
No está en la clase generada `X_C_CreditCardSettlement`: el core lo lee con
`get_Value("M_NumeroComercio_ID")` (línea 1373). Como `genSchema.sql` lee metadata viva de la
base, debería tomarlo igual — pero es exactamente el tipo de cosa que se descubre tarde.

### Paso 2 — repositorios y controllers de la fase 1

`CouponsSettlementsRepository` + `CreditCardSettlementRepository` con sus controllers.
Sólo `GET` de la cabecera; `GET` / `POST` / `DELETE` de los cupones.

### Paso 3 — mapeo de errores R1–R8

En particular **R2 y R7 devolviendo el id del registro en conflicto**. Requiere una
consulta explícita antes o después del error del core, porque el mensaje del core no trae el
id.

### Paso 4 — `POST /couponssettlements/exists`

Recibe una lista de `c_payment_id`, devuelve los que ya están y con qué
`C_CouponsSettlements_ID`. Una sola query con `IN`.

### Paso 5 — `POST /couponssettlements/bulk`

N cupones de una liquidación, **con resultado por ítem y sin rollback del lote** (ver la
subsección de granularidad en §7). Es el endpoint que más se ejecuta de todo el sistema.

Tests que tienen que estar:

- un lote de 3 donde el del medio choca con R7 → **los otros dos se crean igual**;
- reenviar el mismo lote → los tres vuelven como `ya_existia`, sin duplicar nada;
- un lote de 250 con el tope en 200 → 400 con mensaje claro, no un truncado silencioso.

### Paso 6 — `CreditCardSettlementService` y el `/full` de la fase 2

Recién acá, y sólo si la fase 1 anda de punta a punta contra la base de QA.

### Paso 7 — documentar para el consumidor

Un `docs/liquidaciones-tarjetas-api.md` en lyrestapi, al estilo de
`docs/asientos-manuales-api.md`, y el plan (este documento) al lado.

---

## 9. Decisiones tomadas

| Decisión | Quién / cuándo | Consecuencia |
|---|---|---|
| **El `POST` deja la liquidación en `DR`. No se expone `docaction=CO` en esta etapa.** | Julián, 2026-08-20 | El plan **deja de depender de T1 y F1**: no hay que reconstruir la deducción ni resolver el residuo para avanzar. Ninguna llamada de la API crea un `C_Payment` ni contabiliza nada |
| **`numeroscomercio` (E11) se adelanta a la fase 1 y va sólo de lectura.** | Julián, 2026-08-21 | Sin él no se puede resolver el `c_bpartner_id` de la cabecera, que no se deduce del adquirente. Se deja fuera la escritura porque el maestro se administra desde el ERP. Ver §12 |

Consecuencias operativas de dejar todo en `DR`, para tener presentes:

- La liquidación **existe y tiene sus cupones colgados**, que es lo que cierra la brecha
  BI ↔ Libertya. Eso ya sirve al negocio.
- **No genera asiento contable** hasta que alguien la complete —desde la ventana del ERP o
  desde un endpoint futuro—. Conviene que Finanzas sepa que ese paso queda pendiente y en
  manos de una persona.
- Una liquidación en `DR` **sí se puede borrar**, a diferencia de una completada. El error es
  reversible mientras no se complete: es exactamente la propiedad que se quiere para arrancar.
- Cuando T1 y F1 se resuelvan, completar es un `POST /{id}/process?docaction=CO` **sobre las
  liquidaciones que ya están creadas**. No hay que rehacer nada.

---

## 10. Decisiones abiertas antes de empezar

| # | Pregunta | Dueño |
|---|---|---|
| 1 | ¿`C_CreditCardCouponFilter.C_CreditCardSettlement_ID` es NOT NULL en la base? Decide si el filtro es obligatorio o una recomendación | verificable en QA |
| 2 | ~~¿Qué `C_BPartner_ID` corresponde a cada adquirente?~~ **Cerrada el 2026-08-21: la pregunta tenía la premisa equivocada.** No es por adquirente sino **por número de comercio**: sobre los datos del cliente, Fiserv opera contra 6 entidades comerciales distintas y Prisma contra otras 6. Se resuelve con el endpoint de la #4 | cerrada |
| 3 | Los 365/818 de Payway en `IN`: ¿se tocan, se ignoran, o el conciliador no opera sobre ellas? | Finanzas |
| 4 | ~~¿Hace falta `M_NumeroComercio` como endpoint de sólo lectura (E11)?~~ **Cerrada el 2026-08-21: sí, y está implementado.** `GET /v1.0/numeroscomercio`. Ver §12 | cerrada |
| 5 | La rama de lyrestapi, ¿mergea a `main` o queda como fork de Tehuelche? **Recomendación: mergea** — el source no necesita API de TEH (§3.5), lo específico es el `OXP_HOME` del build | Julián + Nacho |
| 6 | ¿Se implementa la supresión del rollup (`setReconciledFlag`) en el `bulk`, o se acepta el O(N²)? **Recomendación: medir primero** — hasta el p99 no duele | técnica |

---

## 11. Resumen para quien tenga que decidir rápido

- **No hay que tocar el core de Libertya** para crear la cabecera ni el filtro. Las clases
  `M*` ya son genéricas; el acoplamiento a `i_fidelius_*` está en los procesos de
  importación, que este plan no usa.
- **El endpoint compuesto va en la capa de servicio de lyrestapi**, que es el patrón que el
  repo ya usa para facturas y asientos. Eso no viola el "thin layer": es orquestación
  transaccional, no lógica de negocio.
- **Empezar por el `GET`**, no por el `POST`: el 97 % de las liquidaciones de Fidelius y el
  80 % de las de Payway ya existen en el ERP.
- **El primer test no es el del `iface`** —esa advertencia heredada es incorrecta, ver §4—
  sino el de **R7**: crear dos cupones con el mismo `C_Payment_ID` y verificar que el ERP
  rechaza el segundo. Es lo único que prueba que el core cargado es el de TEH.
- **Compilar contra los jars del core TEH**, no el público: R6, R7 y la tolerancia de
  cuadratura sólo existen en TEH. Pero el source de lyrestapi puede seguir siendo portable
  —hoy no toca `com.hipertehuelche`—, así que la bifurcación va en el `OXP_HOME` del build,
  no en el código.
- **Tres llamadas por liquidación, no una ni N**: `/full` atómico para cabecera + filtro,
  y `bulk` de cupones con resultado por ítem (sin rollback del lote). La mediana son 4-7
  cupones pero el máximo histórico es 3.504.
- ✅ **Decidido: todo queda en `DR`.** No se expone `docaction=CO`, así que el plan **no depende de T1 ni de F1** y se puede empezar.

---

## 12. `numeroscomercio` (E11) — implementado el 2026-08-21

Adelantado de la fase 3 a pedido de quien está integrando: al querer crear una liquidación aparece que el
`c_bpartner_id` de la cabecera no se puede resolver con lo que había expuesto.

### 12.1 Por qué era bloqueante y no una comodidad

La pregunta abierta #2 preguntaba qué entidad comercial corresponde a cada adquirente. **La premisa estaba
mal.** Contando sobre `m_numerocomercio` en `ly_core_teh` (294 filas activas, 246 comercios distintos):

| adquirente | `c_bpartner_id` distintos |
|---|---:|
| `F` (Fiserv) | 6 |
| `P` (Prisma) | 6 |
| `T` (Otros) | 2 |
| el resto | 1 |

No hay función adquirente → entidad comercial. La única que existe es comercio → entidad comercial, y ese
mapeo vive exclusivamente en `M_NumeroComercio`. Sin el endpoint, un integrador sólo puede hardcodear la
tabla, que es justo lo que la guía le pide no hacer.

### 12.2 Por qué no alcanzaba con `entidadesfinancieras`, que ya estaba

`M_EntidadFinanciera` tiene el comercio desnormalizado —`m_numerocomercio_id`, `adquirente`,
`financingservice`, `establishmentnumber`, `c_bpartner_id`, `c_bankaccount_id`,
`c_bankaccount_settlement_id`— y el endpoint ya existía. Además `AbstractRepository.loadEntityFromPO` devuelve
en `additionalvalues` cualquier columna que no esté en el DTO, y `filter` es SQL crudo, así que ya se podía
consultar por `adquirente` sin tocar nada.

No alcanzaba por tres motivos, en orden de gravedad:

1. **La copia se puede quedar vieja.** `MNumeroComercio.afterSave` sincroniza sólo con `!newRecord`, y el
   `UPDATE` apunta a las entidades financieras que *ya* referencian al comercio. Un comercio nuevo no propaga
   nunca.
2. **No está completa:** 53 de las 944 entidades financieras activas no tienen `m_numerocomercio_id`.
3. **Es una vista por sucursal, no el maestro:** 2.328 filas contra 296, con lo cual hay que deduplicar.

Se documentó igual como atajo en §7 de la guía de uso, porque cuando ya tenés el `m_entidadfinanciera_id` del
cupón ahorra una llamada.

### 12.3 Alcance: sólo lectura

`GET /v1.0/numeroscomercio` y `GET /v1.0/numeroscomercio/{id}`. Sin `POST`/`PUT`/`DELETE`, decidido el
2026-08-21 (Julián): es un maestro que se administra desde la ventana del ERP, y exponer escritura permitiría
cambiar desde una integración la cuenta bancaria de liquidación de un comercio —además de disparar el `UPDATE`
masivo de `MNumeroComercio.afterSave` sobre `m_entidadfinanciera`—.

### 12.4 Lo que no es obvio del modelo

- **La tabla es de plugin.** `AD_Component` la declara con `corelevel=2` y
  `packagename=com.hipertehuelche.sucursales`, y su única clase Java es
  `com.hipertehuelche.sucursales.model.MNumeroComercio` (presente en `OXP.jar`; hereda de
  `LP_M_NumeroComercio extends PO`, con lo cual pasa el chequeo *strict PO* de `M_Table.getPOclass`). Por eso
  `NumeroComercioRepository` usa el nombre de tabla como literal y no la constante `Table_Name` de una clase
  `X_*`: no hay ninguna, y **el source no importa `com.hipertehuelche` a propósito** (§3.5).
- **Si falta el registro del owner, el síntoma es un 404 mudo.** `M_Table.getPO()` devuelve `null` cuando no
  encuentra la clase, no lanza excepción. De ahí el test `retrieveDebeResolverLaClaseDelPlugin`.
- **`financingservice`, `value` y `c_bankaccount_settlement_id` son `ismandatory='N'`** en el diccionario, así
  que van en el filtro explícito de columnas de `genSchema.sh`. `financingservice` es parte de la clave
  natural: sin él el endpoint no sirve.
- **La clave natural no es única.** `getM_NumeroComercio_ID()` resuelve por
  `numerocomercio` + `adquirente` + `financingservice` con `DB.getSQLValueEx`, pero hay 13 ternas duplicadas
  (hasta 4 filas, algunas dentro de la misma sucursal). Para resolver el `c_bpartner_id` da igual —las 13
  apuntan al mismo—, pero es la manifestación en el modelo del problema de comercios cruzados que
  `../conciliador-ce/docs/PENDIENTES.md` T4 describe desde el BI.
- **`ClientOrgAuth` sólo filtra por compañía, no por organización**, así que un token de una sucursal puede
  leer comercios de las otras. Es lo que el conciliador necesita, y conviene saberlo porque no es lo que
  sugiere el nombre de la clase.

### 12.5 Lo que la base de pruebas no puede verificar

En `ly_core_teh` **ninguno de los 11 `c_bpartner_id` de `m_numerocomercio` existe en `c_bpartner`** (la base
tiene 80 entidades comerciales y ninguna es un adquirente). La columna no tiene foreign key, así que no
explota, pero **no se puede comprobar ahí que el `c_bpartner_id` resuelto sea usable en el `POST` de la
cabecera** —que sí tiene `fkbpartner`—. Eso hay que verificarlo contra la base real de Tehuelche.

### 12.6 Cambio colateral: dos campos en `EntidadFinanciera`

Se agregaron `adquirente` y `m_numerocomercio_id` al schema de `EntidadFinanciera`, **a mano y no
regenerando**: una regeneración completa contra `ly_core_teh` arrastra 21 columnas de TPV
(`iscodigo_seguridad`, `longmax_numerotarjeta`, `mascara_vtotarjeta`, ...) que nadie pidió. Funcionalmente no
cambia nada —ya volvían en `additionalvalues`—, pero quedan visibles en Swagger, que es donde un integrador
las busca.

### 12.7 Tests

`NumeroComercioIntegrationTests`, 4 tests, verdes contra `ly_core_teh` con fixtures reales (294 comercios de la
compañía 1010016). Se saltean solos contra una base sin el diccionario de Tehuelche.

Para correrlos hay que pasar `DB_NAME=ly_core_teh` **y** la password de esa base: `CommonIntegrationTests`
tiene `password=AdminLibertya` hardcodeada y en `ly_core_teh` es otra, con lo cual el `POST /token` falla con
un 403 que no dice nada del problema real.
