# 进阶6: 连接查询
/*
含义: 又称多表查询, 当查询的字段来自于多个表时, 就会用到连接查询

笛卡尔乘积现象: 表 1 有 m 行, 表 2 有 n 行, 结果 = m * n 行
发生原因: 没有有效的连接条件
如何避免: 添加有效的连接条件

分类: 
    按年代分类: 
        sql92 标准: 仅仅支持内连接
        sql99 标准[推荐]: 支持内连接 + 外连接(左外和右外) + 交叉连接

    按功能分类: 
        内连接: 
            等值连接
            非等值连接
            自连接
        外连接: 
            左外连接
            右外连接
            全外连接
        交叉连接
*/

USE girls;

SELECT *
FROM beauty;

SELECT *
FROM boys;

SELECT NAME, boyName
FROM boys,
     beauty
WHERE boyfriend_id = boys.id;

-- sql99语法
# 一. 等值连接
# ① 多表等值连接的结果为多表的交集部分
# ② n 表连接, 至少需要 n - 1 个连接条件
# ③ 多表的顺序没有要求
# ④ 一般需要为表起别名
# ⑤ 可以搭配前面介绍的所有子句使用, 比如排序, 分组, 筛选

# 案例 1: 查询女神名和对应的男神名
SELECT NAME, boyName
FROM boys,
     beauty
WHERE beauty.boyfriend_id = boys.id;

# 案例 2: 查询员工名和对应的部门名
USE myemployees;

SELECT last_name, department_name
FROM employees,
     departments
WHERE employees.department_id = departments.department_id;

# 2. 为表起别名
# ① 提高语句的简洁度
# ② 区分多个重名的字段
# 注意: 如果为表起了别名, 则查询的字段就不能使用原来的表名去限定

# 查询员工名, 工种号, 工种名
SELECT last_name, jobs.job_id, job_title
FROM employees,
     jobs
WHERE employees.job_id = jobs.job_id;
# 或 起别名
SELECT last_name, e.job_id, job_title
FROM employees e,
     jobs j
WHERE e.job_id = j.job_id;

# 3. 两个表的顺序是否可以调换
# 查询员工名, 工种号, 工种名
SELECT last_name, e.job_id, job_title
FROM jobs j,
     employees e
WHERE e.job_id = j.job_id;

# 4. 可以加筛选
# 案例: 查询有奖金的员工名, 部门名
SELECT last_name, department_name, commission_pct
FROM employees e,
     departments d
WHERE e.department_id = d.department_id
  AND commission_pct IS NOT NULL;

# 案例2: 查询城市名中第二个字符为 o 的部门名和城市名
SELECT department_name, city
FROM locations l,
     departments d
WHERE d.location_id = l.location_id
  AND l.city LIKE '_o%';

# 5. 可以加分组
# 案例 1: 查询每个城市的部门个数
SELECT count(*), l.city
FROM departments d,
     locations l
WHERE d.location_id = l.location_id
GROUP BY l.city;

# 案例2: 查询有奖金的每个部门的部门名和部门的领导编号和该部门的最低工资
SELECT department_name, d.manager_id, min(salary)
FROM departments d,
     employees e
WHERE e.commission_pct IS NOT NULL
  AND e.department_id = d.department_id
GROUP BY department_name, d.manager_id;

# 6. 可以加排序
# 案例: 查询每个工种的工种名和员工的个数, 并且按员工个数降序
SELECT j.job_title,
       count(*)
FROM jobs j,
     employees e
WHERE e.job_id = j.job_id
GROUP BY job_title
ORDER BY count(*) DESC;

# 7. 可以实现三表连接
# 案例: 查询员工名, 部门名和所在的城市
SELECT last_name, department_name, city
FROM employees e,
     departments d,
     locations l
WHERE e.department_id = d.department_id
  AND d.location_id = l.location_id;

# 二. 非等值连接
# 案例 1: 查询员工的工资和工资级别

SELECT salary, grade_level
FROM employees e,
     job_grades j
WHERE salary BETWEEN lowest_sal AND highest_sal
ORDER BY grade_level;

/*
CREATE TABLE job_grades
(grade_level VARCHAR(3),
 lowest_sal  int,
 highest_sal int);

INSERT INTO job_grades
VALUES ('A', 1000, 2999);

INSERT INTO job_grades
VALUES ('B', 3000, 5999);

INSERT INTO job_grades
VALUES('C', 6000, 9999);

INSERT INTO job_grades
VALUES('D', 10000, 14999);

INSERT INTO job_grades
VALUES('E', 15000, 24999);

INSERT INTO job_grades
VALUES('F', 25000, 40000);
*/

# 三. 自连接
# 案例: 查询 员工名和上级的名称
SELECT e.last_name 员工名,
       m.last_name 领导名
FROM employees e,
     employees m
WHERE e.manager_id = m.employee_id;

-- sql99语法
/*
语法: 
    select 查询列表
    from 表1 别名
    [连接类型] join 表2 别名 
    on 连接条件
    [where 筛选条件]
    [group by 分组]
    [having 筛选条件]
    [order by 排序列表]

分类:
内连接(★): inner
外连接:
    左外(★): left [outer]
    右外(★): right [outer]
    全外: full [outer]
交叉连接: cross
*/

# 一. 内连接
/*
语法: 
select 查询列表
from 表1 别名
inner join 表2 别名
on 连接条件;

分类: 
    等值
    非等值
    自连接

特点: 
① 添加排序, 分组, 筛选
② inner 可以省略
③ 筛选条件放在 where 后面, 连接条件放在 on 后面, 提高分离性, 便于阅读
④ inner join 连接和 sql92 语法中的等值连接效果是一样的, 都是查询多表的交集
*/

# 1. 等值连接
# 案例 1. 查询员工名, 部门名
SELECT last_name, department_name
FROM employees e
         INNER JOIN departments d ON e.department_id = d.department_id;

# 案例 2. 查询名字中包含 e 的员工名和工种名(添加筛选)
SELECT last_name, job_title
FROM employees e
         JOIN jobs j ON e.job_id = j.job_id
WHERE last_name LIKE '%e%';

# 案例 3. 查询部门个数 > 3 的城市名和部门个数(添加分组+筛选)
SELECT city, count(*)
FROM departments d
         JOIN locations l ON d.location_id = l.location_id
GROUP BY l.city
HAVING count(*) > 3;

# 案例 4. 查询哪个部门的员工个数 > 3 的部门名和员工个数, 并按个数降序(添加排序)
SELECT department_name, count(*) c
FROM employees e
         JOIN departments d ON e.department_id = d.department_id
GROUP BY department_name
HAVING count(*) > 3
ORDER BY c;

# 案例 5. 查询员工名, 部门名, 工种名, 并按部门名降序(添加三表连接)
SELECT last_name, department_name, job_title
FROM employees e
         JOIN departments d ON e.department_id = d.department_id
         JOIN jobs j ON e.job_id = j.job_id
ORDER BY department_name DESC;

# 2. 非等值连接
# 查询员工的工资级别
SELECT grade_level, last_name
FROM employees e
         JOIN job_grades j ON e.salary BETWEEN j.lowest_sal AND j.highest_sal
ORDER BY grade_level;

# 查询工资级别的个数 > 20 的个数, 并且按工资级别降序
SELECT grade_level, count(*)
FROM employees e
         JOIN job_grades j ON salary BETWEEN lowest_sal AND highest_sal
GROUP BY grade_level
HAVING count(*) > 20
ORDER BY grade_level DESC;

# 3. 自连接
# 查询员工的名字, 上级的名字
SELECT e.last_name, m.last_name
FROM employees e
         JOIN employees m ON e.manager_id = m.employee_id;

# 查询姓名中包含字符 k 的员工的名字, 上级的名字
SELECT e.last_name, m.last_name
FROM employees e
         JOIN employees m ON e.manager_id = m.employee_id
WHERE e.last_name LIKE '%k%';


# 二. 外连接
/*
应用场景: 用于查询一个表中有, 另一个表没有的记录

特点: 
1. 外连接的查询结果为主表中的所有记录
   如果从表中有和它匹配的, 则显示匹配的值
   如果从表中没有和它匹配的, 则显示 null
   外连接查询结果 = 内连接结果 + 主表中有而从表没有的记录
2. 左外连接, left join 左边的是主表
   右外连接, right join 右边的是主表
3. 左外和右外交换两个表的顺序, 可以实现同样的效果 
4. 全外连接 = 内连接的结果 + 表 1 中有但表 2 没有的 + 表 2 中有但表 1 没有的
*/

# 引入: 查询男朋友不在男神表的的女神名
USE girls;
# 左外连接
SELECT name
FROM beauty g
         LEFT OUTER JOIN boys b ON g.boyfriend_id = b.id
WHERE b.id IS NULL;

# 案例 1: 查询哪个部门没有员工
USE myemployees;
# 左外
SELECT department_name
FROM departments d
         LEFT OUTER JOIN employees e ON d.department_id = e.department_id
WHERE employee_id IS NULL;

# 右外
SELECT department_name
FROM employees e
         RIGHT OUTER JOIN departments d ON e.department_id = d.department_id
WHERE employee_id IS NULL;

# 全外, MySQL 不支持
# USE girls;
# SELECT b.*, bo.*
# FROM beauty b FULL OUTER JOIN boys bo
# ON b.`boyfriend_id` = bo.id;

# 交叉连接
USE girls;
SELECT b.*, bo.*
FROM beauty b
         CROSS JOIN boys bo;


-- sql92 和 sql99 pk
/*
功能: sql99 支持的较多
可读性: sql99 实现连接条件和筛选条件的分离, 可读性较高
*/
