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
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author DIEGO
 */
@WebServlet(name = "Guardar", urlPatterns = {"/GuardarServlet"})
public class Guardar extends HttpServlet {

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
            
            MetodosSQL metodos = new MetodosSQL();
            String txtId = request.getParameter("txtId");
            String txtNombre = request.getParameter("txtNombre");
            String txtApellidos = request.getParameter("txtApellidos");
            String txtContrasena = request.getParameter("txtContrasena");
            String txtPropietarioGeneradoAutomaticamente = request.getParameter("txtPropietarioGeneradoAutomaticamente");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            out.println("<script type=\"text/javascript\">");
            
            boolean propietarioRepetido = metodos.buscarPropietarioRepetidoBD(txtId);
            
            if(propietarioRepetido == true){ //El propietario ya esta registrado en la BD
                out.println("alert('¡Atención!: El propietario con el ID: " + txtId + ", Ya esta registrado en la BD')");
                out.println("location='index.html'");
            }else{
                
            boolean registro = metodos.registrarPropietario(txtId, txtNombre, txtApellidos, txtContrasena, txtPropietarioGeneradoAutomaticamente);
            if(registro == true){//El propietario se ha registrado
                out.println("alert('El usuario se ha registrado con exito : ) ')");
                out.println("location='index.html'");
            }else{
                out.println("alert('ERROR El usuario no se ha registrado : ) ')");
                out.println("location='index.html'");
            }
             //System.out.println("El valor de registro en servlet es: " + registro);
            
            }
            
            
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
