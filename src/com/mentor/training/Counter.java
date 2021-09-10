package com.mentor.training;

public class Counter {

    public static void main(String[] args) {
        int count=0;
        count++;
        changeCount(count);
        System.out.println(count);
    }

    private static void changeCount(int count) {
        count++;
    }
}
