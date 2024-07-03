package com.example.scoresapp.controllers;

import com.example.scoresapp.dtos.GameDTO;
import com.example.scoresapp.dtos.NewGameDTO;
import com.example.scoresapp.dtos.ScoreDTO;
import com.example.scoresapp.services.ApiService;
import com.example.scoresapp.services.CompetitionService;
import com.example.scoresapp.services.GameService;
import com.example.scoresapp.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
  public class GameRestController {
  private final GameService gameService;
  private final CompetitionService competitionService;
  private final TeamService teamService;
  private final ApiService apiService;

  @Autowired
  public GameRestController(GameService gameService, CompetitionService competitionService, TeamService teamService, ApiService apiService) {
    this.gameService = gameService;
    this.competitionService = competitionService;
    this.teamService = teamService;
    this.apiService = apiService;
  }

  @PostMapping("/api/games")
  public ResponseEntity<?> createGame(@RequestBody NewGameDTO newGameDTO) {
    try {
      gameService.createGame(newGameDTO);
      return ResponseEntity.status(200).build();
    } catch (NoSuchElementException e){
      return ResponseEntity.status(400).body(e.getMessage());
    }
  }

  @PatchMapping("/api/games/{gameId}")
  public ResponseEntity<?> playGame(@PathVariable Long gameId, @RequestBody ScoreDTO scoreDTO) {
    try {
      gameService.playGame(gameId, scoreDTO);
      return ResponseEntity.status(200).build();
    } catch (NoSuchElementException e){
      return ResponseEntity.status(400).body(e.getMessage());
    }
  }

  @GetMapping("/api/search")
  public ResponseEntity<?> performSearch(@RequestParam String searchTerm) {
    try {
      competitionService.checkIfCompetitionExists(searchTerm);
      /*teamService.checkIfTeamExists(searchTerm);*/ //ezt még módosítani kell, hogy az adott competition VAGY team oldalára vigyen
      return ResponseEntity.status(200).build();
    } catch (NoSuchElementException e){
      return ResponseEntity.status(400).body(e.getMessage());
    }
  }

  @PatchMapping("/api/game/result")
  public ResponseEntity<?> getGameResult(@RequestParam String h2h, @RequestParam String date) {
    try {
      return ResponseEntity.status(200).body(apiService.getGameResult(h2h, date));
    } catch (Exception e) {
        return ResponseEntity.status(500).body("Error fetching competitions: " + e.getMessage());
    }
  }
}
