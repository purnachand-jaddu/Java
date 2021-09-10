package com.mentor.training.MVCWithDBInteraction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

@SuppressWarnings("ALL")
public class View extends JFrame
{

    private JButton cancelButton;
    private JButton okButton;
    private JButton addButton;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel priceLabel;
    private JTextField priceTextField;
    private InteractWithDB interactWithDBObject;
    public JPanel tablePanel = null;

    public View(InteractWithDB interactWithDBObject)
    {
        this.interactWithDBObject = interactWithDBObject;
        setTitle("Add a user to DB");
    }


    public void createAndDisplay()
    {
        addTextFields();
        setSize(700, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addMouseListenerForAddButton();
        addMouseListeners();
    }

    public void refresh()
    {
        revalidate();
        repaint();
    }


    private void addMouseListenerForAddButton()
    {
        addButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {

//                tablePanel = new JPanel();
                JLabel label = new JLabel("label");
//                label.setSize(100,100);
//                tablePanel.add(label);
                add(label);
                revalidate();
                repaint();
            }
        });
    }

    private void addMouseListeners()
    {
        cancelButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                System.out.println("cancel clicked");
                try
                {
                    dispose();
                    interactWithDBObject.getConnection().close();
                }
                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
                finally
                {
                    System.out.println("Connection closed");
                }
            }
        });

        okButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                System.out.println("Mouse clicked");
                handleDBInteraction();
            }
        });

        nameTextField.addActionListener(e -> handleDBInteraction());

        priceTextField.addActionListener(e -> handleDBInteraction());
    }

    private void handleDBInteraction()
    {
        String nameText = nameTextField.getText().toLowerCase();
        String priceText = priceTextField.getText().toLowerCase();
        if (!nameText.isEmpty() && !priceText.isEmpty())
        {
            if (interactWithDBObject.hasUserAlready(nameText))
            {
                new PopADialog("Already a user with same name exists. Please enter a different one");
            }
            else
            {
                interactWithDBObject.addEntryToDB(nameText, priceText);
                new PopADialog("A new user has been created succesfully");
            }
        }
    }

    private void addTextFields()
    {
        JPanel mainPanel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        mainPanel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        nameLabel = new JLabel("Username");
        nameTextField = new JTextField(10);
        JPanel firstPanel = createPanelWithLabelAndTextField(nameLabel, nameTextField);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(firstPanel, gbc);

        priceLabel = new JLabel("Password");
        priceTextField = new JPasswordField(10);
        JPanel secondPanel = createPanelWithLabelAndTextField(priceLabel, priceTextField);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(2, 0, 10, 2);
        mainPanel.add(secondPanel, gbc);

        int x = 2;
//        tablePanel=new JPanel();
//        mainPanel.add(tablePanel, gbc);
//        x++;

        JPanel okCancelPanel = createOkCancelPanel();
        gbc.gridx = 0;
        gbc.gridy = x;
        mainPanel.add(okCancelPanel, gbc);

        add(mainPanel);
    }

    private JPanel createOkCancelPanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(1, 10, 1, 25);

        addButton = new JButton("Add");
        panel.add(addButton, gbc);

        gbc.gridx = 1;
        okButton = new JButton("Ok");
        panel.add(okButton, gbc);

        gbc.gridx = 2;
        cancelButton = new JButton("Cancel");
        panel.add(cancelButton, gbc);

        return panel;
    }

    private JPanel createPanelWithLabelAndTextField(JLabel label, JTextField textField)
    {
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.weightx = 1;
        gbc.weighty = 1;
        panel.add(label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(textField, gbc);
        return panel;
    }

}
