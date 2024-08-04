package com.revature.controllers;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.revature.models.Users;
import com.revature.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.sasl.AuthenticationException;
import java.util.List;
import java.util.Optional;

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
        return "Welcome to our app :)";
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

    /*
    To register an account I am thinking a json object would be more secure
    so it doesn't send the data in the query.
    use @RequesetBody passed in a a param to the function
    for postman testing.
        {   "id" : 0,
            "name": "newuser",
            "password": "securepwd"
         }
     */
    //@JsonIgnore
    //@JsonProperty(value = "id")
    @PostMapping("register")
    public ResponseEntity<Users> registerNewUser(@RequestBody Users users) throws Exception {
        //Optional<Users> checkIfUserNameExists = userService.checkIfUserNameExists(users.getName());
        return ResponseEntity.status(200).body(users);

        //if(checkIfUserNameExists.isPresent()){ //username already exists
        //    return ResponseEntity.status(409).body(null);
        //    }
        //if(users.passwordLength()>=4) {
        //    Users newuser = userService.addNewUser(users);
        //    return ResponseEntity.status(200).body(newuser);
        //}
        //return ResponseEntity.status(400).body(null);

    }

    @PostMapping("login")
    public ResponseEntity<Users> userLogin(@RequestBody Users users) throws AuthenticationException {
        Users user= userService.login(users.getName(), users.getPassword());
        if(user!=null){
            return ResponseEntity.status(200).body(user);
        }else{
            return ResponseEntity.status(401).body(null);
        }
    }

}
