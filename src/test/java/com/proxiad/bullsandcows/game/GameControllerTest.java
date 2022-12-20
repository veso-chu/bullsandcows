package com.proxiad.bullsandcows.game;

import com.proxiad.bullsandcows.guess.GuessService;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@WebMvcTest(GameController.class)
class GameControllerTest {

  @MockBean private GameService gameService;
  @MockBean private GuessService guessService;

  //  @Autowired private WebApplicationContext webApplicationContext;

  //  @Autowired private MockMvc mockMvc;

  //  @Test
  //  void shouldCreateMockMvc() {
  //    assertNotNull(mockMvc);
  //  }
  //
  //  @Test
  //  void testGameListShouldReturnListOfGames() {
  //    Game game = new Game();
  //    game.setId("12345");
  //    game.setGoal("1234");
  //    game.setGuessList(new ArrayList<>());
  //    when(gameService.getGames()).thenReturn(List.of(game));
  //
  //    this.mockMvc.perform(MockMvcRequestBuilders.get("game/list"));
  //  }
}
