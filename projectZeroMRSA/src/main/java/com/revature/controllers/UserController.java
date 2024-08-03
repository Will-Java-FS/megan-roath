package com.revature.controllers;
import com.revature.models.Users;
import com.revature.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/users")
@RequestMapping("/")
@CrossOrigin
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }




}
