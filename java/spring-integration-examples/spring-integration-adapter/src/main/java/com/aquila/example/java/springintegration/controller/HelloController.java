package com.aquila.example.java.springintegration.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloController {

    // Replace @GetMapping with @RequestMapping
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello, Spring Boot 1.3.8!";
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String order() throws InterruptedException {
        return "some order";
    }
}