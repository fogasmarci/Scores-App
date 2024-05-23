package com.example.scoresapp.services;

import com.example.scoresapp.dtos.GameDTO;

import java.util.List;

public interface TeamService {
  public List<GameDTO> listGames(String teamName);
}
