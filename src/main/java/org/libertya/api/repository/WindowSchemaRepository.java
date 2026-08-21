package org.libertya.api.repository;

import org.libertya.api.stub.model.WindowSchema;
import org.libertya.api.stub.model.WindowSchemaField;
import org.libertya.api.stub.model.WindowSchemaReference;
import org.libertya.api.stub.model.WindowSchemaReferenceValue;
import org.libertya.api.stub.model.WindowSchemaTab;
import org.openXpertya.util.DB;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringJoiner;

@Repository
public class WindowSchemaRepository {

    private static final int REFERENCE_LIST = 17;

    private static final int REFERENCE_YESNO = 20;

    private static final int REFERENCE_TABLE = 18;
    private static final int REFERENCE_TABLE_DIRECT = 19;

    private static final int REFERENCE_BUTTON = 28;

    /*
     * Mapping tabla Libertya -> endpoint REST.
     *
     * Se genera automáticamente mediante utils/genSchema.sh
     * y se encuentra en:
     *
     * src/main/resources/table-endpoints.properties
     */
    private static final Properties TABLE_ENDPOINTS =
            loadTableEndpoints();


    public WindowSchema retrieve(Integer windowId) {

        String sql =
                " SELECT " +
                        "   w.ad_window_id, " +
                        "   w.name AS window_name, " +
                        "   w.description AS window_description, " +

                        "   t.ad_tab_id, " +
                        "   t.name AS tab_name, " +
                        "   t.description AS tab_description, " +
                        "   t.seqno AS tab_seqno, " +
                        "   t.tablevel AS tab_tablevel, " +
                        "   t.whereclause AS tab_whereclause, " +
                        "   t.orderbyclause AS tab_orderbyclause, " +
                        "   t.isreadonly AS tab_isreadonly, " +

                        /*
                         * AD_Tab.AD_Column_ID es el override explícito
                         * para la columna master/detail.
                         */
                        "   tc.columnname AS tab_link_columnname, " +

                        "   tb.ad_table_id, " +
                        "   tb.tablename, " +

                        "   f.ad_field_id, " +
                        "   f.name AS field_name, " +
                        "   f.description AS field_description, " +
                        "   f.seqno AS field_seqno, " +
                        "   f.isdisplayed, " +

                        "   c.ad_column_id, " +
                        "   c.columnname, " +
                        "   c.ad_reference_id, " +
                        "   c.ad_reference_value_id, " +
                        "   c.ismandatory, " +
                        "   c.iskey, " +
                        "   c.isparent " +

                        " FROM ad_window w " +

                        " JOIN ad_tab t " +
                        "   ON t.ad_window_id = w.ad_window_id " +

                        " JOIN ad_table tb " +
                        "   ON tb.ad_table_id = t.ad_table_id " +

                        " JOIN ad_field f " +
                        "   ON f.ad_tab_id = t.ad_tab_id " +

                        " JOIN ad_column c " +
                        "   ON c.ad_column_id = f.ad_column_id " +

                        /*
                         * LEFT JOIN porque AD_Tab.AD_Column_ID
                         * puede no estar configurado.
                         */
                        " LEFT JOIN ad_column tc " +
                        "   ON tc.ad_column_id = t.ad_column_id " +

                        " WHERE w.ad_window_id = ? " +
                        "   AND w.isactive = 'Y' " +
                        "   AND t.isactive = 'Y' " +
                        "   AND f.isactive = 'Y' " +
                        "   AND c.isactive = 'Y' " +

                        " ORDER BY t.seqno, f.seqno ";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            ps = DB.prepareStatement(sql, null);
            ps.setInt(1, windowId);

            rs = ps.executeQuery();

            WindowSchema schema = null;

            Integer currentTabId = null;
            WindowSchemaTab currentTab = null;

            /*
             * Tabs creadas en orden SeqNo.
             * Se utilizan para determinar el padre estructural.
             */
            List<WindowSchemaTab> createdTabs =
                    new ArrayList<>();

            /*
             * Guarda el override explícito definido en
             * AD_Tab.AD_Column_ID.
             */
            Map<Integer, String> explicitLinkColumns =
                    new HashMap<>();


            while (rs.next()) {

                /*
                 * La ventana se crea una única vez.
                 */
                if (schema == null) {

                    schema = new WindowSchema()
                            .adWindowId(
                                    rs.getInt("ad_window_id")
                            )
                            .name(
                                    rs.getString("window_name")
                            )
                            .description(
                                    rs.getString(
                                            "window_description"
                                    )
                            );
                }


                Integer tabId =
                        rs.getInt("ad_tab_id");


                /*
                 * Nueva pestaña.
                 */
                if (!tabId.equals(currentTabId)) {

                    int tablevel =
                            rs.getInt("tab_tablevel");

                    String tableName =
                            rs.getString("tablename");

                    String dataEndpoint =
                            TABLE_ENDPOINTS.getProperty(
                                    tableName
                            );


                    currentTab =
                            new WindowSchemaTab()
                                    .adTabId(tabId)
                                    .name(
                                            rs.getString(
                                                    "tab_name"
                                            )
                                    )
                                    .description(
                                            rs.getString(
                                                    "tab_description"
                                            )
                                    )
                                    .seqno(
                                            rs.getInt(
                                                    "tab_seqno"
                                            )
                                    )
                                    .tablevel(tablevel)
                                    .whereclause(
                                            rs.getString(
                                                    "tab_whereclause"
                                            )
                                    )
                                    .orderbyclause(
                                            rs.getString(
                                                    "tab_orderbyclause"
                                            )
                                    )
                                    .isreadonly(
                                            "Y".equals(
                                                    rs.getString(
                                                            "tab_isreadonly"
                                                    )
                                            )
                                    )
                                    .adTableId(
                                            rs.getInt(
                                                    "ad_table_id"
                                            )
                                    )
                                    .tablename(tableName)
                                    .dataEndpoint(
                                            dataEndpoint
                                    );


                    /*
                     * Padre estructural:
                     *
                     * una pestaña de nivel N depende de la
                     * primera pestaña anterior cuyo nivel sea N-1.
                     */
                    if (tablevel > 0) {

                        Integer parentTabId =
                                findParentTabId(
                                        createdTabs,
                                        tablevel
                                );

                        if (parentTabId != null) {

                            currentTab.parentAdTabId(
                                    parentTabId
                            );
                        }
                    }


                    /*
                     * Guardar override explícito de la columna
                     * master/detail, si existe.
                     */
                    String explicitLinkColumn =
                            rs.getString(
                                    "tab_link_columnname"
                            );

                    if (explicitLinkColumn != null
                            && !explicitLinkColumn.isEmpty()) {

                        explicitLinkColumns.put(
                                tabId,
                                explicitLinkColumn
                        );
                    }


                    schema.addTabsItem(currentTab);
                    createdTabs.add(currentTab);

                    currentTabId = tabId;
                }


                /*
                 * Campo de la pestaña.
                 *
                 * Combina metadata de AD_Field y AD_Column.
                 */
                WindowSchemaField field =
                        new WindowSchemaField()
                                .adFieldId(
                                        rs.getInt(
                                                "ad_field_id"
                                        )
                                )
                                .name(
                                        rs.getString(
                                                "field_name"
                                        )
                                )
                                .description(
                                        rs.getString(
                                                "field_description"
                                        )
                                )
                                .seqno(
                                        rs.getInt(
                                                "field_seqno"
                                        )
                                )
                                .isdisplayed(
                                        "Y".equals(
                                                rs.getString(
                                                        "isdisplayed"
                                                )
                                        )
                                )
                                .adColumnId(
                                        rs.getInt(
                                                "ad_column_id"
                                        )
                                )
                                .columnname(
                                        rs.getString(
                                                "columnname"
                                        )
                                )
                                .adReferenceId(
                                        rs.getInt(
                                                "ad_reference_id"
                                        )
                                )
                                .adReferenceValueId(
                                        rs.getInt(
                                                "ad_reference_value_id"
                                        )
                                )
                                .ismandatory(
                                        "Y".equals(
                                                rs.getString(
                                                        "ismandatory"
                                                )
                                        )
                                )
                                .iskey(
                                        "Y".equals(
                                                rs.getString(
                                                        "iskey"
                                                )
                                        )
                                )
                                .isparent(
                                        "Y".equals(
                                                rs.getString(
                                                        "isparent"
                                                )
                                        )
                                );

                currentTab.addFieldsItem(field);
            }


            if (schema != null) {

                /*
                 * Resolver relaciones master/detail.
                 */
                resolveLinkColumns(
                        schema,
                        explicitLinkColumns
                );

                /*
                 * Resolver listas AD_Ref_List.
                 *
                 * Se realiza en una única consulta adicional
                 * para todas las referencias utilizadas por
                 * la ventana.
                 */
                resolveListReferences(schema);

                resolveBooleanReferences(schema);

                resolveLookupReferences(schema);

                resolveButtonReferences(schema);
            }


            return schema;

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error recuperando schema de ventana "
                            + windowId,
                    e
            );

        } finally {

            DB.close(rs, ps);
        }
    }


    /**
     * Carga el mapping tabla -> endpoint REST generado por
     * utils/genSchema.sh.
     */
    private static Properties loadTableEndpoints() {

        Properties properties =
                new Properties();

        try (
                InputStream input =
                        WindowSchemaRepository.class
                                .getClassLoader()
                                .getResourceAsStream(
                                        "table-endpoints.properties"
                                )
        ) {

            if (input == null) {

                throw new IllegalStateException(
                        "No se encontró "
                                + "table-endpoints.properties "
                                + "en el classpath"
                );
            }

            properties.load(input);

            return properties;

        } catch (Exception e) {

            throw new IllegalStateException(
                    "Error cargando "
                            + "table-endpoints.properties",
                    e
            );
        }
    }


    /**
     * Determina el padre estructural de una pestaña.
     */
    private Integer findParentTabId(
            List<WindowSchemaTab> tabs,
            int currentLevel) {

        int parentLevel =
                currentLevel - 1;

        for (int i = tabs.size() - 1;
             i >= 0;
             i--) {

            WindowSchemaTab candidate =
                    tabs.get(i);

            if (candidate.getTablevel() != null
                    && candidate
                    .getTablevel()
                    .intValue()
                    == parentLevel) {

                return candidate.getAdTabId();
            }
        }

        return null;
    }


    /**
     * Resuelve la columna master/detail de cada pestaña.
     */
    private void resolveLinkColumns(
            WindowSchema schema,
            Map<Integer, String> explicitLinkColumns) {

        if (schema.getTabs() == null) {
            return;
        }


        List<WindowSchemaTab> tabs =
                schema.getTabs();


        for (int tabIndex = 0;
             tabIndex < tabs.size();
             tabIndex++) {

            WindowSchemaTab tab =
                    tabs.get(tabIndex);


            if (tab.getTablevel() == null
                    || tab.getTablevel() == 0) {

                continue;
            }


            /*
             * 1. Override explícito en AD_Tab.AD_Column_ID.
             */
            String explicitColumn =
                    explicitLinkColumns.get(
                            tab.getAdTabId()
                    );

            if (explicitColumn != null
                    && !explicitColumn.isEmpty()) {

                tab.linkColumnname(
                        explicitColumn
                );

                continue;
            }


            /*
             * Obtener columnas IsParent.
             */
            List<WindowSchemaField> parentFields =
                    getParentFields(tab);


            /*
             * 2. Un único candidato.
             */
            if (parentFields.size() == 1) {

                tab.linkColumnname(
                        parentFields
                                .get(0)
                                .getColumnname()
                );

                continue;
            }


            /*
             * 3. Múltiples candidatos.
             */
            if (parentFields.size() > 1) {

                String linkColumn =
                        resolveLinkFromPreviousTabs(
                                tabs,
                                tabIndex,
                                parentFields
                        );

                if (linkColumn != null) {

                    tab.linkColumnname(
                            linkColumn
                    );
                }
            }
        }
    }


    private void resolveButtonReferences(
            WindowSchema schema) {

        if (schema.getTabs() == null) {
            return;
        }

        for (WindowSchemaTab tab : schema.getTabs()) {

            if (tab.getFields() == null) {
                continue;
            }

            for (WindowSchemaField field : tab.getFields()) {

                if (field.getAdReferenceId() != null
                        && field.getAdReferenceId()
                        == REFERENCE_BUTTON) {

                    field.reference(
                            new WindowSchemaReference()
                                    .type("button")
                    );
                }
            }
        }
    }


    /**
     * Recupera los campos marcados IsParent='Y'.
     */
    private List<WindowSchemaField> getParentFields(
            WindowSchemaTab tab) {

        List<WindowSchemaField> result =
                new ArrayList<>();

        if (tab.getFields() == null) {
            return result;
        }


        for (WindowSchemaField field
                : tab.getFields()) {

            if (Boolean.TRUE.equals(
                    field.isIsparent())) {

                result.add(field);
            }
        }


        return result;
    }


    /**
     * Resuelve una columna master/detail cuando existen
     * múltiples candidatos IsParent.
     */
    private String resolveLinkFromPreviousTabs(
            List<WindowSchemaTab> tabs,
            int currentTabIndex,
            List<WindowSchemaField> parentFields) {


        for (int i = currentTabIndex - 1;
             i >= 0;
             i--) {

            WindowSchemaTab previousTab =
                    tabs.get(i);


            if (previousTab.getFields() == null) {
                continue;
            }


            for (WindowSchemaField previousField
                    : previousTab.getFields()) {


                if (!Boolean.TRUE.equals(
                        previousField.isIskey())) {

                    continue;
                }


                String keyColumn =
                        previousField.getColumnname();


                if (keyColumn == null) {
                    continue;
                }


                for (WindowSchemaField parentField
                        : parentFields) {

                    String parentColumn =
                            parentField.getColumnname();


                    if (parentColumn != null
                            && keyColumn.equalsIgnoreCase(
                            parentColumn
                    )) {

                        return parentColumn;
                    }
                }
            }
        }


        return null;
    }


    /**
     * Resuelve todas las referencias de tipo List
     * utilizadas por la ventana.
     *
     * Importante:
     *
     * NO realiza una query por campo.
     *
     * Primero determina todos los AD_Reference_ID
     * necesarios y luego obtiene todos los AD_Ref_List
     * mediante una única consulta.
     */
    private void resolveListReferences(
            WindowSchema schema) {

        Set<Integer> referenceIds =
                new LinkedHashSet<>();


        /*
         * Primera pasada:
         *
         * determinar qué listas necesita esta ventana.
         */
        for (WindowSchemaTab tab
                : schema.getTabs()) {

            if (tab.getFields() == null) {
                continue;
            }

            for (WindowSchemaField field
                    : tab.getFields()) {

                if (field.getAdReferenceId() != null
                        && field.getAdReferenceId()
                        == REFERENCE_LIST
                        && field.getAdReferenceValueId() != null
                        && field.getAdReferenceValueId() > 0) {

                    referenceIds.add(
                            field.getAdReferenceValueId()
                    );
                }
            }
        }


        if (referenceIds.isEmpty()) {
            return;
        }


        /*
         * Recuperar todos los valores de todas las listas
         * en una sola query.
         */
        Map<Integer, List<WindowSchemaReferenceValue>>
                valuesByReference =
                loadListReferenceValues(referenceIds);


        /*
         * Segunda pasada:
         *
         * asociar a cada field su definición semántica.
         */
        for (WindowSchemaTab tab
                : schema.getTabs()) {

            if (tab.getFields() == null) {
                continue;
            }


            for (WindowSchemaField field
                    : tab.getFields()) {

                if (field.getAdReferenceId() == null
                        || field.getAdReferenceId()
                        != REFERENCE_LIST) {

                    continue;
                }


                WindowSchemaReference reference =
                        new WindowSchemaReference()
                                .type("list");


                List<WindowSchemaReferenceValue> values =
                        valuesByReference.get(
                                field.getAdReferenceValueId()
                        );


                if (values != null) {

                    for (WindowSchemaReferenceValue value
                            : values) {

                        reference.addValuesItem(value);
                    }
                }


                field.reference(reference);
            }
        }
    }


    private void resolveBooleanReferences(
            WindowSchema schema) {

        if (schema.getTabs() == null) {
            return;
        }

        for (WindowSchemaTab tab : schema.getTabs()) {

            if (tab.getFields() == null) {
                continue;
            }

            for (WindowSchemaField field : tab.getFields()) {

                if (field.getAdReferenceId() != null
                        && field.getAdReferenceId() == REFERENCE_YESNO) {

                    field.reference(
                            new WindowSchemaReference()
                                    .type("boolean")
                    );
                }
            }
        }
    }


    private void resolveLookupReferences(
            WindowSchema schema) {

        if (schema.getTabs() == null) {
            return;
        }


        for (WindowSchemaTab tab
                : schema.getTabs()) {

            if (tab.getFields() == null) {
                continue;
            }


            for (WindowSchemaField field
                    : tab.getFields()) {

                Integer referenceId =
                        field.getAdReferenceId();


                if (referenceId == null) {
                    continue;
                }


                if (referenceId == REFERENCE_TABLE
                        || referenceId
                        == REFERENCE_TABLE_DIRECT) {


                    String endpoint =
                            "/v1.0/columns/"
                                    + field.getAdColumnId()
                                    + "/lookup";


                    field.reference(
                            new WindowSchemaReference()
                                    .type("lookup")
                                    .endpoint(endpoint)
                    );
                }
            }
        }
    }

    /**
     * Recupera en una única consulta los valores
     * correspondientes a múltiples AD_Reference_ID.
     */
    private Map<Integer, List<WindowSchemaReferenceValue>>
    loadListReferenceValues(
            Set<Integer> referenceIds) {

        Map<Integer, List<WindowSchemaReferenceValue>>
                result =
                new HashMap<>();


        StringJoiner placeholders =
                new StringJoiner(",");

        for (int i = 0;
             i < referenceIds.size();
             i++) {

            placeholders.add("?");
        }


        String sql =
                " SELECT " +
                        "   rl.ad_reference_id, " +
                        "   rl.value, " +
                        "   rl.name " +

                        " FROM ad_ref_list rl " +

                        " WHERE rl.isactive = 'Y' " +
                        "   AND rl.ad_reference_id IN (" +
                        placeholders +
                        ") " +

                        " ORDER BY " +
                        "   rl.ad_reference_id, " +
                        "   rl.name ";


        PreparedStatement ps = null;
        ResultSet rs = null;


        try {

            ps = DB.prepareStatement(sql, null);


            int parameterIndex = 1;

            for (Integer referenceId
                    : referenceIds) {

                ps.setInt(
                        parameterIndex++,
                        referenceId
                );
            }


            rs = ps.executeQuery();


            while (rs.next()) {

                Integer referenceId =
                        rs.getInt(
                                "ad_reference_id"
                        );


                WindowSchemaReferenceValue value =
                        new WindowSchemaReferenceValue()
                                .value(
                                        rs.getString(
                                                "value"
                                        )
                                )
                                .name(
                                        rs.getString(
                                                "name"
                                        )
                                );


                result
                        .computeIfAbsent(
                                referenceId,
                                key ->
                                        new ArrayList<>()
                        )
                        .add(value);
            }


            return result;

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error recuperando valores "
                            + "de AD_Ref_List",
                    e
            );

        } finally {

            DB.close(rs, ps);
        }
    }
}