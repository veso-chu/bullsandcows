package com.proxiad.bullsandcows.game;

import com.proxiad.bullsandcows.guess.GuessCreateForm;
import com.proxiad.bullsandcows.guess.GuessService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
public class GameController {

  private final GameService gameService;

  /**
   * Constructor
   *
   * @param gameService
   */
  @Autowired
  public GameController(GameService gameService, GuessService guessService) {
    this.gameService = gameService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Game createGame(@RequestBody GameCreateForm gameCreateForm) {
    return gameService.createGame(gameCreateForm.getGoal());
  }

  @GetMapping
  @ResponseStatus(HttpStatus.FOUND)
  public List<Game> getGames() {
    return gameService.getGames();
  }

  @GetMapping("/{name}")
  @ResponseStatus(HttpStatus.FOUND)
  public Game getGameByName(@PathVariable String name) {
    return gameService.getGameByName(name);
  }

  @PostMapping("/{name}")
  @ResponseStatus(HttpStatus.OK)
  public Game attemptGuessGame(
      @PathVariable String name, @RequestBody GuessCreateForm guessCreateForm) {
    String guess = guessCreateForm.getGuess();

    return gameService.guessGameGoal(name, guess);
  }
}
