<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width" />
		<title>New Student</title>
	</head>
	<body>
		<h1>Create a new student</h1>
		<c:if test="${not empty errorMessages}">
			<c:forEach items="${errorMessages}" var="error">
				<p style="color: red">${error}</p>
			</c:forEach>
		</c:if>
		<c:if test="${not empty successMessages}">
			<c:forEach items="${successMessages}" var="success">
				<p style="color: green">${success}</p>
			</c:forEach>
		</c:if>
		<form action="/studentSubmit">
			<label for="firstName">First Name:</label>
			<input type="text" name="firstName" value="${firstName}" />
			<br />
			<br />
			<label for="lastName">Last Name:</label>
			<input type="text" name="lastName" value="${lastName}" />
			<br />
			<br />
			<label for="city">City:</label>
			<input type="text" name="city" value="${city}" />
			<br />
			<br />
			<label for="state">State:</label>
			<input type="text" name="state" value="${state}" />
			<br />
			<br />
			<button type="submit">Submit</button>
		</form>
	</body>
</html>
