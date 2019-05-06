/*rank employees based on sales all time*/
select first_name, last_name, sum(sale_total)
from employee, sales
where employee.eid = sales.eid
group by sales.eid
order by sum(sale_total) desc;

/*purchases in the past year from a particular customer (customer name, item id, name of item, date of purchase, quantity, sale total)*/
select first_name, last_name, f.iid, name, date, quantity_sold, unit_price, sale_total 
from customer c, sales s, front_inventory f 
where c.cid = 21 and c.cid = s.cid and s.iid = f.iid and date >= "2016-01-01";

/*rank employees based on sales in 2017*/
select first_name, last_name, sum(sale_total)
from employee, sales
where employee.eid = sales.eid and year(date) = '2017'
group by sales.eid
order by sum(sale_total) desc;

/*best selling item*/
select f.iid, name, count(sid) as num_sold
from front_inventory f, sales
where f.iid = sales.iid
group by sales.iid
order by count(sid) desc;

/* most sales at a store location */
select store_num, count(sid) as store_sales
from employee, sales
where employee.eid = sales.eid 
group by store_num
order by count(sid) desc;

/*money made per store location */
select store_num, sum(sale_total) as money_made
from employee, sales
where employee.eid = sales.eid 
group by store_num
order by sum(sale_total) desc;

/* employees by number of sales they've done */
select employee.eid, first_name, last_name, count(sid) as num_sales
from employee, sales
where employee.eid = sales.eid
group by employee.eid
order by count(sid) desc;

/* number of times each employee has sold each item */
select employee.eid, first_name, last_name, f.iid, name, count(sales.iid) as num_sold
from employee, front_inventory f, sales
where employee.eid = sales.eid and f.iid = sales.iid
group by employee.eid, f.iid
order by employee.eid;