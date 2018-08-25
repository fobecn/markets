package hitstone.dashborad.user.controller;


import cn.hitstone.client.user.UserDetail;
import hitstone.dashborad.client.UserClient;
import hitstone.dashborad.client.UserDetailClient;
import hitstone.dashborad.response.ResultEntity;
import hitstone.dashborad.response.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DashboardUserDetailsController {

    @Autowired
    private UserDetailClient userDetailClient;

    @Autowired
    private UserClient userClient;

    @RequestMapping("/dashboard/user/details")
    @ResponseBody
    public ResultEntity<List<UserDetail>> users(@RequestParam Integer page, @RequestParam Integer size) {

        List<UserDetail> userDetails = userDetailClient.findPages(page, size);
        ResultEntity resultEntity = ResultFactory.produce("0","成功", userDetails);
        resultEntity.setCount(userClient.count());

        return resultEntity;
    }


}
