package com.proxiad.bullsandcows.game;

import java.util.List;

public interface GameService {

  /**
   * Retrieves all Game objects from the repository
   *
   * @return
   */
  List<Game> getGames();

  /**
   * Retrieves a Game from the repository with the given UUID
   *
   * @param game
   */
  Game getGame(String id);

  /**
   * Inserts a Game into the repository
   *
   * @param game
   * @return
   */
  Game createGame(String goal);

  /**
   * Attempt to guess the passed Game goal. Returns a Map with 0 values if the passed guess String
   * is incorrect.
   *
   * @param game
   * @param goal
   * @return
   */
  Game guessGameGoal(String id, String guess);
}
