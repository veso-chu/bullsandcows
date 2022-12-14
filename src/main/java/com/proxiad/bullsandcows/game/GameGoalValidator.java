package com.proxiad.bullsandcows.game;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GameGoalValidator implements ConstraintValidator<GameGoalConstraint, String> {

	public static final String REGEX_FOUR_NONREPEATING_NUMBERS = "^(?!.*(.).*\\1)\\d{4}$";

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return validateGameGoalString(value);
	}

	public static boolean validateGameGoalString(String gameGoalString) {
		return gameGoalString.matches(REGEX_FOUR_NONREPEATING_NUMBERS);
	}
}
