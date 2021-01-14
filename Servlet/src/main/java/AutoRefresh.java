import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/time")
public class AutoRefresh extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setHeader("Refresh", "1");

        PrintWriter writer = resp.getWriter();
        writer.write(String.format("<p style='text-align: center'>Time: <b>%s</b></p>",
                new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").format(new Date())));
        writer.close();
    }
}
