import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by sce on 15.01.2015.
 */
@WebServlet(name = "main",urlPatterns = "/serv")
public class MainServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        /*
        String saveDir = getInitParameter("saveDir");
        String fileTypes = getInitParameter("allowedTypes");

        PrintWriter writer = response.getWriter();

        writer.println("saveDir = " + saveDir);
        writer.println("fileTypes = " + fileTypes);
*/
        request.setAttribute("message", "こんにちは Thymeleaf!");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
