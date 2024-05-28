package com.example.scoresapp.services;

import com.example.scoresapp.dtos.*;

import java.util.List;

public interface GameService {

  public GameDTOList listAllGames();

  public GameDTO findGameById(Long id);

  public void listAllGamesForGivenTeam(TeamNameDTO teamNameDTO);

  public void playGame(Long gameId, ScoreDTO scoreDTO);

  public void createGame(NewGameDTO newGameDTO);
}
