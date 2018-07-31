package hitstone.dashborad.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class DashboardHomeController {

    @RequestMapping("/home")
    @ResponseBody
    public Principal user(Principal user) {
        return user;
    }


}
