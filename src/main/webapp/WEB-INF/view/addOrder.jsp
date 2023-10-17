<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 12.09.2023
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<form:form action="/setOrder" modelAttribute="order">--%>
<%--    <form:input type="hidden" path="id"/>--%>
<%--    name <form:input  path="name"/>--%>
<%--    <br>--%>
<%--    count <form:input path="count"/>--%>
<%--    <br>--%>
<%--    privce <form:input path="price"/>--%>
<%--    <br>--%>
<%--    description<form:input path="description"/>--%>
<%--    <br>--%>
<%--    <input type="submit" value="OK">--%>
<%--</form:form>--%>

<form action="set" method="POST">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name">
    <br>
    <label for="price">Price:</label>
    <input type="number" id="price" name="price">
    <br>
    <label for="count">Count:</label>
    <input type="number" id="count" name="count">
    <br>
    <label for="description">Description:</label>
    <input type="text" id="description" name="description">
    <br>
    <input type="submit" value="Submit">
</form>

</body>
</html>
