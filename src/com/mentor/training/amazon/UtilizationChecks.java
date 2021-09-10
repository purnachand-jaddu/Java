package com.mentor.training.amazon;

import java.util.Scanner;

public class UtilizationChecks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfInstances = scanner.nextInt();

        int numberOfQueries = scanner.nextInt();

        int sleepTime = 0;

        for (int i = 0; i < numberOfQueries; i++) {
            int input = scanner.nextInt();
            if (sleepTime > 0) {
                System.out.println("Sleeping...");
                sleepTime--;
            } else if (input < 25) {
                if (numberOfInstances > 1) {
                    numberOfInstances /= 2;
                    sleepTime = 10;
                }
            } else if (input > 60) {
                if (numberOfInstances <= Math.pow(10, 8)) {
                    numberOfInstances *= 2;
                    sleepTime = 10;
                }
            }
        }
        System.out.println(numberOfInstances);
    }
}
