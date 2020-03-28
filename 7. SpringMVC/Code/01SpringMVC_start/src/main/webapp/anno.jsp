<%--
  Created by IntelliJ IDEA.
  User: morooi
  Date: 2020/3/27
  Time: 18:18
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="zh-CN">
    <meta charset="UTF-8">
    <title>常用注解</title>
</head>
<body>

<a href="anno/testRequestParam?name=haha">RequestParam</a>

<br/>

<form method="post" action="anno/testRequestBody">
    <table>
        <tr>
            <td><label for="username">用户姓名:</label></td>
            <td><input type="text" name="username" id="username"></td>
        </tr>
        <tr>
            <td><label for="age">用户年龄:</label></td>
            <td><input type="number" name="age" id="age"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>

<br/>

<a href="anno/testPathVariable/10">PathVariable</a>
<br/>
<a href="anno/testCookieValue">CookieValue</a>

<form method="post" action="anno/testModelAttribute">
    <table>
        <tr>
            <td><label for="username2">用户姓名:</label></td>
            <td><input type="text" name="uname" id="username2"></td>
        </tr>
        <tr>
            <td><label for="age2">用户年龄:</label></td>
            <td><input type="number" name="age" id="age2"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>

<br/>
<a href="anno/testSessionAttributes">SessionAttributes</a><br/>
<a href="anno/getSessionAttributes">getSessionAttributes</a><br/>
<a href="anno/delSessionAttributes">delSessionAttributes</a><br/>

</body>
</html>
