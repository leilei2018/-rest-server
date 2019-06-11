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
public class IndexController {
    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        Map body = new HashMap();
        body.put("msg","welcome") ;
        return JSON.toJSONString(body);
    }
}
