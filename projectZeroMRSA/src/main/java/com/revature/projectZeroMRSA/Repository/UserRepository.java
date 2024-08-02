package com.revature.projectZeroMRSA.Repository;

import com.revature.projectZeroMRSA.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @GetMapping("/")
    public default String index() {
        return "Greetings from Spring Boot!";
    }
    Optional<Users> findByUsernameAndPassword(String username, String password);
}
