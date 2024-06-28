package com.example.scoresapp.dtos;

import java.util.HashMap;
import java.util.List;

public class GamesDTO {
    private List<GameDTO> games;

    public GamesDTO(List<GameDTO> games) {
        this.games = games;
    }

    public List<GameDTO> getGames() {
        return games;
    }

    public void setGames(List<GameDTO> games) {
        this.games = games;
    }
}
