package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
@EnableConfigServer
public class RestRegistryApplication {

    public static void main(String[] args) {

        SpringApplication.run(RestRegistryApplication.class,args);

    }

}
