package com.mentor.training.DesignPatterns.Creational.AbstractFactory.NonWesternVariant;

import com.mentor.training.DesignPatterns.Creational.AbstractFactory.Chair;

public class NonWesternChair implements Chair
{
    @Override
    public void executeChair()
    {
        System.out.println("this is non western chair");
    }
}
