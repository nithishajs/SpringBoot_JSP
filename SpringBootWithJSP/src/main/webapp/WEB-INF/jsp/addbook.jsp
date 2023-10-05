<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<body>
	<h1>Add Book</h1>
	<form:form method="post" action="/addbook" modelAttribute="book">
		<table>
			<tr>
				<td>Book Name :</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Author :</td>
				<td><form:input path="author" /></td>
			</tr>
			<tr>
				<td>Price :</td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save Book" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>