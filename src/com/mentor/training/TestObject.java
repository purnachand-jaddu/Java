package com.mentor.training;

import java.util.Set;

public class TestObject
{
    private Set<Integer> mSet;
    public void setHashSet(Set<Integer> set)
    {
        mSet=set;
    }

    public void modifySet()
    {
        mSet.add(1);
        mSet.add(2);
    }

    public Set<Integer> getSet()
    {
        return mSet;
    }
}
