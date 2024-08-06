package com.revature.repositories;
import com.revature.models.Games;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GamesRepository extends JpaRepository<Games, Integer> {
    //Optional<Games> findGamesByName(String gameName);
    Optional<Games> findGamesByGameName(String gameName);
}
