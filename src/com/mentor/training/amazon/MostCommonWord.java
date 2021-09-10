package com.mentor.training.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

    public static void main(String[] args)
    {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit";
        String[] bannedWords ={"hit"};
        System.out.println(getMostCommonWord(paragraph,bannedWords));
    }


    private static String getMostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> wordToFrequencyMap = new HashMap<>();

        Set<String> bannedSet = new HashSet<>();
        for (String bannedWord : banned) {
            bannedSet.add(bannedWord.toLowerCase());
        }

        String[] stringsInParagraph = paragraph.split("[\\p{Punct}\\s]+");

        for (String wordInParagraph : stringsInParagraph) {
            if (!bannedSet.contains(wordInParagraph.toLowerCase())) {
                if (!wordToFrequencyMap.containsKey(wordInParagraph.toLowerCase())) {
                    wordToFrequencyMap.put(wordInParagraph.toLowerCase(), 1);
                } else {
                    int currentCount = wordToFrequencyMap.get(wordInParagraph.toLowerCase());
                    currentCount++;
                    wordToFrequencyMap.put(wordInParagraph.toLowerCase(), currentCount);
                }
            }
        }

        int frequency = Integer.MIN_VALUE;
        String frequentWord = null;
        for (Map.Entry<String, Integer> entry : wordToFrequencyMap.entrySet()) {
            String word = entry.getKey();
            int currentFrequency = entry.getValue();
            if (currentFrequency > frequency) {
                frequency = currentFrequency;
                frequentWord = word;
            }
        }

        return frequentWord;
    }

}
