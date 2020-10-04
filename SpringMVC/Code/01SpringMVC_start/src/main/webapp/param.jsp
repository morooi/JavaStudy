<%--
  Created by IntelliJ IDEA.
  User: morooi
  Date: 2020/3/27
  Time: 16:45
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="zh-CN">
    <meta charset="UTF-8">
    <title>参数绑定</title>
    <style>
        h2, td {
            text-align: center;
        }

        table {
            margin: auto;
        }

        .usertitle {
            font-weight: bold;
            font-size: large;
        }

    </style>
</head>
<body>

<%--请求参数绑定--%>

<%--
<a href="param/testParam?username=morooi">请求参数绑定</a>
--%>
<h2>参数绑定</h2>

<%--自定义类型转换器--%>
<form method="post" action="param/saveUser">
    <table>
        <tr>
            <td><label for="uname">用户姓名:</label></td>
            <td><input type="text" name="uname" id="uname"></td>
        </tr>
        <tr>
            <td><label for="age">用户年龄:</label></td>
            <td><input type="number" name="age" id="age"></td>
        </tr>
        <tr>
            <td><label for="birthday">用户生日:</label></td>
            <td><input type="text" name="birthday" id="birthday"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>


<%--
&lt;%&ndash; 把数据封装在 Account 类中, 类中存在 list 和 map 的集合 &ndash;%&gt;
<form method="post" action="param/saveAccount">
    <table>
        <tr>
            <td><label for="username">用户名:</label></td>
            <td><input type="text" name="username" id="username"></td>
        </tr>
        <tr>
            <td><label for="password">密码:</label></td>
            <td><input type="password" name="password" id="password"></td>
        </tr>
        <tr>
            <td><label for="money">金额:</label></td>
            <td><input type="number" name="money" id="money"></td>
        </tr>
        <tr>
            <td colspan="2" class="usertitle">用户1</td>
        </tr>
        <tr>
            <td><label for="uname1">用户姓名:</label></td>
            <td><input type="text" name="userList[0].uname" id="uname1"></td>
        </tr>
        <tr>
            <td><label for="age1">用户年龄:</label></td>
            <td><input type="number" name="userList[0].age" id="age1"></td>
        </tr>
        <tr>
            <td colspan="2" class="usertitle">用户2</td>
        </tr>
        <tr>
            <td><label for="uname2">用户姓名:</label></td>
            <td><input type="text" name="userMap['one'].uname" id="uname2"></td>
        </tr>
        <tr>
            <td><label for="age2">用户年龄:</label></td>
            <td><input type="number" name="userMap['one'].age" id="age2"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>--%>
<%--

<form method="post" action="param/saveAccount">
    <table>
        <tr>
            <td><label for="username">用户名:</label></td>
            <td><input type="text" name="username" id="username"></td>
        </tr>
        <tr>
            <td><label for="password">密码:</label></td>
            <td><input type="password" name="password" id="password"></td>
        </tr>
        <tr>
            <td><label for="money">金额:</label></td>
            <td><input type="number" name="money" id="money"></td>
        </tr>
        <tr>
            <td><label for="uname">用户姓名:</label></td>
            <td><input type="text" name="user.uname" id="uname"></td>
        </tr>
        <tr>
            <td><label for="age">用户年龄:</label></td>
            <td><input type="number" name="user.age" id="age"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交" id="button">
            </td>
        </tr>
    </table>
</form>
--%>


<a href="param/testServlet">Servlet 原生 API</a>

</body>
</html>
