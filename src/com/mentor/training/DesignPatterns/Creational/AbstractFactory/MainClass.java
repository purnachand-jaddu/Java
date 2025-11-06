package com.mentor.training.designpatterns.creational.abstractfactory;

import com.mentor.training.designpatterns.creational.abstractfactory.factories.AbstractFactory;
import com.mentor.training.designpatterns.creational.abstractfactory.factories.FactoryMgr;

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
