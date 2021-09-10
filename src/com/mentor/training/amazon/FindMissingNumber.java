package com.mentor.training.amazon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindMissingNumber {

    public static void main(String[] args) {
        Set<Long> input = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        long inputLength = scanner.nextLong();
        for (int i = 0; i < inputLength - 1; i++) {
            input.add(scanner.nextLong());
        }
        for (long i = 1; i <= inputLength; i++) {
            if (!input.contains(i)) {
                System.out.println(i);
                break;
            }
        }
    }
}
