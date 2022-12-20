package com.proxiad.bullsandcows.game;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameCreateForm {

  @NotEmpty @GameGoalConstraint private String goal;

  public GameCreateForm(String goal) {
    this.setGoal(goal);
  }
}
