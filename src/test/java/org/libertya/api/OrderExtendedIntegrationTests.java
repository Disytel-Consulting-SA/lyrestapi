package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.libertya.api.stub.model.Order;
import org.libertya.api.stub.model.OrderDocument;
import org.libertya.api.stub.model.OrderLine;
import org.openXpertya.util.DB;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderExtendedIntegrationTests extends DocumentIntegrationTests{
    private static final int TEST_CLIENT_ID = 1010016;
    private static final int TEST_ORG_ID = 1010053;
    private static final int ORDER_PRICE_LIST_ID = 1010595;
    private static final int ORDER_PRODUCT_ID = 1015400;
    private static final BigDecimal ORDER_PRODUCT_PRICE = new BigDecimal("120");

    private Integer priceListVersionIdForTest;
    private boolean productPriceCreatedByTest;

    @BeforeAll
    void ensureProductIsLinkedToSelectedPriceList() {
        priceListVersionIdForTest = findLatestPriceListVersionId(ORDER_PRICE_LIST_ID);
        if (!existsProductPrice(ORDER_PRODUCT_ID, priceListVersionIdForTest)) {
            DB.executeUpdate("INSERT INTO M_ProductPrice " +
                    "(AD_Client_ID, AD_Org_ID, IsActive, Created, CreatedBy, Updated, UpdatedBy, M_Product_ID, M_PriceList_Version_ID, PriceList, PriceStd, PriceLimit) " +
                    "VALUES (" + TEST_CLIENT_ID + ", " + TEST_ORG_ID + ", 'Y', now(), 100, now(), 100, " + ORDER_PRODUCT_ID + ", " + priceListVersionIdForTest + ", " + ORDER_PRODUCT_PRICE + ", " + ORDER_PRODUCT_PRICE + ", " + ORDER_PRODUCT_PRICE + ")");
            productPriceCreatedByTest = true;
        }
    }

    @AfterAll
    void removeProductPriceLinkedByTest() {
        if (!productPriceCreatedByTest || priceListVersionIdForTest == null) {
            return;
        }
        DB.executeUpdate("DELETE FROM M_ProductPrice " +
                "WHERE M_Product_ID = " + ORDER_PRODUCT_ID + " " +
                "AND M_PriceList_Version_ID = " + priceListVersionIdForTest);
    }

    private int findLatestPriceListVersionId(int priceListId) {
        final String sql = "SELECT m_pricelist_version_id " +
                "FROM m_pricelist_version " +
                "WHERE m_pricelist_id = ? " +
                "AND isactive = 'Y' " +
                "ORDER BY validfrom DESC, created DESC " +
                "LIMIT 1";
        try (PreparedStatement ps = DB.prepareStatement(sql, null)) {
            ps.setInt(1, priceListId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            throw new IllegalStateException("No se pudo obtener una version de tarifa para M_PriceList_ID=" + priceListId, ex);
        }
        throw new IllegalStateException("No hay version de tarifa activa para M_PriceList_ID=" + priceListId);
    }

    private boolean existsProductPrice(int productId, int priceListVersionId) {
        final String sql = "SELECT 1 FROM m_productprice WHERE m_product_id = ? AND m_pricelist_version_id = ? LIMIT 1";
        try (PreparedStatement ps = DB.prepareStatement(sql, null)) {
            ps.setInt(1, productId);
            ps.setInt(2, priceListVersionId);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException ex) {
            throw new IllegalStateException("No se pudo verificar el precio de producto para las pruebas de order", ex);
        }
    }

    @Override
    protected String getDocumentContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Order order = new Order();
        order.setIssotrx(true);
        order.setAdOrgId(1010053);
        order.setCBpartnerId(1012142);
        order.setCBpartnerLocationId(1012157);
        order.setCCurrencyId(118);
        order.setCDoctypeId(1010532);
        order.setCDoctypetargetId(1010532);
        order.setCPaymenttermId(1010083);
        order.setDateordered(getFormattedDate());
        order.setDateacct(getFormattedDate());
        order.setMPricelistId(1010595);
        order.setPaymentrule("S");
        order.setSalesrepId(100);
        order.setMWarehouseId(1010048);
        order.setCConversiontypeId(114);
        order.setBillBpartnerId(1012142);
        order.setBillLocationId(1012157);
        order.setAdUserId(100);

        // Líneas del pedido
        OrderLine line1 = new OrderLine();
        line1.setLine(10);
        line1.setAdOrgId(1010053);
        line1.setCUomId(100);
        line1.setQtyordered(new BigDecimal(3));
        line1.setPriceactual(ORDER_PRODUCT_PRICE);
        line1.setMProductId(ORDER_PRODUCT_ID);

        OrderDocument doc = new OrderDocument();
        doc.setHeader(order);
        doc.addLinesItem(line1);

        return objectMapper.writeValueAsString(doc);
    }

    @Override
    protected String getDocumentPath() {
        return "orders/";
    }

    @Override
    protected void afterRetrieve(String responseBody) throws Exception {

    }

    @Override
    protected String getModificationBody() {
        return "{ \"descrption\" : \"Prueba en order\"}";
    }
}
