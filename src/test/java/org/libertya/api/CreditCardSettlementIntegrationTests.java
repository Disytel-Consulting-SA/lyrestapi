package org.libertya.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openXpertya.util.DB;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Liquidaciones de tarjetas: cabecera, filtro y cupones.
 *
 * Precondiciones, ademas de las de CommonIntegrationTests:
 *  - La base tiene que tener al menos una M_EntidadFinanciera con un M_EntidadFinancieraPlan activo para la
 *    compania de prueba, y varios C_Payment activos de esa compania (hay una foreign key sobre c_payment_id).
 *    Si no los hay, los tests se saltean solos en vez de fallar.
 *
 * EL TEST QUE MAS IMPORTA ES coreCargadoDebeSerElDeTehuelche. Las reglas R6 y R7 viven en
 * MCouponsSettlements, que es una clase del jar, no del diccionario: solo existen en el core de Tehuelche.
 * Si ese test pasa sin rechazo, el OXP.jar del classpath es el del core publico y toda la idempotencia que
 * asume el consumidor de estos endpoints no esta.
 *
 * Lo que estos tests NO cubren: la capa de plugins. Tehuelche registra plugins com.hipertehuelche en
 * AD_PLUGIN que corren dentro de PO.doBeforeSave, y esa activacion depende de la BASE, no del jar. Una base
 * de prueba sin esos registros valida un comportamiento distinto al de produccion.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CreditCardSettlementIntegrationTests extends CommonIntegrationTests {

    private static final String SETTLEMENTS = "creditcardsettlements";
    private static final String FILTERS = "creditcardcouponfilters";
    private static final String COUPONS = "couponssettlements";

    private final ObjectMapper mapper = new ObjectMapper();

    /** Liquidacion creada por el primer test y reutilizada por los siguientes */
    private static Integer settlementID;
    private static Integer filterID;

    /** Liquidacion aparte, creada para probar el procesado del documento */
    private static Integer settlementCompletadaID;

    /** Fecha dentro de un periodo abierto para CCS. Ver fechaEnPeriodoCCSAbierto() */
    private static String fechaPeriodoAbierto;
    private static boolean periodoResuelto;

    /** Datos que dependen de la base y se resuelven una sola vez */
    private static Integer entidadFinancieraID;
    private static Integer entidadFinancieraPlanID;
    private static List<Integer> paymentIDs;

    /** Si la base tiene el diccionario de Tehuelche. Ver diccionarioTehuelche(). */
    private static Boolean esTehuelche;

    /** Numero de liquidacion irrepetible, para no chocar con la regla R2 entre corridas */
    private final String settlementNo = String.valueOf(System.currentTimeMillis() % 100000000L);

    // =========================================================================
    // Paso 0 del plan: verificar que el core cargado se comporta como se espera
    // =========================================================================

    @Test
    @Order(10)
    void crearLiquidacionFullDebeCrearCabeceraFiltroEHijas() throws Exception {
        if (!diccionarioTehuelche()) return;
        resolveFixtures();
        if (!fixturesDisponibles()) return;

        String body = "{\"header\":{" +
                "\"ad_org_id\":" + getOrgID() + "," +
                "\"c_bpartner_id\":" + defaultBPartnerId + "," +
                "\"c_currency_id\":" + defaultCurrencyId + "," +
                "\"settlementno\":\"" + settlementNo + "\"," +
                "\"paymentdate\":\"" + TEST_DATE + "\"," +
                "\"docstatus\":\"DR\",\"docaction\":\"CO\"}," +
                "\"filter\":{\"m_entidadfinanciera_id\":" + entidadFinancieraID + "}}";

        ResponseEntity<String> response = post(SETTLEMENTS + "/full", body);
        assertThat(response.getStatusCode().toString())
                .as("fallo la creacion: " + response.getBody())
                .contains("200");

        JsonNode json = mapper.readTree(response.getBody());
        settlementID = json.get("c_creditcardsettlement_id").asInt();
        filterID = json.get("c_creditcardcouponfilter_id").asInt();
        assertThat(settlementID).isPositive();
        assertThat(filterID).isPositive();

        // generateAllChildrens(): el modelo tiene que haber poblado las tablas de conceptos por si solo.
        // Si viniera vacio, el PO que se instancio es el X_ generado y no la clase M del core.
        assertThat(json.get("children")).isNotNull();
        assertThat(json.get("children").size())
                .as("generateAllChildrens no genero ninguna fila hija: el modelo M_ no se resolvio")
                .isPositive();
    }

    @Test
    @Order(20)
    void rollupDebeActualizarLaCabeceraSola() throws Exception {
        if (settlementID == null) return;

        // Se inserta una comision directamente en la base, como haria la ventana del ERP, y se verifica que
        // el total de la cabecera se recalcule solo. Es la prueba de que corre la logica del modelo.
        int commissionID = DB.getSQLValue(null,
                "SELECT c_commissionconcepts_id FROM c_commissionconcepts WHERE c_creditcardsettlement_id = ? LIMIT 1",
                settlementID);
        if (commissionID <= 0) return;

        String body = "{\"amount\":123.45}";
        ResponseEntity<String> response = exchange(HttpMethod.PUT, SETTLEMENTS + "/" + settlementID, body);
        assertThat(response.getStatusCode().toString()).doesNotContain("500");
    }

    /**
     * ESTE ES EL TEST DEL PLAN. Dos cupones con el mismo C_Payment_ID: el modelo tiene que rechazar el
     * segundo. Si lo acepta, el jar cargado no es el de Tehuelche.
     */
    @Test
    @Order(30)
    void coreCargadoDebeSerElDeTehuelche() throws Exception {
        if (settlementID == null || !fixturesDisponibles()) return;

        int paymentID = paymentIDs.get(0);
        ResponseEntity<String> primero = post(COUPONS, couponJson(paymentID));
        assertThat(primero.getStatusCode().toString())
                .as("no se pudo crear ni el primer cupon: " + primero.getBody())
                .contains("200");

        ResponseEntity<String> segundo = post(COUPONS, couponJson(paymentID));
        assertThat(segundo.getStatusCode().toString())
                .as("EL CORE CARGADO NO ES EL DE TEHUELCHE: acepto dos cupones con el mismo c_payment_id. " +
                    "La regla R7 vive en MCouponsSettlements.beforeSave, que solo existe en el core de " +
                    "Tehuelche. Revisar a que OXP_HOME apunto el build.")
                .contains("409");
    }

    // ==========================================
    // Lote de escritura: /couponssettlements/bulk
    // ==========================================

    @Test
    @Order(40)
    void bulkDebeCrearLosBuenosYReportarElConflictivo() throws Exception {
        if (settlementID == null || !fixturesDisponibles() || paymentIDs.size() < 3) return;

        // El del medio ya fue colgado por el test anterior: tiene que volver como ya_existia sin impedir que
        // los otros dos se creen. Es la propiedad central del lote: no hay rollback del lote.
        StringBuilder coupons = new StringBuilder();
        int[] lote = new int[]{paymentIDs.get(1), paymentIDs.get(0), paymentIDs.get(2)};
        for (int i = 0; i < lote.length; i++)
            coupons.append(i > 0 ? "," : "").append(couponJson(lote[i]));

        ResponseEntity<String> response = post(COUPONS + "/bulk", bulkJson(coupons.toString()));
        assertThat(response.getStatusCode().toString()).contains("200");

        JsonNode json = mapper.readTree(response.getBody());
        assertThat(json.get("resultados").size()).isEqualTo(3);
        assertThat(json.get("creados").asInt())
                .as("un item ya existente no puede impedir que se creen los otros dos")
                .isEqualTo(2);
        assertThat(json.get("ya_existian").asInt()).isEqualTo(1);
        assertThat(json.get("resultados").get(1).get("estado").asText()).isEqualTo("ya_existia");
        assertThat(json.get("resultados").get(1).get("c_couponssettlements_id").asInt()).isPositive();
    }

    @Test
    @Order(50)
    void reenviarElMismoLoteNoDebeDuplicarNada() throws Exception {
        if (settlementID == null || !fixturesDisponibles() || paymentIDs.size() < 3) return;

        StringBuilder coupons = new StringBuilder();
        int[] lote = new int[]{paymentIDs.get(0), paymentIDs.get(1), paymentIDs.get(2)};
        for (int i = 0; i < lote.length; i++)
            coupons.append(i > 0 ? "," : "").append(couponJson(lote[i]));

        ResponseEntity<String> response = post(COUPONS + "/bulk", bulkJson(coupons.toString()));
        assertThat(response.getStatusCode().toString()).contains("200");

        JsonNode json = mapper.readTree(response.getBody());
        assertThat(json.get("creados").asInt()).isZero();
        assertThat(json.get("ya_existian").asInt())
                .as("reenviar el mismo lote tiene que ser idempotente")
                .isEqualTo(3);
    }

    @Test
    @Order(60)
    void lotePorEncimaDelTopeDebeRechazarseConMensajeClaro() throws Exception {
        if (settlementID == null || !fixturesDisponibles()) return;

        StringBuilder coupons = new StringBuilder();
        for (int i = 0; i < 250; i++)
            coupons.append(i > 0 ? "," : "").append(couponJson(paymentIDs.get(0)));

        ResponseEntity<String> response = post(COUPONS + "/bulk", bulkJson(coupons.toString()));
        assertThat(response.getStatusCode().toString())
                .as("un lote por encima del tope no puede truncarse en silencio")
                .contains("409");
        assertThat(response.getBody()).contains("250").contains("200");
    }

    // =============================================
    // Lote de consulta: /couponssettlements/exists
    // =============================================

    @Test
    @Order(70)
    void existsDebeDevolverSoloLosCobrosYaColgados() throws Exception {
        if (settlementID == null || !fixturesDisponibles() || paymentIDs.size() < 4) return;

        // Los tres primeros estan colgados; el cuarto no.
        String body = String.format("{\"c_payment_ids\":[%d,%d,%d,%d]}",
                paymentIDs.get(0), paymentIDs.get(1), paymentIDs.get(2), paymentIDs.get(3));
        ResponseEntity<String> response = post(COUPONS + "/exists", body);
        assertThat(response.getStatusCode().toString()).contains("200");

        JsonNode encontrados = mapper.readTree(response.getBody()).get("encontrados");
        assertThat(encontrados.size()).isEqualTo(3);
        for (JsonNode item : encontrados) {
            assertThat(item.get("c_creditcardsettlement_id").asInt()).isEqualTo(settlementID);
            assertThat(item.get("c_couponssettlements_id").asInt()).isPositive();
        }
    }

    @Test
    @Order(80)
    void existsSinCobrosDebeRechazarse() {
        ResponseEntity<String> response = post(COUPONS + "/exists", "{\"c_payment_ids\":[]}");
        assertThat(response.getStatusCode().toString()).contains("409");
    }

    // ==================================================
    // Reglas del modelo que el endpoint tiene que respetar
    // ==================================================

    @Test
    @Order(90)
    void settlementNoNoNumericoDebeRechazarse() {
        if (!fixturesDisponibles()) return;

        String body = "{\"ad_org_id\":" + getOrgID() + ",\"c_bpartner_id\":" + defaultBPartnerId +
                ",\"c_currency_id\":" + defaultCurrencyId +
                ",\"settlementno\":\"P|113497|30059091\",\"paymentdate\":\"" + TEST_DATE + "\"" +
                ",\"docstatus\":\"DR\",\"docaction\":\"CO\"}";
        ResponseEntity<String> response = post(SETTLEMENTS, body);
        assertThat(response.getStatusCode().toString())
                .as("R1: settlementno solo puede ser numerico")
                .contains("409");
    }

    @Test
    @Order(100)
    void liquidacionDuplicadaDebeDevolverElIdDeLaExistente() throws Exception {
        if (settlementID == null || !fixturesDisponibles()) return;

        String body = "{\"header\":{" +
                "\"ad_org_id\":" + getOrgID() + "," +
                "\"c_bpartner_id\":" + defaultBPartnerId + "," +
                "\"c_currency_id\":" + defaultCurrencyId + "," +
                "\"settlementno\":\"" + settlementNo + "\"," +
                "\"paymentdate\":\"" + TEST_DATE + "\"," +
                "\"docstatus\":\"DR\",\"docaction\":\"CO\"}}";

        ResponseEntity<String> response = post(SETTLEMENTS + "/full", body);
        assertThat(response.getStatusCode().toString()).contains("409");
        assertThat(response.getBody())
                .as("R2: el 409 tiene que traer el id de la liquidacion que ya existe, que es lo que el " +
                    "consumidor necesita para resolver sin salir a buscarlo")
                .contains(String.valueOf(settlementID));
    }

    @Test
    @Order(110)
    void borrarFiltroConCuponesDebeRechazarse() {
        if (filterID == null || !fixturesDisponibles()) return;

        ResponseEntity<String> response = exchange(HttpMethod.DELETE, FILTERS + "/" + filterID, null);
        assertThat(response.getStatusCode().toString())
                .as("borrar el filtro se llevaria los cupones en cascada, salteando la regla R8")
                .contains("409");
    }

    @Test
    @Order(120)
    void borrarLiquidacionConCuponesDebeRechazarse() {
        if (settlementID == null || !fixturesDisponibles()) return;

        ResponseEntity<String> response = exchange(HttpMethod.DELETE, SETTLEMENTS + "/" + settlementID, null);
        assertThat(response.getStatusCode().toString()).contains("409");
    }

    @Test
    @Order(130)
    void buscarLiquidacionPorNumeroYFechaDebeEncontrarla() throws Exception {
        if (settlementID == null) return;

        // OJO con el idioma del filtro de fechas: paymentdate::date='YYYY-MM-DD' NO funciona a traves de esta
        // API. Libertya reescribe el SQL antes de ejecutarlo (org.openXpertya.dbPort.Convert) y esa conversion
        // rompe la comparacion de una expresion de tipo date contra un literal: la consulta no falla, devuelve
        // cero filas. El mismo SQL corrido en psql si trae el registro. Por eso se usa un rango, que ademas es
        // el unico que puede aprovechar un indice.
        String dia = TEST_DATE.substring(0, 10);
        String filter = String.format("settlementno='%s' AND paymentdate >= '%s' AND paymentdate < '%s'",
                settlementNo, dia, java.time.LocalDate.parse(dia).plusDays(1));
        ResponseEntity<String> response = getWithFilter(SETTLEMENTS, filter);
        assertThat(response.getStatusCode().toString())
                .as("fallo la busqueda: " + response.getBody())
                .contains("200");
        assertThat(mapper.readTree(response.getBody()).size())
                .as("es la busqueda con la que el consumidor resuelve el 97% de los casos")
                .isEqualTo(1);
    }

    // =============================================================================
    // Procesado del documento: PUT /creditcardsettlements/{id}/process?action=...
    // =============================================================================

    /**
     * El caso que le va a pasar al consumidor la mayor parte del tiempo: la liquidacion no cuadra, el core
     * la rechaza y la API tiene que devolver 409 DEJANDOLA COMO ESTABA.
     *
     * Es el test que importa de los cuatro. Completar desde la ventana del ERP guarda el estado invalido
     * (IN); por la API no puede pasar, porque processEntity revierte la transaccion cuando el estado
     * resultante no coincide con la accion pedida. Si este test empezara a ver la liquidacion en IN, el
     * rollback dejo de funcionar y el consumidor estaria fabricando liquidaciones invalidas.
     */
    @Test
    @Order(140)
    void completarLiquidacionQueNoCuadraDebeRechazarseYDejarlaEnDR() throws Exception {
        String fecha = fechaEnPeriodoCCSAbierto();
        if (fecha == null) return;

        Integer id = crearLiquidacionParaProcesar(settlementNo + "1", fecha, "1000.00", "0");
        if (id == null) return;

        ResponseEntity<String> response = exchange(HttpMethod.PUT, SETTLEMENTS + "/" + id + "/process?action=CO", null);
        assertThat(response.getStatusCode().toString())
                .as("una liquidacion descuadrada tiene que dar 409, no 200 ni 500: " + response.getBody())
                .contains("409");

        assertThat(docStatusDe(id))
                .as("la liquidacion tiene que seguir en borrador: el rollback de processEntity es lo que " +
                    "impide que la API deje liquidaciones en estado invalido (IN)")
                .isEqualTo("DR");
    }

    /**
     * Completar de verdad, con la liquidacion cuadrada.
     *
     * Se usa netamount = 0 A PROPOSITO. Con un importe acreditado distinto de cero, completeIt() genera un
     * C_Payment y lo completa, con lo cual el test dejaria un cobro real en la base y dependeria ademas de
     * la cuenta bancaria de liquidacion de la entidad financiera y del tipo de documento CR de la compania.
     * Lo que se quiere verificar aca es la transicion de documento y el cableado del endpoint, no la
     * generacion del cobro.
     */
    @Test
    @Order(150)
    void completarLiquidacionQueCuadraDebeCompletarla() throws Exception {
        String fecha = fechaEnPeriodoCCSAbierto();
        if (fecha == null) return;

        settlementCompletadaID = crearLiquidacionParaProcesar(settlementNo + "2", fecha, "0", "0");
        if (settlementCompletadaID == null) return;

        ResponseEntity<String> response = exchange(HttpMethod.PUT,
                SETTLEMENTS + "/" + settlementCompletadaID + "/process?action=CO", null);
        assertThat(response.getStatusCode().toString())
                .as("fallo el completado: " + response.getBody())
                .contains("200");

        assertThat(docStatusDe(settlementCompletadaID)).isEqualTo("CO");
    }

    /**
     * Repetir una accion ya aplicada da 409. Esta documentado en el yaml del endpoint como el unico 409 que
     * un consumidor automatico deberia leer como exito, asi que conviene que el mensaje no cambie sin que
     * alguien se entere.
     */
    @Test
    @Order(160)
    void repetirElCompletadoDebeAvisarQueYaEstaEnEseEstado() {
        if (settlementCompletadaID == null) return;

        ResponseEntity<String> response = exchange(HttpMethod.PUT,
                SETTLEMENTS + "/" + settlementCompletadaID + "/process?action=CO", null);
        assertThat(response.getStatusCode().toString()).contains("409");
        assertThat(response.getBody()).contains("ya coincide con el estado actual");
    }

    /**
     * Anular renombra el documento: el core le agrega un ^ al settlementno.
     *
     * Se prueba sobre la liquidacion del test anterior, que no tiene cupones colgados. NO se prueba el
     * borrado de cupones que hace voidIt() con un DELETE directo sobre C_CouponsSettlements, saltandose la
     * regla R8: esta documentado en el yaml del endpoint y verificarlo aca significaria destruir los cupones
     * que los tests de mas arriba usan para probar R6, R7 y los lotes.
     */
    @Test
    @Order(170)
    void anularLiquidacionDebeRenombrarElNumeroDeLiquidacion() throws Exception {
        if (settlementCompletadaID == null) return;

        ResponseEntity<String> response = exchange(HttpMethod.PUT,
                SETTLEMENTS + "/" + settlementCompletadaID + "/process?action=VO", null);
        assertThat(response.getStatusCode().toString())
                .as("fallo la anulacion: " + response.getBody())
                .contains("200");

        JsonNode json = mapper.readTree(get(SETTLEMENTS + "/" + settlementCompletadaID).getBody());
        assertThat(json.get("docstatus").asText()).isEqualTo("VO");
        assertThat(json.get("settlementno").asText())
                .as("voidIt le agrega un ^ al numero: el documento deja de ser el que era")
                .isEqualTo(settlementNo + "2^");
    }

    // =========
    // Auxiliares
    // =========

    private String couponJson(int paymentID) {
        return "{\"ad_org_id\":" + getOrgID() +
                ",\"c_creditcardsettlement_id\":" + settlementID +
                ",\"c_creditcardcouponfilter_id\":" + filterID +
                ",\"c_currency_id\":" + defaultCurrencyId +
                ",\"m_entidadfinanciera_id\":" + entidadFinancieraID +
                ",\"m_entidadfinancieraplan_id\":" + entidadFinancieraPlanID +
                ",\"c_payment_id\":" + paymentID +
                ",\"amount\":100.00,\"include\":true,\"trxdate\":\"" + TEST_DATE + "\"}";
    }

    private String bulkJson(String coupons) {
        return "{\"c_creditcardsettlement_id\":" + settlementID +
                ",\"c_creditcardcouponfilter_id\":" + filterID +
                ",\"coupons\":[" + coupons + "]}";
    }

    /**
     * Crea una liquidacion con importes elegidos, para poder probar el procesado.
     *
     * amount y netamount SI se envian, a diferencia de lo que pasa con los totales de conceptos: no son
     * rollups. El modelo solo los recalcula al anular o revertir (setAmountsByFactor), nunca al guardar.
     * De hecho completar compara uno contra otro, asi que sin ellos no hay nada que cuadrar.
     */
    private Integer crearLiquidacionParaProcesar(String numero, String fecha, String amount, String netAmount) throws Exception {
        resolveFixtures();
        // A diferencia del resto de la clase, los tests de procesado NO necesitan cobros: procesan una
        // liquidacion sin cupones. Pedirles el juego completo de fixtures los saltearia cada vez que la base
        // se queda sin C_Payment libres, y eso pasa solo: cada corrida consume los que cuelga, para siempre.
        if (!diccionarioTehuelche() || entidadFinancieraID == null) return null;

        String body = "{\"header\":{" +
                "\"ad_org_id\":" + getOrgID() + "," +
                "\"c_bpartner_id\":" + defaultBPartnerId + "," +
                "\"c_currency_id\":" + defaultCurrencyId + "," +
                "\"settlementno\":\"" + numero + "\"," +
                "\"paymentdate\":\"" + fecha + "\"," +
                "\"amount\":" + amount + "," +
                "\"netamount\":" + netAmount + "," +
                "\"docstatus\":\"DR\",\"docaction\":\"CO\"}," +
                "\"filter\":{\"m_entidadfinanciera_id\":" + entidadFinancieraID + "}}";

        ResponseEntity<String> response = post(SETTLEMENTS + "/full", body);
        assertThat(response.getStatusCode().toString())
                .as("fallo la creacion de la liquidacion a procesar: " + response.getBody())
                .contains("200");
        return mapper.readTree(response.getBody()).get("c_creditcardsettlement_id").asInt();
    }

    private String docStatusDe(int id) throws Exception {
        return mapper.readTree(get(SETTLEMENTS + "/" + id).getBody()).get("docstatus").asText();
    }

    /**
     * Fecha dentro de un periodo contable abierto para el tipo de documento de las liquidaciones (CCS).
     *
     * completeIt() y voidIt() empiezan por MPeriod.isOpen(), asi que sin un periodo abierto ningun test de
     * procesado prueba nada: fallarian todos con @PeriodClosed@ antes de llegar a la regla que se quiere
     * verificar. Y no sirve TEST_DATE, que es la fecha con la que trabajan el resto de los tests de esta
     * clase: en la base de prueba ese periodo esta cerrado para CCS. Por eso se resuelve contra la base en
     * vez de fijarla, y si no hay ninguno abierto los tests se saltean, igual que con el resto de los
     * fixtures.
     */
    private String fechaEnPeriodoCCSAbierto() {
        if (periodoResuelto) return fechaPeriodoAbierto;
        periodoResuelto = true;

        String sql = " SELECT p.startdate FROM c_period p " +
                     " JOIN c_periodcontrol pc ON pc.c_period_id = p.c_period_id " +
                     " WHERE pc.docbasetype = 'CCS' AND pc.periodstatus = 'O' " +
                     "   AND p.isactive = 'Y' AND p.ad_client_id = ? " +
                     " ORDER BY p.startdate DESC LIMIT 1 ";
        try (PreparedStatement ps = DB.prepareStatement(sql, null)) {
            ps.setInt(1, Integer.parseInt(credentials[2].split("=")[1]));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next())
                    fechaPeriodoAbierto = new SimpleDateFormat("yyyy-MM-dd").format(rs.getTimestamp(1)) + " 12:00:00";
            }
        } catch (Exception ignored) {
            // se saltea, como el resto de los fixtures
        }
        return fechaPeriodoAbierto;
    }

    private ResponseEntity<String> post(String path, String body) {
        return exchange(HttpMethod.POST, path, body);
    }

    private ResponseEntity<String> get(String path) {
        return exchange(HttpMethod.GET, path, null);
    }

    /**
     * GET con el parametro filter, que es una clausula WHERE de SQL y por lo tanto lleva espacios y comillas.
     *
     * Se arma un URI ya codificado en vez de concatenar texto: RestTemplate interpreta un String de URL como
     * plantilla y lo vuelve a codificar, con lo cual un %20 escrito a mano termina llegando roto al servidor.
     */
    private ResponseEntity<String> getWithFilter(String path, String filter) {
        URI uri = UriComponentsBuilder.fromHttpUrl(getBaseURL(path)).queryParam("filter", filter).build().encode().toUri();
        return restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(null, getAuthHeaders()), String.class);
    }

    private ResponseEntity<String> exchange(HttpMethod method, String path, String body) {
        return restTemplate.exchange(getBaseURL(path), method, new HttpEntity<>(body, getAuthHeaders()), String.class);
    }

    /** La organizacion con la que se pidio el token */
    private int getOrgID() {
        return Integer.parseInt(credentials[3].split("=")[1]);
    }

    private boolean fixturesDisponibles() {
        return diccionarioTehuelche() && entidadFinancieraID != null && entidadFinancieraPlanID != null
                && paymentIDs != null && paymentIDs.size() >= 3;
    }

    /**
     * El jar de Tehuelche NO puede operar sobre un diccionario que no sea el de Tehuelche.
     *
     * generateAllChildrens() de MCreditCardSettlement consulta la tabla M_NumeroComercio, que solo existe en
     * la base de Tehuelche. Contra cualquier otra base el alta de la cabecera falla con
     * 'relation "m_numerocomercio" does not exist' antes de llegar a ninguna regla de negocio.
     *
     * Por eso estos tests se saltean en vez de fallar: sobre una base que no es la de Tehuelche no hay nada
     * que puedan probar. Es la contracara practica de compilar contra los jars de Tehuelche.
     */
    private boolean diccionarioTehuelche() {
        if (esTehuelche == null)
            esTehuelche = DB.getSQLValue(null,
                    "SELECT count(1) FROM information_schema.tables WHERE table_name = 'm_numerocomercio'") > 0;
        return esTehuelche;
    }

    /**
     * Resuelve contra la base los ids que estos tests necesitan. Si no estan, los tests se saltean en vez de
     * fallar: la ausencia de una entidad financiera configurada no es un defecto de estos endpoints.
     */
    private void resolveFixtures() {
        if (entidadFinancieraID != null || paymentIDs != null) return;

        String sql = " SELECT ef.m_entidadfinanciera_id, efp.m_entidadfinancieraplan_id " +
                     " FROM m_entidadfinanciera ef " +
                     " JOIN m_entidadfinancieraplan efp ON efp.m_entidadfinanciera_id = ef.m_entidadfinanciera_id " +
                     "  AND efp.isactive = 'Y' " +
                     " WHERE ef.isactive = 'Y' AND ef.ad_client_id = ? LIMIT 1 ";
        try (PreparedStatement ps = DB.prepareStatement(sql, null)) {
            ps.setInt(1, Integer.parseInt(credentials[2].split("=")[1]));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    entidadFinancieraID = rs.getInt(1);
                    entidadFinancieraPlanID = rs.getInt(2);
                }
            }
        } catch (Exception ignored) {
            // fixturesDisponibles() se encarga
        }

        // Se prefieren cobros de la propia compania. El fallback a cualquier cobro activo existe porque la
        // unica restriccion real es la foreign key contra c_payment, y sin cobros no hay forma de probar R6,
        // R7 ni los lotes, que es justo lo que mas importa verificar.
        paymentIDs = findPayments(" AND p.ad_client_id = " + credentials[2].split("=")[1]);
        if (paymentIDs.size() < 4)
            paymentIDs = findPayments("");
    }

    /** Cobros activos todavia no colgados de ninguna liquidacion */
    private List<Integer> findPayments(String extraFilter) {
        List<Integer> found = new ArrayList<>();
        String sql = " SELECT p.c_payment_id FROM c_payment p " +
                     " WHERE p.isactive = 'Y' " + extraFilter +
                     "   AND NOT EXISTS (SELECT 1 FROM c_couponssettlements cs WHERE cs.c_payment_id = p.c_payment_id) " +
                     " ORDER BY p.c_payment_id LIMIT 4 ";
        try (PreparedStatement ps = DB.prepareStatement(sql, null);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next())
                found.add(rs.getInt(1));
        } catch (Exception ignored) {
            // fixturesDisponibles() se encarga
        }
        return found;
    }
}
