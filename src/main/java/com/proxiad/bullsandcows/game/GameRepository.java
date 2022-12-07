package com.proxiad.bullsandcows.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

//@Repository
public class GameRepository {

	private Map<UUID, Game> repository;

	/**
	 * Constructor
	 */
	public GameRepository() {
		this.repository = new HashMap<>();
	}

	/**
	 * Puts a Game object into the repository List
	 *
	 * @param game
	 */
	public void add(Game game) {
		repository.put(game.getId(), game);
	}

	/**
	 * Finds and returns a Game with the passed UUID
	 *
	 * @param id
	 * @return
	 */
	public Game findById(UUID id) {
		return repository.get(id);
	}

	/**
	 * Retrieves all Game object inside the repository List
	 *
	 * @return
	 */
	public List<Game> findAll() {
		List<Game> result = new ArrayList<>();

		for (Game game: repository.values()) {
			result.add(game);
		}

		return result;
	}
}
