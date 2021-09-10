package com.mentor.training.stringalgo;

import java.util.Scanner;

public class RabinKarp {
    private static final double modulus = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String actualString = scanner.next();
        String patternString = scanner.next();
        System.out.println(calculateNumSubStrings(actualString, patternString));
        scanner.close();
    }

    private static int calculateNumSubStrings(String actualString, String patternString) {
        int count = 0;
        int patterLength = patternString.length();
        int actualStringLength = actualString.length();
        double patternHash = getHashForString(patternString);
        double hashForString = getHashForString(actualString.substring(0, patterLength));
        if (patternHash == hashForString) {
            System.out.println(patternHash);
            count++;
        }
        double currentHash = hashForString;
        for (int i = patterLength; i < actualStringLength; i++) {
            currentHash = (actualString.charAt(i) + (currentHash * 10) % modulus - actualString.charAt(i - patterLength) * Math.pow(10, patterLength) % modulus) % modulus;
            System.out.println(currentHash);
            if (currentHash == patternHash) {
                count++;
            }
        }
        return count;
    }

    private static double getHashForString(String patternString) {
        int length = patternString.length();
        double hash = 0;
        int power = 0;
        for (int i = length - 1; i >= 0; i--) {
            char currentChar = patternString.charAt(i);
            double c = (currentChar % modulus * Math.pow(10, power) % modulus) % modulus;
            hash += c;
            power++;
        }
        return hash;
    }
}
