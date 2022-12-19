package com.proxiad.bullsandcows.game;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GameController.class)
class GameControllerTest {

  @MockBean private GameService gameService;

  //  @Autowired private WebApplicationContext webApplicationContext;

  @Autowired private MockMvc mockMvc;

  @Test
  void shouldCreateMockMvc() {
    assertNotNull(mockMvc);
  }

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
