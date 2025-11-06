package com.mentor.training.codingpractise;

import java.util.Scanner;

public class TwoSetBits {

    private static long INT_MAX = 1000000007;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long testCases = scanner.nextLong();
        for (int i = 0; i < testCases; i++) {
            long input = scanner.nextLong();
            System.out.println(CalculateNthValue(input));
        }
    }

    private static long CalculateNthValue(long input) {
        if (input == 1) {
            return 3;
        } else {
            long toBeAdded = 2;
            long currentRangeLeftValue = 1;
            long currentRangeRightValue = 3;
            while (true) {
                if (currentRangeLeftValue < input && input <= currentRangeRightValue) {
                    return sumOfPowers(toBeAdded, input - currentRangeLeftValue - 1);
                } else {
                    currentRangeLeftValue = currentRangeRightValue;
                    currentRangeRightValue += toBeAdded++;
                }
            }
        }
    }

    private static long sumOfPowers(long firstValue, long secondValue) {
        long firstPower = (long) Math.pow(2, firstValue) % INT_MAX;
        long secondPower = (long) Math.pow(2, secondValue) % INT_MAX;
        return (firstPower + secondPower) % INT_MAX;
    }
}
