<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 09.09.2023
  Time: 00:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Description</title>
</head>
<body>
<p>name ${order.name}</p>
<p>price ${order.price}</p>
<p>description ${order.description}</p>
<input type="button" value="Back" onclick="window.location.href = '/spr_sec/show'">
</body>
</html>
