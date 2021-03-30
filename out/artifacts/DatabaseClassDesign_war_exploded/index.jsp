<%--
  Created by IntelliJ IDEA.
  User: 覃66666
  Date: 2021/3/27
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    <div>
        <form action="login" method="post">
            username:<input type="text" name="username"><br>
            password:<input type="password" name="password"><br>
            <input type="submit" value="登录"><br>
        </form>
        <p id="msg">${requestScope.msg}</p>
    </div>
</body>
</html>
