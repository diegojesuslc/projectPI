<%-- 
    Document   : Login
    Created on : 22 oct 2023, 22:29:12
    Author     : DIEGO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/estilosLogin.css" type="text/css" media="all">
    </head>
    <body>
        <div class="cuerpoFormulario" id="cuerpoFormulario">
            <form class="formularioLogin" id="formularioLogin" method="post" action="InicioSesionServlet">
                <h1>Inicie Sesión</h1>
                
                <p>Propietario:</p>
                <div class="texto">
                    <input type="text" class="txt" id="txtPropietario" required="" name="txtPropietario">
                
                
                <p>Contraseña:</p>
                <div class="texto">
                    <input type="password" class="txt" id="txtContrasena" required="" name="txtContrasena">
                </div>
                
                <br>
                
                <input type="submit" value="Iniciar Sesión" class="btn">
                <input type="button" value="Borrar Datos" class="btn" onclick="resetearFormularioLogin()">
                
            </form> 
        </div>
    </body>
    <script src="js/funcionesLogin.js"></script>
</html>
