package com.mentor.training.DesignPatterns.Creational.AbstractFactory;

import com.mentor.training.DesignPatterns.Creational.AbstractFactory.Factories.AbstractFactory;
import com.mentor.training.DesignPatterns.Creational.AbstractFactory.Factories.FactoryMgr;

public class MainClass
{
    public static void main(String[] args)
    {
        AbstractFactory nonWesternVariantFactory = FactoryMgr.getNonWesternVariantFactory();

        nonWesternVariantFactory.getChair().executeChair();
        nonWesternVariantFactory.getTable().executeTable();
        nonWesternVariantFactory.getSofa().executeSofa();

        AbstractFactory westernVariantFactory = FactoryMgr.getWesternVariantFactory();

        westernVariantFactory.getChair().executeChair();
        westernVariantFactory.getTable().executeTable();
        westernVariantFactory.getSofa().executeSofa();
    }
}
