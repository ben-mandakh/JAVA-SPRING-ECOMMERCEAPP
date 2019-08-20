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
		<h1> <c:out value="${product.name}" /> </h1>
 		<div class="row">
			<div class="col">
				<h3> Categories </h3>
				<c:forEach items="${product.categories}" var="cat">
					<li> <c:out value="${cat.name }"></c:out> </li>
				</c:forEach>
				
			</div>
			
			<div class="col">
				<h3>Add categories</h3>
				<form:form action ="/addCategory" model ="post" modelAttribute="middleTableObj">
					<form:select path= "category" class="form-control col-6">
						<c:forEach items="${allCats }" var="cat">
							<form:option value="${cat.id}">
								<c:out value="${cat.name }"></c:out>
							</form:option>
						</c:forEach>
					</form:select>
					<form:hidden path="product" value="${product.id }"/>
					<input type="submit" value="Add category" class="btn btn-info">
					
				</form:form>			
			</div> 		
 		
 		</div>
	</div>
</body>
</html>