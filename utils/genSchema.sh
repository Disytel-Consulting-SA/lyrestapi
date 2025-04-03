# Basic config
QUERY_FILE=genSchema.sql
TARGET_DIR=../src/main/resources

# DB Connection
HOST_NAME=localhost
HOST_PORT=5432
USER_NAME=libertya
DB_NAME=libertya_core_for_rel_22

# Funciones
generateSchema() {
  if [ -z "$4" ]; then
    COLUMNAS="(lower(columnname))"
    FILTRO=" sin filtro de columnas"
  else
    COLUMNAS=$4
    FILTRO=" con filtro $4"
  fi
  echo "=== Generando schema $1 segun $2 en destino $TARGET_DIR/model/$3 $FILTRO ==="
  psql -h $HOST_NAME -p $HOST_PORT -U $USER_NAME -d $DB_NAME -Aqnt -f $QUERY_FILE -v nombre="'$1'" -v tabla="'$2'" -v columnas="$COLUMNAS" > $TARGET_DIR/model/"$3"
}

# Scripts de generacion de schemas
# ################################
#
# Ejemplo para incluir todas las columnas de la tabla:
#   generateSchema Currency   C_Currency   currency.yaml
#
# Ejemplo para incluir solo las columnas obligatorias y las especificadas en el ultimo parametro:
#   generateSchema Currency   C_Currency   currency.yaml	"('description', 'iseuro', 'wsfecode')"

generateSchema Product            M_Product             product.yaml
generateSchema BPartner           C_BPartner            bpartner.yaml
generateSchema Location           C_Location            location.yaml
generateSchema BPartnerLocation   C_BPartner_Location   bpartnerlocation.yaml
generateSchema Invoice            C_Invoice             invoice.yaml
generateSchema InvoiceLine        C_InvoiceLine         invoiceline.yaml
generateSchema InvoiceTax         C_InvoiceTax          invoicetax.yaml
generateSchema Order              C_Order               order.yaml
generateSchema OrderLine          C_OrderLine           orderline.yaml
generateSchema OrderTax           C_OrderTax            ordertax.yaml
generateSchema InOut              M_InOut               inout.yaml
generateSchema InOutLine          M_InOutLine           inoutline.yaml
generateSchema Payment            C_Payment             payment.yaml
generateSchema CashLine           C_CashLine            cashline.yaml
generateSchema AllocationHdr      C_AllocationHdr       allocationhdr.yaml
generateSchema AllocationLine     C_AllocationLine      allocationline.yaml
generateSchema ProductPrice       M_ProductPrice        productprice.yaml
generateSchema Inventory          M_Inventory           inventory.yaml
generateSchema InventoryLine      M_InventoryLine       inventoryline.yaml
generateSchema Storage            M_Storage             storage.yaml
generateSchema User               AD_User               user.yaml
generateSchema ProductLines       M_Product_Lines       productlines.yaml
generateSchema ProductGamas       M_Product_Gamas       productgamas.yaml
