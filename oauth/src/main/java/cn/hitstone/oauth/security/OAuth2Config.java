package cn.hitstone.oauth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;

/**
 * 用与其他主机登陆
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {


    @Autowired
    private DataSource dataSource;

    private AuthenticationManager authenticationManager = new OAuth2AuthenticationManager();

    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;

    @Bean
    public TokenStore getTokenStore() {
        return new JdbcTokenStore(dataSource);
    }

    @Bean
    public JdbcAuthorizationCodeServices authorizationCodeServices(){
        return new JdbcAuthorizationCodeServices(dataSource);
    }

    @Bean // 声明TokenStore实现
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }
    @Bean // 声明 ClientDetails实现
    public ClientDetailsService clientDetails() {
        return new JdbcClientDetailsService(dataSource);
    }
    @Override // 配置框架应用上述实现
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
        endpoints.authorizationCodeServices(authorizationCodeServices);

        endpoints.tokenStore(tokenStore());

        // 配置TokenServices参数
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(endpoints.getTokenStore());
        tokenServices.setSupportRefreshToken(false);
        tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
        tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
        tokenServices.setAccessTokenValiditySeconds( (int) TimeUnit.DAYS.toSeconds(30)); // 30天
        endpoints.tokenServices(tokenServices);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.jdbc(dataSource);
    }
//
//    @Autowired
//    public PasswordEncoder passwordEncoder;


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients().checkTokenAccess("permitAll()");
    }

}
