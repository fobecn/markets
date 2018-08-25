package cn.hitstone;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@SessionAttributes("authorizationRequest")
@EnableFeignClients
@EnableOAuth2Sso
public class AppApplication {

    public static void main(String[] args){
        SpringApplication.run(AppApplication.class,args);
    }

    @Bean
    @LoadBalanced // ribbon
    public RestTemplate resetTemplate(){
        return new RestTemplate();
    }
}
