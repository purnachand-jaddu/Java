package com.mentor.training.DesignPatterns.Creational.Factory;

public abstract class Transport
{
    private Vehicle mVehicle;

    public void createAndSetVehicle()
    {
        mVehicle=createVehicle();
    }

    protected abstract Vehicle createVehicle();

    public void deliverLoad(String s)
    {
        mVehicle.deliver(s);
    }

}
