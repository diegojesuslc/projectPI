<%-- 
    Document   : PaginaInicio
    Created on : 23 oct 2023, 21:27:13
    Author     : DIEGO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/estilosPaginaInicio.css" type="text/css" media="all">
        <%
          if(session.getAttribute("txtPropietario") == null && session.getAttribute("nombre") == null){
          response.sendRedirect("index.html");
            }  
        %>
    </head>
    <body>
        <div class="contenidoInicio">
        <h1>Hola <%=request.getSession().getAttribute("nombre")%> ,¡Bienvenido! </h1>
        
        <p><a href="https://www.google.com">IR A GOOGLE</a></p>
        
        <p>Actualmente en uso: ${txtPropietario}</p>
        
        <form action="CerrarSesionServlet">
            
            <input type="submit" value="Cerrar Sesión">
        </form>
        </div>
    </body>
</html>
