package com.arolla.kata.bowling;

import com.arolla.kata.bowling.service.Bowling;

import java.util.List;

public class BowlingApplication
{

   public int computeScore(List<Integer> rolls)
   {
      Bowling bowling = new Bowling(rolls);
      return bowling.totalScore();
   }
}

