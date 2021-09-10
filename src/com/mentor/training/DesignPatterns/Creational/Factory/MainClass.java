package com.mentor.training.DesignPatterns.Creational.Factory;

public class MainClass
{
    public static void main(String[] args)
    {
        Transport seaTransport =new SeaTransport();
        seaTransport.createAndSetVehicle();
        seaTransport.deliverLoad("this is sea transport");

        Transport roadTransport=new RoadTransport();
        roadTransport.createAndSetVehicle();
        roadTransport.deliverLoad("this is road transport");
    }
}
