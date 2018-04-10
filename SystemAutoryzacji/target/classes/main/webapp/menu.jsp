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

<div id="login">
  <div id="triangle"></div>
  <h1>Your options ${user.getUsername()}</h1>
  <div class="loginForm">
	  <a href="/standart.jsp">Service Content</a>
	  <a href="/premium.jsp">Service Prmium</a>
	  <a href="/profile">My Profile</a>
	  <a href="/setpremium">Set Premium Privilate to Users</a>
	  <a href="/setadmin">Set Admin Privilate to Users</a>
	  <a href="/">Log or Register (filter test)</a>
	  <form class="loginForm" action="logout" method="get">
	    <input type="submit" value="Log Out"/>
      </form>
  </div>
</div>

</body>
</html>