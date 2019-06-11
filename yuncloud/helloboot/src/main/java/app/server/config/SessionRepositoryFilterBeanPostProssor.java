package app.server.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.session.web.http.SessionRepositoryFilter;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

public class SessionRepositoryFilterBeanPostProssor implements BeanPostProcessor {

    static class SessionRepositoryFilterProxy implements Filter{

        public SessionRepositoryFilterProxy() {
            super();
        }

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        }

        @Override
        public void destroy() {

        }
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof SessionRepositoryFilter){

        }
        return null;
    }
}
