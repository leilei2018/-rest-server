package server.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("ORDER-SERVER")
public interface UserService {
    @RequestMapping(value = "/order/{id}")
    String sayHiFromClientOne(@PathVariable Integer id);
}
