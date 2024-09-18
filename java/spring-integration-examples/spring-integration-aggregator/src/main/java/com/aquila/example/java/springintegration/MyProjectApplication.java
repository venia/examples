package com.aquila.example.java.springintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MyProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyProjectApplication.class, args);
    }

//    @RestController
//    class HelloController {
//        // Replace @GetMapping with @RequestMapping
//        @RequestMapping(value = "/hello", method = RequestMethod.GET)
//        public String sayHello() {
//            return "Hello, Spring Boot 1.3.8!";
//        }
//    }
}