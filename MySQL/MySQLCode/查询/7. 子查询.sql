# 进阶7: 子查询
/*
含义: 
出现在其他语句中的 select 语句, 称为子查询或内查询
外部的查询语句, 称为主查询或外查询

分类: 
按子查询出现的位置: 
    select 后面:
        仅仅支持标量子查询
    from 后面:
        支持表子查询
    where 或 having 后面: ★
        标量子查询(单行) √
        列子查询  (多行) √
        行子查询
    exists后面(相关子查询)
        表子查询

按结果集的行列数不同: 
    标量子查询(结果集只有一行一列)
    列子查询(结果集只有一列多行)
    行子查询(结果集有一行多列)
    表子查询(结果集一般为多行多列)
*/


# 一. where 或 having 后面
/*
1. 标量子查询(单行子查询)
2. 列子查询 (多行子查询)
3. 行子查询 (一行多列 || 多列多行)

特点: 
① 子查询放在小括号内
② 子查询一般放在条件的右侧
③ 标量子查询, 一般搭配着单行操作符使用
        > < >= <= = <>
   列子查询, 一般搭配着多行操作符使用
        in, any/some, all
④ 子查询的执行优先于主查询执行, 主查询的条件用到了子查询的结果
*/

# 1. 标量子查询★
# 案例 1: 谁的工资比 Abel 高?
USE myemployees;

SELECT last_name
FROM employees
WHERE salary > (
    SELECT salary
    FROM employees
    WHERE last_name = 'Abel'
);

# 案例 2: 返回 job_id 与 141 号员工相同, salary 比 143 号员工多的员工, 姓名, job_id, 工资
SELECT last_name, job_id, salary
FROM employees
WHERE job_id = (
    SELECT job_id
    FROM employees
    WHERE employee_id = 141
)
  AND salary > (
    SELECT salary
    FROM employees
    WHERE employee_id = 143
);

# 案例 3: 返回公司工资最少的员工的 last_name, job_id, salary
SELECT last_name, job_id, salary
FROM employees
WHERE salary = (
    SELECT min(salary)
    FROM employees
);

# 案例 4: 查询最低工资大于 50 号部门最低工资的部门 id 和其最低工资
SELECT department_id, min(salary)
FROM employees
GROUP BY department_id
HAVING min(salary) > (
    SELECT min(salary)
    FROM employees
    WHERE department_id = 50
);

# 非法使用标量子查询
SELECT MIN(salary), department_id
FROM employees
GROUP BY department_id
HAVING MIN(salary) > (
    SELECT salary
    FROM employees
    WHERE department_id = 50
);


# 2. 列子查询(多行子查询)★
# 案例 1: 返回 location_id 是 1400 或 1700 的部门中的所有员工姓名
SELECT last_name
FROM employees
WHERE department_id IN (
    SELECT DISTINCT department_id
    FROM departments d
    WHERE location_id IN (1400, 1700)
);

# 案例 2: 返回其它工种中比 job_id 为 ‘IT_PROG’ 工种任一工资低的员工的员工号, 姓名, job_id, salary
SELECT last_name, job_id, salary
FROM employees
WHERE salary < (
    SELECT max(salary)
    FROM employees
    WHERE job_id = 'IT_PROG'
)
  AND job_id != 'IT_PROG';
# 或
SELECT last_name, employee_id, job_id, salary
FROM employees
WHERE salary < ANY (
    SELECT DISTINCT salary
    FROM employees
    WHERE job_id = 'IT_PROG'
)
  AND job_id <> 'IT_PROG';

# 案例 3: 返回其它部门中比 job_id 为 ‘IT_PROG’ 部门所有工资都低的员工 的员工号, 姓名, job_id, salary
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE salary < ALL (
    SELECT DISTINCT salary
    FROM employees
    WHERE job_id = 'IT_PROG'
)
  AND job_id <> 'IT_PROG';
# 或
SELECT last_name, employee_id, job_id, salary
FROM employees
WHERE salary < (
    SELECT min(salary)
    FROM employees
    WHERE job_id = 'IT_PROG'
)
  AND job_id <> 'IT_PROG';

# 3. 行子查询(结果集一行多列或多行多列)
# 案例: 查询员工编号最小并且工资最高的员工信息
SELECT *
FROM employees
WHERE (employee_id, salary) = (
    SELECT MIN(employee_id), MAX(salary)
    FROM employees
);


# 二. select后面
# 仅仅支持标量子查询

# 案例 1: 查询每个部门的员工个数
SELECT d.*,
       (
           SELECT count(*)
           FROM employees e
           WHERE d.department_id = e.department_id
       ) 个数
FROM departments d;

# 案例 2: 查询员工号 = 102的部门名

SELECT (
           SELECT department_name
           FROM employees e
                    JOIN departments d ON e.department_id = d.department_id
           WHERE employee_id = 102
       ) 部门名;


# 三. from后面
# 将子查询结果充当一张表, 要求必须起别名

# 案例: 查询每个部门的平均工资的工资等级
SELECT department_id, avg, grade_level
FROM (SELECT avg(salary) avg, department_id
      FROM employees
      GROUP BY department_id
     ) new
         JOIN job_grades g ON avg BETWEEN lowest_sal AND highest_sal;

# 四. exists 后面(相关子查询)
/*
语法: 
exists(完整的查询语句)
结果: 1 或 0
*/

SELECT EXISTS(SELECT employee_id FROM employees WHERE salary = 300000);

# 案例 1: 查询有员工的部门名
# in
SELECT department_name
FROM departments d
WHERE d.`department_id` IN (
    SELECT department_id
    FROM employees
);

# exists
SELECT department_name
FROM departments d
WHERE exists(
              SELECT *
              FROM employees e
              WHERE e.department_id = d.department_id
          );

# 案例 2: 查询没有女朋友的男神信息
USE girls;
# exists
SELECT bo.*
FROM boys bo
WHERE NOT exists(
        SELECT boyfriend_id
        FROM beauty b
        WHERE boyfriend_id = bo.id
    );

# in
SELECT bo.*
FROM boys bo
WHERE bo.id NOT IN (
    SELECT boyfriend_id
    FROM beauty
);

# 练习
# 1. 查询和 Zlotkey 相同部门的员工姓名和工资
USE myemployees;

SELECT last_name, salary
FROM employees
WHERE department_id = (
    SELECT department_id
    FROM employees
    WHERE last_name = 'Zlotkey'
);

# 2. 查询工资比公司平均工资高的员工的员工号, 姓名, 工资
SELECT employee_id, last_name, salary
FROM employees
WHERE salary > (
    SELECT avg(salary)
    FROM employees
);

# 3. 查询各部门中工资比本部门平均工资高的员工的员工号, 姓名, 工资
SELECT employee_id, last_name, salary
FROM employees e,
     (
         SELECT avg(salary) avgs, department_id
         FROM employees
         GROUP BY department_id
     ) avg
WHERE e.department_id = avg.department_id
  AND salary > avgs;
# 或
SELECT employee_id, last_name, salary, avg.department_id
FROM employees e
         JOIN (
    SELECT department_id, avg(salary) avgs
    FROM employees
    GROUP BY department_id
) avg ON e.department_id = avg.department_id
WHERE salary > avgs;

# 4. 查询和姓名中包含字母 u 的员工在相同部门的员工的员工号和姓名
SELECT employee_id, last_name
FROM employees
WHERE department_id IN (SELECT DISTINCT department_id
                        FROM employees
                        WHERE last_name LIKE '%u%');

# 5. 查询在部门的 location_id 为 1700 的部门工作的员工的员工号
SELECT employee_id
FROM employees e
         JOIN departments d ON e.department_id = d.department_id
WHERE d.location_id = 1700;
# 或
SELECT employee_id
FROM employees
WHERE department_id = ANY (
    SELECT DISTINCT department_id
    FROM departments
    WHERE location_id = 1700
);

# 6. 查询管理者是 K_ing 的员工姓名和工资
SELECT last_name, salary
FROM employees e
WHERE manager_id IN (SELECT employee_id
                     FROM employees
                     WHERE last_name = 'K_ing');

# 7. 查询工资最高的员工的姓名，要求 first_name 和 last_name 显示为一列，列名为 姓.名
SELECT concat(last_name, ' ', first_name) '姓.名'
FROM employees
WHERE salary = (SELECT max(salary) FROM employees);
