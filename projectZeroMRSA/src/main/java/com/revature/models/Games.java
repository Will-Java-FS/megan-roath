package com.revature.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="games")
//@AllArgsConstructor
//@NoArgsConstructor
public class Games {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="gameId")
    private Integer gameId;
    @Column(name="gameName")
    private String gameName;
    /*
    @Column
    private
     */

    @Autowired
    public Games(){ }

    @Autowired
    public Games(String gameName){
        this.gameName = gameName;
    }

    @Autowired
    public Games(Integer gameId, String gameName){
        this.gameId = gameId;
        this.gameName = gameName;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
}
