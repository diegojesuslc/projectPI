<%-- 
    Document   : altaPropietario
    Created on : 22 oct 2023, 22:28:31
    Author     : DIEGO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/estilosAltaPropietario.css" type="text/css" media="all">
    </head>
    <body>
        <div class="cuerpoFormulario" id="cuerpoFormulario"> 
            <form class="formularioAlta" id="formularioAlta" method="post" action="GuardarServlet">
                <h1>Registro de Propietarios</h1>
                <br>
                <label>ID:</label> <input type="text" class="txt" id="txtId" required="" name="txtId">
                <br>
                <br>
                <label>Nombre:</label> <input type="text" class="txt" id="txtNombre" required="" onkeyup="usuarioGeneradoAutomaticamente()" name="txtNombre">
                <label>Apellidos:</label> <input type="text" class="txt" id="txtApellidos" required="" onkeyup="usuarioGeneradoAutomaticamente()" name="txtApellidos">
                <br>
                <br>
                <label>Contraseña:</label> <input type="password" class="txt" id="txtContrasena" required="" onkeyup="coincidirContrasena()">
                <label>Repita la Contraseña:</label> <input type="password" class="txt" id="txtRepetirContrasena" required="" onkeyup="coincidirContrasena()" name="txtContrasena">
                <br>
                <br>
                <label class="avisoContrasena" id="avisoContrasena"> ------- </label>
                <br>
                <br>
                <label>Propietario Generado Automaticamente:</label> <input type="text" class="txt" id="txtPropietarioGeneradoAutomaticamente" required="" readonly="" name="txtPropietarioGeneradoAutomaticamente">
                <br>
                <br>
                
                <input type="submit" value="Enviar Datos" class="btn" id="btnEnviarDatos" disabled="">
                <input type="button" value="Borrar Datos" class="btn" id="btnBorrar" onclick="resetearFormulario()">
                
            </form>
        </div>
    </body>
    <script src="js/funcionesAltaPropietario.js"></script>
</html>
