package com.mentor.training.questions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MaximumXor {

    static int[] maxXor(int[] a, int[] q) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < a.length; i++) {
            insert(root, a[i]);
        }
        int[] returnValue = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            returnValue[i] = q[i]^ searchTheFarthest(root, q[i]);
        }
        return returnValue;
    }

    static int searchTheFarthest(TrieNode root, int value) {
        List<Integer> bitsOfQuery = bits(value);
        List<Integer> closestValue = new ArrayList<>(26);
        for (Integer i : bitsOfQuery) {
            if (i == 0) {
                if (root.oneChild != null) {
                    closestValue.add(1);
                    root = root.oneChild;
                } else {
                    closestValue.add(0);
                    root = root.zeroChild;
                }
            } else if (i == 1) {
                if (root.zeroChild != null) {
                    closestValue.add(0);
                    root = root.zeroChild;
                } else {
                    closestValue.add(1);
                    root = root.oneChild;
                }
            }
        }
        return value(closestValue);
    }


    static void insert(TrieNode root, int value) {
        List<Integer> bitsOfValue = bits(value);
        for (Integer i : bitsOfValue) {
            if (i == 1) {
                if (root.oneChild == null) {
                    root.oneChild = new TrieNode();
                }
                root = root.oneChild;
            } else {
                if (root.zeroChild == null) {
                    root.zeroChild = new TrieNode();
                }
                root = root.zeroChild;
            }
        }
    }

    static List<Integer> bits(int value) {
        List<Integer> returnValue = new ArrayList<>();
        while (value != 0) {
            returnValue.add(value % 2);
            value /= 2;
        }
        if (returnValue.size() < 32) {
            for (int i = returnValue.size(); i < 32; i++) {
                returnValue.add(0);
            }
        }
        Collections.reverse(returnValue);
        return returnValue;
    }

    static int value(List<Integer> bits) {
        int value = 0;
        for (Integer i : bits) {
            value *= 2;
            value += i;
        }
        return value;
    }

    static class TrieNode {

        TrieNode zeroChild = null;
        TrieNode oneChild = null;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("C:\\Users\\pjaddu\\Desktop\\Learnings\\java_training\\Output.txt")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[m];

        for (int i = 0; i < m; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        int[] result = maxXor(arr, queries);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
