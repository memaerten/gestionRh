<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion RH</title>
</head>
<body>
<%@ include file="h.jsp"%>
<div class="container-sm connexion"><h1>Connexion</h1>
<form method="post">
	<div class="col-md-6">
	<label><spring:message code="global.username"></spring:message> :</label> <input type="text" name="username" class="form-control"><br />

	<label><spring:message code="global.password"></spring:message> :</label> <input type="password" name="password" class="form-control"><br />
	<input type="submit" class="btn btn-primary" />
	</div>
</form>
<br>
${error}</div>
<%@ include file="f.jsp"%>
</body>
</html>