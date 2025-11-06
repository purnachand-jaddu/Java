package com.mentor.training.amazon;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    // Simple Pair class to replace javafx.util.Pair
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public static void main(String[] args)
    {
        char[][] inputArray = {
                {'1','1','1','1','1'},
                {'1','0','0','1','0'},
                {'1','0','1','1','0'},
                {'1','0','0','1','0'}
        };
        System.out.println(getNumberOfIslands(inputArray));
    }

    private static int getNumberOfIslands(char[][] inputArray) {
        int rowCount = inputArray.length;
        int columnCount = inputArray[0].length;
        int numberOfConnectedComponents = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (inputArray[i][j] != 'V' && inputArray[i][j] != '0') {
                    findConnectedComponent(i, j, inputArray, rowCount, columnCount);
                    numberOfConnectedComponents++;
                }
            }
        }
        return numberOfConnectedComponents;
    }

    private static void findConnectedComponent(int i, int j, char[][] inputArray, int rowCount, int columnCount) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(i, j));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> poll = queue.poll();
            int row = poll.getKey();
            int column = poll.getValue();
            inputArray[row][column] = 'V';
            if (row + 1 < rowCount) {
                if (inputArray[row + 1][column] == '1') {
                    queue.offer(new Pair<>(row + 1, column));
                }
                if (column - 1 >= 0 && inputArray[row + 1][column - 1] == '1') {
                    queue.offer(new Pair<>(row + 1, column - 1));
                }
                if (column + 1 < columnCount && inputArray[row + 1][column + 1] == '1') {
                    queue.offer(new Pair<>(row + 1, column + 1));
                }

            }
            if (row - 1 >= 0) {
                if (inputArray[row - 1][column] == '1') {
                    queue.offer(new Pair<>(row - 1, column));
                }
                if (column - 1 >= 0 && inputArray[row - 1][column - 1] == '1') {
                    queue.offer(new Pair<>(row - 1, column - 1));
                }
                if (column + 1 < columnCount && inputArray[row - 1][column + 1] == '1') {
                    queue.offer(new Pair<>(row - 1, column + 1));
                }
            }
            if (column + 1 < columnCount && inputArray[row][column + 1] == '1') {
                queue.offer(new Pair<>(row, column + 1));
            }
            if (column - 1 >= 0 && inputArray[row][column - 1] == '1') {
                queue.offer(new Pair<>(row, column - 1));
            }
        }
    }
}
