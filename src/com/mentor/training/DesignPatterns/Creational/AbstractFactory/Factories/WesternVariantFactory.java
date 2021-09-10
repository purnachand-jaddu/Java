package com.mentor.training.DesignPatterns.Creational.AbstractFactory.Factories;

import com.mentor.training.DesignPatterns.Creational.AbstractFactory.Chair;
import com.mentor.training.DesignPatterns.Creational.AbstractFactory.Sofa;
import com.mentor.training.DesignPatterns.Creational.AbstractFactory.Table;
import com.mentor.training.DesignPatterns.Creational.AbstractFactory.WesternVariant.WesternChair;
import com.mentor.training.DesignPatterns.Creational.AbstractFactory.WesternVariant.WesternSofa;
import com.mentor.training.DesignPatterns.Creational.AbstractFactory.WesternVariant.WesternTable;

public class WesternVariantFactory extends AbstractFactory
{
    @Override
    public Chair getChair()
    {
        return new WesternChair();
    }

    @Override
    public Table getTable()
    {
        return new WesternTable();
    }

    @Override
    public Sofa getSofa()
    {
        return new WesternSofa();
    }
}
