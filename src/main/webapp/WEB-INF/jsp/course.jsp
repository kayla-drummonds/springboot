<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width" />
		<title>Index</title>
	</head>
	<body>
		<h1>Create a new course</h1>
		<c:if test="${not empty errorMessages}">
			<c:forEach items="${errorMessages}" var="error">
				<p style="color: red">${error}</p>
			</c:forEach>
		</c:if>
		<form action="/courseSubmit" method="post">
			<label for="courseName">Course Name:</label>
			<input type="text" name="courseName" value="${courseName}" />
			<br />
			<br />
			<label for="instructorName">Instructor Name:</label>
			<input type="text" name="instructorName" value="${instructorName}" />
			<br />
			<br />
			<button type="submit">Submit</button>
		</form>
	</body>
</html>
