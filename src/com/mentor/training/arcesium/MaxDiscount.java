package com.mentor.training.arcesium;

public class MaxDiscount {

    public static void main(String[] args) {
        System.out.println(calculateMaxDiscount(8,4,3,1,2));
        System.out.println(calculateMaxDiscount(15,4,5,3,1));
    }

    @SuppressWarnings("SameParameterValue")
    private static long calculateMaxDiscount(long N, long x, long y, long a, long b) {
        long discount = 0;
        for (int i = 1; i <= N; i++) {
            if (i % x == 0 && i % y == 0) {
                discount += max(a, b);
            } else if (i % x == 0) {
                discount += a;
            } else if (i % y == 0) {
                discount += b;
            }
        }
        return discount;
    }

    private static long max(long a, long b) {
        return a > b ? a : b;
    }


}
