package cn.hitstone.oauth.controller;


import cn.hitstone.client.user.User;
import cn.hitstone.oauth.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientUserTestController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/users/{id}")
    @ResponseBody
    public User findByUserId(@PathVariable Long id){
        return userClient.findByUserId(id);
    }


//    @FeignClient(name ="user")
//    @Component
//     interface UserClient {
//
//        @RequestMapping(method = RequestMethod.GET, value = "/users/{id}/detail")
//        UserDetail findUserDetailById(@PathVariable("id") Long id);
//
//
//        @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
//        User findByUserId(@PathVariable("id") Long id);
//    }



}
