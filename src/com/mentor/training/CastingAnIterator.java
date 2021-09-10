package com.mentor.training;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CastingAnIterator {
    CastingAnIterator() {
        NodeInterface nodeInterface = new NodeInterface() {
            @Override
            public Iterator<Node1> getiterator() {
                Node1 node1 = new SoapHeaderElement();
                Node1 node2 = new SoapHeaderElement();
                List<Node1> newList = new ArrayList<>();
                newList.add(node1);
                newList.add(node2);
                return newList.iterator();
            }
        };
        Iterator<Node1> iterator = nodeInterface.getiterator();
        int count = 0;
        while (iterator.hasNext()) {
            if (iterator.next() instanceof SoapHeaderElement) {
                System.out.println(count++);
            }
        }
    }
}
