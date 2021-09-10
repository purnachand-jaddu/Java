package com.mentor.training.contest668;

import java.util.Scanner;

public class PermutationForgery {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        for (int i = 0; i < testCount; i++) {
            int n = scanner.nextInt();
            long[] input = new long[n];
            for (int j = 0; j < n; j++) {
                long l = scanner.nextLong();
                input[j] = l;
            }
            long[] output = reverse(input, n);
            for (int j = 0; j < n; j++) {
                System.out.print(output[j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static long[] reverse(long[] input, int n) {
        long[] output = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            output[n - 1 - i] = input[i];
        }
        return output;
    }
}
