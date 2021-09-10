package com.mentor.training.contest670;

public class MaximumProduct {
    public int maxProduct(int[] nums) {
        int maxSumEndingHere = 1;
        int minSumEndingHere = 1;
        int maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            if (maxSumEndingHere <= 0) {
                maxSumEndingHere = 1;
            }
            if (minSumEndingHere >= 0) {
                minSumEndingHere = 1;
            }
            if (num > 0) {
                maxSumEndingHere = max(maxSumEndingHere * num, num);
                minSumEndingHere = min(minSumEndingHere * num, num);
            } else if (num < 0) {
                int temp = maxSumEndingHere;
                maxSumEndingHere = max(minSumEndingHere * num, num);
                minSumEndingHere = min(temp * num, num);
            } else {
                maxSumEndingHere = 0;
                minSumEndingHere = 0;
            }
            if (maxSumEndingHere > maxSum) {
                maxSum = maxSumEndingHere;
            }
        }
        return maxSum;
    }

    private int min(int a,int b)
    {
        return a<b?a:b;
    }

    private int max(int a,int b)
    {
        return a>b?a:b;
    }
}
