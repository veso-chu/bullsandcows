package com.proxiad.bullsandcows.game;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "games")
public class Game {

  @Id private String id;

  @NotEmpty
  @GameGoalConstraint
  @Column(name = "goal")
  private String goal;

  @Column(name = "solved")
  private boolean solved;

  //  @OneToMany(targetEntity = Guess.class, cascade = CascadeType.ALL, mappedBy = "game")
  //  private List<Guess> guessList;

  public Game() {}

  //  public Game(String goal) {
  //    this.setId(UUID.randomUUID().toString());
  //    this.setGoal(goal);
  //    this.setGuessList(new ArrayList<>());
  //  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getGoal() {
    return goal;
  }

  public void setGoal(String goal) {
    this.goal = goal;
  }

  public boolean isSolved() {
    return solved;
  }

  public void setSolved(boolean solved) {
    this.solved = solved;
  }

  //  public List<Guess> getGuessList() {
  //    return guessList;
  //  }
  //
  //  public void setGuessList(List<Guess> gameInfo) {
  //    this.guessList = gameInfo;
  //  }
}
