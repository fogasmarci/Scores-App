package com.example.scoresapp.services;

import com.example.scoresapp.dtos.GameDTO;

import java.util.List;

public interface TeamService {

  List<GameDTO> listGames(String teamName);

  Boolean checkIfTeamExists(String teamName);

}
