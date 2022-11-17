<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width" />
		<title>Index</title>
	</head>

	<body>
		<h1>Index Page ${name}</h1>
		<h2 style="text-align: center">Course Catalog</h2>
		<form method="get" action="/teksys/index">
			<label for="search">Search:</label>
			<input type="text" name="search" placeholder="Search" value="${search}" />
			<button type="submit">Search</button>
		</form>
		<table style="width: 100%">
			<thead>
				<tr>
					<th scope="col">Course ID</th>
					<th scope="col">Course Name</th>
					<th scope="col">Department ID</th>
					<th scope="col">Department Name</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${courses}" var="course">
					<tr style="text-align: center">
						<td>${course.id}</td>
						<td>${course.name}</td>
						<td>${course.department.id}</td>
						<td>${course.department.name}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>
