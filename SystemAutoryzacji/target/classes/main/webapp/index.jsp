<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
<link rel="stylesheet" href="login.css"/>
</head>
</head>
<body>
<h1>Anonimowy uzytkownik nie ma dostepu do serwisu</h1>
<div class="row">
<div class="column">
<div id="login">
  <div id="triangle"></div>
  <h1>Log in</h1>
  <form class="loginForm" action="login" method="get">
    <input type="text" placeholder="Username" name="username" />
    <input type="password" placeholder="Password"  name="password"/>
    <input type="submit" value="Log in" />
  </form>
</div>
</div>
<div class="column">
<div id="login">
  <div id="triangle"></div>
  <h1>Registration</h1>
  <form class="registrationButtonForm" action="add" method="get">
    <input type="text" placeholder="Username" name="username" />
    <input type="email" placeholder="Email"  name="email"/>
    <input type="password" placeholder="Password"  name="password"/>
    <input type="password" placeholder="Confirm Password"  name="cpassword"/>
    
<label>Standart User
  <input type="radio" name="usertype" value="standart" checked="checked" >
</label>

<label>&nbspPrivilege User
  <input type="radio" name="usertype" value="privilaged"  >
</label>

<label>&nbspAdmin User
  <input type="radio" name="usertype" value="admin"  >
</label>

<div > &nbsp </div>


    <input type="submit" value="Register" />
  </form>
</div>
</div>
</div>
</body>
</html>