package org.libertya.api.repository;

import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;
import org.libertya.api.stub.model.CreditCardCouponFilter;
import org.openXpertya.model.X_C_CreditCardCouponFilter;
import org.openXpertya.util.DB;
import org.springframework.stereotype.Repository;

@Repository
public class CreditCardCouponFilterRepository extends AbstractRepository {

    public CreditCardCouponFilterRepository() {
        tableName = X_C_CreditCardCouponFilter.Table_Name;
        iface = CreditCardCouponFilter::new;
    }

    /**
     * Elimina un filtro, pero solo si no tiene cupones colgados.
     *
     * LA GUARDA NO ES DEFENSIVA DE MAS, corrige un agujero real. La foreign key
     * c_couponssettlements.fkcreditcardcouponfilter es ON DELETE CASCADE, con lo cual borrar el filtro se
     * lleva puestos todos sus cupones directamente desde la base, sin pasar por el modelo. Eso saltea la
     * regla R8 (un cupon conciliado no se puede borrar), que solo se aplica cuando la baja pasa por el PO.
     * Verificado contra la base: un cupon con isreconciled='Y' desaparece sin ruido al borrar su filtro.
     *
     * La liquidacion no necesita esta guarda: su foreign key desde los cupones NO es cascade, asi que la
     * base ya rechaza el borrado por si sola.
     */
    @Override
    public void delete(UserInfo info, int id) throws ModelException, NotFoundException, AuthException {
        int coupons = countCoupons(id);
        if (coupons > 0)
            throw new ModelException(String.format(
                    "El filtro tiene %d cupones colgados. Borrarlo los eliminaria en cascada sin pasar por " +
                    "las validaciones del modelo. Hay que borrar antes los cupones, uno por uno, con " +
                    "DELETE /v1.0/couponssettlements/{id}.", coupons));
        super.delete(info, id);
    }

    /** Cantidad de cupones colgados de un filtro */
    public int countCoupons(int filterID) throws ModelException {
        try {
            return DB.getSQLValue(null,
                    "SELECT count(1) FROM C_CouponsSettlements WHERE c_creditcardcouponfilter_id = ?", filterID);
        } catch (Exception e) {
            throw new ModelException("Error verificando los cupones del filtro. " + e.getMessage());
        }
    }
}
