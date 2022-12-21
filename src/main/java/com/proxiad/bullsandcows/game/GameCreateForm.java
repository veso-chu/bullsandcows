package com.proxiad.bullsandcows.game;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameCreateForm {

  @NotEmpty @GameGoalConstraint private String goal;

  /**
   * Constructor
   *
   * @param goal
   */
  public GameCreateForm(String goal) {
    this.setGoal(goal);
  }
}
