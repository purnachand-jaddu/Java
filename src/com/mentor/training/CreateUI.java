package com.mentor.training;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CreateUI {
    public static void setUp() {
        JFrame frame =new JFrame("First frame");
        JPanel panel =new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel label=new JLabel("First Label");
        JButton button=new JButton("First Button");
        panel.add(label);
        panel.add(button);
        button.addMouseListener(createMouseListner());
        frame.add(panel);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    private static MouseListener createMouseListner() {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("3");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("1");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("2");
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
    }
}
