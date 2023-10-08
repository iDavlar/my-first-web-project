<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"\>
<title>Личный кабинет</title>
</head>
<body>
<h2>Личный кабинет</h2>
<form name="user-data-form" method="post" action="account">
  <label for="name">Имя:</label><br>
  <input type="text" id="name" name="name" value=${after.Name}>
  <span name="errorName">${errors.Name}</span>
  <br>

  <label for="age">Возраст:</label><br>
  <input type="number" id="age" name="age" min="12" max="100" title="От 12 до 100" value=${after.Age}>
  <span name="errorAge">${errors.Age}</span>
  <br>

  <label for="email">e-mail:</label><br>
  <input type="text" id="email" name="email" value=${after.Email}>
  <span name="errorEmail">${errors.Email}</span>
  <br>

  <label for="login">Логин:</label><br>
  <input type="text" id="login" name="login" value=${after.Login}>
  <span name="errorLogin">${errors.Login}</span>
  <br>

  <label for="pwd">Пароль:</label><br>
  <input type="password" id="pwd" name="pwd" value=${after.Password}>
  <span name="errorPassword">${errors.Password}</span>
  <br><br>

  <input type="submit" value="Изменить">
  <span name="errorPassword">${errors.Status}</span>
</form>
<p><a href="menu.jsp">Меню</a></p>

</body>
</html>

