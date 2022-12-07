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

	/**
	 * Retrieves all Game objects from the repository
	 *
	 * @return
	 */
	public List<Game> getGames() {
		return repository.findAll();
	}

	/**
	 * Retrieves a Game from the repository with the given UUID
	 *
	 * @param game
	 */
	public Game getGame(UUID id) {
		return repository.findById(id);
	}

	/**
	 * Inserts a Game into the repository
	 *
	 * @param game
	 */
	public void createGame(Game game) {
		repository.add(game);
	}

	/**
	 * Attempt to guess the passed Game goal.
	 * Returns a Map with 0 values if the passed guess String is incorrect.
	 * TODO: Create a Guess object, validate it before passing and return an error message.
	 *
	 * @param game
	 * @param goal
	 * @return
	 */
	public Map<String, Integer> guessGameGoal(Game game, String goal) {
		Integer bulls = 0;
		Integer cows = 0;

		if (GameGoalValidator.validateGameGoalString(goal)) {
			for (int i = 0; i < goal.length(); i++) {
				if (game.getGoal().charAt(i) == goal.charAt(i)) {
					bulls++;
				} else if (game.getGoal().contains(goal.substring(i, i+1))) {
					cows++;
				}
			}
		}
		Map<String, Integer> result = new HashMap<>();
		result.put("bulls", bulls);
		result.put("cows", cows);

		return result;
	}
}
