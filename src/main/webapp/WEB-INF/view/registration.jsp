<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 08.09.2023
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registration</title>
    <style>
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 50px;
        }

        label {
            font-size: 18px;
            margin-bottom: 10px;
        }

        input[type="text"],
        input[type="password"] {
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            width: 250px;
            margin-bottom: 20px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 18px;
        }

        input[type="submit"]:hover {
            background-color: #3e8e41;
        }

        p {
            font-size: 16px;
        }

        input[type="button"] {
            background-color: #008CBA;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 18px;
            margin-top: 20px;
        }

        input[type="button"]:hover {
            background-color: #006B8F;
        }
    </style>
</head>
<body>
<form action="save_user" method="post">
    <input type="hidden" name="enabled" value="1"/>
    <label for="username">Имя</label>
    <input type="text" name="username" id="username"/>
    <br/>
    <label for="password">пароль</label>
    <input type="password" name="password" id="password"/>
    <br/>
<%--    <label for="role">Роль</label>--%>
<%--    <input type="text" name="role" id="role"/>--%>
    <label>
        Роли
    </label>
    <label>
        <input type="checkbox" name="role" value="BUYER"> Покупатель
    </label>
    <label>
        <input type="checkbox" name="role" value="SALESMAN"> Продавец
    </label>
    <input type="submit" value="OK"/>
</form>
<%--<form:form action="/save_user" method="post" modelAttribute="user">--%>
<%--    <form:input type="hidden" path="enabled" value="1"/>--%>
<%--    <label for="username">Имя</label>--%>
<%--    <form:input type="text" path="username" id="username"/>--%>
<%--    <br/>--%>
<%--    <label for="password">пароль</label>--%>
<%--    <form:input type="password" path="password" id="password"/>--%>
<%--    <br/>--%>
<%--    <input type="submit" value="OK"/>--%>
<%--</form:form>--%>
</body>
</html>
