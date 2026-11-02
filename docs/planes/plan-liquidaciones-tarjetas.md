# Plan: endpoints de liquidaciones de tarjetas en lyrestapi

> Escrito el **2026-08-20**, en la rama donde se desarrollaron estos endpoints para una instalación con un
> core customizado (el contexto está en §12, *De dónde salió esto*). Al pasar a `main` (2026-11) se sacó del
> contrato todo lo propio de esa instalación: §13 resume qué cambió y por qué, y las decisiones de §2–§11 se
> leen con esa corrección encima.
>
> El modelo a imitar es `docs/planes/plan-asientos-manuales.md`: diseñar, documentar la evidencia de cada
> decisión, después implementar. La guía para consumir los endpoints es
> `docs/referencia/liquidaciones-tarjetas-api.md`.

## 1. Qué se quiere lograr

Que un sistema externo de conciliación de cobros electrónicos pueda materializar en Libertya la
conciliación que ya resolvió. Dos operaciones, en este orden:

1. **Resolver o crear** la `C_CreditCardSettlement` (la cabecera de la liquidación) junto a
   un `C_CreditCardCouponFilter` por defecto del cual colgar los cupones.
2. **Colgar cada cupón**: un `C_CouponsSettlements` por cobro, apuntando a su `C_Payment`.

El flujo completo del lado del consumidor y su árbol de tablas están en la documentación del propio
consumidor (§12.1).

---

## 2. El hallazgo que cambia el plan

> **La hipótesis de partida era que `MCreditCardSettlement` está acoplada a las tablas
> `i_fidelius_*` y que por eso haría falta una clase Java genérica nueva en el core.
> Revisado el código, ese acoplamiento no está donde parecía. Para el alcance de este plan
> —crear la cabecera y el filtro— las clases del core ya son genéricas y no hay que tocar
> Libertya.**

> Las líneas citadas en esta sección son las del core customizado contra el que se hizo el análisis (§12.1).
> En el core público las mismas piezas existen con otra numeración —`generateAllChildrens()`, el flag
> `generateChildrens`, el `doAfterSave`—, y `MCreditCardCouponFilter` es todavía más simple: no tiene
> `importFromFidelius()` ni `beforeSave`.

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

Lo único que hace el `beforeSave` del filtro en ese core es copiar de la cabecera una columna propia de la
instalación cuando el filtro es nuevo. Inofensivo, y en el core público no existe.

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

## 3. Contra qué core se compila, y contra cuál corre

> **Revisado al pasar a `main` (§13.4).** Esta sección recomendaba compilar contra los jars del core
> customizado. Lo que quedó es lo inverso: `main` se compila contra el core público, y una instalación
> customizada corre la API con su `OXP.jar` primero en `loader.path`. El análisis sigue valiendo como mapa de
> qué cambia entre un core y otro.

La instalación de origen corre su propio core customizado, y todo el dominio de tarjetas tiene lógica propia
ahí. **Todo el análisis de §2 y las reglas de §5 están hechos contra ese core.**

### 3.1 Lyrestapi no se "genera a partir de un core": enlaza contra sus jars

```gradle
def OXPLIBS = System.getenv("OXP_HOME")
implementation files("$OXPLIBS/lib/OXP.jar")
implementation files("$OXPLIBS/lib/OXPXLib.jar")
```

No compila contra código fuente del core. La pregunta "¿desde qué core genero lyrestapi?" es
en realidad **"¿a qué `OXP_HOME` apunto al compilar, y qué jars hay en el servidor al
correr?"**. Son dos cosas distintas y las dos importan.

### 3.2 Qué tiene el core customizado que el core público no tiene

Comparación de las clases del dominio (2026-08-20, `libertya` en **`dev`** vs el core customizado en su rama
principal; verificado también contra otra rama de trabajo de ese core, con resultados idénticos):

| Clase | Público | Customizado | Líneas distintas |
|---|---:|---:|---:|
| `MCreditCardSettlement` | 1.254 | 1.395 | 153 |
| `MCreditCardCouponFilter` | 50 | 182 | 132 |
| `MCouponsSettlements` | 56 | 92 | 36 |
| `MCreditCardClose` | 630 | 806 | 228 |
| `X_C_CouponsSettlements` | 305 | 305 | **0** |

Y el paquete propio de la customización — **242 clases que en el core público no existen**.

**Piezas concretas de las que depende este plan y que son SÓLO del core customizado:**

| Pieza | ¿En el público? | Consecuencia de no tenerla |
|---|---|---|
| **R7** — un `C_Payment` no puede estar en dos liquidaciones | ❌ | `MCouponsSettlements` del público **no tiene `beforeSave`**. La invariante que el conciliador trata como "regalo del ERP" simplemente no se aplica |
| **R6** — `Include`/`IsReconciled` exigen `C_Payment_ID` | ❌ | Se pueden marcar cupones conciliados sin pago |
| **Tolerancia configurable** de cuadratura | ❌ | Ver 3.3 |
| Una columna propia en la liquidación que apunta a una tabla de plugin (13 usos) | ❌ | En el público no existen ni la tabla ni su clase, que vive en el paquete de la customización |
| `importFromFidelius()` y el `beforeSave` del filtro | ❌ | Irrelevante: el plan no los usa |

**Piezas compartidas** (existen igual en los dos): `generateAllChildrens()`, el flag
`generateChildrens`, R1 (`SettlementNo` numérico), R2 (unicidad), R5 (cuenta bancaria), el
rollup `calculateSettlementCouponsTotalAmount()` y el `doAfterSave` de las hijas.

### 3.3 El público valida la cuadratura con igualdad exacta

```java
// core público
boolean validSettlement = amt1.equals(amt2);

// core customizado
BigDecimal difference = amt1.subtract(amt2).abs();
boolean validSettlement = difference.compareTo(getTolerancia()) <= 0;
```

Dos diferencias, y las dos importan:

1. **El público no tiene tolerancia alguna.** Con los datos de la instalación de origen cuadra el 5,3 % de las
   liquidaciones de Payway *con* $0,50 de margen; sin margen sería bastante menos.
2. `BigDecimal.equals()` **compara también la escala**: `100.00` y `100.0` no son iguales. Y
   los `setScale(2, ...)` de arriba **descartan su resultado** (`setScale` devuelve un
   BigDecimal nuevo, no muta). O sea que la versión pública es más estricta *y* más frágil.
   La del core customizado, con `compareTo`, es la corregida.

### 3.4 La buena noticia: el código de lyrestapi ya es agnóstico

Hoy `src/` **no tiene una sola referencia al paquete de la customización**: sólo importa
`org.openXpertya.{model,process,util,db}`. Y `AbstractRepository` no usa getters tipados sino
metadata viva de `M_Column`, y el core customizado mismo accede a su columna propia con
`get_Value(...)` — un acceso dinámico que funciona sobre cualquier `PO` tenga o no la clase generada esa
columna.

**Consecuencia: este plan no necesita ninguna API Java exclusiva del core customizado.** Lo que cambia es el
*comportamiento* (R6, R7, la tolerancia), que lo aporta el jar en tiempo de ejecución.

### 3.5 Recomendación (2026-08, revisada en §13.4)

> **Compilar contra los jars del core customizado, y mantener el código fuente portable. La bifurcación va
> en el destino del build, no en el source.**

| Opción | Veredicto |
|---|---|
| Compilar contra público, correr contra el customizado | ❌ Es una combinación que nadie prueba, justo en las clases que más divergen (153 y 132 líneas). No hay ningún beneficio a cambio. **Es la que quedó al pasar a `main`** (§13.4): el beneficio que no se veía era que `main` no dependa de ninguna instalación |
| Compilar y correr contra el customizado, con fork del source | 🟡 Funciona, pero el fork no hace falta hoy: el código no necesita API del core customizado |
| **Compilar y correr contra el customizado, source portable** | ✅ **Recomendada en 2026-08.** `OXP_HOME` apuntando a sus jars; sin importar el paquete de la customización; columnas propias por nombre, nunca por getter tipado |

En la práctica: **una rama en lyrestapi** (`liquidaciones-tarjetas`) para el desarrollo, que
puede mergear a `main` sin volverlo dependiente de esa instalación. Lo que sí es específico de la instalación
es el *despliegue*: con qué core corre la API.

⚠️ **Y hay que documentarlo en el endpoint**: estas operaciones **asumen R6 y R7**. Si alguien
las desplegara sobre una instalación con core público, el ERP **no rechazaría** un
`C_Payment` cargado en dos liquidaciones, y el doble impacto pasaría en silencio. Es un
argumento más para que las dos guardas del conciliador (tabla `impacto` propia + `GET` en
vivo) no se consideren opcionales: no pueden delegarse enteras en la invariante del ERP.
`/bulk` controla R7 del lado de la API en cualquier core —consulta antes qué cobros ya están colgados—, así
que la advertencia aplica sobre todo al `POST` de a un cupón (§13.2).

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

**En el core: ninguna.** Es la conclusión de §2, y la decisión de quedarse en
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

> La documentación de diseño del consumidor (§12.1) advertía que **"el `iface` del repositorio tiene que
> apuntar a la clase `M*`, no a la `X_*`"** y lo declaraba el primer test a escribir. **Revisado el código el
> 2026-08-20, eso no es así.** Hay que corregirlo allá también, porque manda a resolver un problema que no
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
un error: sería que el ERP acepta en silencio lo que el core customizado habría rechazado.

Por eso el primer test sigue valiendo, con otro objetivo: **verificar que el comportamiento
del core que efectivamente está cargado es el que se espera.**

| Verificar | Cómo | Qué prueba |
|---|---|---|
| Los rollups corren | Insertar una fila de `C_CommissionConcepts` y ver que `CommissionAmount` de la cabecera se actualiza | Que se resolvió la `M*` y no la `X_*` |
| Las hijas se crean solas | `POST` de una cabecera y contar filas en las cinco tablas de conceptos | `generateAllChildrens()` |
| **Está cargado el core customizado** | Intentar crear dos `C_CouponsSettlements` con el mismo `C_Payment_ID` y esperar el rechazo | **R7 — si pasa, el jar es del core público** |

El tercero es el importante y el que nadie tenía anotado.

> Al pasar a `main` el tercero salió del repo (§13.3): R7 no existe en el core público, así que se verifica
> en la instalación que la tiene. En su lugar quedó un test que cuelga un cupón, que el del lote necesita.

---

## 5. Las reglas del core que el endpoint tiene que respetar

Verificadas en `MCreditCardSettlement.beforeSave` del core customizado (línea 145 en adelante; R1–R3 están
igual en el público), que termina en `return found == 0` — o sea que **todas bloquean el guardado**.

| # | Regla | Mensaje del core | HTTP propuesto |
|---|---|---|---|
| R1 | `SettlementNo` sólo puede ser numérico: `matches("\\^?\\d*\\^?")` | `SettlementNumberMustBeNumeric` | 409 |
| R2 | Unicidad por `C_BPartner_ID` + `SettlementNo` + `PaymentDate::date` | `CreditCardSettlementDuplicated` | **409 devolviendo el `C_CreditCardSettlement_ID` existente** |
| R3 | Marcar `IsReconciled='Y'` exige que no queden cupones sin conciliar | `ExistsNotReconciledSettlementCoupons` | 409 |
| R4 | `completeIt()` exige cuadratura ≤ tolerancia (`ToleranciaCompletadoLiquidacionesTarjetas`, default $0,50). En el core público, igualdad exacta (§3.3) | `CreditCardSettlementAmountsMismatch` | 409 |
| R5 | Al completar, si la entidad financiera no tiene `c_bankaccount_settlement_id`, falla | `SettlementBankAccountNotConfigured` | 409 |

Y en `MCouponsSettlements` (R6 y R7 en el `beforeSave` del core customizado —el público no tiene
`beforeSave`—; R8 en el `beforeDelete`, en los dos):

| # | Regla | HTTP |
|---|---|---|
| R6 | `Include='Y'` o `IsReconciled='Y'` exigen `C_Payment_ID` | 409 |
| R7 | Un `C_Payment_ID` no puede estar en dos liquidaciones | **409 devolviendo el `C_CouponsSettlements_ID` que lo tiene** |
| R8 | Un cupón conciliado no se puede borrar (`beforeDelete`) | 409 |

> **R2 y R7 son las dos importantes para el conciliador.** No alcanza con un 409: el body
> tiene que traer el id del registro que ya existe, porque es exactamente lo que el
> conciliador necesita para resolver sin adivinar. Sin eso tiene que salir a buscarlo con
> un GET extra por cada colisión.

> **R1 tiene consecuencia de diseño**: la clave compuesta interna del sistema externo (`liquidacion_key`)
> **no sirve** como `SettlementNo` (ver §6).

---

## 6. Lo que dicen los datos

Medido el **2026-08-20** sobre los datos de la instalación de origen (§12.1). Son de una sola instalación:
sirven como orden de magnitud para dimensionar, no como regla, y los topes que salieron de acá son
configurables.

### 6.1 El `SettlementNo` es `nro_liquidacion`, no `liquidacion_key`

`liquidacion_key` es una clave compuesta interna del sistema externo (`F|1145280`,
`P|113497|30059091|2026-07-07`). El número que el ERP espera es `nro_liquidacion`:

| Fuente | Eventos con `nro_liquidacion` | Numéricos |
|---|---:|---:|
| fidelius | 1.657.953 | **100 %** |
| payway | 185.954 | **100 %** |
| mercadopago / nave | 0 | — |

Cumple R1 sin transformación. Y en una réplica de `C_CreditCardSettlement` de producción, 324.060 de 324.069
`settlementno` cumplen el mismo regex, así que la regla es la que efectivamente rige.

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

Mercado Pago y Nave no aparecen en esta tabla porque no tienen liquidación de origen — es un
pendiente del consumidor (T3), y bloquea a 205.056 cobros.

### 6.3 Estado de las liquidaciones que ya existen

`docstatus` sobre `isactive='Y'`: Payway tiene **365 en `IN`** y 22 en `DR`.

> ⚠️ Los pendientes del consumidor (C9) hablan de **818** liquidaciones de Payway en
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

Medido el 2026-08-20, en la instalación de origen:

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
> es grave**: ese campo no participa de ninguna validación del core (lo revisó la documentación
> del consumidor sobre tolerancia de importe), sólo se muestra. El lote siguiente lo corrige. Aun así, la
> optimización es **opcional**: hasta el p99 el costo es irrelevante y conviene medirlo antes de agregar
> código.

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
(del lado del consumidor), y se ejecuta una vez por cobro por corrida. Con ~300.000 cobros pendientes,
resolverlo de a uno es la diferencia entre una corrida de minutos y una de horas.

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
`M_EntidadFinancieraPlan_ID`, `PaymentBatch`, `TrxDateFrom`, `TrxDateTo`, `IsProcessed`, más las columnas
propias que agregue una instalación. Si no se manda el bloque `filter`, el servicio hereda de la cabecera
`AD_Org_ID`, `C_Currency_ID` y `C_BPartner_ID`; las columnas propias no se heredan (§13.1).

> **Por qué un filtro por defecto y no colgar los cupones directo de la cabecera:** el core
> recorre los cupones *a través del filtro* en `changeCouponsAuditStatus()`. Un cupón sin
> filtro no aparece en esa consulta, así que al anular la liquidación **no se le revierte el
> estado de auditoría al `C_Payment`**. No rompe nada visible, pero deja el cobro mintiendo.
> En la base de producción de la instalación de origen, el 100 % de las 7.186.854 filas activas de
> `C_CouponsSettlements` tiene filtro.

### Fase 3 — completar *(bloqueada por T1 y F1, no arrancar)*

```
POST /v1.0/creditcardsettlements/{id}/process?docaction=CO|VO|CL
```

`CO` dispara `completeIt()`, exige la cuadratura de R4 y **crea un `C_Payment` por el neto**.
Con los datos de hoy sólo cuadran el 5,3 % de las de Payway y el 67,5 % de las de Fidelius.
**Exponer el endpoint sin resolver T1 es fabricar liquidaciones en `IN`.**

> ✅ **Decidido el 2026-08-20 (Julián): el `POST` de la fase 2 deja la liquidación en `DR` y
> no se expone `docaction=CO`.** Con eso las fases 1 y 2 **dejan de depender de T1 y F1** y se
> pueden construir ya. Ver §9. Esto cierra el punto que los pendientes del consumidor marcaban como abierto
> al final.

> ✅ **Implementado el 2026-08-26, revirtiendo la decisión de arriba a pedido del consumidor.**
> La firma real es `PUT /v1.0/creditcardsettlements/{id}/process?action=CO|VO|CL`: `PUT` y `action`,
> que es la convención de los otros diez endpoints de procesado de la API y lo que documenta el
> manual para desarrolladores, no el `POST ...?docaction=` que proponía este borrador.
>
> **El argumento de "fabricar liquidaciones en `IN`" no aplicaba a esta API.** `processEntity`
> revierte la transacción cuando el estado resultante no coincide con la acción pedida, así que un
> `CO` que no cuadra devuelve 409 y deja la liquidación en `DR`. Las `IN` de producción del §6.3 las
> deja la **ventana del ERP**, que sí persiste el estado inválido. Lo que sigue en pie es T1/F1:
> exponer el endpoint no cambia el volumen conciliable —hoy cuadran el 5,3 % de Payway y el 67,5 %
> de Fidelius—, sólo habilita completar lo que ya cuadra.
>
> Tres cosas que aparecieron al revisar el core para escribirlo, todas documentadas en el yaml del
> endpoint porque ninguna se deduce del modelo:
>
> 1. `completeIt()` llama a `removeUnusedChildrens()`, que borra las filas hijas en cero con
>    `DB.executeUpdate(sql)` **sin `trxName`**: ese borrado se autocommitea y **sobrevive al
>    rollback**. Un `CO` fallido después de la cuadratura no es un no-op.
> 2. `reActivateIt()` devuelve `false`. Completar es **irreversible** salvo por `VO`.
> 3. `voidIt()` borra los cupones con un `DELETE` directo sobre `C_CouponsSettlements`, salteando la
>    regla R8, y le agrega un `^` al `SettlementNo`. Para deshacer algo que sigue en `DR` hay que usar
>    el `DELETE` de la liquidación, no `VO`.

---

## 8. Plan de implementación

Para ejecutar con Claude Code desde este repo, en una rama nueva
(sugerencia: `liquidaciones-tarjetas`).

### Paso 0 — el test de que el core cargado es el que creemos

> Antes de compilar: `OXP_HOME` tenía que apuntar a los jars del core customizado (§3.5). Al pasar a `main`
> se compila contra el core público (§13.4).

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
dos pasan igual en ambos cores. (Salió del repo al pasar a `main`, §13.3.)

### Paso 1 — esquema y stubs

Agregar las entidades a `utils/genSchema.sh` y regenerar con `utils/genClasses.sh`.

⚠️ En la rama se verificó que la columna propia de la instalación en `C_CreditCardSettlement` apareciera en
el schema: no está en la clase generada `X_C_CreditCardSettlement` y el core customizado la lee con
`get_Value(...)`. **Al pasar a `main` se sacó** (§13.1): las columnas propias no van al schema, viajan en
`additionalvalues`.

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

`docs/referencia/liquidaciones-tarjetas-api.md`, al estilo de `docs/referencia/asientos-manuales-api.md`, y
el plan (este documento) en `docs/planes/plan-liquidaciones-tarjetas.md`.

---

## 9. Decisiones tomadas

| Decisión | Quién / cuándo | Consecuencia |
|---|---|---|
| **El `POST` deja la liquidación en `DR`. No se expone `docaction=CO` en esta etapa.** | Julián, 2026-08-20 | El plan **deja de depender de T1 y F1**: no hay que reconstruir la deducción ni resolver el residuo para avanzar. Ninguna llamada de la API crea un `C_Payment` ni contabiliza nada |
| **Se expone el procesado del documento (`CO`, `VO`, `CL`), revirtiendo la primera fila.** | Julián, 2026-08-26 | A pedido del consumidor. No destraba volumen —T1/F1 siguen decidiendo qué cuadra— pero deja de hacer falta la ventana del ERP para completar lo que ya cuadra. La API no puede dejar liquidaciones en `IN`: revierte. Ver la fase 3 del §7 |
| ~~**Un endpoint de sólo lectura para el maestro de comercios de la instalación (E11), adelantado a la fase 1.**~~ | Julián, 2026-08-21; **revertida al pasar a `main`**, 2026-11 | Era una tabla de plugin de una sola instalación. En `main` no hay endpoints tipados para tablas que no son del core público: se leen con `/v1.0/generic/{table}`. Historia en §12.2 |
| **El contrato lleva sólo columnas y tablas del core público.** Las columnas propias de una instalación se leen y escriben por `additionalvalues`; sus tablas, por el endpoint genérico | 2026-11, al pasar a `main` | Ver §13 |

Consecuencias operativas de dejar todo en `DR`, para tener presentes:

- La liquidación **existe y tiene sus cupones colgados**, que es lo que cierra la brecha
  sistema externo ↔ Libertya. Eso ya sirve al negocio.
- **No genera asiento contable** hasta que alguien la complete —desde la ventana del ERP o
  desde un endpoint futuro—. Conviene que Finanzas sepa que ese paso queda pendiente y en
  manos de una persona.
- Una liquidación en `DR` **sí se puede borrar**, a diferencia de una completada. El error es
  reversible mientras no se complete: es exactamente la propiedad que se quiere para arrancar.
- Cuando T1 y F1 se resuelvan, completar es un `PUT /{id}/process?action=CO` **sobre las
  liquidaciones que ya están creadas**. No hay que rehacer nada.

---

## 10. Decisiones abiertas antes de empezar

| # | Pregunta | Dueño |
|---|---|---|
| 1 | ¿`C_CreditCardCouponFilter.C_CreditCardSettlement_ID` es NOT NULL en la base? Decide si el filtro es obligatorio o una recomendación | verificable en QA |
| 2 | ~~¿Qué `C_BPartner_ID` corresponde a cada adquirente?~~ **Cerrada: la premisa estaba equivocada.** No hay una entidad comercial por adquirente o por tarjeta. En el core público sale de la entidad financiera (`M_EntidadFinanciera.c_bpartner_id`), que es de donde la toman los importadores y donde `completeIt()` busca la cuenta bancaria; una instalación puede resolverla con un maestro propio (§12.2) | cerrada |
| 3 | ~~Las liquidaciones que el ERP dejó en `IN`: ¿se tocan, se ignoran, o la integración no opera sobre ellas?~~ **No es una decisión de la API**, sino de cada integración sobre sus datos. La API no las toca por su cuenta: `process` aplica sólo la acción que se le pide (§7, fase 3) | fuera de alcance |
| 4 | ~~¿Hace falta un endpoint de sólo lectura para el maestro de comercios de la instalación (E11)?~~ **Cerrada dos veces**: se implementó en la rama (2026-08-21) y se sacó al pasar a `main` (2026-11), donde se lee con el endpoint genérico. Ver §12.2 y §13 | cerrada |
| 5 | ~~La rama, ¿mergea a `main` o queda como fork de una instalación?~~ **Cerrada en 2026-11: mergea**, sin lo propio de la instalación. El source no necesitaba API del core customizado (§3.4); lo específico quedó en el despliegue (§13.4) | cerrada |
| 6 | ¿Se implementa la supresión del rollup (`setReconciledFlag`) en el `bulk`, o se acepta el O(N²)? **Recomendación: medir primero** — hasta el p99 no duele | técnica |

---

## 11. Resumen para quien tenga que decidir rápido

- **No hay que tocar el core de Libertya** para crear la cabecera ni el filtro. Las clases
  `M*` ya son genéricas; el acoplamiento a `i_fidelius_*` está en los procesos de
  importación, que este plan no usa.
- **El endpoint compuesto va en la capa de servicio de lyrestapi**, que es el patrón que el
  repo ya usa para facturas y asientos. Eso no viola el "thin layer": es orquestación
  transaccional, no lógica de negocio.
- **Empezar por el `GET`**, no por el `POST`: en la instalación de origen, el 97 % de las liquidaciones de
  Fidelius y el 80 % de las de Payway ya existían en el ERP.
- **El primer test no es el del `iface`** —esa advertencia heredada es incorrecta, ver §4—
  sino el de **R7**: crear dos cupones con el mismo `C_Payment_ID` y verificar que el ERP
  rechaza el segundo. Es lo único que prueba que el core cargado es el customizado que se espera (salió del
  repo al pasar a `main`, §13.3).
- ~~**Compilar contra los jars del core customizado**, no el público.~~ **Revisado al pasar a `main`
  (§13.4):** se compila contra el core público, y una instalación customizada corre la API con su `OXP.jar`
  en `loader.path`. R6, R7 y la tolerancia de cuadratura son de ese core y rigen sólo si está cargado. El
  source sigue sin tocar el paquete de la customización.
- **Tres llamadas por liquidación, no una ni N**: `/full` atómico para cabecera + filtro,
  y `bulk` de cupones con resultado por ítem (sin rollback del lote). En la instalación de origen la mediana
  son 4-7 cupones pero el máximo histórico es 3.504.
- ✅ **Decidido: el alta deja todo en `DR`**, así que el plan **no depende de T1 ni de F1** y se pudo empezar.
  Completar es una llamada aparte, `PUT /{id}/process?action=CO`, expuesta el 2026-08-26 (§7, fase 3). Sigue
  siendo T1/F1 lo que decide qué liquidación puede completarse, no la API.

---

## 12. De dónde salió esto

### 12.1 El pedido y el core de origen

El pedido vino de Tehuelche, una instalación de Libertya con un core customizado, para su Conciliador de
Cobros Electrónicos: un sistema externo que concilia los cobros electrónicos en un datamart propio y
necesitaba materializar esa conciliación en el ERP. Este plan se escribió primero en el repo de ese consumidor
y se trajo a lyrestapi al arrancar la rama.

- El análisis de §2–§5 se hizo contra el código de ese core customizado, y los números de §6 y §7 contra datos
  de producción de esa instalación replicados en el datamart del consumidor.
- T1, T3, F1 y C9 son pendientes de la documentación del consumidor, igual que el flujo de impacto, el
  árbol de tablas y el análisis de tolerancia de importe que cita este plan. Viven en su repo, no en este.
- Durante la rama, el contrato llevaba las columnas propias de esa instalación y un endpoint para una tabla de
  su plugin (§12.2). Al pasar a `main` se sacaron (§13).

### 12.2 `numeroscomercio` (E11): implementado en la rama, sacado de `main`

Se implementó el 2026-08-21 a pedido de quien integraba. En esa instalación la entidad comercial de la
cabecera no se deducía del adquirente —sobre sus datos, un mismo adquirente operaba contra hasta seis
entidades comerciales— sino del número de comercio, y ese mapeo vivía en `M_NumeroComercio`, una tabla de su
plugin. Se expuso de sólo lectura (`GET /v1.0/numeroscomercio` y `/{id}`): el maestro se administra desde el
ERP, y un `PUT` habría permitido cambiar desde una integración la cuenta bancaria de liquidación de un
comercio.

Lo que se aprendió ahí y sigue valiendo en general:

- **Una copia desnormalizada en `M_EntidadFinanciera` se puede quedar vieja.** En ese core, el `afterSave`
  del maestro sincronizaba sólo al modificar un comercio existente, nunca al crear uno nuevo, y había
  entidades financieras activas sin comercio asignado.
- **Una tabla de plugin sin el registro de su componente da un 404 mudo** en un endpoint tipado:
  `M_Table.getPO()` devuelve `null` en vez de fallar. El endpoint genérico, en cambio, lo informa (*"No se
  encontró la clase de modelo"*).
- **La clave natural de un maestro propio puede no ser única**: había comercios repetidos entre sucursales.
- **`ClientOrgAuth` sólo filtra por compañía, no por organización**: un token de una sucursal lee registros
  de las otras.
- Para que se vieran en Swagger, se agregaron a mano dos columnas propias al schema de `EntidadFinanciera`:
  una regeneración completa contra esa base arrastraba columnas de TPV que nadie había pedido. También se
  sacaron al pasar a `main`.

Se sacó porque la tabla, sus columnas y su clase existen sólo en esa instalación. Ahí se lee con
`/v1.0/generic/M_NumeroComercio`, con el `OXP.jar` de la instalación cargado (§13.4).

---

## 13. Al pasar a main (2026-11)

`main` lleva sólo lo que pertenece al core público de Libertya. La rama traía en el contrato una tabla y
columnas que existen sólo en el diccionario de la instalación de origen; esto es lo que cambió y por qué.

### 13.1 El contrato

- **Fuera de los schemas**: `adquirente`, `establishmentnumber`, `financingservice` y `m_numerocomercio_id`
  en `creditcardsettlements` (y en el `header` de `/full`); `adquirente`, `financingservice` y
  `m_numerocomercio_id` en `creditcardcouponfilters` (y en el `filter` de `/full`). Ver
  `src/main/resources/model/creditcardsettlement.yaml` y `creditcardcouponfilter.yaml`. El schema de
  `entidadesfinancieras` volvió a ser el de `main`.
- **Fuera `/v1.0/numeroscomercio`** (`M_NumeroComercio`). Una instalación que tenga esa tabla la lee con el
  endpoint genérico, `/v1.0/generic/{table}` (`docs/referencia/endpoint-generico-api.md`).
- **`/full`**: si no viene el bloque `filter`, el servicio crea uno heredando de la cabecera `ad_org_id`,
  `c_currency_id` y `c_bpartner_id` (`CreditCardSettlementService.buildFilter`). Ya no copia
  `m_numerocomercio_id`.
- **Las columnas propias de una instalación viajan en `additionalvalues`**, la lista de `{"key", "value"}` que
  tienen todos los DTO:
  - al escribir, la clave es el nombre de la columna en minúscula, con o sin guiones bajos
    (`x_codigo_externo` o `xcodigoexterno`), y el valor va como texto; si la columna no existe en la
    instalación, se ignora;
  - al leer, las claves vienen **normalizadas** (minúscula, sin guiones bajos: `xcodigoexterno`), salvo
    que dos columnas colisionen al normalizar; los valores vienen como texto; y `additionalvalues` viene sólo
    sin `fields`, o cuando `fields` lo nombra;
  - **un campo JSON que no está en el schema se descarta en silencio** (200, y no se graba nada): mandar una
    columna de la instalación como campo suelto no la guarda.
- **Nuevo en esta rama**: `referencedvalues` (`<col>__value`, `<col>__detail`, con las claves conservando los
  guiones bajos) también se arma para las columnas de referencia a tabla que viajan en `additionalvalues`. Sin
  `fields`, para todas; con `fields`, sólo para las columnas nombradas en `fields`.

**Por qué así y no con las columnas en el schema:** el schema de `main` describe el core público, y esas
columnas no existen fuera de la instalación de origen. Con `additionalvalues` la instalación sigue pudiendo
escribirlas y leerlas sin que el contrato las nombre.

### 13.2 Las reglas de negocio: qué es del core público y qué no

- **R6** (`include`/`isreconciled='Y'` exigen `c_payment_id`) y **R7** (un `c_payment_id` no puede estar en
  dos liquidaciones) están implementadas **sólo** en el core customizado (`MCouponsSettlements.beforeSave`).
  El core público (`../libertya/base/src/org/openXpertya/model/MCouponsSettlements.java`) no las tiene, así
  que sobre él un `POST /couponssettlements` suelto **no rechaza** un cobro que ya está en otra liquidación.
- **`/couponssettlements/bulk` nunca cuelga un cobro que ya está en otra liquidación, en ninguna
  instalación**: la API lo consulta antes y lo informa como `conflicto`, con el motivo que arma el propio
  código (`R7: el cobro ya esta cargado en otra liquidacion`). Si el core de la instalación rechaza un ítem
  con sus mensajes de R6/R7, el lote también lo informa como `conflicto`
  (`CouponsSettlementsService`).
- **R1** (`settlementno` numérico), `generateAllChildrens()` y las reglas de `beforeDelete` (R8) están también
  en `MCreditCardSettlement` / `MCreditCardCouponFilter` del core público. **R2** con el id de la liquidación
  existente en el 409 la implementa el servicio de la API.
- La tolerancia de cuadratura de R4 es del core customizado; el público compara en forma exacta (§3.3).

### 13.3 Verificación

El 2026-11-02 los 17 tests de `CreditCardSettlementIntegrationTests` pasaron contra el core público (26.09
`dev`, build 20261028) sobre la base de tests `libertya_rel_22ar_for_api_25`. Hace falta
`org.libertya.tests.use-dynamic-defaults=true`, porque la entidad comercial por defecto ya no existe en esa
base. Ejercitan `/full`, el alta de un cupón suelto, `/bulk`, `/exists`, las bajas rechazadas, completar (`CO`)
y anular (`VO`).

El test de R7 del Paso 0 salió del repo: la regla existe sólo en el core de la instalación y se verifica en
ella, fuera de este repo. En su lugar quedó un test que cuelga un cupón, que el test del lote necesita.

### 13.4 Empaquetado

La API embebe el core. Una instalación con un core customizado corre lyrestapi compilada contra el core
público, con los jars de la instalación primero en `-Dloader.path` (ver `docs/compatibilidad-core.md` §3,
caso 3, y `docs/planes/plan-endpoint-generico.md` §4, cuyo cuidado 2 dice qué hacer con `OXPXLib.jar`). Las
reglas de negocio de esa instalación —como R6 y R7— sólo aplican cuando es su core el que está corriendo: para
confirmarlo, mirar la línea de arranque `Core de Libertya cargado desde: ...`.

Es la combinación que §3.5 descartaba en 2026-08 ("compilar contra público, correr contra el customizado").
Lo que cambió es que el endpoint genérico ya había resuelto y verificado cómo cargar el `OXP.jar` de una
instancia por `loader.path`, y que `main` no puede depender de los jars de una instalación.
