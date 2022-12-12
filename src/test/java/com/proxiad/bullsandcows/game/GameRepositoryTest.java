package com.proxiad.bullsandcows.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameRepositoryTest {

  GameRepository gameRepository;
  Game game;

  @BeforeEach
  void setUp() {
    gameRepository = new GameRepositoryImpl();
    game = mock(Game.class);
  }

  @Test
  void testFindAllReturnsListWithSizeOneAfterUsingAdd() {
    gameRepository.add(game);
    assertEquals(1, gameRepository.findAll().size());
  }

  @Test
  void testFindByIdReturnsTheCorrectGameAfterUsingAdd() {
    gameRepository.add(game);
    assertEquals(game, gameRepository.findById(game.getId()));
  }
}
