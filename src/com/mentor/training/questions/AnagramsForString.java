    package com.mentor.training.questions;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AnagramsForString {

    public static void main(String[] args) {
        System.out.println(calculateAnagrams("abc").size());
        System.out.println(calculateAnagrams("abcd").size());
        System.out.println(calculateAnagrams("abcde").size());
        System.out.println(calculateAnagrams("aaa"));
    }

    private static Set<String> calculateAnagrams(String s) {
        Set<String> result = new HashSet<>();
        return calculateAnagrams(s, 0, result);
    }

    private static Set<String> calculateAnagrams(String s, int swapIndex, Set<String> result) {
        if (swapIndex >= s.length()) {
            return Collections.emptySet();
        }
        for (int i = swapIndex; i < s.length(); i++) {
            String swapped = swap(s, swapIndex, i);
            result.add(swapped);
            result.addAll(calculateAnagrams(swapped, swapIndex+1, result));
        }
        return result;
    }

    private static String swap(String s, int swapIndex, int i) {
        if (swapIndex == i) {
            return s;
        }
        char[] chars = s.toCharArray();
        char temp = chars[swapIndex];
        chars[swapIndex] = chars[i];
        chars[i] = temp;
        return new String(chars).intern();
    }
}
