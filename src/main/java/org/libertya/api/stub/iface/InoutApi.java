/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.20).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package org.libertya.api.stub.iface;

import org.libertya.api.stub.model.InOut;
import org.libertya.api.stub.model.InOutDocument;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
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
@Api(value = "Inout", description = "the Inout API")
public interface InoutApi {

    Logger log = LoggerFactory.getLogger(InoutApi.class);

    default Optional<ObjectMapper> getObjectMapper(){
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest(){
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "Nuevo remito", nickname = "addInOut", notes = "Agrega un nuevo remito", response = String.class, tags={ "inout", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK. ID de remito creado es retornado", response = String.class),
        @ApiResponse(code = 409, message = "Imposible insertar", response = String.class) })
    @RequestMapping(value = "/v1.0/inouts",
        produces = { "text/plain" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<String> addInOut(@ApiParam(value = "" ,required=true )  @Valid @RequestBody InOutDocument body
) {
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
            log.warn("ObjectMapper or HttpServletRequest not configured in default InoutApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Elimina un remito", nickname = "deleteInOut", notes = "Elimina un remito existente", response = String.class, tags={ "inout", })
    @ApiResponses(value = { 
        @ApiResponse(code = 409, message = "Imposible eliminar", response = String.class),
        @ApiResponse(code = 404, message = "No encontrado", response = String.class),
        @ApiResponse(code = 204, message = "OK", response = String.class) })
    @RequestMapping(value = "/v1.0/inouts/{id}",
        produces = { "text/plain" }, 
        method = RequestMethod.DELETE)
    default ResponseEntity<String> deleteInOut(@ApiParam(value = "ID del remito",required=true) @PathVariable("id") Integer id
) {
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
            log.warn("ObjectMapper or HttpServletRequest not configured in default InoutApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Retrieve inouts", nickname = "getAllInOuts", notes = "Retorna una lista de remitos", response = InOut.class, responseContainer = "List", tags={ "inout", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = InOut.class, responseContainer = "List") })
    @RequestMapping(value = "/v1.0/inouts",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<InOut>> getAllInOuts(@ApiParam(value = "Criterio de filtrado") @Valid @RequestParam(value = "filter", required = false) String filter
,@ApiParam(value = "Campos a recuperar") @Valid @RequestParam(value = "fields", required = false) String fields
,@ApiParam(value = "Criterio de ordenado") @Valid @RequestParam(value = "sort", required = false) String sort
,@ApiParam(value = "Limite de elementos a retornar por pagina") @Valid @RequestParam(value = "limit", required = false) Integer limit
,@ApiParam(value = "Desplazamiento de salto a patir del primer elemento") @Valid @RequestParam(value = "offset", required = false) Integer offset
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {\n  \"updatedby\" : 6,\n  \"c_activity_id\" : 5,\n  \"chargeamt\" : 4.145608029883936,\n  \"c_campaign_id\" : 9,\n  \"m_shipper_id\" : 1,\n  \"datereceived\" : \"datereceived\",\n  \"freightamt\" : 6.84685269835264,\n  \"printtype\" : \"printtype\",\n  \"createdby\" : 1,\n  \"receptiondate\" : \"receptiondate\",\n  \"trackingno\" : \"trackingno\",\n  \"ad_client_id\" : 0,\n  \"user2_id\" : 9,\n  \"docstatus\" : \"docstatus\",\n  \"dateacct\" : \"dateacct\",\n  \"created\" : \"created\",\n  \"clearancenumber\" : \"clearancenumber\",\n  \"isintransit\" : true,\n  \"m_inout_id\" : 7,\n  \"preprinted_docno\" : \"preprinted_docno\",\n  \"ad_user_id\" : 5,\n  \"user1_id\" : 8,\n  \"pickdate\" : \"pickdate\",\n  \"updated\" : \"updated\",\n  \"c_bpartner_id\" : 2,\n  \"issotrx\" : true,\n  \"priorityrule\" : \"priorityrule\",\n  \"deliveryrule\" : \"deliveryrule\",\n  \"movementtype\" : \"movementtype\",\n  \"ad_org_id\" : 6,\n  \"isactive\" : true,\n  \"description\" : \"description\",\n  \"cai\" : \"cai\",\n  \"c_doctype_id\" : 2,\n  \"c_invoice_id\" : 7,\n  \"nopackages\" : 5,\n  \"freightcostrule\" : \"freightcostrule\",\n  \"isprinted\" : true,\n  \"c_order_id\" : 1,\n  \"inoutreceptiondate\" : \"inoutreceptiondate\",\n  \"isindispute\" : true,\n  \"datecai\" : \"datecai\",\n  \"c_bpartner_location_id\" : 7,\n  \"dateprinted\" : \"dateprinted\",\n  \"m_warehouse_id\" : 4,\n  \"shipdate\" : \"shipdate\",\n  \"ad_orgtrx_id\" : 1,\n  \"isapproved\" : true,\n  \"ref_inout_id\" : 9,\n  \"c_charge_id\" : 3,\n  \"inoutdate\" : \"inoutdate\",\n  \"deliveryviarule\" : \"deliveryviarule\",\n  \"poreference\" : \"poreference\",\n  \"dateordered\" : \"dateordered\",\n  \"documentno\" : \"documentno\",\n  \"processed\" : true,\n  \"salesrep_id\" : 9,\n  \"c_project_id\" : 1,\n  \"sendemail\" : true,\n  \"movementdate\" : \"movementdate\"\n}, {\n  \"updatedby\" : 6,\n  \"c_activity_id\" : 5,\n  \"chargeamt\" : 4.145608029883936,\n  \"c_campaign_id\" : 9,\n  \"m_shipper_id\" : 1,\n  \"datereceived\" : \"datereceived\",\n  \"freightamt\" : 6.84685269835264,\n  \"printtype\" : \"printtype\",\n  \"createdby\" : 1,\n  \"receptiondate\" : \"receptiondate\",\n  \"trackingno\" : \"trackingno\",\n  \"ad_client_id\" : 0,\n  \"user2_id\" : 9,\n  \"docstatus\" : \"docstatus\",\n  \"dateacct\" : \"dateacct\",\n  \"created\" : \"created\",\n  \"clearancenumber\" : \"clearancenumber\",\n  \"isintransit\" : true,\n  \"m_inout_id\" : 7,\n  \"preprinted_docno\" : \"preprinted_docno\",\n  \"ad_user_id\" : 5,\n  \"user1_id\" : 8,\n  \"pickdate\" : \"pickdate\",\n  \"updated\" : \"updated\",\n  \"c_bpartner_id\" : 2,\n  \"issotrx\" : true,\n  \"priorityrule\" : \"priorityrule\",\n  \"deliveryrule\" : \"deliveryrule\",\n  \"movementtype\" : \"movementtype\",\n  \"ad_org_id\" : 6,\n  \"isactive\" : true,\n  \"description\" : \"description\",\n  \"cai\" : \"cai\",\n  \"c_doctype_id\" : 2,\n  \"c_invoice_id\" : 7,\n  \"nopackages\" : 5,\n  \"freightcostrule\" : \"freightcostrule\",\n  \"isprinted\" : true,\n  \"c_order_id\" : 1,\n  \"inoutreceptiondate\" : \"inoutreceptiondate\",\n  \"isindispute\" : true,\n  \"datecai\" : \"datecai\",\n  \"c_bpartner_location_id\" : 7,\n  \"dateprinted\" : \"dateprinted\",\n  \"m_warehouse_id\" : 4,\n  \"shipdate\" : \"shipdate\",\n  \"ad_orgtrx_id\" : 1,\n  \"isapproved\" : true,\n  \"ref_inout_id\" : 9,\n  \"c_charge_id\" : 3,\n  \"inoutdate\" : \"inoutdate\",\n  \"deliveryviarule\" : \"deliveryviarule\",\n  \"poreference\" : \"poreference\",\n  \"dateordered\" : \"dateordered\",\n  \"documentno\" : \"documentno\",\n  \"processed\" : true,\n  \"salesrep_id\" : 9,\n  \"c_project_id\" : 1,\n  \"sendemail\" : true,\n  \"movementdate\" : \"movementdate\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default InoutApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Procesa un remito", nickname = "processInOut", notes = "", response = String.class, tags={ "inout", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = String.class),
        @ApiResponse(code = 409, message = "Imposible procesar", response = String.class),
        @ApiResponse(code = 404, message = "No encontrado", response = String.class) })
    @RequestMapping(value = "/v1.0/inouts/{id}/process",
        produces = { "text/plain" }, 
        method = RequestMethod.PUT)
    default ResponseEntity<String> processInOut(@ApiParam(value = "ID del remito a procesar",required=true) @PathVariable("id") Integer id
,@NotNull @ApiParam(value = "Accion a aplicar (completar, revertir, etc.)", required = true) @Valid @RequestParam(value = "action", required = true) String action
) {
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
            log.warn("ObjectMapper or HttpServletRequest not configured in default InoutApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Recupera un remito en particular", nickname = "retrieveInOut", notes = "Recupera la informacion de un remito en particular", response = InOutDocument.class, tags={ "inout", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = InOutDocument.class) })
    @RequestMapping(value = "/v1.0/inouts/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<InOutDocument> retrieveInOut(@ApiParam(value = "ID del remito",required=true) @PathVariable("id") Integer id
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\n  \"header\" : {\n    \"updatedby\" : 6,\n    \"c_activity_id\" : 5,\n    \"chargeamt\" : 4.145608029883936,\n    \"c_campaign_id\" : 9,\n    \"m_shipper_id\" : 1,\n    \"datereceived\" : \"datereceived\",\n    \"freightamt\" : 6.84685269835264,\n    \"printtype\" : \"printtype\",\n    \"createdby\" : 1,\n    \"receptiondate\" : \"receptiondate\",\n    \"trackingno\" : \"trackingno\",\n    \"ad_client_id\" : 0,\n    \"user2_id\" : 9,\n    \"docstatus\" : \"docstatus\",\n    \"dateacct\" : \"dateacct\",\n    \"created\" : \"created\",\n    \"clearancenumber\" : \"clearancenumber\",\n    \"isintransit\" : true,\n    \"m_inout_id\" : 7,\n    \"preprinted_docno\" : \"preprinted_docno\",\n    \"ad_user_id\" : 5,\n    \"user1_id\" : 8,\n    \"pickdate\" : \"pickdate\",\n    \"updated\" : \"updated\",\n    \"c_bpartner_id\" : 2,\n    \"issotrx\" : true,\n    \"priorityrule\" : \"priorityrule\",\n    \"deliveryrule\" : \"deliveryrule\",\n    \"movementtype\" : \"movementtype\",\n    \"ad_org_id\" : 6,\n    \"isactive\" : true,\n    \"description\" : \"description\",\n    \"cai\" : \"cai\",\n    \"c_doctype_id\" : 2,\n    \"c_invoice_id\" : 7,\n    \"nopackages\" : 5,\n    \"freightcostrule\" : \"freightcostrule\",\n    \"isprinted\" : true,\n    \"c_order_id\" : 1,\n    \"inoutreceptiondate\" : \"inoutreceptiondate\",\n    \"isindispute\" : true,\n    \"datecai\" : \"datecai\",\n    \"c_bpartner_location_id\" : 7,\n    \"dateprinted\" : \"dateprinted\",\n    \"m_warehouse_id\" : 4,\n    \"shipdate\" : \"shipdate\",\n    \"ad_orgtrx_id\" : 1,\n    \"isapproved\" : true,\n    \"ref_inout_id\" : 9,\n    \"c_charge_id\" : 3,\n    \"inoutdate\" : \"inoutdate\",\n    \"deliveryviarule\" : \"deliveryviarule\",\n    \"poreference\" : \"poreference\",\n    \"dateordered\" : \"dateordered\",\n    \"documentno\" : \"documentno\",\n    \"processed\" : true,\n    \"salesrep_id\" : 9,\n    \"c_project_id\" : 1,\n    \"sendemail\" : true,\n    \"movementdate\" : \"movementdate\"\n  },\n  \"lines\" : [ {\n    \"m_product_id\" : 4,\n    \"updatedby\" : 9,\n    \"ad_org_id\" : 6,\n    \"line\" : 7,\n    \"isactive\" : true,\n    \"c_invoiceline_id\" : 5,\n    \"m_locator_id\" : 7,\n    \"description\" : \"description\",\n    \"costprice\" : 9.301444243932576,\n    \"m_inoutline_id\" : 6,\n    \"isinvoiced\" : true,\n    \"isdescription\" : true,\n    \"createdby\" : 2,\n    \"c_orderline_id\" : 7,\n    \"movementqty\" : 1.1730742509559433,\n    \"c_uom_id\" : 4,\n    \"m_attributesetinstance_id\" : 1,\n    \"ad_client_id\" : 0,\n    \"scrappedqty\" : 6.683562403749608,\n    \"ref_inoutline_id\" : 9,\n    \"pickedqty\" : 5.025004791520295,\n    \"m_import_clearance_id\" : 1,\n    \"created\" : \"created\",\n    \"isselected\" : true,\n    \"targetqty\" : 8.762042012749001,\n    \"m_inout_id\" : 1,\n    \"c_charge_id\" : 1,\n    \"declarationno\" : \"declarationno\",\n    \"c_country_id\" : 5,\n    \"processed\" : true,\n    \"confirmedqty\" : 2.3021358869347655,\n    \"c_project_id\" : 3,\n    \"qtyentered\" : 9.965781217890562,\n    \"updated\" : \"updated\"\n  }, {\n    \"m_product_id\" : 4,\n    \"updatedby\" : 9,\n    \"ad_org_id\" : 6,\n    \"line\" : 7,\n    \"isactive\" : true,\n    \"c_invoiceline_id\" : 5,\n    \"m_locator_id\" : 7,\n    \"description\" : \"description\",\n    \"costprice\" : 9.301444243932576,\n    \"m_inoutline_id\" : 6,\n    \"isinvoiced\" : true,\n    \"isdescription\" : true,\n    \"createdby\" : 2,\n    \"c_orderline_id\" : 7,\n    \"movementqty\" : 1.1730742509559433,\n    \"c_uom_id\" : 4,\n    \"m_attributesetinstance_id\" : 1,\n    \"ad_client_id\" : 0,\n    \"scrappedqty\" : 6.683562403749608,\n    \"ref_inoutline_id\" : 9,\n    \"pickedqty\" : 5.025004791520295,\n    \"m_import_clearance_id\" : 1,\n    \"created\" : \"created\",\n    \"isselected\" : true,\n    \"targetqty\" : 8.762042012749001,\n    \"m_inout_id\" : 1,\n    \"c_charge_id\" : 1,\n    \"declarationno\" : \"declarationno\",\n    \"c_country_id\" : 5,\n    \"processed\" : true,\n    \"confirmedqty\" : 2.3021358869347655,\n    \"c_project_id\" : 3,\n    \"qtyentered\" : 9.965781217890562,\n    \"updated\" : \"updated\"\n  } ]\n}", InOutDocument.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default InoutApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Actualiza un remito existente", nickname = "updateInOut", notes = "", response = String.class, tags={ "inout", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = String.class),
        @ApiResponse(code = 409, message = "Imposible actualizar", response = String.class),
        @ApiResponse(code = 404, message = "No encontrado", response = String.class) })
    @RequestMapping(value = "/v1.0/inouts/{id}",
        produces = { "text/plain" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    default ResponseEntity<String> updateInOut(@ApiParam(value = "" ,required=true )  @Valid @RequestBody InOut body
,@ApiParam(value = "ID del remito a actualizar",required=true) @PathVariable("id") Integer id
) {
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
            log.warn("ObjectMapper or HttpServletRequest not configured in default InoutApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}