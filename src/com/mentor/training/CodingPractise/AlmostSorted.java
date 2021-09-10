package com.mentor.training.CodingPractise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/almost-sorted/problem
public class AlmostSorted
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; i++)
        {
            array[i] = scanner.nextInt();
        }
        List<Integer> references=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(!checkRef(i,array))
            {
                references.add(i);
            }
        }
        System.out.println(references.size());
        if(references.size()<=2)
        {
            if(references.size()==1 && array[n-1]>=getLeftValue(references.get(0),array))
            {
                System.out.println("Possible");
                System.out.println("Reverse(" + references.get(0) +"," + (n-1) +")");
            }
        }
        else
        {
            System.out.println("not possible");
        }

    }

    private static boolean checkRef(int i, int[] array)
    {
        int left=getLeftValue(i-1,array);
        int right=getRightValue(i+1,array);
        return (left <= array[i] && array[i] <=right) || (left>=array[i] && array[i]>=right);
    }

    private static int getRightValue(int i, int[] array)
    {
        int value;
        try
        {
            value=array[i];
        }
        catch (IndexOutOfBoundsException e)
        {
            value=Integer.MAX_VALUE;
        }
        return value;
    }

    private static int getLeftValue(int i, int[] array)
    {
        int value;
        try
        {
            value=array[i];
        }
        catch (IndexOutOfBoundsException e)
        {
            value=Integer.MIN_VALUE;
        }
        return value;
    }
}
