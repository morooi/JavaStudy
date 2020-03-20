# Java Web 笔记

[TOC]

## JSP 页面元素

元素：HTML、Java 代码（脚本 Scriptlet）、指令、注释

### 脚本 Scriptlet（有三种形式）

1. <%   %> —— 局部变量、Java语句

  ``` jsp
  <%
  System.out.println("输出到了控制台");
  %>
  ```

2. <%!  %> —— 全局变量、方法

   ``` jsp
   <%!
   	public String name;
   	public void init(String name) {
         this.name = name;
     } 
   %>
   
   <%
     String name = "Java";
     init(name);
   %>
   ```
   
3. <%=  %> —— 输出表达式

   ``` jsp
   <%="输出表达式: " + name%>
   ```

### 指令

JSP 指令: http://www.runoob.com/JSP/JSP-directives.html

一般使用 Page 指令：`<%@ page ... %>`

page 指定的属性：

* **language**：JSP 页面使用的语言
* **import**：导入类
* **pageEncoding**：JSP 文件自身编码
* **contentType**：浏览器解析 JSP 的编码

``` jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" 
  	pageEncoding="UTF-8" import="java.util.Date"%>
```

### 注释

* HTML 注释：`<!--注释-->`
* Java 注释：`//   /*....*/`
* JSP 注释：`<%-- --%>`

## JSP 内置对象

JSP 九大内置对象，自带的，不需要 `new` 也能使用的对象。

### 输出对象：out

作用：输出对象，向客户端输出内容

---

### 请求对象：request

作用：请求对象、存储客户端向服务端发出的请求信息

**常见方法：**

1. String getParameter(String name): 根据请求的字段名 key（input 标签的 name 属性值），返回字段值 value（input 标签的 value 属性值）

2. String[] getParametersValues(String name): 根据请求的字段名 key，返回多个字段值 value（CheckBox）

3. void setCharacterEncoding(编码格式): 设置 post 方式的请求编码（不设就为默认，tomcat7以前iso-8859-1，tomcat8以后UTF-8）

4. getRequestDispatcher().forward(): 请求转发的方式跳转页面 A->B
5. getServerContext(): 获取项目的 ServletContext 对象

示例：/request register.jsp -> show.jsp



get 提交方式：method="get" 和地址栏、超链接（\<a href="xx">）请求方式，默认都属于 get 提交方式

**get、post 两种提交方式的区别：**

1. get 方式在地址栏显示请求信息（但是地址栏能够容纳的信息有限，4-5 KB），post 不显示

2. 文件上传操作，必须是 post

推荐使用 post

---

### 响应对象：response

作用：响应对象

**常见方法：**

1. Void addCookie(Cookie cookie): 服务端向客户端增加 cookie 对象
2. void sendRedirect(String location) throws IOException: 页面跳转的一种方式（重定向）
3. void setContentType(String type): 设置服务端响应的编码（设置服务端的 content 编码）

示例：/response login.jsp -> check.jsp -> success.jsp



**请求转发与重定向的区别**

请求转发：request.getRequestDispatcher().forward()

重定向：response.sendRedirect()

|           区别           |     请求转发     |         重定向         |
| :----------------------: | :--------------: | :--------------------: |
|      地址栏是否改变      | 不变 (check.jsp) |   会变 (success.jsp)   |
| 是否保留首次请求时的数据 |       保留       |         不保留         |
|        请求的次数        |        1         |           2            |
|      跳转发生的位置      |      服务端      | 客户端发出的第二次跳转 |

---

### 会话对象：session

**Cookie**

Cookie（客户端，不是内置对象）：Cookie 是由服务端生成的，再发送给客户端保存，相当于本地缓存的作用 -> 提高访问服务端的效率，但是安全性较差。

Cookie 不是内置对象，要使用必须 new

Cookie: key=value

``` java
import javax.servlet.http.Cookie

public Cookie(String name, String value)
String getName() // 获取 name
String getValue() // 获取 value
void setMaxAge(int expiry) // 设置最大有效期（秒）
```

服务端准备 Cookie ：response.addCookie(Cookie cookie)	（response 对象）

页面跳转（转发、重定向）

客户端获取 Cookie：requese.getCookies()	（request 对象）

**客户端不能直接获取某一个单独对象，只能一次性将全部的 cookie 拿到**

例：/cookie



**session**

session 会话（开始到结束）

> 浏览网站：开始-关闭
>
> 购物：浏览、付款、退出
>
> 电子邮件：浏览、写邮件、退出

在 Cookies 中，除了自己设置的 Cookie 对象外，还有一个名字为 JSESSIONID 的 Cookie（在第一次请求时服务端自动产生）

**session 机制：**

1. 客户端第一次请求服务端时（JSESSIONID != sessionID），服务端会产生一个 seesion 对象（用于保存该客户的信息），并且每个 session 对象都会有一个唯一的 sessionID（用于区分其他 session）。
2. 服务端会产生一个 Cookie，并且该 Cookie 的 name=JSESSIONID, value=sessionID
3. 服务端会在响应客户端的同时将该 Cookie 发送给客户端，至此客户端就有了一个名为 JSESSIONID 的 Cookie
4. 因此客户端的 Cookie 就可以和服务端的 session 对应（JSESSIONID = sessionID）

* 客户端第二次或第 N 次请求服务端时，服务端会先根据客户端 Cookie 中的 JSESSIONID 去服务端的 session 中匹配 sessionID，如果匹配成功，说明不是第一次访问

注意：

* session 存储在服务端

* session 是在同一个用户（客户）请求时共享
* 实现机制：第一次客户请求时产生一个 sessionID 并复制给 Cookie 的 JSESSIONID 然后发送给客户端

**session 方法：**

```java
String getId() // 获取 sessionID
boolean isNew() // 判断是否是新用户（第一次访问）
void invalidate() // 使 session 失效（退出登录、注销）
  
void setAttribute()
Object getAttribute()
  
void setMaxInactiveInterval(秒) // 设置最大有效非活动时间
int getMaxInactiveInterval()
```

示例：/session



**session 和 Cookie 的区别**

|   区别点   | session |  Cookie  |
| :--------: | :-----: | :------: |
| 保存的位置 | 服务端  |  客户端  |
|   安全性   | 较安全  | 较不安全 |
| 保存的内容 | Object  |  String  |

---

### 全局对象：application

``` java
String getContextPath() // 获取虚拟路径
String getRealPath(String name) // 获取绝对路径（虚拟路径相对的绝对路径）
```



---

### JSP页面容器：pageContext

有些地方称 page 对象

### config



### page

### exception

## 四种范围对象

作用范围从小到大，对象的范围越大，造成的性能损耗越大（尽量使用最小的范围）

|           对象           |                 范围                 |
| :----------------------: | :----------------------------------: |
| pageContext JSP 页面容器 |      当前页面有效（跳转后无效）      |
|     request 请求对象     |    同一次请求有效（重定向后无效）    |
|     session 会话对象     | 同一次会话有效（无论怎么跳转都有效） |
|   application 全局对象   |  全局有效（整个项目运行期间都有效）  |

共有的方法：

``` java
Object getAttribute(String name) // 根据属性名或属性值获取
void setAttribute(String name, Object obj) // 设置属性值（新增、修改）
void removeAttribute(String name) // 根据属性名，删除对象
```