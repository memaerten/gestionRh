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
		<h2>Paramètres</h2>
		Liste d'Employees sans Managers
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
			</tr>
			</thead>
			<c:forEach items="${liste}" var="employee">
				<tr>
					<td>${employee.lastName}</td>
					<td>${employee.firstName}</td>
					<td>${employee.startDate}</td>
					<td>${employee.title}</td>
					<td>${employee.department.name}</td>
					<td> <select class="form-select" name="superiorEmpId">
  <option value="null"><spring:message code="global.nonemanager"></spring:message> </option>
  <c:forEach items="${managers}" var="emp">
  <c:choose>
  <c:when test="${employee.chef.empId == emp.empId}"><option value="${emp.empId}" selected="selected">${emp.firstName} ${emp.lastName}</option></c:when>
  <c:when test="${employee.chef.empId != emp.empId}"><option value="${emp.empId}">${emp.firstName} ${emp.lastName}</option></c:when>
  </c:choose>
    </c:forEach>
  </select></td>
				</tr>
			</c:forEach>
		</table>
		</div>
		<a href="addEmployee"><button class="btn btn-primary">Mise à jour</button></a>
	</div>
	<%@ include file="f.jsp"%>
</body>
</html>