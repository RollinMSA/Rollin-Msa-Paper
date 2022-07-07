package com.example.rollin_paperservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@SpringBootApplication
@EnableEurekaClient
public class RollinPaperServiceApplication {

    public static void main(String[] args) {
         SpringApplication.run(RollinPaperServiceApplication.class, args);
    }

}

//@RestController
//class FallBackController {
//
//    @GetMapping("paper-fallback")
//    Flux<Void> getFallBack(){
//        return Flux.empty();
//    }
//}