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
@WebServlet(name = "actualizar/prestamo", urlPatterns = {"/actualizar/prestamo"})
public class ActualizarPrestamo extends HttpServlet {

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
        request.setAttribute("titulo2", "Actualizar prestamo");
        getServletContext().getRequestDispatcher("/WEB-INF/Actualizar/ActualizarPrestamo.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        int idcliente = Integer.parseInt(request.getParameter("idcliente"));
        int idlibro = Integer.parseInt(request.getParameter("idlibro"));
        Prestamo cuenta = new Prestamo();
        ILibroDao dao = new LibroDao();
        Libro lib = new Libro();
        lib = dao.getLibro(idlibro);
        String nombrelibro = lib.getNombre();
        cuenta.setIdcliente(idcliente);
        IClienteDao dae = new ClienteDao();
        Cliente cli = new Cliente();
        cli = dae.getCliente(idcliente);
        String nombrecli = cli.getNombre();
        IPrestamoDao dai = new PrestamoDao();
        Prestamo prestamo = new Prestamo(id, idcliente, nombrecli, idlibro, nombrelibro);
        dai.Guardar(prestamo);

        request.setAttribute("cuenta", cuenta);
        request.setAttribute("titulo1", "Datos Actualizados");
        getServletContext().getRequestDispatcher("/WEB-INF/Actualizar/SalidaPrestamo.jsp").forward(request, response);

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
