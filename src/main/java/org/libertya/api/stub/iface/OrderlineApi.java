/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.46).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package org.libertya.api.stub.iface;

import org.libertya.api.stub.model.OrderLine;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Validated
public interface OrderlineApi {

    Logger log = LoggerFactory.getLogger(OrderlineApi.class);

    default Optional<ObjectMapper> getObjectMapper(){
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest(){
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @Operation(summary = "Nueva linea de pedido", description = "Agrega una nueva linea de pedido", security = {
        @SecurityRequirement(name = "jwtAuth")    }, tags={ "orderline" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK. ID de linea de pedido creado es retornado", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "409", description = "Imposible insertar", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))) })
    @RequestMapping(value = "/v1.0/orderlines",
        produces = { "text/plain" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    default ResponseEntity<String> addOrderLine(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody OrderLine body) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("\"\"", String.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default OrderlineApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Elimina una linea de pedido", description = "Elimina una linea de pedido existente", security = {
        @SecurityRequirement(name = "jwtAuth")    }, tags={ "orderline" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "409", description = "Imposible eliminar", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "204", description = "OK", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))) })
    @RequestMapping(value = "/v1.0/orderlines/{id}",
        produces = { "text/plain" }, 
        method = RequestMethod.DELETE)
    default ResponseEntity<String> deleteOrderLine(@Parameter(in = ParameterIn.PATH, description = "ID de la linea de pedido", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("\"\"", String.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default OrderlineApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Retrieve order lines", description = "Retorna una lista de lineas de pedido", security = {
        @SecurityRequirement(name = "jwtAuth")    }, tags={ "orderline" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = OrderLine.class)))) })
    @RequestMapping(value = "/v1.0/orderlines",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<OrderLine>> getAllOrderLines(@Parameter(in = ParameterIn.QUERY, description = "Criterio de filtrado" ,schema=@Schema()) @Valid @RequestParam(value = "filter", required = false) String filter, @Parameter(in = ParameterIn.QUERY, description = "Campos a recuperar" ,schema=@Schema()) @Valid @RequestParam(value = "fields", required = false) String fields, @Parameter(in = ParameterIn.QUERY, description = "Criterio de ordenado" ,schema=@Schema()) @Valid @RequestParam(value = "sort", required = false) String sort, @Parameter(in = ParameterIn.QUERY, description = "Limite de elementos a retornar por pagina" ,schema=@Schema()) @Valid @RequestParam(value = "limit", required = false) Integer limit, @Parameter(in = ParameterIn.QUERY, description = "Numero de pagina" ,schema=@Schema()) @Valid @RequestParam(value = "page", required = false) Integer page) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {\n  \"linediscountamt\" : 4.965218492984954,\n  \"m_product_id\" : 8,\n  \"updatedby\" : 7,\n  \"documentdiscountamt\" : 1.4894159098541704,\n  \"ref_orderline_id\" : 3,\n  \"discount\" : 1.0246457001441578,\n  \"qtyinvoiced\" : 0.8851374739011653,\n  \"qtyreception\" : 6.519180951018382,\n  \"c_tax_id\" : 4,\n  \"m_shipper_id\" : 9,\n  \"freightamt\" : 6.84685269835264,\n  \"linebonusamt\" : 1.1730742509559433,\n  \"createdby\" : 2,\n  \"receptionamt\" : 7.740351818741173,\n  \"priceentered\" : 6.778324963048013,\n  \"manualgeneraldiscountamt\" : 9.369310271410669,\n  \"ad_client_id\" : 0,\n  \"pricediff\" : 2.8841621266687802,\n  \"pricereception\" : 6.704019297950036,\n  \"qtyordered\" : 7.058770351582356,\n  \"c_currency_id\" : 2,\n  \"created\" : \"created\",\n  \"datepromised\" : \"datepromised\",\n  \"datedelivered\" : \"datedelivered\",\n  \"pricelist\" : 5.944895607614016,\n  \"checkoutplace\" : \"checkoutplace\",\n  \"updated\" : \"updated\",\n  \"c_bpartner_id\" : 1,\n  \"dateinvoiced\" : \"dateinvoiced\",\n  \"qtydelivered\" : 3.353193347011243,\n  \"qtyreturned\" : 4.652396432933246,\n  \"ad_org_id\" : 6,\n  \"line\" : 7,\n  \"isactive\" : true,\n  \"referencedvalues\" : [ {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  } ],\n  \"description\" : \"description\",\n  \"diffamt\" : 1.2315135367772556,\n  \"order_min\" : 3.5571952270680973,\n  \"qtytransferred\" : 8.969578798196912,\n  \"qtydiff\" : 3.0937452626664474,\n  \"isdescription\" : true,\n  \"c_order_id\" : 7,\n  \"c_orderline_id\" : 9,\n  \"c_uom_id\" : 7,\n  \"m_attributesetinstance_id\" : 6,\n  \"linetotalamt\" : 9.965781217890562,\n  \"c_bpartner_location_id\" : 5,\n  \"m_warehouse_id\" : 6,\n  \"linenetamt\" : 5.025004791520295,\n  \"c_charge_id\" : 5,\n  \"pricelimit\" : 6.878052220127876,\n  \"qtyreserved\" : 0.10263654006109402,\n  \"dateordered\" : \"dateordered\",\n  \"processed\" : true,\n  \"salesrep_orig_id\" : 3,\n  \"c_project_id\" : 3,\n  \"order_pack\" : 6.965117697638846,\n  \"qtyentered\" : 7.143538047012306,\n  \"priceactual\" : 1.284659006116532\n}, {\n  \"linediscountamt\" : 4.965218492984954,\n  \"m_product_id\" : 8,\n  \"updatedby\" : 7,\n  \"documentdiscountamt\" : 1.4894159098541704,\n  \"ref_orderline_id\" : 3,\n  \"discount\" : 1.0246457001441578,\n  \"qtyinvoiced\" : 0.8851374739011653,\n  \"qtyreception\" : 6.519180951018382,\n  \"c_tax_id\" : 4,\n  \"m_shipper_id\" : 9,\n  \"freightamt\" : 6.84685269835264,\n  \"linebonusamt\" : 1.1730742509559433,\n  \"createdby\" : 2,\n  \"receptionamt\" : 7.740351818741173,\n  \"priceentered\" : 6.778324963048013,\n  \"manualgeneraldiscountamt\" : 9.369310271410669,\n  \"ad_client_id\" : 0,\n  \"pricediff\" : 2.8841621266687802,\n  \"pricereception\" : 6.704019297950036,\n  \"qtyordered\" : 7.058770351582356,\n  \"c_currency_id\" : 2,\n  \"created\" : \"created\",\n  \"datepromised\" : \"datepromised\",\n  \"datedelivered\" : \"datedelivered\",\n  \"pricelist\" : 5.944895607614016,\n  \"checkoutplace\" : \"checkoutplace\",\n  \"updated\" : \"updated\",\n  \"c_bpartner_id\" : 1,\n  \"dateinvoiced\" : \"dateinvoiced\",\n  \"qtydelivered\" : 3.353193347011243,\n  \"qtyreturned\" : 4.652396432933246,\n  \"ad_org_id\" : 6,\n  \"line\" : 7,\n  \"isactive\" : true,\n  \"referencedvalues\" : [ {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  } ],\n  \"description\" : \"description\",\n  \"diffamt\" : 1.2315135367772556,\n  \"order_min\" : 3.5571952270680973,\n  \"qtytransferred\" : 8.969578798196912,\n  \"qtydiff\" : 3.0937452626664474,\n  \"isdescription\" : true,\n  \"c_order_id\" : 7,\n  \"c_orderline_id\" : 9,\n  \"c_uom_id\" : 7,\n  \"m_attributesetinstance_id\" : 6,\n  \"linetotalamt\" : 9.965781217890562,\n  \"c_bpartner_location_id\" : 5,\n  \"m_warehouse_id\" : 6,\n  \"linenetamt\" : 5.025004791520295,\n  \"c_charge_id\" : 5,\n  \"pricelimit\" : 6.878052220127876,\n  \"qtyreserved\" : 0.10263654006109402,\n  \"dateordered\" : \"dateordered\",\n  \"processed\" : true,\n  \"salesrep_orig_id\" : 3,\n  \"c_project_id\" : 3,\n  \"order_pack\" : 6.965117697638846,\n  \"qtyentered\" : 7.143538047012306,\n  \"priceactual\" : 1.284659006116532\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default OrderlineApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Recupera una linea de pedido en particular", description = "Recupera la informacion de una linea de pedido en particular", security = {
        @SecurityRequirement(name = "jwtAuth")    }, tags={ "orderline" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderLine.class))) })
    @RequestMapping(value = "/v1.0/orderlines/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<OrderLine> retrieveOrderLine(@Parameter(in = ParameterIn.PATH, description = "ID de la linea de pedido", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\n  \"linediscountamt\" : 4.965218492984954,\n  \"m_product_id\" : 8,\n  \"updatedby\" : 7,\n  \"documentdiscountamt\" : 1.4894159098541704,\n  \"ref_orderline_id\" : 3,\n  \"discount\" : 1.0246457001441578,\n  \"qtyinvoiced\" : 0.8851374739011653,\n  \"qtyreception\" : 6.519180951018382,\n  \"c_tax_id\" : 4,\n  \"m_shipper_id\" : 9,\n  \"freightamt\" : 6.84685269835264,\n  \"linebonusamt\" : 1.1730742509559433,\n  \"createdby\" : 2,\n  \"receptionamt\" : 7.740351818741173,\n  \"priceentered\" : 6.778324963048013,\n  \"manualgeneraldiscountamt\" : 9.369310271410669,\n  \"ad_client_id\" : 0,\n  \"pricediff\" : 2.8841621266687802,\n  \"pricereception\" : 6.704019297950036,\n  \"qtyordered\" : 7.058770351582356,\n  \"c_currency_id\" : 2,\n  \"created\" : \"created\",\n  \"datepromised\" : \"datepromised\",\n  \"datedelivered\" : \"datedelivered\",\n  \"pricelist\" : 5.944895607614016,\n  \"checkoutplace\" : \"checkoutplace\",\n  \"updated\" : \"updated\",\n  \"c_bpartner_id\" : 1,\n  \"dateinvoiced\" : \"dateinvoiced\",\n  \"qtydelivered\" : 3.353193347011243,\n  \"qtyreturned\" : 4.652396432933246,\n  \"ad_org_id\" : 6,\n  \"line\" : 7,\n  \"isactive\" : true,\n  \"referencedvalues\" : [ {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  } ],\n  \"description\" : \"description\",\n  \"diffamt\" : 1.2315135367772556,\n  \"order_min\" : 3.5571952270680973,\n  \"qtytransferred\" : 8.969578798196912,\n  \"qtydiff\" : 3.0937452626664474,\n  \"isdescription\" : true,\n  \"c_order_id\" : 7,\n  \"c_orderline_id\" : 9,\n  \"c_uom_id\" : 7,\n  \"m_attributesetinstance_id\" : 6,\n  \"linetotalamt\" : 9.965781217890562,\n  \"c_bpartner_location_id\" : 5,\n  \"m_warehouse_id\" : 6,\n  \"linenetamt\" : 5.025004791520295,\n  \"c_charge_id\" : 5,\n  \"pricelimit\" : 6.878052220127876,\n  \"qtyreserved\" : 0.10263654006109402,\n  \"dateordered\" : \"dateordered\",\n  \"processed\" : true,\n  \"salesrep_orig_id\" : 3,\n  \"c_project_id\" : 3,\n  \"order_pack\" : 6.965117697638846,\n  \"qtyentered\" : 7.143538047012306,\n  \"priceactual\" : 1.284659006116532\n}", OrderLine.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default OrderlineApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Actualiza una linea de pedido existente", description = "", security = {
        @SecurityRequirement(name = "jwtAuth")    }, tags={ "orderline" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "409", description = "Imposible actualizar", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))) })
    @RequestMapping(value = "/v1.0/orderlines/{id}",
        produces = { "text/plain" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    default ResponseEntity<String> updateOrderLine(@Parameter(in = ParameterIn.PATH, description = "ID de la linea de pedido a actualizar", required=true, schema=@Schema()) @PathVariable("id") Integer id, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody OrderLine body) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("\"\"", String.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default OrderlineApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
