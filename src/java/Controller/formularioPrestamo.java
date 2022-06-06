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
import models.dao.PrestamoDao;
import models.dao.LibroDao;
import models.dao.IClienteDao;
import models.dao.IPrestamoDao;
import models.dao.ILibroDao;
import models.entity.Prestamo;
import models.entity.Libro;

/**
 *
 * @author Usuario1
 */
@WebServlet(name = "formulario/prestamo", urlPatterns = {"/formulario/prestamo"})
public class formularioPrestamo extends HttpServlet {

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

        request.setAttribute("titulo1","Crear");
        request.setAttribute("titulo2","Crear Prestamo");
        getServletContext().getRequestDispatcher("/WEB-INF/Crear/RegistroPrestamo.jsp").forward(request, response);
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id    = Integer.parseInt(request.getParameter("id"));
        int idlibro       = Integer.parseInt(request.getParameter("idlibro"));
                Prestamo cuenta= new Prestamo();
                ILibroDao dao = new LibroDao();
                Libro ele = new Libro();
                ele= dao.getLibro(idlibro);
                String nombrelibro = ele.getNombre();
                cuenta.setIdcliente(id);
                IClienteDao dae= new ClienteDao();
                Cliente cli = new Cliente();
                cli=dae.getCliente(id);
                String nombrecli= cli.getNombre();
                cuenta.setIdlibro(idlibro);
                IPrestamoDao dai= new PrestamoDao();
                Prestamo compra= new Prestamo(id,nombrecli,idlibro,nombrelibro);
                dai.Insertar(compra);
                
        
        
        request.setAttribute("cuenta",cuenta);
        request.setAttribute("titulo1","Crear");
        request.setAttribute("titulo2","Crear Prestamo");
        getServletContext().getRequestDispatcher("/WEB-INF/Crear/SalidaPrestamo.jsp").forward(request, response);
        
        

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
