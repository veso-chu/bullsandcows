package com.proxiad.bullsandcows.guess;

import com.proxiad.bullsandcows.game.GameGoalConstraint;
import jakarta.validation.constraints.NotEmpty;

public class GuessCreateForm {

  @NotEmpty @GameGoalConstraint private String guess;

  public GuessCreateForm(String guess) {
    this.setGuess(guess);
  }

  public String getGuess() {
    return guess;
  }

  public void setGuess(String guess) {
    this.guess = guess;
  }
}
