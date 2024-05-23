package com.example.scoresapp.controllers;

import com.example.scoresapp.dtos.NewGameDTO;
import com.example.scoresapp.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
public class TeamController {
  private TeamService teamService;

  @Autowired
  public TeamController(TeamService teamService){
    this.teamService = teamService;
  }

  @GetMapping("/api/teams/{teamName}")
  public ResponseEntity<?> listGames(@PathVariable String teamName) {
    try {
      return ResponseEntity.status(200).body(teamService.listGames(teamName));
    } catch (NoSuchElementException e){
      return ResponseEntity.status(400).body(e.getMessage());
    }
  }
}
