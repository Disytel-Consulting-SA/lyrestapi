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
            String key = tableName + "_ID";
            String sql = "SELECT 1 FROM " + tableName + " WHERE " + key + "=? AND (" + recordWhere + ")";
            try (PreparedStatement ps = DB.prepareStatement(sql, null)) {
                ps.setInt(1, aPO.getID());
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next())
                        throw new AuthException("Acceso de lectura no autorizado al registro");
                }
            } catch (SQLException e) {
                throw new AuthException("No fue posible verificar el acceso al registro");
            }
        }
        return aPO;
    }
}
