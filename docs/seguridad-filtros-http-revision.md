# Seguridad de filtros HTTP — implementación inicial (rama de revisión)

Base de la rama: main @ afad746634f39a034d071602091453a300febe35.

## Alcance
- Los listados y conteos de AbstractRepository y WindowRecordRepository
  convierten filtros HTTP en predicados de gramática restringida y parámetros JDBC.
- sort de AbstractRepository admite únicamente columnas de metadatos y ASC/DESC.
- UserRepository.find utiliza parámetros JDBC para credenciales, compañía y organización.
- ClientOrgAuth valida compañía y, cuando hay rol, acceso de cliente,
  organización y tabla mediante MRole.

## Compatibilidad
Sintaxis admitida: AND, OR, NOT, paréntesis, =, !=, <>, <, <=, >, >=,
LIKE, ILIKE, IN, NOT IN, BETWEEN, NOT BETWEEN, IS [NOT] NULL;
literales de texto entre comillas simples (escape SQL ''), números y booleanos.
Se rechazan funciones SQL, subconsultas, nombres de columna inexistentes,
comentarios y sentencias adicionales. Es un cambio deliberado respecto del
SQL libre histórico: debe probarse contra integraciones existentes.

## Pendientes antes de merge
1. Ejecutar ./gradlew test con OXP_HOME apuntando al CORE compatible.
2. Probar filtros de todas las pantallas y consumidores REST existentes.
3. Corregir en CORE/dev MRole.isRecordAccess: el bucle recorre
   m_tableAccess pero indexa m_recordAccess. No invocar este método
   sin corregirlo. La autorización por registro NO está cerrada.
4. Auditar autorización de listados y conteos genéricos por rol/organización.
   La validación por PO no protege countAll ni evita paginar sobre IDs ocultos.
5. Auditar campos restringidos y endpoints SQL adicionales.
6. Revisar la compatibilidad de filtros con funciones/expresiones SQL históricas.
7. Verificar comportamiento de los WHERE contextuales de ventanas dinámicas
   y la parametrización junto con MQueryPreparation.applyReadAccess.

No desplegar esta rama en producción sin completar la validación.
