package com.proxiad.bullsandcows.game;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class GameController {

	private final GameService gameService;

	@Autowired
	public GameController(GameService gameService) {
		this.gameService = gameService;
	}

	@GetMapping("game/{id}")
	public String getGameView(
			@PathVariable UUID id,
			@RequestParam(name = "guess", defaultValue = "") String guess,
			Map<String, Object> model)
	{
		Game game = gameService.getGame(id);
		model.put("game", game);

		if (!guess.equals("")) {
			model.put("guessResult", gameService.guessGameGoal(game, guess));
		}

		return "view";
	}

//	@GetMapping("game/*")
//	public String getGameView(HttpServletRequest request, Map<String, Object> model) {
//		List<String> pathSegments = ServletUriComponentsBuilder.fromRequest(request).build().getPathSegments();
//		UUID id = UUID.fromString(pathSegments.get(2));
//		Game game = gameService.getGame(id);
//		model.put("game", game);
//
//		return "view";
//	}

	@GetMapping("game/list")
	public String getGameListPage(Map<String, Object> model) {
		model.put("games", gameService.getGames());

		return "list";
	}

	@GetMapping("game")
	public String getGameCreatePage(@ModelAttribute ("game") Game game) {
		return "create";
	}

	@PostMapping("game")
	public String createGame(
			@Valid @ModelAttribute ("game") Game game,
			BindingResult result)
	{
		if (result.hasErrors()) {
			System.out.println("There were errors creating the game with goal " + game.getGoal());
			return "create";
		}
		gameService.createGame(game);

		return "redirect:game/" + game.getId();
	}
}
