package com.proxiad.bullsandcows.game;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

  /**
   * Retrieves a list of {@link Game} objects, based on the their solved property.
   *
   * @param solved
   * @return
   */
  List<Game> findBySolved(boolean solved);

  /**
   * Retrieves a {@link Game} from the repository with the given name
   *
   * @param name The UUID string name of the looked for {@link Game} object
   * @return The {@link Game} object if found. Else returns null
   */
  Game findByName(String name);
}
