package com.example.scoresapp.services;

import com.example.scoresapp.dtos.GameDTO;
import com.example.scoresapp.dtos.TableDTOList;
import com.example.scoresapp.models.Competition;
import com.example.scoresapp.models.Game;
import com.example.scoresapp.repositories.CompetitionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FootballCompetitionService implements CompetitionService {
  private CompetitionRepository competitionRepository;

  public FootballCompetitionService(CompetitionRepository competitionRepository) {
    this.competitionRepository = competitionRepository;
  }

  @Override
  @Transactional
  public List<GameDTO> listGames(String competitionName) {
    Competition competition = competitionRepository.findByName(competitionName)
        .orElseThrow(() -> new NoSuchElementException("Team name not found"));
    List<Game> games = competition.getGames();

    List<GameDTO> gameDTOList = mapGamesToGameDTO(games);

    return gameDTOList;
  }

  @Override
  public List<TableDTOList> showTable(String competitionName) {
    Competition competition = competitionRepository.findByName(competitionName)
        .orElseThrow(() -> new NoSuchElementException("Team name not found"));

    return null;
  }

  private List<GameDTO> mapGamesToGameDTO(List<Game> games){
  // Team service has a VERY similar method, maybe I should organize them in a separate Class.
    List<GameDTO> gameDTOList = games.stream()
        .map(GameDTO::new)
        .toList();

    return gameDTOList;
  }
}
