select columnname from
(
    (
        select 1 as row, e'components:\n  schemas:\n    '||:v1||e':\n      type: object\n      properties:' as columnname
    )
    union
    (
    select 1000 + row_number() over () as row,
        e'        ' || lower(c.columnname) || e':\n          ' ||
            case
                when ad_reference_id in (10, 14, 17, 34, 36) then e'type: string' -- varchars
                when ad_reference_id in (11, 13, 18, 19, 30, 21, 31, 35) then e'type: integer' -- integers
                when ad_reference_id in (12, 22, 37, 11, 29) then e'type: number' -- numberics
                when ad_reference_id in (15, 16, 24) then e'type: string' -- date-time considered string for swagger
                when ad_reference_id in (20) then e'type: boolean' -- Y/N
            end
    from ad_column c
    inner join ad_table t on c.ad_table_id = t.ad_table_id
    where t.tablename = :v2
    and ad_reference_id <> 28 -- button no es necesario enviar
    and ad_reference_id not in (23, 32) -- LOB por el momento no
    order by c.columnname
    )
) as foobar
order by row asc