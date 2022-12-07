package com.proxiad.bullsandcows.guess;

import java.util.Map;

public class Guess {

	private String guess;
	private Map<String, Integer> guessResult;

	/**
	 * Constructor
	 */
	public Guess(String guess, Map<String, Integer> guessResult) {
		this.setGuess(guess);
		this.setGuessResult(guessResult);
	}

	/**
	 * Getter for guess
	 *
	 * @return
	 */
	public String getGuess() {
		return guess;
	}

	/**
	 * Setter for guess
	 *
	 * @return
	 */
	public void setGuess(String guess) {
		this.guess = guess;
	}

	/**
	 * Getter for guessResult
	 *
	 * @return
	 */
	public Map<String, Integer> getGuessResult() {
		return guessResult;
	}

	/**
	 * Setter for guessResult
	 *
	 * @return
	 */
	public void setGuessResult(Map<String, Integer> guessResult) {
		this.guessResult = guessResult;
	}
}
