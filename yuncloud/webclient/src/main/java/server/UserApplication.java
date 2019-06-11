package server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import server.rest.UserService;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
@EnableFeignClients
public class UserApplication {

    @Autowired
    UserService userService;


    @RequestMapping("/user/{id}")
    public String hello(@PathVariable Integer id){
        return userService.sayHiFromClientOne(id);
    }
    public static void main(String[] args) {
        new SpringApplicationBuilder(UserApplication.class)
                .run(args);
    }

}
