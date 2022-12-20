package com.proxiad.bullsandcows.guess;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proxiad.bullsandcows.game.Game;
import com.proxiad.bullsandcows.game.GameGoalConstraint;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "guesses")
@Getter
@Setter
@NoArgsConstructor
public class Guess {

  @Id private String id;

  @NotEmpty
  @GameGoalConstraint
  @Column(name = "guess")
  private String guess;

  @Column(name = "bulls")
  private Integer bulls;

  @Column(name = "cows")
  private Integer cows;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "game_id", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
  private Game game;
}
