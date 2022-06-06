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
import models.dao.IClienteDao;

/**
 *
 * @author Usuario1
 */
@WebServlet(name = "eliminar/cliente", urlPatterns = {"/eliminar/cliente"})
public class EliminarCliente extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("titulo1","Eliminar");
        request.setAttribute("titulo2","Eliminar Cliente");
        getServletContext().getRequestDispatcher("/WEB-INF/Eliminar/EliminarCliente.jsp").forward(request, response);
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
        IClienteDao dao = new ClienteDao();
        dao.Eliminar(id);
        getServletContext().getRequestDispatcher("/WEB-INF/Eliminar/SalidaCliente.jsp").forward(request, response);
        
        

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
