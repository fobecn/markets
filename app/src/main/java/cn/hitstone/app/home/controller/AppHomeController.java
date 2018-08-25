package cn.hitstone.app.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class AppHomeController {

    @RequestMapping("/app/home")
    @ResponseBody
    public Principal user(Principal user) {
        return user;
    }


}
