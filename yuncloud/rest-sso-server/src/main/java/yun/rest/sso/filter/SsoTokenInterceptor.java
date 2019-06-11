package yun.rest.sso.filter;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import yun.rest.common.util.PrintWriterUtil;
import yun.rest.common.util.TokenUtil;
import yun.rest.sso.config.ApplicationContextUtil;
import yun.rest.sso.config.SsoConstant;
import yun.rest.sso.util.SsoTokenUtil;
import yun.rest.sso.vo.SsoToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * sso单点登录，一次登录，多个应用都可以不用再次登录，
 * 这就要求：多个应用使用同一个认证系统，即同一个数据库的账户/密码
 */
public class SsoTokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.getSession()
        String ssoToken = request.getParameter("ssoToken");
        if (ssoToken==null){
            PrintWriterUtil.writer(response.getWriter(),"ssoToken is null");
            return false;
        }

        SsoToken stoken = SsoTokenUtil.parseSsoToken(ssoToken);
        String key =  SsoTokenUtil.createRedisKey(stoken);
        RedisTemplate fastjsonRedisTemplate = ApplicationContextUtil.getBean("fastjsonRedisTemplate", RedisTemplate.class);
        boolean exists = fastjsonRedisTemplate.hasKey(key);
        if (!exists){
            request.getRequestDispatcher("/toLogin").forward(request, response);
        }else{
            request.getRequestDispatcher("/hasLogin").forward(request, response);
        }

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
