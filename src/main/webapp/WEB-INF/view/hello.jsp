<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 08.09.2023
  Time: 01:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>authentication</title>
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
<form
        name="f"
        method="post"
        action="process_login"
>
    <label for="username">Имя</label>
    <input type="text" name="username" id="username" value="" />
    <br />
    <label for="password">Пароль</label>
    <input type="password" name="password" id="password" value="" />
    <br />
    <input type="submit" value="Войти" />

    <c:if test="${not empty param.error}">
        <p style="color: red;">Неправильный пароль</p>
    </c:if>
    <br/>
    Зарегистрироваться
    <input type="button" value="Регистрация" onclick="window.location.href = 'registration'">
</form>
</body>
<%--<script defer>--%>
<%--    window.addEventListener('load', () => {--%>
<%--        const form = document.getElementsByName('f')[0]--%>
<%--        console.log(form)--%>
<%--        form.addEventListener('submit', async (e) => {--%>
<%--            e.preventDefault()--%>
<%--            const username = e.target.username.value--%>
<%--            const password = e.target.password.value--%>
<%--            const response = await fetch('/save_user', {--%>
<%--                method: 'POST',--%>
<%--                headers: {--%>
<%--                    contentType: 'Application/JSON',--%>
<%--                },--%>
<%--                body: JSON.stringify({username, password, role: 'BUYER'})--%>
<%--            })--%>
<%--            const data = await response.json()--%>
<%--        })--%>
<%--    })--%>
<%--</script>--%>
</html>
