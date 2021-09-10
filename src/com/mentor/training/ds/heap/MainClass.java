package com.mentor.training.ds.heap;

import java.util.PriorityQueue;

public class MainClass {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 < o2 ? -1 : 1);
        queue.add(1);
        queue.add(3);
        queue.add(0);

        System.out.println(queue.peek());
        int x = 0xA;
        System.out.println(x);
    }
}
