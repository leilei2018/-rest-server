package app.server.filter;

import app.server.config.ApplicationContextUtil;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/*@WebFilter(filterName = "sessionFilter",urlPatterns = "/*")
@Order(1)*/

public class SessionFilter implements Filter {

    List<String> excludeUrl = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest arg1, ServletResponse arg2, FilterChain chain) throws IOException, ServletException {
        if (excludeUrl==null){
            String values = ApplicationContextUtil.getApplicationContext().getEnvironment().getProperty("session.filter.exclude");
            excludeUrl = Arrays.asList(values.split(","));
        }

        HttpServletRequest request = (HttpServletRequest)arg1;
        HttpServletResponse response = (HttpServletResponse)arg2;
        String requestURI = request.getRequestURI();
        if (excludeUrl.contains(requestURI)){
            chain.doFilter(request,response);
            return;
        }

        Object user = request.getSession().getAttribute("user");
        if(user==null){
            request.getRequestDispatcher("/toLogin").forward(request,response);
        }else{
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
