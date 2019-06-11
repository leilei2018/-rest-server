package app.server.config;

import app.server.interceptor.SessionInterceptor;
import app.server.vo.SysUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.validator.HibernateValidator;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.session.config.annotation.web.http.SpringHttpSessionConfiguration;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Locale;
import java.util.Set;

public class WebConfig{

    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper mm = new ObjectMapper();
        SysUser sysuser = new SysUser("asd","kkk",20);

        String s = mm.writeValueAsString(sysuser);
        System.out.println(s);
    }


}
