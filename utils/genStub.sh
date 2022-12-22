# wget https://repo1.maven.org/maven2/io/swagger/codegen/v3/swagger-codegen-cli/3.0.20/swagger-codegen-cli-3.0.20.jar
TARGET_DIR=/tmp/genStub
rm -rf $TARGET_DIR
java -jar swagger-codegen-cli-3.0.20.jar generate --api-package org.libertya.api.stub.iface --model-package org.libertya.api.stub.model -c config.json -i ../src/main/resources/ly-rest-api.yaml -l spring -o $TARGET_DIR
rm -rf ../src/main/java/org/libertya/api/stub
cp -r $TARGET_DIR/src/main/java/org/libertya/api/* ../src/main/java/org/libertya/api