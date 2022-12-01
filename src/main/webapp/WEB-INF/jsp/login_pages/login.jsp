<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../include/header.jsp" />
<div class="container">
    <form action="login" method="post">
        <div class="mb-3">
			<label for="username" class="form-label">Username</label>
			<input
				type="username"
				class="form-control"
				id="username"
				name="username"/>
		</div>
		<div class="row">
			<div class="col-6 mb-3">
				<label for="password" class="form-label">Password</label>
				<input
					type="password"
					class="form-control"
					id="password"
					name="password" />
			</div>
    </form>
</div>
<jsp:include page="../include/footer.jsp" />
