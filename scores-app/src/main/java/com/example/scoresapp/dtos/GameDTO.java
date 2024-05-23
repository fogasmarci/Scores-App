package com.example.scoresapp.dtos;

import com.example.scoresapp.models.Game;

public class GameDTO {
  private String startTime;
  private String competitionName;
  private String homeTeamName;
  private Integer homeTeamScore;
  private String awayTeamName;
  private Integer awayTeamScore;

  public GameDTO(Game game) {
    startTime = game.getStartTime().toString();
    competitionName = game.getCompetition().getName();
    homeTeamName = game.getHomeTeamName();
    awayTeamName = game.getAwayTeamName();
    homeTeamScore = game.getHomeTeamScore();
    awayTeamScore = game.getAwayTeamScore();
  }

  public String getStartTime() {
    return startTime;
  }

  public String getCompetitionName() {
    return competitionName;
  }

  public String getHomeTeamName() {
    return homeTeamName;
  }

  public Integer getHomeTeamScore() {
    return homeTeamScore;
  }

  public String getAwayTeamName() {
    return awayTeamName;
  }

  public Integer getAwayTeamScore() {
    return awayTeamScore;
  }
}
