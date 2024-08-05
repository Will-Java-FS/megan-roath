package com.revature.services;
import com.revature.models.Users;
import com.revature.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.sasl.AuthenticationException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    //@PersistenceContext
    //private EntityManager entityManager;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public void persistUsers(Users users){
        this.userRepository.save(users);
    }

    //@Transactional
    //public void persistUsers(Users users) {
    //    this.entityManager.persist(users);
    //}

    public List<Users> getAllUsers() throws Exception{
        return userRepository.findAll();
    }

    public Optional<Users> checkIfUserNameExists(String name) throws Exception {
        Optional<Users> optionalAccount=userRepository.findUsersByName(name);
        return optionalAccount;
    }

    //public Users addNewUser(Users users) {
    //   return userRepository.save(users);
    //}

    public Users login(String username, String password) throws AuthenticationException {
        Optional<Users> user=userRepository.findUsersByNameAndPassword(username, password);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }


}
