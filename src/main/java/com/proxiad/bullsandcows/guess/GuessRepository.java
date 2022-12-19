package com.proxiad.bullsandcows.guess;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuessRepository extends JpaRepository<Guess, String> {

  List<Guess> findByGameId(String gameId);

  @Transactional
  void deleteByGameId(String gameId);
}
