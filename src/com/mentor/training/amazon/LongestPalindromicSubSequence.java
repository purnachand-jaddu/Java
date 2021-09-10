package com.mentor.training.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestPalindromicSubSequence {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.next();

        List<Integer> outPut = new ArrayList<>(inputString.length());

        for (int i = 0; i < inputString.length(); i++) {
            outPut.add(0);
        }

        outPut.set(0, 1);

        for (int i = 1; i < inputString.length(); i++) {

            boolean hasMatch = false;
            for (int j = 0; j < i; j++) {

                if (inputString.charAt(i) == inputString.charAt(j)) {
                    hasMatch = true;
                    break;
                }
            }
            int previousValue = outPut.get(i - 1);
            if (hasMatch) {
                outPut.set(i, previousValue + 1);
            } else {
                outPut.set(i, previousValue);
            }
        }

        System.out.println(outPut.get(inputString.length()-1));
    }
}
