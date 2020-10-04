# Spring 笔记

## BeanFactory 与 ApplicationContext

BeanFactory 是 Spring 容器中的顶层接口，ApplicationContext 是它的子接口

BeanFactory 和 ApplicationContext 的区别：创建对象的时间点不一样。

* ApplicationContext：只要一读取配置文件，默认情况下就会创建对象（立即加载，更常用）
* BeanFactory：什么使用什么时候创建对象（延迟加载）

## ApplicationContext 接口的实现类

* ClassPathXmlApplicationContext: 从类的根路径下加载配置文件（推荐使用这种）
* FileSystemXmlApplicationContext: 从磁盘路径上加载配置文件，配置文件可以在磁盘的任意位置
* AnnotationConfigApplicationContext: 当我们使用注解配置容器对象时，需要使用此类来创建 Spring 容器，它用来读取注解

## JavaBean

XML 的约束

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">
</beans>
```

### Bean 标签

`<bean/>`

作用：用于配置对象让 Spring 来创建的

默认情况下它调用的是类中的无参构造函数。如果没有无参构造函数则不能创建成功。

属性:

* id：给对象在容器中提供一个唯一标识，用于获取对象
* class：指定类的全限定类名。用于反射创建对象。默认情况下调用无参构造函数
* scope：指定对象的作用范围
* init-method：指定类中的初始化方法名称
* destroy-method：指定类中销毁方法名称

### 实例化 Bean 的三种方式

1. 使用默认无参构造函数

   在默认情况下，它会根据默认无参构造函数来创建类对象。如果 bean 中没有默认无参构造函数，将会创建失败。

   ``` xml
   <bean id="accountService" class="cn.morooi.service.impl.AccountServiceImpl"/>
   ```

2. Spring 管理实例工厂 —— 使用实例工厂的方法创建对象（使用某个类中的方法创建对象，并存入 Spring 容器）

   ``` xml
   <bean id="instanceFactory" class="cn.morooi.factory.InstanceFactory"/>
   <bean id="accountService" factory-bean="instanceFactory" factory-method="getAccountService"/>
   ```

3. Spring 管理静态工厂 —— 使用静态工厂的方法创建对象

   ``` xml
   <bean id="accountService" class="cn.morooi.factory.StaticFactory" factory-method="getAccountService"/>
   ```

### Bean 的作用范围

bean 标签的 scope 属性，取值：常用单例和多例

* singleton：单例的（默认值）
* prototype：多例的
* request：作用于 web 应用的请求范围
* session：作用于 web 应用的会话范围
* global-session：作用于集群环境的会话范围（全局会话范围），当不是集群环境时就是 session

### Bean 对象的生命周期

单例对象：生命周期和容器相同

* 出生：当应用加载，创建容器时，对象就被创建
* 活着：只要容器还在，对象就一直活着
* 死亡：当应用卸载，销毁容器时，对象就被销毁

多例对象：

* 出生：当使用对象时，创建新的对象实例
* 活着：只要对象在使用中，就一直活着
* 死亡：当对象长时间不用时，会被 Java 的垃圾回收器回收

## Spring 中的依赖注入

依赖注入：Dependency Injection

它是 Spring 框架核心 IoC 的具体实现，我们的程序在编写时，通过控制反转，把对象的创建交给了 Spring，但是代码中不可能出现没有依赖的情况

IoC 解耦只是降低他们的依赖关系，但不会消除。例如：我们的业务层仍会调用持久层的方法，那这种业务层和持久层的依赖关系，在使用 Spring 之后，就让 Spring 来维护了。简单的说，就是坐等框架把持久层对象传入业务层，而不用我们自己去获取。

依赖关系的维护就称为依赖注入

能注入的数据有三类：

* 基本类型和 String

* 其他 bean 类型（在配置文件中或者注解配置过的 bean）

* 复杂类型/集合类型

注入的方式有三种：

* 使用构造方法提供
* 使用 set 方法提供
* 使用注解提供

### 使用构造方法注入

优势：在获取 bean 对象时，注入数据是必须的操作，否则对象无法创建成功

弊端：改变了 bean 对象的实例化方式，使我们在创建对象时如果用不到这些数据，也必须提供

使用的标签：constructor-arg

出现的位置：bean 标签的内部

标签中的属性：

* type：用于指定要注入的数据和数据类型，该数据类型也是构造函数中某个或某些参数的类型

* index：用于指定要注入的数据给构造函数中指定索引位置的参数赋值，从 0 开始

* name：用于指定给构造函数中指定名称的参数赋值**（常用）**

  ==========上面三个都是找给谁赋值，下面两个指的是赋什么值 ==========

* value：用于提供基本类型和 String 类型的数据

* ref：用于指定其他的 bean 类型数据。指的是在 spring 的 IoC 核心容器中出现过的 bean 对象

``` java
public class AccountServiceImpl implements AccountService {
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }
}
```

``` xml
<bean id="accountService" class="cn.morooi.service.impl.AccountServiceImpl">
  <constructor-arg name="name" value="南极"/>
  <constructor-arg name="age" value="18"/>
  <constructor-arg name="birthday" ref="now"/>
</bean>

<!-- 配置一个时间对象 -->
<bean id="now" class="java.util.Date"/>
```

### 使用 set 方法注入

优势：创建对象时没有明确的限制，可以直接使用默认构造函数

弊端：如果有某个成员必须有值，则获取对象时有可能 set 方法没有执行

在类中提供需要注入成员的 set 方法**（常用）**

使用的标签：property

出现的位置：bean 标签的内部

标签中的属性：

* name：用于指定注入时所调用的 set 方法的名称

  ==上面是找给谁赋值，下面两个指的是赋什么值==

* value：用于提供基本类型和 String 类型的数据

* ref：用于指定其他的 bean 类型数据。指的是在 spring 的 IoC 核心容器中出现过的 bean 对象

``` java
public class AccountServiceImpl2 implements AccountService {
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
```

``` xml
<bean id="accountService2" class="cn.morooi.service.impl.AccountServiceImpl2">
  <property name="name" value="试试水"/>
  <property name="age" value="22"/>
  <property name="birthday" ref="now"/>
</bean>
```

使用 set 方法注入复杂类型的数据

使用的标签：property

出现的位置：bean 标签的内部

用于给 List 结构集合注入的标签：array, list, set

用于给 Map 结构集合注入的标签：map, props

**结构相同，标签可互换**

``` java
public class AccountServiceImpl3 implements AccountService {

    private String[] strings;
    private List<String> stringList;
    private Set<String> stringSet;
    private Map<String, String> stringMap;
    private Properties properties;

    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public void setStringSet(Set<String> stringSet) {
        this.stringSet = stringSet;
    }

    public void setStringMap(Map<String, String> stringMap) {
        this.stringMap = stringMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
```

``` xml
<bean id="accountService3" class="cn.morooi.service.impl.AccountServiceImpl3">
  <property name="strings">
    <array>
      <value>AAA_array</value>
      <value>BBB_array</value>
      <value>CCC_array</value>
    </array>
  </property>
  <property name="stringList">
    <list>
      <value>AAA_list</value>
      <value>BBB_list</value>
      <value>CCC_list</value>
    </list>
  </property>
  <property name="stringSet">
    <set>
      <value>AAA_set</value>
      <value>BBB_set</value>
      <value>CCC_set</value>
    </set>
  </property>
  <property name="stringMap">
    <map>
      <entry key="testA" value="AAA_map"/>
      <entry key="testB" value="BBB_map"/>
    </map>
  </property>
  <property name="properties">
    <props>
      <prop key="testC">CCC_prop</prop>
      <prop key="testD">DDD_prop</prop>
    </props>
  </property>
</bean>
```

## 使用注解代替 XML 文件

曾经 XML 配置:

``` xml
<bean id="accountService" class="cn.morooi.service.impl.AccountServiceImpl"
      scope="" init-method="" destory-method="">
  <property name="" value="" | ref=""></property>
</bean>
```

XML 的约束：

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">
</beans>
```

### 用于创建对象的注解

他们的作用和在 XML 配置文件中编写一个 `<bean> `标签实现的功能是一样的

* `@Component`：用于把当前对象存入 Spring 容器中

  属性：value：用于指定 bean 的 id，若不写，默认值为当前类名的首字母小写

==以下三个注解作用、属性和 `@Component` 一样，但使用可以更明确==

* `@Controller`：一般用在表现层
* `@Service`：一般用在业务层
* `@Repository`：一般用在持久层

### 用于注入数据的注解

他们的作用和在 XML 配置文件中的 `<bean>` 标签中的 `<property>` 标签作用是一样的

* `@Autowired`：

  作用：自动按照类型注入

  注意：只要容器中有唯一的一个 bean 对象类型和要注入的变量类型匹配，就可以注入成功。

  ​			若 IoC 容器中没有任何 bean 的类型和要注入的变量类型匹配，则报错。

  ​			若 IoC 容器中有多个类型匹配时，使用要注入的对象变量名称作为 bean 的 id，在 spring 容器查找，找到了也可以注入成功。找不到就报错。

  出现位置：可以是变量上，也可以是方法上

  细节：在使用注解注入时，set 方法就不是必须的了

* `@Qualifier`

  作用：在 `@Autowired` 的基础上，再按照 Bean 的 id 注入

  注意：它在给类成员注入时不能独立使用，必须和 `@Autowire` 一起使用；但是给方法参数注入时可以独立使用。

  属性：value：用于指定注入 bean 的 id

* `@Resource` （需要导入javax.annotation-api）

  作用：直接按照 bean 的 id 注入，可独立使用

  属性：name：用于指定 bean 的 id

==以上三种只能注入其他 Bean 类型的数据，基本数据类型和 String 类型无法使用==

* `@Value`

  作用：用于注入基本类型和 String 类型的数据

  属性：value：用于指定数据的值，可以使用 Spring 中 SpEL（Spring 的 el 表达式）`${表达式}`

<span style="color:red">**列表等数据只能使用 XML 配置文件注入**</span>

### 用于改变作用范围的

他们的作用和在 XML 配置文件中的 scope 属性实现的功能是一样的

* `@Scope`

  作用：用于指定 bean 的作用范围

  属性：value：指定范围的取值（常用：singleton (default), prototype）

### 和生命周期相关

他们的作用和在 XML 配置文件中的 `<bean>` 标签中的 init-method, destory-method 属性的作用是一样的

* `@PostConstruct`：用于指定销毁方法
* `@PreDestroy`：用于指定初始化方法

## Spring 中的新注解

### @Configuration

指定当前类是一个配置类

细节：

​	当配置类作为 AnnotationConfigApplicationContext 对象创建的参数时，该注解可省略

### @ComponentScan

用于通过注解指定 Spring 在创建容器时要扫描的包

属性 value 和 basePackages 的作用一样，都是用于指定创建容器时要扫描的包

使用此注解等同于在 xml 中配置了 `<context:component-scan base-package=""/>`

### @Bean

用于把当前方法的返回值作为 bean 对象存入 Spring 的 IoC 容器中

属性 name：用于指定 bean 的 id，若不写，默认值为当前方法的名称。

细节：当使用注解配置方法时，若方法有参数，Spring 框架会去容器中查找有无可用的 bean 对象，查找的方式和 `@Autowired` 注解的作用是一样的

### @Import

用于导入其他的配置类，使用后，有 `@Import` 注解的类就是父配置类，导入的都是子配置类

属性 value：用于指定其他配置类的字节码

### @PropertySource

用于指定 properties 文件的位置

属性 value 指定文件的名称和路径，关键字 `classpath`，表示类路径下

## 整合 Junit 单元测试

1. 导入 Spring 整合 Junit 的 jar: [Spring Test](https://mvnrepository.com/artifact/org.springframework/spring-test)

   ``` xml
   <dependency>
     <groupId>org.springframework</groupId>
     <artifactId>spring-test</artifactId>
     <version>5.2.4.RELEASE</version>
     <scope>test</scope>
   </dependency>
   ```

2. 使用 Junit 提供的一个注解把原有的 main 方法替换了，替换成 Spring 提供的

   Junit 4 使用：`@Runwith(SpringJUnit4ClassRunner.class)`

   Junit 5 使用：`@ExtendWith(SpringExtension.class)`

3. 告知 Spring 的运行器，Spring 和 IoC 创建是基于 XML 还是注解的，并且说明位置

   使用 `@ContextConfiguration`

   属性 location 指定 XML 文件的位置，加上 classpath 关键字，表示在类路径下

   属性 classes 指定注解类所在地位置

注：当使用 Spring 5.x 版本的时候，要求 Junit 的 jar 包必须是 4.12 及以上

## AOP

### 基于 XML 的配置

Spring 中基于 XML 的 AOP 配置步骤

1. 把通知 Bean 也交给 Spring 管理

2. 使用 aop:config 标签表明开始 AOP 的配置

3. 使用 aop:aspect 标签表明配置切面

   id 属性：给切面提供一个唯一标识

   ref 属性：指定通知类 bean 的 id

4. 在 aop:aspect 标签的内部使用对象标签来配置通知的类型

   aop:before：表示配置前置通知

   ​	method 属性：用于指定 Logger 类中哪个方法是前置通知

   ​	pointcut 属性：用于指定切入点表达式，该表达式的含义指的是业务层中哪些方法增强
   
   后置通知和异常通知永远只会执行一个

``` xml
<!-- 开始配置 AOP -->
<aop:config>
  <!-- 配置切面 -->
  <aop:aspect id="logAdvice" ref="logger">
    <!-- 配置通知的类型, 且建立通知方法和切入点方法的关联 -->
    <!-- 前置通知: 在切入点方法执行之前执行 -->
    <aop:before method="beforePrintLog" pointcut="execution(* cn.morooi.service.impl.*.*(..))"/>

    <!-- 后置通知: 在切入点方法执行之后执行 -->
    <aop:after-returning method="afterReturningPrintLog" pointcut-ref="ptl"/>

    <!-- 异常通知: 在切入点方法产生异常之后执行 -->
    <aop:after-throwing method="afterThrowingPrintLog" pointcut-ref="ptl"/>

    <!-- 最终通知: 最终总会执行 -->
    <aop:after method="afterPrintLog" pointcut-ref="ptl"/>
    
    <!-- 配置切入点表达式: id 属性用于指定表达式的唯一标识; expression 属性指定表达式内容 -->
    <aop:pointcut id="ptl" expression="execution(* cn.morooi.service.impl.*.*(..))"/>
  </aop:aspect>
</aop:config>
```

### 环绕通知

它是 Spring 框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式

当配置了环绕通知之后，切入点方法没有执行，而通知方法执行了

解决：

Spring 框架提供了一个接口：ProceedingJoinPoint。该接口有一个方法 proceed()，此方法相当于明确调用切入点方法。该接口可以作为环绕通知的方法参数，在程序执行时，Spring 框架会为我们提供该接口的实现类

``` java
/**
 * 环绕通知
 */
public Object aroundPrintLog(ProceedingJoinPoint pjd) {
  Object returnValue = null;
  try {
    System.out.println("Logger 类中的 aroundPrintLog 方法开始记录日志了...前置");
    Object[] args = pjd.getArgs(); // 得到方法执行所需的参数
    returnValue = pjd.proceed(); // 明确调用业务层方法(切入点方法)
    System.out.println("Logger 类中的 aroundPrintLog 方法开始记录日志了...后置");
  } catch (Throwable throwable) {
    System.out.println("Logger 类中的 aroundPrintLog 方法开始记录日志了...异常");
    throwable.printStackTrace();
  } finally {
    System.out.println("Logger 类中的 aroundPrintLog 方法开始记录日志了...最终");
  }
  return returnValue;
}
```

### 切入点表达式的写法

关键字：`execution(表达式)`

表达式：

* 标准表达式：`访问修饰符 返回值 包名.包名..包名.类名.方法名(参数列表)`

  ```
  public void cn.morooi.service.impl.AccountServiceImpl.saveAccount()
  ```

* 访问修饰符可省略：`返回值 包名.包名..包名.类名.方法名(参数列表)`

  ```
  void cn.morooi.service.impl.AccountServiceImpl.saveAccount()
  ```

* 返回值可以使用通配符表示任意返回值：`* 包名.包名..包名.类名.方法名(参数列表)`

  ```
  * cn.morooi.service.impl.AccountServiceImpl.saveAccount()
  ```

* 包名可使用通配符表示任意包，但有几级包，就需要写几个 `*.`：`* *.*..*.类名.方法名(参数列表)`

  ```
  * *.*.*.*.AccountServiceImpl.saveAccount()
  ```

* 包名可以使用 `..` 表示当前包及其子包

  ```
  * *..AccountServiceImpl.saveAccount()
  ```

* 类名和方法名都可以使用 `*` 来实现通配

  ```
  * *..*.saveAccount()
  * *..*.*()
  ```

* 参数列表可直接写数据类型：

  基本类型直接写名称

  引用类型写 `包名.类名` 的方式

  可以使用通配符 `*` 表示任意类型，但必须有参数

  可以使用 `..` 表示有无参数均可，有参数可以是任意类型

* 全通配写法：`* *..*.*(...)`

### 实际开发中切入点表达式的通常写法

切到业务层实现类下的所有方法

```
* cn.morooi.service.impl.*.*(..)
```

## Spring 中基于 XML 的声明式事务控制

配置步骤：

1. 配置事务管理器

2. 配置事务的通知（需要导入事务的约束）

3. 配置 AOP 中的通用切入点表达式

4. 建立事务通知和切入点表达式的对应关系

5. 配置事务的属性，在事务的通知 `tx:advice` 标签内部

   `isolation`：指定事务的隔离级别。默认是 DEFAULT，表示使用数据库的默认隔离级别

   `propagation`：指定事务的传播行为。默认是 REQUIRED，表示一定有事务（增删改）。查询方法可选择 SUPPORTS

   `read-only`：指定事务是否只读。只有查询方法才能设置为 true，默认为 false，表示读写

   `timeout`：指定事务的超时时间，默认为 -1，表示永不超时。若指定数值，以秒为单位

   `rollback-for`：指定一个异常，产生该异常时，事务回滚；产生其他异常时，事务不回滚。没有默认值，表示任何异常都回滚

   `no-rollback-for`：用于指定一个异常，产生该异常时，事务不回滚；产生其他异常时，事务回滚。没有默认值，表示任何异常都回滚

## Spring 中基于注解的声明式事务控制

1. 配置事务管理器
2. 开启 Spring 对注解事务的支持
3. 在需要事务支持的地方使用 `@Transactional` 注解

   