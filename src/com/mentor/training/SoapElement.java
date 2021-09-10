package com.mentor.training;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SoapElement extends Node1 {

    public Iterator getChildren() {
        List<Object> newList=new ArrayList<>();
       addToList(newList,new Node1());
        addToList(newList,new SoapElement());
        return newList.iterator();
    }

    private void addToList(List<Object> newList, Object createdObject) {
        newList.add(createdObject);
    }
}
