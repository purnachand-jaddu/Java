package com.mentor.training.arcesium;

public class SuppandiStockPrice {

    public static void main(String[] args) {
        System.out.println(calculateMinimumDays(1, 10));
        System.out.println(calculateMinimumDays(4,3));
    }

    private static long calculateMinimumDays(int m, int n) {
        if (m <= n) {
            return n - m;
        }
        if (m % 2 == 0) {
            return calculateMinimumDays(m / 2, n) + 1;
        } else {
            return calculateMinimumDays(m + 1, 2) + 1;
        }
    }

}
