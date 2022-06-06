/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.dao.LibroDao;
import models.dao.ILibroDao;
import models.entity.Libro;

@WebServlet(name = "actualizar/libro", urlPatterns = {"/actualizar/libro"})
public class ActualizarLibro extends HttpServlet {

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

        request.setAttribute("titulo1","Registrar");
        request.setAttribute("titulo2","Registro de Libros");
        getServletContext().getRequestDispatcher("/WEB-INF/Actualizar/ActualizarLibro.jsp").forward(request, response);
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id      = request.getParameter("id");
        String nombre      = request.getParameter("nombre");
        String autor       = request.getParameter("autor");
        String genero = request.getParameter("genero");
        Libro cuenta = new Libro();
        cuenta.setNombre(nombre);
        
        Libro cliente = new Libro(Integer.parseInt(id),nombre,autor,genero);
        ILibroDao dao = new LibroDao();
        dao.Guardar(cliente);
        
        
        
        request.setAttribute("cuenta",cuenta);
        request.setAttribute("titulo1","Registro de datos");
        getServletContext().getRequestDispatcher("/WEB-INF/Actualizar/SalidaLibro.jsp").forward(request, response);
        
        

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
