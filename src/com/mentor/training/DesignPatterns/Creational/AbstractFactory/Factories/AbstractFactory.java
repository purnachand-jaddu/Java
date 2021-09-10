package com.mentor.training.DesignPatterns.Creational.AbstractFactory.Factories;

import com.mentor.training.DesignPatterns.Creational.AbstractFactory.Chair;
import com.mentor.training.DesignPatterns.Creational.AbstractFactory.Sofa;
import com.mentor.training.DesignPatterns.Creational.AbstractFactory.Table;

public abstract class AbstractFactory
{
    public abstract Chair getChair();

    public abstract Table getTable();

    public abstract Sofa getSofa();
}
