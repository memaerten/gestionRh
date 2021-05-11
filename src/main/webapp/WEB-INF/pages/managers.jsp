<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion RH</title>

<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	type="text/css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</head>
<%@ include file="h.jsp"%>
<body>
	<div class="container-sm">
		<h2>Managers</h2>
		<div class="table-responsive">
			<table class="table table-responsive table-striped table-hover">
				<thead>

					<tr>
						<th scope="col">Numéro</th>
						<th scope="col">Nom</th>
						<th scope="col">Prénom</th>
						<th scope="col">Date de début</th>
						<th scope="col">Titre</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${liste}" var="employee">
						<tr class="clickable" data-toggle="collapse"
							data-target="#group-of-rows-${employee.empId}"
							aria-expanded="false" aria-controls="group-of-rows-1">
							<td><svg xmlns="http://www.w3.org/2000/svg" width="16"
									height="16" fill="currentColor" class="bi bi-arrow-right"
									viewBox="0 0 16 16">
  <path fill-rule="evenodd"
										d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z" />
</svg></td>
							<td>${employee.lastName}</td>
							<td>${employee.firstName}</td>
							<td>${employee.startDate}</td>
							<td>${employee.title}</td>
						</tr>
				</tbody>
				<tbody id="group-of-rows-${employee.empId}"
					class="collapse table-striped">
					<tr>
						<td></td>
						<td>Nom</td>
						<td>Prénom</td>
						<td>Date de début</td>
						<td>Titre</td>
					</tr>
				</tbody>
				</c:forEach>
			</table>
		</div>
	</div>
	<%@ include file="f.jsp"%>
</body>
</html>