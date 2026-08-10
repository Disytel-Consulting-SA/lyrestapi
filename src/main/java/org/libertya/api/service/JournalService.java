package org.libertya.api.service;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.QueryParams;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.repository.AbstractRepository;
import org.libertya.api.repository.JournalLineRepository;
import org.libertya.api.repository.JournalRepository;
import org.libertya.api.stub.model.Journal;
import org.libertya.api.stub.model.JournalDocument;
import org.libertya.api.stub.model.JournalLine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Asientos contables manuales (GL_Journal + GL_JournalLine).
 *
 * Ver docs/plan-asientos-manuales.md para el diseño completo y docs/asientos-manuales-api.md para el
 * contrato de uso de los endpoints.
 */
@Service
@RequiredArgsConstructor
public class JournalService extends AbstractService {

    /**
     * Limite explicito al recuperar las lineas de un asiento.  Es imprescindible: si el limite queda en null,
     * retrieveAll aplica DEFAULT_LIMIT (100) y truncaria el asiento en silencio.  Un cierre mensual de costos
     * puede superar las 100 lineas sin esfuerzo.
     */
    private static final int MAX_LINES = 100000;

    /**
     * Validar Debe = Haber antes de insertar? Valor global, redefinible por request.
     *
     * OJO CON EL DEFAULT EN LINEA (":N"): NO es redundante con application.properties.  Los despliegues
     * arrancan con --spring.config.location=file:/ruta/application.properties, que REEMPLAZA al archivo
     * empaquetado en el jar en lugar de complementarlo.  O sea que el application.properties del jar no se
     * lee, y una propiedad sin default hace que la aplicacion no levante contra cualquier config anterior a
     * su incorporacion.  Toda propiedad nueva que tenga un valor por defecto razonable debe declararlo aca.
     */
    @Value("${org.libertya.api.service.journal.validate-balance:N}")
    private String validateBalance;

    private final JournalRepository journalRepository;

    private final JournalLineRepository journalLineRepository;

    @Override
    protected AbstractRepository getRepository() {
        return journalRepository;
    }

    /**
     * Alta de asiento con control por request del completado y de la validacion de balanceo.
     *
     * @param complete true/false para forzar el completado, o null para usar el valor global
     * @param validateBalanceParam true/false para forzar la validacion de balanceo, o null para el valor global
     */
    public String create(UserInfo info, JournalDocument document, Boolean complete, Boolean validateBalanceParam) throws ModelException, AuthException {
        if (shouldValidateBalance(validateBalanceParam)) {
            validateBalance(document);
        }
        return create(info, document, complete);
    }

    @Override
    protected Optional<JournalDocument> performRetrieve(UserInfo info, int id) throws ModelException, AuthException {
        JournalDocument doc = new JournalDocument();

        // Cabecera
        Optional<Journal> journal = journalRepository.retrieve(info, id);
        if (!journal.isPresent())
            return Optional.empty();
        doc.setHeader(journal.get());

        // Lineas: con limite explicito y ordenadas por numero de linea
        QueryParams params = new QueryParams();
        params.setFilter("gl_journal_id="+id);
        params.setSort("line");
        params.setLimit(MAX_LINES);
        for (Object item : journalLineRepository.retrieveAll(info, params)) {
            doc.addLinesItem(((Optional<JournalLine>)item).get());
        }

        return Optional.of(doc);
    }

    @Override
    protected String performCreate(UserInfo info, Object document, String trxName) throws Exception {
        JournalDocument journalDocument = (JournalDocument)document;
        Journal header = journalDocument.getHeader();

        // Cabecera
        Integer id = Integer.parseInt(journalRepository.insert(info, header, trxName));

        // Lineas.  Se insertan bajo la misma trx que la cabecera, y es imprescindible que asi sea:
        // MJournalLine.beforeSave recarga el asiento desde la base para resolver el esquema contable y la
        // fecha, con lo cual la cabecera tiene que ser visible dentro de esa transaccion.
        for (JournalLine line : getList(journalDocument.getLines())) {
            line.setGlJournalId(id);
            // Organizacion y fecha contable se heredan de la cabecera si la linea no las trae
            if (line.getAdOrgId()==null && header!=null)
                line.setAdOrgId(header.getAdOrgId());
            if (line.getDateacct()==null && header!=null)
                line.setDateacct(header.getDateacct());
            journalLineRepository.insert(info, line, trxName);
        }

        return Integer.toString(id);
    }

    /** Debe validarse el balanceo? El parametro del request tiene precedencia sobre la propiedad global */
    protected boolean shouldValidateBalance(Boolean param) {
        return param!=null ? param : "Y".equalsIgnoreCase(validateBalance);
    }

    /**
     * Verifica que la suma del Debe iguale a la suma del Haber, antes de insertar nada.
     *
     * No se delega en el core a proposito: con el suspense balancing habilitado (que es lo habitual)
     * MJournal.prepareIt NO rechaza un asiento descuadrado, sino que completa la diferencia contra la cuenta
     * puente de comprobacion del esquema contable.  O sea que un error de calculo del consumidor no se
     * manifestaria como un 409 sino como un descuadre silencioso escondido en la contabilidad.
     */
    protected void validateBalance(JournalDocument document) throws ModelException {
        BigDecimal totalDr = BigDecimal.ZERO;
        BigDecimal totalCr = BigDecimal.ZERO;
        for (JournalLine line : getList(document.getLines())) {
            if (line.getAmtsourcedr()!=null)
                totalDr = totalDr.add(line.getAmtsourcedr());
            if (line.getAmtsourcecr()!=null)
                totalCr = totalCr.add(line.getAmtsourcecr());
        }
        if (totalDr.compareTo(totalCr) != 0) {
            throw new ModelException(String.format(
                    "Asiento descuadrado: el total del Debe (%s) no coincide con el total del Haber (%s). " +
                    "Diferencia: %s", totalDr.toPlainString(), totalCr.toPlainString(),
                    totalDr.subtract(totalCr).toPlainString()));
        }
    }
}
