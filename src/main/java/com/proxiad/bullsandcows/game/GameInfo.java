package com.proxiad.bullsandcows.game;

import java.util.ArrayList;
import java.util.List;

import com.proxiad.bullsandcows.guess.Guess;

public class GameInfo {

	private List<Guess> guesses;

	/**
	 * Constructor
	 */
	public GameInfo() {
		this.setGuesses(new ArrayList<>());
	}

	/**
	 * Getter for guesses
	 *
	 * @return
	 */
	public List<Guess> getGuesses() {
		return guesses;
	}

	/**
	 * Setter for guesses
	 *
	 * @param guesses
	 */
	public void setGuesses(List<Guess> guesses) {
		this.guesses = guesses;
	}

	/**
	 * Adds a guess string to the guesses List
	 *
	 * @param guess
	 */
	public void addGuess(Guess guess) {
		this.guesses.add(guess);
	}
}
