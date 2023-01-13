package com.proxiad.bullsandcows.guess;

import com.proxiad.bullsandcows.game.Game;
import com.proxiad.bullsandcows.game.GameGoalConstraint;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "guesses")
@Getter
@Setter
@NoArgsConstructor
public class Guess {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "guess_id")
  private Long id;

  @NotEmpty @GameGoalConstraint private String guess;

  private Integer bulls;

  private Integer cows;

  @ManyToOne
  @JoinColumn(name = "game_id", nullable = false)
  private Game game;
}
