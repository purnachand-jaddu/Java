package com.mentor.training.contest674;

import java.util.Scanner;

public class FloorNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long testCases = scanner.nextLong();
        while (testCases-- > 0) {
            System.out.println((long) doCalculate(scanner));
        }
    }

    private static double doCalculate(Scanner scanner) {
        double apartNumber = scanner.nextDouble();
        double numberOfApartsInAFloor = scanner.nextDouble();
        if (apartNumber <= 2) {
            return 1;
        }
        double f = (apartNumber - 2.0) / numberOfApartsInAFloor;
        return 1 + Math.ceil(f);
    }
}
