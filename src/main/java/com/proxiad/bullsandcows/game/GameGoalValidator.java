package com.proxiad.bullsandcows.game;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GameGoalValidator implements ConstraintValidator<GameGoalConstraint, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value.matches("^(?!.*(.).*\\1)\\d{4}$");
	}
}
