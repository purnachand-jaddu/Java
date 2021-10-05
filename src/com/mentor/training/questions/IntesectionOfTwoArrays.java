package com.mentor.training.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntesectionOfTwoArrays
{
	public Integer[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int first = 0;
		int second = 0;
		List<Integer> intersection  = new ArrayList<>();
		while(true)
		{
			if(first < nums1.length && second < nums2.length)
			{
				if(nums1[first] == nums2[second])
				{
					intersection.add(nums1[first]);
					first++;
					second++;
				}
				else if(nums1[first] > nums2[second])
				{
					second++;
				}
				else
				{
					first++;
				}
			}
			else
			{
				break;
			}
		}
		Integer[] ref = new Integer[1];
		return intersection.toArray(ref);
	}
}
