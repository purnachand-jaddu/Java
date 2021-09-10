package com.mentor.training.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintAllBraceCombinations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int inputLength = scanner.nextInt();

        List<BracketWrapper> wrappers = new ArrayList<>();
        for (int i = 0; i < inputLength; i++) {
            wrappers.add(new BracketWrapper());
        }

        fillAllABraceCombinations(wrappers, inputLength, inputLength);
    }

    private static void fillAllABraceCombinations(List<BracketWrapper> wrappers, int inputLength, int actualInputLength) {

        if (wrappers.isEmpty() || inputLength == 0) {
            return;
        }
        for (BracketWrapper leftWrapper : wrappers) {
            for (BracketWrapper rightWrapper : wrappers) {
                if (wrappers.indexOf(leftWrapper) < wrappers.indexOf(rightWrapper)) {
                    leftWrapper.setBracketValue("(");
                    rightWrapper.setBracketValue(")");
                    List<BracketWrapper> copyOfWrappers = new ArrayList<>(wrappers);
                    copyOfWrappers.remove(leftWrapper);
                    copyOfWrappers.remove(rightWrapper);
                    fillAllABraceCombinations(copyOfWrappers, inputLength - 2, actualInputLength);
                    if (wrappers.size() == actualInputLength) {
                        for (BracketWrapper wrapper : wrappers) {
                            System.out.print(wrapper.bracketValue);
                        }
                        System.out.println();
                    }
                }

            }
        }
    }

    private static class BracketWrapper {
        private String bracketValue;

        void setBracketValue(String bracketValue) {
            this.bracketValue = bracketValue;
        }
    }
}
