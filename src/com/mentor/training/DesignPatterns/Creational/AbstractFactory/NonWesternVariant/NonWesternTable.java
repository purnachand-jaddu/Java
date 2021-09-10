package com.mentor.training.DesignPatterns.Creational.AbstractFactory.NonWesternVariant;

import com.mentor.training.DesignPatterns.Creational.AbstractFactory.Table;

public class NonWesternTable implements Table
{
    @Override
    public void executeTable()
    {
        System.out.println("this is non western table");
    }
}
