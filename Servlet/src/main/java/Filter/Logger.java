package Filter;

import com.sun.deploy.net.HttpRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/testFilter"})
//filter all: /*
public class Logger implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Init Logger");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // xu ly request
        System.out.printf("Filter from %s%n", ((HttpServletRequest)servletRequest).getRequestURI());

        // cho request di tiep
        filterChain.doFilter(servletRequest, servletResponse);

        // xu ly response tra ve
        servletResponse.setContentType("text/plain");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy Logger");
    }
}
