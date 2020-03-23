# MyBatis

## MyBatis 的环境搭建

1. 创建 maven 工程并导入坐标

2. 创建实体类和 dao 的接口

3. 创建 MyBatis 的主配置文件

   SqlMapConfig.xml

4. 创建映射配置文件

   UserDao.xml

注意事项：

1. 创建 UserDao.xml 和 UserDao.java 时，名称是为了和之前的知识保持一致。在 MyBatis 中把持久层的操作接口名称和映射文件也叫做：Mapper。所以 UserDao 和 UserMapper 是一样的
2. MyBatis 的映射配置文件位置必须和 dao 接口的包结构相同
3. 映射配置文件的 mapper 标签 namespace 属性的取值必须是 dao 接口的全限定类名
4. 映射配置文件的操作配置（select），id 属性的取值必须是 dao 接口的方法名

> 遵从第 2, 3, 4 点后，在开发中就无须再写 dao 的实现类

## 入门案例

Project：`01mybatis_eesy`

1. 读取配置文件
2. 创建 SQLSessionFactory 工厂
3. 使用工厂生产 SQLSession 对象
4. 使用 SQLSession 创建 Dao 接口的代理对象
5. 使用代理对象执行 dao 中的方法
6. 释放资源

注意：不要忘记在映射配置中告知 MyBatis 要封装到哪个实体类中

## 基于注解的入门案例

Project：`01mybatis_annotation_eesy`

把 UserDao.xml 移除，在 dao 接口的方法上使用 @Select 注解，并指定 SQL 语句。

同时需要在 SqlMapConfig.xml 中的 mapper 配置时，使用 class 属性指定 dao 接口的全限定类名

## 自定义 dao 实现类

**明确：在实际开发中，都是越简便越好，所有都是采用不写 dao 实现类的方式，不管使用 XML 还是注解配置，但是 MyBatis 是支持写 dao 实现类的**

Project：`01mybatis_dao_eesy`

## 入门案例中的设计模式分析

![](https://i.loli.net/2020/03/20/Ix6NLjFcJzR4y3D.jpg)

## 自实现 MyBatis

Project：`04mybatis_design_eesy`

## MyBatis 的 CURD

Project：`05mybatis_CURD_eesy`

## MyBatis 中的数据库连接池

MyBatis 连接池提供了 3 种方式的配置

主配置文件 SqlMapConfig.xml 中的 `dataSource`  标签， `type` 属性就是表示采用何种连接池方式

`type` 的属性的取值：

* POOLED：采用传统的 javax.sql.DateSource 规范的连接池， MyBatis 中有针对规范的实现
* UNPOOLED：采用传统的获取连接的方式，虽然也实现 javax.sql.DateSource 接口，但是并没有使用池的思想
* JNDI：采用服务器提供的 JNDI 技术实现，来获取 DataSource 对象，不同的服务器所能拿到的 DataSource 是不一样的。**注意**：如果不是 web 或 maven 的 war 工程，是不能使用的。Tomcat 服务器采用的是 dbcp 连接池

## MyBatis 中的事务

通过 sqlSession 的 commit 方法和 rollback 方法实现事务的提交和回滚


## MyBatis 中的动态 SQL

`<if></if>`

`<where></where>`

`<foreach></foreach>`

Project：`06mybatis_dynamicSQL_eesy`

## MyBatis 中的多表查询

表之前的关系有几种：

* 一对多

  例：用户和订单就是一对多

* 多对一

  例：订单和用户就是多对一，多个订单属于同一个用户

  **注意**：每个订单对应一个用户，MyBatis 把多对一看成是一对第一

* 一对一

  例：人和身份证号

* 多对多

  例：老师和学生



一对多、多对一，示例：用户和账户

Project：`07mybatis_one2many_eesy`

​	一个用户可以有多个账户

​	一个账户只能属于一个用户（多个账户也可以属于同一个用户）

步骤：

1. 建立两张表：用户表、账户表。

   让两张表之间具备一对多的关系：使用外键在账户表中添加

2. 建立两个实体类：用户实体类和账户实体类

   让两个实体类能体现出来一对多的关系

3. 建立两个配置文件

   用户的配置文件、账户的配置文件

4. 实现配置

   查询用户时，可以同时得到用户下所包含的账户信息

   查询账户时，可以同时得到账户的所属用户信息



多对多示例：用户和角色

Project：`08mybatis_many2many_eesy`

​	一个用户可以有多个角色

​	一个角色可以赋予多个用户

步骤：

1. 建立两张表：用户表、角色表。

   让两张表之间具备多对多的关系。使用中间表，包含各自的主键，在中间表中是外键

2. 建立两个实体类：用户实体类和角色实体类

   让两个实体类能体现出来多对多的关系，各自包含对方一个集合引用

3. 建立两个配置文件

   用户的配置文件、角色的配置文件

4. 实现配置

   查询用户时，可以同时得到用户下所包含的角色信息

   查询角色时，可以同时得到角色的所赋予的用户信息

## MyBatis 中的延迟加载

Project：`09mybatis_lazyload_eesy`

**立即加载**：不管用不用，只要一调用方法，马上发起查询

**延迟加载**：在真正使用数据时才发起查询，不用的时候不查询，按需加载（懒加载）

在对应的四种表关系中：一对多，多对一，一对一，多对多

* 一对多、多对多：通常采用延迟加载

* 多对一、一对一：通常采用立即加载

## MyBatis 中的缓存

缓存：是存在内存中的临时数据。

好处：可以减少和数据库的交互次数，提高执行效率

使用情况：

适用：

		1. 经常查询，并且不经常改变的数据
  		2. 数据的正确与否对最终结果的影响不大的

不适用：

1. 经常改变的数据
2. 数据的正确与否对最终结果的影响很大的（商品库存、银行汇率等）

### 一级缓存

一级缓存是 SqlSession 级别的缓存，当调用 SqlSession 的修改，添加，删除，commit()，close()等方法时，就会清空一级缓存。

![](https://i.loli.net/2020/03/23/D9XkqbGOP6LYx5n.jpg)

### 二级缓存

指的是 MyBatis 中的 SqlSessionFactory 对象的缓存，由同一个 SqlSessionFactory 对象创建的 SqlSession 共享其缓存

使用步骤：

1. 让 MyBatis 框架支持二级缓存（在 SqlMapconfig.xml 中配置）
2. 让当前的映射文件支持二级缓存（在 UserDao.xml 中配置）
3. 让当前的操作支持二级缓存（在 select 标签中配置）

二级缓存存放的是数据，而不是 Java 对象

注意：使用二级缓存时，所缓存的类一定要实现 java.io.Serializable 接口，这样就可以使用序列化
方式来保存对象。

