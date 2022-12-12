package com.proxiad.bullsandcows.game;

import com.proxiad.bullsandcows.guess.Guess;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public class Game {

  private String id;
  @NotEmpty @GameGoalConstraint private String goal;
  private boolean solved;
  private List<Guess> guessList;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getGoal() {
    return goal;
  }

  public void setGoal(String goal) {
    this.goal = goal;
  }

  public boolean isSolved() {
    return solved;
  }

  public void setSolved(boolean solved) {
    this.solved = solved;
  }

  public List<Guess> getGuessList() {
    return guessList;
  }

  public void setGuessList(List<Guess> gameInfo) {
    this.guessList = gameInfo;
  }
}
