package com.mentor.training.amazon;

import java.util.*;

public class MusicPairsFinal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int inputLength = scanner.nextInt();

        Map<Integer, Integer> valueToCountMap = new HashMap<>();

        for (int i = 0; i < inputLength; i++) {

            int input = scanner.nextInt();
            input %= 60;
            if (valueToCountMap.containsKey(input)) {
                int count = valueToCountMap.get(input);
                count++;
                valueToCountMap.put(input, count);
            } else {
                valueToCountMap.put(input, 1);
            }
        }

        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : valueToCountMap.entrySet()) {

            int value = entry.getKey();
            int count = entry.getValue();

            if (value < 30 && value > 0) {
                if (valueToCountMap.containsKey(60 - value)) {
                    int alternateCount = valueToCountMap.get(60 - value);
                    sum += count * alternateCount;
                }
            } else if (value == 30 || value == 0) {
                count = count * (count - 1);
                count /= 2;
                sum += count;
            }
        }
        System.out.println(sum);
    }
}
