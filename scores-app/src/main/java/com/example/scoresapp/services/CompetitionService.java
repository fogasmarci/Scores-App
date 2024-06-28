package com.example.scoresapp.services;

import com.example.scoresapp.dtos.GamesDTO;
import com.example.scoresapp.dtos.TableDTOList;

public interface CompetitionService {

  GamesDTO listGames(String competitionName);

  TableDTOList showTable(String competitionName);

  GamesDTO showResults(String competitionName);

  Boolean checkIfCompetitionExists(String competitionName);
}
