package org.libertya.api.service;

import java.util.Properties;

import org.openXpertya.OpenXpertya;
import org.openXpertya.model.MUser;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;
import org.openXpertya.util.Ini;
import org.openXpertya.util.Secure;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StartupLYService {

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


    /**
     * Realiza la configuración inicial a partir de la información recibida
     * @throws Exception en caso de error o rechazo
     */
    public void init() throws Exception
    {
        setConnection();
        startupEnvironment();
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
        System.setProperty("OXP_HOME", System.getenv("OXP_HOME"));
        Env.setContext(Env.getCtx(), "#AD_Language", "es_AR");
        Env.setContext(Env.getCtx(), "#AD_Client_ID", clientID);
        Env.setContext(Env.getCtx(), "#AD_Org_ID", 0);
        if (!OpenXpertya.startup( false ))
            throw new Exception ("Error al iniciar entorno (Hay conexión a Base de Datos?) ");
        setCurrency(Env.getCtx());
        setUseDefaults(Env.getCtx());
        setReferencedValues(Env.getCtx());
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

}
