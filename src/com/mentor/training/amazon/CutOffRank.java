package com.mentor.training.amazon;

import java.util.Arrays;
import java.util.List;

public class CutOffRank {

    public static void main(String[] args) {
        System.out.println(getNumberOfUsersInCutOffRank(Arrays.asList(100, 50, 50, 25), 3));
    }

    public static int getNumberOfUsersInCutOffRank(List<Integer> scores, int cutOffRank) {
        int[] counterArray = new int[101];
        for (int i = 0; i < 101; i++) {
            counterArray[i] = 0;
        }
        for (int score : scores) {
            counterArray[score]++;
        }
        int currentRank = 0;
        int index = 0;
        int totalSum = 0;
        while (currentRank < cutOffRank) {
            while (index < 101) {
                if (counterArray[index] != 0) {
                    totalSum += counterArray[index];
                    currentRank += counterArray[index];
                    index++;
                    break;
                } else {
                    index++;
                }
            }
        }
        return totalSum;
    }
}
