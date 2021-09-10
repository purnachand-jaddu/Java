package com.mentor.training.contest674;

import java.util.Scanner;

public class IncreaseAndCopy {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long testCases = scanner.nextLong();
        while (testCases-- > 0) {
            int arraySize = scanner.nextInt();
            int[] outputArray = new int[arraySize + 1];

            outputArray[1] = 0;
            outputArray[2] = 1;

            for (int i = 3; i <= arraySize; i++) {
                int numberOfOperations = outputArray[i - 1] + 1;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        numberOfOperations = Math.min(numberOfOperations, (outputArray[j] * (i / j)) - 1);
                    }
                }
                outputArray[i] = numberOfOperations;
            }
            System.out.println(outputArray[arraySize]);
        }
    }

    private static void printOutputArray(int[] outputArray) {
        for (int value : outputArray) {
            System.out.println(value);
            System.out.println(" ");
        }
        System.out.println("\n");
    }
}
