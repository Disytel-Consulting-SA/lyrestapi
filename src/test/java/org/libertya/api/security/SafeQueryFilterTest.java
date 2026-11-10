package org.libertya.api.security;

import org.junit.jupiter.api.Test;
import org.libertya.api.exception.ModelException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

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
}
