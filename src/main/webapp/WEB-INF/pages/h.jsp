<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="resources/js/bootstrap.bundle.min.js"></script>	
</head>
<body>
	<nav class="navbar justify-content-md-c navbar-expand-md navbar-dark bg-dark">
		<div class="container-fluid">
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbar"
				aria-controls="navbar" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div id="navbar" class="collapse navbar-collapse">
				<ul class="navbar-nav me-auto mb-2 mb-md-0">
					<li class="nav-item"><a class="nav-link" href="/gestionRH"><spring:message code="global.main"></spring:message></a>
					</li>
					<li class="nav-item"><a class="nav-link" href="contact"><spring:message code="global.contact"></spring:message> </a>
					</li>
					<li class="nav-item"><a class="nav-link" href="about"><spring:message code="global.about"></spring:message> </a></li>
					<li class="nav-item"><a class="nav-link" href="managers"><spring:message code="global.managers"></spring:message> </a>
					</li>
					<li class="nav-item"><a class="nav-link" href="employees"><spring:message code="global.employees"></spring:message></a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="parametres.html"><spring:message code="global.settings"></spring:message> </a></li>
				</ul>
				<ul class="navbar-nav me-auto mb-2 mb-md-0">
					<li><a href="deconnexion" class="nav-item nav-link"><spring:message code="global.login"></spring:message> </a>
					</li>
					<li><a href="${pageContext.request.contextPath}?lang=fr" class="nav-item nav-link">Français</a>
					</li>
					<li><a href="${pageContext.request.contextPath}?lang=en" class="nav-item nav-link">English</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>