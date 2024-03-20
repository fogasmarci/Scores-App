package com.example.scoresapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

public class NationalPlayer extends Player{
  @ManyToOne
  @Column(name = "national_team")
  private Team nationalTeam;

}
