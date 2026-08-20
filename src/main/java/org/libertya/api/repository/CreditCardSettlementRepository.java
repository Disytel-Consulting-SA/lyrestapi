package org.libertya.api.repository;

import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.ModelException;
import org.libertya.api.stub.model.CreditCardSettlement;
import org.openXpertya.model.X_C_CreditCardSettlement;
import org.openXpertya.util.DB;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class CreditCardSettlementRepository extends AbstractRepository {

    public CreditCardSettlementRepository() {
        tableName = X_C_CreditCardSettlement.Table_Name;
        iface = CreditCardSettlement::new;
    }

    /**
     * Busca una liquidacion que colisione con la regla R2 del modelo: misma entidad comercial, mismo numero
     * de liquidacion y misma fecha de pago, comparada por dia y no por timestamp.
     *
     * El modelo ya aplica esta regla y rechaza el guardado, pero su mensaje de error no incluye el id de la
     * fila que ya existe, y ese id es justo lo que necesita un conciliador para resolver la colision sin
     * salir a buscarlo con otra llamada.
     *
     * @return el id de la liquidacion existente, o null si no hay ninguna
     */
    public Integer findDuplicate(UserInfo info, Integer bpartnerID, String settlementNo, String paymentDate, String trxName) throws ModelException {
        if (bpartnerID == null || settlementNo == null || paymentDate == null)
            return null;

        String sql = " SELECT c_creditcardsettlement_id FROM " + tableName +
                     " WHERE c_bpartner_id = ? AND settlementno = ? AND paymentdate::date = ?::date " +
                     "   AND isactive = 'Y' AND " + filterByClient(info);
        try (PreparedStatement pstmt = DB.prepareStatement(sql, trxName)) {
            pstmt.setInt(1, bpartnerID);
            pstmt.setString(2, settlementNo);
            pstmt.setString(3, paymentDate);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() ? rs.getInt(1) : null;
            }
        } catch (Exception e) {
            throw new ModelException("Error verificando duplicados de liquidacion. " + e.getMessage());
        }
    }
}
