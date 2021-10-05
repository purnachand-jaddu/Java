package com.mentor.training.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IcecreamParlor
{

	public static List<Integer> icecreamParlor(int m, List<Integer> arr)
	{
		Map<Integer, List<Integer>> costIndicesMap = populateMap(arr);
		for (Map.Entry<Integer, List<Integer>> entry : costIndicesMap.entrySet()) {
			int currentCost = entry.getKey();
			int remainingCost = m - currentCost;
			if (remainingCost < 0) {
				continue;
			}
			if (remainingCost == currentCost) {
				List<Integer> indicies = entry.getValue();
				if (indicies.size() < 2) {
					continue;
				}
				return Arrays.asList(indicies.get(0) + 1, indicies.get(1) + 1);
			}
			else if (costIndicesMap.containsKey(remainingCost)) {
				List<Integer> firstIndices = entry.getValue();
				List<Integer> secondIndices = costIndicesMap.get(remainingCost);
				return Arrays.asList(firstIndices.get(0) + 1, secondIndices.get(0) + 1);
			}
		}
		return Collections.emptyList();
	}

	private static Map<Integer, List<Integer>> populateMap(List<Integer> arr)
	{
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < arr.size(); i++) {
			int cost = arr.get(i);
			if (map.containsKey(cost)) {
				List<Integer> integers = map.get(cost);
				integers.add(i);
			}
			else {
				List<Integer> indices = new ArrayList<>();
				indices.add(i);
				map.put(cost, indices);
			}
		}
		return map;
	}

	public static void main(String[] args)
	{
		System.out.println(icecreamParlor(4, Arrays.asList(1, 4, 5, 3, 2)));
		System.out.println(icecreamParlor(4, Arrays.asList(2, 2, 4, 3)));
	}
}
