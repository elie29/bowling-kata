package com.arolla.kata.bowling;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * RollsByFrame > 10 not allowed
 * RollsByFrame < 0 not
 */
public class KataTest
{
   private final BowlingApplication bowlingApplication = new BowlingApplication();

   @Test
   public void shouldReturnTotalScoreWith10PairsOf9AndMiss()
   {
      List<Integer> rollsByFrame = Arrays.asList(9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0);
      int totalScore = bowlingApplication.computeScore(rollsByFrame);

      assertThat(totalScore, is(equalTo(90)));
   }

   @Test
   public void shouldReturn80When8pinsDownThroughAllFrames()
   {
      List<Integer> rollsByFrame = Arrays.asList(8, 0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0);
      int totalScore = bowlingApplication.computeScore(rollsByFrame);

      assertThat(totalScore, is(equalTo(80)));
   }

   @Test
   public void shouldReturnTotalScoreWhenSomePinsDownThroughAllFrames()
   {
      List<Integer> rollsByFrame = Arrays.asList(8, 1, 7, 2, 6, 3, 5, 4, 4, 5, 8, 1, 7, 2, 6, 3, 5, 4, 6, 3);
      int totalScore = bowlingApplication.computeScore(rollsByFrame);

      assertThat(totalScore, is(equalTo(90)));
   }

   @Test
   public void shouldReturnTotalScoreWithOneSpare()
   {
      List<Integer> rollsByFrame = Arrays.asList(8, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
      assertThat(rollsByFrame, hasSize(20));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);

      assertThat(totalScore, is(equalTo(18)));
   }

   @Test
   public void shouldReturnTotalScoreWithFakeSpare()
   {
      List<Integer> rollsByFrame = Arrays.asList(7, 1, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
      assertThat(rollsByFrame, hasSize(20));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);

      assertThat(totalScore, is(equalTo(17)));
   }

   @Test
   public void shouldReturnTotalScoreWithAnotherSpare()
   {
      List<Integer> rollsByFrame = Arrays.asList(8, 2, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
      assertThat(rollsByFrame, hasSize(20));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);

      assertThat(totalScore, is(equalTo(24)));
   }

   @Test
   public void shouldReturnTotalScoreWithTwoSpare()
   {
      List<Integer> rollsByFrame = Arrays.asList(8, 2, 7, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
      assertThat(rollsByFrame, hasSize(20));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);

      assertThat(totalScore, is(equalTo(37)));
   }

   @Test
   public void shouldReturnTotalScoreWithThreeSpare()
   {
      List<Integer> rollsByFrame = Arrays.asList(8, 2, 7, 3, 5, 5, 8, 0, 0, 0, 0, 1, 0, 6, 0, 0, 0, 0, 0, 0);
      assertThat(rollsByFrame, hasSize(20));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);

      assertThat(totalScore, is(equalTo(65)));
   }

   @Test
   public void shouldReturnTotalScoreWithSpareAtTheEnd()
   {
      List<Integer> rollsByFrame = Arrays.asList(8, 2, 7, 3, 5, 5, 8, 0, 0, 0, 0, 1, 0, 6, 0, 0, 0, 0, 9, 1, 7);
      assertThat(rollsByFrame, hasSize(21));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);

      assertThat(totalScore, is(equalTo(82)));
   }

   @Test
   public void shouldReturnTotalScoreWithOneStrike()
   {
      List<Integer> rollsByFrame = Arrays.asList(10, 0, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
      assertThat(rollsByFrame, hasSize(20));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);

      assertThat(totalScore, is(equalTo(24)));
   }

   @Test
   public void shouldReturnTotalScoreWithTwoStrike()
   {
      List<Integer> rollsByFrame = Arrays.asList(10, 0, 10, 0, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
      assertThat(rollsByFrame, hasSize(20));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);

      assertThat(totalScore, is(equalTo(50)));
   }

   @Test
   public void shouldReturnTotalScoreWithThreeStrike()
   {
      List<Integer> rollsByFrame = Arrays.asList(10, 0, 10, 0, 10, 0, 7, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
      assertThat(rollsByFrame, hasSize(20));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);

      assertThat(totalScore, is(equalTo(85)));
   }

   @Test
   public void shouldReturnTotalScoreWithThreeStrikeAndOneSpare()
   {
      List<Integer> rollsByFrame = Arrays.asList(10, 0, 10, 0, 10, 0, 7, 3, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
      assertThat(rollsByFrame, hasSize(20));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);

      assertThat(totalScore, is(equalTo(104)));
   }

   @Test
   public void shouldReturnTotalScoreWithAllStrike()
   {
      List<Integer> rollsByFrame = Arrays.asList(10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 10, 10);
      assertThat(rollsByFrame, hasSize(21));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);

      assertThat(totalScore, is(equalTo(300)));
   }

   @Test
   public void shouldReturnTotalScoreWithAllStrikeAndSpareOnExtraRoll()
   {
      List<Integer> rollsByFrame = Arrays.asList(10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 9, 1);
      assertThat(rollsByFrame, hasSize(21));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);

      assertThat(totalScore, is(equalTo(289)));
   }

   @Test
   public void shouldReturnTotalScoreWithAllStrikeAndSpareAtTheEnd()
   {
      List<Integer> rollsByFrame = Arrays.asList(10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 9, 1, 6);
      assertThat(rollsByFrame, hasSize(21));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);

      assertThat(totalScore, is(equalTo(275)));
   }

   @Test
   public void shouldReturnTotalScoreWithAllButLastNotStrike()
   {
      List<Integer> rollsByFrame = Arrays.asList(10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 9, 0);
      assertThat(rollsByFrame, hasSize(20));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);

      assertThat(totalScore, is(equalTo(267)));
   }

   @Test
   public void shouldReturnTotalScoreWithMixedRolls()
   {
      List<Integer> rollsByFrame = Arrays.asList(10, 0, 10, 0, 10, 0, 7, 3, 5, 5, 4, 3, 7, 3, 10, 0, 10, 0, 10, 10, 10);
      assertThat(rollsByFrame, hasSize(21));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);

      assertThat(totalScore, is(equalTo(223)));
   }

   @Test
   public void shouldReturnTotalScoreWith10PairsOf5And5()
   {
      List<Integer> rollsByFrame = Arrays.asList(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);
      assertThat(rollsByFrame, hasSize(21));

      int totalScore = bowlingApplication.computeScore(rollsByFrame);

      assertThat(totalScore, is(equalTo(150)));
   }
}
