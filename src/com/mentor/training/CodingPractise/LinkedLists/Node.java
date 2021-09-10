package com.mentor.training.CodingPractise.LinkedLists;

public class Node {

    public Node next;

    public int value;

    Node(int value)
    {
        this.value=value;
        next=null;
    }

    Node appendNode(int value)
    {
        if(next==null)
        {
            next=new Node(value);
        }
        return next;
    }
}
