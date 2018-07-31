package hitstone.dashborad.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class DashboradHomeController {

    @RequestMapping("/home")
    public Principal user(Principal user) {
        return user;
    }


}
