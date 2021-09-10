package com.mentor.training.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThrottlingGateway {

    public static void main(String[] args) {
        System.out.println(calculateNumberOfDroppedRequests(27, Arrays.asList(
                1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11
        )));
    }

    public static int calculateNumberOfDroppedRequests(int numberOfRequests, List<Integer> requestTimes) {
        int maximum = Collections.max(requestTimes);
        int[] numberOfRequestsAtTime = new int[maximum + 1];

        for (int i = 1; i < maximum + 1; i++) {
            numberOfRequestsAtTime[i] = 0;
        }

        for (Integer time : requestTimes) {
            numberOfRequestsAtTime[time]++;
        }

        for(int i=1;i<maximum+1;i++)
        {
            System.out.print(numberOfRequestsAtTime[i] + " ");
        }
        System.out.println();

        int totalDroppedRequests = 0;

        int leftIndexOfFirstSlidingWindow = 1;
        int rightIndexOfFirstSlidingWindow = 1;
        int firstSlidingWindowSum = 0;

        int leftIndexOfSecondSlidingWindow = 1;
        int rightIndexOfSecondSlidingWindow = 1;
        int secondSlidingWindowSum = 0;

        while (rightIndexOfFirstSlidingWindow < maximum + 1) {

            int numberOfRequestsToBeDropped = Integer.MIN_VALUE;

            if (numberOfRequestsAtTime[rightIndexOfFirstSlidingWindow] > 3) {
                if (numberOfRequestsAtTime[rightIndexOfFirstSlidingWindow] - 3 > numberOfRequestsToBeDropped) {
                    numberOfRequestsToBeDropped = numberOfRequestsAtTime[rightIndexOfFirstSlidingWindow] - 3;
                }
            }
            firstSlidingWindowSum += numberOfRequestsAtTime[rightIndexOfFirstSlidingWindow];
            if (rightIndexOfFirstSlidingWindow - leftIndexOfFirstSlidingWindow >= 10) {
                firstSlidingWindowSum -= numberOfRequestsAtTime[leftIndexOfFirstSlidingWindow];
                leftIndexOfFirstSlidingWindow++;
            }
            if (firstSlidingWindowSum > 20 && firstSlidingWindowSum - 20 > numberOfRequestsToBeDropped) {
                numberOfRequestsToBeDropped = firstSlidingWindowSum - 20;
            }
            secondSlidingWindowSum += numberOfRequestsAtTime[rightIndexOfSecondSlidingWindow];
            if (rightIndexOfSecondSlidingWindow - leftIndexOfSecondSlidingWindow >= 60) {
                secondSlidingWindowSum -= numberOfRequestsAtTime[leftIndexOfSecondSlidingWindow];
                leftIndexOfSecondSlidingWindow++;
            }
            if (secondSlidingWindowSum > 60 && secondSlidingWindowSum - 60 > numberOfRequestsToBeDropped) {
                numberOfRequestsToBeDropped = secondSlidingWindowSum - 60;
            }
            if (numberOfRequestsToBeDropped == Integer.MIN_VALUE) {
                System.out.print(0 + " ");
            } else {
                System.out.print(numberOfRequestsToBeDropped + " ");
            }
            if (numberOfRequestsToBeDropped != Integer.MIN_VALUE) {
                totalDroppedRequests += numberOfRequestsToBeDropped;
            }
            rightIndexOfFirstSlidingWindow++;
            rightIndexOfSecondSlidingWindow++;
        }
        return totalDroppedRequests;
    }
}
