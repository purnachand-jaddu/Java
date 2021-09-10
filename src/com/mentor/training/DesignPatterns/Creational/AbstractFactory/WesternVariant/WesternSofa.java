package com.mentor.training.DesignPatterns.Creational.AbstractFactory.WesternVariant;

import com.mentor.training.DesignPatterns.Creational.AbstractFactory.Sofa;

public class WesternSofa implements Sofa
{
    @Override
    public void executeSofa()
    {
        System.out.println("This is western sofa");
    }
}
