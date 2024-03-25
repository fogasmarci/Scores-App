package com.example.scoresapp.services;

import com.example.scoresapp.dtos.MessageDTO;
import com.example.scoresapp.dtos.NewGameDTO;
import com.example.scoresapp.dtos.ScoreDTO;

public interface GameService {
  public void playGame(Long gameId, ScoreDTO scoreDTO);

  public MessageDTO createGame(NewGameDTO newGameDTO);
}
