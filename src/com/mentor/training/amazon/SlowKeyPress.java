package com.mentor.training.amazon;

import java.util.*;

public class SlowKeyPress {

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

    public static void main(String[] args) {
        System.out.println(getSlowestKeyPressed(4, Arrays.asList(
                new Pair<>(0, 2),
                new Pair<>(1, 5),
                new Pair<>(0, 9),
                new Pair<>(2, 15)
        )));
    }

    public static Character getSlowestKeyPressed(int numberOfPresses, List<Pair<Integer, Integer>> intToTimeMap) {

        if (numberOfPresses == 0) {
            return null;
        }

        Queue<CharacterPressObject> queue = new PriorityQueue<>(numberOfPresses, new MyComparator());

        for (Pair<Integer, Integer> intToTime : intToTimeMap) {
            queue.offer(new CharacterPressObject(intToTime.getKey(), intToTime.getValue()));
        }
        CharacterPressObject poll = queue.poll();
        char currentChar = poll.character;
        int startTime = poll.startTime;
        int minTimeTaken = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            CharacterPressObject newStartTIme = queue.poll();
            if (newStartTIme.startTime - startTime > minTimeTaken) {
                minTimeTaken = newStartTIme.startTime - startTime;
                currentChar = newStartTIme.character;
            }

            startTime = newStartTIme.startTime;
        }
        return currentChar;
    }

    private static class MyComparator implements Comparator<CharacterPressObject> {
        @Override
        public int compare(CharacterPressObject o1, CharacterPressObject o2) {

            return o2.startTime > o1.startTime ? -1 : o2.startTime == o1.startTime ? 0 : 1;
        }
    }

    private static class CharacterPressObject {
        private char character;

        private int startTime;

        private CharacterPressObject(int charNum, int startTime) {
            this.character = 'a';
            for (int i = 0; i < charNum; i++) {
                character++;
            }
            this.startTime = startTime;
        }
    }

}
