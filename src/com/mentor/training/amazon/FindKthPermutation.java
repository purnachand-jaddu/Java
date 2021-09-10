package com.mentor.training.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindKthPermutation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int k = scanner.nextInt();

        List<Integer> possibleEntries = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            possibleEntries.add(i);
        }

        printPermutation(n, k, possibleEntries);

    }

    private static void printPermutation(int n, int k, List<Integer> possibleEntries) {

        if (n == 0) {
            for (Integer possibleEntry : possibleEntries) {
                System.out.println(possibleEntry);
            }
            return;
        }
        int factorial = calculateFactorial(n - 1);
        for (int i = 0; i < n; i++) {
            if (i * factorial < k && k <= (i + 1) * factorial) {
                Integer x = possibleEntries.get(i);
                System.out.println(x);
                possibleEntries.remove(x);
                printPermutation(n - 1, k - i * factorial, possibleEntries);
            }
        }
    }

    private static int calculateFactorial(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }
        return n * calculateFactorial(n - 1);
    }
}
