package com.example.scoresapp.services;

import com.example.scoresapp.dtos.GameDTO;
import com.example.scoresapp.dtos.TableDTOList;

import java.util.List;

public interface FootballCompetitionService {


  List<GameDTO> listGames(String competitionName);

  List<TableDTOList> showTable(String competitionName);
}
