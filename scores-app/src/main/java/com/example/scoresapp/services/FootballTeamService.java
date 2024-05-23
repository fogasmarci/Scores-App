package com.example.scoresapp.services;

import com.example.scoresapp.dtos.GameDTO;
import com.example.scoresapp.models.Game;
import com.example.scoresapp.models.Team;
import com.example.scoresapp.models.TeamGame;
import com.example.scoresapp.repositories.GameRepository;
import com.example.scoresapp.repositories.TeamGameRepository;
import com.example.scoresapp.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class FootballTeamService implements TeamService {
  TeamRepository teamRepository;
  GameRepository gameRepository;
  TeamGameRepository teamGameRepository;

  @Autowired
  public FootballTeamService(TeamRepository teamRepository, GameRepository gameRepository, TeamGameRepository teamGameRepository){
    this.teamRepository = teamRepository;
    this.gameRepository = gameRepository;
    this.teamGameRepository = teamGameRepository;
  }

  @Override
  public List<GameDTO> listGames(String teamName) {
    Team team = teamRepository.findByName(teamName).orElseThrow(()
        -> new NoSuchElementException("Team with name " + teamName + " not found"));

    List<TeamGame> teamGames = teamGameRepository.findByTeamId(team.getId());
    List<Game> games = mapTeamGamesToGame(teamGames);

    List<GameDTO> gameDTOList = mapGamesToGameDTO(games);

    return gameDTOList;
  }

  private List<Game> mapTeamGamesToGame(List<TeamGame> teamGames){
    List<Game> games = new ArrayList<>();

    for (TeamGame tg : teamGames){
      Game game = gameRepository.findById(tg.getId()).orElseThrow(()
          -> new NoSuchElementException("Game not found"));
      games.add(game);
    }

    return games;
  }

  private List<GameDTO> mapGamesToGameDTO(List<Game> games){
    List<GameDTO> gameDTOList = games.stream()
        .map(GameDTO::new)
        .toList();

    return gameDTOList;
  }
}
