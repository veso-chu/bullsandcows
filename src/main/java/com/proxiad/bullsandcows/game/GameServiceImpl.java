package com.proxiad.bullsandcows.game;

import com.proxiad.bullsandcows.guess.Guess;
import java.util.List;
import java.util.UUID;

// @Service
public class GameServiceImpl implements GameService {

  private GameRepo repository;

  /**
   * Constructor
   *
   * @param gameRepository
   */
  public GameServiceImpl(GameRepo gameRepository) {
    repository = gameRepository;
  }

  /**
   * Retrieves all Game objects from the repository
   *
   * @return
   */
  @Override
  public List<Game> getGames() {
    return repository.findAll();
  }

  /**
   * Retrieves a Game from the repository with the given UUID
   *
   * @param game
   */
  @Override
  public Game getGame(String id) {
    return repository.findById(id);
  }

  /**
   * Inserts a Game into the repository
   *
   * @param game
   */
  @Override
  public Game createGame(String goal) {
    Game game = new Game();
    game.setId(UUID.randomUUID().toString());
    game.setGoal(goal);
    repository.add(game);
    return game;
  }

  /**
   * Attempt to guess the passed Game goal. Returns a Map with 0 values if the passed guess String
   * is incorrect.
   *
   * @param game
   * @param goal
   * @return
   */
  @Override
  public Game guessGameGoal(String id, String guess) {
    Game game = repository.findById(id);
    Integer bulls = 0;
    Integer cows = 0;

    if (GameGoalValidator.validateGameGoalString(guess)) {
      for (int i = 0; i < guess.length(); i++) {
        if (game.getGoal().charAt(i) == guess.charAt(i)) {
          bulls++;
        } else if (game.getGoal().contains(guess.substring(i, i + 1))) {
          cows++;
        }
      }
    }

    if (bulls.equals(4)) {
      game.setSolved(true);
    }
    Guess guessEntry = new Guess();
    guessEntry.setGuess(guess);
    guessEntry.setCows(bulls);
    guessEntry.setCows(cows);
    game.getGuessList().add(guessEntry);

    return game;
  }
}
