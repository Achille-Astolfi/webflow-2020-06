<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<title>Hello Flow</title>
<c:url var="resources" value="/resources" />
<link rel="stylesheet"
	href="${ resources }/bootstrap/4.4.1/css/bootstrap.css" type="text/css">
</head>
<body>
	<div class="container">
		<h1>Hello Flow</h1>
		<p>Pagina iniziale di Hello Flow</p>
		<form:form action="${ flowExecutionUrl }" method="post"
			modelAttribute="flowBean">
			<div class="form-group">
				<form:label path="firstName">Nome</form:label>
				<form:input class="form-control" path="firstName"
					placeholder="Il tuo nome" />
				<form:errors path="firstName" class="text-danger"></form:errors>
			</div>
			<form:button type="submit" class="btn btn-primary" name="_eventId_success">Ok</form:button>
		</form:form>
	</div>
	<script type="text/javascript"
		src="${ resources }/jquery/3.4.1/jquery.js"></script>
	<script type="text/javascript"
		src="${ resources }/popper.js/1.14.7/popper.js"></script>
	<script type="text/javascript"
		src="${ resources }/bootstrap/4.4.1/js/bootstrap.js"></script>
</body>
</html>
