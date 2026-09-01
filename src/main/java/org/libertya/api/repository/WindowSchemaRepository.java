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

import org.libertya.api.common.UserInfo;
import org.libertya.api.util.WindowFieldDefaultResolver;

@Repository
public class WindowSchemaRepository {

    private static final int REFERENCE_LIST = 17;

    private static final int REFERENCE_TABLE = 18;

    private static final int REFERENCE_TABLE_DIRECT = 19;

    private static final int REFERENCE_YESNO = 20;

    private static final int REFERENCE_BUTTON = 28;

    private static final int REFERENCE_SEARCH = 30;

    private static final int REFERENCE_INTEGER = 11;
    private static final int REFERENCE_AMOUNT = 12;

    private static final int REFERENCE_DATE = 15;
    private static final int REFERENCE_DATETIME = 16;

    private static final int REFERENCE_NUMBER = 22;
    private static final int REFERENCE_TIME = 24;

    private static final int REFERENCE_QUANTITY = 29;

    private static final int REFERENCE_MEMO = 34;
    private static final int REFERENCE_TEXT_LONG = 36;

    private static final int REFERENCE_COST_PRICE = 37;


    private static final String DEFAULT_LANGUAGE = "es_AR";

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


    /**
     * Mantiene compatibilidad con llamadas sin contexto ni idioma.
     */
    public WindowSchema retrieve(
            Integer windowId) {

        return retrieve(
                null,
                windowId,
                null
        );
    }


    /**
     * Mantiene compatibilidad con llamadas sin contexto.
     */
    public WindowSchema retrieve(
            Integer windowId,
            String language) {

        return retrieve(
                null,
                windowId,
                language
        );
    }


    /**
     * Recupera el schema completo de una ventana
     * utilizando el contexto del request.
     */
    public WindowSchema retrieve(
            UserInfo info,
            Integer windowId,
            String language) {

        boolean translated = true;

        String effectiveLanguage =
                language != null && !language.trim().isEmpty()
                        ? language.trim()
                        : DEFAULT_LANGUAGE;


        /*
         * Las expresiones se construyen de esta manera
         * para evitar joins a las tablas _Trl cuando no
         * se solicita idioma.
         */
        String windowName =
                translated
                        ? "COALESCE(wt.name, w.name)"
                        : "w.name";

        String windowDescription =
                translated
                        ? "COALESCE(wt.description, w.description)"
                        : "w.description";

        String tabName =
                translated
                        ? "COALESCE(tt.name, t.name)"
                        : "t.name";

        String tabDescription =
                translated
                        ? "COALESCE(tt.description, t.description)"
                        : "t.description";

        String fieldName =
                translated
                        ? "COALESCE(ft.name, f.name)"
                        : "f.name";

        String fieldDescription =
                translated
                        ? "COALESCE(ft.description, f.description)"
                        : "f.description";


        StringBuilder sql =
                new StringBuilder();


        sql.append(" SELECT ");

        sql.append("   w.ad_window_id, ");

        sql.append("   ");
        sql.append(windowName);
        sql.append(" AS window_name, ");

        sql.append("   ");
        sql.append(windowDescription);
        sql.append(" AS window_description, ");


        sql.append("   t.ad_tab_id, ");

        sql.append("   ");
        sql.append(tabName);
        sql.append(" AS tab_name, ");

        sql.append("   ");
        sql.append(tabDescription);
        sql.append(" AS tab_description, ");

        sql.append("   t.seqno AS tab_seqno, ");
        sql.append("   t.tablevel AS tab_tablevel, ");
        sql.append("   t.whereclause AS tab_whereclause, ");
        sql.append("   t.orderbyclause AS tab_orderbyclause, ");
        sql.append("   t.isreadonly AS tab_isreadonly, ");


        /*
         * AD_Tab.AD_Column_ID es el override explícito
         * para la columna master/detail.
         */
        sql.append(
                "   tc.columnname AS tab_link_columnname, "
        );


        sql.append("   tb.ad_table_id, ");
        sql.append("   tb.tablename, ");


        sql.append("   f.ad_field_id, ");

        sql.append("   ");
        sql.append(fieldName);
        sql.append(" AS field_name, ");

        sql.append("   ");
        sql.append(fieldDescription);
        sql.append(" AS field_description, ");

        sql.append("   f.seqno AS field_seqno, ");
        sql.append("   f.isdisplayed, ");
        sql.append("   f.isreadonly AS field_isreadonly, ");


        sql.append("   c.ad_column_id, ");
        sql.append("   c.columnname, ");
        sql.append("   c.ad_reference_id, ");
        sql.append("   c.ad_reference_value_id, ");
        sql.append("   c.ismandatory, ");
        sql.append("   c.iskey, ");
        sql.append("   c.isparent, ");
        sql.append("   c.defaultvalue ");


        sql.append(" FROM ad_window w ");


        /*
         * Traducción de ventana.
         */
        if (translated) {

            sql.append(
                    " LEFT JOIN ad_window_trl wt "
            );

            sql.append(
                    "   ON wt.ad_window_id = w.ad_window_id "
            );

            sql.append(
                    "  AND wt.ad_language = ? "
            );
        }


        sql.append(
                " JOIN ad_tab t "
        );

        sql.append(
                "   ON t.ad_window_id = w.ad_window_id "
        );


        /*
         * Traducción de pestaña.
         */
        if (translated) {

            sql.append(
                    " LEFT JOIN ad_tab_trl tt "
            );

            sql.append(
                    "   ON tt.ad_tab_id = t.ad_tab_id "
            );

            sql.append(
                    "  AND tt.ad_language = ? "
            );
        }


        sql.append(
                " JOIN ad_table tb "
        );

        sql.append(
                "   ON tb.ad_table_id = t.ad_table_id "
        );


        sql.append(
                " JOIN ad_field f "
        );

        sql.append(
                "   ON f.ad_tab_id = t.ad_tab_id "
        );


        /*
         * Traducción de campo.
         */
        if (translated) {

            sql.append(
                    " LEFT JOIN ad_field_trl ft "
            );

            sql.append(
                    "   ON ft.ad_field_id = f.ad_field_id "
            );

            sql.append(
                    "  AND ft.ad_language = ? "
            );
        }


        sql.append(
                " JOIN ad_column c "
        );

        sql.append(
                "   ON c.ad_column_id = f.ad_column_id "
        );


        /*
         * LEFT JOIN porque AD_Tab.AD_Column_ID
         * puede no estar configurado.
         */
        sql.append(
                " LEFT JOIN ad_column tc "
        );

        sql.append(
                "   ON tc.ad_column_id = t.ad_column_id "
        );


        sql.append(
                " WHERE w.ad_window_id = ? "
        );

        sql.append(
                "   AND w.isactive = 'Y' "
        );

        sql.append(
                "   AND t.isactive = 'Y' "
        );

        sql.append(
                "   AND f.isactive = 'Y' "
        );

        sql.append(
                "   AND c.isactive = 'Y' "
        );


        sql.append(
                " ORDER BY t.seqno, f.seqno "
        );


        PreparedStatement ps = null;
        ResultSet rs = null;


        try {

            ps = DB.prepareStatement(
                    sql.toString(),
                    null
            );


            int parameterIndex = 1;


            /*
             * Los parámetros de idioma aparecen antes que
             * windowId en el SQL porque pertenecen a los JOIN.
             */
            if (translated) {

                ps.setString(
                        parameterIndex++,
                        effectiveLanguage
                );

                ps.setString(
                        parameterIndex++,
                        effectiveLanguage
                );

                ps.setString(
                        parameterIndex++,
                        effectiveLanguage
                );
            }


            ps.setInt(
                    parameterIndex,
                    windowId
            );


            rs = ps.executeQuery();


            WindowSchema schema = null;

            Integer currentTabId = null;

            WindowSchemaTab currentTab = null;


            /*
             * Tabs creadas en orden SeqNo.
             *
             * Se utilizan para determinar el padre estructural.
             */
            List<WindowSchemaTab> createdTabs =
                    new ArrayList<>();


            /*
             * Guarda el override explícito definido
             * en AD_Tab.AD_Column_ID.
             */
            Map<Integer, String> explicitLinkColumns =
                    new HashMap<>();


            while (rs.next()) {

                /*
                 * La ventana se crea una única vez.
                 */
                if (schema == null) {

                    schema =
                            new WindowSchema()
                                    .adWindowId(
                                            rs.getInt(
                                                    "ad_window_id"
                                            )
                                    )
                                    .name(
                                            rs.getString(
                                                    "window_name"
                                            )
                                    )
                                    .description(
                                            rs.getString(
                                                    "window_description"
                                            )
                                    );
                }


                Integer tabId =
                        rs.getInt(
                                "ad_tab_id"
                        );


                /*
                 * Nueva pestaña.
                 */
                if (!tabId.equals(currentTabId)) {

                    int tablevel =
                            rs.getInt(
                                    "tab_tablevel"
                            );


                    String tableName =
                            rs.getString(
                                    "tablename"
                            );


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
                                    .tablevel(
                                            tablevel
                                    )
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
                                    .tablename(
                                            tableName
                                    )
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


                    schema.addTabsItem(
                            currentTab
                    );

                    createdTabs.add(
                            currentTab
                    );


                    currentTabId =
                            tabId;
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
                                .isreadonly(
                                        "Y".equals(
                                                rs.getString(
                                                        "field_isreadonly"
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
                                ).defaultvalue(
                                        WindowFieldDefaultResolver.resolve(
                                                info,
                                                rs.getInt(
                                                        "ad_reference_id"
                                                ),
                                                rs.getString(
                                                        "columnname"
                                                ),
                                                "Y".equals(
                                                        rs.getString(
                                                                "iskey"
                                                        )
                                                ),
                                                "Y".equals(
                                                        rs.getString(
                                                                "isparent"
                                                        )
                                                ),
                                                rs.getString(
                                                        "defaultvalue"
                                                )
                                        )
                                );


                currentTab.addFieldsItem(
                        field
                );
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
                 * Sigue siendo una única consulta adicional
                 * para todas las listas utilizadas por la ventana.
                 */
                resolveListReferences(
                        schema,
                        effectiveLanguage
                );


                /*
                 * Tipos semánticos para frontend.
                 */
                resolveBooleanReferences(
                        schema
                );

                resolveLookupReferences(
                        schema
                );

                resolveButtonReferences(
                        schema
                );

                resolveVisualReferences(
                            schema
                );
            }


            return schema;


        } catch (Exception e) {

            throw new RuntimeException(
                    "Error recuperando schema de ventana "
                            + windowId
                            + (
                            translated
                                    ? " para idioma "
                                    + effectiveLanguage
                                    : ""
                    ),
                    e
            );

        } finally {

            DB.close(
                    rs,
                    ps
            );
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


            properties.load(
                    input
            );


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
                    getParentFields(
                            tab
                    );


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


    /**
     * Resuelve campos Button.
     */
    private void resolveButtonReferences(
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

                result.add(
                        field
                );
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
     * Se recuperan todos los AD_Reference_ID utilizados
     * y luego todos los valores mediante una única consulta.
     */
    private void resolveListReferences(
            WindowSchema schema,
            String language) {

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
                loadListReferenceValues(
                        referenceIds,
                        language
                );


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

                        reference.addValuesItem(
                                value
                        );
                    }
                }


                field.reference(
                        reference
                );
            }
        }
    }


    /**
     * Resuelve campos Yes/No.
     */
    private void resolveBooleanReferences(
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

                if (field.getAdReferenceId() != null
                        && field.getAdReferenceId()
                        == REFERENCE_YESNO) {

                    field.reference(
                            new WindowSchemaReference()
                                    .type("boolean")
                    );
                }
            }
        }
    }


    /**
     * Resuelve referencias Table, Table Direct y Search.
     *
     * Table/Table Direct se renderizan como lookup.
     *
     * Search utiliza el mismo endpoint de resolución,
     * pero el frontend lo presenta mediante ventana modal.
     */
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


                String endpoint =
                        "/v1.0/columns/"
                                + field.getAdColumnId()
                                + "/lookup";


                /*
                 * Table / Table Direct
                 */
                if (referenceId == REFERENCE_TABLE
                        || referenceId
                        == REFERENCE_TABLE_DIRECT) {

                    field.reference(
                            new WindowSchemaReference()
                                    .type("lookup")
                                    .endpoint(endpoint)
                    );

                    continue;
                }


                /*
                 * Search
                 */
                if (referenceId == REFERENCE_SEARCH) {

                    field.reference(
                            new WindowSchemaReference()
                                    .type("search")
                                    .endpoint(endpoint)
                    );
                }
            }
        }
    }


    /**
     * Recupera en una única consulta los valores
     * correspondientes a múltiples AD_Reference_ID.
     *
     * Si language viene informado, intenta obtener Name
     * desde AD_Ref_List_Trl.
     *
     * Si no existe traducción, se utiliza rl.Name.
     */
    private Map<Integer, List<WindowSchemaReferenceValue>>
    loadListReferenceValues(
            Set<Integer> referenceIds,
            String language) {

        Map<Integer, List<WindowSchemaReferenceValue>>
                result =
                new HashMap<>();


        boolean translated =
                language != null
                        && !language.trim().isEmpty();


        StringJoiner placeholders =
                new StringJoiner(",");


        for (int i = 0;
             i < referenceIds.size();
             i++) {

            placeholders.add(
                    "?"
            );
        }


        String listName =
                translated
                        ? "COALESCE(rlt.name, rl.name)"
                        : "rl.name";


        StringBuilder sql =
                new StringBuilder();


        sql.append(
                " SELECT "
        );

        sql.append(
                "   rl.ad_reference_id, "
        );

        sql.append(
                "   rl.value, "
        );

        sql.append(
                "   "
        );

        sql.append(
                listName
        );

        sql.append(
                " AS name "
        );


        sql.append(
                " FROM ad_ref_list rl "
        );


        if (translated) {

            sql.append(
                    " LEFT JOIN ad_ref_list_trl rlt "
            );

            sql.append(
                    "   ON rlt.ad_ref_list_id = rl.ad_ref_list_id "
            );

            sql.append(
                    "  AND rlt.ad_language = ? "
            );
        }


        sql.append(
                " WHERE rl.isactive = 'Y' "
        );

        sql.append(
                "   AND rl.ad_reference_id IN ("
        );

        sql.append(
                placeholders
        );

        sql.append(
                ") "
        );


        sql.append(
                " ORDER BY "
        );

        sql.append(
                "   rl.ad_reference_id, "
        );

        sql.append(
                "   name "
        );


        PreparedStatement ps = null;
        ResultSet rs = null;


        try {

            ps = DB.prepareStatement(
                    sql.toString(),
                    null
            );


            int parameterIndex = 1;


            /*
             * El parámetro del JOIN aparece antes
             * que los IDs del IN.
             */
            if (translated) {

                ps.setString(
                        parameterIndex++,
                        language.trim()
                );
            }


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
                        .add(
                                value
                        );
            }


            return result;


        } catch (Exception e) {

            throw new RuntimeException(
                    "Error recuperando valores "
                            + "de AD_Ref_List"
                            + (
                            translated
                                    ? " para idioma "
                                    + language
                                    : ""
                    ),
                    e
            );

        } finally {

            DB.close(
                    rs,
                    ps
            );
        }
    }


    private void resolveVisualReferences(
            WindowSchema schema) {

        if (schema.getTabs() == null) {
            return;
        }

        for (WindowSchemaTab tab : schema.getTabs()) {

            if (tab.getFields() == null) {
                continue;
            }

            for (WindowSchemaField field : tab.getFields()) {

                Integer referenceId =
                        field.getAdReferenceId();

                if (referenceId == null) {
                    continue;
                }

                switch (referenceId) {

                    case REFERENCE_INTEGER:

                        field.reference(
                                new WindowSchemaReference()
                                        .type("integer")
                        );

                        break;


                    case REFERENCE_AMOUNT:

                        field.reference(
                                new WindowSchemaReference()
                                        .type("amount")
                        );

                        break;


                    case REFERENCE_NUMBER:

                        field.reference(
                                new WindowSchemaReference()
                                        .type("number")
                        );

                        break;


                    case REFERENCE_QUANTITY:

                        field.reference(
                                new WindowSchemaReference()
                                        .type("quantity")
                        );

                        break;


                    case REFERENCE_COST_PRICE:

                        field.reference(
                                new WindowSchemaReference()
                                        .type("costprice")
                        );

                        break;


                    case REFERENCE_DATE:

                        field.reference(
                                new WindowSchemaReference()
                                        .type("date")
                        );

                        break;


                    case REFERENCE_DATETIME:

                        field.reference(
                                new WindowSchemaReference()
                                        .type("datetime")
                        );

                        break;


                    case REFERENCE_TIME:

                        field.reference(
                                new WindowSchemaReference()
                                        .type("time")
                        );

                        break;


                    case REFERENCE_MEMO:
                    case REFERENCE_TEXT_LONG:

                        field.reference(
                                new WindowSchemaReference()
                                        .type("textarea")
                        );

                        break;


                    default:
                        break;
                }
            }
        }
    }

}