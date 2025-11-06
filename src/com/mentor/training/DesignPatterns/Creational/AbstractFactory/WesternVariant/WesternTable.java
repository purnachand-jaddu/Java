package com.mentor.training.designpatterns.creational.abstractfactory.westernvariant;

import com.mentor.training.designpatterns.creational.abstractfactory.Table;

public class WesternTable implements Table
{
    @Override
    public void executeTable()
    {
        System.out.println("This is western table");
    }
}
