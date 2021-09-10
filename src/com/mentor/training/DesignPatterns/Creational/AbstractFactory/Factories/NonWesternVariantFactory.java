package com.mentor.training.DesignPatterns.Creational.AbstractFactory.Factories;

import com.mentor.training.DesignPatterns.Creational.AbstractFactory.Chair;
import com.mentor.training.DesignPatterns.Creational.AbstractFactory.NonWesternVariant.NonWesternChair;
import com.mentor.training.DesignPatterns.Creational.AbstractFactory.NonWesternVariant.NonWesternSofa;
import com.mentor.training.DesignPatterns.Creational.AbstractFactory.NonWesternVariant.NonWesternTable;
import com.mentor.training.DesignPatterns.Creational.AbstractFactory.Sofa;
import com.mentor.training.DesignPatterns.Creational.AbstractFactory.Table;

public class NonWesternVariantFactory extends AbstractFactory
{
    @Override
    public Chair getChair()
    {
        return new NonWesternChair();
    }

    @Override
    public Table getTable()
    {
        return new NonWesternTable();
    }

    @Override
    public Sofa getSofa()
    {
        return new NonWesternSofa();
    }
}
