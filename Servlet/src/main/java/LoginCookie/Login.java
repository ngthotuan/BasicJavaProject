package LoginCookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        writer.write("<form action='/Servlet/login' method = 'post'>");
        writer.write("<p>Username: <input type='text' name='username'></p>");
        writer.write("<p>Password: <input type='password' name='password'></p>");
        writer.write("<p><input type='submit' name='Login' ></p>");
        writer.write("</form>");

        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(login(username, password)){
            Cookie user = new Cookie("username", username);
            user.setMaxAge(3*60);
            resp.addCookie(user);
            resp.sendRedirect("/Servlet/");
        } else {
            resp.sendRedirect("/Servlet/login");
        }
    }

    private boolean login(String username, String password) {

        return username.equals("nttuan") && password.equals("123");
    }
}
