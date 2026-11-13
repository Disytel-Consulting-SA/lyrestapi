package org.libertya.api.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.libertya.api.stub.model.AccountStatementLine;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Serializacion estable de GET /v1.0/bpartners/{id}/accountstatement.
 *
 * Un consumidor puede calcular un hash sobre la respuesta para detectar si cambio la cuenta de un cliente, asi que sin
 * cambios en la base la respuesta tiene que ser identica byte a byte, tambien despues de reiniciar la API
 * (plan-estado-de-cuenta.md §5.2).
 *
 * Los DTO generados por swagger-codegen no lo garantizan: un campo como cBpartnerId tiene el getter getCBpartnerId(),
 * del que Jackson deriva otra propiedad (cbpartnerId) que no coincide con el campo, y la serializa ademas de
 * c_bpartner_id. El orden de esas propiedades sale de la reflexion sobre los metodos y cambia de un arranque de la
 * JVM a otro. Pasa en toda la API; aca importa porque se calcula un hash sobre la respuesta.
 *
 * El stub no se edita a mano, asi que se corrige con un mixin solo para AccountStatementLine: se ignoran los getters
 * (los campos con @JsonProperty se serializan igual) y el orden queda fijo, el del contrato. Si se agrega un campo al
 * esquema, agregarlo tambien aca; uno que falte en la lista sale al final.
 */
@Configuration
public class AccountStatementJsonConfig {

    @JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
                    isGetterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonPropertyOrder({"rowtype", "doc_id", "c_invoicepayschedule_id", "installmentno", "installmentcount",
            "c_bpartner_id", "ad_org_id", "issotrx", "c_doctype_id", "doctypekey", "docbasetype", "doctypename",
            "doctypeprintname", "documentno", "puntodeventa", "numerocomprobante", "letra", "dateinvoiced", "dateacct",
            "duedate", "c_currency_id", "iso_code", "signo", "grandtotal", "dueamt", "paidamt", "openamt", "salesrep_id",
            "c_paymentterm_id", "paymentrule", "c_order_id"})
    interface AccountStatementLineMixin {
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer accountStatementLineMixin() {
        return builder -> builder.mixIn(AccountStatementLine.class, AccountStatementLineMixin.class);
    }
}
