package com.mentor.training.amazon;

import java.util.*;

public class NumberOfWaysToMakeChange {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long denominationsLength = scanner.nextLong();
        Set<Integer> denominationsSet = new HashSet<>();
        while (denominationsLength-- > 0) {
            denominationsSet.add(scanner.nextInt());
        }
        int requiredSum = scanner.nextInt();
        int min = Collections.min(denominationsSet);
        long[] output = new long[requiredSum + 1];
        for (int i = 0; i < requiredSum + 1; i++) {
            output[i] = 0;
        }
        output[min] = 1;
        for (int i = min + 1; i < requiredSum + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (denominationsSet.contains(i - j)) {
                    if (j == 0) {
                        output[i]++;
                    }
                    output[i] += output[j];
                }
            }
        }
        System.out.println(output[requiredSum]);
    }

}
