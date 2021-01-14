import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/testConfig"}, initParams = {@WebInitParam(name = "username", value = "nttuan")})
public class ServletConfig extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = super.getServletConfig().getInitParameter("username");

        resp.setContentType("text/html");
        PrintWriter respWriter = resp.getWriter();
        respWriter.write(String.format("Xin chào <b>%s</b>", username));
    }
}
