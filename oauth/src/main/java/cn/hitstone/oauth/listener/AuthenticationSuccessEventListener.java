package cn.hitstone.oauth.listener;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent> {


    Logger logger = LoggerFactory.getLogger(AuthenticationSuccessEventListener.class);

    public void onApplicationEvent(AuthenticationSuccessEvent e) {
        WebAuthenticationDetails auth = (WebAuthenticationDetails)
                e.getAuthentication().getDetails();

        Authentication authentication = (Authentication) e.getSource();

        logger.info(authentication.getPrincipal() + ":" + authentication.getName()  + " login success.");

    }
}