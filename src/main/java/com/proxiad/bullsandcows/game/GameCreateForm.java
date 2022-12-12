package com.proxiad.bullsandcows.game;

import jakarta.validation.constraints.NotEmpty;

public class GameCreateForm {

  @NotEmpty @GameGoalConstraint private String goal;

  public GameCreateForm(String goal) {
    this.setGoal(goal);
  }

  public String getGoal() {
    return goal;
  }

  public void setGoal(String goal) {
    this.goal = goal;
  }
}
