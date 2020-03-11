USE myemployees;

# 进阶3: 排序查询
/*
语法：
select 查询列表
from 表名
(where  筛选条件)
order by 排序的字段或表达式;

特点：
1.  asc 代表的是升序，可以省略，不写默认升序
    desc 代表的是降序
2.  order by 子句可以支持单个字段、别名、表达式、函数、多个字段
3.  order by 子句在查询语句的最后面，除了 limit 子句
*/

# 1、按单个字段排序
SELECT *
FROM employees
ORDER BY salary DESC;

# 2、添加筛选条件再排序
# 案例：查询部门编号 >= 90的员工信息，并按员工编号降序
SELECT *
FROM employees
WHERE department_id >= 90
ORDER BY employee_id DESC;

# 3、按表达式排序
# 案例：查询员工信息, 按年薪降序
SELECT *,
       salary * 12 * (1 + IFNULL(commission_pct, 0)) 年薪
FROM employees
ORDER BY salary * 12 * (1 + IFNULL(commission_pct, 0)) DESC;


# 4、按别名排序
# 案例：查询员工信息 按年薪升序
SELECT *, salary * 12 * (1 + IFNULL(commission_pct, 0)) 年薪
FROM employees
ORDER BY 年薪;

# 5、按函数排序
# 案例：查询员工名，并且按名字的长度降序
SELECT concat(last_name, ' ', first_name) name
FROM employees
ORDER BY length(concat(last_name, first_name));

# 6、按多个字段排序
# 案例：查询员工信息，要求先按工资降序，再按 employee_id 升序
SELECT *
FROM employees
ORDER BY salary DESC, employee_id;

# 测试1：查询员工的姓名和部门号和年薪，按年薪降序，按姓名升序
SELECT concat(last_name, ' ', first_name)            姓名,
       department_id,
       salary * 12 * (1 + IFNULL(commission_pct, 0)) 年薪
FROM employees
ORDER BY 年薪 DESC, 姓名;

# 测试2：选择工资不在 8000 到 17000 的员工的姓名和工资，按工资降序
SELECT concat(last_name, ' ', first_name) 姓名,
       salary
FROM employees
WHERE salary NOT BETWEEN 8000 AND 17000
ORDER BY salary DESC;

# 测试3：查询邮箱中包含 e 的员工信息，并先按邮箱的字节数降序，再按部门号升序
SELECT *
FROM employees
WHERE email LIKE '%e%'
ORDER BY length(email) DESC, department_id;
