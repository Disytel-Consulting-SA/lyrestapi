package org.libertya.api.service;

import java.util.Properties;

import org.openXpertya.OpenXpertya;
import org.openXpertya.model.MUser;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StartupLYService {

    @Value("${restapi.libertya.credentials.clientid}")
    private Integer clientID;

    @Value("${restapi.libertya.credentials.orgid}")
    private Integer orgID;

    @Value("${restapi.libertya.credentials.username}")
    private String userName;

    @Value("${restapi.libertya.credentials.password}")
    private String password;

    /** Nombres de parametros de la invocacion */
    protected String[] argNames = null;
    /** Valores de parametros de la invocacion */
    protected Object[] argValues = null;

    /** Variables de entorno a recuperar */
    public static final String ENV_OXP_HOME 			= "OXP_HOME";

    /**
     * Realiza la configuración inicial a partir de la información recibida
     * @throws Exception en caso de error o rechazo
     */
    public void init(String[] argNames, Object[] argValues) throws Exception
    {
        // Argumentos
        this.argNames = argNames;
        this.argValues = argValues;

        // Iniciar el entorno
        setClientOrg(clientID, orgID);
        startupEnvironment();

        // Validar login
        checkLogin(userName, password);

        // Setear valores adicionales
        setCurrency();
        setWarehouse(orgID);
    }

    /**
     * 	Setea en el contexto las variables de compañía y organizacion
     * @throws Exception en caso de indicar valores incorrectos
     */
    protected void setClientOrg(Integer clientID, Integer orgID) throws Exception
    {
        // Setear clientID y orgID en el contexto
        if (clientID == null || clientID < 0)
            throw new Exception("Valor clientID (" + clientID + ") incorrecto. ");
        if (orgID == null || orgID < 0)
            throw new Exception("Valor orgID (" + orgID + ") incorrecto. ");
        Env.setContext(getCtx(), "#AD_Client_ID", clientID);
        Env.setContext(getCtx(), "#AD_Org_ID", orgID);
    }

    /**
     * Setea la moneda de la compañía en el contexto
     * @throws Exception en caso de error
     */
    protected void setCurrency() throws Exception {
        // Incorporar al contexto la moneda de la compañía
        String sql = 	" SELECT C_Currency_ID " +
                " FROM C_AcctSchema a, AD_ClientInfo c " +
                " WHERE a.C_AcctSchema_ID=c.C_AcctSchema1_ID " +
                " AND c.AD_Client_ID = " + Env.getAD_Client_ID(getCtx());
        int currencyID = DB.getSQLValue(null, sql);
        Env.setContext(getCtx(), "$C_Currency_ID", currencyID);
    }

    /**
     * Setea en el contexto el almacen definido en la organizacion (o bien si
     * este no se encuentra definido toma un almacen perteneciente a la organización)
     * @param orgID id de Organizacion
     * @throws Exception en caso de error
     */
    protected void setWarehouse(int orgID) throws Exception
    {
        // Recuperar el warehouseID a partir de la configuración de la organización
        if (orgID > 0) {
            int warehouseID = DB.getSQLValue(null, "SELECT M_Warehouse_ID FROM AD_OrgInfo WHERE AD_Org_ID = " + orgID);
            if (warehouseID > 0) {
                Env.setContext(getCtx(), "#M_Warehouse_ID", warehouseID);
                return;
            }
            // En caso contrario recuperar algún warehouse de los existentes para la organización dada
            warehouseID = DB.getSQLValue(null, 	" SELECT M_Warehouse_ID " +
                    " FROM M_Warehouse " +
                    " WHERE AD_Org_ID = " + orgID +
                    " AND isactive = 'Y'" +
                    " ORDER BY created ASC LIMIT 1");
            if (warehouseID > 0) {
                Env.setContext(getCtx(), "#M_Warehouse_ID", warehouseID);
            }
        }
    }

    /**
     * Configura en entorno inicial
     * @throws Exception en caso de error
     */
    protected void startupEnvironment() throws Exception
    {
        // Validar parametros recibidos
        if (getCtx() == null)
            throw new Exception ("Error al chequear login.  Contexto es null.");
        if (Env.getContext(getCtx(), "#AD_Client_ID") == null)
            throw new Exception ("Error al chequear login.  AD_Client_ID no esta configurada.");
        if (Env.getContext(getCtx(), "#AD_Org_ID") == null)
            throw new Exception ("Error al chequear login.  AD_Org_ID no esta configurada.");

        // Iniciar ambiente
        setOXPHome();
        if (!OpenXpertya.startup( false ))
            throw new Exception ("Error al iniciar entorno (Hay conexión a Base de Datos?) ");
    }

    /**
     * Configura OXP_HOME y ubicacion de log segun las variables de entorno
     */
    protected void setOXPHome() throws Exception {
        // OXP_HOME seteada?
        String oxpHomeDir = System.getenv(ENV_OXP_HOME);
        if (oxpHomeDir == null)
            throw new Exception ("La variable de entorno OXP_HOME no está seteada. ");
        // Cargar el entorno basico
        System.setProperty(ENV_OXP_HOME, oxpHomeDir);
;
    }

    /**
     * 	Valida el acceso al WS
     * @throws Exception en caso de error o acceso invalido
     */
    protected void checkLogin(String userName, String password) throws Exception
    {
        // Recuperar el usuario
        MUser user = MUser.get(getCtx(), userName, password);
        if (user==null)
            throw new Exception ("Error de acceso para usuario " + userName);
        // Setear valores correspondientes
        Env.setContext(getCtx(), "#AD_User_ID", user.getAD_User_ID());
        Env.setContext(getCtx(), "#AD_User_Name", user.getName());
        Env.setContext(getCtx(), "#AD_Language", "es_AR");
    }

    /**
     * Recupera el contexto. En su primera invocacion genera
     * el contexto en funcion de los datos recibidos.
     */
    protected Properties getCtx()
    {
        return Env.getCtx();
    }

}
