package com.proxiad.bullsandcows.guess;

import com.proxiad.bullsandcows.game.Game;

public interface GuessService {

  /**
   * Retrieves a list of Guesses
   *
   * @param guess
   * @return
   */
  Guess createGuess(Game game, String guess, Integer bulls, Integer cows);
}
