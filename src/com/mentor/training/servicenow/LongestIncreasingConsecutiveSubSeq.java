package com.mentor.training.servicenow;

public class LongestIncreasingConsecutiveSubSeq
{
	//	  Input : a[] = {3, 10, 3, 11, 4, 5, 6, 7, 8, 12}
	//	  Output : 6
	//	  Explanation: 4, 5, 6, 7, 8, 12
	//
	//
	//	  Input : a[] = {6, 7, 8, 3, 4, 5, 9, 10}
	//	  Output : 5
	//    Explanation:  3, 4, 5, 9, 10

	public static void main(String[] args)
	{
		LongestIncreasingConsecutiveSubSeq sol = new LongestIncreasingConsecutiveSubSeq();
		System.out.println(sol.calculateLongestSubSeq(new int[]{3, 10, 3, 11, 4, 5, 6, 7, 8, 12}));
		System.out.println(sol.calculateLongestSubSeq(new int[]{6, 7, 8, 3, 4, 5, 9, 10}));
	}

	private int calculateLongestSubSeq(int[] arr)
	{
		if (arr.length == 0) {
			return 0;
		}
		int currLength = 1;
		int maxLength = Integer.MIN_VALUE;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1]) {
				currLength++;
			}
			else {
				currLength = 1;
			}
			maxLength = Integer.max(maxLength, currLength);
		}
		return maxLength;
	}
}

