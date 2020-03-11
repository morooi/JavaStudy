# 进阶 5：分组查询

/*
语法：

select 查询列表
from 表
[where 筛选条件]
group by 分组的字段
[order by 排序的字段];

特点：
1. 和分组函数一同查询的字段必须是 group by 后出现的字段
2. 筛选分为两类: 分组前筛选和分组后筛选
    针对的表               位置                连接的关键字
    分组前筛选             原始表           group by 前  where
    分组后筛选       group by 后的结果集     group by 后  having

问题 1 : 分组函数做筛选能不能放在 where 后面
    不能

问题 2: where--group by--having
    一般来讲, 能用分组前筛选的, 尽量使用分组前筛选, 提高效率

3. 分组可以按单个字段也可以按多个字段
4. 可以搭配着排序使用
*/

USE myemployees;

# 1.简单的分组
# 案例 1: 查询每个工种的员工平均工资
SELECT AVG(salary), job_id
FROM employees
GROUP BY job_id;

# 案例 2: 查询每个位置的部门个数
SELECT COUNT(*), location_id
FROM departments
GROUP BY location_id;

# 2. 可以实现分组前的筛选
# 案例 1: 查询邮箱中包含 a 字符的, 每个部门的最高工资
SELECT max(salary), department_id
FROM employees
WHERE email LIKE '%a%'
GROUP BY department_id;

# 案例2：查询有奖金的每个领导手下员工的平均工资
SELECT avg(salary), manager_id
FROM employees
WHERE commission_pct IS NOT NULL
GROUP BY manager_id;

# 3、分组后筛选
# 案例：查询哪个部门的员工个数 > 5

# ① 查询每个部门的员工个数
SELECT count(*), department_id
FROM employees
GROUP BY department_id;

# ② 筛选刚才①结果
SELECT count(*), department_id
FROM employees
GROUP BY department_id
HAVING count(*) > 5;

# 案例 2: 每个工种有奖金的员工的最高工资 > 12000 的工种编号和最高工资
SELECT job_id, max(salary)
FROM employees
WHERE commission_pct IS NOT NULL
GROUP BY job_id
HAVING max(salary) > 12000;

# 案例 3: 领导编号 > 102 的每个领导手下的最低工资大于 5000 的领导编号和最低工资
SELECT min(salary), manager_id
FROM employees
WHERE manager_id > 102
GROUP BY manager_id
HAVING min(salary) > 5000;

# 4. 添加排序
# 案例: 每个工种有奖金的员工的最高工资 > 6000 的工种编号和最高工资, 按最高工资升序
SELECT max(salary), job_id
FROM employees
WHERE commission_pct IS NOT NULL
GROUP BY job_id
HAVING max(salary) > 6000
ORDER BY max(salary);

# 或
SELECT job_id, MAX(salary) m
FROM employees
WHERE commission_pct IS NOT NULL
GROUP BY job_id
HAVING m > 6000
ORDER BY m;

# 5. 按多个字段分组
# 案例: 查询每个工种每个部门的最低工资, 并按最低工资降序
SELECT min(salary), job_id, department_id
FROM employees
GROUP BY job_id, department_id
ORDER BY min(salary) DESC;

# 6. 按表达式或函数分组
# 案例: 按员工姓名的长度分组, 查询每一组的员工个数, 筛选员工个数 > 5 的有哪些
SELECT count(*), length(last_name)
FROM employees
GROUP BY length(last_name)
HAVING count(*) > 5;

# 练习1: 查询各个管理者手下员工的最低工资, 其中最低工资不能低于 6000, 没有管理者的员工不计算
SELECT min(salary) min,
       manager_id
FROM employees
WHERE manager_id IS NOT NULL
GROUP BY manager_id
HAVING min >= 6000;

# 练习2: 查询所有部门的编号, 员工数量, 工资平均值, 并按工资平均值降序
SELECT count(*),
       round(avg(salary), 2),
       department_id
FROM employees
GROUP BY department_id
ORDER BY avg(salary) DESC;
