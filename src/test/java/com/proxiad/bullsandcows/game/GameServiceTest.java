// package com.proxiad.bullsandcows.game;
//
// import static org.assertj.core.api.Assertions.assertThat;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertFalse;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.when;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.params.ParameterizedTest;
// import org.junit.jupiter.params.provider.CsvSource;
//
// class GameServiceTest {
//
//  private final String GOAL_STRING = "1234";
//  private final String TOO_LONG_STRING = "12345";
//  private final String NON_UNIQUE_NUMBERS_STRING = "1233";
//  private final String NON_NUMERIC_STRING = "123a";
//  private final String COW_MATCH_STRING = "4567";
//  private final String BULL_MATCH_STRING = "1567";
//
//  private GameRepo gameRepository;
//  private GameService gameService;
//
//  @BeforeEach
//  void setUp() {
//    gameRepository = mock(GameRepo.class);
//    gameService = new GameServiceImpl(gameRepository);
//  }
//
//  @Test
//  void testGetGamesAlwaysReturnsAnInitializedList() {
//    boolean listIsNotInitialized = gameService.getGames().equals(null);
//    assertFalse(listIsNotInitialized);
//  }
//
//  @Test
//  void testGetGamesReturnsListOfSizeOneAfterCreateGameIsUsed() {
//    Game game = gameService.createGame("1234");
//    assertThat(game.getId()).isNotNull();
//    assertThat(game.getGoal()).isEqualTo("1234");
//    assertThat(game.getGameInfo().getGuesses()).isEmpty();
//  }
//
//  @Test
//  void testGetGameReturnsTheCorrectGame() {
//    Game game = new Game();
//    game.setId("12345");
//    game.setGoal("1234");
//    when(gameRepository.findById("12345")).thenReturn(game);
//
//    Game returnedGame = gameService.getGame("12345");
//    assertThat(returnedGame).isSameAs(game);
//  }
//
//  @CsvSource({"2143,0,4", "1432,2,2", "1234,4,0", "5678,0,0"})
//  @ParameterizedTest
//  void testGuessGameGoalReturnsListWithOneCow(String guess, int bulls, int cows) {
//    Game game = new Game();
//    game.setId("12345");
//    game.setGoal("1234");
//    game.setGameInfo(new GameInfo());
//    when(gameRepository.findById("12345")).thenReturn(game);
//
//    var returnedGame = gameService.guessGameGoal("12345", guess);
//    assertThat(game.getGameInfo().getGuesses()).hasSize(1);
//    var result = game.getGameInfo().getGuesses().get(0);
//    assertThat(result.getGuess()).isEqualTo(guess);
//    assertThat(result.getGuessResult().get("bulls")).isEqualTo(bulls);
//    assertThat(result.getGuessResult().get("cows")).isEqualTo(cows);
//  }
//
//  @Test
//  void
//
// testGuessGameGoalReturnsListWithOneBullIfStringGoalMatchesOneOfThePassedNumbersOnCorrectPosition() {
//    assertTrue(bullsAndCowsSizeBasedOnPassedGuessString(BULL_MATCH_STRING, 1, 0));
//  }
//
//  @Test
//  void testGuessGameGoalReturnsListWithZeroBullsAndCowsKeysIfStringGoalIsTooLong() {
//    //		gameService.createGame(game);
//    //		Map<String, Integer> guessMap = gameService.guessGameGoal(game, TOO_LONG_STRING);
//    //		boolean result = guessMap.get("bulls").equals(0);
//    //		result &= guessMap.get("cows").equals(0);
//
//    //		assertEquals(guessMap.get("bulls"), 0);
//    //		assertEquals(guessMap.get("cows"), 0);
//    assertTrue(bullsAndCowsSizeBasedOnPassedGuessString(TOO_LONG_STRING, 0, 0));
//  }
//
//  @Test
//  void
//      testGuessGameGoalReturnsListWithZeroBullsAndCowsKeysIfStringGoalConsistsOfNonUniqueNumbers()
// {
//    assertTrue(bullsAndCowsSizeBasedOnPassedGuessString(NON_UNIQUE_NUMBERS_STRING, 0, 0));
//  }
//
//  //  @Test
//  //  void
//  //
//  // testGuessGameGoalReturnsListWithZeroBullsAndCowsKeysIfStringGoalConsistsOfNonNumericString()
// {
//  //    assertTrue(bullsAndCowsSizeBasedOnPassedGuessString(NON_NUMERIC_STRING, 0, 0));
//  //  }
//
//  //  private boolean bullsAndCowsSizeBasedOnPassedGuessString(
//  //      String testString, Integer expectedBullsSize, Integer expectedCowsSize) {
//  //    gameService.createGame(game);
//  //    Map<String, Integer> guessMap = gameService.guessGameGoal(game, testString);
//  //    boolean result = guessMap.get("bulls").equals(expectedBullsSize);
//  //    result &= guessMap.get("cows").equals(expectedCowsSize);
//  //
//  //    return result;
//  //  }
//
//  @Test
//  void testGuessGameGoalIncreasesTheGuessesSizeOfGameInfoRelatedGame() {
//    gameService.createGame(game);
//    gameService.guessGameGoal(game, BULL_MATCH_STRING);
//    Integer guessesCount = game.getGameInfo().getGuesses().size();
//
//    assertEquals(1, guessesCount);
//  }
//
//  @Test
//  void testGuessGameGoalSetsGameSolvedToTrueOnCorrectGuess() {
//    gameService.createGame(game);
//    gameService.guessGameGoal(game, GOAL_STRING);
//
//    assertTrue(game.isSolved());
//  }
//
//  @Test
//  void testGuessGameGoalDoesNotChangeGameSolvedOnIncorrectGuess() {
//    gameService.createGame(game);
//    gameService.guessGameGoal(game, BULL_MATCH_STRING);
//
//    assertFalse(game.isSolved());
//  }
// }
