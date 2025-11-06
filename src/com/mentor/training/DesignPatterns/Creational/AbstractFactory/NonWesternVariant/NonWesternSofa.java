package com.mentor.training.designpatterns.creational.abstractfactory.nonwesternvariant;

import com.mentor.training.designpatterns.creational.abstractfactory.Sofa;

public class NonWesternSofa implements Sofa
{
    @Override
    public void executeSofa()
    {
        System.out.println("This is non western sofa");
    }
}
