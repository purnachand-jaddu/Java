package com.mentor.training.questions;

public class IsPowerOf2
{

	public static void main(String[] args)
	{
		IsPowerOf2 solution = new IsPowerOf2();
		int input = 0xFFFFFFFF;
		System.out.println(solution.isPowerOf2BruteForce(input));
		System.out.println(solution.isPowerOf2Efficient(input));
	}

	private boolean isPowerOf2Efficient(int input)
	{
		long startTime = System.currentTimeMillis();
		boolean returnValue = (input & input - 1) == 0;
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken via efficient is " + (endTime - startTime));
		return returnValue;
	}

	private boolean isPowerOf2BruteForce(int input)
	{
		long startTime = System.currentTimeMillis();
		int numberOfSetBits = 0;
		while (input != 0) {
			if ((input & 1) == 1) {
				numberOfSetBits++;
			}
			input = input >>> 1;
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken via brute force is " + (endTime - startTime));
		return numberOfSetBits == 0 || numberOfSetBits == 1;
	}
}
