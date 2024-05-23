package com.example.scoresapp.dtos;

import com.example.scoresapp.models.Competition;

import java.util.List;

public class TableDTO {
  private Competition competition;
  private int rank;
  private String TeamName;
  private int gamesPlayed;
  private int wins;
  private int draws;
  private int loses;
  private String goalRatio;
  private int goalDifference;
  private int points;
  private List<GameDTO> form;
}
