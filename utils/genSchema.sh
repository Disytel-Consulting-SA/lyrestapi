# Basic config
QUERY_FILE=genSchema.sql
TARGET_DIR=../src/main/resources

# DB Connection
HOST_NAME=localhost
HOST_PORT=5432
USER_NAME=libertya
DB_NAME=libertya_core_for_rel_22

generateSchema() {
  echo "=== Generando schema $1 segun $2 en destino $TARGET_DIR/model/$3"
  psql -h $HOST_NAME -p $HOST_PORT -U $USER_NAME -d $DB_NAME -Aqnt -f $QUERY_FILE -v v1="'$1'" -v v2="'$2'" > $TARGET_DIR/model/"$3"
}

# Scripts de generacion
generateSchema Product   M_Product   product.yaml
generateSchema BPartner  C_BPartner  bpartner.yaml
generateSchema Invoice   C_Invoice   invoice.yaml
generateSchema Order     C_Order     order.yaml
