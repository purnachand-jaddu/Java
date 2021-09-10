package com.mentor.training.questions;

public class GarbageCollection {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Garbage collected");
    }

    public static void main(String[] args) {
        GarbageCollection a = new GarbageCollection();
        GarbageCollection b = new GarbageCollection();
        a=null;
        b=null;
        System.gc();
    }
}
