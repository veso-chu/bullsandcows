package com.proxiad.bullsandcows.game;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, String> {

  /**
   * Retrieves a list of Game objects, based on the their solved property.
   *
   * @param solved
   * @return
   */
  List<Game> findBySolved(boolean solved);
}
