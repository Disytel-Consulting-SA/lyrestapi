/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.46).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package org.libertya.api.stub.iface;

import org.libertya.api.stub.model.PriceListVersion;
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
public interface PricelistversionApi {

    Logger log = LoggerFactory.getLogger(PricelistversionApi.class);

    default Optional<ObjectMapper> getObjectMapper(){
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest(){
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @Operation(summary = "Nueva version de lista de precio", description = "Agrega una nueva version de lista de precio", security = {
        @SecurityRequirement(name = "jwtAuth")    }, tags={ "pricelistversion" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK. ID de version de precio es creada es retornada", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "409", description = "Imposible insertar", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))) })
    @RequestMapping(value = "/v1.0/pricelistversions",
        produces = { "text/plain" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    default ResponseEntity<String> addPriceListVersion(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody PriceListVersion body) {
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
            log.warn("ObjectMapper or HttpServletRequest not configured in default PricelistversionApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Elimina una version de lista de precio", description = "Elimina una version de lista de precio existente", security = {
        @SecurityRequirement(name = "jwtAuth")    }, tags={ "pricelistversion" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "409", description = "Imposible eliminar", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "204", description = "OK", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))) })
    @RequestMapping(value = "/v1.0/pricelistversions/{id}",
        produces = { "text/plain" }, 
        method = RequestMethod.DELETE)
    default ResponseEntity<String> deletePriceListVersion(@Parameter(in = ParameterIn.PATH, description = "ID de version de lista de precio", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
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
            log.warn("ObjectMapper or HttpServletRequest not configured in default PricelistversionApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Retorna la lista de versiones de lista de precio", description = "Retorna la lista completa de versiones de lista de precio", security = {
        @SecurityRequirement(name = "jwtAuth")    }, tags={ "pricelistversion" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PriceListVersion.class)))) })
    @RequestMapping(value = "/v1.0/pricelistversions",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<PriceListVersion>> getAllPriceListVersions(@Parameter(in = ParameterIn.QUERY, description = "Criterio de filtrado" ,schema=@Schema()) @Valid @RequestParam(value = "filter", required = false) String filter, @Parameter(in = ParameterIn.QUERY, description = "Campos a recuperar" ,schema=@Schema()) @Valid @RequestParam(value = "fields", required = false) String fields, @Parameter(in = ParameterIn.QUERY, description = "Criterio de ordenado" ,schema=@Schema()) @Valid @RequestParam(value = "sort", required = false) String sort, @Parameter(in = ParameterIn.QUERY, description = "Limite de elementos a retornar por pagina" ,schema=@Schema()) @Valid @RequestParam(value = "limit", required = false) Integer limit, @Parameter(in = ParameterIn.QUERY, description = "Numero de pagina" ,schema=@Schema()) @Valid @RequestParam(value = "page", required = false) Integer page) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {\n  \"ad_componentversion_id\" : 6,\n  \"updatedby\" : 3,\n  \"ad_org_id\" : 1,\n  \"created\" : \"created\",\n  \"m_discountschema_id\" : 5,\n  \"m_pricelist_id\" : 2,\n  \"isactive\" : true,\n  \"referencedvalues\" : [ null, null ],\n  \"description\" : \"description\",\n  \"m_pricelist_version_id\" : 9,\n  \"ad_componentobjectuid\" : \"ad_componentobjectuid\",\n  \"createdby\" : 5,\n  \"additionalvalues\" : [ {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  } ],\n  \"name\" : \"name\",\n  \"proccreate\" : \"proccreate\",\n  \"validfrom\" : \"validfrom\",\n  \"ad_client_id\" : 0,\n  \"m_pricelist_version_base_id\" : 7,\n  \"updated\" : \"updated\"\n}, {\n  \"ad_componentversion_id\" : 6,\n  \"updatedby\" : 3,\n  \"ad_org_id\" : 1,\n  \"created\" : \"created\",\n  \"m_discountschema_id\" : 5,\n  \"m_pricelist_id\" : 2,\n  \"isactive\" : true,\n  \"referencedvalues\" : [ null, null ],\n  \"description\" : \"description\",\n  \"m_pricelist_version_id\" : 9,\n  \"ad_componentobjectuid\" : \"ad_componentobjectuid\",\n  \"createdby\" : 5,\n  \"additionalvalues\" : [ {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  } ],\n  \"name\" : \"name\",\n  \"proccreate\" : \"proccreate\",\n  \"validfrom\" : \"validfrom\",\n  \"ad_client_id\" : 0,\n  \"m_pricelist_version_base_id\" : 7,\n  \"updated\" : \"updated\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default PricelistversionApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Recupera una version de lista de precio particular", description = "Recupera la version de lista de precio en particular", security = {
        @SecurityRequirement(name = "jwtAuth")    }, tags={ "pricelistversion" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PriceListVersion.class))) })
    @RequestMapping(value = "/v1.0/pricelistversions/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<PriceListVersion> retrievePriceListVersion(@Parameter(in = ParameterIn.PATH, description = "ID de la version de lista de precio", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\n  \"ad_componentversion_id\" : 6,\n  \"updatedby\" : 3,\n  \"ad_org_id\" : 1,\n  \"created\" : \"created\",\n  \"m_discountschema_id\" : 5,\n  \"m_pricelist_id\" : 2,\n  \"isactive\" : true,\n  \"referencedvalues\" : [ null, null ],\n  \"description\" : \"description\",\n  \"m_pricelist_version_id\" : 9,\n  \"ad_componentobjectuid\" : \"ad_componentobjectuid\",\n  \"createdby\" : 5,\n  \"additionalvalues\" : [ {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  } ],\n  \"name\" : \"name\",\n  \"proccreate\" : \"proccreate\",\n  \"validfrom\" : \"validfrom\",\n  \"ad_client_id\" : 0,\n  \"m_pricelist_version_base_id\" : 7,\n  \"updated\" : \"updated\"\n}", PriceListVersion.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default PricelistversionApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Actualiza por una version de lista de precio", description = "", security = {
        @SecurityRequirement(name = "jwtAuth")    }, tags={ "pricelistversion" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "409", description = "Imposible actualizar", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))) })
    @RequestMapping(value = "/v1.0/pricelistversions/{id}",
        produces = { "text/plain" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    default ResponseEntity<String> updatePriceListVersion(@Parameter(in = ParameterIn.PATH, description = "ID de la version de lista de precio a actualizar", required=true, schema=@Schema()) @PathVariable("id") Integer id, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody PriceListVersion body) {
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
            log.warn("ObjectMapper or HttpServletRequest not configured in default PricelistversionApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}

