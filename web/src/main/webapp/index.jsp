<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"\>
<title>Авторизация</title>
</head>
<body>
<h2>Авторизация</h2>
<form name="login-form" method="post" action="auth">
  <label for="login">Логин:</label><br>
  <input type="text" id="login" name="login" value="${after.Login}">
  <br>

  <label for="pwd">Пароль:</label><br>
  <input type="password" id="pwd" name="pwd" value="${after.Password}">
  <br><br>

  <input type="submit" value="Войти"><span name="errorAuth">${errors.Auth}</span>
</form>
<p><a href="registration.jsp">Регистрация</a></p>
</body>
</html>

