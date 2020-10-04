USE myemployees;

# 进阶2：条件查询
/*
语法：
    SELECT
        查询列表
    FROM
        表名
    WHERE
        筛选条件;

分类：
    一、按条件表达式筛选

    简单条件运算符：> < = != <> >= <=

    二、按逻辑表达式筛选
    逻辑运算符：
    作用：用于连接条件表达式
        && || !
        and or not

    &&和and：两个条件都为true，结果为true，反之为false
    ||或or： 只要有一个条件为true，结果为true，反之为false
    !或not： 如果连接的条件本身为false，结果为true，反之为false

    三、模糊查询
        LIKE
        between and
        in
        is null
*/

# 一、按条件表达式筛选
# 案例1：查询工资 > 12000的员工信息

SELECT *
FROM employees
WHERE salary > 12000;

# 案例2：查询部门编号不等于 90 号的员工名和部门编号
SELECT last_name,
       department_id
FROM employees
WHERE department_id <> 90;

# 二、按逻辑表达式筛选
# 案例1：查询工资在 10000 到 20000 之间的员工名、工资以及奖金
SELECT last_name,
       salary,
       commission_pct
FROM employees
WHERE salary >= 10000
  AND salary <= 20000;

# 案例2：查询部门编号不是在 90 到 110 之间，或者工资高于 15000 的员工信息
SELECT *
FROM employees
WHERE NOT (department_id >= 90 AND department_id <= 110)
   OR salary > 15000;

# 三、模糊查询
/*
LIKE
between and
in
is null | is not null
*/

# 1. LIKE
/*
特点：
一般和通配符搭配使用
    通配符：
    % 任意多个字符, 包含 0 个字符
    _ 任意单个字符
*/

# 案例1：查询员工名中包含字符 a 的员工信息
SELECT *
FROM employees
WHERE last_name LIKE '%a%';

# 案例2：查询员工名中第三个字符为e，第五个字符为a的员工名和工资
SELECT first_name, salary
FROM employees
WHERE first_name LIKE '__e_a%';

# 案例3：查询员工名中第二个字符为 _ 的员工名
SELECT last_name
FROM employees
WHERE last_name LIKE '_$_%' ESCAPE '$';

# 2. between and
/*
1. 使用between and 可以提高语句的简洁度
2. 包含临界值
3. 两个临界值不要调换顺序
*/

# 案例 1：查询员工编号在100到120之间的员工信息

SELECT *
FROM employees
WHERE employee_id >= 100
  AND employee_id <= 120;
#----------------------
SELECT *
FROM employees
WHERE employee_id BETWEEN 100 AND 120;
# 包含临界值

# 3. in
/*
含义：判断某字段的值是否属于in列表中的某一项
特点：
    1. 使用 in 提高语句简洁度
    2. in 列表的值类型必须一致或兼容
    3. in 列表中不支持通配符
*/
# 案例：查询员工的工种编号是 IT_PROG、AD_VP、AD_PRES 中的一个员工名和工种编号

SELECT last_name,
       job_id
FROM employees
WHERE job_id = 'IT_PROT'
   OR job_id = 'AD_VP'
   OR job_id = 'AD_PRES';

#------------------

SELECT last_name,
       job_id
FROM employees
WHERE job_id IN ('IT_PROT', 'AD_VP', 'AD_PRES');

# 4、is null
/*
=或<>不能用于判断 null 值
is null 或 is not null 可以判断 null 值
*/

# 案例 1：查询没有奖金的员工名和奖金率
SELECT last_name,
       commission_pct
FROM employees
WHERE commission_pct IS NULL;

# 案例2：查询有奖金的员工名和奖金率
SELECT last_name,
       commission_pct
FROM employees
WHERE commission_pct IS NOT NULL;

# ---------以下为错误写法---------
SELECT last_name,
       commission_pct
FROM employees
WHERE salary IS 12000;
# ------------------------------

# 安全等于<=>
# 案例 1：查询没有奖金的员工名和奖金率
SELECT last_name,
       commission_pct
FROM employees
WHERE commission_pct <=> NULL;

# 案例 2：查询工资为 12000 的员工信息
SELECT last_name,
       salary
FROM employees
WHERE salary <=> 12000;

# is null pk <=>
# IS NULL: 仅仅可以判断NULL值，可读性较高，建议使用
# <=>    : 既可以判断NULL值，又可以判断普通的数值，可读性较低

# 查询员工号为 176 的员工的姓名和部门号、年薪
SELECT CONCAT(last_name, ' ', first_name)            AS `name`,
       department_id,
       salary * 12 * (1 + IFNULL(commission_pct, 0)) AS `年薪`
FROM employees
WHERE employee_id = 176;

# 查询没有奖金，且工资小于 18000 的 salary, last_name
SELECT salary,
       last_name
FROM employees
WHERE commission_pct IS NULL
  AND salary < 18000;

# 查询 employee 表中，job_id 不为 'IT' 或工资为 12000 的员工信息
SELECT *
FROM employees
WHERE job_id != 'IT'
   OR salary = 12000;

# 查看 departments 表的结构
DESC departments;

# 查询部门 departments 表中涉及到了哪些位置编号
SELECT DISTINCT location_id
FROM departments;
