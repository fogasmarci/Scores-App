package com.example.scoresapp.services;

import com.example.scoresapp.dtos.GameDTO;
import com.example.scoresapp.dtos.GamesDTO;
import com.example.scoresapp.dtos.TableDTOList;
import com.example.scoresapp.dtos.TableDataDTO;
import com.example.scoresapp.models.Competition;
import com.example.scoresapp.models.Game;
import com.example.scoresapp.models.GameStatus;
import com.example.scoresapp.models.TeamStats;
import com.example.scoresapp.repositories.CompetitionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FootballCompetitionService implements CompetitionService {
  private CompetitionRepository competitionRepository;

  public FootballCompetitionService(CompetitionRepository competitionRepository) {
    this.competitionRepository = competitionRepository;
  }

  public Boolean checkIfCompetitionExists(String competitionName) {
    Competition comptetition = competitionRepository.findByName(competitionName)
            .orElse(null);

    if (comptetition == null) {
      return false;
    }

    return true;
  }

  @Override
  @Transactional
  public GamesDTO listGames(String competitionName) {
    Competition competition = competitionRepository.findByName(competitionName)
        .orElseThrow(() -> new NoSuchElementException("Team name not found"));
    List<Game> games = competition.getGames();

    List<GameDTO> gameDTOList = mapGamesToGameDTO(games);

    GamesDTO gamesDTO = new GamesDTO(gameDTOList);

    return gamesDTO;
  }

  // Lehet, hogy erre nem is lesz szükség, mert a Competition Controllerbe
  //behúzom a TeamStat Service-t.
  @Override
  public TableDTOList showTable(String competitionName) {
    Competition competition = competitionRepository.findByName(competitionName)
        .orElseThrow(() -> new NoSuchElementException("Team name not found"));
    List<TeamStats> teamStats = competition.getTable();
    TableDTOList tableDTO = mapTableToTableDTO(teamStats);

    return tableDTO;
  }

  @Override
  public GamesDTO showResults(String competitionName) {
    Competition competition = competitionRepository.findByName(competitionName).orElseThrow(()
            -> new NoSuchElementException("Team name not found"));

    List<Game> games = competition.getGames();
    List<GameDTO> gamesDTO = mapGamesToGameDTO(games);
    List<GameDTO> playedGames = gamesDTO.stream()
            .filter(game -> game.getGameStatus() == GameStatus.Finished)
            .toList();

    return new GamesDTO(playedGames);
  }

  @Override
  public GamesDTO showGames(String competitionName) {
    Competition competition = competitionRepository.findByName(competitionName).orElseThrow(()
            -> new NoSuchElementException("Team name not found"));

    List<Game> games = competition.getGames();
    List<GameDTO> gamesDTO = mapGamesToGameDTO(games);
    List<GameDTO> playedGames = gamesDTO.stream()
            .filter(game -> game.getGameStatus() == GameStatus.Not_started)
            .toList();

    return new GamesDTO(playedGames);
  }

  private List<GameDTO> mapGamesToGameDTO(List<Game> games){
  // Team service has a VERY similar method, maybe I should organize them in a separate Class.
    List<GameDTO> gameDTOList = games.stream()
        .map(GameDTO::new)
        .toList();

    return gameDTOList;
  }

  private TableDTOList mapTableToTableDTO(List<TeamStats> teamStats){
    List<TableDataDTO> tableDataDTO = new ArrayList<>();

    for (TeamStats teamStat : teamStats) {
      tableDataDTO.add(new TableDataDTO(teamStat));
    }

    TableDTOList tableDTO = new TableDTOList(tableDataDTO);
    return tableDTO;
  }
}
