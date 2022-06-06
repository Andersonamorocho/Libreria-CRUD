/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import models.entity.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.dao.ClienteDao;
import models.dao.PrestamoDao;
import models.dao.IClienteDao;
import models.dao.IPrestamoDao;

/**
 *
 * @author Usuario1
 */
@WebServlet(name = "buscar/prestamo", urlPatterns = {"/buscar/prestamo"})
public class BuscarPrestamo extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("titulo1","Buscar");
        request.setAttribute("titulo2","Buscador de Prestamo");
        getServletContext().getRequestDispatcher("/WEB-INF/Buscar/BuscarPrestamo.jsp").forward(request, response);
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int  id      = Integer.parseInt(request.getParameter("id"));
        IPrestamoDao dao = new PrestamoDao();
        
     
            
            request.setAttribute("clientes",dao.getPrestamo(id));
        getServletContext().getRequestDispatcher("/WEB-INF/Buscar/SalidaPrestamo.jsp").forward(request, response);
        
        

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
