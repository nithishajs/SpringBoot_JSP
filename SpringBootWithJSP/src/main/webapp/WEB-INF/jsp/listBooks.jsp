<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Welcome to Java Training School Library</h1><br>
<div>${msg}</div><br>
<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Book Name</th>
			<th>Author</th>
			<th>Price</th>
			<th>Status</th>
			<th>Borrow</th>
		</tr>
		<c:forEach var="book" items="${listBooks}">
			<tr>
				<td>${book.id}</td>
				<td>${book.name}</td>
				<td>${book.author}</td>
				<td>${book.price}</td>
				<td>${book.status}</td>
				<c:if test="${book.status == 'available'}">  
   					<td><a href="borrow/${book.id}">Borrow</a></td>  
				</c:if> 
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="add">Add a Book</a>
</body>
</html>

