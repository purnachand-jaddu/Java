package com.mentor.training;

import javax.swing.*;
import java.awt.*;

public class MyComboBox extends JComboBox<String>
{
    public static MyComboBox comboBox=new MyComboBox();

    public static void main(String[] args) throws InterruptedException
    {
        Frame frame = new Frame();
        frame.setSize(600,600);
        Panel panel=new Panel();
        panel.add(comboBox);
        comboBox.setPrototypeDisplayValue("XXXXXXXXXX");
        comboBox.addItem("sampleItem");
        frame.add(panel);
        frame.setVisible(true);
        Thread.sleep(5000);
        frame.setVisible(false);
    }
}
