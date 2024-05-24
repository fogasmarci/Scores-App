package com.example.scoresapp.models;

import com.example.scoresapp.dtos.ScoreDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "team_stats")
public class TeamStats {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumn (name = "competition_id")
  private Competition competition;
  @Column(name = "team_rank")
  private int teamRank;
  @Column(name = "team_name")
  private String teamName;
  @Column(name = "games_played")
  private int gamesPlayed;
  private int wins;
  private int draws;
  private int losses;
  @Column(name = "goal_difference")
  private int goalDifference;
  private int points;

  public TeamStats() {

  }

  public TeamStats(String teamName) {
    teamRank = 1;
    this.teamName = teamName;
    gamesPlayed = 0;
    wins = 0;
    draws = 0;
    losses = 0;
    goalDifference = 0;
    points = 0;
  }

  public Competition getCompetition() {
    return competition;
  }

  public void setCompetition(Competition competition) {
    this.competition = competition;
  }

  public int getTeamRank() {
    return teamRank;
  }

  public void setTeamRank(int rank) {
    this.teamRank = rank;
  }

  public String getTeamName() {
    return teamName;
  }

  public void setTeamName(String teamName) {
    teamName = teamName;
  }

  public int getGamesPlayed() {
    return gamesPlayed;
  }

  public void setGamesPlayed(int gamesPlayed) {
    this.gamesPlayed = gamesPlayed;
  }

  public int getWins() {
    return wins;
  }

  public void setWins(int wins) {
    this.wins = wins;
  }

  public int getDraws() {
    return draws;
  }

  public void setDraws(int draws) {
    this.draws = draws;
  }

  public int getLosses() {
    return losses;
  }

  public void setLosses(int loses) {
    this.losses = loses;
  }


  public int getGoalDifference() {
    return goalDifference;
  }

  public void setGoalDifference(int goalDifference) {
    this.goalDifference = goalDifference;
  }

  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
  }


  public void drewGame(ScoreDTO scoreDTO){
    gamesPlayed++;
    draws++;
    goalDifference = goalDifference + scoreDTO.homeTeamScore() - scoreDTO.awayTeamScore();
    points++;
  }

  public void wonGame(ScoreDTO scoreDTO){
    gamesPlayed++;
    wins++;
    goalDifference = goalDifference + scoreDTO.homeTeamScore() - scoreDTO.awayTeamScore();
    points = points + 3;
  }

  public void lostGame(ScoreDTO scoreDTO){
    gamesPlayed++;
    losses++;
    goalDifference = goalDifference + scoreDTO.homeTeamScore() - scoreDTO.awayTeamScore();
  }

}