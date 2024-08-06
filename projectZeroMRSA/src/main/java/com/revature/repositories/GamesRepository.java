package com.revature.repositories;
import com.revature.models.Games;

import com.revature.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GamesRepository extends JpaRepository<Games, Integer> {
    Optional<Games> findGamesByGameName(String gameName);
}