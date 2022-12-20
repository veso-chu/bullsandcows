package com.proxiad.bullsandcows.game;

import com.proxiad.bullsandcows.guess.GuessServiceImpl;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GameServiceImpl implements GameService {

  @Autowired private GameRepository repository;

  @Autowired private GuessServiceImpl guessService;

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
    try {
      return repository.findById(id).orElseThrow(() -> new Exception("Game not found"));
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
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
    repository.save(game);
    return game;
  }

  /**
   * Attempt to guess the passed Game goal. If the guess matches the Game goal, the Game solved
   * property is set to true.
   *
   * @param game
   * @param goal
   * @return
   */
  @Override
  public Game guessGameGoal(String id, String guess) {
    Game game = this.getGame(id);
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
      repository.save(game);
    }

    guessService.createGuess(game, guess, bulls, cows);

    return game;
  }
}
