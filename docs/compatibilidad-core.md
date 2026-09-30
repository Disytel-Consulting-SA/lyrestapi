# Compatibilidad lyrestapi ↔ Libertya core

**Para qué sirve:** saber con qué versión del core de Libertya se puede compilar y desplegar cada versión de
lyrestapi, y por qué. La tabla (§4) es para consultar rápido; la bitácora (§6) explica cada incompatibilidad:
qué cambió, cómo se manifiesta y qué hay que hacer.

**Por qué hace falta:** lyrestapi no habla con el servidor de Libertya. **Embebe el core** (`OXP.jar` y
`OXPXLib.jar` de `$OXP_HOME/lib`, dentro del fat jar) y lo ejecuta directamente contra la base de la instancia.
O sea que en cada despliegue conviven tres cosas que pueden ser de versiones distintas: el core con el que se
compiló lyrestapi, la base de la instancia y, si se usa `loader.path`, el `OXP.jar` propio de la instancia.

---

## 1. Cuándo agregar una entrada

- **Un cambio de lyrestapi empieza a usar algo del core que no existía antes** (un método, una clase, una
  columna). Es el caso más común y el más fácil de no ver: compila en la máquina de quien lo escribió, que tiene
  el core al día, y rompe en la de al lado.
- **Se arma un jar para desplegar** contra un core o una base de otra versión.
- **Aparece una incompatibilidad en un despliegue.**

En todos los casos: una fila o un ajuste en la tabla (§4), una nota en la bitácora (§6, con la plantilla de §7)
y, si agrega un requisito, su chequeo en §5.

---

## 2. Cómo identificar cada versión

| Qué | Dónde se ve | Ejemplo |
|---|---|---|
| **lyrestapi** | El commit de git. La `version` de `build.gradle` es siempre `1.0.0` y no sirve para esto | `f11f167` |
| **Core, en el repo** | El tag de release (`v25.0`, `v26.05`, `v26.09`, en `master`) o el commit de `dev`. `git tag --contains <commit>` dice en qué release entró un commit; si no devuelve nada, todavía no hay release que lo incluya | `v26.09`, `dev@b9213a78` |
| **Core, en un jar** | `unzip -p OXP.jar META-INF/MANIFEST.MF \| grep Implementation-Version`. Ojo: un build de `dev` posterior a un release también dice `Versión 26.09`; lo que lo distingue es la fecha | `Versión 26.09 20260929-2359` |
| **Core, en ejecución** | La primera línea que loguea lyrestapi al arrancar: de qué jar se cargó el core y su versión | `Core de Libertya cargado desde: ...OXP.jar!/ (version: Versión 26.09 20260929-2359)` |
| **Esquema de la base** | `SELECT version FROM AD_System`. Es el `DB_VERSION` de `OpenXpertya.java` del core que la instaló o actualizó | `28-08-2026` |

**Nombre del jar:** como la `version` de `build.gradle` no cambia, conviene nombrar el jar con el core que embebe,
como el precedente `lyrestapi-1.0.0_for_LY22.0ar.jar`. Para un core de `dev`, agregar la fecha del build:
`lyrestapi-1.0.0_for_LY26.09-dev-20260929.jar`.

Equivalencias de `DB_VERSION` por release: `v25.0` = `12-11-2025`, `v26.05` = `08-05-2026`,
`v26.09` = `28-08-2026`. Los cambios de esquema entre versiones están en el repo del core, en
`data/core/upgrade_from_<version>/preinstall_from_<version>.sql`.

---

## 3. Qué se puede romper, y cuándo

| # | Combinación | Síntoma | Cuándo aparece |
|---|---|---|---|
| 1 | lyrestapi usa algo del core que el core de `$OXP_HOME` no tiene | `cannot find symbol` al compilar | **Al compilar.** Es el caso seguro: no sale ningún jar |
| 2 | El core embebido espera un esquema que la base de la instancia no tiene (la base es más vieja) | Validaciones del modelo que fallan porque la columna nueva siempre llega en null (§6.2), o `column/relation ... does not exist` en SQL explícito | **En runtime**, solo en las operaciones que tocan lo nuevo |
| 3 | El `OXP.jar` de la instancia va en `loader.path` (customizaciones) y es más viejo que lo que lyrestapi necesita | `NoSuchMethodError` / `NoClassDefFoundError` → **500** | **En runtime**, recién al usar ese camino. La app arranca normal y no avisa |

Y una cuarta que no rompe nada pero conviene tener presente: **la lógica de negocio de la API es la del core
embebido**, no la del servidor de la instancia. Si la instancia tiene reglas propias en su `OXP.jar` (una
customización) y lyrestapi embebe el core público sin `loader.path`, los documentos creados por la API **no**
pasan por esas reglas. Para una instancia customizada, el core que ejecute lyrestapi tiene que ser el de la
instancia: compilando con sus jars, o poniendo su `OXP.jar` en `loader.path` (ver
`docs/planes/plan-endpoint-generico.md` §4).

**Regla práctica:** el core embebido tiene que ser **de la misma versión de esquema que la base** (mismo
`DB_VERSION`, o sin cambios en los `preinstall` entre ambas), y **igual o más nuevo que lo que pide la tabla
de §4**.

---

## 4. Tabla de compatibilidad

La más nueva arriba.

| lyrestapi | Core necesario para compilar | Esquema de base | Verificado | Nota |
|---|---|---|---|---|
| desde `2bdd59b` (2026-09-04) | Un core que incluya `e1259b8a` (2026-09-04). **Hoy solo `dev`**: ningún release lo incluye todavía, el primero va a ser el siguiente a 26.09 | 26.09 (`28-08-2026`). El `preinstall_from_26.09` de `dev` está vacío, así que este core no agrega cambios de esquema | 2026-09-30, con el core `dev@b9213a78` (`Versión 26.09 20260929-2359`): compilación, suite de integración y smoke con una instancia customizada vía `loader.path` | §6.1 |
| hasta `8ddb196` (2026-09-04) | 26.05 o posterior (sin requisitos posteriores conocidos) | La de su core; ojo con bases anteriores a 26.05 | 2026-09-30: `8ddb196` compila con el core `dev` del 2026-08-25 (`Libertya 20260825-1522`) y `2bdd59b` ya no | §6.2 |
| publicada como `lyrestapi-1.0.0_for_LY22.0ar.jar` (commit no registrado) | 22.0 **más** los commits de core `a101ec1` y `99b34e5` (incluidos de fábrica desde `v25.0`) | 22.0 | Según el manual para desarrolladores | §6.3 |

---

## 5. Chequeos antes de armar y desplegar un jar

```bash
# 1) El core a embeber tiene todo lo que lyrestapi necesita (uno por requisito de la tabla de §4)
javap -cp $OXP_HOME/lib/OXP.jar org.openXpertya.model.MField | grep -q getAD_Field_ID && echo OK   # §6.1

# 2) Qué versión de core se va a embeber
unzip -p $OXP_HOME/lib/OXP.jar META-INF/MANIFEST.MF | grep Implementation-Version

# 3) OXPXLib.jar sano: la primera tiene que decir "3 files" y la segunda "0 files" (§6.4)
X=$OXP_HOME/lib/OXPXLib.jar
unzip -l $X org/postgresql/ds/PGSimpleDataSource.class oracle/jdbc/OracleConnection.class \
            javax/mail/internet/AddressException.class | tail -1
unzip -l $X 'org/slf4j/impl/*' | tail -1

# 4) Esquema de la base destino: tiene que coincidir con el DB_VERSION del core embebido (§2)
psql -h <host> -U <usuario> -d <base> -Atc "SELECT version FROM AD_System"

# 5) Después de desplegar: confirmar en el log de arranque qué core se cargó
grep "Core de Libertya cargado desde" <log>
```

Si la instancia pone su propio `OXP.jar` en `loader.path`, el chequeo 1 hay que correrlo **también sobre ese
jar**, porque es el que termina ejecutándose (§3, caso 3).

---

## 6. Bitácora

### 6.1 2026-09-04 — lyrestapi usa `MField.getAD_Field_ID()`, que agregó el core en `e1259b8a`

**Qué cambió en el core:** el commit `e1259b8a` (2026-09-04) agrega tres getters públicos a `MField`:
`getAD_Field_ID()`, `getAD_Table_ID()` y `getReadOnlyLogic()`. Son 13 líneas de Java, **sin cambios de
diccionario ni de base**. No es un error del core: lyrestapi pasó a depender de ellos.

**Qué cambió en lyrestapi:** los endpoints de estado de ventana (commits `2bdd59b`, `046c205` y `abd22a7`, del
2026-09-04 al 2026-09-18) llaman a `MField.getAD_Field_ID()` desde `WindowFieldStateEngine` y
`WindowCalloutExecutor`. Endpoints afectados: `POST /v1.0/tabs/{id}/new-record`, `/evaluate` y `/callout`.

**Cómo se manifiesta:**

- **Al compilar** con un core anterior: `cannot find symbol: method getAD_Field_ID()`. Pasó el 2026-09-29: ningún
  `OXP.jar` de la máquina de desarrollo tenía el commit.
- **En un despliegue normal** (core embebido): nada. El fat jar trae su propio core, y este commit no pide
  cambios de base: una instancia con la base en 26.09 no necesita actualizar nada para usar un lyrestapi que
  embeba `dev`.
- **Con el `OXP.jar` de la instancia en `loader.path`** y ese jar anterior a `e1259b8a`: la app arranca normal y
  el resto funciona, pero esos tres endpoints responden **500** con
  `NoSuchMethodError: org.openXpertya.model.MField.getAD_Field_ID()I`. Verificado el 2026-09-30: la misma llamada
  da 500 con el jar de una instancia de agosto por delante y 200 con el core embebido. Como es un `Error` y no una
  `Exception`, los `catch` de los controllers no lo atrapan.

**Qué hacer:** compilar con un core que incluya `e1259b8a` (hoy, `dev`). Para una instancia que use su propio
`OXP.jar`: construirlo sobre un core que incluya ese commit. Si eso no es posible, esos tres endpoints no están
disponibles en esa instancia. Chequeo: §5, paso 1.

### 6.2 2026-01-30 — Desde 26.05, el core exige `InventoryType` en los inventarios físicos

**Qué cambió en el core:** el commit `777a2aeb` (2026-01-30, incluido desde `v26.05`) agrega a
`MInventory.beforeSave` la validación *"tipo de inventario obligatorio"* para los inventarios físicos. La
columna `M_Inventory.InventoryType` llega con el esquema de 26.05.

**Qué cambió en lyrestapi:** nada. Es un ejemplo del caso 2 de §3: **core embebido más nuevo que la base**.

**Cómo se manifiesta:** con un core 26.05 o posterior embebido contra una base anterior, `POST
/v1.0/inventories` responde `409` con `InventoryTypeRequired`, porque la base no tiene la columna y el modelo la
ve siempre en null. Pasa hoy en la base de los tests de integración (`libertya_rel_22ar_for_api_25`, esquema
`03-05-2022`): los tests de inventario fallan por esto, no por datos.

**Qué hacer:** que la base de la instancia esté en el esquema del core embebido (§3, regla práctica). Para la
base de tests, actualizarla a 26.05 o posterior.

### 6.3 LY 22.0ar — lyrestapi necesitaba dos commits de core posteriores al release

Del manual para desarrolladores (`docs/referencia/`, sección "Release para LY CORE 22.0ar"): lyrestapi se apoya
en `a101ec1` (`DocumentEngine`: tomar el mensaje de la excepción si `CLogger` no trae error) y `99b34e5`
(salida a log en la gestión de conexiones), ambos de 2023-08. Para 22.0 se armó el core con el parche
`org.libertya.core.22.0.patches.a101ec1.99b34e5.jar` y el jar se publicó como
`lyrestapi-1.0.0_for_LY22.0ar.jar`. Síntoma sin el parche: falla la compilación de `ErrorController`
(`Cannot resolve symbol 'ERROR_STATUS_CODE'`). Desde `v25.0` los dos commits vienen incluidos.

### 6.4 Desde el core con soporte Java 11 (`a0e93ef`, incluido desde `v25.0`) — `OXPXLib.jar` trae `slf4j`

No es una incompatibilidad de API sino de empaquetado. Desde `a0e93ef` el `OXPXLib.jar` que arma el core puede
incluir `org/slf4j/impl/JDK14LoggerFactory`, que choca con el Logback de Spring Boot: la app no arranca
(`LoggerFactory is not a Logback LoggerContext`). Hay que usar un `OXPXLib.jar` sin `org/slf4j/impl` (§5,
paso 3). El manual describe cómo quitarlo (sección "Consideraciones para LY CORE 26.0 o superiores"), junto con
el reemplazo del driver JDBC para conectarse a Postgres 16 con `scram-sha-256`.

---

## 7. Plantilla para una entrada nueva

```markdown
### 6.N AAAA-MM-DD — <qué empezó a usar lyrestapi, o qué cambió en el core>

**Qué cambió en el core:** commit `<hash>` (fecha), primer release que lo incluye (o "ninguno todavía").
¿Toca el esquema de la base? (`preinstall`, diccionario)

**Qué cambió en lyrestapi:** commit(s) `<hash>`, clases y endpoints afectados.

**Cómo se manifiesta:** al compilar / en un despliegue normal / con el `OXP.jar` de la instancia en
`loader.path`.

**Qué hacer:** versión mínima de core, y el chequeo que se suma a §5.
```
