package hitstone.dashborad.controller;


import hitstone.dashborad.client.UserDetailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class DashboardController {

    @Autowired
    private UserDetailClient userDetailClient;

    @RequestMapping("/dashboard")
    public String dashboard(Model model, Principal user) {

        model.addAttribute("userDetail",userDetailClient.findById(Long.parseLong(user.getName())));
        return "dashboard";
    }

}
