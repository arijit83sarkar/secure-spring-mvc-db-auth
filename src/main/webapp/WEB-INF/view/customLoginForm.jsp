<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Log In - Spring Security</title>
<%-- <link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css"> --%>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap')
	;

html, body {
	height: 100%;
}

body {
	font-family: 'Roboto', sans-serif;
	background-image: linear-gradient(to top, #7028e4 0%, #e5b2ca 100%);
}

.demo-container {
	height: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
}

.btn-lg {
	padding: 12px 26px;
	font-size: 14px;
	font-weight: 700;
	letter-spacing: 1px;
	text-transform: uppercase;
}

::placeholder {
	font-size: 14px;
	letter-spacing: 0.5px;
}

.form-control-lg {
	font-size: 16px;
	padding: 25px 20px;
}

.font-500 {
	font-weight: 500;
}
</style>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.css" />
<script src="https://code.jquery.com/jquery-3.4.1.slim.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.js"></script>
</head>
<body>
	<div class="demo-container">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-12 mx-auto">
					<div class="p-5 bg-white rounded shadow-lg">
						<h3 class="mb-2 text-center">Log In</h3>
						<p class="text-center lead">Log In to manage your account</p>
						<form:form
							action="${pageContext.request.contextPath}/authenticateTheUser"
							method="POST">
							<label class="font-500">User name</label>
							<input name="username" placeholder="enter username"
								class="form-control form-control-lg mb-3" type="text">

							<label class="font-500">Password</label>
							<input name="password" placeholder="enter password"
								class="form-control form-control-lg" type="password">

							<div style="margin-top: 20px; margin-top: 20px">
								<button type="submit"
									class="btn btn-primary btn-lg w-100 shadow-lg">LOG IN</button>
							</div>

							<div style="margin-top: 20px; margin-top: 20px">
								<!-- ERROR MESSAGE -->
								<c:if test="${param.error != null}">
									<div class="alert alert-danger col-xs-offset-1 col-xs-10">
										Invalid username and password!</div>
								</c:if>

								<!-- LOGOUT MESSAGE -->
								<c:if test="${param.logout != null}">
									<div class="alert alert-success col-xs-offset-1 col-xs-10">
										You've been successfully logged out!</div>
								</c:if>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>