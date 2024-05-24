package com.example.scoresapp.services;

import com.example.scoresapp.dtos.NewGameDTO;
import com.example.scoresapp.dtos.ScoreDTO;
import com.example.scoresapp.dtos.TeamNameDTO;
import com.example.scoresapp.models.*;
import com.example.scoresapp.repositories.CompetitionRepository;
import com.example.scoresapp.repositories.GameRepository;
import com.example.scoresapp.repositories.TeamGameRepository;
import com.example.scoresapp.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FootballGameService implements GameService{
  private GameRepository gameRepository;
  private CompetitionRepository competitionRepository;
  private TeamRepository teamRepository;
  private TeamGameRepository teamGameRepository;
  private FootballTeamStatsService footballTeamStatsService;

  @Autowired
  public FootballGameService(GameRepository gameRepository, CompetitionRepository competitionRepository, TeamRepository teamRepository,
                             TeamGameRepository teamGameRepository, FootballTeamStatsService footballTeamStatsService) {
    this.gameRepository = gameRepository;
    this.competitionRepository = competitionRepository;
    this.teamRepository = teamRepository;
    this.teamGameRepository = teamGameRepository;
    this.footballTeamStatsService = footballTeamStatsService;
  }

  @Override
  public void createGame(NewGameDTO newGameDTO){
  mapDTOtoGame(newGameDTO);
  }

  @Override
  public void playGame(Long gameId, ScoreDTO scoreDTO){
    Game game = gameRepository.findById(gameId).orElseThrow(() -> new NoSuchElementException("Game with ID " + gameId + " not found"));
    game.finishGame(scoreDTO);
    List<TeamStats> table = game.getCompetition().getTable();
    footballTeamStatsService.updateTable(scoreDTO,table);
    gameRepository.save(game);
  }

  @Override
  public void listAllGames(TeamNameDTO teamNameDTO) {
    Team team = teamRepository.findByName(teamNameDTO.teamName())
        .orElseThrow(() -> new NoSuchElementException("Home Team with name " + teamNameDTO.teamName() + " not found"));

  }

  private Game mapDTOtoGame(NewGameDTO newGameDTO){
    Competition competition = competitionRepository.findByName(newGameDTO.competitionName())
        .orElseThrow(() -> new NoSuchElementException("Competition with name " + newGameDTO.competitionName() + " not found"));
    String homeTeamName = newGameDTO.homeTeamName();
    String awayTeamName = newGameDTO.awayTeamName();
    LocalDateTime startTime =  LocalDateTime.parse(newGameDTO.startTime());

    Game game = new Game(newGameDTO.name(),competition, newGameDTO.round(), startTime, homeTeamName, awayTeamName);
    gameRepository.save(game);
    createTeamGame(game, homeTeamName, awayTeamName);

    return game;
  }

  private void createTeamGame(Game game, String homeTeamName, String awayTeamName){
    Team homeTeam = teamRepository.findByName(homeTeamName)
        .orElseThrow(() -> new NoSuchElementException("Home Team with name " + homeTeamName + " not found"));
    Team awayTeam = teamRepository.findByName(awayTeamName)
        .orElseThrow(() -> new NoSuchElementException("Away Team with name " + awayTeamName + " not found"));

    TeamGame teamGame = new TeamGame(game, homeTeam, awayTeam);
    teamGameRepository.save(teamGame);
  }
}


