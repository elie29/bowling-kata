package com.arolla.kata.bowling.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class Frame
{
   @Getter
   private final int firstRoll;

   @Getter
   private final int secondRoll;

   @Setter
   private int bonus;

   public boolean isStrike()
   {
      return firstRoll == 10;
   }

   public boolean isSpare()
   {
      return !isStrike() && rollsScore() == 10;
   }

   public int totalScore()
   {
      return rollsScore() + bonus;
   }

   public int rollsScore()
   {
      return firstRoll + secondRoll;
   }
}
