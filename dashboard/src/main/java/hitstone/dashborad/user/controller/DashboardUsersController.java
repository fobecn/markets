package hitstone.dashborad.user.controller;


import cn.hitstone.client.user.User;
import hitstone.dashborad.client.UserClient;
import hitstone.dashborad.response.ResultEntity;
import hitstone.dashborad.response.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DashboardUsersController {

    @Autowired
    private UserClient userClient;

    @RequestMapping("/dashboard/users")
    @ResponseBody
    public ResultEntity<List<User>> users(@RequestParam Integer page, @RequestParam Integer size) {

        List<User> users = userClient.findLimit(page, size);
        ResultEntity resultEntity = ResultFactory.produce("0","成功", users);

        return resultEntity;
    }


}
