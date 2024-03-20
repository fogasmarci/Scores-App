package com.example.scoresapp.models;

import java.util.List;

public class Cup extends Competition {
  private List<List<Team>> groups;

  public Cup(List<List<Team>> groups) {
    this.groups = groups;
  }
}
