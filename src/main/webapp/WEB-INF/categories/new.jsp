<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Category</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<h1> New Category  </h1>
	<p> <form:errors class="alert alert-danger" path="newCategoryObj"/>   </p>
	
	<form:form action="/categories/new" method = "post" modelAttribute="newCategoryObj">
		<p>
			<form:label path="name">Name</form:label>
			<form:input path="name" class="form-control col-6"/>
		</p>
		<input class="btn btn-info" type="submit" value="Create a Category" />
	</form:form>
	
 	
	
	</div>
</body>
</html>