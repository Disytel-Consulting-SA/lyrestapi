package org.libertya.api.repository;

import org.libertya.api.common.UserInfo;
import org.libertya.api.repository.DynamicLookupResolver.DynamicLookupInfo;
import org.libertya.api.stub.model.ColumnLookupValue;
import org.openXpertya.util.DB;
import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@Repository
public class ProcessParameterLookupRepository {
    private static final int DEFAULT_LIMIT = 50;
    private static final int DEFAULT_PAGE = 1;
    private final DynamicLookupResolver resolver = new DynamicLookupResolver();

    public List<ColumnLookupValue> retrieve(UserInfo info, Integer processId, Integer parameterId, Integer limit, Integer page, String search, String value, Map<String, String> contextValues) {
        DynamicLookupInfo lookup = loadParameterInfo(processId, parameterId);
        if (lookup == null) return null;
        int effectiveLimit = limit != null && limit > 0 ? limit : DEFAULT_LIMIT;
        int effectivePage = page != null && page > 0 ? page : DEFAULT_PAGE;
        return resolver.retrieve(info, lookup, effectiveLimit, effectivePage, search, value, contextValues);
    }

    private DynamicLookupInfo loadParameterInfo(Integer processId, Integer parameterId) {
        String sql = " SELECT pp.columnname, pp.ad_reference_id, pp.ad_reference_value_id, pp.ad_val_rule_id, vr.code AS validation_code FROM ad_process_para pp LEFT JOIN ad_val_rule vr ON vr.ad_val_rule_id = pp.ad_val_rule_id AND vr.isactive = 'Y' WHERE pp.ad_process_id = ? AND pp.ad_process_para_id = ? AND pp.isactive = 'Y' ";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = DB.prepareStatement(sql, null); ps.setInt(1, processId); ps.setInt(2, parameterId); rs = ps.executeQuery();
            if (!rs.next()) return null;
            return new DynamicLookupInfo("parametro de proceso " + parameterId, rs.getString("columnname"), rs.getInt("ad_reference_id"), nullableInt(rs, "ad_reference_value_id"), nullableInt(rs, "ad_val_rule_id"), rs.getString("validation_code"));
        } catch (Exception e) {
            throw new RuntimeException("Error recuperando metadata de AD_Process_Para " + parameterId, e);
        } finally { DB.close(rs, ps); }
    }

    private Integer nullableInt(ResultSet rs, String column) throws Exception {
        int result = rs.getInt(column);
        return rs.wasNull() ? null : result;
    }
}
