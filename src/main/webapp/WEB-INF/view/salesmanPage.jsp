<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 15.09.2023
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SalesmanPage</title>
</head>
<body>
Товары в продаже
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>price</th>
        <th>count</th>
    </tr>
    <c:forEach var="orderOnSale" items="${ordersOnSale}">
        <c:url var="deleteButton" value="/deleteOrder">
            <c:param name="delid" value="${order.id}"/>
        </c:url>
        <tr>
            <td>${orderOnSale.id}</td>
            <td>${orderOnSale.name}</td>
            <td>${orderOnSale.price}</td>
            <td>${orderOnSale.count}</td>
            <td>
                <input type="button" value="Delete" onclick="window.location.href = '${deleteButton}'">
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<br>
Товары в корзинах
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>price</th>
        <th>count</th>
    </tr>
    <c:forEach var="orderInCart" items="${ordersInCart}">
        <tr>
            <td>${orderInCart.id}</td>
            <td>${orderInCart.name}</td>
            <td>${orderInCart.price}</td>
            <td>${orderInCart.count}</td>
        </tr>
    </c:forEach>
</table>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>price</th>
        <th>count</th>
    </tr>
    <c:forEach var="orderBought" items="${ordersBought}">
        <tr>
            <td>${orderBought.id}</td>
            <td>${orderBought.name}</td>
            <td>${orderBought.price}</td>
            <td>${orderBought.count}</td>
            <c:set var="sum" value="${sum + orderBought.price*orderBought.count}" />
        </tr>
    </c:forEach>
</table>
<p>Сумма: ${sum}</p>
</body>
</html>
