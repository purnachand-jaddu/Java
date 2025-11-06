package com.mentor.training.designpatterns.creational.abstractfactory.factories;

import com.mentor.training.designpatterns.creational.abstractfactory.Chair;
import com.mentor.training.designpatterns.creational.abstractfactory.Sofa;
import com.mentor.training.designpatterns.creational.abstractfactory.Table;
import com.mentor.training.designpatterns.creational.abstractfactory.westernvariant.WesternChair;
import com.mentor.training.designpatterns.creational.abstractfactory.westernvariant.WesternSofa;
import com.mentor.training.designpatterns.creational.abstractfactory.westernvariant.WesternTable;

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
