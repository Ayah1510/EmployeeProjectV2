<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/styles.css">
<title>Projects</title>
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
		<h1>List of Projects</h1>
		<table border="1" cellpadding="5">
			<tr>
				<th>Name</th>
				<th>Details</th>
				<th>Manager</th>
				<th>Tasks</th>
				<th>Edit</th>
				<th>Delete</th>

			</tr>
			<c:forEach var="project" items="${projects}">
				<tr>
					<td><c:out value="${project.projName}" /></td>
					<td><c:out value="${project.details}" /></td>
					<td><c:out value="${project.manager.getName()}" /></td>
					<td><a href="${ContextRoot}/task-project/${project.projName}">Tasks</a></td>
					<td><form method="post">
							<a href="${ContextRoot}/project/${project.projName}">Edit</a>
						</form></td>
					<td><form method="post">
							<a href="${ContextRoot}/project/delete/${project.projName}">Delete</a>
						</form></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<button>
		<form method="post">
			<a href="${contextRoot}/project/insertion/">Add New Project</a>
		</form>
	</button>
</body>
</html>