package com.revature.Controller;
import com.revature.Service.UserService;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private UserService userService;


    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }


}
