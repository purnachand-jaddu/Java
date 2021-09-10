package com.mentor.training.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LargestRectangle {

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(11);
        input.add(11);
        input.add(10);
        input.add(10);
        input.add(10);
        System.out.println(largestRectangle(input));
    }

    public static long largestRectangle(List<Integer> h) {
        long maxArea = Long.MIN_VALUE;
        h.add(0);
        if (h.size() == 0) {
            return 0;
        }
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < h.size(); i++) {
            if (s.isEmpty()) {
                s.push(i);
                continue;
            }
            int topIndex = s.peek();
            if (h.get(i) > h.get(topIndex)) {
                s.push(i);
            } else {
                while (!s.isEmpty() && h.get(s.peek()) > h.get(i)) {
                    int index = s.peek();
                    long poppedArea = h.get(index) * (i - index);
                    if (poppedArea > maxArea) {
                        maxArea = poppedArea;
                    }
                    if (s.isEmpty()) {
                        s.push(0);
                        break;
                    }
                    s.pop();
                }
                s.push(i);
            }

        }
        return maxArea;

    }
}
