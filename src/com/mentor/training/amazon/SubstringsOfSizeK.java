package com.mentor.training.amazon;

import java.util.ArrayList;
import java.util.List;

public class SubstringsOfSizeK {

    public static void main(String[] args) {
        List<String> amag = getSubStringsOfSizeK(4, "wawaglknagagwunagkwkwagl");
        for (String s : amag) {
            System.out.println(s);
        }
    }

    public static List<String> getSubStringsOfSizeK(int k, String referenceString) {

        CharState[] states = new CharState[referenceString.length()];

        CharState previousCharState = null;

        for (int i = 0; i < referenceString.length(); i++) {
            states[i] = new CharState(previousCharState);
            previousCharState = states[i];
            states[i].incrementCount(referenceString.charAt(i));
        }

        int startingPointer = -1;
        int endingPointer = k - 1;
        List<String> output = new ArrayList<>();

        while (endingPointer < referenceString.length()) {
            CharState finalState = states[endingPointer];
            CharState initialState = startingPointer == -1 ? new CharState(null) : states[startingPointer];
            if (isDiffCorrect(finalState, initialState, k)) {
                startingPointer++;
                endingPointer++;
                output.add(referenceString.substring(startingPointer, endingPointer));

            } else {
                startingPointer++;
                endingPointer++;
            }
        }
        return output;
    }

    private static boolean isDiffCorrect(CharState state, CharState state1, int k) {
        int distinctValues = 0;
        for (int i = 0; i < 26; i++) {
            if (state.counts[i] - state1.counts[i] >= 1) {
                distinctValues++;
            }
        }
        return distinctValues == k - 1;
    }

    private static class CharState {
        private int[] counts;

        private CharState(CharState previousState) {
            this.counts = new int[26];
            for (int i = 0; i < 26; i++) {
                if (previousState != null) {
                    this.counts[i] = previousState.counts[i];
                } else {
                    this.counts[i] = 0;
                }
            }
        }

        private void incrementCount(char c) {
            this.counts[c - 'a']++;
        }
    }


}
