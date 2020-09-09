package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*", initParams = {@WebInitParam(name = "count", value = "100")} )
public class CounterFilter implements Filter {
    private static int count;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        count = Integer.parseInt(filterConfig.getInitParameter("count"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        count++;
        System.out.printf("Filter from %s, count = %d%n",((HttpServletRequest) servletRequest).getRequestURI(), count);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
