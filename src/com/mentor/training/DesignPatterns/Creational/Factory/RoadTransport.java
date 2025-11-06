package com.mentor.training.designpatterns.creational.factory;

public class RoadTransport extends Transport
{
    @Override
    public Vehicle createVehicle()
    {
        return new Car();
    }
}
