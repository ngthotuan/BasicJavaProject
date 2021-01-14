package LoginSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/signIn")
public class SignIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        writer.write("<form action='/Servlet/signIn' method = 'post'>");
        writer.write("<p>Username: <input type='text' name='username'></p>");
        writer.write("<p>Password: <input type='password' name='password'></p>");
        writer.write("<p><input type='submit' name='SignIn' ></p>");
        writer.write("</form>");

        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(login(username, password)){
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("username", username);
            httpSession.setAttribute("password", password);
            resp.sendRedirect("/Servlet/home");
        } else {
            resp.sendRedirect("/Servlet/signIn");
        }
    }

    private boolean login(String username, String password) {

        return username.equals("nttuan") && password.equals("123");
    }
}
