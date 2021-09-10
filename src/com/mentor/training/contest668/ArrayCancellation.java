package com.mentor.training.contest668;

import java.util.Scanner;
import java.util.Stack;

public class ArrayCancellation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        for (int i = 0; i < testCount; i++) {
            int n = scanner.nextInt();
            long[] input = scanInput(scanner, n);
            System.out.println(performCancellation(input, n));
        }

    }

    private static long performCancellation(long[] input, int length) {
        Stack<Long> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            long currentValue = input[i];
            if (currentValue > 0) {
                if (stack.isEmpty()) {
                    stack.push(currentValue);
                } else {
                    Long top = stack.pop();
                    top += currentValue;
                    stack.push(top);
                }
            } else if (currentValue < 0 && !stack.isEmpty()) {
                Long top = stack.pop();
                long remainingLimit = currentValue + top;
                if (remainingLimit > 0) {
                    input[i] = 0;
                    stack.push(remainingLimit);

                } else {
                    input[i] = remainingLimit;
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < length; i++) {
            long currentValue = input[i];
            if (currentValue < 0) {
                sum += Math.abs(currentValue);
            }
        }
        return sum;
    }

    private static long[] scanInput(Scanner scanner, int n) {
        long[] input = new long[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextLong();
        }
        return input;
    }
}
