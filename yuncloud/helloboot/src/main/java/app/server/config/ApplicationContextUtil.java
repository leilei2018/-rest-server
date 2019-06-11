package app.server.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    static ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextUtil.ctx = applicationContext;
    }
    public static <T> T getBean(String id,Class<T> clazz){
        return (T)ctx.getBean(id,clazz);
    }
    public static <T> T getBean(Class<T> clazz){
        return (T)ctx.getBean(clazz);
    }

    public static ApplicationContext getApplicationContext(){
        return ctx;
    }

}
