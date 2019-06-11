package server;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class OrderApplication {




    @RequestMapping("/order/{id}")
    public String find(@PathVariable  int id){

        return "order2";
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(OrderApplication.class)
                .run(args);
    }

}
