package com.proxiad.bullsandcows.game;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GameGoalValidatorTest {

	private final String ACCEPTED_STRING = "1234";
	private final String TOO_LONG_STRING = "12345";
	private final String NON_UNIQUE_NUMBERS_STRING = "1233";
	private final String NON_NUMERIC_STRING = "123a";

	@Test
	void testValidateGameGoalStringReturnsTrueIfGameGoalStringIsFourUniqueNumericCharacters() {
		assertTrue(GameGoalValidator.validateGameGoalString(ACCEPTED_STRING));
	}

	@Test
	void testValidateGameGoalStringReturnsFalseIfGameGoalStringIsTooLong() {
		assertFalse(GameGoalValidator.validateGameGoalString(TOO_LONG_STRING));
	}

	@Test
	void testValidateGameGoalStringReturnsFalseIfGameGoalStringContainsNonUniqueCharacters() {
		assertFalse(GameGoalValidator.validateGameGoalString(NON_UNIQUE_NUMBERS_STRING));
	}

	@Test
	void testValidateGameGoalStringReturnsFalseIfGameGoalStringContainsNonNumericCharacters() {
		assertFalse(GameGoalValidator.validateGameGoalString(NON_NUMERIC_STRING));
	}
}
