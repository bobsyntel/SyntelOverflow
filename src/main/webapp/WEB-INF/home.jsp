<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
  <h1>Welcome to home page <c:out value="${currentUser.username }"></c:out></h1>
  <h1>Welcome to home page <c:out value="${currentUser.id }"></c:out></h1>
  
  <form id="logoutForm" method="POST" action="/logout">
  	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }"/>
  	<input type="submit" value="Logout!"/>
  </form>
  <a href="/questions/new/${currentUser.id}">Ask Question</a>
</body>
</html>