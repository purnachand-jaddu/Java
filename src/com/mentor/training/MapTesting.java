package com.mentor.training;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapTesting
{

    public static void main(String[] args)
    {
        Map<Set<String>,Set<String>> myMap=new HashMap<>();

        Set<String> mySet=new HashSet<>();
        mySet.add("1");
        mySet.add("2");
        mySet.add("3");

        Set<String> secondSet=new HashSet<>();
        secondSet.add("4");
        secondSet.add("5");
        myMap.put(mySet,secondSet);
        for (Map.Entry<Set<String>, Set<String>> setSetEntry : myMap.entrySet())
        {
//            setSetEntry.getValue().add("6");
        }
        System.out.println("Lol");
    }
}
