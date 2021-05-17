<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
	
			<div class="col-auto"><label><spring:message code="global.lastname"></spring:message> :</label></div>
			<div class="col-auto"><input type="text" name="lastName" class="form-control" maxlength="20"></div><br />
			<label><spring:message code="global.firstname"></spring:message> :</label> <input type="text" name="firstName" class="form-control" maxlength="20"><br />
			<form:errors path="firstName" element="div"></form:errors>
			<label><spring:message code="global.startdate"></spring:message> :</label> <input type="date" name="startDate" class="form-control" value="${date}"><br />
			<label><spring:message code="global.title"></spring:message> :</label> <input type="text" name="title" class="form-control" maxlength="20"><br />
			<label><spring:message code="global.department"></spring:message> :</label>  </label> <div class="form-group">
  <select class="form-select form-control" name="depId">
   <option value="null"><spring:message code="global.nonemanager"></spring:message></option>
  <c:forEach items="${departments}" var="department">
    <option value="${department.deptId}">${department.name}</option>
    </c:forEach>
  
  </select></div>
			<label>Manager : </label> 
			 <div class="form-group">
  <select class="form-select" name="superiorEmpId">
  <option value="null"><spring:message code="global.nonemanager"></spring:message></option>
  <c:forEach items="${managers}" var="employee">
    <option value="${employee.empId}">${employee.firstName} ${employee.lastName}</option>
    </c:forEach>
  </select>
</div> 
<br />
<div class="form-check">
	<input type="submit" class="btn btn-primary" />
</div>
</form>
</div>
<%@ include file="f.jsp"%>
</body>
</html>