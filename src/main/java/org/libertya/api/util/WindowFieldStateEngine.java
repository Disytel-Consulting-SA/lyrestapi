package org.libertya.api.util;

import org.libertya.api.common.UserInfo;
import org.openXpertya.model.MField;
import org.openXpertya.model.MFieldVO;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;
import org.libertya.api.stub.model.WindowRecordFieldState;
import org.libertya.api.stub.model.WindowRecordState;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class WindowFieldStateEngine {

    /*
     * La REST API no posee ventanas Swing reales.
     * Utilizamos un WindowNo lógico propio para que MField/Env
     * puedan trabajar con el contexto de la evaluación.
     */
    private static final int WINDOW_NO = 1;
    private static final int TAB_NO = 0;

    private List<MField> loadFields(Properties ctx, int adTabId, TabInfo tabInfo, boolean inserting) {

        List<MField> fields = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = DB.prepareStatement(MFieldVO.getSQL(ctx), null);
            ps.setInt(1, adTabId);
            rs = ps.executeQuery();

            while (rs.next()) {
                MFieldVO vo = MFieldVO.create(
                        ctx,
                        WINDOW_NO,
                        TAB_NO,
                        tabInfo.adWindowId,
                        tabInfo.readOnly,
                        rs,
                        tabInfo.alwaysUpdateable
                );

                if (vo != null) {
                    MField field = new MField(vo);
                    field.setInserting(inserting);
                    fields.add(field);
                }
            }

            return fields;
        } catch (Exception e) {
            throw new RuntimeException("Error cargando fields CORE para AD_Tab_ID=" + adTabId, e);
        } finally {
            DB.close(rs, ps);
        }
    }

    private TabInfo loadTabInfo(int adTabId) {
        String sql =
                "SELECT t.ad_window_id, t.ad_table_id, t.isreadonly, t.isalwaysupdateable, w.issotrx " +
                        "FROM ad_tab t " +
                        "JOIN ad_window w ON w.ad_window_id = t.ad_window_id " +
                        "WHERE t.ad_tab_id = ? AND t.isactive = 'Y'";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = DB.prepareStatement(sql, null);
            ps.setInt(1, adTabId);
            rs = ps.executeQuery();

            if (!rs.next()) {
                throw new IllegalArgumentException("No existe AD_Tab_ID=" + adTabId);
            }

            return new TabInfo(
                    rs.getInt("ad_window_id"),
                    rs.getInt("ad_table_id"),
                    "Y".equals(rs.getString("isreadonly")),
                    "Y".equals(rs.getString("isalwaysupdateable")),
                    "Y".equals(rs.getString("issotrx"))
            );
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error recuperando AD_Tab_ID=" + adTabId, e);
        } finally {
            DB.close(rs, ps);
        }
    }

    public WindowRecordState resolveNewRecordState(UserInfo info, int adTabId, Map<String, String> parentValues) {
        Properties ctx = info.getCtx();
        TabInfo tabInfo = loadTabInfo(adTabId);
        Env.setContext(ctx, WINDOW_NO, "IsSOTrx", tabInfo.isSOTrx ? "Y" : "N");
        Env.setContext(ctx, WINDOW_NO, TAB_NO, "AD_Table_ID", String.valueOf(tabInfo.adTableId));

        if (parentValues != null) {
            for (Map.Entry<String, String> entry : parentValues.entrySet()) {
                Env.setContext(ctx, WINDOW_NO, entry.getKey(), entry.getValue());
            }
        }

        String linkColumnName = resolveExplicitLinkColumnName(adTabId);

        if (linkColumnName != null) {
            Env.setContext(ctx, WINDOW_NO, TAB_NO, "LinkColumnName", linkColumnName);
        }

        List<MField> fields = loadFields(ctx, adTabId, tabInfo, true);
        Map<String, String> values = new LinkedHashMap<>();

        for (MField field : fields) {
            Object defaultValue = field.getDefault();

            if (defaultValue != null) {
                field.setValue(defaultValue, true);
            }
        }

        for (MField field : fields) {
            field.lookupLoadComplete();
            field.validateValue();
            String value = toProtocolValue(field.getValue());
            if (value != null) {
                values.put(field.getColumnName(), value);
            }
        }

        List<WindowRecordFieldState> fieldStates = new ArrayList<>();

        for (MField field : fields) {
            WindowRecordFieldState state = new WindowRecordFieldState();

            state.setAdFieldId(field.getAD_Field_ID());
            state.setColumnname(field.getColumnName());
            state.setDisplayed(field.isDisplayed(true));
            state.setReadonly(!field.isEditable(true));

            fieldStates.add(state);
        }

        WindowRecordState state = new WindowRecordState();
        state.setValues(values);
        state.setFields(fieldStates);

        return state;
    }


    public WindowRecordState resolveRecordState(UserInfo info, int adTabId, Map<String, String> currentValues,
                                                Map<String, String> parentValues, boolean inserting) {

        Properties ctx = info.getCtx();
        TabInfo tabInfo = loadTabInfo(adTabId);
        Env.setContext(ctx, WINDOW_NO, "IsSOTrx", tabInfo.isSOTrx ? "Y" : "N");
        Env.setContext(ctx, WINDOW_NO, TAB_NO, "AD_Table_ID", String.valueOf(tabInfo.adTableId));

        if (parentValues != null) {
            for (Map.Entry<String, String> entry : parentValues.entrySet()) {
                Env.setContext(ctx, WINDOW_NO, entry.getKey(), entry.getValue());
            }
        }

        String linkColumnName = resolveExplicitLinkColumnName(adTabId);

        if (linkColumnName != null) {
            Env.setContext(ctx, WINDOW_NO, TAB_NO, "LinkColumnName", linkColumnName);
        }

        List<MField> fields = loadFields(ctx, adTabId, tabInfo, inserting);
        Map<String, String> values = new LinkedHashMap<>();

        if (currentValues != null) {
            values.putAll(currentValues);

            for (Map.Entry<String, String> entry : currentValues.entrySet()) {
                Env.setContext(ctx, WINDOW_NO, TAB_NO, entry.getKey(), entry.getValue());
            }

            for (MField field : fields) {
                String value = currentValues.get(field.getColumnName());

                if (value != null) {
                    field.setValue(value, inserting);
                }
            }
        }

        List<WindowRecordFieldState> fieldStates = new ArrayList<>();

        for (MField field : fields) {
            WindowRecordFieldState state = new WindowRecordFieldState();

            state.setAdFieldId(field.getAD_Field_ID());
            state.setColumnname(field.getColumnName());
            state.setDisplayed(field.isDisplayed(true));
            state.setReadonly(!field.isEditable(true));

            fieldStates.add(state);
        }

        WindowRecordState state = new WindowRecordState();
        state.setValues(values);
        state.setFields(fieldStates);

        return state;
    }


    private String toProtocolValue(Object value) {
        if (value == null) {
            return null;
        }

        if (value instanceof Boolean) {
            return ((Boolean) value) ? "Y" : "N";
        }

        return value.toString();
    }

    private String resolveExplicitLinkColumnName(int adTabId) {
        String sql =
                "SELECT c.columnname " +
                        "FROM ad_tab t " +
                        "JOIN ad_column c ON c.ad_column_id = t.ad_column_id " +
                        "WHERE t.ad_tab_id = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = DB.prepareStatement(sql, null);
            ps.setInt(1, adTabId);
            rs = ps.executeQuery();

            return rs.next() ? rs.getString("columnname") : null;
        } catch (Exception e) {
            throw new RuntimeException("Error resolviendo LinkColumnName explícito para AD_Tab_ID=" + adTabId, e);
        } finally {
            DB.close(rs, ps);
        }
    }


    private static class TabInfo {
        private final int adWindowId;
        private final int adTableId;
        private final boolean readOnly;
        private final boolean alwaysUpdateable;
        private final boolean isSOTrx;

        private TabInfo(int adWindowId, int adTableId, boolean readOnly, boolean alwaysUpdateable, boolean isSOTrx) {
            this.adWindowId = adWindowId;
            this.adTableId = adTableId;
            this.readOnly = readOnly;
            this.alwaysUpdateable = alwaysUpdateable;
            this.isSOTrx = isSOTrx;
        }
    }


}
