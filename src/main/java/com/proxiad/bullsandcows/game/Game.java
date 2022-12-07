package com.proxiad.bullsandcows.game;

import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;

public class Game {

	private UUID id;
	@NotEmpty
	@GameGoalConstraint
	private String goal;
	private boolean solved;
	private GameInfo gameInfo;

	/**
	 * Constructor
	 *
	 * @param goal
	 */
	public Game(String goal) {
		this.setId();
		this.setGoal(goal);
		this.setGameInfo(new GameInfo());
		this.setSolved(false);
	}

	/**
	 * Getter for id
	 *
	 * @return
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * Setter for id
	 *
	 * @return
	 */
	public void setId() {
		this.id = UUID.randomUUID();
	}

	/**
	 * Getter for goal
	 *
	 * @return
	 */
	public String getGoal() {
		return goal;
	}

	/**
	 * Setter for goal
	 *
	 * @return
	 */
	public void setGoal(String goal) {
		this.goal = goal;
	}

	/**
	 * Getter for solved
	 *
	 * @return
	 */
	public boolean isSolved() {
		return solved;
	}

	/**
	 * Setter for solved
	 *
	 * @return
	 */
	public void setSolved(boolean solved) {
		this.solved = solved;
	}

	/**
	 * Getter for GameInfo
	 *
	 * @return
	 */
	public GameInfo getGameInfo() {
		return gameInfo;
	}

	/**
	 * Setter for GameInfo
	 *
	 * @param gameInfo
	 */
	public void setGameInfo(GameInfo gameInfo) {
		this.gameInfo = gameInfo;
	}
}
