package cn.hitstone.oauth.client;


import cn.hitstone.OauthApplication;
import cn.hitstone.client.user.User;
import cn.hitstone.client.user.UserDetail;
import cn.hitstone.client.user.request.UsernameSignInRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OauthApplication.class)
public class UserClientTest {

    @Autowired
    private UserClient userClient;

    @Test
    public void testCount(){
        Long count= userClient.count(1);

        System.out.println(count);
    }

    @Test
    public void testList(){
        List<User> count= userClient.findLimit(1,5);

        System.out.println(count.size());
    }

    @Test
    public void testUser(){
        User user = userClient.findByUserId(1L);

        System.out.println(user);
    }

    @Test
    public void testUsernameSignInRequest(){
        UsernameSignInRequest usernameSignInRequest = new UsernameSignInRequest();
        usernameSignInRequest.setPassword("123456");
        usernameSignInRequest.setSalt("salt");
        usernameSignInRequest.setUsername("username23");

        UserDetail userDetail = userClient.signIn(usernameSignInRequest,true);
    }
}
