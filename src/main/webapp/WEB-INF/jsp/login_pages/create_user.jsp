<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../include/header.jsp" />

<div class="container mt-3">
	<h1 class="text-center">Create User</h1>
	<form>
		<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">Email address</label>
			<input
				type="email"
				class="form-control"
				id="exampleInputEmail1"
				aria-describedby="emailHelp"
				name="email" />
			<div id="emailHelp" class="form-text">
				We'll never share your email with anyone else.
			</div>
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Password</label>
			<input
				type="password"
				class="form-control"
				id="exampleInputPassword1"
				name="password" />
		</div>
		<div class="row">
			<div class="col-6 mb-3">
				<label for="firstName" class="form-label">First Name</label>
				<input type="text" class="form-control" id="firstName" />
				<div id="firstNameHelp" class="form-text">
					Please give us your first name.
				</div>
			</div>
			<div class="col-6 mb-3">
				<label for="lastName" class="form-label">Last Name</label>
				<input type="text" class="form-control" id="lastName" name="lastName" />
				<div id="lastNameHelp" class="form-text">
					Please give us your last name.
				</div>
			</div>
		</div>
		<div class="mb-3">
			<label for="address" class="form-label">Address</label>
			<input type="text" class="form-control" id="address" />
			<div id="addressHelp" class="form-text">Please give us your address.</div>
		</div>
		<div class="row">
			<div class="col-4 mb-3">
				<label for="city" class="form-label">City</label>
				<input type="text" class="form-control" id="city" name="city" />
				<div id="cityHelp" class="form-text">Please give us your city.</div>
			</div>
			<div class="col-4 mb-3">
				<label for="state" class="form-label">State</label>
				<input type="text" class="form-control" id="state" />
				<div id="stateHelp" class="form-text">Please give us your state.</div>
			</div>
			<div class="col-4 mb-3">
				<label for="zip" class="form-label">ZIP Code</label>
				<input type="text" class="form-control" id="zip" name="zip" />
				<div id="zipHelp" class="form-text">Please give us your ZIP code.</div>
			</div>
		</div>
		<div class="mb-3">
			<label for="phone" class="form-label">Phone</label>
			<input type="phone" class="form-control" id="phone" />
			<div id="phoneHelp" class="form-text">
				Please give us your phone number.
			</div>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>

<jsp:include page="../include/footer.jsp" />
