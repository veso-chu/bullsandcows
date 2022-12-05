package com.proxiad.bullsandcows.game;

import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;

public class Game {

	private UUID id;
	
	@NotEmpty
	@GameGoalConstraint
	private String goal;
	
	public Game(String goal) {
		this.setId();
		this.goal = goal;
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId() {
		this.id = UUID.randomUUID();
	}
	
	public String getGoal() {
		return goal;
	}
	
	public void setGoal(String goal) {
		this.goal = goal;
	}
	
//	public List<String> getGuesses() {
//		return guesses;
//	}
//	
//	public void setGuesses(List<String> guesses) {
//		this.guesses = guesses;
//	}
}
