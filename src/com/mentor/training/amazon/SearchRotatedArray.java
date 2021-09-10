package com.mentor.training.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchRotatedArray {

    public static void main(String[] args) {

        List<Integer> input = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        int inputLength = scanner.nextInt();

        for (int i = 0; i < inputLength; i++) {
            input.add(scanner.nextInt());
        }

        int valueToBeSearched = scanner.nextInt();

        int rotatedIndex = findRotatedIndex(input);

        int indexInFirstHalf = binarySearch(valueToBeSearched, input, 0, rotatedIndex);

        if (indexInFirstHalf != -1) {
            System.out.println(indexInFirstHalf);
        } else {
            System.out.println(binarySearch(valueToBeSearched, input, rotatedIndex + 1, inputLength - 1));
        }

    }

    private static int binarySearch(int valueToBeSearched, List<Integer> input, int low, int high) {

        if (high < low) {
            return -1;
        }
        if (low == high) {
            if (input.get(low) == valueToBeSearched) {
                return low;
            }
            return -1;
        }
        int mid = low + (high - low) / 2;
        int midValue = input.get(mid);
        if (midValue == valueToBeSearched) {
            return mid;
        }
        if (valueToBeSearched < midValue) {
            return binarySearch(valueToBeSearched, input, low, mid - 1);
        }
        return binarySearch(valueToBeSearched, input, mid + 1, high);
    }

    private static int findRotatedIndex(List<Integer> input) {

        int length = input.size();

        for (int i = 0; i < length - 1; i++) {
            if (!(input.get(i) < input.get(i + 1))) {
                return i;
            }
        }
        return length - 1;
    }
}
