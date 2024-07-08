package com.example.scoresapp.controllers;

import com.example.scoresapp.services.ApiService;
import com.example.scoresapp.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
public class TeamRestController {
  private TeamService teamService;
  private ApiService apiService;

  @Autowired
  public TeamRestController(TeamService teamService, ApiService apiService){
    this.teamService = teamService;
    this.apiService = apiService;
  }

  @GetMapping("/api/teams/{teamName}")
  public ResponseEntity<?> listGames(@PathVariable String teamName) {
    try {
      return ResponseEntity.status(200).body(teamService.listGames(teamName));
    } catch (NoSuchElementException e){
      return ResponseEntity.status(400).body(e.getMessage());
    }
  }

  @GetMapping("/api/teams/logo")
  public ResponseEntity<?> getTeamLogo() {
    try {
      apiService.getTeamIdFromTeamName();
      return ResponseEntity.status(200).build();
    } catch (Exception e) {
      return ResponseEntity.status(500).body("Error fetching competitions: " + e.getMessage());
    }
  }
}
