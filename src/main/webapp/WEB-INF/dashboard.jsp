<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Overflow</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container pd-4">
		<h1>Dashboard de Preguntas</h1>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Preguntas</th>
					<th>Etiquetas</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pregunta}" var="p">
					<tr>
						<td><a href="/pregunta/${p.id}">${p.contenido}</a></td>
						<td>
							<c:forEach items="${p.etiquetas}" var="e">
								<span class="badge bg-secondary">${e.tema}</span>
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="d-flex justify-content-md-end">
			<a href="/nuevo" class="btn btn-success">Nueva Pregunta</a>
		</div>
	</div>
</body>
</html>