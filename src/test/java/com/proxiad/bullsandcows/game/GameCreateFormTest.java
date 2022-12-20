package com.proxiad.bullsandcows.game;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class GameCreateFormTest {

  @Test
  void testConstructorProperlySetsGoalValue() {
    String goal = "1234";
    GameCreateForm gameCreateForm = new GameCreateForm(goal);

    assertThat(gameCreateForm.getGoal()).isEqualTo(goal);
  }
}
