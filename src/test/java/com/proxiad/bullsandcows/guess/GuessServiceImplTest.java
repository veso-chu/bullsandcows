package com.proxiad.bullsandcows.guess;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import com.proxiad.bullsandcows.game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GuessServiceImplTest {

  GuessRepository guessRepository;
  GuessService guessService;

  @BeforeEach
  void setUp() {
    guessRepository = mock(GuessRepository.class);
    guessService = new GuessServiceImpl(guessRepository);
  }

  @Test
  void testCreateGuessReturnsGameWithCorrectProperties() {
    Guess guess = guessService.createGuess(mock(Game.class), "1234", 2, 2);

    assertThat(guess.getGuess()).isEqualTo("1234");
    assertThat(guess.getBulls()).isEqualTo(2);
    assertThat(guess.getCows()).isEqualTo(2);
  }

  //  @Test
  //  void testFindGuessesByGameIdReturnsListOfGuessesWhenRelationWithGameExists() {
  //    Game game = new Game();
  //    game.setId("12345");
  //    game.setGoal("1234");
  //    game.setSolved(false);
  //
  //    guessService.createGuess(game, "4321", 0, 4);
  //    List<Guess> guessList = guessService.findGuessesByGameId(game.getId());
  //
  //    assertThat(guessList).isNotEmpty();
  //  }
}
