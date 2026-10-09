package org.libertya.api.repository;

import org.libertya.api.stub.model.MenuOption;
import org.openXpertya.util.DB;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuOptionsRepository {

    private static final String DEFAULT_LANGUAGE = "es_AR";

    public List<MenuOption> retrieve(String language, int roleID) {
        String effectiveLanguage = language != null && !language.trim().isEmpty() ? language.trim() : DEFAULT_LANGUAGE;

        String sql =
                "SELECT m.ad_menu_id, COALESCE(mt.name,m.name) AS name, m.ad_window_id, m.ad_process_id " +
                "FROM ad_menu m " +
                "LEFT JOIN ad_menu_trl mt ON mt.ad_menu_id=m.ad_menu_id AND mt.ad_language=? " +
                "LEFT JOIN ad_window_access wa ON wa.ad_window_id=m.ad_window_id AND wa.ad_role_id=? AND wa.isactive='Y' " +
                "LEFT JOIN ad_process p ON p.ad_process_id=m.ad_process_id " +
                "LEFT JOIN ad_process_access pa ON pa.ad_process_id=m.ad_process_id AND pa.ad_role_id=? AND pa.isactive='Y' " +
                "WHERE m.isactive='Y' AND (" +
                " (m.ad_window_id IS NOT NULL AND wa.ad_window_id IS NOT NULL) OR " +
                " (m.ad_process_id IS NOT NULL AND p.isactive='Y' AND p.isreport='N' AND pa.ad_process_id IS NOT NULL)" +
                ") ORDER BY COALESCE(mt.name,m.name)";

        try (PreparedStatement ps = DB.prepareStatement(sql, null)) {
            ps.setString(1, effectiveLanguage);
            ps.setInt(2, roleID);
            ps.setInt(3, roleID);

            try (ResultSet rs = ps.executeQuery()) {
                List<MenuOption> result = new ArrayList<>();
                while (rs.next()) {
                    Integer windowId = getNullableInteger(rs, "ad_window_id");
                    Integer processId = getNullableInteger(rs, "ad_process_id");
                    if (windowId != null) {
                        result.add(new MenuOption().adMenuId(rs.getInt("ad_menu_id")).name(rs.getString("name"))
                                .type(MenuOption.TypeEnum.WINDOW).targetId(windowId));
                    } else if (processId != null) {
                        result.add(new MenuOption().adMenuId(rs.getInt("ad_menu_id")).name(rs.getString("name"))
                                .type(MenuOption.TypeEnum.PROCESS).targetId(processId));
                    }
                }
                return result;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error recuperando opciones de menu para perfil " + roleID + " e idioma " + effectiveLanguage, e);
        }
    }

    private static Integer getNullableInteger(ResultSet rs, String column) throws Exception {
        int value = rs.getInt(column);
        return rs.wasNull() ? null : value;
    }
}
