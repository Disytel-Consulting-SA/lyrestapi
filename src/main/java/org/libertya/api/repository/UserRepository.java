package org.libertya.api.repository;

import org.libertya.api.stub.model.User;
import org.openXpertya.model.PO;
import org.openXpertya.model.X_AD_User;
import org.openXpertya.util.DB;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class UserRepository extends AbstractRepository {

    public UserRepository() {
        tableName = X_AD_User.Table_Name;
        iface = User::new;
    }

    public Optional<PO> findActiveUser(String username, String clientId, String orgId) {
        return find(username, null, clientId, orgId, true);
    }

    public Optional<PO> findUser(String username, String password, String clientId, String orgId) {
        return find(username, password, clientId, orgId, false);
    }

    public Optional<PO> find(String username, String password, String clientId, String orgId, boolean active) {
        if (username == null || clientId == null || orgId == null)
            return Optional.empty();

        final int client;
        final int org;
        try {
            client = Integer.parseInt(clientId);
            org = Integer.parseInt(orgId);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }

        String sql = "SELECT AD_User_ID FROM AD_User WHERE Name = ?"
                + (active ? " AND IsActive = 'Y'" : "")
                + (password != null ? " AND Password = ?" : "")
                + " AND AD_Client_ID = ?"
                + " AND (AD_Org_ID = ? OR (AD_Org_ID = 0"
                + " AND ? IN (SELECT AD_Org_ID FROM AD_Org WHERE AD_Client_ID = ?)))";

        try (PreparedStatement ps = DB.prepareStatement(sql, null)) {
            int p = 1;
            ps.setString(p++, username);
            if (password != null)
                ps.setString(p++, password);
            ps.setInt(p++, client);
            ps.setInt(p++, org);
            ps.setInt(p++, org);
            ps.setInt(p, client);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next())
                    return Optional.empty();
                return Optional.ofNullable(getPO(null, X_AD_User.Table_Name, new int[]{rs.getInt(1)}, null));
            }
        } catch (SQLException | org.libertya.api.exception.AuthException e) {
            return Optional.empty();
        }
    }
}
