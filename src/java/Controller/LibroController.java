package Controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.dao.LibroDao;
import models.dao.ILibroDao;
import models.entity.Libro;



@WebServlet(name = "/libro/listado", urlPatterns = {"/libro/listado"})
public class LibroController extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            ILibroDao dao = new LibroDao();
            List<Libro> lista = dao.Listar();
            
            request.setAttribute("electrodomestico",lista);
            request.setAttribute("titulo","Listado de Libros");
            request.getRequestDispatcher("/WEB-INF/Vistas/libro.jsp").forward(request, response);
    }


}
