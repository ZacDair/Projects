package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerGui extends JFrame{
    private JTable playerstable;
    private JButton createPlayer;
    private JButton insertButton;
    private JButton deleteButton;
    private JButton back;
    private JTextField usernametext;
    private JTextField idtochange;
    private JRadioButton euRadioButton;
    private JRadioButton ASIARadioButton;
    private JRadioButton SARadioButton;
    private JRadioButton naRadioButton;
    private JPanel playerPanel;
    private JTextField PasswordText;
    private JButton inputDataButton;
    private String region = "EU";
    private String username = "N/A";
    private String password = "N/A";
    private String id;
    private String[] columnNames = {"Username","Password","Region","ID"};
    private String[] data = {username,password,region,id};


    public PlayerGui(){

        add(playerPanel);
        setTitle("Player Database");
        setSize(500,500);

        createPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Player p = new Player(username, password, region);
                    id = ""+p.getID();
                System.out.println(username+" "+password+" "+region);
            }
        });
        inputDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username = usernametext.getText();
                password = PasswordText.getText();
                if (euRadioButton.isSelected()){
                    region = "EU";
                }
                if (ASIARadioButton.isSelected()){
                    region = "ASIA";
                }
                if (SARadioButton.isSelected()){
                    region = "SA";
                }
                else{
                    region = "NA";
                }
            }
            public String getUsername(){
                return username;
            }
            public String getPassword(){
                return password;
            }
            public String getRegionInt(){
                return region;
            }
        });

    }
}
