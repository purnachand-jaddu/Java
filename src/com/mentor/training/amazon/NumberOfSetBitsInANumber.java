package com.mentor.training.amazon;

import java.util.Scanner;

public class NumberOfSetBitsInANumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        int count=0;

        while(input!=0)
        {
            if((input&1)==1)
            {
                count++;
            }
            input>>=1;
        }

        System.out.println(count);
    }
}
