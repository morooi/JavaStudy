<%--
  Created by IntelliJ IDEA.
  User: morooi
  Date: 2020/3/27
  Time: 21:51
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="zh-CN">
    <meta charset="UTF-8">
    <title>文件上传</title>
</head>
<body>

<h3>传统的文件上传</h3>

<form action="user/fileUpload1" method="post" enctype="multipart/form-data">
    选择文件: <input type="file" name="upload"/><br/>
    <input type="submit" value="上传">
</form>

<h3>SpringMVC 的文件上传</h3>

<form action="user/fileUpload2" method="post" enctype="multipart/form-data">
    选择文件: <input type="file" name="upload"/><br/>
    <input type="submit" value="上传">
</form>

</body>
</html>
