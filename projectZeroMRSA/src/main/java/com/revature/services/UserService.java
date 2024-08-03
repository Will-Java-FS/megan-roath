package com.revature.Service;
import com.revature.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;


    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }



}
