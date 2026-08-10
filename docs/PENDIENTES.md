# Pendientes

Bugs conocidos y trabajo diferido que no bloquea nada hoy, pero que conviene no perder de vista.
Cada entrada dice qué pasa, cómo se verificó, qué impacto tiene y cuál sería el arreglo.

---

## P1 — `AbstractRepository.processEntity` no puede ejecutar `RC`, `RA` ni `RE`

**Detectado:** 2026-08-07, durante el diseño de los endpoints de asientos manuales
(`docs/plan-asientos-manuales.md` §3.4).
**Alcance:** el genérico de procesado de documentos → **afecta a todos los documentos**, no solo a los
asientos: facturas, pedidos, pagos, remitos, inventarios.
**Impacto hoy:** ninguno en producción — nadie ejercita esas acciones vía API. Es un bug latente.

### Qué pasa

`AbstractRepository.processEntity` (`src/main/java/org/libertya/api/repository/AbstractRepository.java:801`)
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

Para `RE` hay además un segundo problema: el pre-check de la línea 793 rechaza reactivar un documento
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

Los endpoints de documentos exponen `CO`, `VO` y `CL`. En asientos manuales quedó documentado en la
descripción del endpoint, para que nadie asuma que `VO` es una reversión contable.

---

## P2 — Los stubs generados están desincronizados con los yaml del repo

**Detectado:** 2026-08-10, al regenerar los stubs para los endpoints de asientos manuales.
**Alcance:** el circuito de codegen (`utils/genClasses.sh`).
**Impacto hoy:** ninguno en runtime. Es una trampa para el próximo que regenere.

### Qué pasa

Correr el codegen sobre `ly-rest-api.yaml` y pisar `stub/` **modifica entidades que uno no tocó**, porque lo
que hay commiteado bajo `stub/` no es lo que sale de los `model/*.yaml` commiteados. El caso más claro:

- `stub/model/Inventory.java` tiene el campo `inventorytype`; `model/inventory.yaml` **no lo tiene**.
  Regenerar **borra el campo**.
- `WarehouseApi` / `Warehouse` también cambian de forma sustancial.

### Segundo problema: `genClasses.sh` no se puede correr tal cual

Su primera línea es `./genSchema.sh`, que apunta a `DB_NAME=libertya_rel_22ar_for_api` — una base que **no
existe** en la máquina de desarrollo. Correrlo así **sobrescribe todos los `model/*.yaml` con archivos
vacíos**, porque `psql` falla y el redirect `>` igual crea el archivo.

Lo que sí existe es **`libertya_rel_22ar_for_api_25`** (mismo nombre + `_25`), y todo indica que es la base de
referencia buena: `model/inventory.yaml` commiteado sale **idéntico** generándolo desde ahí.

### La causa del desfasaje (diagnóstico del 2026-08-10)

Los `model/*.yaml` y los `stub/*.java` commiteados vienen de **bases distintas**:

| | `libertya_qa` | `libertya_rel_22ar_for_api_25` | commiteado |
|---|---|---|---|
| `model/inventory.yaml` | ≠ | **=** | viene de la base de referencia |
| `M_Inventory.InventoryType` en el diccionario | **existe** | **no existe** | ausente del yaml, **presente** en `stub/model/Inventory.java` |
| `model/warehouse.yaml` | ≠ | ≠ | **no coincide con ninguna** — editado a mano |

O sea: los yaml se regeneraron contra la base de referencia, pero los stubs quedaron de una generación
anterior hecha contra una base que sí tenía `InventoryType`.

⚠️ **Y eso no es cosmético:** `InventoryIntegrationTest.java:33` hace `inv.setInventorytype("C")`. Si se
regeneran los stubs desde la base de referencia, `Inventory.java` pierde el campo y **el test deja de
compilar**. La base de referencia está atrasada respecto de lo que el proyecto necesita, al menos en ese punto.

### Mientras tanto

Para agregar entidades nuevas, el procedimiento seguro es:

1. Generar solo los schemas nuevos, apuntando a una base viva (`libertya_qa`), sin correr `genSchema.sh` entero.
2. Correr **solo el bloque de swagger-codegen** de `genClasses.sh`, con salida a `/tmp/genStub`.
3. Copiar a `stub/` **únicamente los archivos nuevos**, y verificar con `git status` que no quedó ningún
   archivo preexistente modificado.

Así se hicieron los de asientos manuales.

### Arreglo propuesto

1. **Decidir cuál es la base de referencia** y actualizar `DB_NAME` en `genSchema.sh` (hoy le falta el
   sufijo `_25`). Si es `libertya_rel_22ar_for_api_25`, hay que resolver antes qué se hace con
   `M_Inventory.InventoryType`: o se agrega la columna al diccionario de esa base, o se saca el
   `setInventorytype` del test.
2. Regenerar los `model/*.yaml` y los stubs completos desde esa base.
3. Revisar el diff a mano para reponer los agregados manuales: al menos el `m_warehouse_id` derivado de
   `model/storage.yaml` (documentado en `StorageRepository`) y lo que sea que tenga `warehouse.yaml`, que no
   coincide con ninguna de las dos bases.

Es una tarea de una sentada, pero el paso 1 es una decisión, no un tecleo.

### Nota sobre los endpoints de asientos manuales

Se generaron desde `libertya_qa`, y se verificó que los 7 schemas nuevos salen **byte-idénticos** generándolos
desde `libertya_rel_22ar_for_api_25`. O sea que este pendiente no los afecta.

---

## P3 — `genSchema.sql` no mapeaba el tipo de referencia 25 (Account)

**Detectado:** 2026-08-10. **Estado: ARREGLADO** en el mismo commit de asientos manuales.

Las columnas con `ad_reference_id = 25` (Account) no entraban en ningún `when` del `case` que asigna el tipo,
con lo cual la concatenación daba NULL y la columna **salía como una línea en blanco en `properties`** — pero
igual aparecía en el bloque `required`, porque esa segunda query no evalúa el tipo. Resultado: un schema con un
campo declarado obligatorio que no existe como propiedad.

Se detectó con `GL_JournalLine.C_ValidCombination_ID`, que es la **única** columna con reference 25 entre todas
las tablas que genera este proyecto. El arreglo fue agregar `25` al grupo de enteros.
