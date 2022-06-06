/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import models.entity.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.dao.ClienteDao;
import models.dao.IClienteDao;

/**
 *
 * @author Usuario1
 */
@WebServlet(name = "actualizar/cliente", urlPatterns = {"/actualizar/cliente"})
public class ActualizarCliente extends HttpServlet {

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

        request.setAttribute("titulo1", "Actualizar");
        request.setAttribute("titulo2", "Actualizacion de datos");
        getServletContext().getRequestDispatcher("/WEB-INF/Actualizar/ActualizarCliente.jsp").forward(request, response);
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id          = request.getParameter("id");
        String nombre      = request.getParameter("nombre");
        String email       = request.getParameter("email");
        String password = request.getParameter("password");
        Cliente cliente = new Cliente(Integer.parseInt(id),nombre,email,password);
        IClienteDao dao = new ClienteDao();
        dao.Guardar(cliente);

        
        request.setAttribute("clientes",cliente);
        request.setAttribute("titulo1","Salida de datos JSP");
        request.setAttribute("titulo2","Datos del titular "+cliente.getNombre());
        getServletContext().getRequestDispatcher("/WEB-INF/Actualizar/SalidaCliente.jsp").forward(request, response);
        
        

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
