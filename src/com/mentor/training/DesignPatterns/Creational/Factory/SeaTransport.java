package com.mentor.training.DesignPatterns.Creational.Factory;

public class SeaTransport extends Transport
{
    @Override
    public Vehicle createVehicle()
    {
        return new Ship();
    }
}
