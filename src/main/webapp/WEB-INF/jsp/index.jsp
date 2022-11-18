<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width" />
		<title>Index</title>
	</head>

	<body>
		<h1>Hello, ${name}</h1>
		<h2 style="text-align: center">Course Catalog</h2>
		<form method="get" action="/teksys/index">
			<label for="searchName">Search by Course Name:</label>
			<input
				type="text"
				name="searchName"
				placeholder="Course Name"
				value="${searchName}" />
			<label for="searchInstructor">Search by Instructor</label>
			<input
				type="text"
				name="searchInstructor"
				placeholder="Instructor Name"
				value="${searchInstructor}" />
			<button type="submit">Search</button>
		</form>
		<table style="width: 100%">
			<thead>
				<tr>
					<th scope="col">Course ID</th>
					<th scope="col">Course Name</th>
					<th scope="col">Instructor</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${coursesByName}" var="course">
					<tr style="text-align: center">
						<td>${course.id}</td>
						<td>${course.name}</td>
						<td>${course.instructor}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>
