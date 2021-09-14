<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="entity.Users"%>

<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Users table</title>
</head>
	<body>
	
		<%@ include file="include/header.jsp"%>
	
		<div class="wrapper">
	
			<div style="margin-top: 110px; padding: 10px;">
				<button type="button" class="btn btn-info"
					onclick="window.location='${pageContext.request.contextPath}/OperationController?page=addUser';">Add
					new user</button>
			</div>
	
				<table class="table table-striped table-dark">
					<thead>
						<tr>
							<td>Id</td>
							<td>First name</td>
							<td>Last name</td>
							<td>Email</td>
							<td>Phone number</td>
							<td>Action</td>
						</tr>
					</thead>
			
						<c:forEach items="${users}" var="user">
				
							<c:url var="updateURL" value="OperationController">
								<c:param name="page" value="updateUserForm"></c:param>
								<c:param name="userID" value="${user.id}"></c:param>
								<c:param name="firstName" value="${user.firstName}"></c:param>
								<c:param name="lastName" value="${user.lastName}"></c:param>
								<c:param name="email" value="${user.email}"></c:param>
								<c:param name="phoneNumber" value="${user.phoneNumber}"></c:param>
							</c:url>
				
							<c:url var="deleteURL" value="OperationController">
								<c:param name="page" value="deleteUser"></c:param>
								<c:param name="userID" value="${user.id}"></c:param>
							</c:url>
				
							<tr>
								<td style="width: 100px;">${user.id}</td>
								<td style="width: 200px;">${user.firstName}</td>
								<td style="width: 200px;">${user.lastName}</td>
								<td style="width: 200px;">${user.email}</td>
								<td style="width: 200px;">${user.phoneNumber}</td>
				
								<td style="width: 200px;">

										<a href="${deleteURL}">
										<button class="btn btn-danger" 
										onclick="if(!confirm('Are you sure to delete the user ?')) return false">
										Delete
										</button>
										</a>
					
										<button 
										type="button" 
										class="btn btn-success"
										onclick="window.location='${updateURL}';">
										Edit
										</button>
								</td>
							</tr>
						</c:forEach>
				</table>
			<div class="push"></div>
		</div>
		<%@ include file="include/footer.jsp"%>
	</body>
</html>