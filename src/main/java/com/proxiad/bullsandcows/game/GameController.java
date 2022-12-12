package com.proxiad.bullsandcows.game;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GameController {

  private final GameService gameService;

  @Autowired
  public GameController(GameService gameService) {
    this.gameService = gameService;
  }

  @GetMapping("game/{id}")
  public String getGameView(@PathVariable String id, Map<String, Object> model) {
    Game game = gameService.getGame(id);
    // 404 page Not found

    model.put("game", game);
    return "view";
  }

  @PostMapping("game/{id}/guess")
  public String makeGuess(
      @PathVariable String id,
      @GameGoalConstraint String guess,
      Map<String, Object> model,
      Errors errors) {
    // errors.hasErrors()

    Game game = gameService.getGame(id);
    // 404 page Not found

    model.put("game", game);
    gameService.guessGameGoal(id, guess);
    return "view";
  }

  @GetMapping("game/list")
  public String getGameListPage(Map<String, Object> model) {
    model.put("games", gameService.getGames());

    return "list";
  }

  @GetMapping("game")
  public String getGameCreatePage(@ModelAttribute("game") Game game) {
    return "create";
  }

  @PostMapping("game")
  public String createGame(String goal) {
    var game = gameService.createGame(goal);
    return "redirect:game/" + game.getId();
  }
}
