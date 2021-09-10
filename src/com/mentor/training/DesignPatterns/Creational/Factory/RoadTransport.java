package com.mentor.training.DesignPatterns.Creational.Factory;

public class RoadTransport extends Transport
{
    @Override
    public Vehicle createVehicle()
    {
        return new Car();
    }
}
