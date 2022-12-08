<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../include/header.jsp" />

<div class="container mt-3">
	<c:if test="${empty form.id}">
		<h1 class="text-center">Create Course</h1>
	</c:if>
	<c:if test="${not empty form.id}">
		<h1 class="text-center">Edit Course</h1>
	</c:if>
	<c:if test="${not empty bindingResult.getAllErrors()}">
		<c:forEach items="${bindingResult.getAllErrors()}" var="error">
			<p style="color: red">${error.getDefaultMessage()}</p>
		</c:forEach>
	</c:if>
	<form action="/course/save" method="post">
		<input type="hidden" name="id" value="${form.id}" />
		<div class="row mb-3">
			<label for="name" class="form-label">Course name:</label>
			<input
				type="text"
				class="form-control"
				id="name"
				name="name"
				value="${form.name}" />
		</div>
		<div class="row mb-3">
			<label for="instructor" class="form-label">Instructor:</label>
			<input
				type="text"
				class="form-control"
				id="instructor"
				name="instructor"
				value="${form.instructor}" />
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>

<jsp:include page="../include/footer.jsp" />
