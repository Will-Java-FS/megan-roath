package com.revature.controllers;

import com.revature.services.GamesService;
import com.revature.models.Games;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.sasl.AuthenticationException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class GamesController {
    private GamesService gamesService;

    @Autowired
    public GamesController(GamesService gamesService){
        this.gamesService = gamesService;
    }

    /*
    I am thinking our GetMapping can return the games that are available to play
     */
    @GetMapping("/games")
    public ResponseEntity<List<Games>> getAllGames(){
        List<Games> games = gamesService.getAllGames();
        return ResponseEntity.status(200).body(games);
        }
}
