# Basic config
QUERY_FILE=genAPISchema.sql
TARGET_DIR=../src/main/resources/

# DB Connection
DB_NAME=libertya_core_for_rel_22
HOST_NAME=localhost
USER_NAME=libertya

# Scripts de generacion
psql -h $HOST_NAME -U $USER_NAME -d $DB_NAME -Aqnt -f $QUERY_FILE -v v1="'Product'" -v v2="'M_Product'" > $TARGET_DIR/product.yaml
psql -h $HOST_NAME -U $USER_NAME -d $DB_NAME -Aqnt -f $QUERY_FILE -v v1="'BPartner'" -v v2="'C_BPartner'" > $TARGET_DIR/bpartner.yaml
