package hitstone.dashborad.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class DashboardHomeController {

    @RequestMapping("/dashboard/home")
    @ResponseBody
    public Principal user(Principal user) {
        return user;
    }


    @PostMapping("/dashboard/home/password/change")
    @ResponseBody
    public Principal passwordChange(Principal user,
                                    @RequestParam String oldPassword,
                                    @RequestParam String newPassword) {
        return user;
    }

}
