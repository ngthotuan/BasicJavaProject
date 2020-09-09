package Cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/getCookies")
public class CookieRead extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        Cookie[] cookies = req.getCookies();
        if(cookies!= null){
            for(Cookie cookie : cookies){
                writer.write(String.format("<p>%s : %s</p>", cookie.getName(), cookie.getValue()));
            }
        } else {
            writer.write("No cookie found!");
        }

        writer.close();
    }
}
