package com.mentor.training.servicenow;

import java.util.Arrays;

//Given an array of integers in random order, rearrange them so that they follow below condition
//Each element should be either less than its neighbours or greater than its neighbours
//Ex: A = [2,7,9,4,1] . Solution: [2,9,1,7,4]
// 1 2 4 7 9
// 1 7 2 9 4
// 2 7 4 9 1

public class BeautifulArray
{
	public static void main(String[] args)
	{
		BeautifulArray solution = new BeautifulArray();
		int[] input = {2, 7, 9, 4, 1};
		solution.makeArrayBeautiful(input);
		System.out.println(Arrays.toString(input));
	}

	private void makeArrayBeautiful(int[] nums)
	{
		if (nums.length <= 2) {
			return;
		}
		boolean parentPattern = nums[1] > nums[0];
		for (int i = 2; i < nums.length; i++) {
			boolean currentPattern = nums[i] > nums[i - 1];
			if (currentPattern == parentPattern) {
				int temp = nums[i];
				nums[i] = nums[i - 1];
				nums[i - 1] = temp;
				parentPattern = !currentPattern;
			}
			else {
				parentPattern = currentPattern;
			}
		}
	}
}
