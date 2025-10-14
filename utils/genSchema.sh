# Basic config
QUERY_FILE=genSchema.sql
TARGET_DIR=../src/main/resources

# DB Connection
HOST_NAME=localhost
HOST_PORT=5432
USER_NAME=libertya
DB_NAME=libertya_rel_22ar_for_api

# Funciones
generateSchema() {
  if [ -z "$4" ]; then
    COLUMNAS="(lower(c.columnname))"
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

generateSchema Product                  M_Product                 product.yaml
generateSchema BPartner                 C_BPartner                bpartner.yaml
generateSchema Location                 C_Location                location.yaml
generateSchema BPartnerLocation         C_BPartner_Location       bpartnerlocation.yaml
generateSchema Invoice                  C_Invoice                 invoice.yaml
generateSchema InvoiceLine              C_InvoiceLine             invoiceline.yaml
generateSchema InvoiceTax               C_InvoiceTax              invoicetax.yaml
generateSchema Order                    C_Order                   order.yaml
generateSchema OrderLine                C_OrderLine               orderline.yaml
generateSchema OrderTax                 C_OrderTax                ordertax.yaml
generateSchema InOut                    M_InOut                   inout.yaml
generateSchema InOutLine                M_InOutLine               inoutline.yaml
generateSchema Payment                  C_Payment                 payment.yaml
generateSchema CashLine                 C_CashLine                cashline.yaml
generateSchema AllocationHdr            C_AllocationHdr           allocationhdr.yaml
generateSchema AllocationLine           C_AllocationLine          allocationline.yaml
generateSchema ProductPrice             M_ProductPrice            productprice.yaml
generateSchema Inventory                M_Inventory               inventory.yaml
generateSchema InventoryLine            M_InventoryLine           inventoryline.yaml
generateSchema Storage                  M_Storage                 storage.yaml
generateSchema User                     AD_User                   user.yaml
generateSchema ProductLines             M_Product_Lines           productlines.yaml
generateSchema ProductGamas             M_Product_Gamas           productgamas.yaml
generateSchema ProductCategories        M_Product_Category        productcategories.yaml
generateSchema ProductFamilies          M_Product_Family          productfamilies.yaml
generateSchema TaxCategory              C_TaxCategory             taxcategory.yaml
generateSchema Tax                      C_Tax                     tax.yaml
generateSchema DocType                  C_DocType                 doctype.yaml
generateSchema Org                      AD_Org                    org.yaml
generateSchema OrgPercepcion            AD_OrgPercepcion          orgercepcion.yaml
generateSchema POS                      C_POS                     pos.yaml
generateSchema POSPaymentMedium         C_POSPaymentMedium        pospaymentmedium.yaml
generateSchema PaySchedule              C_PaySchedule             payschedule.yaml
generateSchema PaymentTerm              C_PaymentTerm             paymentterm.yaml
generateSchema LetraComprobante         C_Letra_Comprobante       letracomprobante.yaml
generateSchema LetraAceptaIVA           C_Letra_Acepta_IVA        letraaceptaiva.yaml
generateSchema PriceList                M_PriceList               pricelist.yaml
generateSchema PriceListVersion         M_PriceList_Version       pricelistversion.yaml
generateSchema Bank                     C_Bank                    bank.yaml
generateSchema BankAccount              C_BankAccount             bankaccount.yaml
generateSchema UOM                      C_UOM                     uom.yaml
generateSchema Currency                 C_Currency                currency.yaml
generateSchema ConversionRate           C_Conversion_Rate         conversionrate.yaml
generateSchema CashBook                 C_CashBook                cashbook.yaml
generateSchema Cash                     C_Cash                    cash.yaml
generateSchema DocumentDiscount         C_DocumentDiscount        documentdiscount.yaml
generateSchema DiscountSchema           M_DiscountSchema          discountschema.yaml
generateSchema DiscountSchemaBreak      M_DiscountSchemaBreak     discountschemabreak.yaml
generateSchema DiscountConfig           M_DiscountConfig          discountconfig.yaml
generateSchema EntidadFinanciera        M_EntidadFinanciera       entidadfinanciera.yaml
generateSchema EntidadFinancieraPlan    M_EntidadFinancieraPlan   entidadfinancieraplan.yaml
generateSchema POSJournal               C_POSJournal              posjournal.yaml
generateSchema ControladorFiscal        C_Controlador_Fiscal      controladorfiscal.yaml
generateSchema CheckCuitControl         C_CheckCuitControl        checkcuitcontrol.yaml
generateSchema Role                     AD_Role                   role.yaml
generateSchema Preference               AD_Preference             preference.yaml
generateSchema Promotion                C_Promotion               promotion.yaml
generateSchema POSLetter                C_POSLetter               posletter.yaml