package com.proxiad.bullsandcows.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.Map;

import org.junit.jupiter.api.Test;

class GameServiceTest {

	private final String GOAL_STRING = "1234";
	private final String TOO_LONG_STRING = "12345";
	private final String NON_UNIQUE_NUMBERS_STRING = "1233";
	private final String NON_NUMERIC_STRING = "123a";
	private final String COW_MATCH_STRING = "4567";
	private final String BULL_MATCH_STRING = "1567";

	private final GameRepository gameRepository = new GameRepository();
	private final GameService gameService = new GameService(gameRepository);
	private final Game game = new Game(GOAL_STRING);
	private final Game mockGame = mock(Game.class);

	@Test
	void testGetGamesAlwaysReturnsAnInitializedList() {
		boolean listIsNotInitialized = gameService.getGames().equals(null);
		assertFalse(listIsNotInitialized);
	}

	@Test
	void testGetGamesReturnsListOfSizeOneAfterCreateGameIsUsed() {
		gameService.createGame(mockGame);
		assertEquals(1, gameService.getGames().size());
	}

	@Test
	void testGetGameReturnsTheCorrectGameAfterUsingCreateGame() {
		gameService.createGame(mockGame);
		assertEquals(mockGame, gameService.getGame(mockGame.getId()));
	}

	@Test
	void testGuessGameGoalReturnsListWithOneCowIfStringGoalContainsOneOfThePassedNumbersButOnWrongPosition() {
		assertTrue(bullsAndCowsSizeBasedOnPassedGuessString(COW_MATCH_STRING, 0, 1));
	}

	@Test
	void testGuessGameGoalReturnsListWithOneBullIfStringGoalMatchesOneOfThePassedNumbersOnCorrectPosition() {
		assertTrue(bullsAndCowsSizeBasedOnPassedGuessString(BULL_MATCH_STRING, 1, 0));
	}

	@Test
	void testGuessGameGoalReturnsListWithZeroBullsAndCowsKeysIfStringGoalIsTooLong() {
//		gameService.createGame(game);
//		Map<String, Integer> guessMap = gameService.guessGameGoal(game, TOO_LONG_STRING);
//		boolean result = guessMap.get("bulls").equals(0);
//		result &= guessMap.get("cows").equals(0);

//		assertEquals(guessMap.get("bulls"), 0);
//		assertEquals(guessMap.get("cows"), 0);
		assertTrue(bullsAndCowsSizeBasedOnPassedGuessString(TOO_LONG_STRING, 0, 0));
	}

	@Test
	void testGuessGameGoalReturnsListWithZeroBullsAndCowsKeysIfStringGoalConsistsOfNonUniqueNumbers() {
		assertTrue(bullsAndCowsSizeBasedOnPassedGuessString(NON_UNIQUE_NUMBERS_STRING, 0, 0));
	}

	@Test
	void testGuessGameGoalReturnsListWithZeroBullsAndCowsKeysIfStringGoalConsistsOfNonNumericString() {
		assertTrue(bullsAndCowsSizeBasedOnPassedGuessString(NON_NUMERIC_STRING, 0, 0));
	}

	private boolean bullsAndCowsSizeBasedOnPassedGuessString(String testString, Integer expectedBullsSize, Integer expectedCowsSize) {
		gameService.createGame(game);
		Map<String, Integer> guessMap = gameService.guessGameGoal(game, testString);
		boolean result = guessMap.get("bulls").equals(expectedBullsSize);
		result &= guessMap.get("cows").equals(expectedCowsSize);

		return result;
	}

	@Test
	void testGuessGameGoalIncreasesTheGuessesSizeOfGameInfoRelatedGame() {
		gameService.createGame(game);
		gameService.guessGameGoal(game, BULL_MATCH_STRING);
		Integer guessesCount = game.getGameInfo().getGuesses().size();

		assertEquals(1, guessesCount);
	}

	@Test
	void testGuessGameGoalSetsGameSolvedToTrueOnCorrectGuess() {
		gameService.createGame(game);
		gameService.guessGameGoal(game, GOAL_STRING);

		assertTrue(game.isSolved());
	}

	@Test
	void testGuessGameGoalDoesNotChangeGameSolvedOnIncorrectGuess() {
		gameService.createGame(game);
		gameService.guessGameGoal(game, BULL_MATCH_STRING);

		assertFalse(game.isSolved());
	}
}
