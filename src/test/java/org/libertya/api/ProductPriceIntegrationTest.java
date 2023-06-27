package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.libertya.api.stub.model.ProductPrice;
import org.openXpertya.util.DB;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductPriceIntegrationTest extends CommonIntegrationTests {

    protected final int PRODUCT_ID = 1015400;
    protected final int PRICE_LIST_VERSION_ID = 1010527;

    protected String getProductPriceContent() throws JsonProcessingException {

        // Eliminar el precio por las dudas de que ya existiera anteriormente
        DB.executeUpdate("DELETE FROM M_ProductPrice WHERE M_Product_ID = " + PRODUCT_ID + " AND M_PriceList_Version_ID = " + PRICE_LIST_VERSION_ID);

        ObjectMapper objectMapper = new ObjectMapper();

        ProductPrice pp = new ProductPrice();

        pp.setAdClientId(1010016);
        pp.setAdOrgId(1010053);
        pp.setMProductId(PRODUCT_ID);
        pp.setMPricelistVersionId(PRICE_LIST_VERSION_ID);
        pp.setPricelimit(new BigDecimal(10));
        pp.setPricelist(new BigDecimal(10));
        pp.setPricestd(new BigDecimal(10));

        return objectMapper.writeValueAsString(pp);

    }

    @Test
    @Order(1)
    void createProductPriceShouldReturnOK() throws Exception {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("productprices"),
                        HttpMethod.POST,
                        new HttpEntity<>(getProductPriceContent(), getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("200");
        assertThat(response.getBody().contains("1015400-1010527") );
    }

    @Test
    @Order(500)
    void updateProductPriceShouldReturnOK() throws Exception {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("productprices/"+PRODUCT_ID+"/"+PRICE_LIST_VERSION_ID),
                        HttpMethod.PUT,
                        new HttpEntity<>("{ \"pricelist\" : \"80\" }", getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("200");
    }


    @Test
    @Order(1000)
    void deleteProductPriceShouldReturnOK() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("productprices/"+PRODUCT_ID+"/"+PRICE_LIST_VERSION_ID),
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("204");
    }
}
