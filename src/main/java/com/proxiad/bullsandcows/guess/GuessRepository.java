package com.proxiad.bullsandcows.guess;

import com.proxiad.bullsandcows.game.Game;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuessRepository extends JpaRepository<Guess, Long> {

  /**
   * Retrieves a list of {@link Guess} objects, related to a {@link Game} with gameId, contained in
   * this repository.
   *
   * @param gameId
   * @return
   */
  List<Guess> findByGameId(Long gameId);

  /**
   * Deletes all {@link Guess} objects, related to a {@link Game} with gameId, contained in this
   * repository.
   *
   * @param gameId
   */
  @Transactional
  void deleteByGameId(Long gameId);
}
