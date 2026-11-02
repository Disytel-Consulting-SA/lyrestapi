package org.libertya.api.service;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.repository.AbstractRepository;
import org.libertya.api.repository.CouponsSettlementsRepository;
import org.libertya.api.stub.model.CouponsSettlements;
import org.libertya.api.stub.model.CouponsSettlementsBulk;
import org.libertya.api.stub.model.CouponsSettlementsBulkResult;
import org.libertya.api.stub.model.CouponsSettlementsExists;
import org.libertya.api.stub.model.CouponsSettlementsExistsItem;
import org.libertya.api.stub.model.CouponsSettlementsExistsResult;
import org.libertya.api.stub.model.CouponsSettlementsItemResult;
import org.openXpertya.util.Trx;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Cupones de liquidacion (C_CouponsSettlements): la fila que vincula un cobro con una liquidacion.
 *
 * Los dos endpoints que justifican esta clase son el lote de escritura (bulk) y el lote de consulta
 * (exists). Los dos existen por la misma razon: el consumidor natural de esta API procesa cientos de miles
 * de cobros por corrida, y resolverlos de a uno es la diferencia entre una corrida de minutos y una de
 * horas.
 */
@Service
@RequiredArgsConstructor
public class CouponsSettlementsService extends AbstractService {

    /** Estados posibles de un cupon dentro de un lote */
    public static final String ESTADO_CREADO = "creado";
    public static final String ESTADO_YA_EXISTIA = "ya_existia";
    public static final String ESTADO_CONFLICTO = "conflicto";
    public static final String ESTADO_ERROR = "error";

    /**
     * Fragmentos de los mensajes con los que el modelo rechaza un cupon. Se comparan contra el texto porque
     * el core no expone codigos de error: MCouponsSettlements.beforeSave devuelve false y deja el motivo en
     * el log, que AbstractRepository recupera como texto plano.
     */
    private static final String MSG_R7 = "ya fue cargado en otra liquidacion";
    private static final String MSG_R6_CONCILIADO = "marcar como Conciliado sin el Medio de Pago";
    private static final String MSG_R6_INCLUIDO = "marcar como Incluido sin el Medio de Pago";

    private final CouponsSettlementsRepository repository;

    /**
     * Tope de cupones por lote. Doscientos cubre el percentil 99 de las liquidaciones reales en una sola
     * llamada; el maximo historico (unos 3.500 cupones) se parte en 18 lotes.
     *
     * El default va en linea a proposito: los despliegues arrancan el jar con --spring.config.location
     * apuntando a un application.properties externo que reemplaza al del jar, con lo cual una propiedad
     * nueva sin default rompe todos los entornos ya desplegados.
     */
    @Value("${org.libertya.api.service.couponssettlements.bulk-max-size:200}")
    private Integer bulkMaxSize;

    /** Tope de cobros por consulta de existencia. Mismo criterio de default en linea que bulkMaxSize. */
    @Value("${org.libertya.api.service.couponssettlements.exists-max-size:1000}")
    private Integer existsMaxSize;

    /**
     * Consulta en lote que cobros ya estan colgados de alguna liquidacion.
     */
    public CouponsSettlementsExistsResult exists(UserInfo info, CouponsSettlementsExists body) throws ModelException {
        if (body == null || body.getCPaymentIds() == null || body.getCPaymentIds().isEmpty())
            throw new ModelException("Hay que enviar al menos un c_payment_id");

        // Se deduplica preservando el orden: el consumidor puede mandar repetidos sin querer, y una lista de
        // 1000 con 900 repetidos no tiene por que contar como 1000 contra el tope.
        Set<Integer> paymentIDs = new LinkedHashSet<>(body.getCPaymentIds());
        if (paymentIDs.size() > existsMaxSize)
            throw new ModelException(String.format(
                    "El lote tiene %d cobros distintos y el maximo es %d. Partirlo en lotes mas chicos.",
                    paymentIDs.size(), existsMaxSize));

        CouponsSettlementsExistsResult retVal = new CouponsSettlementsExistsResult();
        retVal.setEncontrados(repository.findByPaymentIDs(info, paymentIDs));
        return retVal;
    }

    /**
     * Cuelga N cupones de una misma liquidacion, con una transaccion por cupon.
     *
     * NO HAY ROLLBACK DEL LOTE, y es la decision central de este metodo. Las colisiones de R7 son
     * esperables y no excepcionales, porque los procesos de importacion del ERP siguen activos y escribiendo
     * sobre las mismas tablas. Si el lote fuera atomico, un solo cupon en conflicto tiraria abajo los otros
     * 699 que estaban bien, y el reintento tendria que ser de la liquidacion entera.
     *
     * Por eso tampoco se usa AbstractService.create(): ese metodo abre UNA transaccion para todo el
     * documento, que es exactamente lo contrario de lo que hace falta aca.
     */
    public CouponsSettlementsBulkResult bulk(UserInfo info, CouponsSettlementsBulk body) throws ModelException, AuthException {
        if (body == null || body.getCoupons() == null || body.getCoupons().isEmpty())
            throw new ModelException("Hay que enviar al menos un cupon");
        if (body.getCCreditcardsettlementId() == null)
            throw new ModelException("Hay que enviar el c_creditcardsettlement_id del lote");
        if (body.getCoupons().size() > bulkMaxSize)
            throw new ModelException(String.format(
                    "El lote tiene %d cupones y el maximo es %d. Partirlo en lotes mas chicos.",
                    body.getCoupons().size(), bulkMaxSize));

        int settlementID = body.getCCreditcardsettlementId();

        // Una sola consulta para todo el lote resuelve de antemano los dos casos que no son una insercion:
        // el cobro ya esta en ESTA liquidacion (ya_existia) o esta en OTRA (conflicto por R7).
        Map<Integer, CouponsSettlementsExistsItem> yaColgados = new HashMap<>();
        for (CouponsSettlementsExistsItem item : repository.findByPaymentIDs(info, collectPaymentIDs(body)))
            yaColgados.put(item.getCPaymentId(), item);

        List<CouponsSettlementsItemResult> resultados = new ArrayList<>();
        for (CouponsSettlements coupon : body.getCoupons())
            resultados.add(processCoupon(info, body, settlementID, coupon, yaColgados));

        return buildResult(settlementID, resultados);
    }

    /** Resuelve un cupon del lote: ya estaba, esta en otra liquidacion, o hay que insertarlo */
    protected CouponsSettlementsItemResult processCoupon(UserInfo info, CouponsSettlementsBulk body, int settlementID,
                                                         CouponsSettlements coupon, Map<Integer, CouponsSettlementsExistsItem> yaColgados) {
        CouponsSettlementsItemResult result = new CouponsSettlementsItemResult();
        result.setCPaymentId(coupon.getCPaymentId());

        CouponsSettlementsExistsItem existing = coupon.getCPaymentId() != null ? yaColgados.get(coupon.getCPaymentId()) : null;
        if (existing != null) {
            result.setCCouponssettlementsId(existing.getCCouponssettlementsId());
            if (existing.getCCreditcardsettlementId() != null && existing.getCCreditcardsettlementId() == settlementID) {
                result.setEstado(ESTADO_YA_EXISTIA);
                result.setMotivo("El cobro ya estaba colgado de esta misma liquidacion");
            } else {
                result.setEstado(ESTADO_CONFLICTO);
                result.setMotivo("R7: el cobro ya esta cargado en otra liquidacion");
                result.setCCreditcardsettlementIdEnConflicto(existing.getCCreditcardsettlementId());
            }
            return result;
        }

        return insertCoupon(info, body, settlementID, coupon, result);
    }

    /** Inserta un cupon en su propia transaccion y clasifica el resultado */
    protected CouponsSettlementsItemResult insertCoupon(UserInfo info, CouponsSettlementsBulk body, int settlementID,
                                                        CouponsSettlements coupon, CouponsSettlementsItemResult result) {
        applyBatchDefaults(body, settlementID, coupon);

        String trxName = Trx.createTrx(Trx.createTrxName()).getTrxName();
        try {
            result.setCCouponssettlementsId(Integer.parseInt(repository.insert(info, coupon, trxName)));
            result.setEstado(ESTADO_CREADO);
            Trx.getTrx(trxName).commit();
        } catch (Exception e) {
            Trx.getTrx(trxName).rollback();
            classifyFailure(info, coupon, result, e);
        } finally {
            Trx.getTrx(trxName).close();
        }
        return result;
    }

    /**
     * Traduce el rechazo del modelo a un estado del lote.
     *
     * Un fallo por R7 aca (y no en la consulta previa) significa que el cupon aparecio entre medio, o que la
     * fila que lo bloquea quedo fuera del filtro por compania de la consulta. En ese caso se vuelve a
     * preguntar por ese unico cobro para poder devolver el id en conflicto, que es lo que el consumidor
     * necesita.
     */
    protected void classifyFailure(UserInfo info, CouponsSettlements coupon, CouponsSettlementsItemResult result, Exception e) {
        String message = e.getMessage() != null ? e.getMessage() : "Error desconocido al insertar el cupon";

        if (message.contains(MSG_R7)) {
            result.setEstado(ESTADO_CONFLICTO);
            result.setMotivo("R7: el cobro ya esta cargado en otra liquidacion");
            resolveConflictingSettlement(info, coupon, result);
        } else if (message.contains(MSG_R6_CONCILIADO) || message.contains(MSG_R6_INCLUIDO)) {
            result.setEstado(ESTADO_CONFLICTO);
            result.setMotivo("R6: " + message);
        } else {
            result.setEstado(ESTADO_ERROR);
            result.setMotivo(message);
        }
    }

    /** Segunda consulta, solo para un cupon que fallo por R7, para poder informar contra que colisiono */
    protected void resolveConflictingSettlement(UserInfo info, CouponsSettlements coupon, CouponsSettlementsItemResult result) {
        if (coupon.getCPaymentId() == null)
            return;
        try {
            for (CouponsSettlementsExistsItem item : repository.findByPaymentIDs(info, java.util.Collections.singletonList(coupon.getCPaymentId()))) {
                result.setCCouponssettlementsId(item.getCCouponssettlementsId());
                result.setCCreditcardsettlementIdEnConflicto(item.getCCreditcardsettlementId());
            }
        } catch (ModelException ignored) {
            // El estado y el motivo ya estan puestos; no poder resolver el id no cambia el resultado del lote
        }
    }

    /** Completa en el cupon los datos que vienen una sola vez en la cabecera del lote */
    protected void applyBatchDefaults(CouponsSettlementsBulk body, int settlementID, CouponsSettlements coupon) {
        if (coupon.getCCreditcardsettlementId() == null)
            coupon.setCCreditcardsettlementId(settlementID);
        if (coupon.getCCreditcardcouponfilterId() == null)
            coupon.setCCreditcardcouponfilterId(body.getCCreditcardcouponfilterId());
    }

    /** Cobros distintos que menciona el lote */
    protected Set<Integer> collectPaymentIDs(CouponsSettlementsBulk body) {
        Set<Integer> paymentIDs = new LinkedHashSet<>();
        for (CouponsSettlements coupon : body.getCoupons())
            if (coupon.getCPaymentId() != null)
                paymentIDs.add(coupon.getCPaymentId());
        return paymentIDs;
    }

    /** Arma el resumen del lote a partir de los resultados individuales */
    protected CouponsSettlementsBulkResult buildResult(int settlementID, List<CouponsSettlementsItemResult> resultados) {
        int creados = 0, yaExistian = 0, conflictos = 0;
        for (CouponsSettlementsItemResult item : resultados) {
            if (ESTADO_CREADO.equals(item.getEstado()))
                creados++;
            else if (ESTADO_YA_EXISTIA.equals(item.getEstado()))
                yaExistian++;
            else
                conflictos++;
        }
        CouponsSettlementsBulkResult retVal = new CouponsSettlementsBulkResult();
        retVal.setCCreditcardsettlementId(settlementID);
        retVal.setCreados(creados);
        retVal.setYaExistian(yaExistian);
        retVal.setConflictos(conflictos);
        retVal.setResultados(resultados);
        return retVal;
    }

    // === Contrato de AbstractService ===

    @Override
    protected String performCreate(UserInfo info, Object document, String trxName) throws Exception {
        return repository.insert(info, document, trxName);
    }

    @Override
    protected <T> Optional<T> performRetrieve(UserInfo info, int id) throws ModelException, AuthException {
        return repository.retrieve(info, id);
    }

    @Override
    protected AbstractRepository getRepository() {
        return repository;
    }

    /** Un cupon no es un documento: no tiene DocAction ni estado que completar. */
    @Override
    protected boolean shouldComplete() {
        return false;
    }
}
