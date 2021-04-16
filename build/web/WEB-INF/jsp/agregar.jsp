<%-- 
    Document   : agregar
    Created on : 22/05/2019, 08:35:19 PM
    Author     : OswaldoAbimael
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
       
    </head>
    <body>
        <div class="container mt-4 col-lg-4">
            <div class="card border-info"> 
                <div class="card-header bg-info">
                    <h4>Agregar Nuevo Registro</h4>
                    
                </div>
                <div class="card-body">
                    <form method="POST">
                        <label>Nombres</label>
                        <input type="text" name="nom" class="form-control">
                        <label><label>Correo</label>
                        <input type="text" name="correo" class="form-control">
                        <label>Nacionalidad</label>
                        <input type="text" name="nacio" class="form-control">
                        <input type="submit" value="Agregar" class="btn btn-success">
                        <a href="index.htm">Regresar</a>
                    </form>
                </div>
            </div>
            
        </div>
    </body>
</html>
 
