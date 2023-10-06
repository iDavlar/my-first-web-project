<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"\>
<title>Регистрация</title>
</head>
<body>
<h2>Регистрация</h2>
<form name="registration-form" method="post" action="registration">
  <label for="name">Имя:</label><br>
  <input type="text" id="name" name="name" placeholder="Введите имя" value="${after.Name}">
  <span name="errorName">${errors.Name}</span>
  <br>

  <label for="age">Возраст:</label><br>
  <input type="number" id="age" name="age" min="12" max="100" title="От 12 до 100" value=${after.Age}>
  <span name="errorAge">${errors.Age}</span>
  <br>

  <label for="email">e-mail:</label><br>
  <input type="text" id="email" name="email" placeholder="e-mail@mail.com" value="${after.Email}">
  <span name="errorEmail">${errors.Email}</span>
  <br>

  <label for="login">Логин:</label><br>
  <input type="text" id="login" name="login" placeholder="Придумайте логин" value="${after.Login}">
  <span name="errorLogin">${errors.Login}</span>
  <br>

  <label for="pwd">Пароль:</label><br>
  <input type="password" id="pwd" name="pwd" placeholder="Придумайте пароль" value="${after.Password}">
  <span name="errorPassword">${errors.Password}</span>
  <br><br>

  <input type="submit" value="Завершить">
</form>

</body>
</html>

