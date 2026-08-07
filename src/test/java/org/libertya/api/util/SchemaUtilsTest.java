package org.libertya.api.util;

import org.junit.jupiter.api.Test;
import org.libertya.api.exception.ModelException;
import org.openXpertya.model.M_Column;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SchemaUtilsTest {

    @Test
    void columnResolverKeepsLegacyNameWhenThereIsNoCollision() throws Exception {
        M_Column customStatus = column(1, "Custom_Status");

        SchemaUtils.ColumnResolver resolver = new SchemaUtils.ColumnResolver(new M_Column[] { customStatus });

        assertThat(resolver.getApiName(customStatus)).isEqualTo("customstatus");
        assertThat(resolver.resolve("customstatus")).isSameAs(customStatus);
        assertThat(resolver.resolve("custom_status")).isSameAs(customStatus);
        assertThat(resolver.getColumnNameMap()).containsEntry("customstatus", customStatus);
    }

    @Test
    void columnResolverUsesExactNamesWhenLegacyNameCollides() throws Exception {
        M_Column customActionFlag = column(1020148, "Custom_Action_Flag");
        M_Column customActionButton = column(1020722, "Custom_ActionFlag");

        SchemaUtils.ColumnResolver resolver = new SchemaUtils.ColumnResolver(new M_Column[] {
                customActionButton,
                customActionFlag
        });

        assertThat(resolver.getApiName(customActionFlag)).isEqualTo("custom_action_flag");
        assertThat(resolver.getApiName(customActionButton)).isEqualTo("custom_actionflag");
        assertThat(resolver.resolve("custom_action_flag")).isSameAs(customActionFlag);
        assertThat(resolver.resolve("custom_actionflag")).isSameAs(customActionButton);
        assertThat(resolver.getColumnNameMap()).doesNotContainKey("customactionflag");
    }

    @Test
    void columnResolverRejectsAmbiguousLegacyNames() {
        M_Column customActionFlag = column(1020148, "Custom_Action_Flag");
        M_Column customActionButton = column(1020722, "Custom_ActionFlag");

        SchemaUtils.ColumnResolver resolver = new SchemaUtils.ColumnResolver(new M_Column[] {
                customActionFlag,
                customActionButton
        });

        assertThatThrownBy(() -> resolver.resolve("customactionflag"))
                .isInstanceOf(ModelException.class)
                .hasMessageContaining("Nombre de columna ambiguo")
                .hasMessageContaining("custom_action_flag")
                .hasMessageContaining("custom_actionflag");
    }

    private M_Column column(int id, String columnName) {
        M_Column column = mock(M_Column.class);
        when(column.getAD_Column_ID()).thenReturn(id);
        when(column.getColumnName()).thenReturn(columnName);
        return column;
    }
}
