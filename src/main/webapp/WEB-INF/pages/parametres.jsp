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
				<th scope="col">Nom</th>
				<th scope="col">Prénom</th>
				<th scope="col">Date de début</th>
				<th scope="col">Titre</th>
				<th scope="col">Département</th>
			</tr>
			</thead>
			<c:forEach items="${liste}" var="employee">
				<tr>
					<td>${employee.lastName}</td>
					<td>${employee.firstName}</td>
					<td>${employee.startDate}</td>
					<td>${employee.title}</td>
					<td>${employee.department.name}</td>
				</tr>
			</c:forEach>
		</table>
		</div>
		<a href="addEmployee"><button class="btn btn-primary">Ajouter</button></a>
	</div>
	<%@ include file="f.jsp"%>
</body>
</html>