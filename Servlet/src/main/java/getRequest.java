import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/testRequest"})
public class getRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");

        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();
        writer.write(String.format("<p>Name: %s</p>", name));
        writer.write(String.format("<p>Age: %s</p>", age));
        writer.close();

        // http://localhost:8080/Servlet/testRequest?name=Tuan&age=22
    }
}
