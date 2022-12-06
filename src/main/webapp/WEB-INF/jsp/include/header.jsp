<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
			crossorigin="anonymous" />
			<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
		<title>Document</title>
	</head><body>
		<div class="row">
			<div class="col-10">
				<a href="/">Home</a>
				<a href="/user/createuser">Create User</a>
				<sec:authorize access="hasAnyAuthority('ADMIN')">
					<a href="/admin/admintest">Admin Test</a>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<a href="/ajax">AJAX</a>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<a href="/user/logout">Logout</a>
					<sec:authentication property="principal.username" />
				</sec:authorize>
				<sec:authorize access="!isAuthenticated()">
					<a href="/user/login">Login</a>
				</sec:authorize>
			</div>
		</div>
	</html>
