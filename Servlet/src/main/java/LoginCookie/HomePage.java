package LoginCookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/")
public class HomePage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isLogin = false;
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for(Cookie c : cookies){
                if (c.getName().equals("username")){
                    PrintWriter writer = resp.getWriter();
                    resp.setContentType("text/html");
                    writer.write(String.format("<h1>Hello <i>%s</i></h1>", c.getValue()));
                    writer.write("<a href='/Servlet/logout'>Logout</a>");
                    isLogin = true;
                    break;
                }
            }
        }
        if(!isLogin){
            resp.sendRedirect("/Servlet/login");
        }

    }
}
