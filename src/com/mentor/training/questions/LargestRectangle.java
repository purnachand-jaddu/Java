package com.mentor.training.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LargestRectangle
{

	public static void main(String[] args)
	{
		List<Integer> input = new ArrayList<>();
		input.add(11);
		input.add(11);
		input.add(10);
		input.add(10);
		input.add(10);
		System.out.println(largestRectangle(input));
	}

	public static long largestRectangle(List<Integer> h)
	{
		Stack<Integer> s = new Stack<>();
		s.push(0);
		int size = h.size();
		int maxArea = Integer.MIN_VALUE;
		for (int i = 1; i < size; i++) {
			if (h.get(i) > h.get(s.peek())) {
				s.push(i);
			}
			else if(h.get(i) < h.get(s.peek())){
				int popped = 0;
				while (!s.isEmpty() && h.get(i) < h.get(s.peek())) {
					popped = s.pop();
					maxArea = Integer.max(maxArea, h.get(popped) * (i - popped));
				}
				s.push(popped);
			}
		}
		while (!s.isEmpty()) {
			int popped = s.pop();
			maxArea = Integer.max(maxArea, h.get(popped) * (size - popped));
		}
		return maxArea;
	}
}
