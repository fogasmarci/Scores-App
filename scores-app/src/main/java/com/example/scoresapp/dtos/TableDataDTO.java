package com.example.scoresapp.dtos;

import com.example.scoresapp.models.TeamStats;

public class TableDataDTO {
    private String competitionName;
    private int teamRank;
    private String teamName;
    private Long apiID;
    private int gamesPlayed;
    private int wins;
    private int draws;
    private int losses;
    private int goalDifference;
    private int points;

    public TableDataDTO(TeamStats teamStat) {
        competitionName = teamStat.getCompetition().getName();
        teamRank = teamStat.getTeamRank();
        teamName = teamStat.getTeam().getName();
        apiID = teamStat.getTeam().getApiId();
        gamesPlayed = teamStat.getGamesPlayed();
        wins = teamStat.getWins();
        draws = teamStat.getDraws();
        losses = teamStat.getLosses();
        goalDifference = teamStat.getGoalDifference();
        points = teamStat.getPoints();
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public int getTeamRank() {
        return teamRank;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getLosses() {
        return losses;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public int getPoints() {
        return points;
    }

    public Long getApiID() {
        return apiID;
    }
}
