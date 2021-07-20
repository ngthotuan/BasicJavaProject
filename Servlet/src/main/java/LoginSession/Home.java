package LoginSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/home")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String username = (String) httpSession.getAttribute("username");
        if(username != null){
            PrintWriter writer = resp.getWriter();
            resp.setContentType("text/html");
            writer.write(String.format("<h1>Hello <i>%s</i></h1>", username));
            writer.write("<a href='/Servlet/signOut'>SignOut</a>");
        } else {
            resp.sendRedirect("/Servlet/signIn");
        }
    }
}
