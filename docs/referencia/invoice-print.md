# Impresión de facturas en base64

## Endpoint

```
GET /v1.0/invoices/{id}/print
```

Retorna el PDF de la factura codificado en base64 (`text/plain`). El PDF generado es
el mismo que produce Libertya via JasperReports (mismo template, mismo diseño gráfico).

---

## El problema con JasperReports.jar

Para generar el PDF via JasperReports es necesario que `JasperReports.jar` esté en el
classpath en runtime. Sin embargo, **el JAR original de Libertya
(`/ServidorOXP/lib/JasperReports.jar`) no puede agregarse directamente** al fat-jar de
Spring Boot por dos razones:

### 1. Clases Groovy incompletas

El JAR contiene paquetes Groovy parciales:

- `groovy/`
- `groovyjarjarantlr/`
- `groovyjarjarasm/`
- `org/codehaus/groovy/`

...pero le falta `groovy.lang.GroovySystem`. Spring Boot escanea el classpath durante el
bootstrap y, al detectar `MetaClass`, intenta inicializar `GroovyBeanDefinitionReader`,
fallando con:

```
java.lang.NoClassDefFoundError: groovy/lang/GroovySystem
```

### 2. JAR firmado digitalmente

El JAR tiene `META-INF/LIBERTYA.SF` y `META-INF/LIBERTYA.RSA`. Si se modifica el JAR
sin eliminar esas firmas, la JVM lo rechaza al cargarlo:

```
java.lang.SecurityException: Invalid signature file digest for Manifest main attributes
```

---

## Solución: JasperReports-ngroovy.jar

Se creó una versión modificada del JAR sin las clases Groovy ni las firmas digitales,
guardada en `libs/JasperReports-ngroovy.jar` dentro del proyecto.

Este JAR se incluye en `build.gradle` como `compileOnly` (solo para compilar, no entra
en el fat-jar), y se pasa en runtime via `-Dloader.path`.

### Cómo regenerar el JAR (cuando Libertya actualice JasperReports.jar)

```bash
# 1. Extraer el JAR original
mkdir /tmp/jasper_clean && cd /tmp/jasper_clean
jar xf /ServidorOXP/lib/JasperReports.jar

# 2. Eliminar los paquetes Groovy
rm -rf groovy groovyjarjarantlr groovyjarjarasm org/codehaus/groovy

# 3. Eliminar las firmas digitales
rm META-INF/LIBERTYA.SF META-INF/LIBERTYA.RSA

# 4. Reempaquetar
jar cf /tmp/JasperReports-ngroovy.jar .

# 5. Copiar al proyecto
cp /tmp/JasperReports-ngroovy.jar /ruta/al/proyecto/lyrestapi/libs/

# Limpieza
rm -rf /tmp/jasper_clean /tmp/JasperReports-ngroovy.jar
```

> **Nota:** No reemplazar el JAR original en `/ServidorOXP/lib/` — Libertya server lo
> necesita intacto. El JAR modificado es exclusivo para lyrestapi.

---

## Cómo lanzar lyrestapi

El fat-jar usa `PropertiesLauncher` (en lugar del `JarLauncher` por defecto de Spring
Boot). Esto permite cargar JARs externos via `-Dloader.path` **después** del bootstrap
de Spring, evitando que Spring escanee el contenido de `JasperReports-ngroovy.jar`
durante el arranque.

**El flag `-Dloader.path` es obligatorio.** Sin él, `JRDataSource` no se encuentra en
runtime y el endpoint falla.

### Desarrollo local (java -jar)

```bash
./gradlew bootJar
java -Dloader.path=libs/JasperReports-ngroovy.jar -jar build/libs/lyrestapi-1.0.0.jar
```

### IntelliJ IDEA

En la run configuration de `LYRestAPI`:

- **VM options:** `-Dloader.path=/ruta/absoluta/al/proyecto/lyrestapi/libs/JasperReports-ngroovy.jar`

### Docker

El `Dockerfile` ya está configurado. Al hacer build con `DockerCreateImage.sh` copia
`libs/JasperReports-ngroovy.jar` dentro de la imagen y lo pasa con `-Dloader.path`.

```bash
./DockerCreateImage.sh
./DockerRunContainer.sh <DB_HOST> <DB_NAME>
```

---

## Cómo funciona internamente el endpoint

El flujo en `InvoiceService`:

1. **`retrieveInvoicePrintProcessId()`** — Busca en `AD_Process` el proceso de
   impresión de facturas con `Classname = LaunchInvoice` e `IsJasperReport = Y`.
   Prioridad:
   - Primero busca el proceso cuyo template (`AD_JasperReport`) tenga nombre `%factura electr%`
     → este es el que tiene el diseño gráfico completo.
   - Fallback: cualquier proceso `LaunchInvoice` con nombre que contenga `%factura%`.
   - Último fallback: cualquier proceso con classname `%launchinvoice%`.

   > **Importante:** El template genérico "Factura" (`AD_JasperReport_ID = 1000021`) no
   > tiene diseño gráfico — produce un PDF con datos flotando en hoja en blanco. Siempre
   > hay que preferir "Factura Electrónica" u otro template personalizado.

2. **`generatePdfFromJasperProcess()`** — Instancia `LaunchInvoice` directamente y
   llama a `startProcess()` con el contexto que incluye el `AD_Org_ID` de la factura
   (no el del usuario del request). El `AD_Org_ID` correcto es crítico para que
   `MJasperReport` resuelva el template de la organización correcta.

3. Si `ProcessInfo.getReportResultStream()` tiene contenido, lo retorna directamente.
   Si no, exporta con `JasperExportManager.exportReportToPdf(jasperPrint)`.
