package yun.rest.sso.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import yun.rest.sso.filter.SsoTokenInterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new SsoTokenInterceptor());
        interceptorRegistration.excludePathPatterns("/toLogin");
        interceptorRegistration.excludePathPatterns("/hasLogin");
    }
}
