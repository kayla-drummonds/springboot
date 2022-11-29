<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width" />
		<title>Index</title>
	</head>
	<body>
		<table>
			<thead>
				<th>Instructor</th>
				<th>Count</th>
			</thead>
			<tbody>
				<c:forEach items="${instructorCounts}" var="count">
					<tr>
						<td>${count.instructor}</td>
						<td>${count.cnt}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>
