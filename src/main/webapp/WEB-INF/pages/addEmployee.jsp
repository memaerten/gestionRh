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

<div class="container-sm"><h1>Ajout Employee</h1>
		<form class="col-sm-6">
			<div class="col-auto"><label>Nom :</label></div>
			<div class="col-auto"><input type="text" name="name" class="form-control"></div><br />
			<label>Prénom :</label> <input type="text" name="firstName" class="form-control"><br />
			<label>Date de début :</label> <input type="date" name="startDate" class="form-control"><br />
			<label>Titre :</label> <input type="text" name="title" class="form-control"><br />
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
			<label>Manager : </label> <div class="dropdown dropdown-inline">
				<button class="btn dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
					Aucun
				</button>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="#">Manager 1</a></li>
					<li><a class="dropdown-item" href="#">Manager 2</a></li>
					<li><a class="dropdown-item" href="#">Manager 3</a></li>
				</ul>
			</div>
<br />
<div class="form-check">
	<input type="submit" class="btn btn-primary" />
</div>
</form></div>
</body>
</html>