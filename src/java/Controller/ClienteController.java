package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.dao.ClienteDao;
import models.dao.IClienteDao;
import models.entity.Cliente;

@WebServlet(name = "/clientes/listado", urlPatterns = {"/clientes/listado"})
public class ClienteController extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            IClienteDao dao = new ClienteDao();
            List<Cliente> lista = dao.Listar();
            
            request.setAttribute("clientes",lista);
            request.setAttribute("titulo","Listado de Clientes");
            request.getRequestDispatcher("/WEB-INF/Vistas/clientes.jsp").forward(request, response);
    }
}