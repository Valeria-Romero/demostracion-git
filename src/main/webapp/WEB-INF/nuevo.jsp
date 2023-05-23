<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Preguntar</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>¿Cuál es tu pregunta?</h1>
		<form:form action="/crear" method="post" modelAttribute="pregunta">
		<div class="d-flex justify-content-around mt-3">
			<form:label path="contenido">Pregunta:</form:label>
			<form:input path="contenido" type="text-area" class="form-control"/>
			<form:errors path="contenido" class="text-danger"/>
		</div>
		<div class="d-flex justify-content-around mt-3">
			<label>Etiquetas: </label>
			<input type="text" name="textoEtiquetas" class="form-control"/> <!-- se manda así porque van aparte -->
		</div> 
		<div class="d-flex justify-content-md-end">
			<input type="submit" value="Guardar" class="btn btn-success mt-3">
		</div>
		</form:form>
		<div>
			<a href="/dashboard" class="btn btn-danger">Dashboard</a>
		</div> 
	</div>
	
</body>
</html>