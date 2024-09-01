package com.aquila.spring.data.example.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // <1>
public class HomeController {

    @RequestMapping(value = "/") // <2>
    public String index() {
        return "index"; // <3>
    }

}