package xin.jerome.eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务提供者 提供"/hello"
 *
 * @author Jerome Zhu
 * @since 2019.01.07 16:20
 */
@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/hello")
    public String hello() {
        ServiceInstance instances = client.getInstances("hello-service").get(0);
        System.out.println(instances.getServiceId() +"-"+ instances.getHost() +"-"+ instances.getPort());
        return "hello word!";
    }

}
