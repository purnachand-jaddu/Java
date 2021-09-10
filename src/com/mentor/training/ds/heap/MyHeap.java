package com.mentor.training.ds.heap;

public class MyHeap {

    private void heapify(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            int parentIndex = (i - 1) / 2;
            if (nums[i] > nums[parentIndex]) {
                int temp = nums[i];
                nums[i] = nums[parentIndex];
                nums[parentIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        MyHeap heap = new MyHeap();
        int[] input1 = {1, 2, 3, 4};
        heap.heapify(input1);
        System.out.println(input1[0]);
        int[] input2 = {1,10,9,8,17,90,1,210 ,6};
        heap.heapify(input2);
        System.out.println(input2[0]);
    }
}
