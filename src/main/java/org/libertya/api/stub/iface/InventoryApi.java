/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.46).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package org.libertya.api.stub.iface;

import org.libertya.api.stub.model.Inventory;
import org.libertya.api.stub.model.InventoryDocument;
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
public interface InventoryApi {

    Logger log = LoggerFactory.getLogger(InventoryApi.class);

    default Optional<ObjectMapper> getObjectMapper(){
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest(){
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @Operation(summary = "Nuevo inventario", description = "Agrega una nuevo inventario", security = {
        @SecurityRequirement(name = "jwtAuth")    }, tags={ "inventory" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK. ID de inventario creado es retornado", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "409", description = "Imposible insertar", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))) })
    @RequestMapping(value = "/v1.0/inventories",
        produces = { "text/plain" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    default ResponseEntity<String> addInventory(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody InventoryDocument body) {
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
            log.warn("ObjectMapper or HttpServletRequest not configured in default InventoryApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Elimina un inventario", description = "Elimina un inventario existente", security = {
        @SecurityRequirement(name = "jwtAuth")    }, tags={ "inventory" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "409", description = "Imposible eliminar", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "204", description = "OK", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))) })
    @RequestMapping(value = "/v1.0/inventories/{id}",
        produces = { "text/plain" }, 
        method = RequestMethod.DELETE)
    default ResponseEntity<String> deleteInventory(@Parameter(in = ParameterIn.PATH, description = "ID del inventario", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
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
            log.warn("ObjectMapper or HttpServletRequest not configured in default InventoryApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Retorna la lista de inventarios", description = "Retorna una lista de inventarios", security = {
        @SecurityRequirement(name = "jwtAuth")    }, tags={ "inventory" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Inventory.class)))) })
    @RequestMapping(value = "/v1.0/inventories",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<Inventory>> getAllInventories(@Parameter(in = ParameterIn.QUERY, description = "Criterio de filtrado" ,schema=@Schema()) @Valid @RequestParam(value = "filter", required = false) String filter, @Parameter(in = ParameterIn.QUERY, description = "Campos a recuperar" ,schema=@Schema()) @Valid @RequestParam(value = "fields", required = false) String fields, @Parameter(in = ParameterIn.QUERY, description = "Criterio de ordenado" ,schema=@Schema()) @Valid @RequestParam(value = "sort", required = false) String sort, @Parameter(in = ParameterIn.QUERY, description = "Limite de elementos a retornar por pagina" ,schema=@Schema()) @Valid @RequestParam(value = "limit", required = false) Integer limit, @Parameter(in = ParameterIn.QUERY, description = "Numero de pagina" ,schema=@Schema()) @Valid @RequestParam(value = "page", required = false) Integer page) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {\n  \"updatedby\" : 1,\n  \"c_activity_id\" : 5,\n  \"c_campaign_id\" : 2,\n  \"ad_org_id\" : 6,\n  \"isactive\" : true,\n  \"referencedvalues\" : [ null, null ],\n  \"description\" : \"description\",\n  \"c_doctype_id\" : 9,\n  \"paper_form\" : \"paper_form\",\n  \"posted\" : \"posted\",\n  \"createdby\" : 2,\n  \"ad_client_id\" : 0,\n  \"updateqty\" : \"updateqty\",\n  \"approvalamt\" : 5.962133916683182,\n  \"user2_id\" : 6,\n  \"docstatus\" : \"docstatus\",\n  \"m_warehouse_id\" : 1,\n  \"ad_orgtrx_id\" : 1,\n  \"isapproved\" : true,\n  \"created\" : \"created\",\n  \"m_perpetualinv_id\" : 7,\n  \"c_charge_id\" : 7,\n  \"generatelist\" : \"generatelist\",\n  \"inventorykind\" : \"inventorykind\",\n  \"documentno\" : \"documentno\",\n  \"processed\" : true,\n  \"m_inventory_id\" : 4,\n  \"additionalvalues\" : [ {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  } ],\n  \"c_project_id\" : 3,\n  \"docaction\" : \"docaction\",\n  \"processing\" : true,\n  \"user1_id\" : 1,\n  \"updated\" : \"updated\",\n  \"movementdate\" : \"movementdate\"\n}, {\n  \"updatedby\" : 1,\n  \"c_activity_id\" : 5,\n  \"c_campaign_id\" : 2,\n  \"ad_org_id\" : 6,\n  \"isactive\" : true,\n  \"referencedvalues\" : [ null, null ],\n  \"description\" : \"description\",\n  \"c_doctype_id\" : 9,\n  \"paper_form\" : \"paper_form\",\n  \"posted\" : \"posted\",\n  \"createdby\" : 2,\n  \"ad_client_id\" : 0,\n  \"updateqty\" : \"updateqty\",\n  \"approvalamt\" : 5.962133916683182,\n  \"user2_id\" : 6,\n  \"docstatus\" : \"docstatus\",\n  \"m_warehouse_id\" : 1,\n  \"ad_orgtrx_id\" : 1,\n  \"isapproved\" : true,\n  \"created\" : \"created\",\n  \"m_perpetualinv_id\" : 7,\n  \"c_charge_id\" : 7,\n  \"generatelist\" : \"generatelist\",\n  \"inventorykind\" : \"inventorykind\",\n  \"documentno\" : \"documentno\",\n  \"processed\" : true,\n  \"m_inventory_id\" : 4,\n  \"additionalvalues\" : [ {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  } ],\n  \"c_project_id\" : 3,\n  \"docaction\" : \"docaction\",\n  \"processing\" : true,\n  \"user1_id\" : 1,\n  \"updated\" : \"updated\",\n  \"movementdate\" : \"movementdate\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default InventoryApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Procesa un inventario", description = "", security = {
        @SecurityRequirement(name = "jwtAuth")    }, tags={ "inventory" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "409", description = "Imposible procesar", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))) })
    @RequestMapping(value = "/v1.0/inventories/{id}/process",
        produces = { "text/plain" }, 
        method = RequestMethod.PUT)
    default ResponseEntity<String> processInventory(@Parameter(in = ParameterIn.PATH, description = "ID del inventario a procesar", required=true, schema=@Schema()) @PathVariable("id") Integer id, @NotNull @Parameter(in = ParameterIn.QUERY, description = "Accion a aplicar (completar, revertir, etc.)" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "action", required = true) String action) {
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
            log.warn("ObjectMapper or HttpServletRequest not configured in default InventoryApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Recupera un inventario en particular", description = "Recupera la informacion de un inventario en particular", security = {
        @SecurityRequirement(name = "jwtAuth")    }, tags={ "inventory" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InventoryDocument.class))) })
    @RequestMapping(value = "/v1.0/inventories/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<InventoryDocument> retrieveInventory(@Parameter(in = ParameterIn.PATH, description = "ID del inventario", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\n  \"header\" : {\n    \"updatedby\" : 1,\n    \"c_activity_id\" : 5,\n    \"c_campaign_id\" : 2,\n    \"ad_org_id\" : 6,\n    \"isactive\" : true,\n    \"referencedvalues\" : [ null, null ],\n    \"description\" : \"description\",\n    \"c_doctype_id\" : 9,\n    \"paper_form\" : \"paper_form\",\n    \"posted\" : \"posted\",\n    \"createdby\" : 2,\n    \"ad_client_id\" : 0,\n    \"updateqty\" : \"updateqty\",\n    \"approvalamt\" : 5.962133916683182,\n    \"user2_id\" : 6,\n    \"docstatus\" : \"docstatus\",\n    \"m_warehouse_id\" : 1,\n    \"ad_orgtrx_id\" : 1,\n    \"isapproved\" : true,\n    \"created\" : \"created\",\n    \"m_perpetualinv_id\" : 7,\n    \"c_charge_id\" : 7,\n    \"generatelist\" : \"generatelist\",\n    \"inventorykind\" : \"inventorykind\",\n    \"documentno\" : \"documentno\",\n    \"processed\" : true,\n    \"m_inventory_id\" : 4,\n    \"additionalvalues\" : [ {\n      \"value\" : \"value\",\n      \"key\" : \"key\"\n    }, {\n      \"value\" : \"value\",\n      \"key\" : \"key\"\n    } ],\n    \"c_project_id\" : 3,\n    \"docaction\" : \"docaction\",\n    \"processing\" : true,\n    \"user1_id\" : 1,\n    \"updated\" : \"updated\",\n    \"movementdate\" : \"movementdate\"\n  },\n  \"lines\" : [ {\n    \"qtycount\" : 1.2315135367772556,\n    \"qtyinternaluse\" : 1.4894159098541704,\n    \"cost\" : 5.962133916683182,\n    \"m_product_id\" : 4,\n    \"updatedby\" : 6,\n    \"ad_org_id\" : 6,\n    \"created\" : \"created\",\n    \"line\" : 2,\n    \"isactive\" : true,\n    \"referencedvalues\" : [ null, null ],\n    \"c_charge_id\" : 1,\n    \"m_locator_id\" : 2,\n    \"description\" : \"description\",\n    \"qtycountwithoutchargesign\" : 1.0246457001441578,\n    \"processed\" : true,\n    \"m_inventoryline_id\" : 3,\n    \"inventorytype\" : \"inventorytype\",\n    \"createdby\" : 5,\n    \"m_inventory_id\" : 9,\n    \"qtybook\" : 7.386281948385884,\n    \"additionalvalues\" : [ {\n      \"value\" : \"value\",\n      \"key\" : \"key\"\n    }, {\n      \"value\" : \"value\",\n      \"key\" : \"key\"\n    } ],\n    \"m_attributesetinstance_id\" : 7,\n    \"ad_client_id\" : 0,\n    \"updated\" : \"updated\"\n  }, {\n    \"qtycount\" : 1.2315135367772556,\n    \"qtyinternaluse\" : 1.4894159098541704,\n    \"cost\" : 5.962133916683182,\n    \"m_product_id\" : 4,\n    \"updatedby\" : 6,\n    \"ad_org_id\" : 6,\n    \"created\" : \"created\",\n    \"line\" : 2,\n    \"isactive\" : true,\n    \"referencedvalues\" : [ null, null ],\n    \"c_charge_id\" : 1,\n    \"m_locator_id\" : 2,\n    \"description\" : \"description\",\n    \"qtycountwithoutchargesign\" : 1.0246457001441578,\n    \"processed\" : true,\n    \"m_inventoryline_id\" : 3,\n    \"inventorytype\" : \"inventorytype\",\n    \"createdby\" : 5,\n    \"m_inventory_id\" : 9,\n    \"qtybook\" : 7.386281948385884,\n    \"additionalvalues\" : [ {\n      \"value\" : \"value\",\n      \"key\" : \"key\"\n    }, {\n      \"value\" : \"value\",\n      \"key\" : \"key\"\n    } ],\n    \"m_attributesetinstance_id\" : 7,\n    \"ad_client_id\" : 0,\n    \"updated\" : \"updated\"\n  } ]\n}", InventoryDocument.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default InventoryApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Actualiza un inventario existente", description = "", security = {
        @SecurityRequirement(name = "jwtAuth")    }, tags={ "inventory" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "409", description = "Imposible actualizar", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))) })
    @RequestMapping(value = "/v1.0/inventories/{id}",
        produces = { "text/plain" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    default ResponseEntity<String> updateInventory(@Parameter(in = ParameterIn.PATH, description = "ID del inventario a actualizar", required=true, schema=@Schema()) @PathVariable("id") Integer id, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Inventory body) {
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
            log.warn("ObjectMapper or HttpServletRequest not configured in default InventoryApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}

