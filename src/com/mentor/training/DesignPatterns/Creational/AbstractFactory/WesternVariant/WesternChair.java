package com.mentor.training.designpatterns.creational.abstractfactory.westernvariant;

import com.mentor.training.designpatterns.creational.abstractfactory.Chair;

public class WesternChair implements Chair
{
    @Override
    public void executeChair()
    {
        System.out.println("This is western chair");
    }
}
