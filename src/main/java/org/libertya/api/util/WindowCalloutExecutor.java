package org.libertya.api.util;

import org.libertya.api.common.UserInfo;
import org.libertya.api.stub.model.WindowCalloutRequest;
import org.libertya.api.stub.model.WindowCalloutResponse;
import org.openXpertya.model.MField;
import org.openXpertya.model.MTab;
import org.openXpertya.model.MTable;
import org.openXpertya.model.MWindow;
import org.openXpertya.model.MWindowVO;
import org.openXpertya.model.M_Table;
import org.openXpertya.util.DB;
import org.openXpertya.util.DisplayType;
import org.openXpertya.util.Env;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class WindowCalloutExecutor {

    private static final AtomicInteger NEXT_WINDOW_NO = new AtomicInteger(1000);

    public WindowCalloutResponse execute(UserInfo info, int adTabId, WindowCalloutRequest request) {

        if (request == null || request.getAdFieldId() == null || request.getValues() == null) {
            throw new IllegalArgumentException("Se requieren ad_field_id y values");
        }

        boolean inserting = Boolean.TRUE.equals(request.isInserting());

        if (!inserting && (request.getRecordIds() == null || request.getRecordIds().isEmpty())) {
            throw new IllegalArgumentException("Se requieren record_ids para ejecutar un callout sobre un registro existente");
        }

        int adWindowId = findWindowId(adTabId);
        if (!info.hasRole()) {
            throw new SecurityException("El token no contiene roleID");
        }

        int windowNo = NEXT_WINDOW_NO.getAndIncrement();
        MWindowVO vo = MWindowVO.create(info.getCtx(), windowNo, adWindowId);
        if (vo == null) {
            throw new SecurityException("El rol " + info.getRoleID() + " no tiene acceso a AD_Window_ID=" + adWindowId);
        }

        MWindow window = new MWindow(vo);
        try {
            MTab tab = findTab(window, adTabId);
            if (tab.isDetail()) {
                throw new IllegalArgumentException("Las pestanas hijas requieren contexto del registro padre");
            }

            MField changedField = findField(tab, request.getAdFieldId());
            String changedColumn = changedField.getColumnName();

            tab.query(false, 0);
            if (!tab.isOpen()) {
                throw new IllegalStateException("No se pudo abrir AD_Tab_ID=" + adTabId);
            }

            MTable table = tab.getTableModel();

            if (inserting) {
                if (!tab.dataNew(false)) {
                    throw new IllegalStateException("No se pudo crear una fila temporal para AD_Tab_ID=" + adTabId);
                }
            } else {
                M_Table metadataTable = M_Table.get(info.getCtx(), tab.getTableName());
                List<String> keyColumns = metadataTable.getKeyColumns();
                List<String> recordIds = request.getRecordIds();

                if (keyColumns.size() != recordIds.size()) {
                    throw new IllegalArgumentException(
                            "Cantidad de valores de clave invalida para " + tab.getTableName()
                                    + ": se esperaban " + keyColumns.size()
                                    + " y se recibieron " + recordIds.size());
                }

                int targetRow = -1;

                for (int row = 0; row < tab.getRowCount(); row++) {
                    boolean matches = true;

                    for (int keyIndex = 0; keyIndex < keyColumns.size(); keyIndex++) {
                        String columnName = keyColumns.get(keyIndex);
                        int column = table.findColumn(columnName);

                        if (column < 0) {
                            throw new IllegalStateException(
                                    "La columna clave " + columnName + " no pertenece a AD_Tab_ID=" + adTabId);
                        }

                        Object rowValue = table.getValueAt(row, column);
                        String expectedValue = recordIds.get(keyIndex);

                        if (!Objects.equals(rowValue == null ? null : String.valueOf(rowValue), expectedValue)) {
                            matches = false;
                            break;
                        }
                    }

                    if (matches) {
                        targetRow = row;
                        break;
                    }
                }

                if (targetRow < 0) {
                    throw new NoSuchElementException(
                            "No se encontro el registro " + recordIds + " en AD_Tab_ID=" + adTabId);
                }

                tab.navigate(targetRow);
            }

            // Reconstruir sobre MTab el estado actual recibido desde el frontend.
            // Se usa directamente MTable para no disparar callouts durante esta reconstruccion.
            for (Map.Entry<String, Object> entry : request.getValues().entrySet()) {
                String columnName = entry.getKey();

                if (changedColumn.equals(columnName)) {
                    continue;
                }

                MField field = tab.getField(columnName);
                int column = table.findColumn(columnName);

                if (field == null || column < 0) {
                    throw new IllegalArgumentException("Columna ajena a la pestana: " + columnName);
                }

                table.setValueAt(
                        toCoreValue(field, entry.getValue()),
                        tab.getCurrentRow(),
                        column,
                        false);
            }

            int orgColumn = table.findColumn("AD_Org_ID");
            if (orgColumn >= 0
                    && table.getValueAt(tab.getCurrentRow(), orgColumn) == null
                    && info.getOrgID() > 0) {
                table.setValueAt(info.getOrgID(), tab.getCurrentRow(), orgColumn, false);
            }

            if (!changedField.isEditable(true)) {
                throw new IllegalArgumentException("Campo no editable: " + request.getAdFieldId());
            }

            Map<String, Object> before = snapshot(tab);

            // Esta asignacion se realiza mediante MTab.setValue porque es la que debe disparar el callout.
            String message = tab.setValue(
                    changedColumn,
                    toCoreValue(changedField, request.getValue()));

            if (message != null && (message.startsWith("Cannot invoke ")
                    || message.startsWith("Callout Invalid: ")
                    || message.startsWith("java.lang."))) {
                throw new IllegalStateException("Fallo tecnico del callout " + changedColumn + ": " + message);
            }

            Map<String, Object> after = snapshot(tab);

            Map<String, Object> changes = new LinkedHashMap<>();
            for (Map.Entry<String, Object> entry : after.entrySet()) {
                String columnName = entry.getKey();

                if (!changedColumn.equals(columnName)
                        && !Objects.equals(before.get(columnName), entry.getValue())) {
                    changes.put(columnName, entry.getValue());
                }
            }

            WindowCalloutResponse response = new WindowCalloutResponse();
            response.setChanges(changes);
            response.setMessage(message);
            return response;

        } finally {
            window.dispose();
            Env.clearWinContext(info.getCtx(), windowNo);
        }
    }

    private int findWindowId(int adTabId) {
        String sql = "SELECT ad_window_id FROM ad_tab WHERE ad_tab_id = ? AND isactive = 'Y'";
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            statement = DB.prepareStatement(sql, null);
            statement.setInt(1, adTabId);
            result = statement.executeQuery();

            if (!result.next()) {
                throw new NoSuchElementException("No existe AD_Tab_ID=" + adTabId);
            }

            return result.getInt(1);

        } catch (NoSuchElementException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalStateException("Error recuperando AD_Tab_ID=" + adTabId, e);
        } finally {
            DB.close(result, statement);
        }
    }

    private MTab findTab(MWindow window, int adTabId) {
        for (int i = 0; i < window.getTabCount(); i++) {
            MTab tab = window.getTab(i);

            if (tab.getAD_Tab_ID() == adTabId) {
                return tab;
            }
        }

        throw new SecurityException("El rol no tiene acceso a AD_Tab_ID=" + adTabId);
    }

    private MField findField(MTab tab, int adFieldId) {
        for (MField field : tab.getFields()) {
            if (field.getAD_Field_ID() == adFieldId) {
                return field;
            }
        }

        throw new NoSuchElementException(
                "Campo ajeno a AD_Tab_ID=" + tab.getAD_Tab_ID() + ": " + adFieldId);
    }

    private Map<String, Object> snapshot(MTab tab) {
        Map<String, Object> values = new LinkedHashMap<>();
        MTable table = tab.getTableModel();

        for (MField field : tab.getFields()) {
            int column = table.findColumn(field.getColumnName());

            if (column >= 0) {
                values.put(
                        field.getColumnName(),
                        table.getValueAt(tab.getCurrentRow(), column));
            }
        }

        return values;
    }

    private Object toCoreValue(MField field, Object value) {
        if (value == null) {
            return null;
        }

        int type = field.getDisplayType();

        try {
            if (type == DisplayType.YesNo) {
                if (value instanceof Boolean) {
                    return value;
                }

                if ("Y".equals(value) || "N".equals(value)) {
                    return "Y".equals(value);
                }

            } else if (DisplayType.isID(type) || type == DisplayType.Integer) {
                return new BigDecimal(value.toString()).intValueExact();

            } else if (DisplayType.isNumeric(type)) {
                return new BigDecimal(value.toString());

            } else if ((type == DisplayType.Date || type == DisplayType.DateTime || type == DisplayType.Time)
                    && value instanceof String) {
                String date = (String) value;

                if (date.endsWith("Z")) {
                    return Timestamp.from(Instant.parse(date));
                }

                if (date.length() == 10) {
                    return Timestamp.valueOf(LocalDate.parse(date).atStartOfDay());
                }

                return Timestamp.valueOf(date.replace('T', ' '));

            } else {
                return value;
            }

        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Valor invalido para " + field.getColumnName(), e);
        }

        throw new IllegalArgumentException("Valor invalido para " + field.getColumnName());
    }
}