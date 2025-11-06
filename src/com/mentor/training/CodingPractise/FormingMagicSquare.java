package com.mentor.training.codingpractise;

//https://www.hackerrank.com/challenges/magic-square-forming/problem

import java.util.Scanner;

public class FormingMagicSquare {

    public static void main(String[] args) {
        int b[][] = {
                {
                        4, 3, 8, 9, 5, 1, 2, 7, 6
                },
                {
                        6, 1, 8, 7, 5, 3, 2, 9, 4
                },
                {
                        2, 9, 4, 7, 5, 3, 6, 1, 8
                },
                {
                        2, 7, 6, 9, 5, 1, 4, 3, 8
                },
                {
                        6, 7, 2, 1, 5, 9, 8, 3, 4
                },
                {
                        4, 9, 2, 3, 5, 7, 8, 1, 6
                },
                {
                        8, 1, 6, 3, 5, 7, 4, 9, 2
                },
                {
                        8, 3, 4, 1, 5, 9, 6, 7, 2
                }
        };
        int a[] = new int[9];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            a[i] = scanner.nextInt();
        }
        int MinCost = 81;
        for (int i = 0; i < 8; i++) {
            int calculatedCost = calculatedCost(a, b[i]);
            if (calculatedCost < MinCost) {
                MinCost = calculatedCost;
            }
        }
        System.out.println(MinCost);
    }

    private static int calculatedCost(int[] a, int[] perfectArray) {
        int cost = 0;
        for (int i = 0; i < 9; i++) {
            int tempCost = a[i] - perfectArray[i];
            if (tempCost < 0) {
                tempCost *= -1;
            }
            cost += tempCost;
        }
        return cost;
    }
}
