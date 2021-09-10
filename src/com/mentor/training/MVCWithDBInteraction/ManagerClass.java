package com.mentor.training.MVCWithDBInteraction;

public class ManagerClass
{
    public static void main(String[] args)
    {
        InteractWithDB interactWithDBObject=new InteractWithDB();
        View view = new View(interactWithDBObject);
        view.createAndDisplay();
    }
}
