package yun.rest.sso.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yun.rest.common.enums.TokenStateEnum;
import yun.rest.common.util.TokenUtil;

import javax.servlet.*;
import java.io.IOException;


public class TokenFilter implements Filter {

    public static final String tokenParam = "token";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String token = request.getParameter(tokenParam);
        if (token==null){
            request.getRequestDispatcher("/toLogin").forward(request, response);
        }else{
            TokenStateEnum state = TokenUtil.check(token);
            if (state!=TokenStateEnum.NORMAL){
                request.getRequestDispatcher("/toLogin").forward(request, response);
            }else{
                //如果token正常的话，直接返回 todo
            }
        }
    }

    @Override
    public void destroy() {

    }
}
