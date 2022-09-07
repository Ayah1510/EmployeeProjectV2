<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/styles.css">
<title>Tasks</title>
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
		<h1>List of Tasks</h1>
		<table border="1" cellpadding="5">
			<tr>
				<th>Name</th>
				<th>Main Task</th>
				<th>Status</th>
				<th>Project</th>
				<th>Employees</th>
				<th>Qualifications</th>
				<th>Edit</th>
				<th>Delete</th>

			</tr>
			<c:forEach var="task" items="${tasks}">
				<tr>
					<td><c:out value="${task.taskName}" /></td>
					<td><c:out default="-" value="${task.mainTask.getTaskName()}" /></td>
					<td><c:out value="${task.status}" /></td>
					<td><c:out default="-" value="${task.project.getProjName()}" /></td>
					<td><a href="${ContextRoot}/employee-task/${task.taskName}">Employees</a></td>
					<td><a
						href="${ContextRoot}/qualification-task/${task.taskName}">Qualifications</a></td>
					<td>
						<form method="post">
							<a href="${ContextRoot}/task/${task.taskName}">Edit</a>
						</form>
					</td>
					<td><form method="post">
							<a href="${ContextRoot}/task/delete/${task.taskName}">Delete</a>
						</form></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<form method="post">
		<button>
			<a href="${contextRoot}/task/insertion/">Add New Task</a>
		</button>
	</form>
</body>
</html>