package com.mentor.training.designpatterns.creational.abstractfactory.factories;

public class FactoryMgr
{
    public static AbstractFactory getWesternVariantFactory()
    {
        return new WesternVariantFactory();
    }

    public static AbstractFactory getNonWesternVariantFactory()
    {
        return new NonWesternVariantFactory();
    }
}
