package com.arolla.kata.bowling;

import com.arolla.kata.bowling.service.Bowling;

public class BowlingApplication
{

   public int computeScore(int[] rolls)
   {
      Bowling bowling = new Bowling(rolls);
      return bowling.totalScore();
   }
}

