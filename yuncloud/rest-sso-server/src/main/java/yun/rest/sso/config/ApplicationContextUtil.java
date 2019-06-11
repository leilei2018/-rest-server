package yun.rest.sso.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    static ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
    public static <T> T getBean(String id,Class<T> clazz){
        return (T)ctx.getBean(id,clazz);
    }
    public static <T> T getBean(Class<T> clazz){
        return (T)ctx.getBean(clazz);
    }
}
