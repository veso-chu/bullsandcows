package com.proxiad.bullsandcows.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GameGoalValidatorTest {

  @Test
  void testValidateGameGoalStringReturnsTrueIfGameGoalStringIsFourUniqueNumericCharacters() {
    assertThat(GameGoalValidator.validateGameGoalString("1234")).isTrue();
  }

  @Test
  void testValidateGameGoalStringReturnsFalseIfGameGoalStringIsTooLong() {
    assertThat(GameGoalValidator.validateGameGoalString("12345")).isFalse();
  }

  @Test
  void testValidateGameGoalStringReturnsFalseIfGameGoalStringContainsNonUniqueCharacters() {
    assertThat(GameGoalValidator.validateGameGoalString("1233")).isFalse();
  }

  @Test
  void testValidateGameGoalStringReturnsFalseIfGameGoalStringContainsNonNumericCharacters() {
    assertThat(GameGoalValidator.validateGameGoalString("123a")).isFalse();
  }

  @Nested
  class isValidTests {

    ConstraintValidatorContext constraintValidatorContext;
    GameGoalValidator gameGoalValidator;

    @BeforeEach
    void setUp() {
      constraintValidatorContext = mock(ConstraintValidatorContext.class);
      gameGoalValidator = new GameGoalValidator();
    }

    @Test
    void testIsValidReturnsTrueIfGameGoalStringIsFourUniqueNumericCharacters() {
      assertThat(gameGoalValidator.isValid("1234", constraintValidatorContext)).isTrue();
    }

    @Test
    void testIsValidReturnsFalseIfGameGoalStringIsTooLong() {
      assertThat(gameGoalValidator.isValid("12345", constraintValidatorContext)).isFalse();
    }

    @Test
    void testIsValidReturnsFalseIfGameGoalStringContainsNonUniqueCharacters() {
      assertThat(gameGoalValidator.isValid("1233", constraintValidatorContext)).isFalse();
    }

    @Test
    void testIsValidReturnsFalseIfGameGoalStringContainsNonNumericCharacters() {
      assertThat(gameGoalValidator.isValid("123a", constraintValidatorContext)).isFalse();
    }
  }
}
