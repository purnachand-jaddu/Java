package com.mentor.training.oracle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountingSort
{

	public static void main(String[] args)
	{
		int[] input = new int[]{0, 0, 1, 2, 0, 0, 1, 2, 1, 1, 2, 2, 2};
		Map<Integer, Integer> freqMap = populateFrequencyMap(input);
		int iterator = 0;
		for (int i = 0; i <= 2; i++) {
			Integer freq = freqMap.get(i);
			for (int j = 0; j < freq; j++) {
				input[iterator] = i;
				iterator++;
			}
		}
		System.out.println(Arrays.toString(input));
	}

	private static Map<Integer, Integer> populateFrequencyMap(int[] input)
	{
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 0);
		map.put(1, 0);
		map.put(2, 0);
		for (int i = 0; i < input.length; i++) {
			incrementFreq(input[i], map);
		}
		return map;
	}

	private static void incrementFreq(int i, Map<Integer, Integer> map)
	{
		Integer v = map.get(i);
		map.put(i, v + 1);
	}
}

