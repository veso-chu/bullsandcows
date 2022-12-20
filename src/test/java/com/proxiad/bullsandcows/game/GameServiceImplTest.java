package com.proxiad.bullsandcows.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.proxiad.bullsandcows.guess.GuessService;
import com.proxiad.bullsandcows.guess.GuessServiceImpl;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameServiceImplTest {

  private final String VALID_GOAL_STRING = "1234";

  private GameRepository gameRepository;
  private GuessService guessService;
  private GameService gameService;

  @BeforeEach
  void setUp() {
    gameRepository = mock(GameRepository.class);
    guessService = mock(GuessServiceImpl.class);
    gameService = new GameServiceImpl(gameRepository, guessService);
  }

  @Test
  void testGetGamesAlwaysReturnsAnInitializedList() {
    assertThat(gameService.getGames()).isNotNull();
  }

  @Test
  void testGetGameReturnsTheCorrectGame() {
    Game game = new Game();
    game.setId("12345");
    game.setGoal(VALID_GOAL_STRING);
    game.setSolved(false);
    when(gameRepository.findById("12345")).thenReturn(Optional.of(game));

    Game returnedGame = gameService.getGame("12345");
    assertThat(returnedGame).isSameAs(game);
  }

  @Test
  void testGetGameReturnsNullIfGameDoesNotExist() {
    assertThat(gameService.getGame("54321")).isNull();
  }

  @Test
  void testCreateGameReturnsGameWithCorrectlySetGoal() {
    Game game = gameService.createGame(VALID_GOAL_STRING);

    assertThat(game.getGoal()).isEqualTo(VALID_GOAL_STRING);
  }

  @Test
  void testGuessGameDoesNotSetSolvedToTrueWhenWrongGuessIsPassed() {
    Game game = new Game();
    game.setId("12345");
    game.setGoal(VALID_GOAL_STRING);
    game.setSolved(false);
    when(gameRepository.findById("12345")).thenReturn(Optional.of(game));

    gameService.guessGameGoal("12345", "4321");
    assertThat(game.getSolved()).isFalse();
  }

  @Test
  void testGuessGameSetsSolvedToTrueWhenValidGuessIsPassed() {
    Game game = new Game();
    game.setId("12345");
    game.setGoal(VALID_GOAL_STRING);
    game.setSolved(false);
    when(gameRepository.findById("12345")).thenReturn(Optional.of(game));

    gameService.guessGameGoal("12345", VALID_GOAL_STRING);
    assertThat(game.getSolved()).isTrue();
  }

  //    @Test
  //    void testGetGamesReturnsListOfSizeOneAfterCreateGameIsUsed() {
  //      Game game = gameService.createGame(VALID_GOAL_STRING);
  //      assertThat(game.getId()).isNotNull();
  //      assertThat(game.getGoal()).isEqualTo(VALID_GOAL_STRING);
  //      assertThat(game.getGuessList()).isEmpty();
  //    }
  //
  //
  //  @CsvSource({"2143,0,4", "1432,2,2", "1234,4,0", "5678,0,0"})
  //  @ParameterizedTest
  //  void testGuessGameGoal(String guess, int bulls, int cows) {
  //    Game game = new Game();
  //    game.setId("12345");
  //    game.setGoal(VALID_GOAL_STRING);
  //    when(gameRepository.findById("12345")).thenReturn(Optional.of(game));
  //
  //    var returnedGame = gameService.guessGameGoal("12345", guess);
  //    assertThat(returnedGame.getGuessList()).hasSize(1);
  //    var result = returnedGame.getGuessList().get(0);
  //    assertThat(result.getGuess()).isEqualTo(guess);
  //    assertThat(result.getBulls()).isEqualTo(bulls);
  //    assertThat(result.getCows()).isEqualTo(cows);
  //  }
}
