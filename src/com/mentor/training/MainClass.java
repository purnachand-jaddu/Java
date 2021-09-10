package com.mentor.training;

import java.util.HashSet;
import java.util.Set;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        long l = System.currentTimeMillis();
        TestObject obj1=new TestObject();
        TestObject obj2=new TestObject();

        Set<Integer> set = new HashSet<>();
        obj1.setHashSet(set);
        obj2.setHashSet(set);
        int i = 5 % 4;
        int i2 = 5 / 4;
        int i3 = 5 / 4;
        int i4 = 5 * 4;

        Thread.sleep(1000);

        obj1.modifySet();

        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
//        System.out.println(obj2.getSet().size());
    }

}
