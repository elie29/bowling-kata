package com.arolla.kata.bowling;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * RollsByFrame > 10 not allowed
 * RollsByFrame < 0 not allowed
 * If last frame is strike or spare, an extra roll is required
 */
public class KataTest
{
   private final BowlingApplication bowlingApplication = new BowlingApplication();

   @Test
   public void shouldReturnTotalScoreWith10PairsOf9AndMiss()
   {
      int[] rollsByFrame = {9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0};
      assertThat(rollsByFrame.length, is(20));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);
      assertThat(totalScore, is(equalTo(90)));
   }

   @Test
   public void shouldReturn80When8pinsDownThroughAllFrames()
   {
      int[] rollsByFrame = {8, 0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0};
      assertThat(rollsByFrame.length, is(20));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);
      assertThat(totalScore, is(equalTo(80)));
   }

   @Test
   public void shouldReturnTotalScoreWhenSomePinsDownThroughAllFrames()
   {
      int[] rollsByFrame = {8, 1, 7, 2, 6, 3, 5, 4, 4, 5, 8, 1, 7, 2, 6, 3, 5, 4, 6, 3};
      assertThat(rollsByFrame.length, is(20));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);
      assertThat(totalScore, is(equalTo(90)));
   }

   @Test
   public void shouldReturnTotalScoreWithOneSpare()
   {
      int[] rollsByFrame = {8, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
      assertThat(rollsByFrame.length, is(20));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);
      assertThat(totalScore, is(equalTo(18)));
   }

   @Test
   public void shouldReturnTotalScoreWithFakeSpare()
   {
      int[] rollsByFrame = {7, 1, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
      assertThat(rollsByFrame.length, is(20));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);
      assertThat(totalScore, is(equalTo(17)));
   }

   @Test
   public void shouldReturnTotalScoreWithAnotherSpare()
   {
      int[] rollsByFrame = {8, 2, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
      assertThat(rollsByFrame.length, is(20));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);
      assertThat(totalScore, is(equalTo(24)));
   }

   @Test
   public void shouldReturnTotalScoreWithTwoSpare()
   {
      int[] rollsByFrame = {8, 2, 7, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
      assertThat(rollsByFrame.length, is(20));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);
      assertThat(totalScore, is(equalTo(37)));
   }

   @Test
   public void shouldReturnTotalScoreWithThreeSpare()
   {
      int[] rollsByFrame = {8, 2, 7, 3, 5, 5, 8, 0, 0, 0, 0, 1, 0, 6, 0, 0, 0, 0, 0, 0};
      assertThat(rollsByFrame.length, is(20));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);
      assertThat(totalScore, is(equalTo(65)));
   }

   @Test
   public void shouldReturnTotalScoreWithSpareAtTheEnd()
   {
      int[] rollsByFrame = {8, 2, 7, 3, 5, 5, 8, 0, 0, 0, 0, 1, 0, 6, 0, 0, 0, 0, 9, 1, 7};
      assertThat(rollsByFrame.length, is(21));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);
      assertThat(totalScore, is(equalTo(82)));
   }

   @Test
   public void shouldReturnTotalScoreWithOneStrike()
   {
      int[] rollsByFrame = {10, 0, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
      assertThat(rollsByFrame.length, is(20));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);
      assertThat(totalScore, is(equalTo(24)));
   }

   @Test
   public void shouldReturnTotalScoreWithTwoStrike()
   {
      int[] rollsByFrame = {10, 0, 10, 0, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
      assertThat(rollsByFrame.length, is(20));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);
      assertThat(totalScore, is(equalTo(50)));
   }

   @Test
   public void shouldReturnTotalScoreWithThreeStrike()
   {
      int[] rollsByFrame = {10, 0, 10, 0, 10, 0, 7, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
      assertThat(rollsByFrame.length, is(20));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);
      assertThat(totalScore, is(equalTo(85)));
   }

   @Test
   public void shouldReturnTotalScoreWithThreeStrikeAndOneSpare()
   {
      int[] rollsByFrame = {10, 0, 10, 0, 10, 0, 7, 3, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
      assertThat(rollsByFrame.length, is(20));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);
      assertThat(totalScore, is(equalTo(104)));
   }

   @Test
   public void shouldReturnTotalScoreWithAllStrike()
   {
      int[] rollsByFrame = {10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 10, 10};
      assertThat(rollsByFrame.length, is(21));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);
      assertThat(totalScore, is(equalTo(300)));
   }

   @Test
   public void shouldReturnTotalScoreWithAllStrikeAndSpareOnExtraRoll()
   {
      int[] rollsByFrame = {10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 9, 1};
      assertThat(rollsByFrame.length, is(21));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);
      assertThat(totalScore, is(equalTo(289)));
   }

   @Test
   public void shouldReturnTotalScoreWithAllStrikeAndSpareAtTheEnd()
   {
      int[] rollsByFrame = {10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 9, 1, 6};
      assertThat(rollsByFrame.length, is(21));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);
      assertThat(totalScore, is(equalTo(275)));
   }

   @Test
   public void shouldReturnTotalScoreWithAllButLastNotStrike()
   {
      int[] rollsByFrame = {10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 9, 0};
      assertThat(rollsByFrame.length, is(20));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);
      assertThat(totalScore, is(equalTo(267)));
   }

   @Test
   public void shouldReturnTotalScoreWithMixedRolls()
   {
      int[] rollsByFrame = {10, 0, 10, 0, 10, 0, 7, 3, 5, 5, 4, 3, 7, 3, 10, 0, 10, 0, 10, 10, 10};
      assertThat(rollsByFrame.length, is(21));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);
      assertThat(totalScore, is(equalTo(223)));
   }

   @Test
   public void shouldReturnTotalScoreWith10PairsOf5And5()
   {
      int[] rollsByFrame = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
      assertThat(rollsByFrame.length, is(21));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);
      assertThat(totalScore, is(equalTo(150)));
   }
}
