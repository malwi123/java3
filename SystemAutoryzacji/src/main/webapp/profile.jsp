<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
<link rel="stylesheet" href="login.css"/>
</head>
</head>
<body>
<div id="login">
  <div id="triangle"></div>
  <h1>Dane Uzytkownika</h1>
  
	<div class="row">
	<div class="column">
	<label> Username: </label>
	</div>
	<div class="column">
	<label> ${user.getUsername()} </label>
	</div>
	</div>
	
	<div class="row">
	<div class="column">
	<label> Email: </label>
	</div>
	<div class="column">
	<label> ${user.getEmail()} </label>
	</div>
	</div>
	
	<div class="row">
	<div class="column">
	<label> Type: </label>
	</div>
	<div class="column">
	<label> ${user.getUserType()} </label>
	</div>
	</div>
	
</div>

</body>
</html>