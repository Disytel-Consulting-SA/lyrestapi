package org.libertya.api.service;

import java.io.InputStream;
import java.net.URL;
import java.time.Instant;
import java.util.Properties;
import java.util.jar.Manifest;
import org.openXpertya.db.CConnection;
import org.openXpertya.model.M_Table;
import org.openXpertya.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StartupLYService {

    private static final Logger log = LoggerFactory.getLogger(StartupLYService.class);

    @Value("${restapi.libertya.db.DBHost}")
    private String dbHost;

    @Value("${restapi.libertya.db.DBPort}")
    private Integer dbPort;

    @Value("${restapi.libertya.db.DBName}")
    private String dbName;

    @Value("${restapi.libertya.db.DBUser}")
    private String dbUser;

    @Value("${restapi.libertya.db.DBPass}")
    private String dbPass;

    @Value("${restapi.libertya.app.clientID}")
    private String clientID;

    @Value("${restapi.libertya.app.useDefaults}")
    private String useDefaults;

    @Value("${restapi.libertya.app.referencedValues}")
    private String referencedValues;

    Instant startTime;

    /**
     * Realiza la configuración inicial a partir de la información recibida
     * @throws Exception en caso de error o rechazo
     */
    public void init() throws Exception
    {
        startTime = Instant.now();
        logCoreLocation();
        setConnection();
        startupEnvironment();
    }

    /**
     * Informa desde que jar se cargo el core y su version (Implementation-Version del manifest del OXP.jar).
     * El OXP.jar de una instancia customizada puede sumarse por loader.path por delante del embebido, y con dos
     * cores en el classpath es la forma de saber cual se usa. Ver docs/compatibilidad-core.md.
     */
    protected void logCoreLocation() {
        try {
            URL location = M_Table.class.getProtectionDomain().getCodeSource().getLocation();
            log.info("Core de Libertya cargado desde: " + location + " (version: " + getCoreVersion(location) + ")");
        } catch (Exception e) {
            log.warn("No fue posible determinar desde que jar se cargo el core de Libertya: " + e.getMessage());
        }
    }

    /**
     * Version del manifest del jar desde el que se cargo el core. No se usa Package.getImplementationVersion():
     * el launcher de Spring Boot define el paquete con el manifest del OXP.jar embebido aunque la clase venga de
     * otro jar por loader.path, y la version informada seria la equivocada.
     */
    protected String getCoreVersion(URL location) {
        String spec = location.toString();
        // Embebido: jar:file:.../lyrestapi.jar!/BOOT-INF/lib/OXP.jar!/  -  Por loader.path: file:/ruta/OXP.jar
        String manifest = spec.startsWith("jar:") ? spec + (spec.endsWith("/") ? "" : "/") + "META-INF/MANIFEST.MF"
                                                  : "jar:" + spec + "!/META-INF/MANIFEST.MF";
        try (InputStream in = new URL(manifest).openStream()) {
            String version = new Manifest(in).getMainAttributes().getValue("Implementation-Version");
            return version != null ? version : "desconocida";
        } catch (Exception e) {
            return "desconocida";
        }
    }

    protected void setConnection() {
        Ini.getProperties().put(Ini.P_CONNECTION,
                Secure.CLEARTEXT +
                        "CConnection["
                        + "name=localhost{DEVELOPMENT-DEVELOPMENT},"
                        + "AppsHost=localhost,"
                        + "AppsPort=1099,"
                        + "RMIoverHTTP=false,"
                        + "type=PostgreSQL,"
                        + "DBhost="+dbHost+","
                        + "DBport="+dbPort+","
                        + "DBname="+dbName+","
                        + "BQ=false,"
                        + "FW=false,"
                        + "FWhost=,"
                        + "FWport=0,"
                        + "UID="+dbUser+","
                        + "PWD="+dbPass+"]");

    }

    /**
     * Configura en entorno inicial
     * @throws Exception en caso de error
     */
    protected void startupEnvironment() throws Exception
    {
        Env.setContext(Env.getCtx(), "#AD_Language", "es_AR");
        Env.setContext(Env.getCtx(), "#AD_Client_ID", clientID);
        Env.setContext(Env.getCtx(), "#AD_Org_ID", 0);
        if (!setup())
            throw new Exception ("Error al iniciar entorno (Hay conexión a Base de Datos?) ");
        setCurrency(Env.getCtx());
        setUseDefaults(Env.getCtx());
        setReferencedValues(Env.getCtx());
    }

    protected boolean setup() {
        if (DB.isConnected())
            return true;
        // La gestion de log corre por cuenta del aspect EventLogAspect
        CLogMgt.shutdown();
        // Gestion server-side
        Ini.setClient(false);
        // Conectar a BDD
        CConnection cc = CConnection.get();
        DB.setDBTarget(cc);
        return DB.isConnected();
    }

    /**
     * Setea la moneda de la compañía en el contexto
     * @throws Exception en caso de error
     */
    protected void setCurrency(Properties ctx) {
        // Incorporar al contexto la moneda de la compañía
        String sql = 	" SELECT C_Currency_ID " +
                " FROM C_AcctSchema a, AD_ClientInfo c " +
                " WHERE a.C_AcctSchema_ID=c.C_AcctSchema1_ID " +
                " AND c.AD_Client_ID = " + Env.getAD_Client_ID(ctx);
        int currencyID = DB.getSQLValue(null, sql);
        Env.setContext(ctx, "$C_Currency_ID", currencyID);
    }

    /** Usar valores por defecto definidos en los metadatos de las columnas? */
    protected void setUseDefaults(Properties ctx) {
        Env.setContext(ctx, "#USE_DEFAULTS", useDefaults);
    }

    /** Retornar tambien los valores de las columnas que referencias a registos otras tablas? */
    protected void setReferencedValues(Properties ctx) {
        Env.setContext(ctx, "#USE_REFERENCED_VALUES", referencedValues);
    }

    public Instant getStartTime() {
        return startTime;
    }


}
