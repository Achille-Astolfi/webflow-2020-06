<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:url var="resources" value="/resources" />
<link rel="stylesheet"
	href="${ resources }/bootstrap/4.4.1/css/bootstrap.css" type="text/css">
</head>
<body>
	<div class="container">
		<!-- PICK AN ELEMENT -->
		<form:form action="${ flowExecutionUrl }" method="post"
			modelAttribute="flowBean">
			<!-- TEXT FIELD -->
			<div class="form-group">
				<form:label path="textProperty">Nome</form:label>
				<form:input class="form-control" path="textProperty"
					placeholder="Text field" />
				<form:errors path="textProperty" class="text-danger"></form:errors>
			</div>
			<!-- PASSWORD FIELD -->
			<div class="form-group">
				<form:label path="passwordProperty">Password</form:label>
				<form:password class="form-control" path="passwordProperty"
					placeholder="Password field" />
				<form:errors path="passwordProperty" class="text-danger"></form:errors>
			</div>
			<!-- CHECKBOX FIELD -->
			<div class="form-group form-check">
				<form:checkbox class="form-check-input" path="checkboxProperty" />
				<form:label class="form-check-label" path="checkboxProperty">Checkbox field.</form:label>
				<br>
				<form:errors path="checkboxProperty" class="text-danger"></form:errors>
			</div>
			<!-- RADIOBUTTON FIELDS -->
			<div class="form-group">
				<div class="form-check form-check-inline">
					<form:radiobutton class="form-check-input" path="radioProperty"
						value="A" />
					<form:label class="form-check-label" path="radioProperty"
						for="radioProperty1">Radio value A</form:label>
				</div>
				<div class="form-check form-check-inline">
					<form:radiobutton class="form-check-input" path="radioProperty"
						value="B" />
					<form:label class="form-check-label" path="radioProperty"
						for="radioProperty2">Radio value B</form:label>
				</div>
				<div class="form-check form-check-inline">
					<form:radiobutton class="form-check-input" path="radioProperty"
						value="C" />
					<form:label class="form-check-label" path="radioProperty"
						for="radioProperty3">Radio value C</form:label>
				</div>
				<br>
				<form:errors path="radioProperty" class="text-danger"></form:errors>
			</div>
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
