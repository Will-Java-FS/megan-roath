package com.revature.basic.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class theController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
