package com.example.scoresapp.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "games")
public class Game {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @Column(name = "home_team_score")
  private Integer homeTeamScore;
  @Column(name = "away_team_score")
  private Integer awayTeamScore;
  private int round;
  @Column(name = "game_status")
  private GameStatus gameStatus;
  @Column(name = "start_time")
  private LocalDateTime startTime;
  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn (name = "competition_id")
  private Competition competition;
  @ManyToMany (fetch = FetchType.EAGER)
  @JoinTable(
      name = "game_team",
      joinColumns = @JoinColumn(name = "game_id"),
      inverseJoinColumns = @JoinColumn(name = "team_id"))
  private List<Team> teams;
  @OneToOne
  @JoinColumn (name = "game_details_id")
  private GameDetails gameDetails;

  public Game() {
    gameStatus = GameStatus.Not_started;
  }

  public Game (String name, Competition competition, int round, List<Team> teams, LocalDateTime startTime) {
    this();
    this.name = name;
    this.competition = competition;
    this.round = round;
    this.teams = teams;
    this.startTime = startTime;
  }

  public void finishGame(){
    this.gameStatus = GameStatus.Finished;
    teams.get(0).addToPlayedGames(this);
    teams.get(1).addToPlayedGames(this);
    competition.addToPlayedGames(this);
  }

  public GameStatus getGameStatus() {
    return gameStatus;
  }

  public void setGameStatus(GameStatus gameStatus) {
    this.gameStatus = gameStatus;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }

  public Competition getCompetition() {
    return competition;
  }

  public void setCompetition(Competition competition) {
    this.competition = competition;
  }

  public int getHomeTeamScore() {
    return homeTeamScore;
  }

  public void setHomeTeamScore(int homeTeamScore) {
    this.homeTeamScore = homeTeamScore;
  }

  public int getAwayTeamScore() {
    return awayTeamScore;
  }

  public void setAwayTeamScore(int awayTeamScore) {
    this.awayTeamScore = awayTeamScore;
  }

  public int getRound() {
    return round;
  }

  public void setRound(int round) {
    this.round = round;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Team> getTeams() {
    return teams;
  }

  public GameDetails getGameDetails() {
    return gameDetails;
  }

  public void setGameDetails(GameDetails gameDetails) {
    this.gameDetails = gameDetails;
  }
}
