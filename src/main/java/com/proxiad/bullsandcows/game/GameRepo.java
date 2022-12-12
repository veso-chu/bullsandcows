package com.proxiad.bullsandcows.game;

import java.util.List;

public interface GameRepo {

  /**
   * Puts a Game object into the repository List
   *
   * @param game
   */
  void add(Game game);

  /**
   * Finds and returns a Game with the passed UUID
   *
   * @param id
   * @return
   */
  Game findById(String id);

  /**
   * Retrieves all Game object inside the repository List
   *
   * @return
   */
  List<Game> findAll();
}
