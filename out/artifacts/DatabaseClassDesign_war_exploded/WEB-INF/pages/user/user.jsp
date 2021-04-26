<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 覃66666
  Date: 2021/3/28
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user</title>
</head>
<body>
    <%@include file="../common/loginUserInfo.jsp"%>
    <a href="logout">注销</a><br>
    <a href="query">查询</a><br>
    <a href="analysis">c2i分析</a><br>
    <c:if test="${sessionScope.user.admin}">
        <a href="userManage">用户管理</a><br>
        <a href="dataManage">数据管理</a><br>
        <a href="dbManage">数据库管理</a><br>
    </c:if>
    <br>
</body>
</html>
