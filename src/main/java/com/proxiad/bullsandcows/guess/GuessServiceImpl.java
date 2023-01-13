package com.proxiad.bullsandcows.guess;

import com.proxiad.bullsandcows.game.Game;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GuessServiceImpl implements GuessService {

  private GuessRepository guessRepository;

  @Autowired
  public GuessServiceImpl(GuessRepository guessRepository) {
    this.guessRepository = guessRepository;
  }

  @Override
  public Guess createGuess(Game game, String guess, Integer bulls, Integer cows) {
    Guess guessObj = new Guess();
    guessObj.setGame(game);
    guessObj.setGuess(guess);
    guessObj.setBulls(bulls);
    guessObj.setCows(cows);
    guessRepository.save(guessObj);

    return guessObj;
  }

  @Override
  public List<Guess> findGuessesByGameId(Long gameId) {
    return guessRepository.findByGameId(gameId);
  }
}
