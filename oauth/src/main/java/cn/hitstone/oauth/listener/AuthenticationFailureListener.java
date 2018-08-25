package cn.hitstone.oauth.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;


/**
 * 登陆失败监听
 */
@Component
public class AuthenticationFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {


    Logger logger = LoggerFactory.getLogger(AuthenticationFailureListener.class);



    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent e) {

        WebAuthenticationDetails auth = (WebAuthenticationDetails)
                e.getAuthentication().getDetails();

        Authentication authentication = (Authentication) e.getSource();


        logger.warn(authentication.getPrincipal() + ":" + authentication.getName()  + " login failure.");

    }
}
