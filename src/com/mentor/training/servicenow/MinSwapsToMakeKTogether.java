package com.mentor.training.servicenow;

//Given an array of n positive integers and a number k. Find the minimum number of swaps required to bring all the numbers less than k together and make a single block of it.
//
//Input array [3,6,4,8,1] K = 5
//
//Input array [3,6,4,8,1], Swap  (6,1) Result array [3,1,4,8,6] . Number of Swaps 1
//Input array [3,6,4,8,1], Swap (3,6) and (8,1). Result array [6,3,4,1,8]. Number of swaps 2
//Input array [3,6,4,8,1], Swap (3,8). Result array  [8,6,4,3,1] Swaps = 1 (3,8)
//So, Min Swaps Required is 1

//-2,1,-1,3,-4

public class MinSwapsToMakeKTogether
{

	public static void main(String[] args)
	{
		MinSwapsToMakeKTogether solution = new MinSwapsToMakeKTogether();
		System.out.println(solution.minSwaps(new int[]{3, 6, 4, 8, 1}, 5));
		System.out.println(solution.minSwaps(new int[]{5, 100, 99, 98, 97, 1, 2, 3, 4, 98}, 6));
	}

	private int minSwaps(int[] nums, int k)
	{
		int length = nums.length;
		int numLessThanK = 0;
		for (int num : nums) {
			if (num < k) {
				numLessThanK++;
			}
		}
		int start = 0;
		int end = numLessThanK - 1;
		int numPos = 0;
		for (int i = 0; i <= end; i++) {
			if (nums[i] >= k) {
				numPos++;
			}
		}
		int numSwaps = numPos;
		while (end + 1 <= length - 1) {
			if (nums[end + 1] >= k) {
				numPos++;
			}
			if (nums[start] >= k) {
				numPos--;
			}
			start++;
			end++;
			numSwaps = Integer.min(numSwaps, numPos);
		}
		return numSwaps;
	}
}
