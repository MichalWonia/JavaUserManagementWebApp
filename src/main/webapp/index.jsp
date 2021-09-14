<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Users Management App</title>

</head>
<body>

	<%@ include file="include/header.jsp"%>
	
	<div class="wrapper">
			<div style="margin-top: 150px;">
				<h1>Users management application</h1>
				<h3>
					Click here to start: <button type="button" class="btn btn-info"
						onclick="window.location='${pageContext.request.contextPath}/SiteController?page=usersTable';">Manage
						users</button>
				</h3>
			</div>
		<div class="push"></div>
	</div>
	
	<%@ include file="include/footer.jsp"%>

</body>
</html>