package com.mentor.training.DesignPatterns.Creational.AbstractFactory.NonWesternVariant;

import com.mentor.training.DesignPatterns.Creational.AbstractFactory.Sofa;

public class NonWesternSofa implements Sofa
{
    @Override
    public void executeSofa()
    {
        System.out.println("This is non western sofa");
    }
}
