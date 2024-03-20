/*
package com.example.scoresapp.services;

import com.example.scoresapp.dtos.NewGameDTO;
import com.example.scoresapp.dtos.ScoreDTO;
import com.example.scoresapp.models.Competition;
import com.example.scoresapp.models.Game;
import com.example.scoresapp.models.Team;
import com.example.scoresapp.repositories.CompetitionRepository;
import com.example.scoresapp.repositories.GameRepository;
import com.example.scoresapp.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FootballGameService implements GameService{
  private GameRepository gameRepository;
  private CompetitionRepository competitionRepository;
  private TeamRepository teamRepository;

  @Autowired
  public FootballGameService(GameRepository gameRepository, CompetitionRepository competitionRepository, TeamRepository teamRepository) {
    this.gameRepository = gameRepository;
    this.competitionRepository = competitionRepository;
    this.teamRepository = teamRepository;
  }

  @Override
  public void createGame(NewGameDTO newGameDTO){
    Game game = mapDTOtoGame(newGameDTO);
    gameRepository.save(game);
  }

  @Override
  public void playGame(Long gameId, ScoreDTO scoreDTO){
    Game game = gameRepository.findById(gameId).orElseThrow(() -> new NoSuchElementException("Game with ID " + gameId + " not found"));
    game.setGameStatusToFinished();

    char[] score = scoreDTO.score().toCharArray();

    gameRepository.save(game);
  }

  private Game mapDTOtoGame(NewGameDTO newGameDTO){
    List<Team> teams = new ArrayList<>();
    Competition competition = competitionRepository.findByName(newGameDTO.competitionName())
        .orElseThrow(() -> new NoSuchElementException("Competition with name " + newGameDTO.competitionName() + " not found"));
    Team homeTeam = teamRepository.findByName(newGameDTO.homeTeamName())
        .orElseThrow(() -> new NoSuchElementException("Home Team with name " + newGameDTO.homeTeamName() + " not found"));
    Team awayTeam = teamRepository.findByName(newGameDTO.homeTeamName())
        .orElseThrow(() -> new NoSuchElementException("Away Team with name " + newGameDTO.awayTeamName() + " not found"));
    LocalDateTime startTime =  LocalDateTime.parse(newGameDTO.startTime());
    teams.add(homeTeam);
    teams.add(awayTeam);
    return new Game(competition, teams, startTime);
  }
}











*/
