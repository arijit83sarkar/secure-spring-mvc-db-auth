<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home - Spring Security</title>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	margin: 0;
}

.header {
	padding: 60px;
	text-align: center;
	background: #1abc9c;
	color: white;
	font-size: 30px;
}

.content {
	padding: 20px;
}
</style>
</head>
<body>
	<div class="header">
		<h1>Spring Security</h1>
		<p>Welcome to Spring Security with JDBC Authentication</p>
	</div>

	<div class="content">
		<h1>Home</h1>
		<p>In this tutorial we'll learn how to secure a Spring MVC
			application using the user stored in the database along with a custom
			login page and logout facility.</p>
		<p>
			<form:form action="${pageContext.request.contextPath}/logout"
				method="POST">
				<input type="submit" value="LOGOUT">
			</form:form>
		</p>
	</div>
</body>
</html>