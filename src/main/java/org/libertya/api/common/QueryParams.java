package org.libertya.api.common;

public class QueryParams {

    protected String filter = null;
    protected String fields = null;
    protected String sort = null;
    protected Integer limit = null;
    protected Integer page = null;

    public QueryParams() {}

    public QueryParams(String filter, String fields, String sort, Integer limit, Integer page) {
        this.filter = filter;
        this.fields = fields;
        this.sort = sort;
        this.limit = limit;
        this.page = page;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

}
