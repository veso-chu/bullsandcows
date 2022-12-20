package com.proxiad.bullsandcows.guess;

import com.proxiad.bullsandcows.game.GameGoalConstraint;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GuessCreateForm {

  @NotEmpty @GameGoalConstraint private String guess;

  /**
   * Constructor
   *
   * @param guess
   */
  public GuessCreateForm(String guess) {
    this.setGuess(guess);
  }
}
