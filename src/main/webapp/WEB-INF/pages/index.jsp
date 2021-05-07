<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Hello World!</h2>
<c:forEach items="${liste}" var="employee">
${employee.lastName}, ${employee.firstName}, ${employee.startDate}, ${employee.title}<br>
</c:forEach>

</body>
</html>