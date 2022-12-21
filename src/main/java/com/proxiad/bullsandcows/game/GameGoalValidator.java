package com.proxiad.bullsandcows.game;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GameGoalValidator implements ConstraintValidator<GameGoalConstraint, String> {

  public static final String REGEX_FOUR_NONREPEATING_NUMBERS = "^(?!.*(.).*\\1)\\d{4}$";

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return validateGameGoalString(value);
  }

  /**
   * Checks if the passed string consists of exactly 4 unique digits
   *
   * @param gameGoalString The string the RegEx match will be tested on
   * @return
   */
  public static boolean validateGameGoalString(String gameGoalString) {
    return gameGoalString.matches(REGEX_FOUR_NONREPEATING_NUMBERS);
  }
}
