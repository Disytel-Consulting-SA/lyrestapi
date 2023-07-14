package org.libertya.api.common;

import org.openXpertya.util.Env;

import java.util.Properties;

public class UserInfo {

    private String userName;

    private int clientID;

    private int orgID;

    private Properties ctx;

    public static UserInfo of(String userName, int clientID, int orgID) {
        return new UserInfo(userName, clientID, orgID);
    }

    protected UserInfo(String userName, int clientID, int orgID) {
        this.userName = userName;
        this.clientID = clientID;
        this.orgID = orgID;
        // Se propagan las propiedades del environment pero se redefinen segun el actual request
        ctx = new Properties();
        ctx.putAll(Env.getCtx());
        Env.setContext(ctx, "#AD_Client_ID", this.clientID);
        Env.setContext(ctx, "#AD_Org_ID", this.orgID);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getOrgID() {
        return orgID;
    }

    public void setOrgID(int orgID) {
        this.orgID = orgID;
    }

    public Properties getCtx() { return ctx;    }

    public void setCtx(Properties ctx) { this.ctx = ctx;    }

}
