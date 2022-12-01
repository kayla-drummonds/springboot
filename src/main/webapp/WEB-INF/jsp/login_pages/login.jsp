<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />
<div class="container pt-3">
	<form action="/user/loginpost" method="post">
		<h1 class="text-center">Login</h1>
		<div class="row mb-3">
			<label for="username" class="form-label">Username</label>
			<input
				type="username"
				class="form-control"
				id="username"
				name="username" />
		</div>
		<div class="row mb-3">
			<label for="password" class="form-label">Password</label>
			<input
				type="password"
				class="form-control"
				id="password"
				name="password" />
		</div>
		<div class="justify-content-center">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>
</div>
<jsp:include page="../include/footer.jsp" />
