package com.revature.controllers;
import com.revature.models.Users;
import com.revature.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/userlist")
    public ResponseEntity<List<Users>> getMessages() throws Exception {
        try {
            List<Users> users= userService.getAllUsers();
            return ResponseEntity.status(200).body(users);
        } catch (Exception e) {
            e.getMessage();
        }
        return ResponseEntity.status(200).body(null);

    }


}
