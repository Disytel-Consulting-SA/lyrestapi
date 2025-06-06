/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.46).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package org.libertya.api.stub.iface;

import org.libertya.api.stub.model.Bank;
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
public interface BankApi {

    Logger log = LoggerFactory.getLogger(BankApi.class);

    default Optional<ObjectMapper> getObjectMapper(){
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest(){
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @Operation(summary = "Nuevo banco", description = "Agrega un nuevo banco", security = {
        @SecurityRequirement(name = "jwtAuth")    }, tags={ "bank" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK. ID de banco creado es retornado", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "409", description = "Imposible insertar", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))) })
    @RequestMapping(value = "/v1.0/banks",
        produces = { "text/plain" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    default ResponseEntity<String> addBank(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Bank body) {
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
            log.warn("ObjectMapper or HttpServletRequest not configured in default BankApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Elimina un banco", description = "Elimina un banco existente", security = {
        @SecurityRequirement(name = "jwtAuth")    }, tags={ "bank" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "409", description = "Imposible eliminar", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "204", description = "OK", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))) })
    @RequestMapping(value = "/v1.0/banks/{id}",
        produces = { "text/plain" }, 
        method = RequestMethod.DELETE)
    default ResponseEntity<String> deleteBank(@Parameter(in = ParameterIn.PATH, description = "ID de banco", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
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
            log.warn("ObjectMapper or HttpServletRequest not configured in default BankApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Retorna la lista de bancos", description = "Retorna la lista completa de bancos", security = {
        @SecurityRequirement(name = "jwtAuth")    }, tags={ "bank" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Bank.class)))) })
    @RequestMapping(value = "/v1.0/banks",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<Bank>> getAllBanks(@Parameter(in = ParameterIn.QUERY, description = "Criterio de filtrado" ,schema=@Schema()) @Valid @RequestParam(value = "filter", required = false) String filter, @Parameter(in = ParameterIn.QUERY, description = "Campos a recuperar" ,schema=@Schema()) @Valid @RequestParam(value = "fields", required = false) String fields, @Parameter(in = ParameterIn.QUERY, description = "Criterio de ordenado" ,schema=@Schema()) @Valid @RequestParam(value = "sort", required = false) String sort, @Parameter(in = ParameterIn.QUERY, description = "Limite de elementos a retornar por pagina" ,schema=@Schema()) @Valid @RequestParam(value = "limit", required = false) Integer limit, @Parameter(in = ParameterIn.QUERY, description = "Numero de pagina" ,schema=@Schema()) @Valid @RequestParam(value = "page", required = false) Integer page) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {\n  \"isownbank\" : true,\n  \"updatedby\" : 2,\n  \"routingno\" : \"routingno\",\n  \"ad_org_id\" : 6,\n  \"created\" : \"created\",\n  \"isactive\" : true,\n  \"referencedvalues\" : [ null, null ],\n  \"description\" : \"description\",\n  \"c_location_id\" : 5,\n  \"c_bank_id\" : 1,\n  \"ad_componentobjectuid\" : \"ad_componentobjectuid\",\n  \"createdby\" : 5,\n  \"additionalvalues\" : [ {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  } ],\n  \"swiftcode\" : \"swiftcode\",\n  \"name\" : \"name\",\n  \"ad_client_id\" : 0,\n  \"updated\" : \"updated\"\n}, {\n  \"isownbank\" : true,\n  \"updatedby\" : 2,\n  \"routingno\" : \"routingno\",\n  \"ad_org_id\" : 6,\n  \"created\" : \"created\",\n  \"isactive\" : true,\n  \"referencedvalues\" : [ null, null ],\n  \"description\" : \"description\",\n  \"c_location_id\" : 5,\n  \"c_bank_id\" : 1,\n  \"ad_componentobjectuid\" : \"ad_componentobjectuid\",\n  \"createdby\" : 5,\n  \"additionalvalues\" : [ {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  } ],\n  \"swiftcode\" : \"swiftcode\",\n  \"name\" : \"name\",\n  \"ad_client_id\" : 0,\n  \"updated\" : \"updated\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default BankApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Recupera un banco en particular", description = "Recupera la informacion de un banco en particular", security = {
        @SecurityRequirement(name = "jwtAuth")    }, tags={ "bank" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Bank.class))) })
    @RequestMapping(value = "/v1.0/banks/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Bank> retrieveBank(@Parameter(in = ParameterIn.PATH, description = "ID del banco", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\n  \"isownbank\" : true,\n  \"updatedby\" : 2,\n  \"routingno\" : \"routingno\",\n  \"ad_org_id\" : 6,\n  \"created\" : \"created\",\n  \"isactive\" : true,\n  \"referencedvalues\" : [ null, null ],\n  \"description\" : \"description\",\n  \"c_location_id\" : 5,\n  \"c_bank_id\" : 1,\n  \"ad_componentobjectuid\" : \"ad_componentobjectuid\",\n  \"createdby\" : 5,\n  \"additionalvalues\" : [ {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  } ],\n  \"swiftcode\" : \"swiftcode\",\n  \"name\" : \"name\",\n  \"ad_client_id\" : 0,\n  \"updated\" : \"updated\"\n}", Bank.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default BankApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Actualiza un banco existente", description = "", security = {
        @SecurityRequirement(name = "jwtAuth")    }, tags={ "bank" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "409", description = "Imposible actualizar", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))) })
    @RequestMapping(value = "/v1.0/banks/{id}",
        produces = { "text/plain" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    default ResponseEntity<String> updateBank(@Parameter(in = ParameterIn.PATH, description = "ID del banco a actualizar", required=true, schema=@Schema()) @PathVariable("id") Integer id, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Bank body) {
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
            log.warn("ObjectMapper or HttpServletRequest not configured in default BankApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}

