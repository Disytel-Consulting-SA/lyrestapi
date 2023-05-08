# wget https://repo1.maven.org/maven2/io/swagger/codegen/v3/swagger-codegen-cli/3.0.20/swagger-codegen-cli-3.0.20.jar

# Generacion de definiciones de modelo a partir de metadatos de LY
./genSchema.sh

# Generacion de clases mediante swagger code-gen
TEMP_DIR=/tmp/genStub
TARGET_DIR=../src/main/java/org/libertya/api

rm -rf $TEMP_DIR

java -jar swagger-codegen-cli-3.0.20.jar generate \
        --api-package org.libertya.api.stub.iface \
        --model-package org.libertya.api.stub.model \
        -c config.json \
        -i ../src/main/resources/ly-rest-api.yaml \
        -l spring \
        -o $TEMP_DIR

rm -rf $TARGET_DIR/stub

cp -r $TEMP_DIR/src/main/java/org/libertya/api/* $TARGET_DIR