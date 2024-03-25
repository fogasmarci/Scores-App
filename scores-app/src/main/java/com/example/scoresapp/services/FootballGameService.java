
package com.example.scoresapp.services;

import com.example.scoresapp.dtos.MessageDTO;
import com.example.scoresapp.dtos.NewGameDTO;
import com.example.scoresapp.dtos.ScoreDTO;
import com.example.scoresapp.exceptions.TeamMismatchException;
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
  public MessageDTO createGame(NewGameDTO newGameDTO){
    Game game = mapDTOtoGame(newGameDTO);
    gameRepository.save(game);
    return new MessageDTO(game.getName() + " played at " + game.getStartTime() + " was created.");
  }

  @Override
  public void playGame(Long gameId, ScoreDTO scoreDTO){
    Game game = gameRepository.findById(gameId).orElseThrow(() -> new NoSuchElementException("Game with ID " + gameId + " not found."));
/*    if (game.getTeams().get(0).getName() != scoreDTO.homeTeam() ||
        game.getTeams().get(1).getName() != scoreDTO.awayTeam()){
      throw new TeamMismatchException();
    }*/

    game.getTeams().get(0).getPlayedGames();
    game.getTeams().get(0).getGamesToPlay();

    game.getTeams().get(1).getPlayedGames();
    game.getTeams().get(1).getGamesToPlay();

    game.setHomeTeamScore(scoreDTO.homeTeamScore());
    game.setAwayTeamScore(scoreDTO.awayTeamScore());
    game.finishGame();
    gameRepository.save(game);
  }

  private Game mapDTOtoGame(NewGameDTO newGameDTO){
    Competition competition = competitionRepository.findByName(newGameDTO.competitionName())
        .orElseThrow(() -> new NoSuchElementException("Competition with name " + newGameDTO.competitionName() + " not found."));
    Team homeTeam = teamRepository.findByName(newGameDTO.homeTeamName())
        .orElseThrow(() -> new NoSuchElementException("Home Team with name " + newGameDTO.homeTeamName() + " not found."));
    Team awayTeam = teamRepository.findByName(newGameDTO.homeTeamName())
        .orElseThrow(() -> new NoSuchElementException("Away Team with name " + newGameDTO.awayTeamName() + " not found."));

    List<Team> teams = new ArrayList<>();
    teams.add(homeTeam);
    teams.add(awayTeam);
    String name = newGameDTO.homeTeamName() + " vs " + newGameDTO.awayTeamName();
    LocalDateTime startTime =  LocalDateTime.parse(newGameDTO.startTime());

    return new Game(name, competition, newGameDTO.round(), teams, startTime);
  }
}




