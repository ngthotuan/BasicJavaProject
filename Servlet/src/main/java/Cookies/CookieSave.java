package Cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/saveCookies")
public class CookieSave extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Cookie username = new Cookie("username", "nttuan");
        Cookie age = new Cookie("age", "22");
        username.setMaxAge(15);
        age.setMaxAge(20);
        resp.addCookie(username);
        resp.addCookie(age);

        PrintWriter writer = resp.getWriter();
        writer.write("Cookies saved!!!");
        writer.close();
    }
}
