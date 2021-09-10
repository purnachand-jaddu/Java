package com.mentor.training.CodingPractise;

import java.util.*;

//https://www.hackerrank.com/challenges/bigger-is-greater/problem
public class BiggerIsGreater
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n-- >0)
        {
            String s = scanner.next();
            char firstChar = s.charAt(0);
            String intermediateString = s.substring(1);
            String finalString = "";

            if (checkStatusOfString(intermediateString))
            {
//            System.out.println("sorting not needed here");
                String nextPermutationOfString = getNextPermutationOfString(intermediateString, intermediateString.length() - 1);
                finalString = s.charAt(0) + nextPermutationOfString;
            }
            else
            {
                char currentFirstChar = '0';
//            System.out.println("sorting needed here");
                List<Character> charList = new ArrayList<>();
                int length = s.length();
                for (int i = 0; i < length; i++)
                {
                    charList.add(s.charAt(i));
                }
                Collections.sort(charList);
                boolean greaterCharFound = false;
                for (int i = 0; i < length; i++)
                {
                    Character aChar = charList.get(i);
                    if (aChar > firstChar)
                    {
                        currentFirstChar = aChar;
                        charList.remove(i);
                        greaterCharFound = true;
                        break;
                    }
                }
//            System.out.println(charList);
                if (!greaterCharFound)
                {
                    finalString = s;
                }
                else if (currentFirstChar != '0')
                {
                    charList.add(0, currentFirstChar);
                    finalString = String.valueOf(charList);
                }
            }
            if (finalString.equals(s))
            {
                System.out.println("no answer");
            }
            else
            {
                System.out.println(finalString.replace("[", "").replace(",", "").replace("]", "").replace(" ", "").trim());
            }
        }
    }

    private static String getNextPermutationOfString(String string, int length)
    {
        char[] chars = string.toCharArray();
        boolean matchFound = false;
        for (int i = length; i >= 0; i--)
        {
            for (int j = length; j >= 0; j--)
            {
                if (chars[i] < chars[j])
                {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                    matchFound = true;
                    break;
                }
            }
            if (matchFound)
            {
                break;
            }
        }
        return Arrays.toString(chars).replace("[", "").replace(",", "").replace("]", "").replace(" ", "").trim();
    }

    private static boolean checkStatusOfString(String s)
    {
        int len = s.length();
        for (int i = 0; i < len - 1; i++)
        {
            if (s.charAt(i) < s.charAt(i + 1))
            {
                return true;
            }
        }
        return false;
    }
}
