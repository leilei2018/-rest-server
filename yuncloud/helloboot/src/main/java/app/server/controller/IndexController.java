package app.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @RequestMapping("/toLogin")
    public String index(){
        return "redirect:login.html";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpSession session){
        session.setAttribute("user","haha");
        return "success";
    }

    @RequestMapping("/index")
    @ResponseBody
    public String login(){
        return "gg";
    }


    @RequestMapping("/values")
    @ResponseBody
    public String values(HttpSession session){
        Object user = session.getAttribute("user");
        return String.valueOf(user);
    }
}
