package com.mentor.training.questions;

import java.util.Arrays;

public class CarsProblem
{

	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(calculateSimilars(new String[]{"100", "110", "010", "011", "100"})));
	}

	private static int[] calculateSimilars(String[] cars)
	{
		int[] toInts = convertToInts(cars);
		int[] result = new int[cars.length];
		for (int i = 0; i < toInts.length; i++) {
			int count = 0;
			for (int j = 0; j < toInts.length; j++) {
				if (i == j) {
					continue;
				}
				int xor = toInts[i] ^ toInts[j];
				if ((xor&xor-1) == 0) {
					count++;
				}
			}
			result[i] = count;
		}
		return result;
	}

	private static int[] convertToInts(String[] cars)
	{
		int[] result = new int[cars.length];
		for (int i = 0; i < cars.length; i++) {
			int length = cars[i].length();
			int value = 0;
			for (int j = length - 1; j >= 0; j--) {
				value = 2 * value + (cars[i].charAt(j) == '0' ? 0 : 1);
			}
			result[i] = value;
		}
		return result;
	}
}
