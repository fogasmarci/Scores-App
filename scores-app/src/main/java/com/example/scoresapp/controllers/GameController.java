package com.example.scoresapp.controllers;

import com.example.scoresapp.dtos.GameDTO;
import com.example.scoresapp.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/")
    public String displayAllGames(Model model) {
        model.addAttribute("gamesGroupedByCompetition", gameService.listAllGames());
            return "home";
    }

    @GetMapping("/game/{gameId}")
    public String displayAllGames(@PathVariable Long gameId, Model model) {
        model.addAttribute("gameDTO", gameService.findGameById(gameId));
        return "game";
    }
}
