<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Set Premium</title>
</head>
</head>
<body>
<h1>Set Premium Users</h1>
There is ${userslist.size()} users
<form class="loginForm" action="dosetpremium" method="get">
<table>
            <tbody>
            
                <c:forEach items="${userslist}" var="User">
                
                
                
                <tr>
                    <td>${User.getEmail()}</td>
                    <td><input type="checkbox" placeholder="privilage" name="privilage" value="${User.getEmail()}" <c:if test="${User.IsPrivilaged()}">checked="checked"</c:if>/></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <input type="submit" value="Set Premium" />
        </form>

</body>
</html>