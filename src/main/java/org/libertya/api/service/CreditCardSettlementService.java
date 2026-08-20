package org.libertya.api.service;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.repository.AbstractRepository;
import org.libertya.api.repository.CreditCardCouponFilterRepository;
import org.libertya.api.repository.CreditCardSettlementRepository;
import org.libertya.api.stub.model.CreditCardCouponFilter;
import org.libertya.api.stub.model.CreditCardSettlement;
import org.libertya.api.stub.model.CreditCardSettlementChild;
import org.libertya.api.stub.model.CreditCardSettlementCreated;
import org.libertya.api.stub.model.CreditCardSettlementDocument;
import org.openXpertya.util.DB;
import org.openXpertya.util.Trx;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Liquidaciones de tarjetas de credito (C_CreditCardSettlement).
 *
 * Lo unico que agrega sobre el CRUD generico es componer la cabecera con su filtro por defecto en una sola
 * transaccion, que es lo que hace util al endpoint /full: un cupon no se puede insertar sin filtro
 * (C_CouponsSettlements.c_creditcardcouponfilter_id es NOT NULL), asi que una cabecera sin filtro es un
 * estado invalido que no le sirve a nadie.
 */
@Service
@RequiredArgsConstructor
public class CreditCardSettlementService extends AbstractService {

    /** Tablas hijas que el modelo puebla solo, en generateAllChildrens(), al guardar una cabecera nueva */
    private static final List<String> CHILD_TABLES = Arrays.asList(
            "C_CommissionConcepts",
            "C_ExpenseConcepts",
            "C_IVASettlements",
            "C_PerceptionsSettlement",
            "C_WithholdingSettlement");

    private final CreditCardSettlementRepository settlementRepository;

    private final CreditCardCouponFilterRepository filterRepository;

    /**
     * Crea la cabecera y su filtro por defecto, todo o nada.
     *
     * NO pasa por AbstractService.create() a proposito, por dos motivos:
     *  1. create() devuelve un String con el id de la cabecera, y aca hay que devolver tambien el id del
     *     filtro y las filas hijas que genero el modelo;
     *  2. create() completa el documento si org.libertya.api.service.doc.complete=Y, y esta liquidacion
     *     tiene que quedar en borrador SIEMPRE. Completar genera un C_Payment por el neto y exige que la
     *     liquidacion cuadre; ninguna de las dos cosas puede decidirlas una integracion.
     */
    public CreditCardSettlementCreated createFull(UserInfo info, CreditCardSettlementDocument document) throws ModelException, AuthException {
        if (document == null || document.getHeader() == null)
            throw new ModelException("Falta la cabecera de la liquidacion");

        String trxName = Trx.createTrx(Trx.createTrxName()).getTrxName();
        try {
            CreditCardSettlement header = document.getHeader();

            // Se busca el duplicado antes de insertar para poder devolver el id del que ya existe. El modelo
            // aplica la misma regla (R2) pero su mensaje de error no trae el id, y ese id es justo lo que
            // necesita un conciliador para resolver sin salir a buscarlo con otra llamada.
            Integer existing = settlementRepository.findDuplicate(info, header.getCBpartnerId(), header.getSettlementno(), header.getPaymentdate(), trxName);
            if (existing != null)
                throw new ModelException("Ya existe una liquidacion con esa entidad comercial, numero y fecha de pago. " +
                        "C_CreditCardSettlement_ID=" + existing);

            int settlementID = Integer.parseInt(settlementRepository.insert(info, header, trxName));
            int filterID = Integer.parseInt(filterRepository.insert(info, buildFilter(document, header, settlementID), trxName));

            CreditCardSettlementCreated retVal = new CreditCardSettlementCreated();
            retVal.setCCreditcardsettlementId(settlementID);
            retVal.setCCreditcardcouponfilterId(filterID);
            retVal.setChildren(retrieveChildren(settlementID, trxName));

            Trx.getTrx(trxName).commit();
            return retVal;
        } catch (ModelException | AuthException e) {
            Trx.getTrx(trxName).rollback();
            throw e;
        } catch (Exception e) {
            Trx.getTrx(trxName).rollback();
            throw new ModelException("Error creando la liquidacion: " + e.getMessage());
        } finally {
            Trx.getTrx(trxName).close();
        }
    }

    /**
     * Arma el filtro a insertar. Si el cliente no mando ninguno se crea uno heredando de la cabecera los
     * datos que el filtro necesita para tener sentido.
     *
     * m_numerocomercio_id no se fuerza: el modelo lo copia de la cabecera en su propio beforeSave. Se hereda
     * igual por si esa copia no corriera (por ejemplo sobre una instalacion sin esa columna, donde el campo
     * se ignora en silencio).
     */
    protected CreditCardCouponFilter buildFilter(CreditCardSettlementDocument document, CreditCardSettlement header, int settlementID) {
        CreditCardCouponFilter filter = document.getFilter() != null ? document.getFilter() : new CreditCardCouponFilter();
        filter.setCCreditcardsettlementId(settlementID);
        if (filter.getAdOrgId() == null)
            filter.setAdOrgId(header.getAdOrgId());
        if (filter.getCCurrencyId() == null)
            filter.setCCurrencyId(header.getCCurrencyId());
        if (filter.getCBpartnerId() == null)
            filter.setCBpartnerId(header.getCBpartnerId());
        if (filter.getMNumerocomercioId() == null)
            filter.setMNumerocomercioId(header.getMNumerocomercioId());
        return filter;
    }

    /** Filas que el modelo genero por si solo al guardar la cabecera (generateAllChildrens) */
    protected List<CreditCardSettlementChild> retrieveChildren(int settlementID, String trxName) throws ModelException {
        List<CreditCardSettlementChild> children = new ArrayList<>();
        for (String childTable : CHILD_TABLES) {
            String sql = " SELECT " + childTable + "_ID FROM " + childTable +
                         " WHERE c_creditcardsettlement_id = ? ORDER BY 1 ";
            try (PreparedStatement pstmt = DB.prepareStatement(sql, trxName)) {
                pstmt.setInt(1, settlementID);
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        CreditCardSettlementChild child = new CreditCardSettlementChild();
                        child.setTablename(childTable);
                        child.setRecordId(rs.getInt(1));
                        children.add(child);
                    }
                }
            } catch (Exception e) {
                throw new ModelException("Error recuperando las filas hijas de la liquidacion. " + e.getMessage());
            }
        }
        return children;
    }

    // === Contrato de AbstractService ===

    @Override
    protected String performCreate(UserInfo info, Object document, String trxName) throws Exception {
        CreditCardSettlementDocument doc = (CreditCardSettlementDocument) document;
        int settlementID = Integer.parseInt(settlementRepository.insert(info, doc.getHeader(), trxName));
        filterRepository.insert(info, buildFilter(doc, doc.getHeader(), settlementID), trxName);
        return String.valueOf(settlementID);
    }

    @Override
    protected <T> Optional<T> performRetrieve(UserInfo info, int id) throws ModelException, AuthException {
        return settlementRepository.retrieve(info, id);
    }

    @Override
    protected AbstractRepository getRepository() {
        return settlementRepository;
    }

    /** Una liquidacion creada por esta API nunca se completa. Ver el comentario de createFull. */
    @Override
    protected boolean shouldComplete() {
        return false;
    }
}
