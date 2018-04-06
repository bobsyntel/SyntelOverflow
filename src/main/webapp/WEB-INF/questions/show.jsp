<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question</title>
</head>
<body>
<h1>Show</h1>

  <h1> <c:out value="${question.getTitle() }"/></h1> 
  <br>
   <h2><c:out value="${question.getContent() }"/></h2> 
   <h3>Answers</h3>
   <a href="/answers/new/${question.getId()}">Answer Question</a>  <a href="/comments/new/${question.getId()}">Comment</a>
   <c:forEach var="ans" items="${question.answers}">
						
							<td><c:out value="${ans.content}" /></td>
	</c:forEach>
	<h1>Add your comment</h1>
	<form:form action="/comment/create" method="POST" modelAttribute="Cmodel">
   <form:input type="hidden" path="question" value="${question.id}"/>
   <form:input type="hidden" path="user" value="${userId.id}"/>
     
     <form:label path="content">Answer :</form:label>
      <br>
      <form:textarea path="content"  type="text" rows="10" cols="40"/>
      
      <br>
     <input type="submit" name="Add a COMMENT!"/>
   </form:form>
   <h1>Add your answer :</h1>
   <form:form action="/answer/create" method="POST" modelAttribute="Amodel">
   <form:input type="hidden" path="question" value="${question.id}"/>
   <form:input type="hidden" path="user" value="${userId.id}"/>
     
     <form:label path="content">Answer :</form:label>
      <br>
      <form:textarea path="content"  type="text" rows="10" cols="40"/>
      
      <br>
     <input type="submit" name="Answer it!"/>
   </form:form>
   
   
   
   

</body>
</html>