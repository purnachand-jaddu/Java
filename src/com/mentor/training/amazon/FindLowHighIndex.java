package com.mentor.training.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindLowHighIndex {

    public static void main(String[] args) {

        List<Integer> input = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        int inputLength = scanner.nextInt();

        while (inputLength-- > 0) {
            input.add(scanner.nextInt());
        }

        int valueToBeSearched = scanner.nextInt();

        System.out.println(performHighBinarySearch(valueToBeSearched, input, 0, input.size() - 1));

        System.out.println(performLowBinarySearch(valueToBeSearched, input, 0, input.size() - 1));
    }

    private static int performHighBinarySearch(int valueToBeSearched, List<Integer> input, int low, int high) {

        if (high < low) {
            return -1;
        }
        if (low == high) {
            if (valueToBeSearched == input.get(low)) {
                return low;
            }
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (input.get(mid) == valueToBeSearched) {
            if (mid + 1 <= high) {
                if (input.get(mid + 1) == valueToBeSearched) {
                    return performHighBinarySearch(valueToBeSearched, input, mid + 1, high);
                }
                return mid;
            }
            return mid;
        }
        if (input.get(mid) < valueToBeSearched) {
            return performHighBinarySearch(valueToBeSearched, input, mid + 1, high);
        }
        return performHighBinarySearch(valueToBeSearched, input, low, mid - 1);
    }

    private static int performLowBinarySearch(int valueToBeSearched, List<Integer> input, int low, int high) {

        if (high < low) {
            return -1;
        }
        if (low == high) {
            if (valueToBeSearched == input.get(low)) {
                return low;
            }
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (input.get(mid) == valueToBeSearched) {
            if (mid - 1 >= low) {
                if (input.get(mid - 1) == valueToBeSearched) {
                    return performLowBinarySearch(valueToBeSearched, input, low, mid - 1);
                }
                return mid;
            }
            return mid;
        }
        if (input.get(mid) < valueToBeSearched) {
            return performLowBinarySearch(valueToBeSearched, input, mid + 1, high);
        }
        return performLowBinarySearch(valueToBeSearched, input, low, mid - 1);
    }
}
