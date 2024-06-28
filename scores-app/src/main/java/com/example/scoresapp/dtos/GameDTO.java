package com.example.scoresapp.dtos;

import com.example.scoresapp.models.Game;
import com.example.scoresapp.models.GameStatus;

import java.time.format.DateTimeFormatter;

public class GameDTO {
  private Long id;
  private String startTime;
  private String competitionName;
  private String homeTeamName;
  private Integer homeTeamScore;
  private String awayTeamName;
  private Integer awayTeamScore;
  private GameStatus gameStatus;

  public GameDTO(Game game) {
    id = game.getId();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
    startTime = game.getStartTime().format(formatter);
    competitionName = game.getCompetition().getName();
    homeTeamName = game.getHomeTeamName();
    awayTeamName = game.getAwayTeamName();
    homeTeamScore = game.getHomeTeamScore();
    awayTeamScore = game.getAwayTeamScore();
    this.gameStatus = game.getGameStatus();
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

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public void setCompetitionName(String competitionName) {
    this.competitionName = competitionName;
  }

  public void setHomeTeamName(String homeTeamName) {
    this.homeTeamName = homeTeamName;
  }

  public void setHomeTeamScore(Integer homeTeamScore) {
    this.homeTeamScore = homeTeamScore;
  }

  public void setAwayTeamName(String awayTeamName) {
    this.awayTeamName = awayTeamName;
  }

  public void setAwayTeamScore(Integer awayTeamScore) {
    this.awayTeamScore = awayTeamScore;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public GameStatus getGameStatus() {
    return gameStatus;
  }
}
