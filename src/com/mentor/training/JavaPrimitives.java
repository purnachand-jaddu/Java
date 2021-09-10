package com.mentor.training;


import junit.framework.Assert;

public class JavaPrimitives
{
    public static void main(String[] args)
    {
        String s=new String("Purna").intern();
        String s1=new String("Purna").intern();
        Integer i=1;
        Integer i1=1;
        Assert.assertSame(i,i1);
    }
}
