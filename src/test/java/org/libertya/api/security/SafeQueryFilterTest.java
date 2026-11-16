package org.libertya.api.security;

import org.junit.jupiter.api.Test;
import org.libertya.api.exception.ModelException;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SafeQueryFilterTest {
    private final Map<String, String> columns = new HashMap<>();
    SafeQueryFilterTest() {
        columns.put("name", "Name");
        columns.put("ad_client_id", "AD_Client_ID");
        columns.put("isactive", "IsActive");
        columns.put("grandtotal", "GrandTotal");
    }

    @Test
    void bindsValuesAndPreservesBooleanGrouping() throws Exception {
        SafeQueryFilter.Compiled filter = SafeQueryFilter.compile(
                "name ILIKE '%cli%' AND (isactive='Y' OR grandtotal >= 100.25)", columns);
        assertEquals(3, filter.values.size());
        assertEquals(Arrays.asList("%cli%", "Y", new java.math.BigDecimal("100.25")), filter.values);
        assertTrue(filter.sql.contains("Name ILIKE ?"));
        assertTrue(filter.sql.contains("GrandTotal >= ?"));
    }

    @Test
    void escapedQuotesRemainData() throws Exception {
        SafeQueryFilter.Compiled filter = SafeQueryFilter.compile("name='O''Brien'", columns);
        assertEquals("O'Brien", filter.values.get(0));
        assertEquals("Name = ?", filter.sql);
    }

    @Test
    void rejectsInjectionAndUnknownColumns() {
        assertThrows(ModelException.class, () -> SafeQueryFilter.compile("name='x' OR 1=1", columns));
        assertThrows(ModelException.class, () -> SafeQueryFilter.compile("name='x'; DROP TABLE AD_User", columns));
        assertThrows(ModelException.class, () -> SafeQueryFilter.compile("name='x' -- comment", columns));
        assertThrows(ModelException.class, () -> SafeQueryFilter.compile("password='x'", columns));
        assertThrows(ModelException.class, () -> SafeQueryFilter.compile("name IN (SELECT Name FROM AD_User)", columns));
    }

    @Test
    void acceptsDocumentedQuotedFilters() throws Exception {
        SafeQueryFilter.Compiled filter = SafeQueryFilter.compile(
                "\"ad_client_id IN (0, 101) AND isactive='Y'\"", columns);
        assertEquals(Arrays.asList(new java.math.BigDecimal("0"),
                new java.math.BigDecimal("101"), "Y"), filter.values);
        assertTrue(filter.sql.contains("AD_Client_ID IN (?, ?)"));
    }

    @Test
    void rejectsInjectionInsideQuotedFilter() {
        assertThrows(ModelException.class, () ->
                SafeQueryFilter.compile("\"name='x'; DROP TABLE AD_User\"", columns));
        assertThrows(ModelException.class, () ->
                SafeQueryFilter.compile("\"name='x'\" OR 1=1", columns));
    }

    @Test
    void supportsInNullAndBetween() throws Exception {
        SafeQueryFilter.Compiled filter = SafeQueryFilter.compile(
                "ad_client_id IN (0, 101) AND grandtotal BETWEEN 1 AND 100 AND name IS NOT NULL", columns);
        assertEquals(4, filter.values.size());
        assertTrue(filter.sql.contains("AD_Client_ID IN (?, ?)"));
        assertTrue(filter.sql.contains("Name IS NOT NULL"));
    }

    /* Columnas derivadas (p. ej. M_Warehouse_ID en M_Storage) */

    private final Map<String, SafeQueryFilter.DerivedColumn> derived = Collections.singletonMap("m_warehouse_id",
            new SafeQueryFilter.DerivedColumn("M_Locator_ID IN (SELECT l.M_Locator_ID FROM M_Locator l "
                    + "WHERE l.M_Warehouse_ID IN (" + SafeQueryFilter.DerivedColumn.VALUES + "))"));

    @Test
    void derivedColumnRendersFixedSqlWithBoundValues() throws Exception {
        SafeQueryFilter.Compiled eq = SafeQueryFilter.compile(
                "isactive='Y' AND M_Warehouse_ID=1010048", columns, derived);
        assertEquals("(IsActive = ? AND (M_Locator_ID IN (SELECT l.M_Locator_ID FROM M_Locator l "
                + "WHERE l.M_Warehouse_ID IN (?))))", eq.sql);
        assertEquals(Arrays.asList("Y", new BigDecimal("1010048")), eq.values);

        SafeQueryFilter.Compiled in = SafeQueryFilter.compile("m_warehouse_id IN (1, 2)", columns, derived);
        assertTrue(in.sql.contains("l.M_Warehouse_ID IN (?, ?)"));
        assertEquals(Arrays.asList(new BigDecimal("1"), new BigDecimal("2")), in.values);
    }

    @Test
    void derivedColumnAcceptsOnlyNumbersWithEqualsOrIn() {
        assertThrows(ModelException.class, () -> SafeQueryFilter.compile("m_warehouse_id='1'", columns, derived));
        assertThrows(ModelException.class, () -> SafeQueryFilter.compile("m_warehouse_id>1", columns, derived));
        assertThrows(ModelException.class, () -> SafeQueryFilter.compile("m_warehouse_id NOT IN (1)", columns, derived));
        assertThrows(ModelException.class, () -> SafeQueryFilter.compile("m_warehouse_id IS NULL", columns, derived));
        assertThrows(ModelException.class, () ->
                SafeQueryFilter.compile("m_warehouse_id IN (SELECT M_Warehouse_ID FROM M_Warehouse)", columns, derived));
        // Sin la columna derivada registrada, sigue siendo una columna desconocida.
        assertThrows(ModelException.class, () -> SafeQueryFilter.compile("m_warehouse_id=1", columns));
    }

    @Test
    void derivedColumnTemplateNeedsValuesPlaceholderOnce() {
        assertThrows(IllegalArgumentException.class, () -> new SafeQueryFilter.DerivedColumn("M_Locator_ID = 1"));
        assertThrows(IllegalArgumentException.class, () -> new SafeQueryFilter.DerivedColumn(
                "A IN ({values}) OR B IN ({values})"));
    }

    /* Ligado de valores */

    @Test
    void bindsTextUntypedSoPostgresUsesTheColumnType() throws Exception {
        SafeQueryFilter.Compiled filter = SafeQueryFilter.compile(
                "name > '2026-11-01' AND grandtotal = 5 AND isactive = true", columns);
        PreparedStatement ps = mock(PreparedStatement.class);
        assertEquals(6, filter.bind(ps, 3));
        verify(ps).setObject(3, "2026-11-01", Types.OTHER, 0);
        verify(ps).setObject(4, new BigDecimal("5"));
        verify(ps).setObject(5, Boolean.TRUE);
        verifyNoMoreInteractions(ps);
    }
}
