package com.example.scoresapp.services;

import com.example.scoresapp.dtos.*;
import com.example.scoresapp.models.*;
import com.example.scoresapp.repositories.CompetitionRepository;
import com.example.scoresapp.repositories.GameRepository;
import com.example.scoresapp.repositories.TeamGameRepository;
import com.example.scoresapp.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class FootballGameService implements GameService{
  private GameRepository gameRepository;
  private CompetitionRepository competitionRepository;
  private TeamRepository teamRepository;
  private TeamGameRepository teamGameRepository;
  private TeamStatsService teamStatsService;

  @Autowired
  public FootballGameService(GameRepository gameRepository, CompetitionRepository competitionRepository, TeamRepository teamRepository,
                             TeamGameRepository teamGameRepository, TeamStatsService teamStatsService) {
    this.gameRepository = gameRepository;
    this.competitionRepository = competitionRepository;
    this.teamRepository = teamRepository;
    this.teamGameRepository = teamGameRepository;
    this.teamStatsService = teamStatsService;
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
    teamStatsService.updateTable(scoreDTO,table);
    gameRepository.save(game);
  }

  @Override
  public void listAllGamesForGivenTeam(TeamNameDTO teamNameDTO) {
    Team team = teamRepository.findByName(teamNameDTO.teamName())
        .orElseThrow(() -> new NoSuchElementException("Home Team with name " + teamNameDTO.teamName() + " not found"));
  }

  @Override
  public GameDTOList listAllGames() {
    List<Game> games = gameRepository.findAll();
      return new GameDTOList(mapGamestoGameDTO(games));
    }

  @Override
  public GameDTO findGameById(Long gameId) {
    Game game = gameRepository.findById(gameId).orElseThrow(() -> new NoSuchElementException("Game with ID " + gameId + " not found"));
    return new GameDTO(game);
  }


  private void createTeamGame(Game game, String homeTeamName, String awayTeamName){
    Team homeTeam = teamRepository.findByName(homeTeamName)
        .orElseThrow(() -> new NoSuchElementException("Home Team with name " + homeTeamName + " not found"));
    Team awayTeam = teamRepository.findByName(awayTeamName)
        .orElseThrow(() -> new NoSuchElementException("Away Team with name " + awayTeamName + " not found"));

    TeamGame teamGame = new TeamGame(game, homeTeam, awayTeam);
    teamGameRepository.save(teamGame);
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

  private GameDTO mapGametoGameDTO(Game game){
    GameDTO gameDTO = new GameDTO(game);
    return gameDTO;
  }

  private List<GameDTO> mapGamestoGameDTO(List<Game> games){
    List<GameDTO> gamesDTO = games.stream()
            .map(game -> new GameDTO(game))
            .collect(Collectors.toList());
    return gamesDTO;
  }
}


