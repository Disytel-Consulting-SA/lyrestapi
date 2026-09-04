package org.libertya.api.common;

import org.openXpertya.util.Env;

import java.util.Properties;

public class UserInfo {

    private String userName;

    private int clientID;

    private int orgID;

    private Integer roleID;

    private Properties ctx;

    private int userID;

    public static UserInfo of(String userName, int userID, int clientID, int orgID) {
        return new UserInfo(userName, userID, clientID, orgID, null);
    }

    public static UserInfo of(String userName, int userID, int clientID, int orgID, Integer roleID) {
        return new UserInfo(userName, userID, clientID, orgID, roleID);
    }

    protected UserInfo(String userName, int userID, int clientID, int orgID, Integer roleID) {
        this.userName = userName;
        this.userID = userID;
        this.clientID = clientID;
        this.orgID = orgID;
        this.roleID = roleID;
        // Se propagan las propiedades del environment pero se redefinen segun el actual request
        ctx = new Properties();
        ctx.putAll(Env.getCtx());
        Env.setContext(ctx, "#AD_User_ID", this.userID);
        Env.setContext(ctx, "#AD_Client_ID", this.clientID);
        Env.setContext(ctx, "#AD_Org_ID", this.orgID);
        if (this.roleID != null) {
            Env.setContext(ctx, "#AD_Role_ID", this.roleID);
        }
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

    public Integer getRoleID() { return roleID; }

    public void setRoleID(Integer roleID) { this.roleID = roleID; }

    public boolean hasRole() { return roleID != null; }

    public Properties getCtx() { return ctx;    }

    public void setCtx(Properties ctx) { this.ctx = ctx;    }

    public int getUserID() { return userID; }

    public void setUserID(int userID) { this.userID = userID; }
}
