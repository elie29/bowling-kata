package com.arolla.kata.bowling.service;

import com.arolla.kata.bowling.entity.Frame;

import java.util.stream.Stream;

public class Bowling
{
   private static final int FRAME_NINE_INDEX = 8;
   private static final int FRAME_TEN_INDEX = 9;
   private static final int EXTRA_ROLL_INDEX = 20;
   private static final int MAX_FRAMES = 10;

   private Frame[] frames;
   private int currentStep;

   private final int[] rolls;

   public Bowling(int[] rolls)
   {
      this.rolls = rolls;
   }

   public int totalScore()
   {
      createFramesFromRolls();
      computeScoreWhenStrike();

      // sum all frames total score
      return Stream.of(frames).mapToInt(frame -> frame.totalScore()).reduce(0, Integer::sum);
   }

   private void createFramesFromRolls()
   {
      frames = new Frame[MAX_FRAMES];
      currentStep = 0;

      // A frame is equivalent to two rolls
      for (int roll = 0; roll < 2 * MAX_FRAMES; roll += 2) {
         addFrame(roll);
         computeBonusWhenSpare(roll);
         currentStep += 1;
      }
   }

   private void addFrame(int currentRoll)
   {
      int firstRoll = rolls[currentRoll];
      int secondRoll = rolls[currentRoll + 1];
      frames[currentStep] = new Frame(firstRoll, secondRoll);
   }

   private void computeBonusWhenSpare(int currentRoll)
   {
      if (frames[currentStep].isSpare()) {
         // set bonus from the first roll of next frame or extra roll
         int next = rolls[currentRoll + 2];
         frames[currentStep].setBonus(next);
      }
   }

   // on each frame, add bonus when strike occurred
   private void computeScoreWhenStrike()
   {
      int max = frames.length;
      for (int index = 0; index < max; index += 1) {
         computeBonusOnStrike(index);
      }
   }

   private void computeBonusOnStrike(int currentIndex)
   {
      // current frame is not a strike?
      if (!frames[currentIndex].isStrike()) {
         return;
      }

      int bonus;

      // first eight frames
      if (currentIndex < FRAME_NINE_INDEX) {
         bonus = computeBonusOnStrikeForFirstEightFrames(currentIndex);
      }

      // for frame number 9, bonus is equivalent to the score of frame number 10
      else if (currentIndex == FRAME_NINE_INDEX) {
         bonus = frames[FRAME_TEN_INDEX].rollsScore();
      }

      // for frame number 10, bonus is equivalent to the extra roll (index 20)
      else {
         bonus = rolls[EXTRA_ROLL_INDEX];
      }

      frames[currentIndex].setBonus(bonus);
   }

   private int computeBonusOnStrikeForFirstEightFrames(int currentIndex)
   {
      // the next two frames are strikes ??
      if (frames[currentIndex + 1].isStrike() && frames[currentIndex + 2].isStrike()) {
         return 20;
      }

      // only next frame is a strike ?
      if (frames[currentIndex + 1].isStrike()) {
         return 10 + frames[currentIndex + 2].getFirstRoll();
      }

      // only current frame is a strike, get next frame score as bonus
      return frames[currentIndex + 1].rollsScore();
   }
}
