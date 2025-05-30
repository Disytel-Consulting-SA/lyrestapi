select columnname from
(
    (
        select 1 as row,
            e'components:\n  schemas:\n    '||:nombre||e':\n      type: object\n      properties:' as columnname
    )
    union
    (
        select 1000 + row_number() over () as row,
            e'        ' || lower(c.columnname) || e':\n          ' ||
                case
                    when ad_reference_id in (10, 14, 17, 34, 36, 28) then e'type: string' -- varchars
                    when ad_reference_id in (11, 13, 18, 19, 30, 21, 31, 35) then e'type: integer' -- integers
                    when ad_reference_id in (12, 22, 37, 11, 29) then e'type: number' -- numberics
                    when ad_reference_id in (15, 16, 24) then e'type: string' -- date-time considered string for swagger
                    when ad_reference_id in (20) then e'type: boolean' -- Y/N
                end || e'\n' ||
            e'          description: "' || replace(coalesce(e_trl.description, ' '), '"', '\"') || '"'
        from ad_column c
        inner join ad_table t on c.ad_table_id = t.ad_table_id
        inner join ad_element e on c.ad_element_id = e.ad_element_id
        inner join ad_element_trl e_trl on e.ad_element_id = e_trl.ad_element_id and ad_language = 'es_AR'
        where lower(t.tablename) = lower(:tabla)
        and c.isactive = 'Y'
        and c.ad_reference_id not in (23, 32) -- LOB por el momento no
        and (c.ismandatory = 'Y' or lower(c.columnname) in :columnas)
        order by c.columnname
    )
    union
    (
        select 2000 as row,
            e'        additionalvalues:\n          type: array\n          items:\n            $ref: ''./propertiesmap.yaml#/propertiesmap''' as columnname
    )
    union
    (
        select 3000 as row,
            e'        referencedvalues:\n          type: array\n          items:\n            $ref: ''./propertiesmap.yaml#/propertiesmap''' as columnname
    )
    union
    (
        select 4000 + row_number() over () as row,
            e'      required:' as columnname
    )
    union
    (
        select 5000 + row_number() over () as row,
            e'         - ' || lower(c.columnname)
        from ad_column c
        inner join ad_table t on c.ad_table_id = t.ad_table_id
        where lower(t.tablename) = lower(:tabla)
        and c.isactive = 'Y'
        and c.ad_reference_id not in (23, 32) -- LOB por el momento no
        and (c.ismandatory = 'Y' or lower(c.columnname) in :columnas)
        and c.ismandatory = 'Y'
        order by c.columnname
    )
) as foobar
order by row asc
