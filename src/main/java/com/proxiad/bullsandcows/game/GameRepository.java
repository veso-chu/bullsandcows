package com.proxiad.bullsandcows.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public class GameRepository {
	
	private Map<UUID, Game> repository;
	
	public GameRepository() {
		this.repository = new HashMap<>();
	}
	
	public void add(Game game) {
		repository.put(game.getId(), game);
		System.out.println("Game added: " + game);
	}
	
	public Game findById(UUID id) {
		return repository.get(id);
	}
	
	public List<Game> findAll() {
		List<Game> result = new ArrayList<>();
		
		for (Game game: repository.values()) {
			result.add(game);
		}

		return result;
	}
}
