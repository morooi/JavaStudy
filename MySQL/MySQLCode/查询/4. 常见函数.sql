# 进阶4：常见函数

/*
概念：类似于java的方法，将一组逻辑语句封装在方法体中，对外暴露方法名
好处：1、隐藏了实现细节  2、提高代码的重用性
调用：select 函数名(实参列表) (from 表);
特点：
    1. 叫什么（函数名）
    2. 干什么（函数功能）
分类：
    1、单行函数
        如 concat、length、ifnull等
    2、分组函数
        功能：做统计使用，又称为统计函数、聚合函数、组函数

常见函数：
一、单行函数
    字符函数：
    length: 获取字节个数(utf-8 一个汉字代表 3 个字节, gbk 为 2 个字节)
    concat
    substr
    instr
    trim
    upper
    lower
    lpad
    rpad
    replace

    数学函数：
    round
    ceil
    floor
    truncate
    mod

    日期函数：
    now
    curdate
    curtime
    year
    month
    monthname
    day
    hour
    minute
    second
    str_to_date
    date_format

    其他函数：
    version
    database
    user

    控制函数
    if
    case

二、分组函数
功能：用作统计使用，又称为聚合函数或统计函数或组函数

分类：
sum 求和, avg 平均值, max 最大值, min 最小值, count 计算个数

特点：
1、sum, avg 一般用于处理数值型
   max, min, count 可以处理任何类型
2、以上分组函数都忽略 null 值
3、可以和 distinct 搭配实现去重的运算
4、count 函数的单独介绍: 一般使用 count(*) 用作统计行数
5、和分组函数一同查询的字段要求是 group by 后的字段
*/

USE myemployees;

# 一、字符函数

# 1. length 获取参数值的字节个数
SELECT LENGTH('john');
SELECT LENGTH('张三丰');

SHOW VARIABLES LIKE '%char%';

# 2. concat 拼接字符串
SELECT CONCAT(last_name, '_', first_name) 姓名
FROM employees;

# 3. upper, lower
SELECT UPPER('john');
SELECT LOWER('joHn');
# 示例：将姓变大写，名变小写，然后拼接
SELECT CONCAT(UPPER(last_name), LOWER(first_name)) 姓名
FROM employees;

# 4. substr, substring
# 注意：索引从1开始
# 截取从指定索引处后面所有字符
SELECT SUBSTR('李莫愁爱', 2) out_put;

# 截取从指定索引处指定字符长度的字符
SELECT SUBSTR('李莫愁爱上了陆展元', 1, 3) out_put;

# 案例：姓名中首字符大写，其他字符小写然后用_拼接，显示出来
SELECT concat(upper(substr(last_name, 1, 1)), lower(substr(last_name, 2)), '_', first_name) 姓名
FROM employees;

# 5. instr 返回子串第一次出现的索引，如果找不到返回0
SELECT INSTR('abceeeabc', 'e') AS out_put;

# 6. trim 去首尾的空格 或 定义的内容
SELECT LENGTH(TRIM('    a bc    ')) AS out_put;
SELECT TRIM('aa' FROM 'aaaaaaaaa张aaaaaaa翠山aaaaaaaaaaa') AS out_put;

# 7. lpad 用指定的字符实现左填充, 达到指定长度
SELECT lpad('殷素素', 5, '*') AS out_put;

# 8. rpad 用指定的字符实现右填充, 达到指定长度
SELECT rpad('殷素素', 12, 'ab') AS out_put;

# 9. replace 替换
SELECT REPLACE('周芷若周芷若张无忌爱上了周芷若', '周芷若', '赵敏') AS out_put;


# 二、数学函数
# round 四舍五入
SELECT ROUND(-1.55);
SELECT ROUND(1.567, 2);
# 四舍五入到指定位数

# ceil 向上取整,返回>=该参数的最小整数
SELECT CEIL(-1.02);

# floor 向下取整，返回<=该参数的最大整数
SELECT FLOOR(-9.99);

# truncate 截断
SELECT TRUNCATE(1.69999, 3);

# mod 取余
/*
mod(a,b):  a-a/b*b
mod(-10,-3): -10- (-10)/(-3)*（-3）=-1
*/
SELECT mod(10, -3) out_put;
SELECT 10 % 3;

# 三、日期函数

# now 返回当前系统日期+时间
SELECT NOW();

# curdate 返回当前系统日期，不包含时间
SELECT CURDATE();

# curtime 返回当前时间，不包含日期
SELECT CURTIME();

# 可以获取指定的部分，年、月、日、小时、分钟、秒
SELECT YEAR(NOW()) 年;
SELECT YEAR('1998-1-1') 年;

SELECT YEAR(hiredate) 年
FROM employees;

SELECT month(now()) 月;
SELECT monthname(now()) 月;

# str_to_date 将字符通过指定的格式转换成日期
# %Y    四位年份
# %y    二位年份
# %m    月（01, 02, ..., 11, 12）
# %c    月（1, 2, ..., 11, 12）
# %d    日（01, 02, ...）
# %H    小时（24小时）
# %h    小时（12小时）
# %i    分钟（00, 01, ..., 59）
# %s    秒（00, 01, ..., 59）
SELECT str_to_date('1998/3/2', '%Y/%c/%d') AS out_put;

# 查询入职日期为 1992-4-3 的员工信息
SELECT *
FROM employees
WHERE hiredate = '1992-4-3';

SELECT *
FROM employees
WHERE hiredate = STR_TO_DATE('4-3 1992', '%c-%d %Y');

#date_format 将日期转换成字符
SELECT date_format(now(), '%Y年%m月%d日 %H:%i:%s') AS out_put;

# 查询有奖金的员工名和入职日期(xx月/xx日 xx年)
SELECT concat(last_name, ' ', first_name) 姓名,
       date_format(hiredate, '%m/%d %Y')  入职日期
FROM employees
WHERE commission_pct IS NOT NULL;


# 四、其他函数
SELECT version();
SELECT database();
SELECT user();

# 五、流程控制函数
# 1. if 函数: 实现 if else 的效果
SELECT if(10 < 5, '大', '小');
SELECT last_name,
       commission_pct,
       IF(commission_pct IS NULL, '没奖金，呵呵', '有奖金，嘻嘻') 备注
FROM employees;

# 2. case 函数的使用一: 实现 switch case 的效果
/*
mysql中
case 要判断的字段或表达式
when 常量1 then 要显示的值1或语句1;
when 常量2 then 要显示的值2或语句2;
...
else 要显示的值n或语句n;
end
*/

/*案例：查询员工的工资，要求
部门号=30，显示的工资为1.1倍
部门号=40，显示的工资为1.2倍
部门号=50，显示的工资为1.3倍
其他部门，显示的工资为原工资
*/
SELECT salary  原始工资,
       department_id,
       CASE department_id
           WHEN 30 THEN salary * 1.1
           WHEN 40 THEN salary * 1.2
           WHEN 50 THEN salary * 1.3
           ELSE salary
           END 新工资
FROM employees;

# 3. case 函数的使用二：类似于 多重if
/*
java中：
if(条件1) {
    语句1;
} else if(条件2) {
    语句2;
} else {
    语句n;
}

mysql中:
case
when 条件1 then 要显示的值1或语句1
when 条件2 then 要显示的值2或语句2
...
else 要显示的值n或语句n
end
*/

# 案例：查询员工的工资的情况
# 如果工资>20000, 显示A级别
# 如果工资>15000, 显示B级别
# 如果工资>10000, 显示C级别
# 否则，显示D级别
SELECT salary,
       CASE
           WHEN salary >= 20000 THEN 'A'
           WHEN salary >= 15000 THEN 'B'
           WHEN salary >= 10000 THEN 'C'
           ELSE 'D'
           END 等级
FROM employees
ORDER BY 等级;


# 练习一：显示系统时间（日期+时间）
SELECT now();

# 练习二：查询员工号，姓名，工资，以及工资提高20%后的结果
SELECT employee_id, last_name, salary, salary * 1.2 'new salary'
FROM employees;

# 练习三：将员工的姓名按首字母排序，并写出姓名的长度
SELECT last_name, length(last_name)
FROM employees
ORDER BY last_name;

SELECT concat(last_name, ' earns ', salary, ' monthly but wants ', salary * 3)
FROM employees;

# -----------------------------

# 分组函数
# 1、简单的使用
SELECT sum(salary)
FROM employees;

SELECT avg(salary)
FROM employees;

SELECT min(salary)
FROM employees;

SELECT max(salary)
FROM employees;

SELECT count(salary) # 非空的
FROM employees;

SELECT sum(salary) 和, avg(salary) 平均, max(salary) 最高, min(salary) 最低, count(salary) 个数
FROM employees;

SELECT sum(salary) 和, ROUND(avg(salary), 2) 平均, max(salary) 最高, min(salary) 最低, count(salary) 个数
FROM employees;

# 2、参数支持哪些类型
SELECT sum(last_name), # 不支持非数值
       avg(last_name)  # 不支持非数值
FROM employees;

SELECT sum(hiredate), avg(hiredate)
FROM employees;

SELECT max(last_name), min(last_name)
FROM employees;

SELECT max(hiredate), min(hiredate)
FROM employees;

SELECT count(commission_pct) # 不计 null
FROM employees;

SELECT count(last_name)
FROM employees;

# 3、是否忽略 null
SELECT sum(commission_pct), # sum, avg 都忽略了 null
       avg(commission_pct),
       sum(commission_pct) / 35,
       sum(commission_pct) / 107
FROM employees;

SELECT max(commission_pct), # max, min 都忽略了 null
       min(commission_pct)
FROM employees;

SELECT count(commission_pct) # count 也忽略了 null
FROM employees;

# 4、和 distinct 搭配
SELECT sum(DISTINCT salary), sum(salary)
FROM employees;

SELECT count(DISTINCT salary), count(salary)
FROM employees;

# 5、count 函数的详细介绍
#   效率：
#   MYISAM 存储引擎下, count(*)的效率高
#   INNODB 存储引擎下, count(*)和count(1)的效率差不多, 比count(字段)要高一些
SELECT count(salary)
FROM employees;

SELECT count(*) # 推荐写法
FROM employees;

SELECT count(1)
FROM employees;

# 6、和分组函数一同查询的字段有限制
SELECT avg(salary), employee_id
FROM employees;

# 计算入职最早和最晚的相差天数
SELECT datediff(max(hiredate), min(hiredate)) Difference
FROM employees;

SELECT count(*)
FROM employees
WHERE department_id = 90;