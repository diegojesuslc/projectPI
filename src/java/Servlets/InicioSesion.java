/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import SQL.MetodosSQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author DIEGO
 */
@WebServlet(name = "InicioSesion", urlPatterns = {"/InicioSesion"})
public class InicioSesion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            
            HttpSession sesion = request.getSession();
            MetodosSQL metodos = new MetodosSQL();
            String txtPropietario = request.getParameter("txtPropietario");
            String txtContrasena = request.getParameter("txtContrasena");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            out.println("<script type=\"text/javascript\">");
            
            boolean iniciarSesion = metodos.buscarPropietarioInicioSesion(txtPropietario, txtContrasena);
            if(iniciarSesion == true){ //El propietario puede acceder porque esta registrado
                out.println("alert('¡Bienvenido a la pagina! Iniciaste sesion como: "+txtPropietario+"')");
                out.println("location = 'PaginaInicio.jsp'");
                
                String nombre = metodos.buscarNombre(txtPropietario);
                //System.out.println("El valor del nombre en el Servlet es: " + nombre);
                
                sesion.setAttribute("nombre", nombre);
                sesion.setAttribute("txtPropietario", txtPropietario);
            }else{
                out.println("alert('Datos incorrectos, verifica tus credenciales o registrate en el sistema')");
                out.println("location = 'index.html'");
            }
            System.out.println("El valor de iniciarSesion dentro del SERVLET es: " + iniciarSesion);
            
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
        }
    }
