package com.example.scoresapp.dtos;

import java.util.HashMap;
import java.util.List;

public class GamesGroupedByCompetitionDTO {
    private HashMap<String, List<GameDTO>> gamesGroupedByCompetition;

    public GamesGroupedByCompetitionDTO(HashMap<String, List<GameDTO>> gamesGroupedByCompetition) {
        this.gamesGroupedByCompetition = gamesGroupedByCompetition;
    }

    public HashMap<String, List<GameDTO>> getGamesGroupedByCompetition() {
        return gamesGroupedByCompetition;
    }

    public void setGamesGroupedByCompetition(HashMap<String, List<GameDTO>> gamesGroupedByCompetition) {
        this.gamesGroupedByCompetition = gamesGroupedByCompetition;
    }
}
