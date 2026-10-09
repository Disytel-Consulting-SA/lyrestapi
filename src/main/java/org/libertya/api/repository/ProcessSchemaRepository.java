package org.libertya.api.repository;

import org.libertya.api.common.UserInfo;
import org.libertya.api.stub.model.ProcessSchema;
import org.libertya.api.stub.model.ProcessSchemaParameter;
import org.libertya.api.stub.model.ProcessSchemaReference;
import org.libertya.api.stub.model.ProcessSchemaReferenceValue;
import org.libertya.api.util.WindowFieldDefaultResolver;
import org.openXpertya.util.DB;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

@Repository
public class ProcessSchemaRepository {
    private static final String DEFAULT_LANGUAGE = "es_AR";

    public ProcessSchema retrieve(UserInfo info, Integer processId, String language) {
        String effectiveLanguage = language != null && !language.trim().isEmpty() ? language.trim() : DEFAULT_LANGUAGE;
        String sql = "SELECT p.ad_process_id, COALESCE(pt.name,p.name) process_name, COALESCE(pt.description,p.description) process_description, COALESCE(pt.help,p.help) process_help, " +
                "pp.ad_process_para_id, COALESCE(ppt.name,pp.name) para_name, COALESCE(ppt.description,pp.description) para_description, COALESCE(ppt.help,pp.help) para_help, " +
                "pp.seqno, pp.columnname, pp.ad_reference_id, pp.ad_reference_value_id, pp.ad_val_rule_id, pp.ismandatory, pp.isrange, pp.sameline, pp.isreadonly, " +
                "pp.callout, pp.calloutalsoonload, pp.defaultvalue, pp.defaultvalue2, pp.displaylogic, pp.readonlylogic, pp.fieldlength, pp.vformat, pp.valuemin, pp.valuemax " +
                "FROM ad_process p LEFT JOIN ad_process_trl pt ON pt.ad_process_id=p.ad_process_id AND pt.ad_language=? " +
                "LEFT JOIN ad_process_para pp ON pp.ad_process_id=p.ad_process_id AND pp.isactive='Y' " +
                "LEFT JOIN ad_process_para_trl ppt ON ppt.ad_process_para_id=pp.ad_process_para_id AND ppt.ad_language=? " +
                "WHERE p.ad_process_id=? AND p.isactive='Y' ORDER BY pp.seqno, pp.ad_process_para_id";

        try (PreparedStatement ps = DB.prepareStatement(sql, null)) {
            ps.setString(1, effectiveLanguage);
            ps.setString(2, effectiveLanguage);
            ps.setInt(3, processId);

            try (ResultSet rs = ps.executeQuery()) {
                ProcessSchema schema = null;

                while (rs.next()) {
                    if (schema == null) {
                        schema = new ProcessSchema().processId(rs.getInt("ad_process_id")).name(rs.getString("process_name"))
                                .description(rs.getString("process_description")).help(rs.getString("process_help"));
                    }

                    Integer paraId = getNullableInteger(rs, "ad_process_para_id");
                    if (paraId == null) continue;

                    Integer referenceId = getNullableInteger(rs, "ad_reference_id");
                    String columnName = rs.getString("columnname");
                    String defaultValue = WindowFieldDefaultResolver.resolveExplicit(info, referenceId, columnName, rs.getString("defaultvalue"));
                    String defaultValue2 = WindowFieldDefaultResolver.resolveExplicit(info, referenceId, columnName, rs.getString("defaultvalue2"));
                    String type = ReferenceMetadataResolver.resolveType(referenceId);

                    ProcessSchemaParameter parameter = new ProcessSchemaParameter().processParaId(paraId).name(rs.getString("para_name"))
                            .description(rs.getString("para_description")).help(rs.getString("para_help")).seqno(getNullableInteger(rs, "seqno"))
                            .columnname(columnName).adReferenceId(referenceId).adReferenceValueId(getNullableInteger(rs, "ad_reference_value_id"))
                            .adValRuleId(getNullableInteger(rs, "ad_val_rule_id")).ismandatory(isYes(rs.getString("ismandatory")))
                            .isrange(isYes(rs.getString("isrange"))).issameline(isYes(rs.getString("sameline"))).isreadonly(isYes(rs.getString("isreadonly")))
                            .hasCallout(!isEmpty(rs.getString("callout"))).calloutalsoonload(isYes(rs.getString("calloutalsoonload")))
                            .defaultvalue(defaultValue).defaultvalue2(defaultValue2).displaylogic(rs.getString("displaylogic"))
                            .readonlylogic(rs.getString("readonlylogic")).fieldlength(getNullableInteger(rs, "fieldlength")).vformat(rs.getString("vformat"))
                            .valuemin(rs.getString("valuemin")).valuemax(rs.getString("valuemax"));

                    if (type != null) parameter.reference(new ProcessSchemaReference().type(type));
                    schema.addParametersItem(parameter);
                }

                if (schema != null && schema.getParameters() != null) resolveReferences(schema, processId, effectiveLanguage);
                return schema;
            }
        } catch (Exception e) {
            throw new IllegalStateException("Error recuperando schema del proceso " + processId, e);
        }
    }

    private void resolveReferences(ProcessSchema schema, Integer processId, String language) {
        Set<Integer> listReferenceIds = new HashSet<>();
        for (ProcessSchemaParameter parameter : schema.getParameters()) {
            Integer referenceId = parameter.getAdReferenceId();
            if (referenceId != null && referenceId == ReferenceMetadataResolver.REFERENCE_LIST && parameter.getAdReferenceValueId() != null) {
                listReferenceIds.add(parameter.getAdReferenceValueId());
            }
        }

        Map<Integer, List<ProcessSchemaReferenceValue>> listValues = loadListReferenceValues(listReferenceIds, language);

        for (ProcessSchemaParameter parameter : schema.getParameters()) {
            Integer referenceId = parameter.getAdReferenceId();
            String type = ReferenceMetadataResolver.resolveType(referenceId);
            if (type == null) continue;

            ProcessSchemaReference reference = new ProcessSchemaReference().type(type);

            if (referenceId == ReferenceMetadataResolver.REFERENCE_TABLE ||
                    referenceId == ReferenceMetadataResolver.REFERENCE_TABLE_DIRECT ||
                    referenceId == ReferenceMetadataResolver.REFERENCE_SEARCH) {
                reference.endpoint("/v1.0/processes/" + processId + "/parameters/" + parameter.getProcessParaId() + "/lookup");
            }

            if (referenceId == ReferenceMetadataResolver.REFERENCE_LIST && parameter.getAdReferenceValueId() != null) {
                List<ProcessSchemaReferenceValue> values = listValues.get(parameter.getAdReferenceValueId());
                if (values != null) reference.values(values);
            }

            parameter.reference(reference);
        }
    }

    private Map<Integer, List<ProcessSchemaReferenceValue>> loadListReferenceValues(Set<Integer> referenceIds, String language) {
        Map<Integer, List<ProcessSchemaReferenceValue>> result = new HashMap<>();
        if (referenceIds.isEmpty()) return result;

        StringJoiner placeholders = new StringJoiner(",");
        for (int i = 0; i < referenceIds.size(); i++) placeholders.add("?");

        String sql = "SELECT rl.ad_reference_id, rl.value, COALESCE(rlt.name,rl.name) AS name " +
                "FROM ad_ref_list rl LEFT JOIN ad_ref_list_trl rlt ON rlt.ad_ref_list_id=rl.ad_ref_list_id AND rlt.ad_language=? " +
                "WHERE rl.isactive='Y' AND rl.ad_reference_id IN (" + placeholders + ") ORDER BY rl.ad_reference_id, name";

        try (PreparedStatement ps = DB.prepareStatement(sql, null)) {
            int index = 1;
            ps.setString(index++, language);
            for (Integer referenceId : referenceIds) ps.setInt(index++, referenceId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Integer referenceId = rs.getInt("ad_reference_id");
                    ProcessSchemaReferenceValue value = new ProcessSchemaReferenceValue().value(rs.getString("value")).name(rs.getString("name"));
                    result.computeIfAbsent(referenceId, key -> new ArrayList<>()).add(value);
                }
            }
            return result;
        } catch (Exception e) {
            throw new IllegalStateException("Error recuperando valores de AD_Ref_List para schema de proceso", e);
        }
    }

    private static Integer getNullableInteger(ResultSet rs, String column) throws Exception {
        int value = rs.getInt(column);
        return rs.wasNull() ? null : value;
    }

    private static boolean isYes(String value) { return "Y".equals(value); }
    private static boolean isEmpty(String value) { return value == null || value.trim().isEmpty(); }
}
