package org.libertya.api.repository;

import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.ModelException;
import org.libertya.api.stub.model.CouponsSettlements;
import org.libertya.api.stub.model.CouponsSettlementsExistsItem;
import org.openXpertya.model.X_C_CouponsSettlements;
import org.openXpertya.util.DB;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CouponsSettlementsRepository extends AbstractRepository {

    public CouponsSettlementsRepository() {
        tableName = X_C_CouponsSettlements.Table_Name;
        iface = CouponsSettlements::new;
    }

    /**
     * Resuelve de una sola consulta cuales de los cobros recibidos ya estan colgados de alguna liquidacion.
     *
     * Es la consulta que le da sentido a POST /couponssettlements/exists y la que usa el bulk para
     * distinguir "ya_existia" de "conflicto": ambos casos son un cobro ya cargado, y lo unico que los
     * separa es si la liquidacion que lo tiene es la que se esta procesando o es otra.
     *
     * OJO: no pasa por retrieveAll ni por el PO. Es a proposito. retrieveAll hace una consulta de claves y
     * despues una carga completa del PO por cada fila, con lo cual resolver N cobros costaria N+1 consultas
     * y el limite por defecto de 100 truncaria el resultado en silencio.
     *
     * NO SE FILTRA POR isactive, y eso es deliberado: la consulta con la que el core aplica R7 es
     *   SELECT C_CouponsSettlements_ID FROM C_CouponsSettlements
     *    WHERE C_Payment_ID = ? AND C_CouponsSettlements_ID <> ?
     * o sea que un cupon desactivado igual bloquea a su cobro. Si aca filtraramos por isactive='Y' esta
     * consulta diria "libre" para un cobro que el modelo despues va a rechazar. Se devuelve isactive en cada
     * item para que el consumidor pueda distinguir los dos casos.
     *
     * La unica diferencia que queda con el core es el filtro por compania, que aca SI se aplica porque es la
     * frontera de seguridad de esta API. Una colision entre companias distintas se veria como un rechazo del
     * modelo al insertar, no en esta consulta.
     *
     * @param paymentIDs cobros a consultar
     * @return un item por cada cobro que YA este colgado. Los que no aparecen estan libres.
     */
    public List<CouponsSettlementsExistsItem> findByPaymentIDs(UserInfo info, Collection<Integer> paymentIDs, String trxName) throws ModelException {
        List<CouponsSettlementsExistsItem> retVal = new ArrayList<>();
        if (paymentIDs == null || paymentIDs.isEmpty())
            return retVal;

        // Los ids son Integer ya parseados por Jackson, no texto del request: no hay lugar para inyeccion.
        String inClause = paymentIDs.stream().map(String::valueOf).collect(Collectors.joining(","));
        String sql = " SELECT c_payment_id, c_couponssettlements_id, c_creditcardsettlement_id, " +
                     "        c_creditcardcouponfilter_id, isactive, isreconciled, include " +
                     " FROM " + tableName +
                     " WHERE c_payment_id IN (" + inClause + ") " +
                     "   AND " + filterByClient(info);

        try (PreparedStatement pstmt = DB.prepareStatement(sql, trxName);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                CouponsSettlementsExistsItem item = new CouponsSettlementsExistsItem();
                item.setCPaymentId(rs.getInt(1));
                item.setCCouponssettlementsId(rs.getInt(2));
                item.setCCreditcardsettlementId(rs.getInt(3));
                item.setCCreditcardcouponfilterId(rs.getInt(4));
                item.setIsactive("Y".equalsIgnoreCase(rs.getString(5)));
                item.setIsreconciled("Y".equalsIgnoreCase(rs.getString(6)));
                item.setInclude("Y".equalsIgnoreCase(rs.getString(7)));
                retVal.add(item);
            }
        } catch (SQLException e) {
            throw new ModelException("Error al consultar cupones por cobro. " + e.getMessage());
        }
        return retVal;
    }

    /** Idem findByPaymentIDs fuera de toda transaccion */
    public List<CouponsSettlementsExistsItem> findByPaymentIDs(UserInfo info, Collection<Integer> paymentIDs) throws ModelException {
        return findByPaymentIDs(info, paymentIDs, null);
    }
}
