<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion RH</title>
</head>
<%@ include file="h.jsp"%>
<body>
	<div class="container-sm">
		<h2>Employees</h2>
		<div class="table-responsive">
		<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th scope="col"><spring:message code="global.lastname"></spring:message></th>
				<th scope="col"><spring:message code="global.firstname"></spring:message></th>
				<th scope="col"><spring:message code="global.startdate"></spring:message></th>
				<th scope="col"><spring:message code="global.title"></spring:message></th>
				<th scope="col"><spring:message code="global.department"></spring:message></th>
				<th scope="col">Manager</th>
				<th scope="col"><spring:message code="global.edit"></spring:message></th>
				<th scope="col"><spring:message code="global.delete"></spring:message></th>
			</tr>
			</thead>
			<c:forEach items="${liste}" var="employee">
				<tr>
					<td>${employee.lastName}</td>
					<td>${employee.firstName}</td>
					<td>${employee.startDate}</td>
					<td>${employee.title}</td>
					<td>${employee.department.name}</td>
					<td>${employee.chef.firstName} ${employee.chef.lastName}</td>
					<td><a href="updateEmployee?empId=${employee.empId}"><svg class="text-primary" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
  <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
</svg></td>
<%-- deleteEmployee?empId=${employee.empId} --%>
					<td onclick="del(${employee.empId})"><svg class="text-danger" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
  <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
  <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
</svg></td>
				</tr>
			</c:forEach>
		</table>
		</div>
		<a href="addEmployee"><button class="btn btn-primary"><spring:message code="global.add"></spring:message></button></a>
	</div>
	<%@ include file="f.jsp"%>
</body>
</html>
<script>
function del(empId) {
	var deleteEmployee = confirm('Voulez-vous vraiment supprimer cet employé ?');
	if (deleteEmployee) {
		alert("L'employé a été supprimé.");
		window.location.href = "deleteEmployee?empId=" + empId;
	} else {
		sendRedirect("employees");
	}
}
</script>