package com.mentor.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeometricTriplets {

    public static void main(String[] args) {
        List<Long> input = Arrays.asList(1L,2L,2L,4L);
        System.out.println(countTriplets(input,2));
    }

    static long countTriplets(List<Long> arr, long r) {
        int n=arr.size();
        long totalCount =0;
        for(int i=0;i<n;i++)
        {
            long first = arr.get(i);
            long second = first*r;
            long third = second*r;
            int[] count= new int[n-i-1];
            for(int j=0;j<n-i-1;j++)
            {
                count[j]=0;
            }
            int countTillI=0;
            for(int j=n-1;j>i;j--)
            {
                if(arr.get(j) == third)
                {
                    count[j-i-1] = ++countTillI;
                }
                else
                {
                    count[j-i-1] = countTillI;
                }
                countTillI=count[j-i-1];
            }
            for(int j=i+1;j<n-1;j++)
            {
                if(arr.get(j)== second)
                {
                    totalCount+=count[j-i-1];
                }
            }
        }
        return totalCount;
    }
}
