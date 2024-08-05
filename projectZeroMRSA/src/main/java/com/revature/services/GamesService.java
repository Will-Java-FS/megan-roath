package com.revature.services;
import com.revature.models.Games;
import com.revature.repositories.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamesService {

    private GamesRepository gamesRepository;

    @Autowired
    public GamesService(GamesRepository gamesRepository){
        this.gamesRepository = gamesRepository;
    }

    public List<Games> getAllGames(){
        return gamesRepository.findAll();
    }
}
