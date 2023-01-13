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
   * Retrieves a {@link Game} from the repository with the given id
   *
   * @param id The id of the looked for {@link Game} object
   * @return The {@link Game} object if found. Else returns null
   */
  Game getGame(Long id);

  /**
   * Retrieves a {@link Game} from the repository with the given name
   *
   * @param name The UUID name of the looked for {@link Game} object
   * @return The {@link Game} object if found. Else returns null
   */
  Game getGameByName(String name);

  /**
   * Inserts a {@link Game} into the repository
   *
   * @param goal The goal property of the newly created {@link Game}
   * @return The newly created {@link Game} object
   */
  Game createGame(String goal);

  /**
   * Attempt to guess the goal of a {@link Game} with id. If the guess matches the {@link Game}
   * goal, the {@link Game} solved property is set to true.
   *
   * @param id The id of the {@link Game} object that the guess attempt will be made on
   * @param guess The string symbolizing with the guess attempt
   * @return The {@link Game} object if found. Else returns null
   */
  Game guessGameGoal(Game game, String guess);
}
