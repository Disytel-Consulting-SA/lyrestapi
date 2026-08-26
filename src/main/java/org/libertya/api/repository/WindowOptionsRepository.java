package org.libertya.api.repository;

import org.libertya.api.stub.model.WindowOption;
import org.openXpertya.util.DB;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WindowOptionsRepository {

    private static final String DEFAULT_LANGUAGE = "es_AR";


    public List<WindowOption> retrieve(
            String language) {

        String effectiveLanguage =
                language != null
                        && !language.trim().isEmpty()
                        ? language.trim()
                        : DEFAULT_LANGUAGE;


        String sql =
                " SELECT " +
                        "   w.ad_window_id, " +
                        "   COALESCE(wt.name, w.name) AS name " +

                        " FROM ad_window w " +

                        " LEFT JOIN ad_window_trl wt " +
                        "   ON wt.ad_window_id = w.ad_window_id " +
                        "  AND wt.ad_language = ? " +

                        " WHERE w.isactive = 'Y' " +

                        " ORDER BY COALESCE(wt.name, w.name) ";


        PreparedStatement ps = null;
        ResultSet rs = null;


        try {

            ps = DB.prepareStatement(
                    sql,
                    null
            );

            ps.setString(
                    1,
                    effectiveLanguage
            );

            rs = ps.executeQuery();


            List<WindowOption> result =
                    new ArrayList<>();


            while (rs.next()) {

                result.add(
                        new WindowOption()
                                .adWindowId(
                                        rs.getInt(
                                                "ad_window_id"
                                        )
                                )
                                .name(
                                        rs.getString(
                                                "name"
                                        )
                                )
                );
            }


            return result;

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error recuperando opciones de ventanas "
                            + "para idioma "
                            + effectiveLanguage,
                    e
            );

        } finally {

            DB.close(
                    rs,
                    ps
            );
        }
    }
}