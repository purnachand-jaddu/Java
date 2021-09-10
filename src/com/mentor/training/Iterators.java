package com.mentor.training;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;

public class Iterators {
    public static void checkIterators() {
        HashSet<Integer> newSet = new HashSet<Integer>(3);
        newSet.add(1);
        newSet.add(5);
        newSet.add(6);
        newSet.add(4);
        newSet.add(1);

        System.out.println(newSet.size());

        Iterator<Integer> iterator = newSet.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("------------------------------");

        ArrayList<Integer> integerArray = new ArrayList<Integer>(5);

        for (int i = 0; i < 8; i++) {
            integerArray.add(i);
        }

        System.out.println(integerArray.size());

        ListIterator<Integer> newIterator = integerArray.listIterator();

        while (newIterator.hasNext()) {
            System.out.println(newIterator.next());

            //iterator.next();
        }

    }
}
