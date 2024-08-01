package com.revature.projectZeroMRSA.Service;
import com.revature.projectZeroMRSA.Model.Users;
import com.revature.projectZeroMRSA.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }


    public Users login(String username, String password) throws AuthenticationException {
        Optional<Users> user=userRepository.findByUsernameAndPassword(username, password);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }



}
