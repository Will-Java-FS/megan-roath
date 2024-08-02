package com.revature.projectZeroMRSA.Controller;
import com.revature.projectZeroMRSA.Model.Users;
import com.revature.projectZeroMRSA.Service.UserService;
import com.revature.projectZeroMRSA.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.sasl.AuthenticationException;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    /*@PostMapping("/login")
    public @ResponseBody ResponseEntity<Users> loginAccount(@RequestBody Users users){
        Users login = userService.saveAccount(users);
        if(login != null){
            return ResponseEntity.status(200).body(login);
        }
        return ResponseEntity.status(401).body(null);
    */
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }


    @PostMapping("login")
    public ResponseEntity<Users> userLogin(@RequestBody Users users) throws javax.naming.AuthenticationException {
        Users user= userService.login(users.getUser_name(), users.getUser_password());
        if(user!=null){
            return ResponseEntity.status(200).body(user);
        }else{
            return ResponseEntity.status(401).body(null);
        }
    }



}
