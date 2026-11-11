# Write your MySQL query statement below
# Write your MySQL query statement below
WITH CTE as(
    select *,
        SUM(weight) OVER(ORDER BY turn) as rt
    from queue
)

select person_name
from cte
where rt <= 1000
order by rt desc
limit 1