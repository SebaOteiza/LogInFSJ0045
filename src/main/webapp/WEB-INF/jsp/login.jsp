<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="cl.infoclub.fsj.modelo.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="charset=ISO-8859-1">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<title>JSP CRUD</title>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</head>
<body>
<h1>Iniciar sesión</h1>
<h3>${mensaje}</h3>
<br>
<form action="handleLogin" method="POST">
<input type="text" name="nombre" placeholder="Nombre de usuario">
<input type="password" name="clave" placeholder="Contraseña">
<input type="submit" name="btnEnviar" value="Enviar">
</form>
</body>
</html>
