/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.dao.PrestamoDao;
import models.dao.IPrestamoDao;
import models.entity.Prestamo;

@WebServlet(name = "/prestamo/listado", urlPatterns = {"/prestamo/listado"})
public class PrestamoController extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            IPrestamoDao dao = new PrestamoDao();
            List<Prestamo> lista = dao.Listar();
            
            request.setAttribute("compras",lista);
            request.setAttribute("titulo","Listado de Prestamos");
            request.getRequestDispatcher("/WEB-INF/Vistas/prestamo.jsp").forward(request, response);
    }
}