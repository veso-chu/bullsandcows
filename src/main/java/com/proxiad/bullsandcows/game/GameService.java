package com.proxiad.bullsandcows.game;

import java.util.List;

public interface GameService {

  /**
   * Retrieves all {@link Game} objects from the related repository
   *
   * @return List of {@link Game} objects contained in the related repository
   */
  List<Game> getGames();

  /**
   * Retrieves a {@link Game} from the repository with the given string id
   *
   * @param id The id of the looked for Game object
   * @return The Game object if found. Else returns null
   */
  Game getGame(String id);

  /**
   * Inserts a {@link Game} into the repository
   *
   * @param goal The goal property of the newly created Game
   * @return The newly created Game object
   */
  Game createGame(String goal);

  /**
   * Attempt to guess the goal of a {@link Game} with id. If the guess matches the {@link Game}
   * goal, the {@link Game} solved property is set to true.
   *
   * @param id The id of the Game object that the guess attempt will be made on
   * @param guess The string symbolizing with the guess attempt
   * @return The Game object if found. Else returns null
   */
  Game guessGameGoal(String id, String guess);
}
