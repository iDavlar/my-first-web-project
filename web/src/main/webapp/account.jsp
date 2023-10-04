<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"\>
<title>Личный кабинет</title>
</head>
<body>
<h2>Личный кабинет</h2>
<form action="auth">
  <label for="name">Имя:</label><br>
  <input type="text" id="name" name="name" value=${user.Name}>
  <span name="errorName">${errors.Name}</span>
  <br>

  <label for="age">Возраст:</label><br>
  <input type="number" id="age" name="age" min="12" max="100" title="От 12 до 100" value=${user.Age}>
  <span name="errorAge">${errors.Age}</span>
  <br>

  <label for="email">e-mail:</label><br>
  <input type="text" id="email" name="email" value=${user.Email}>
  <span name="errorEmail">${errors.Email}</span>
  <br>

  <label for="login">Логин:</label><br>
  <input type="text" id="login" name="login" value=${user.Login}>
  <span name="errorLogin">${errors.Login}</span>
  <br>

  <label for="pwd">Пароль:</label><br>
  <input type="password" id="pwd" name="pwd" value=${user.Password}>
  <span name="errorPassword">${errors.Password}</span>
  <br><br>

  <input type="submit" value="Изменить">
</form>

</body>
</html>

