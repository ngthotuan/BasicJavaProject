package Api;

import Api.Model.User;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/api")
public class Api extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = new ArrayList<>();
        for(int i=0; i<10; i++){
            users.add(new User(i, String.format("user name %d", i)));
        }

        resp.setContentType("application/json");
        resp.getWriter().println(new Gson().toJson(users));
        resp.getWriter().close();
    }
}
