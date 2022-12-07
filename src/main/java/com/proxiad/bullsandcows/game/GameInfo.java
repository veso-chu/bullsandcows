package com.proxiad.bullsandcows.game;

import java.util.HashMap;
import java.util.Map;

public class GameInfo {

	private Map<String, Map<String, Integer>> guesses;

	/**
	 * Constructor
	 */
	public GameInfo() {
		this.setGuesses(new HashMap<>());
	}

	/**
	 * Getter for guesses
	 *
	 * @return
	 */
	public Map<String, Map<String, Integer>> getGuesses() {
		return guesses;
	}

	/**
	 * Setter for guesses
	 *
	 * @param guesses
	 */
	public void setGuesses(Map<String, Map<String, Integer>> guesses) {
		this.guesses = guesses;
	}

	/**
	 * Adds a guess string to the guesses List
	 *
	 * @param guess
	 */
	public void addGuess(String guess, Map<String, Integer> guessResult) {
		this.guesses.put(guess, guessResult);
	}
}
