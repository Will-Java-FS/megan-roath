package com.revature.projectZeroMRSA.Controller;
import com.revature.projectZeroMRSA.Model.Users;
import com.revature.projectZeroMRSA.Service.UserService;
import com.revature.projectZeroMRSA.Repository.UserRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.security.sasl.AuthenticationException;

@RestController
public class UserController {
    UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/login")
    public @ResponseBody ResponseEntity<Users> loginAccount(@RequestBody Users users){
        Users login = userService.saveAccount(users);
        if(login != null){
            return ResponseEntity.status(200).body(login);
        }
        return ResponseEntity.status(401).body(null);
    /*
    @PostMapping("login")
    public ResponseEntity<Users> userLogin(@RequestBody Users users) throws AuthenticationException {
        Users user= userService.login(user.getUsername(), user.getPassword());
        if(user!=null){
            return ResponseEntity.status(200).body(user);
        }else{
            return ResponseEntity.status(401).body(null);
        }
    }
    */


}
