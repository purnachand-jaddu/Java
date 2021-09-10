package com.mentor.training;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

//Fail-fast : will not allow any modification done collection after creating iterator as it works or direct references of collections.
//Fail-safe : will not notice any modifications done on collection after creating iterator as it works on clone of collection, has drawbacks of time taken for creating cloning and not noticing an new changes done after creating iterator

class FailFastIterator
{
    public static void main(String[] args)
    {
        List <Integer> myList=new LinkedList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);

        Iterator<Integer> iterator = myList.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
            myList.add(5);
        }
    }
}

class FailSafeIterator
{
    public static void main(String[] args)
    {
        ConcurrentHashMap<String,Integer> myHashMap=new ConcurrentHashMap<>();
        myHashMap.put("a",1);
        myHashMap.put("b",2);
        myHashMap.put("c",3);

        Iterator<String> iterator = myHashMap.keySet().iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
            myHashMap.put("d",4);
        }
    }
}
