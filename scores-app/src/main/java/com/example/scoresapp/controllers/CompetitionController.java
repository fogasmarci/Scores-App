package com.example.scoresapp.controllers;

import com.example.scoresapp.services.CompetitionService;
import com.example.scoresapp.services.TeamStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CompetitionController {
    private final CompetitionService competitionService;
    private final TeamStatsService teamStatsService;

    @Autowired
    public CompetitionController(CompetitionService competitionService, TeamStatsService teamStatsService) {
        this.competitionService = competitionService;
        this.teamStatsService = teamStatsService;
    }

    @GetMapping("/competition/{competitionName}")
    public String displayAllGames(@PathVariable String competitionName, Model model) {
        model.addAttribute("games", competitionService.listGames(competitionName));
        model.addAttribute("competitionName", competitionName);
        return "competition/main";
    }

    @GetMapping("/competition/{competitionName}/games")
    public String displayGames(@PathVariable String competitionName, Model model) {
        model.addAttribute("results", competitionService.showResults(competitionName));
        return "competition/results";
    }

    @GetMapping("/competition/{competitionName}/results")
    public String displayResults(@PathVariable String competitionName, Model model) {
        model.addAttribute("results", competitionService.showResults(competitionName));
        return "competition/results";
    }

    @GetMapping("/competition/{competitionName}/table")
    public String displayTable(@PathVariable String competitionName, Model model) {
        model.addAttribute("tableData", competitionService.showTable(competitionName));
        return "competition/table";
    }
}
