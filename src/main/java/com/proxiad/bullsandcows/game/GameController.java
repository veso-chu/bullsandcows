package com.proxiad.bullsandcows.game;

import com.proxiad.bullsandcows.guess.GuessCreateForm;
import com.proxiad.bullsandcows.guess.GuessService;
import jakarta.validation.Valid;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class GameController {

  private final GameService gameService;

  private final GuessService guessService;

  /**
   * Constructor
   *
   * @param gameService
   * @param guessService
   */
  @Autowired
  public GameController(GameService gameService, GuessService guessService) {
    this.gameService = gameService;
    this.guessService = guessService;
  }

  @GetMapping("404")
  public String getNotFoundPage() {
    return "404";
  }

  @GetMapping("/")
  public String getHomepage() {
    return "home";
  }

  @GetMapping("game/{id}")
  public String getGameView(
      @PathVariable String id,
      @ModelAttribute("guessCreateForm") GuessCreateForm guessCreateForm,
      Map<String, Object> model) {
    Game game = gameService.getGame(id);
    if (game == null) {
      return "redirect:/404";
    }

    model.put("game", game);
    model.put("guesses", guessService.findGuessesByGameId(id));

    return "game/view";
  }

  @PostMapping("game/{id}/guess")
  public String makeGuess(
      @PathVariable String id,
      @Valid @ModelAttribute("guessCreateForm") GuessCreateForm guessCreateForm,
      BindingResult bindingResult,
      Map<String, Object> model) {
    Game game = gameService.getGame(id);
    if (game == null) {
      return "redirect:/404";
    }
    model.put("game", game);

    if (!bindingResult.hasErrors()) {
      gameService.guessGameGoal(id, guessCreateForm.getGuess());
    }
    model.put("guesses", guessService.findGuessesByGameId(id));

    return "game/view";
  }

  @GetMapping("game/list")
  public String getGameListPage(Map<String, Object> model) {
    model.put("games", gameService.getGames());

    return "game/list";
  }

  @GetMapping("game")
  public String getGameCreatePage(@ModelAttribute("gameCreateForm") GameCreateForm gameCreateForm) {
    return "game/create";
  }

  @PostMapping("game")
  public String createGame(
      @Valid @ModelAttribute("gameCreateForm") GameCreateForm gameCreateForm,
      BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "game/create";
    }
    var game = gameService.createGame(gameCreateForm.getGoal());

    return "redirect:game/" + game.getId();
  }
}
