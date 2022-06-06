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
@WebServlet(name = "eliminar/prestamo", urlPatterns = {"/eliminar/prestamo"})
public class EliminarPrestamo extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("titulo1","Eliminar");
        request.setAttribute("titulo2","Eliminar prestamo");
        getServletContext().getRequestDispatcher("/WEB-INF/Eliminar/EliminarPrestamo.jsp").forward(request, response);
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
        dao.Eliminar(id);
        getServletContext().getRequestDispatcher("/WEB-INF/Eliminar/SalidaPrestamo.jsp").forward(request, response);
        
        

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
