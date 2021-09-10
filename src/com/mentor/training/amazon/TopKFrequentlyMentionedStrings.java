package com.mentor.training.amazon;

import java.util.*;

public class TopKFrequentlyMentionedStrings {

    public List<String> getFrequentlyMentionedStrings(int number, List<String> keyWords, List<String> reviews) {
        Map<String, KeyWordWithCount> keywordToObjectMap = new HashMap<>();
        Queue<KeyWordWithCount> queue = new PriorityQueue<>(new MyComparator());
        for (String keyword : keyWords) {
            KeyWordWithCount keyWOrdWithCount = new KeyWordWithCount(keyword);
            keywordToObjectMap.put(keyword, keyWOrdWithCount);
            queue.add(keyWOrdWithCount);
        }
        for (String review : reviews) {
            for (String keyword : keyWords) {
                if (review.toLowerCase().contains(keyword)) {
                    KeyWordWithCount popedObject = keywordToObjectMap.get(keyword);
                    queue.remove(popedObject);
                    popedObject.count++;
                    queue.add(popedObject);
                }
            }
        }

        List<String> output = new ArrayList<>();

        for(int i=0;i<number;i++)
        {
            KeyWordWithCount popedObject = queue.poll();
            output.add(popedObject.keyWord);
        }
        return output;
    }

    private class MyComparator implements Comparator<KeyWordWithCount> {

        @Override
        public int compare(KeyWordWithCount o1, KeyWordWithCount o2) {
            int firstObjectCount = o1.count;
            int secondObjectCount = o2.count;
            if(firstObjectCount == secondObjectCount)
            {
                return o1.keyWord.compareTo(o2.keyWord);
            }
            return Integer.compare(secondObjectCount, firstObjectCount);
        }
    }


    private class KeyWordWithCount {
        private String keyWord;
        private int count;

        private KeyWordWithCount(String keyWord) {
            this.keyWord = keyWord;
            this.count = 0;
        }

    }
}
