package com.revature.services;
import com.revature.models.Users;
import com.revature.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.sasl.AuthenticationException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public void persistUsers(Users users){
        this.userRepository.save(users);
    }

    public List<Users> getAllUsers() throws Exception{
        return userRepository.findAll();
    }

    public Optional<Users> checkIfUserNameExists(String name) throws Exception {
        Optional<Users> optionalAccount=userRepository.findUsersByName(name);
        return optionalAccount;
    }


    public Users login(String username, String password) throws AuthenticationException {
        Optional<Users> user=userRepository.findUsersByNameAndPassword(username, password);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }


}
