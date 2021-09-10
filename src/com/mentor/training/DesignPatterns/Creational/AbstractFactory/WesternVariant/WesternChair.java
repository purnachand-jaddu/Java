package com.mentor.training.DesignPatterns.Creational.AbstractFactory.WesternVariant;

import com.mentor.training.DesignPatterns.Creational.AbstractFactory.Chair;

public class WesternChair implements Chair
{
    @Override
    public void executeChair()
    {
        System.out.println("This is western chair");
    }
}
