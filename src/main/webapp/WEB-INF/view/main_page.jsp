<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 02.08.2023
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
Интернет магазин электроники
<br><br>
Войти
<input type="button" value="LogIn" onclick="window.location.href = 'hello'">
<br><br>
Посмотреть товары
<input type="button" value="Show" onclick="window.location.href = 'show'">
<%--<security:authorize access="hasRole('HR')">--%>
<%--    Information for HR--%>
<%--    <input type="button" value="Salary" onclick="window.location.href = 'hr'">--%>
<%--</security:authorize>--%>
<%--<br><br>--%>
<%--<security:authorize access="hasRole('MANAGER')">--%>
<%--    Information for Directors--%>
<%--    <input type="button" value="Documents" onclick="window.location.href = 'director'">--%>
<%--</security:authorize>--%>
</body>
</html>
