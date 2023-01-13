package com.proxiad.bullsandcows.guess;

import com.proxiad.bullsandcows.game.Game;
import java.util.List;

public interface GuessService {

  /**
   * Creates a {@link Guess} and adds it to the associated {@link GuessRepository}
   *
   * @param game The {@link Game} this {@link Guess} is related to
   * @param guess The string symbolizing the guess attempt
   * @param bulls The amount of bulls scored with this guess
   * @param cows The amount of cows scored with this guess
   * @return The created {@link Guess}
   */
  Guess createGuess(Game game, String guess, Integer bulls, Integer cows);

  /**
   * Retrieves all {@link Guess} objects related to a {@link Game} with gameId
   *
   * @param gameId
   * @return
   */
  List<Guess> findGuessesByGameId(Long gameId);
}
