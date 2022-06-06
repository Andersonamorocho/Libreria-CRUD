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
@WebServlet(name = "formulario", urlPatterns = {"/formulario"})
public class formulario extends HttpServlet {

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
        request.setAttribute("titulo2","Crear Cliente");
        getServletContext().getRequestDispatcher("/WEB-INF/Crear/RegistroCliente.jsp").forward(request, response);
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre      = request.getParameter("nombre");
        String email       = request.getParameter("email");
        String password = request.getParameter("password");
        Cliente cliente = new Cliente(nombre,email,password);
        IClienteDao dao = new ClienteDao();
        dao.Insertar(cliente);
        
        Cliente cuenta = new Cliente();
        cuenta.setNombre(nombre);
        cuenta.setEmail(email);
        cuenta.setPassword(password);
        
        
        request.setAttribute("cuenta",cuenta);
        request.setAttribute("titulo1","Salida de datos JSP");
        request.setAttribute("titulo2","Datos del titular "+cuenta.getNombre());
        getServletContext().getRequestDispatcher("/WEB-INF/Crear/SalidaCliente.jsp").forward(request, response);
        
        

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
