<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Question</title>
</head>
<body>
		<h1>Welcome to home page <c:out value="${userId}"></c:out></h1>

		 <form:form method="POST" action="/new" modelAttribute="newQuestion">
 	<p>	
 		<form:input type="hidden" path="user" value="${userId}"/>
 	 	<form:label path="title">Title:</form:label>
 	 	<form:input path="title"/>
 	 	<br>
 	 </p>
 	 <p>	
 	 	<form:label path="content">Content:</form:label>
 	 	<form:textarea type="text" path="content" rows="4" cols="50"/>
 	 	<br>
 	 </p>
 			
 	 	<br>
 	 <input type="submit" value="Ask"/>
 </form:form>

</body>
</html>