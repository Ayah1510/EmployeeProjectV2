<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="http://yui.yahooapis.com/3.5.1/build/cssreset/cssreset-min.css">
<link rel="stylesheet" href="/css/styles.css">
<title>Insert title here</title>
</head>

<body>

	<div class="menu">
		<h1>Employee Project</h1>
		<ul>
			<li><a href="${ContextRoot}/employee/${employee.id}">Employees</a></li>
			<li><a href="${ContextRoot}/project/${employee.id}">Projects</a></li>
			<li><a href="${ContextRoot}/task/${employee.id}">Tasks</a></li>
			<li><a href="${ContextRoot}/department/${employee.id}">Departments</a></li>
			<li><a href="${ContextRoot}/qualification/${employee.id}">Qualifications</a></li>

		</ul>
	</div>


</body>
</html>