package yun.rest.sso.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import yun.rest.sso.util.SsoTokenUtil;
import yun.rest.sso.vo.SsoToken;
import yun.rest.sso.vo.SsoUser;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
public class LoginController {

    @Autowired
    @Qualifier("fastjsonRedisTemplate")
    RedisTemplate fastjsonRedisTemplate;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "redirect:login.html";
    }
    @RequestMapping("/hasLogin")
    @ResponseBody
    public String hasLogin(){
        Map body = new HashMap();
        body.put("msg","已经登录") ;
        return JSON.toJSONString(body);
    }

    @RequestMapping("/login")
    public String login(SsoUser user, @RequestParam String ssoToken){
        if (user.getUseCode().equals(user.getPassword())){

            SsoToken stoken = SsoTokenUtil.parseSsoToken(ssoToken);
            stoken.setUserCode(user.getUseCode());
            String key =  SsoTokenUtil.createRedisKey(stoken);
            //登录成功,记录redis
            fastjsonRedisTemplate.opsForValue().set(key, key,30, TimeUnit.MINUTES);
            String accessToken = "asd";
            //并返回一个ticket(access_token)[包含过期时间等]给系统，然后系统自己存储
            return "redirect:"+stoken.getRedirectUrl()+"&access_token="+accessToken;
        }
        return "redirect:login.html";
    }




}
