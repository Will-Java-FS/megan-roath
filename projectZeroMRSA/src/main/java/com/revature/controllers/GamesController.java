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

    //Handler to retrieve all games in the repository
    @GetMapping("/games")
    public ResponseEntity<List<Games>> getAllGames(){
        List<Games> games = gamesService.getAllGames();
        return ResponseEntity.status(200).body(games);
        }

        //Handler to process new games to the repository
    @PostMapping("/games")
    public @ResponseBody ResponseEntity<Games> newGames(@RequestBody Games games){
        Games gm = gamesService.newGames(games);
        if(gm != null){
            return ResponseEntity.status(200).body(gm);
        }
        return ResponseEntity.status(400).body(null);
    }

    //Retrieve specific game by name
    @GetMapping("/games/{gameName}")
    public ResponseEntity<Games> getGamesByGameName(@PathVariable String gameName){
        Games game = gamesService.getGamesByGameName(gameName);
        if(game!=null){
            return ResponseEntity.status(200).body(game);
        } else {
            return ResponseEntity.status(401).body(null);
        }
    }

    //Handler to update a games' owner in case purchased by another company
    @PatchMapping("/games/{gameName}")
    public ResponseEntity<String> updateGames(@RequestBody Games games, @PathVariable String gameName){
        games.setGameName(gameName);
        int updated = gamesService.updateGames(games);
        if(updated == 1){
            return ResponseEntity.status(200).body(gameName);
        }
        return ResponseEntity.status(400).body(gameName);
    }

}
