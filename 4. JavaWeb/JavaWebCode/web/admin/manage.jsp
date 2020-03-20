<%--
  Created by IntelliJ IDEA.
  User: morooi
  Date: 2020/3/20
  Time: 12:11
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="zh-CN">
    <meta charset="UTF-8">
    <title>管理页面</title>
</head>
<body>
这是管理页面
<%
    Object user = session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("../index.jsp");
//        request.getRequestDispatcher("/index.jsp").forward(request, response);
        return;
    }
%>
</body>
</html>
