<%@page import="models.entity.Prestamo"%>
<%@page import="java.util.List"%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>



<%
Prestamo cliente= (Prestamo) request.getAttribute("clientes");
String titulo = (String) request.getAttribute("titulo");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title><%=titulo%></title>
</head>
<body>

<div class="container">
<div class="card text-center">
  <div class="card-header">
   ANDERSON AMOROCHO
  </div>
  <div class="card-body">
    <h3><%=titulo%></h3>
</div>
<div class="card-body">
<table class="table caption-top">
<thead>
<tr class="text-center">
<th>Id</th>
<th>Id Cliente</th>
<th>Nombre Cliente</th>
<th>Id Libro</th>
<th>Nombre Libro</th>
</tr>
</thead>
<tbody>
<tr>
<td><center><%=cliente.getId()%></center></td>
<td><center><%=cliente.getIdcliente()%></center></td>
<td><center><%=cliente.getNombrecliente()%></center></td>
<td><center><%=cliente.getIdlibro()%></center></td>
<td><center><%=cliente.getNombrelibro()%></center></td>
</tr>
</tbody>
</table>
  </div>
  <div class="card-footer text-muted">
    <div class="col-sm-2 control-label"><a class="btn btn-primary" href="http://localhost:8080/Parcial/">Volver</a></div>
  </div>
</div>
</div>

</body>
</html>



