package com.mentor.training.designpatterns.creational.abstractfactory.factories;

import com.mentor.training.designpatterns.creational.abstractfactory.Chair;
import com.mentor.training.designpatterns.creational.abstractfactory.Sofa;
import com.mentor.training.designpatterns.creational.abstractfactory.Table;

public abstract class AbstractFactory
{
    public abstract Chair getChair();

    public abstract Table getTable();

    public abstract Sofa getSofa();
}
