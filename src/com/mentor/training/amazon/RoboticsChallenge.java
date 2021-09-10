package com.mentor.training.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoboticsChallenge {

    public static void main(String[] args) {
        System.out.println(computeScope(Arrays.asList("5", "-2", "4", "Z", "X", "9", "+", "+")));
        System.out.println(computeScope(Arrays.asList("1","2","+","Z")));
    }


    private static int computeScope(List<String> stringList) {
        List<Integer> outputScore = new ArrayList<>();
        for (String c : stringList) {
            if (c.equals("Z")) {
                if (!outputScore.isEmpty()) {
                    outputScore.remove(outputScore.size() - 1);
                }
            } else if (c.equals("+")) {
                int score = 0;
                if (!outputScore.isEmpty()) {
                    score += outputScore.get(outputScore.size() - 1);
                }
                if (outputScore.size() >= 2) {
                    score += outputScore.get(outputScore.size() - 2);
                }
                outputScore.add(score);
            } else if (c.equals("X")) {
                if (!outputScore.isEmpty()) {
                    outputScore.add(2 * outputScore.get(outputScore.size() - 1));
                }
            } else {
                outputScore.add(Integer.parseInt(c));
            }
        }

        int totalScore = 0;
        for (int score : outputScore) {
            totalScore += score;
        }

        return totalScore;
    }
}
