package MVC.Controllers;

import MVC.Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

@WebServlet(urlPatterns = "/userInfo")
public class UserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", new User("Nguyen Tho Tuan", "C6 - 520"));

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("UserInfo.jsp");

        requestDispatcher.forward(req, resp);
    }
}
