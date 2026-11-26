package org.libertya.api.security;

import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.openXpertya.model.MRole;
import org.openXpertya.model.M_Table;
import org.openXpertya.util.DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.openXpertya.model.PO;

/**
 * Validacion de acceso a registros recuperados por la API.
 *
 * El contexto de autenticacion (/token) puede no tener UserInfo. Para las
 * operaciones autenticadas, se verifica el alcance del token y, cuando hay
 * un rol seleccionado, los permisos de lectura definidos por CORE.
 */
public class ClientOrgAuth {

    /**
     * Comprueba permisos de escritura sobre la tabla y el alcance del registro.
     * Para registros existentes también aplica las restricciones de registro del rol.
     */
    public static void validateWrite(UserInfo info, PO po, boolean existing) throws AuthException {
        if (info == null || po == null || !info.hasRole())
            throw new AuthException("Se requiere un rol para escribir registros");
        MRole role = MRole.get(info.getCtx(), info.getRoleID(), info.getUserID(), false);
        if (role == null || !role.isTableAccess(po.get_Table_ID(), false))
            throw new AuthException("Acceso de escritura no autorizado a la tabla");
        int clientId = po.getAD_Client_ID();
        int orgId = po.getAD_Org_ID();
        if ((info.getClientID() > 0 && clientId != 0 && clientId != info.getClientID())
                || !role.isClientAccess(clientId, false)
                || !role.isOrgAccess(orgId, false))
            throw new AuthException("Acceso de escritura no autorizado a compañía u organización");
        if (existing) {
            String tableName = po.get_TableName();
            M_Table table = M_Table.get(info.getCtx(), tableName);
            String restriction = RecordAccessFilter.where(role, table, tableName);
            if (!"1=1".equals(restriction)) {
                validateRecordRestriction(po, table, restriction);

            }
        }
    }

    public static PO validate(UserInfo info, PO aPO) throws AuthException {
        if (info == null || aPO == null)
            return aPO;

        int clientID = aPO.getAD_Client_ID();
        int orgID = aPO.getAD_Org_ID();

        if (info.getClientID() > 0 && clientID != 0 && clientID != info.getClientID())
            throw new AuthException("Token de acceso limitado a compañía " + info.getClientID());

        // La organizacion del token es el contexto activo, no una lista de
        // organizaciones permitidas. La autorizacion real corresponde a MRole.
        if (!info.hasRole())
            return aPO;

        MRole role = MRole.get(info.getCtx(), info.getRoleID(), info.getUserID(), false);
        if (role == null)
            throw new AuthException("Rol de acceso no disponible");

        // NOTA: no usar MRole.isRecordAccess() hasta corregir su implementación
        // en CORE (dev): itera m_tableAccess e indexa m_recordAccess.
        if (!role.isClientAccess(clientID, false)
                || !role.isOrgAccess(orgID, false)
                || !role.isTableAccess(aPO.get_Table_ID(), true)) {
            throw new AuthException("Acceso de lectura no autorizado al registro");
        }
        // Comprobar la misma clausula que utilizan listados y conteos.
        String tableName = aPO.get_TableName();
        M_Table table = M_Table.get(info.getCtx(), tableName);
        String recordWhere = RecordAccessFilter.where(role, table, tableName);
        if (!"1=1".equals(recordWhere)) {
            validateRecordRestriction(aPO, table, recordWhere);
        }
        return aPO;
    }
    /**
     * CORE expresa las restricciones individuales mediante Record_ID numerico.
     * RecordAccessFilter rechaza las identidades que no pueden representarse de esa forma.
     */
    private static void validateRecordRestriction(PO po, M_Table table, String restriction) throws AuthException {
        String[] keys = table.getKeyColumnsAsArray();
        if (keys == null || keys.length != 1 || !keys[0].equalsIgnoreCase(table.getTableName() + "_ID"))
            throw new AuthException("No es posible evaluar restricciones de registro en " + table.getTableName());
        Object value = po.get_Value(keys[0]);
        if (!(value instanceof Integer))
            throw new AuthException("Identidad numerica no disponible para verificar el acceso");
        String sql = "SELECT 1 FROM " + table.getTableName() + " WHERE " + keys[0] + "=? AND (" + restriction + ")";
        try (PreparedStatement ps = DB.prepareStatement(sql, po.get_TrxName())) {
            ps.setObject(1, value);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next())
                    throw new AuthException("Acceso no autorizado al registro");
            }
        } catch (SQLException e) {
            throw new AuthException("No fue posible verificar el acceso al registro");
        }
    }
}
