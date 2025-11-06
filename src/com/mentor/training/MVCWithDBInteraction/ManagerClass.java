package com.mentor.training.mvcwithdbinteraction;

public class ManagerClass
{
    public static void main(String[] args)
    {
        InteractWithDB interactWithDBObject=new InteractWithDB();
        View view = new View(interactWithDBObject);
        view.createAndDisplay();
    }
}
