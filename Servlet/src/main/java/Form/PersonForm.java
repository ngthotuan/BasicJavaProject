package Form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/createPerson"})
public class PersonForm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write("<form action='userInfo' method = 'post'>");
        writer.write("<p>Name: <input type='text' name='name'></p>");
        writer.write("<p>Age: <input type='text' name='age'></p>");
        writer.write("<p><input type='submit' ></p>");
        writer.write("</form>");
        writer.close();
    }
}
