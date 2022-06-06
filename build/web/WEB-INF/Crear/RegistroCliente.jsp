<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
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
                    <div class="container">
                        <div class="row">
                            <form action="<%=request.getContextPath()%>/formulario" method="post" class="form-horizontal" role="form">
                                <div class="form-group">
                                    <label for="nombre" class="col-sm-2 control-label">Nombre</label>
                                    <div class="col-sm-10">
                                        <input type="text" name="nombre" style="width: 300px" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="email" class="col-sm-2 control-label">Email</label>
                                    <div class="col-sm-10">
                                        <input type="text" name="email" style="width: 300px" class="form-control"/>
                                    </div>
                                </div> 
                                <div class="form-group">
                                    <label for="password" class="col-sm-2 control-label">Contraseña</label>
                                    <div class="col-sm-10">
                                        <input type="text" name="password" style="width: 300px" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <input type="submit" value="Enviar" class="btn btn-primary" role="button"/>
                                    </div>
                                    <div class="col-sm-2 control-label"><a class="btn btn-primary" href="http://localhost:8080/Parcial/">Volver</a></div>

                                </div>
                              </form>
                          </div>
                  </div>
            </div>
        </div>
        </div>
    </body>
</html>
