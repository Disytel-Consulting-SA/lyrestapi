# Documentación de lyrestapi

| Documento | Para qué |
|---|---|
| [`compatibilidad-core.md`](compatibilidad-core.md) | Qué versión del core de Libertya necesita cada versión de lyrestapi, y la bitácora de incompatibilidades. **Leer antes de armar un jar para desplegar.** |
| [`PENDIENTES.md`](PENDIENTES.md) | Bugs conocidos y trabajo diferido |

## `referencia/` — cómo usar y extender la API

| Documento | Para quién |
|---|---|
| [`Libertya REST API - Manual para desarrolladores.md`](referencia/Libertya%20REST%20API%20-%20Manual%20para%20desarrolladores.md) | Quien agrega endpoints: estructura del proyecto, codegen, build, releases por versión de core, Docker |
| [`asientos-manuales-api.md`](referencia/asientos-manuales-api.md) | Integradores que cargan asientos contables (`/v1.0/journals`) |
| [`endpoint-generico-api.md`](referencia/endpoint-generico-api.md) | Integradores que operan tablas sin endpoint propio (`/v1.0/generic/{table}`) |
| [`invoice-print.md`](referencia/invoice-print.md) | Impresión de facturas en PDF y cómo regenerar `libs/JasperReports-ngroovy.jar` |

## `planes/` — diseño, decisiones y evidencia

| Documento | Estado |
|---|---|
| [`plan-asientos-manuales.md`](planes/plan-asientos-manuales.md) | Implementado (2026-08). Quedan las fases 3 y 4 |
| [`plan-endpoint-generico.md`](planes/plan-endpoint-generico.md) | Implementado (2026-09). La §2 tiene decisiones tomadas a propósito |

Las guías de `referencia/` están escritas para que las lea un integrador (persona o agente de IA) sin conocer
el código; los `planes/` explican el porqué y no hace falta leerlos para usar la API.
