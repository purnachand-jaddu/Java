package com.mentor.training.DesignPatterns.Creational.AbstractFactory.Factories;

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
