package com.mentor.training.amazon;

import java.util.Scanner;

public class MusicPairs {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int inputLength = scanner.nextInt();

        long[] input = new long[inputLength];

        for (int i = 0; i < inputLength; i++) {
            input[i] = scanner.nextLong();
        }

        System.out.println(findMaxPairs(inputLength, input));
    }

    private static long findMaxPairs(int inputLength, long[] input) {
        long[] output = new long[inputLength];

        if (inputLength == 1) {
            return 0;
        }

        output[0] = 0;
        output[1] = (input[1] + input[0]) % 60 == 0 ? 1 : 0;

        for (int i = 2; i < inputLength; i++) {
            output[i] = (input[i] + input[i - 1]) % 60 == 0 ? Long.max(output[i - 2] + 1, output[i - 1]) : output[i - 1];
        }

        return output[inputLength - 1];
    }
}
