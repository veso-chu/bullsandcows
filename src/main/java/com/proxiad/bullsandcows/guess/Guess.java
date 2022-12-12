package com.proxiad.bullsandcows.guess;

public class Guess {

  private String guess;
  private Integer bulls;
  private Integer cows;

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
}
