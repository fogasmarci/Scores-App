package com.example.scoresapp.controllers;

import com.example.scoresapp.services.FootballCompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.NoSuchElementException;

@Controller
public class CompetitionController {
  private FootballCompetitionService competitionService;

  @Autowired
  public CompetitionController(FootballCompetitionService competitionService) {
    this.competitionService = competitionService;
  }

  @GetMapping("/api/competition/{competitionName}")
  public ResponseEntity<?> listGames(@PathVariable String competitionName) {
    try {
      return ResponseEntity.status(200).body(competitionService.listGames(competitionName));
    } catch (NoSuchElementException e){
      return ResponseEntity.status(400).body(e.getMessage());
    }
  }

  @GetMapping("/api/competition/{competitionName}/table")
  public ResponseEntity<?> showBoard(@PathVariable String competitionName) {
    try {
      return ResponseEntity.status(200).body(competitionService.showTable(competitionName));
    } catch (NoSuchElementException e){
      return ResponseEntity.status(400).body(e.getMessage());
    }
  }
}
