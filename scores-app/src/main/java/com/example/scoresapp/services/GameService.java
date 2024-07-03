package com.example.scoresapp.services;

import com.example.scoresapp.dtos.*;
import com.example.scoresapp.models.Game;

public interface GameService {

  public GamesGroupedByCompetitionDTO listAllGames();

  public GameDTO findGameById(Long id);

  public void listAllGamesForGivenTeam(TeamNameDTO teamNameDTO);

  public void playGame(Long gameId, ScoreDTO scoreDTO);

  public void playGame(Game game, ScoreDTO scoreDTO);

  public void createGame(NewGameDTO newGameDTO);
}
