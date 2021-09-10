package com.mentor.training.questions;

public class RotatedIndex {
    public int search(int[] nums, int target) {
        int rotatedIndex = findRotatedIndex(nums, 0, nums.length - 1);
        return findIndex(nums, rotatedIndex, target);
    }

    private int findIndex(int[] nums, int index, int target) {
        if (index != -1) {
            int returnIndex = binarySearch(nums, 0, index, target);
            if (returnIndex != -1) {
                return returnIndex;
            }
            return binarySearch(nums, index, nums.length - 1, target);
        } else {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (end - start == 1) {
                return binarySearch(nums, start + 1, end, target);
            } else if (nums[mid] > target) {
                return binarySearch(nums, start, mid - 1, target);
            }
            return binarySearch(nums, mid + 1, end, target);
        }
        return -1;
    }

    private int findRotatedIndex(int[] nums, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (isLeftIndexGreater(nums, mid) && isRightIndexGreater(nums, mid)) {
                return mid;
            } else if (end - start == 1) {
                return findRotatedIndex(nums, start + 1, end);
            } else if (nums[mid] > nums[start] && nums[mid] > nums[end]) {
                return findRotatedIndex(nums, mid + 1, end);
            }
            return findRotatedIndex(nums, start, mid - 1);
        }
        return -1;
    }

    private boolean isLeftIndexGreater(int[] nums, int index) {
        if (index - 1 < 0) {
            return true;
        }
        return nums[index - 1] > nums[index];
    }

    private boolean isRightIndexGreater(int[] nums, int index) {
        if (index + 1 >= nums.length) {
            return true;
        }
        return nums[index + 1] > nums[index];
    }

    public static void main(String[] args) {
        RotatedIndex index = new RotatedIndex();
        int[] input = new int[]{2, 3, 0, 1};
        System.out.println(index.search(input, 1));
    }
}
