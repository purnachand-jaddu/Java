package com.mentor.training.amazon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SumOfTwoEqualToValue {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long requiredSum = scanner.nextLong();
        long inputLength = scanner.nextLong();
        Set<Long> input = new HashSet<>();
        for (long i = 0; i < inputLength; i++) {
            input.add(scanner.nextLong());
        }
        System.out.println(calculateOutput(requiredSum, input));

    }

    private static String calculateOutput(long requiredSum, Set<Long> input) {
        for (Long aLong : input) {
            if (input.contains(requiredSum - aLong)) {
                return "YES";
            }
        }
        return "NO";
    }
}
