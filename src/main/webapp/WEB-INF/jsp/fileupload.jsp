<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="./include/header.jsp" />

<div class="container">
	<h1>File upload example</h1>
	<form method="POST" action="/fileuploadsubmit" enctype="multipart/form-data">
		<div class="row col-4 mb-2">Select a file to upload</div>
		<div class="row col-6 mb-3">
			<input type="file" name="file" />
		</div>
		<div class="row col-2 mb-1">
			<input class="btn btn-primary" type="submit" value="Submit" />
		</div>
	</form>
	<img src="${filename}" alt="uploaded image" />
</div>
<jsp:include page="./include/footer.jsp" />
