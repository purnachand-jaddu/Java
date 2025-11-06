package com.mentor.training.designpatterns.creational.abstractfactory.factories;

import com.mentor.training.designpatterns.creational.abstractfactory.Chair;
import com.mentor.training.designpatterns.creational.abstractfactory.nonwesternvariant.NonWesternChair;
import com.mentor.training.designpatterns.creational.abstractfactory.nonwesternvariant.NonWesternSofa;
import com.mentor.training.designpatterns.creational.abstractfactory.nonwesternvariant.NonWesternTable;
import com.mentor.training.designpatterns.creational.abstractfactory.Sofa;
import com.mentor.training.designpatterns.creational.abstractfactory.Table;

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
