package org.libertya.api.common;

public class UserInfo {

    private String userName;

    private int clientID;

    private int orgID;

    public static UserInfo of(String userName, int clientID, int orgID) {
        return new UserInfo(userName, clientID, orgID);
    }

    protected UserInfo(String userName, int clientID, int orgID) {
        this.userName = userName;
        this.clientID = clientID;
        this.orgID = orgID;
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
}
