package cn.hitstone.oauth.controller;


import cn.hitstone.client.user.UserDetail;
import cn.hitstone.client.user.request.UsernameSignInRequest;
import cn.hitstone.oauth.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * 使用email 验证码注册禁止暴力注册。
 *
 * 业务级别需要覆盖此登陆，一般用于系统基础。
 * @Date 2017-7-24
 * @Auth Daji
 */
@Controller
public class OauthSignInController {

    @Autowired
    private UserClient userClient;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @RequestMapping(value = "/sign/in",method=RequestMethod.GET)
    public String perSignIn(){
        return "sign_in";
    }


    @RequestMapping(value = "/sign/in",method=RequestMethod.POST)
    @ResponseBody
    public UserDetail signIn(String username,String password){
        UsernameSignInRequest usernameSignInRequest = new UsernameSignInRequest();
        usernameSignInRequest.setPassword(passwordEncoder.encode(password));
        usernameSignInRequest.setSalt(UUID.randomUUID().toString());
        usernameSignInRequest.setUsername(username);

        System.out.println("aa");

        UserDetail userDetail = userClient.register(usernameSignInRequest,true);
        return userDetail;
    }


}
