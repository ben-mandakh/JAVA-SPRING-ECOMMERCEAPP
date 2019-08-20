<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<h1> New Product  </h1>
	<p> <form:errors class="alert alert-danger" path="newProductObj"/>   </p>
	
	<form:form action="/products/new" method = "post" modelAttribute="newProductObj">
		<p>
			<form:label path="name">Name</form:label>
			<form:input path="name" class="form-control col-6"/>
		</p>
		<p>
			<form:label path="description">Description</form:label>
			<form:input path="description" class="form-control col-6"/>
		</p>
		<p>
			<form:label path="price">Price</form:label>
			<form:input path="price" class="form-control col-6"/>
		</p>
		<input class="btn btn-info" type="submit" value="Create a Product" />
	</form:form>
	
 	
	
	</div>
</body>
</html>