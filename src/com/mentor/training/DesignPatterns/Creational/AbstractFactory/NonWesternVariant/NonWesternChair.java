package com.mentor.training.designpatterns.creational.abstractfactory.nonwesternvariant;

import com.mentor.training.designpatterns.creational.abstractfactory.Chair;

public class NonWesternChair implements Chair
{
    @Override
    public void executeChair()
    {
        System.out.println("this is non western chair");
    }
}
