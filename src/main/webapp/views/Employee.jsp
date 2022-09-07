<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/styles.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jQuery.js"/></script>

<title>Employees</title>
</head>
<body>
	<div class="menu">
		<ul>
			<li><a href="${ContextRoot}/employee/${employee.id}">Employees</a></li>
			<li><a href="${ContextRoot}/project/${employee.id}">Projects</a></li>
			<li><a href="${ContextRoot}/task/${employee.id}">Tasks</a></li>
			<li><a href="${ContextRoot}/department/${employee.id}">Departments</a></li>
			<li><a href="${ContextRoot}/qualification/${employee.id}">Qualifications</a></li>
		</ul>
	</div>
	<div align="center">
		<h1>List of Employees</h1>
		<table border="1" cellpadding="5">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Birth Date</th>
				<th>Phone Number</th>
				<th>Gender</th>
				<th>Department</th>
				<th>Tasks</th>
				<th>Qualifications</th>
				<th>Projects</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach var="employee" items="${employees}">
				<tr>
					<td><c:out value="${employee.id}" /></td>
					<td><c:out value="${employee.name}" /></td>
					<td><c:out value="${employee.birthDate}" /></td>
					<td><c:out value="${employee.phone}" /></td>
					<td><c:out value="${employee.gender}" /></td>
					<td><c:out value="${employee.department.getDepName()}" /></td>
					<td><a href="${ContextRoot}/task-employee/${employee.id}">Tasks</a></td>
					<td><a
						href="${ContextRoot}/qualification-employee/${employee.id}">Qualifications</a></td>
					<td><a href="${ContextRoot}/project-employee/${employee.id}">Projects</a></td>
					<td><form method="post">
							<a href="${ContextRoot}/employee/${employee.id}">Edit</a>
						</form></td>
					<td><form method="post">
							<a href="${ContextRoot}/employee/delete/${employee.id}">Delete</a>
						</form></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<button>
		<form method="post">
			<a href="${contextRoot}/employee/insertion/">Add New Employee</a>
		</form>
	</button>
</body>
</html>