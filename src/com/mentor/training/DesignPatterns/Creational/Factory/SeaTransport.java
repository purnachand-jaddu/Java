package com.mentor.training.designpatterns.creational.factory;

public class SeaTransport extends Transport
{
    @Override
    public Vehicle createVehicle()
    {
        return new Ship();
    }
}
