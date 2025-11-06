package com.mentor.training.designpatterns.creational.abstractfactory.nonwesternvariant;

import com.mentor.training.designpatterns.creational.abstractfactory.Table;

public class NonWesternTable implements Table
{
    @Override
    public void executeTable()
    {
        System.out.println("this is non western table");
    }
}
