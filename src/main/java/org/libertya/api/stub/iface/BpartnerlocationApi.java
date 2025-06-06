/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.46).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package org.libertya.api.stub.iface;

import org.libertya.api.stub.model.BPartnerLocation;
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
public interface BpartnerlocationApi {

    Logger log = LoggerFactory.getLogger(BpartnerlocationApi.class);

    default Optional<ObjectMapper> getObjectMapper(){
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest(){
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @Operation(summary = "Nueva direccion de entidad comercial", description = "Agrega una nueva direccion de entidad comercial", security = {
        @SecurityRequirement(name = "jwtAuth")    }, tags={ "bpartnerlocation" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK. ID de direccion de entidad comercial creada es retornado", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "409", description = "Imposible insertar", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))) })
    @RequestMapping(value = "/v1.0/bpartnerlocations",
        produces = { "text/plain" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    default ResponseEntity<String> addBPartnerLocation(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody BPartnerLocation body) {
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
            log.warn("ObjectMapper or HttpServletRequest not configured in default BpartnerlocationApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Elimina una direccion de entidad comercial", description = "Elimina una direccion de entidad comercial existente", security = {
        @SecurityRequirement(name = "jwtAuth")    }, tags={ "bpartnerlocation" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "409", description = "Imposible eliminar", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "204", description = "OK", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))) })
    @RequestMapping(value = "/v1.0/bpartnerlocations/{id}",
        produces = { "text/plain" }, 
        method = RequestMethod.DELETE)
    default ResponseEntity<String> deleteBPartnerLocation(@Parameter(in = ParameterIn.PATH, description = "ID de direccion de entidad comercial", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
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
            log.warn("ObjectMapper or HttpServletRequest not configured in default BpartnerlocationApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Retorna la lista de direcciones de entidad comercial", description = "Retorna la lista completa de direcciones de entidad comercial", security = {
        @SecurityRequirement(name = "jwtAuth")    }, tags={ "bpartnerlocation" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BPartnerLocation.class)))) })
    @RequestMapping(value = "/v1.0/bpartnerlocations",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<BPartnerLocation>> getAllBPartnerLocations(@Parameter(in = ParameterIn.QUERY, description = "Criterio de filtrado" ,schema=@Schema()) @Valid @RequestParam(value = "filter", required = false) String filter, @Parameter(in = ParameterIn.QUERY, description = "Campos a recuperar" ,schema=@Schema()) @Valid @RequestParam(value = "fields", required = false) String fields, @Parameter(in = ParameterIn.QUERY, description = "Criterio de ordenado" ,schema=@Schema()) @Valid @RequestParam(value = "sort", required = false) String sort, @Parameter(in = ParameterIn.QUERY, description = "Limite de elementos a retornar por pagina" ,schema=@Schema()) @Valid @RequestParam(value = "limit", required = false) Integer limit, @Parameter(in = ParameterIn.QUERY, description = "Numero de pagina" ,schema=@Schema()) @Valid @RequestParam(value = "page", required = false) Integer page) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {\n  \"updatedby\" : 9,\n  \"isdn\" : \"isdn\",\n  \"ad_org_id\" : 6,\n  \"isactive\" : true,\n  \"referencedvalues\" : [ null, null ],\n  \"phone2\" : \"phone2\",\n  \"c_location_id\" : 5,\n  \"isbillto\" : true,\n  \"isshipto\" : true,\n  \"ad_componentobjectuid\" : \"ad_componentobjectuid\",\n  \"createdby\" : 2,\n  \"istemporal\" : true,\n  \"ad_client_id\" : 0,\n  \"fax\" : \"fax\",\n  \"isremitto\" : true,\n  \"c_bpartner_location_id\" : 5,\n  \"email\" : \"email\",\n  \"c_salesregion_id\" : 7,\n  \"created\" : \"created\",\n  \"phone\" : \"phone\",\n  \"additionalvalues\" : [ {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  } ],\n  \"name\" : \"name\",\n  \"ispayfrom\" : true,\n  \"updated\" : \"updated\",\n  \"c_bpartner_id\" : 1\n}, {\n  \"updatedby\" : 9,\n  \"isdn\" : \"isdn\",\n  \"ad_org_id\" : 6,\n  \"isactive\" : true,\n  \"referencedvalues\" : [ null, null ],\n  \"phone2\" : \"phone2\",\n  \"c_location_id\" : 5,\n  \"isbillto\" : true,\n  \"isshipto\" : true,\n  \"ad_componentobjectuid\" : \"ad_componentobjectuid\",\n  \"createdby\" : 2,\n  \"istemporal\" : true,\n  \"ad_client_id\" : 0,\n  \"fax\" : \"fax\",\n  \"isremitto\" : true,\n  \"c_bpartner_location_id\" : 5,\n  \"email\" : \"email\",\n  \"c_salesregion_id\" : 7,\n  \"created\" : \"created\",\n  \"phone\" : \"phone\",\n  \"additionalvalues\" : [ {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  } ],\n  \"name\" : \"name\",\n  \"ispayfrom\" : true,\n  \"updated\" : \"updated\",\n  \"c_bpartner_id\" : 1\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default BpartnerlocationApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Recupera una direccion de entidad comercial en particular", description = "Recupera la informacion de una direccion  de entidad comercial  en particular", security = {
        @SecurityRequirement(name = "jwtAuth")    }, tags={ "bpartnerlocation" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BPartnerLocation.class))) })
    @RequestMapping(value = "/v1.0/bpartnerlocations/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<BPartnerLocation> retrieveBPartnerLocation(@Parameter(in = ParameterIn.PATH, description = "ID de la direccion de entidad comercial", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\n  \"updatedby\" : 9,\n  \"isdn\" : \"isdn\",\n  \"ad_org_id\" : 6,\n  \"isactive\" : true,\n  \"referencedvalues\" : [ null, null ],\n  \"phone2\" : \"phone2\",\n  \"c_location_id\" : 5,\n  \"isbillto\" : true,\n  \"isshipto\" : true,\n  \"ad_componentobjectuid\" : \"ad_componentobjectuid\",\n  \"createdby\" : 2,\n  \"istemporal\" : true,\n  \"ad_client_id\" : 0,\n  \"fax\" : \"fax\",\n  \"isremitto\" : true,\n  \"c_bpartner_location_id\" : 5,\n  \"email\" : \"email\",\n  \"c_salesregion_id\" : 7,\n  \"created\" : \"created\",\n  \"phone\" : \"phone\",\n  \"additionalvalues\" : [ {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  } ],\n  \"name\" : \"name\",\n  \"ispayfrom\" : true,\n  \"updated\" : \"updated\",\n  \"c_bpartner_id\" : 1\n}", BPartnerLocation.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default BpartnerlocationApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Actualiza una direccion de entidad comercial existente", description = "", security = {
        @SecurityRequirement(name = "jwtAuth")    }, tags={ "bpartnerlocation" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "409", description = "Imposible actualizar", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))) })
    @RequestMapping(value = "/v1.0/bpartnerlocations/{id}",
        produces = { "text/plain" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    default ResponseEntity<String> updateBPartnerLocation(@Parameter(in = ParameterIn.PATH, description = "ID de la direccion de entidad comercial a actualizar", required=true, schema=@Schema()) @PathVariable("id") Integer id, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody BPartnerLocation body) {
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
            log.warn("ObjectMapper or HttpServletRequest not configured in default BpartnerlocationApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}

