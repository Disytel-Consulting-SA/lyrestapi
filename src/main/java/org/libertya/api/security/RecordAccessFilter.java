package org.libertya.api.security;

import org.libertya.api.exception.AuthException;
import org.openXpertya.model.MRole;
import org.openXpertya.model.M_Column;
import org.openXpertya.model.M_Table;

/** Restricciones de registros y privacidad de CORE, sin isRecordAccess(). */
public final class RecordAccessFilter {
    private RecordAccessFilter() {}

    public static String where(MRole role, M_Table table, String tableName) throws AuthException {
        if (role == null || table == null || tableName == null
                || !tableName.matches("[A-Za-z_][A-Za-z0-9_]*"))
            throw new AuthException("Metadatos de acceso a registros no disponibles");

        String expectedKey = tableName + "_ID";
        String key = null;
        for (M_Column column : table.getColumns(false)) {
            if (expectedKey.equalsIgnoreCase(column.getColumnName())) {
                key = column.getColumnName();
                break;
            }
        }

        // Detectar restricciones aun sin PK simple; en ese caso denegar.
        String restriction = role.getRecordWhere(table.getAD_Table_ID(),
                key == null ? "__record_access_key__" : key);
        if (restriction == null || restriction.trim().isEmpty())
            return "1=1";
        if (key == null)
            throw new AuthException("No es posible evaluar restricciones de registro en " + tableName);
        return "(" + restriction + ")";
    }
}
