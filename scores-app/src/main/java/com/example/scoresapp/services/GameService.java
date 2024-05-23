package com.example.scoresapp.services;

import com.example.scoresapp.dtos.NewGameDTO;
import com.example.scoresapp.dtos.ScoreDTO;
import com.example.scoresapp.dtos.TeamNameDTO;

public interface GameService {
  public void listAllGames(TeamNameDTO teamNameDTO);
  public void playGame(Long gameId, ScoreDTO scoreDTO);

  public void createGame(NewGameDTO newGameDTO);
}
