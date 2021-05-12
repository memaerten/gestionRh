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

<div class="container-sm"><h1>Mise à jour Employee</h1>
		<form class="col-sm-6" method="post">
	
			<div class="col-auto"><label><spring:message code="global.lastname"></spring:message> :</label></div>
			<div class="col-auto"><input type="text" name="lastName" class="form-control" value="${employee.lastName}" maxlength="20"></div><br />
			<label><spring:message code="global.firstname"></spring:message> :</label> <input type="text" name="firstName" class="form-control" value="${employee.firstName}" maxlength="20"><br />
			<label><spring:message code="global.startdate"></spring:message> :</label> <input type="date" name="startDateString" class="form-control" value="${employee.startDate}"><br />
			<label><spring:message code="global.title"></spring:message> :</label> <input type="text" name="title" class="form-control" value="${employee.title}" maxlength="20"><br />
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
			<label>Manager : </label> <div class="form-group">
  <select class="form-select" name="superiorEmpId">
  <option value="null"><spring:message code="global.nonemanager"></spring:message> </option>
  <c:forEach items="${managers}" var="emp">
  <c:choose>
  <c:when test="${employee.chef.empId == emp.empId}"><option value="${employee.empId}" selected="selected">${emp.firstName} ${emp.lastName}</option></c:when>
  <c:when test="${employee.chef.empId != emp.empId}"><option value="${employee.empId}">${emp.firstName} ${emp.lastName}</option></c:when>
  </c:choose>
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