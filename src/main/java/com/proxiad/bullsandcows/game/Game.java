package com.proxiad.bullsandcows.game;

import com.proxiad.bullsandcows.guess.Guess;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "games")
@Getter
@Setter
@NoArgsConstructor
public class Game {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "game_id")
  private Long id;

  private String name;

  @NotEmpty @GameGoalConstraint private String goal;

  private Boolean solved;

  @OneToMany(mappedBy = "game")
  private Set<Guess> guesses;
}
