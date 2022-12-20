package com.proxiad.bullsandcows.guess;

import com.proxiad.bullsandcows.game.Game;
import java.util.List;

public interface GuessService {

  /**
   * Creates a Guess object and adds it to the associated GuessRepository
   *
   * @param game The Game object this Guess is related to
   * @param guess The string symbolizing the guess attempt
   * @param bulls The amount of bulls scored with this guess
   * @param cows The amount of cows scored with this guess
   * @return The created Guess object
   */
  Guess createGuess(Game game, String guess, Integer bulls, Integer cows);

  /**
   * Retrieves all Guess objects related to a Game with gameId
   *
   * @param gameId
   * @return
   */
  List<Guess> findGuessesByGameId(String gameId);
}
