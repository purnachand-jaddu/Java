package com.mentor.training.designpatterns.creational.abstractfactory.westernvariant;

import com.mentor.training.designpatterns.creational.abstractfactory.Sofa;

public class WesternSofa implements Sofa
{
    @Override
    public void executeSofa()
    {
        System.out.println("This is western sofa");
    }
}
