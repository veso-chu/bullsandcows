package com.proxiad.bullsandcows.guess;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proxiad.bullsandcows.game.Game;
import com.proxiad.bullsandcows.game.GameGoalConstraint;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "guesses")
public class Guess {

  @Id private String id;

  @NotEmpty
  @GameGoalConstraint
  @Column(name = "guess")
  private String guess;

  @Column(name = "bulls")
  private Integer bulls;

  @Column(name = "cows")
  private Integer cows;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "game_id", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
  private Game game;

  public Guess() {}

  //  public Guess(String guess, Integer bulls, Integer cows) {
  //    this.setGuess(guess);
  //    this.setBulls(bulls);
  //    this.setCows(cows);
  //  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getGuess() {
    return guess;
  }

  public void setGuess(String guess) {
    this.guess = guess;
  }

  public Integer getBulls() {
    return bulls;
  }

  public void setBulls(Integer bulls) {
    this.bulls = bulls;
  }

  public Integer getCows() {
    return cows;
  }

  public void setCows(Integer cows) {
    this.cows = cows;
  }

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }
}
