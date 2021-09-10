package com.mentor.training.contest441;

import java.util.Arrays;
import java.util.Scanner;

public class MainClass {

    private static final char[] charSet = getValidCharacters(3);

    private static char[] getValidCharacters(int i) {
        char[] chars = new char[i];
        chars[0] = 'a';
        chars[1] = 'b';
        return chars;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int offSet = 2;
        int startingPoint = 0;
        char[] output = new char[length];
        fillCharArray(output, length, startingPoint, offSet);
        fillCharArray(output, length, ++startingPoint, offSet);
        System.out.println(getString(output));
    }

    private static String  getString(char[] output) {
        StringBuilder sb = new StringBuilder();
        for (char c : output) {
            sb.append(c);
        }
        return sb.toString();
    }

    private static void fillCharArray(char[] output, int length, int startingPoint, int offSet) throws Exception {

        int state = 0;
        for (int i = startingPoint; i < length; i += offSet) {
            output[i] = charSet[state];
            state = getUpdatedState(state);
        }
    }

    private static int getUpdatedState(int state) throws Exception {
        if (state == 0)
            return 1;
        if (state == 1)
            return 0;
        if (state == 2)
            return 0;
        throw new Exception("");
    }
}
