package com.example.scoresapp.exceptions;

public class TeamMismatchException extends RuntimeException{

  public TeamMismatchException() {
    super("Team was not found");
  }
}
