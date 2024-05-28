package com.example.scoresapp.dtos;

import java.util.List;

public class GameDTOList {
    private List<GameDTO> gameDTO;

    public GameDTOList(List<GameDTO> gameDTO) {
        this.gameDTO = gameDTO;
    }

    public List<GameDTO> getGameDTO() {
        return gameDTO;
    }

    public void setGameDTO(List<GameDTO> gameDTO) {
        this.gameDTO = gameDTO;
    }
}
