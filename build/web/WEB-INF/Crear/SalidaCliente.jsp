<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.entity.Cliente"%>
<%
    Cliente cuenta = (Cliente) request.getAttribute("cuenta");
    String titulo1 = (String) request.getAttribute("titulo1");
    String titulo2 = (String) request.getAttribute("titulo2");
%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=titulo1%></title>
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">         
    </head>
    <body>
        <div class="container">
            <div class="page-header">
                <h1><%=titulo1%></h1> 
            </div>
           <div class="panel panel-primary">
                <div class="panel-heading"><%=titulo2%></div>
                <div class="panel-body">
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>Nombre</th> 
                                <th>Email</th> 
                                <th>Contraseña</th> 
                            </tr> 
                        </thead>
                        <tbody>
                            <tr>
                                <td><%=cuenta.getNombre()%></td>
                                <td><%=cuenta.getEmail()%></td>
                                <td><%=cuenta.getPassword()%></td>
                            </tr>
                        </tbody>
                    </table>
                     <a class="btn btn-default" href="<%=request.getContextPath()%>/formulario" role="button">Volver</a>
                </div>
            </div>
        </div>
        
    </body>
</html>
