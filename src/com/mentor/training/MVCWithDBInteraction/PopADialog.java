package com.mentor.training.mvcwithdbinteraction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PopADialog extends JDialog implements KeyListener
{
    private JButton okButton;

    public PopADialog(String name)
    {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(new JLabel(name), gbc);
        gbc.gridy = 1;
        okButton = new JButton("Ok");
        mainPanel.add(okButton, gbc);
        okButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                dispose();
            }
        });
        okButton.addKeyListener(this);
        add(mainPanel);
        setTitle("Information");
        setMinimumSize(new Dimension(600, 200));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JButton getOkButton()
    {
        return okButton;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            dispose();
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
    }
}
