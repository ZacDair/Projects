package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myGui extends JFrame{

    private JPanel rootPanel;
    private JTextField textField1;
    private JButton input;
    private JLabel log;
    private JButton playerButton;
    private String text;
    private boolean inputted;
    public myGui(){
        add(rootPanel);
        setTitle("Databases");
        setSize(500,500);




        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = textField1.getText();
            }
        });
        playerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerGui pgui = new PlayerGui();
                pgui.setVisible(true);
            }
        });
    }
    public String getText(){
        return text;
    }
}

