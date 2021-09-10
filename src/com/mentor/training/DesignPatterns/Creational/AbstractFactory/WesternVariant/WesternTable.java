package com.mentor.training.DesignPatterns.Creational.AbstractFactory.WesternVariant;

import com.mentor.training.DesignPatterns.Creational.AbstractFactory.Table;

public class WesternTable implements Table
{
    @Override
    public void executeTable()
    {
        System.out.println("This is western table");
    }
}
