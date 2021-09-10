package com.mentor.training.amazon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StringSegmentation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long dictionaryLength = scanner.nextLong();
        Set<String> dictionaryInput = new HashSet<>();
        while (dictionaryLength-- > 0) {
            dictionaryInput.add(scanner.next());
        }
        String stringToBeSegmented = scanner.next();

        int length = stringToBeSegmented.length();
        boolean[] output = new boolean[length];
        for (int i = 0; i < length; i++) {
            output[i] = false;
        }

        String substring = stringToBeSegmented.substring(0, 1);
        if (dictionaryInput.contains(substring)) {
            output[0] = true;
        } else {
            output[1] = false;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                String stringToBeSearched = null;
                if (j == 0) {
                    stringToBeSearched = stringToBeSegmented.substring(0, i + 1);

                } else if (output[j]) {
                    stringToBeSearched = stringToBeSegmented.substring(j + 1, i + 1);
                }
                if (dictionaryInput.contains(stringToBeSearched)) {
                    output[i] = true;
                }
            }
        }

        System.out.println(output[length - 1]);

    }
}
