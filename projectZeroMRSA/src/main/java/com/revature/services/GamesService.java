package com.revature.services;
import com.revature.models.Games;
import com.revature.repositories.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class GamesService {

    @Autowired
    private GamesRepository gamesRepository;

    @Autowired
    public GamesService(GamesRepository gamesRepository){
        this.gamesRepository = gamesRepository;
    }

    //Retrieve all games in the repository
    public List<Games> getAllGames(){
        return gamesRepository.findAll();
    }

    //Save new game to the repository
    public Games newGames(Games games){
        return gamesRepository.save(games);
    }

    //Retrieve games by name
    public Games getGamesByGameName(String gameName){
        Optional<Games> game = gamesRepository.findGamesByGameName(gameName);
        if(game.isPresent()){
            return game.get();
        }
        return null;
    }

    //Update a game's owner by specified gameName
    public int updateGames(Games games){
        String gameName = games.getGameName();
        String owner = games.getOwner();
        Optional<Games> optionalGames = gamesRepository.findGamesByGameName(gameName);

        if(optionalGames.isEmpty()){
            return 0;
        }

        Games updated = optionalGames.get();
        updated.setOwner(owner);
        gamesRepository.save(updated);

        return 1;
    }
}
