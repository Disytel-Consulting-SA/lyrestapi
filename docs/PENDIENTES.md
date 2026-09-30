# Pendientes

Bugs conocidos y trabajo diferido que no bloquea nada hoy, pero que conviene no perder de vista.
Cada entrada dice qué pasa, cómo se verificó, qué impacto tiene y cuál sería el arreglo.

Cuando una entrada se resuelve, se borra (el historial queda en git). Los números **no se reutilizan**, porque
el código y la descripción de la API citan entradas por número ("P1").

---

## P1 — `AbstractRepository.processEntity` no puede ejecutar `RC`, `RA` ni `RE`

**Detectado:** 2026-08-07, durante el diseño de los endpoints de asientos manuales
(`docs/planes/plan-asientos-manuales.md` §3.4).
**Alcance:** el genérico de procesado de documentos → **afecta a todos los documentos**, no solo a los
asientos: facturas, pedidos, pagos, remitos, inventarios.
**Impacto hoy:** ninguno en producción — nadie ejercita esas acciones vía API. Es un bug latente.

### Qué pasa

`AbstractRepository.processEntity` (`src/main/java/org/libertya/api/repository/AbstractRepository.java`)
valida, después de procesar, que la acción pedida coincida con el `DocStatus` resultante, y hace **rollback**
si no coinciden:

```java
if (!action.equalsIgnoreCase(((DocAction)aPO).getDocStatus())) {
    throw new ModelException(String.format(
        "Imposible procesar.  La accion %s no puede aplicarse al estado actual %s", ...));
}
```

La premisa "la acción y el estado resultante se llaman igual" vale para tres acciones y falla para las otras
tres, porque el `DocumentEngine` deja un `DocStatus` distinto:

| `action` | `DocStatus` resultante | Dónde | Resultado |
|---|---|---|---|
| `CO` Complete | `CO` | — | ✅ |
| `VO` Void | `VO` | — | ✅ |
| `CL` Close | `CL` | — | ✅ |
| `RC` Reverse-Correct | `RE` (Reversed) | `DocumentEngine.java:626` | ❌ 409 + rollback de la reversión |
| `RA` Reverse-Accrual | `RE` (Reversed) | `DocumentEngine.java:654` | ❌ 409 + rollback |
| `RE` ReActivate | `IP` (InProgress) | `DocumentEngine.java:682` | ❌ 409 + rollback |

Para `RE` hay además un segundo problema: el pre-check del principio de `processEntity` rechaza reactivar un documento
reversado (`docstatus='RE'`) con *"la accion ya coincide con el estado actual"*, porque compara la acción
`RE` contra el estado `RE` que significa otra cosa.

El efecto neto es el peor posible: el documento **sí** se procesa en memoria, y después se tira todo por
rollback. El cliente recibe un 409 que dice que la acción no se puede aplicar, cuando en realidad se aplicó
bien y el genérico la deshizo.

### Por qué importa

Para documentos contables, `RC` (contra-asiento) es la forma correcta de corregir algo ya contabilizado:
deja los dos documentos visibles y auditables. La alternativa disponible, `VO`, **no es equivalente** — en
asientos, `MJournal.voidIt` (`MJournal.java:675-711`) borra los `Fact_Acct` y pone todas las líneas en cero,
o sea que destruye el rastro contable.

No se notó antes porque en facturas y pedidos la operación habitual es anular o emitir una nota de crédito,
no revertir.

### Arreglo propuesto

Reemplazar la comparación `action == docStatus` por un mapa explícito de acción → estado(s) esperado(s):

```
CO → CO
VO → VO
CL → CL
RC → RE
RA → RE
RE → DR, IP
PR → IP
```

Es acotado, pero toca el camino de procesado de **todos** los documentos, así que necesita su propia tanda de
verificación sobre facturas / pedidos / pagos antes de darlo por bueno. Por eso no entró en la
implementación de asientos manuales.

### Mientras tanto

Los endpoints de documentos exponen `CO`, `VO` y `CL`. En asientos manuales y en el endpoint genérico quedó
documentado en la descripción del endpoint, para que nadie asuma que `VO` es una reversión contable.

---

## P2 — `genClasses.sh` pisa los `model/*.yaml` con archivos vacíos si la base no existe

**Detectado:** 2026-08-10. **Revisado:** 2026-09-30.
**Alcance:** el circuito de codegen (`utils/genClasses.sh` → `utils/genSchema.sh`).
**Impacto hoy:** ninguno en runtime. Es una trampa para el próximo que regenere en otra máquina.

### Qué pasa

`genClasses.sh` arranca corriendo `genSchema.sh`, que genera cada schema con
`psql ... -d $DB_NAME ... > $TARGET_DIR/model/<archivo>.yaml`. Si la base `DB_NAME` no existe en la máquina
(hoy apunta a `ly_core_rel_2605ar`), `psql` falla pero el redirect `>` **igual crea el archivo vacío**. El
script sigue de largo y deja todos los `model/*.yaml` vacíos, y después el codegen pisa `stub/` con eso.

> El otro problema que describía esta entrada (stubs commiteados que no coincidían con los yaml, con
> `Inventory.inventorytype` y `Warehouse` como casos) **quedó resuelto** con la regeneración del 2026-09-21
> contra `ly_core_rel_2605ar`. Verificado el 2026-09-29: regenerar los stubs desde los yaml commiteados da
> exactamente los mismos archivos que hay en `stub/`.

### Mientras tanto

En una máquina sin esa base, no correr `genClasses.sh` entero. Para agregar entidades nuevas:

1. Generar solo los schemas nuevos invocando `genSchema.sql` a mano contra una base que exista.
2. Correr **solo el bloque de swagger-codegen** de `genClasses.sh`, con salida a un directorio temporal.
3. Copiar a `stub/` **únicamente los archivos nuevos**, y verificar con `git status` que no quedó ningún
   archivo preexistente modificado.

### Arreglo propuesto

Que `genSchema.sh` falle en vez de pisar: escribir cada schema a un archivo temporal y moverlo solo si `psql`
terminó bien (o chequear la conexión una vez al principio), y tomar `DB_NAME` de una variable de entorno con el
valor actual como default.

---

## P4 — El fat-jar se arma incompleto si falta una lib de `$OXP_HOME/lib`

**Detectado:** 2026-08-10, al exportar el jar de la versión con asientos manuales.
**Alcance:** el empaquetado (`build.gradle` + el contenido de `$OXP_HOME/lib`).
**Impacto:** alto y silencioso cuando pasa — produce un artefacto que parece correcto y no lo es.

### Qué pasa

`build.gradle` declara las libs de Libertya con `implementation files("$OXPLIBS/lib/OXP.jar")` (ídem
`OXPXLib.jar`), y **`files()` de Gradle ignora en silencio los archivos que no existen**: el build no falla y
el jar sale sin esa librería. Sin `OXPXLib.jar` la aplicación arranca igual y recién falla al conectarse a la
base, en `DB.getConnectionRW` o en `POST /token`.

Hoy las libs están en su lugar; lo que falta es la red de seguridad para la próxima vez. Los chequeos a mano
antes de empaquetar están en `docs/compatibilidad-core.md` (§5).

### Arreglo propuesto

Hacer que el build **falle** si falta una lib declarada:

```gradle
def oxpLib = { name ->
    def f = file("${System.getenv('OXP_HOME')}/lib/${name}")
    if (!f.exists()) throw new GradleException("Falta ${f} — el jar quedaria incompleto")
    files(f)
}
```

Con las libs ya en su lugar, agregarlo no rompe nada.
