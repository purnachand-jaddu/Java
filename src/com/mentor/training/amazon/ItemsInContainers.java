package com.mentor.training.amazon;

import java.util.Scanner;

public class ItemsInContainers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.next().toCharArray();

        int inputLength = input.length;

        int[] output = new int[inputLength];

        for (int i = 0; i < inputLength; i++) {
            output[i] = -1;
        }

        boolean firstOpen = true;

        int count = 0;
        for (int i = inputLength - 1; i >= 0; i--) {
            if (input[i] == '*' && firstOpen) {
                output[i] = 0;
            } else if (firstOpen) {
                output[i] = 0;
                firstOpen = false;
            } else if (input[i] == '*') {
                count++;
            } else if (input[i] == '|') {
                output[i] = count;
                for (int j = i + 1; j < inputLength; j++) {
                    if (output[j] != -1) {
                        break;
                    } else {
                        output[j] = count;
                    }
                }
            }
        }
        for (int i = 0; i < inputLength; i++) {
            System.out.print(output[i] + " ");
        }
    }
}
