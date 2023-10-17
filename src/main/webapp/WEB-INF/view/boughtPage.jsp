<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 15.09.2023
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    `
<html>
<head>
    <title>Bought page</title>
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
        <tr>
            <td>${order.id}</td>
            <td>${order.name}</td>
            <td>${order.price}</td>
            <td>${order.count}</td>
            <c:set var="sum" value="${sum + order.price*order.count}" />
        </tr>
    </c:forEach>
</table>
<p>Сумма: ${sum}</p>
</body>
</html>
