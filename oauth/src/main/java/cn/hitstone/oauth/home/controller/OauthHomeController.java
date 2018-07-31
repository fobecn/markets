package cn.hitstone.oauth.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class OauthHomeController {

    @GetMapping("/home")
    @ResponseBody
    public Principal user(Principal user) {
        return user;
    }

    @GetMapping("/home/info")
    @ResponseBody
    public String homeInfo() {
        return "home";
    }
}
