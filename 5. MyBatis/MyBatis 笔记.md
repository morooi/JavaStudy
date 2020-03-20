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

### 入门案例：

Project：`01mybatis_eesy`

1. 读取配置文件
2. 创建 SQLSessionFactory 工厂
3. 使用工厂生产 SQLSession 对象
4. 使用 SQLSession 创建 Dao 接口的代理对象
5. 使用代理对象执行 dao 中的方法
6. 释放资源

注意：不要忘记在映射配置中告知 MyBatis 要封装到哪个实体类中

### 基于注解的入门案例

Project：`01mybatis_annotation_eesy`

把 UserDao.xml 移除，在 dao 接口的方法上使用 @Select 注解，并指定 SQL 语句。

同时需要在 SqlMapConfig.xml 中的 mapper 配置时，使用 class 属性指定 dao 接口的全限定类名

### 自定义 dao 实现类

**明确：在实际开发中，都是越简便越好，所有都是采用不写 dao 实现类的方式，不管使用 XML 还是注解配置，但是 MyBatis 是支持写 dao 实现类的**

Project：`01mybatis_dao_eesy`

### 入门案例中的设计模式分析

![](https://i.loli.net/2020/03/20/Ix6NLjFcJzR4y3D.jpg)

### 自实现 MyBatis

Project：`04mybatis_design_eesy`

