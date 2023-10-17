<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 11.09.2023
  Time: 08:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>price</th>
        <th>count</th>
    </tr>
    <c:forEach var="order" items="${orders}">
        <c:url var="descriptionButton" value="/description/${order.id}">
        </c:url>
        <c:url var="deleteButton" value="/deleteFromCart">
            <c:param name="delid" value="${order.id}"/>
        </c:url>
        <tr>
            <td>${order.id}</td>
            <td>${order.name}</td>
            <td>${order.price}</td>
            <td>${order.count}</td>
                <%--        <td>${order.count}</td>--%>
            <td>
                <input type="button" value="Description" onclick="window.location.href = '${descriptionButton}'">
            </td>

            <td>
                <input type="button" value="Delete" onclick="window.location.href = '${deleteButton}'">
            </td>

        </tr>
    </c:forEach>
</table>
<br>
<input type="button" value="Back" onclick="window.location.href = 'show'">
<br>
<input type="button" value="Buy" onclick="window.location.href = 'boughtPage'">
</body>
</html>
