package com.proxiad.bullsandcows.game;

class GameServiceTest {

  //  private final String VALID_GOAL_STRING = "1234";
  //
  //  private GameRepository gameRepository;
  //  private GameService gameService;
  //
  //  @BeforeEach
  //  void setUp() {
  //    gameRepository = mock(GameRepository.class);
  //    gameService = new GameServiceImpl(gameRepository);
  //  }
  //
  //  @Test
  //  void testGetGamesAlwaysReturnsAnInitializedList() {
  //    boolean listIsNotNull = !gameService.getGames().equals(null);
  //    assertTrue(listIsNotNull);
  //  }
  //
  //  @Test
  //  void testGetGamesReturnsListOfSizeOneAfterCreateGameIsUsed() {
  //    Game game = gameService.createGame(VALID_GOAL_STRING);
  //    assertThat(game.getId()).isNotNull();
  //    assertThat(game.getGoal()).isEqualTo(VALID_GOAL_STRING);
  //    assertThat(game.getGuessList()).isEmpty();
  //  }
  //
  //  @Test
  //  void testGetGameReturnsTheCorrectGame() {
  //    Game game = new Game();
  //    game.setId("12345");
  //    game.setGoal(VALID_GOAL_STRING);
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
  //    game.setGoal(VALID_GOAL_STRING);
  //    game.setGuessList(new ArrayList<>());
  //    when(gameRepository.findById("12345")).thenReturn(game);
  //
  //    var returnedGame = gameService.guessGameGoal("12345", guess);
  //    assertThat(returnedGame.getGuessList()).hasSize(1);
  //    var result = returnedGame.getGuessList().get(0);
  //    assertThat(result.getGuess()).isEqualTo(guess);
  //    assertThat(result.getBulls()).isEqualTo(bulls);
  //    assertThat(result.getCows()).isEqualTo(cows);
  //  }
}
