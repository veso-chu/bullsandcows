package com.proxiad.bullsandcows.game;

import com.proxiad.bullsandcows.guess.GuessService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GameServiceImpl implements GameService {

  private GameRepository repository;
  private GuessService guessService;

  @Autowired
  public GameServiceImpl(GameRepository repository, GuessService guessService) {
    this.repository = repository;
    this.guessService = guessService;
  }

  @Override
  public List<Game> getGames() {
    return repository.findAll();
  }

  @Override
  public Game getGame(String id) {
    return repository.findById(id).orElse(null);
  }

  @Override
  public Game createGame(String goal) {
    Game game = new Game();
    game.setId(UUID.randomUUID().toString());
    game.setGoal(goal);
    game.setSolved(false);
    repository.save(game);
    return game;
  }

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
    this.attemptToSolveGame(game, bulls);
    guessService.createGuess(game, guess, bulls, cows);

    return game;
  }

  /**
   * Attempts to solve a Game. Sets the Game solved property to true if the bulls count is 4.
   *
   * @param game
   * @param bulls
   */
  private void attemptToSolveGame(Game game, Integer bulls) {
    if (bulls.equals(4)) {
      game.setSolved(true);
      repository.save(game);
    }
  }
}
