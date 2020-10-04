<%--
  Created by IntelliJ IDEA.
  User: morooi
  Date: 2020/3/27
  Time: 13:52
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="zh-CN">
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h3>入门成功</h3>

<%=request.getAttribute("msg")%>
<%=session.getAttribute("msg")%>

</body>
</html>
