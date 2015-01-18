import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sce on 15.01.2015.
 */
@WebServlet(name="home",urlPatterns = "/home")
public class HomeServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.setAttribute("message", "こんにちは Thymeleaf!");

        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }
}
