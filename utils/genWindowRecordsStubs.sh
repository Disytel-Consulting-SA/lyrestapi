#!/usr/bin/env bash
# Regenera exclusivamente los stubs de Windowrecords, sin ejecutar genSchema.sh
# ni sobrescribir los restantes modelos generados desde la base de datos.
set -euo pipefail
cd "$(dirname "$0")"
ROOT="$(cd .. && pwd)"
JAR="swagger-codegen-cli-3.0.46.jar"
if [[ ! -f "$JAR" ]]; then
  echo "No se encontró $PWD/$JAR" >&2
  exit 1
fi
TEMP_DIR="$(mktemp -d)"
trap 'rm -rf "$TEMP_DIR"' EXIT
java -jar "$JAR" generate \
  --api-package org.libertya.api.stub.iface \
  --model-package org.libertya.api.stub.model \
  -c config.json \
  -i "$ROOT/src/main/resources/ly-rest-api.yaml" \
  -l spring \
  -o "$TEMP_DIR/genStub" \
  --additional-properties useOas3=true,hideGenerationTimestamp=true
SOURCE="$TEMP_DIR/genStub/src/main/java/org/libertya/api/stub"
TARGET="$ROOT/src/main/java/org/libertya/api/stub"
for file in \
  iface/WindowrecordsApi.java \
  model/ContextualRecordWrite.java \
  model/ContextualRecordDelete.java; do
  if [[ ! -f "$SOURCE/$file" ]]; then
    echo "No se generó el stub esperado: $file" >&2
    exit 1
  fi
done
for file in \
  iface/WindowrecordsApi.java \
  model/ContextualRecordWrite.java \
  model/ContextualRecordDelete.java; do
  cp "$SOURCE/$file" "$TARGET/$file"
done
echo "Stubs contextuales actualizados. Revisar y adaptar WindowRecordController antes de compilar."
