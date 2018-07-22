<%--
  Created by IntelliJ IDEA.
  User: zhouzhu
  Date: 18-7-21
  Time: 下午5:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style type="text/css">
        .error{color: red}
    </style>
</head>
<body>
    <div class="error">${error}</div>
    <form action="${pageContext.request.contextPath}/formfilterlogin" method="post">
        用户名：<input type="text" name="username"/><br/>
        密码：<input type="text" name="password"><br/>
        <input type="submit" value="登录">
    </form>
</body>
</html>
