package com.mentor.training.amazon;

import java.util.Scanner;

public class ReverseWordsInSentence {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(reverseValues(s.split(" ")));

    }

    private static String reverseValues(String[] s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length - 1; i >= 0; i--) {
            sb.append(s[i]).append(" ");
        }

        return sb.toString();
    }
}
