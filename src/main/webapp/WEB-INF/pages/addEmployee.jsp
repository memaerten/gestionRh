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
<body>
<%@ include file="h.jsp"%>

<div class="container-sm"><h1>Ajout Employee</h1>
		<form class="col-sm-6" method="post">
	
			<div class="col-auto"><label>Nom :</label></div>
			<div class="col-auto"><input type="text" name="lastName" class="form-control" maxlength="20"></div><br />
			<label>Prénom :</label> <input type="text" name="firstName" class="form-control" maxlength="20"><br />
			<label>Date de début :</label> <input type="date" name="startDateString" class="form-control"><br />
			<label>Titre :</label> <input type="text" name="title" class="form-control" maxlength="20"><br />
			<label>Département :</label>  </label> <div class="dropdown dropdown-inline">
				<button class="btn dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
					Aucun
				</button>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="#">Branche 1</a></li>
					<li><a class="dropdown-item" href="#">Branche 2</a></li>
					<li><a class="dropdown-item" href="#">Branche 3</a></li>
				</ul>
			</div>
			<label>Manager : </label> 
			 <div class="form-group">
  <select class="form-control" name="superiorEmpId">
  <option value="null">Aucun</option>
  <c:forEach items="${managers}" var="employee">
    <option value="${employee.empId}">${employee.firstName} ${employee.lastName}</option>
    </c:forEach>
  </select>
</div> 
<br />
<div class="form-check">
	<input type="submit" class="btn btn-primary" />
</div>
</form></div>
<%@ include file="f.jsp"%>
</body>
</html>