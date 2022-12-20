package com.proxiad.bullsandcows.guess;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class GuessCreateFormTest {

  @Test
  void testConstructorProperlySetsGuessValue() {
    String guess = "1234";
    GuessCreateForm guessCreateForm = new GuessCreateForm(guess);

    assertThat(guessCreateForm.getGuess()).isEqualTo(guess);
  }
}
