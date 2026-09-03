package org.libertya.api.repository;

import org.libertya.api.stub.model.RoleOption;
import org.openXpertya.util.DB;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RoleOptionsRepository {

    public List<RoleOption> retrieve(String userName) {

        String sql =
                " SELECT r.ad_role_id, r.name " +
                        " FROM ad_user u " +
                        " JOIN ad_user_roles ur ON ur.ad_user_id = u.ad_user_id " +
                        " JOIN ad_role r ON r.ad_role_id = ur.ad_role_id " +
                        " WHERE u.name = ? " +
                        "   AND u.isactive = 'Y' " +
                        "   AND ur.isactive = 'Y' " +
                        "   AND r.isactive = 'Y' " +
                        " ORDER BY r.name ";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = DB.prepareStatement(sql, null);
            ps.setString(1, userName);

            rs = ps.executeQuery();

            List<RoleOption> result = new ArrayList<>();

            while (rs.next()) {
                result.add(new RoleOption()
                        .adRoleId(rs.getInt("ad_role_id"))
                        .name(rs.getString("name")));
            }

            return result;

        } catch (Exception e) {
            throw new RuntimeException("Error recuperando perfiles para usuario " + userName, e);

        } finally {
            DB.close(rs, ps);
        }
    }


    public boolean hasRole(String userName, int roleID) {

        String sql =
                " SELECT 1 " +
                        " FROM ad_user u " +
                        " JOIN ad_user_roles ur ON ur.ad_user_id = u.ad_user_id " +
                        " JOIN ad_role r ON r.ad_role_id = ur.ad_role_id " +
                        " WHERE u.name = ? " +
                        "   AND u.isactive = 'Y' " +
                        "   AND ur.isactive = 'Y' " +
                        "   AND r.isactive = 'Y' " +
                        "   AND r.ad_role_id = ? ";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = DB.prepareStatement(sql, null);
            ps.setString(1, userName);
            ps.setInt(2, roleID);

            rs = ps.executeQuery();
            return rs.next();

        } catch (Exception e) {
            throw new RuntimeException(
                    "Error validando perfil " + roleID + " para usuario " + userName, e);

        } finally {
            DB.close(rs, ps);
        }
    }
}