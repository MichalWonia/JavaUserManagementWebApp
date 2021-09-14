<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page isELIgnored="false"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<link href="css/styles_form.css" rel="stylesheet" />
<title>Add new user</title>

</head>

<body>

<h2 style="font-family:courier; text-align: center;">Fill the missing fields:</h2>

<div>
  <form action="${pageContext.request.contextPath}/OperationController" id="login-form" method="post">
    	<label>First name: </label> <input type="text" name="firstName" value="${param.firstName}" required>
		<label>Last name: </label> <input type="text" name="lastName" value="${param.lastName}" required> 
		<label>Email: </label> <input type="email" name="email" value="${param.email}" required> 
		<label>Phone number: </label> <input type="text" name="phoneNumber" value="${param.phoneNumber}" required> 
		<input type="hidden" name="userID" value="${param.userID}"/>
		<input type="hidden" name="operation" value="updateUserOperation"> 
		<input type="submit" value="Submit">
  </form>
</div>

</body>

</html>