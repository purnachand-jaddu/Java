package com.mentor.training.questions;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatingSubString
{

	public static void main(String[] args)
	{
		LongestNonRepeatingSubString solution = new LongestNonRepeatingSubString();
		System.out.println(solution.calculateLongestNonRepeatingSubString("abcapqrst"));
		System.out.println(solution.calculateLongestNonRepeatingSubString("abcaa"));
		System.out.println(solution.calculateLongestNonRepeatingSubString("bbbbb"));
		System.out.println(solution.calculateLongestNonRepeatingSubString(""));
	}

	private int calculateLongestNonRepeatingSubString(String s)
	{
		if (s == null || s.length() == 0) {
			return 0;
		}
		int start = 0;
		int length = s.length();
		Map<Character, Integer> freqMap = new HashMap<>();
		int maxLength = Integer.MIN_VALUE;
		for (int i = 0; i < length; i++) {
			char currentChar = s.charAt(i);
			int v = incrementFreq(currentChar, freqMap);
			if (v > 1) {
				while (s.charAt(start) != currentChar) {
					decrementFreq(s.charAt(start), freqMap);
					start++;
				}
				decrementFreq(s.charAt(start), freqMap);
				start++;
			}
			maxLength = Integer.max(maxLength, i - start + 1);
		}
		return maxLength;
	}

	private void decrementFreq(char c, Map<Character, Integer> map)
	{
		Integer v = map.get(c);
		assert v != null;
		map.put(c, v - 1);
	}

	private int incrementFreq(char c, Map<Character, Integer> map)
	{
		Integer v = map.get(c);
		if (v == null) {
			v = 1;
		}
		else {
			v = v + 1;
		}
		map.put(c, v);
		return v;
	}
}
