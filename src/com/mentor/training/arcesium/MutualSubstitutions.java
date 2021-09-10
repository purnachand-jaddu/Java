package com.mentor.training.arcesium;

public class MutualSubstitutions {

    public static void main(String[] args) {
        System.out.println(calculateMutualSubstitution("coder", 1, new char[]{'c'}, new char[]{'o'}));
        System.out.println(calculateMutualSubstitution("keyboard", 2, new char[]{'n', 'a'}, new char[]{'y', 'z'}));
    }

    private static String calculateMutualSubstitution(String initialString, int m, char[] first, char[] second) {
        assert first.length == m;
        assert second.length == m;
        char[] oldToNewCharMap = new char[26];
        for (int i = 0; i < 26; i++) {
            oldToNewCharMap[i] = (char) ('a' + i);
        }
        for (int i = 0; i < m; i++) {
            char a = first[i];
            char b = second[i];
            oldToNewCharMap[a - 'a'] = b;
            oldToNewCharMap[b - 'a'] = a;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < initialString.length(); i++) {
            sb.append(oldToNewCharMap[initialString.charAt(i) - 'a']);
        }
        return sb.toString();
    }

}
