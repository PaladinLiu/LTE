<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 覃66666
  Date: 2021/3/28
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@include file="../common/loginUserInfo.jsp"%>
    <table border="1">
        <tr>
            <td>id</td>
            <td>name</td>
            <td>isAdmin</td>
            <td>operation</td>
        </tr>
        <c:forEach items="${requestScope.users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.admin}</td>
                <c:if test="${user.admin == false}">
                    <td><a href="deleteUser?id=${user.id}">delete</a></td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
    <br>
    <form action="addUser" method="post">
        username:<input type="text" name="username">
        password:<input type="password" name="password">
        <input type="submit" value="添加">
    </form>
    <br>
</body>
</html>
