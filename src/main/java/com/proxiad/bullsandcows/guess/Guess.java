package com.proxiad.bullsandcows.guess;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proxiad.bullsandcows.game.Game;
import com.proxiad.bullsandcows.game.GameGoalConstraint;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Guess {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "guess_id")
  private Long id;

  @NotEmpty @GameGoalConstraint private String guess;

  @NotNull private Integer bulls;

  @NotNull private Integer cows;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "game_id", nullable = false)
  private Game game;
}
