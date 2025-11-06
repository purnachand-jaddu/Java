package com.mentor.training.codingpractise;


//https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem

import java.util.Scanner;

public class ClimbingLeaderBoard
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int scoresToRank[][] = new int[n][2];
        int currentRank = 1;

        for (int i = 0; i < n; i++) {
            int element = scanner.nextInt();
            scoresToRank[i][0] = element;
            if (i == 0) {
                scoresToRank[i][1] = currentRank;
            } else {
                if (scoresToRank[i][0] < scoresToRank[i - 1][0]) {
                    scoresToRank[i][1] = ++currentRank;
                } else {
                    scoresToRank[i][1] = currentRank;
                }
            }
        }

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int valueToBeInserted = scanner.nextInt();
            int positionFromBinarySearch = findPositionFromBinarySearch(scoresToRank, valueToBeInserted, 0, n - 1);
            if (positionFromBinarySearch == 0) {
                System.out.println("1");
            } else {
                positionFromBinarySearch--;
                if (valueToBeInserted == scoresToRank[positionFromBinarySearch][0]) {
                    //Print rank
                    System.out.println(scoresToRank[positionFromBinarySearch][1]);
                } else {
                    System.out.println(scoresToRank[positionFromBinarySearch][1] + 1);
                }
            }
        }

    }

    private static int findPositionFromBinarySearch(int[][] scoresToRank, int valueToBeInserted, int initialValue, int finalValue)
    {
        if (initialValue <= finalValue) {
            int reference = (initialValue + finalValue) / 2;
            int referenceRightValue = scoresToRank[reference][0];
            int referenceLeftValue;
            try {
                referenceLeftValue = scoresToRank[reference - 1][0];
            }
            catch (Exception e) {
                referenceLeftValue = Integer.MAX_VALUE;
            }
            if (valueToBeInserted <= referenceLeftValue && valueToBeInserted > referenceRightValue) {
                return reference;
            } else if (referenceLeftValue >= valueToBeInserted && referenceRightValue >= valueToBeInserted) {
                return findPositionFromBinarySearch(scoresToRank, valueToBeInserted, reference + 1, finalValue);
            } else {
                return findPositionFromBinarySearch(scoresToRank, valueToBeInserted, initialValue, reference - 1);
            }
        } else {
            return initialValue;
        }
    }
}
