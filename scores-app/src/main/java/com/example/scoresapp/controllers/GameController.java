package com.example.scoresapp.controllers;

import com.example.scoresapp.dtos.NewGameDTO;
import com.example.scoresapp.dtos.ScoreDTO;
import com.example.scoresapp.exceptions.TeamMismatchException;
import com.example.scoresapp.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
  public class GameController {
  private final GameService gameService;

  @Autowired
  public GameController(GameService gameService) {
    this.gameService = gameService;
  }

  @PostMapping("/api/games")
  public ResponseEntity<?> createGame(@RequestBody NewGameDTO newGameDTO) {
    try {
      return ResponseEntity.status(200).body(gameService.createGame(newGameDTO));
    } catch (NoSuchElementException e){
      return ResponseEntity.status(400).body(e.getMessage());
    }
  }

  @PatchMapping("/api/games/{gameId}")
  public ResponseEntity<?> playGame(@PathVariable Long gameId, @RequestBody ScoreDTO scoreDTO) {
    try {
      gameService.playGame(gameId, scoreDTO);
      return ResponseEntity.status(200).build();
    } catch (TeamMismatchException e){
      return ResponseEntity.status(400).body(e.getMessage());
    }
  }
}
