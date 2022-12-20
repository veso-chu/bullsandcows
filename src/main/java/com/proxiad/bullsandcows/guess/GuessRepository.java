package com.proxiad.bullsandcows.guess;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuessRepository extends JpaRepository<Guess, String> {

  /**
   * Retrieves a list of Guess objects, related to a Game with gameId, contained in this repository.
   *
   * @param gameId
   * @return
   */
  List<Guess> findByGameId(String gameId);

  /**
   * Deletes all Guess objects, related to a Game with gameId, contained in this repository.
   *
   * @param gameId
   */
  @Transactional
  void deleteByGameId(String gameId);
}
