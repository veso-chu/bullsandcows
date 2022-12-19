package com.proxiad.bullsandcows.guess;

import com.proxiad.bullsandcows.game.Game;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GuessServiceImpl implements GuessService {

  @Autowired private GuessRepository guessRepository;

  @Override
  public Guess createGuess(Game game, String guess, Integer bulls, Integer cows) {
    Guess guessObj = new Guess();
    guessObj.setId(UUID.randomUUID().toString());
    guessObj.setGuess(guess);
    guessObj.setBulls(bulls);
    guessObj.setCows(cows);
    guessObj.setGame(game);
    guessRepository.save(guessObj);

    return guessObj;
  }

  public List<Guess> findGuessesByGameId(String gameId) {
    return guessRepository.findByGameId(gameId);
  }
}
