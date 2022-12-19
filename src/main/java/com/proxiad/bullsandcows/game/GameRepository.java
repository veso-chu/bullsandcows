package com.proxiad.bullsandcows.game;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, String> {

  List<Game> findBySolved(boolean solved);
}
