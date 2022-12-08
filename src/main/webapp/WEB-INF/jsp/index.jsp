<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="include/header.jsp" />
<h1>Hello, ${name}</h1>
<h2 style="text-align: center">Course Catalog</h2>
<form method="get" action="/">
	<label for="courseName">Course Name:</label>
	<input
		type="text"
		name="courseName"
		placeholder="Course Name"
		value="${courseName}" />
	<label for="instructorName">Search by Instructor</label>
	<input
		type="text"
		name="instructorName"
		placeholder="Instructor Name"
		value="${instructorName}" />
	<button type="submit">Search</button>
</form>
<table style="width: 100%">
	<thead>
		<tr>
			<th scope="col">Course ID</th>
			<th scope="col">Course Name</th>
			<th scope="col">Instructor</th>
			<th scope="col">Edit</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${courses}" var="course">
			<tr style="text-align: center">
				<td>${course.id}</td>
				<td>${course.name}</td>
				<td>${course.instructor}</td>
				<td><a href="/course/edit?id=${course.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<jsp:include page="include/footer.jsp" />
