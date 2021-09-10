package com.mentor.training;

import java.util.Scanner;

public class LongestNonDecreasingSubSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] input = new int[length];
        for (int i = 0; i < length; i++) {
            input[i] = scanner.nextInt();
        }
        System.out.println(calculateLongestNonDecreasingSubSequence(input, length));
    }

    private static int calculateLongestNonDecreasingSubSequence(int[] arr, int length) {
        if (arr.length == 0) {
            return 0;
        }
        int[] dp = new int[length];
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] <= arr[i]) {
                    dp[i] = Integer.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = dp[0];
        for (int i = 0; i < length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
