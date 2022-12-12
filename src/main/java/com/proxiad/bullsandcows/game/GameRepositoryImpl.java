package com.proxiad.bullsandcows.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @Repository
public class GameRepositoryImpl implements GameRepository {

  private Map<String, Game> repository;

  /** Constructor */
  public GameRepositoryImpl() {
    this.repository =
        new HashMap<>(); // Hashmap is not thread safe. Use sth from concurrent package
    // ConcurrentHashMap
  }

  /**
   * Puts a Game object into the repository List
   *
   * @param game
   */
  @Override
  public void add(Game game) {
    repository.put(game.getId(), game);
  }

  /**
   * Finds and returns a Game with the passed UUID
   *
   * @param id
   * @return
   */
  @Override
  public Game findById(String id) {
    return repository.get(id);
  }

  /**
   * Retrieves all Game object inside the repository List
   *
   * @return
   */
  @Override
  public List<Game> findAll() {
    List<Game> result = new ArrayList<>();

    for (Game game : repository.values()) {
      result.add(game);
    }

    return result;
  }
}
