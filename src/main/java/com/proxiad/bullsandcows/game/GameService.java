package com.proxiad.bullsandcows.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
	
	private GameRepository repository;
	
	/**
	 * Constructor
	 * 
	 * @param gameRepository
	 */
	@Autowired
	public GameService(GameRepository gameRepository) {
		repository = gameRepository;
	}
	
	public List<Game> getGames() {
		return repository.findAll();
	}
	
	public Game getGame(UUID id) {
		return repository.findById(id);
	}
	
	public void createGame(Game game) {
		repository.add(game);
	}
	
	public Map<String, Integer> guessGameGoal(Game game, String goal) {
		Integer bulls = 0;
		Integer cows = 0;
		Map<String, Integer> result = new HashMap<>();
		
		if (goal.length() != 4) {
			result.put("bulls", bulls);
			result.put("cows", cows);
			
			return result;
		} else {
			for ()
		}
	}
}
