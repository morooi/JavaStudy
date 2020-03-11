# DDL
/*
数据定义语言
库和表的管理

一. 库的管理
    创建. 修改. 删除
二. 表的管理
    创建. 修改. 删除

创建: create
修改: alter
删除: drop
*/

# 一. 库的管理
# 1. 库的创建
/*
语法:
create database [if not exists] 库名;
create schema [if not exists] 库名;
*/

# 案例: 创建库 book
CREATE SCHEMA IF NOT EXISTS book;
CREATE DATABASE IF NOT EXISTS book;

# 2. 库的修改
# RENAME DATABASE books TO 新库名;  (已废弃)

# 更改库的字符集
USE book;
ALTER DATABASE book CHARACTER SET utf8;

# 3. 库的删除
DROP DATABASE IF EXISTS book;

# 二. 表的管理
# 1.表的创建 ★
/*
语法: 
create table 表名(
	列名 列的类型[(长度) 约束],
	列名 列的类型[(长度) 约束],
	列名 列的类型[(长度) 约束],
	...
	列名 列的类型[(长度) 约束]
)
*/

CREATE SCHEMA IF NOT EXISTS book CHARACTER SET utf8;

# 案例: 创建表 Book
CREATE TABLE book
(
    id          INT,         # 编号
    bName       VARCHAR(20), # 图书名
    price       DOUBLE,      # 价格
    authorId    INT,         # 作者编号
    publishDate DATETIME     # 出版日期
);
DESC book;

# 案例: 创建表 author
CREATE TABLE IF NOT EXISTS author
(
    id      INT,
    au_name VARCHAR(20),
    nation  VARCHAR(10)
);
DESC author;

# 2. 表的修改
# 语法: alter table 表名 add|drop|modify|change column 列名 [列类型 约束];

# ① 修改列名 change
ALTER TABLE book
    CHANGE COLUMN publishdate pubDate DATETIME;

# ② 修改列的类型或约束 modify
ALTER TABLE book
    MODIFY COLUMN pubdate TIMESTAMP;

# ③ 添加新列 add
ALTER TABLE author
    ADD COLUMN annual DOUBLE;

# ④ 删除列 drop
ALTER TABLE author
    DROP COLUMN annual;

# ⑤ 修改表名
ALTER TABLE author RENAME TO book_author;
DESC book;

# 3. 表的删除
DROP TABLE IF EXISTS book_author;
SHOW TABLES;


# 通用的写法:
# DROP SCHEMA IF EXISTS 旧库名;
# CREATE SCHEMA 新库名;
#
# DROP TABLE IF EXISTS 旧表名;
# CREATE TABLE 表名;

# 4. 表的复制
INSERT INTO author
VALUES (1, '村上春树', '日本'),
       (2, '莫言', '中国'),
       (3, '冯唐', '中国'),
       (4, '金庸', '中国');

# 1. 仅仅复制表的结构
CREATE TABLE copy LIKE author;

# 2. 复制表的结构 + 数据
CREATE TABLE copy2
SELECT *
FROM author;

# 只复制部分数据
CREATE TABLE copy3
SELECT id, au_name
FROM author
WHERE nation = '中国';

# 仅仅复制某些列
CREATE TABLE copy4
SELECT id, au_name
FROM author
WHERE 0;
