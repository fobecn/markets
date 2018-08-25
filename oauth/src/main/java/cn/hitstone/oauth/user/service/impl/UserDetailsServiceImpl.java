package cn.hitstone.oauth.user.service.impl;

import cn.hitstone.client.user.Authority;
import cn.hitstone.client.user.UserAccount;
import cn.hitstone.client.user.UserDetail;
import cn.hitstone.oauth.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 *
 * 用户登陆
 * @See https://vincentmi.gitbooks.io/spring-security-reference-zh/content/3.1_hello_web_security_java_configuration.html
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserAccount userAccount = userClient.findUserAccountByTypeAndTypeId("username",username);
        UserDetails userDetails = null;

        if(userAccount != null){
            UserDetail userDetail = userClient.findUserDetailById(userAccount.getUserId());

            Collection<GrantedAuthority> authorities = new ArrayList<>();

            for(Authority authority : userDetail.getAuthorities()){
                authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
            }
            userDetails = new org.springframework.security.core.userdetails.User(userDetail.getUserId().toString(),userDetail.getUserPassword().getPassword(),authorities);
        }else{
            throw new UsernameNotFoundException("");
        }


        return userDetails;
    }
}
