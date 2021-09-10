package com.mentor.training.contest674;

import java.util.Scanner;

public class SymmetricMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long testCases = scanner.nextLong();
        while (testCases-- > 0) {
            long numOfTiles = scanner.nextLong();
            long sizeOfSquare = scanner.nextLong();
            boolean hasPartialSymmetricMatrix = false;
            while (numOfTiles-- > 0) {
                long a0 = scanner.nextLong();
                long a1 = scanner.nextLong();
                long b0 = scanner.nextLong();
                long b1 = scanner.nextLong();
                if (a1 == b0) {
                    hasPartialSymmetricMatrix = true;
                }
            }
            if (sizeOfSquare % 2 == 0 && hasPartialSymmetricMatrix) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
}
