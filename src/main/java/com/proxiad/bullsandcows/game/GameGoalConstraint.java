package com.proxiad.bullsandcows.game;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = GameGoalValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface GameGoalConstraint {
  String message() default "The goal must consist of 4 different digits";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
