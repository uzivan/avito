<%@ page import="com.try_security.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.try_security.entity.Order" %><%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 08.09.2023
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <%--    <style>--%>
    <%--        table {--%>
    <%--            border-collapse: collapse;--%>
    <%--            width: 100%;--%>
    <%--        }--%>

    <%--        th, td {--%>
    <%--            border: 1px solid #ddd;--%>
    <%--            padding: 8px;--%>
    <%--            text-align: left;--%>
    <%--        }--%>

    <%--        th {--%>
    <%--            background-color: #f2f2f2;--%>
    <%--        }--%>

    <%--        tr:nth-child(even) {--%>
    <%--            background-color: #f2f2f2;--%>
    <%--        }--%>
    <%--    </style>--%>
</head>
<body>
<br><br>
<security:authorize access="!hasRole('BUYER')">
    Для звказа необходимо войти
    <input type="button" value="LogIn" onclick="window.location.href = 'hello'">
    <br><br>
</security:authorize>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>price</th>
        <th>description</th>
    </tr>
    <c:forEach var="order" items="${orders}">

        <c:url var="descriptionButton" value="/description/${order.id}">
            <%--        <c:param name="delid" value="${del.id}"/>--%>
        </c:url>
        <%--    <c:url var="addButton" value="/addOrder">--%>
        <%--        <c:param name="id" value="${order.id}"/>--%>
        <%--    </c:url>--%>
        <tr>
            <td>${order.id}</td>
            <td>${order.name}</td>
            <td>${order.price}</td>
            <td>
                <input type="button" value="Show" onclick="window.location.href = '${descriptionButton}'">
            </td>
            <td>
                <security:authorize access="hasRole('BUYER')">
                    <form action="addOrder" method="post">
                        <input type="hidden" name="id" value="${order.id}"/>
                        <button type="submit">Add</button>
                    </form>
                </security:authorize>
            </td>
        </tr>
    </c:forEach>
</table>
<security:authorize access="hasRole('SALESMAN')">
    Добавить товары в продажу
    <input type="button" value="Add" onclick="window.location.href = 'set'">
    <br><br>
    Перейти на личную страницу проодавца
    <input type="button" value="Page" onclick="window.location.href = 'salesmanPage'">
</security:authorize>
</body>
</html>
