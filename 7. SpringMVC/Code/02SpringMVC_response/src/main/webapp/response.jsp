<%--
  Created by IntelliJ IDEA.
  User: morooi
  Date: 2020/3/27
  Time: 20:18
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="zh-CN">
    <meta charset="UTF-8">
    <title>Response</title>
    <script src="js/jquery.min.js"></script>
    <script type="application/javascript">
        // 页面加载, 绑定单击事件
        $(function () {
            $("#btn").click(function () {
                // alert("hello btn")
                // 发送 Ajax 请求
                $.ajax({
                    // 编写 json, 设置属性和值
                    url: "user/testAjax",
                    contentType: "application/json;charset=UTF-8",
                    data: '{"username=": "heihei", "password": "123", "age": "12"}',
                    dataType: "json",
                    type: "POST",
                    success: function (data) {
                        // data: 服务器端响应的 json 的数据, 进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                })
            });
        });
    </script>
</head>
<body>

<p><a href="user/testString">testString</a></p>

<p><a href="user/testVoid">testVoid</a></p>

<p><a href="user/testModelAndView">testModelAndView</a></p>

<p><a href="user/testForwardOrRedirect">testForwardOrRedirect</a></p>

<button id="btn">发送 Ajax 的请求</button>

</body>
</html>
