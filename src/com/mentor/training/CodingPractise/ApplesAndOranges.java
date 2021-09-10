package com.mentor.training.CodingPractise;

//https://www.hackerrank.com/challenges/apple-and-orange/problem

import java.util.Scanner;

public class ApplesAndOranges {

    // Complete the countApplesAndOranges function below.
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int noOfApples=0;
        int noOfOranges=0;
        for(int i=0;i<apples.length;i++)
        {
            int currentApplePosition = apples[i];
            if(s<= a+currentApplePosition && a+currentApplePosition<=t)
            {
                noOfApples++;
            }
        }
        for(int i=0;i<oranges.length;i++)
        {
            int currentOrangePosition = oranges[i];
            if(s<= b+currentOrangePosition && b+currentOrangePosition<=t)
            {
                noOfOranges++;
            }
        }
        System.out.println(noOfApples);
        System.out.println(noOfOranges);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] st = scanner.nextLine().split(" ");

        int s = Integer.parseInt(st[0]);

        int t = Integer.parseInt(st[1]);

        String[] ab = scanner.nextLine().split(" ");

        int a = Integer.parseInt(ab[0]);

        int b = Integer.parseInt(ab[1]);

        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        int[] apples = new int[m];

        String[] applesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int applesItem = Integer.parseInt(applesItems[i]);
            apples[i] = applesItem;
        }

        int[] oranges = new int[n];

        String[] orangesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int orangesItem = Integer.parseInt(orangesItems[i]);
            oranges[i] = orangesItem;
        }

        countApplesAndOranges(s, t, a, b, apples, oranges);

        scanner.close();
    }
}

