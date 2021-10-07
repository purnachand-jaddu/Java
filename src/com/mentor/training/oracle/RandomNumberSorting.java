package com.mentor.training.oracle;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberSorting
{

	public static void main(String[] args)
	{
		List<Integer> input = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int value = (int) (Math.random() * 10);
			input.add(value);
		}
		System.out.println(sortUsingMergeSort(input));
	}

	private static List<Integer> sortUsingMergeSort(List<Integer> input)
	{
		if (input.size() == 1) {
			return input;
		}
		int start = 0;
		int end = input.size() - 1;
		int mid = start + (end - start) / 2;
		List<Integer> firstHalf = input.subList(0, mid + 1);
		List<Integer> secondHalf = input.subList(mid + 1, end + 1);
		List<Integer> sortedFirst = sortUsingMergeSort(firstHalf);
		List<Integer> sortedSecond = sortUsingMergeSort(secondHalf);
		List<Integer> sortedList = new ArrayList<>();
		int start1 = 0;
		int start2 = 0;
		while (true) {
			if (start1 == sortedFirst.size() && start2 == sortedSecond.size()) {
				break;
			}
			else if (start1 == sortedFirst.size()) {
				sortedList.add(sortedSecond.get(start2));
				start2++;
			}
			else if (start2 == sortedSecond.size()) {
				sortedList.add(sortedFirst.get(start1));
				start1++;
			}
			else {
				if (sortedFirst.get(start1) < sortedSecond.get(start2)) {
					sortedList.add(sortedFirst.get(start1));
					start1++;
				}
				else {
					sortedList.add(sortedSecond.get(start2));
					start2++;
				}
			}
		}
		return sortedList;
	}
}
