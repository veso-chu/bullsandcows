package com.proxiad.bullsandcows.game;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "games")
@Getter
@Setter
@NoArgsConstructor
public class Game {

  @Id private String id;

  @NotEmpty
  @GameGoalConstraint
  @Column(name = "goal")
  private String goal;

  @Column(name = "solved")
  private boolean solved;
}
