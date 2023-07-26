# wget https://repo1.maven.org/maven2/io/swagger/codegen/v3/swagger-codegen-cli/3.0.46/swagger-codegen-cli-3.0.46.jar

# Generacion de definiciones de modelo a partir de metadatos de LY
./genSchema.sh

# Generacion de clases mediante swagger code-gen
TEMP_DIR=/tmp
# Ubicacion destino dentro del proyecto
TARGET_DIR=../src/main/java/org/libertya/api

# ====================
# Generacion de clases
# ====================

rm -rf $TEMP_DIR/genStub

java -jar swagger-codegen-cli-3.0.46.jar generate \
        --api-package org.libertya.api.stub.iface \
        --model-package org.libertya.api.stub.model \
        -c config.json \
        -i ../src/main/resources/ly-rest-api.yaml \
        -l spring \
        -o $TEMP_DIR/genStub \
        --additional-properties useOas3=true,hideGenerationTimestamp=true

rm -rf $TARGET_DIR/stub

cp -r $TEMP_DIR/genStub/src/main/java/org/libertya/api/* $TARGET_DIR

# ===========================
# Generacion de documentacion
# ===========================

rm -rf $TEMP_DIR/apiDoc

java -jar swagger-codegen-cli-3.0.20.jar generate \
        -i ../src/main/resources/ly-rest-api.yaml \
        -l html2 \
        -o $TEMP_DIR/apiDoc \

