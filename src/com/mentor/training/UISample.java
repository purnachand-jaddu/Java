package com.mentor.training;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class UISample {
    private JButton okButton=new JButton();
    private JButton cancelButton =new JButton();
    private JButton helpButton=new JButton();
    private JPanel okCancelPanel=new JPanel();
    private JPanel helpPanel=new JPanel();
    private JFrame frame=new JFrame();
    private JPanel mainPanel =new JPanel();

    public UISample()
    {

    }

    public UISample(JFrame frame)
    {
        this.frame=frame;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public JButton getOkButton() {
        return okButton;
    }

    public JButton getHelpButton() {
        return helpButton;
    }

    public void init() {
        getOkButton().setName("OK");
        getCancelButton().setName("CANCEL");
        getHelpButton().setName("HELP");

        getOkButton().setText("Ok");
        getCancelButton().setText("Cancel");
        getHelpButton().setText("Help");

        JTextField textField=new JTextField();
        textField.setColumns(12);

        okCancelPanel.add(okButton);
        okCancelPanel.add(cancelButton);
        okCancelPanel.add(textField);

        FocusListener listener=new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textField.setText("Hii!!!");
            }

            @Override
            public void focusLost(FocusEvent e) {
                textField.setText("lol");
            }
        };

        ActionListener okActionListener= e -> textField.setText("kksn");
        ActionListener cancelListener = e-> textField.setText("");

        getOkButton().addActionListener(okActionListener);
        getCancelButton().addActionListener(cancelListener);

        helpPanel.add(helpButton);
        mainPanel.add(okCancelPanel);
        mainPanel.add(helpPanel);
        frame.add(mainPanel);
    }

    public JFrame getFrame() {
        return frame;
    }
}
