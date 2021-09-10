package com.mentor.training.CodingPractise;


import java.util.*;

//https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
public class SherlockAndValidString
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int frequencies[] = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++)
        {
            frequencies[s.charAt(i) - 'a']++;
        }
        List<Integer> nonZeros = new ArrayList<>();
        for (int i = 0; i < 26; i++)
        {
            if (frequencies[i] != 0)
            {
                nonZeros.add(frequencies[i]);
            }
        }
        if (nonZeros.size() <= 1)
        {
            System.out.println("YES");
            scanner.close();
            return;
        }
        else
        {
            int min = calculateMin(nonZeros);

            int index = numberOfOnes(nonZeros);
            if(min==1 && index!=-1)
            {
                nonZeros.remove(index);
                evaluate(nonZeros);
            }
            else
            {
                evaluate(nonZeros);
            }
        }
    }
    private static void evaluate(List<Integer> nonZeros)
    {
        int min=calculateMin(nonZeros);
        boolean removableIndexNotFound = true;
        for (Integer currentValue : nonZeros)
        {
            if (currentValue == min + 1 && removableIndexNotFound)
            {
                removableIndexNotFound = false;
            }
            else if (currentValue != min)
            {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static int numberOfOnes(List<Integer> nonZeros)
    {
        int currentIndex=-1;
        int iterator=0;
        for(Integer value:nonZeros)
        {
            if(value==1)
            {
                if(currentIndex==-1)
                {
                    currentIndex=iterator;
                }
                else
                {
                    currentIndex=-1;
                    break;
                }
            }
            iterator++;
        }
        return currentIndex;
    }

    private static int calculateMin(List<Integer> nonZeros)
    {
        int min = Integer.MAX_VALUE;
        for (Integer value : nonZeros)
        {
            if (value < min)
            {
                min = value;
            }
        }
        return min;
    }
}
