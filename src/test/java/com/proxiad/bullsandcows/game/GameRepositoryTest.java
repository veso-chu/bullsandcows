package com.proxiad.bullsandcows.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

class GameRepositoryTest {

	GameRepo gameRepository = new InMemoryGameRepo();
	Game game = mock(Game.class);

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
