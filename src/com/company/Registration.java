package com.company;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Registration extends JFrame {


    private JPanel header;
    private JLabel regist;
    private JPanel body;
    private JTextField loginfield;
    private JTextField namefield;
    private JPasswordField passfield;
    private JButton regbutton;

    private JTextField wrist;
    private JComboBox gender;
    private JTextField result;
    private JButton calc;
    private JPanel panel;



    public Registration() {

        DBManager manager=new DBManager();
        manager.connect();

        setTitle("Man Of Steel");
        setSize(600, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        header = new JPanel();
        Color myNewColor = new Color(46, 51, 72);
        header.setBackground(myNewColor);
        header.setBounds(0, 0, 600, 100);
        header.setLayout(null);

        regist = new JLabel("Registration");
        regist.setFont(new Font("French Script MT", Font.BOLD, 70));
        regist.setForeground(Color.WHITE);
        regist.setBounds(150, 20, 340, 80);
        header.add(regist);

        body = new JPanel();
        body.setBounds(20, 120, 350, 200);
        body.setLayout(new GridLayout(4, 1));

        TitledBorder login;
        login = BorderFactory.createTitledBorder("Login");
        TitledBorder pass;
        pass = BorderFactory.createTitledBorder("Password");
        TitledBorder name;
        name = BorderFactory.createTitledBorder("Name");

        namefield=new JTextField();
        namefield.setBounds(0, 50, 300, 20);
        namefield.setBorder(name);

        loginfield = new JTextField();
        loginfield.setBounds(0, 50, 300, 20);
        loginfield.setBorder(login);

        passfield = new JPasswordField();
        passfield.setEchoChar('*');
        passfield.setSize(300, 20);
        passfield.setBorder(pass);

        regbutton = new JButton("Registrate");
        regbutton.setFont(new Font("French Script MT", Font.BOLD, 20));
        regbutton.setBounds(410,376,140, 43);
        regbutton.setForeground(Color.WHITE);
        regbutton.setBackground(myNewColor);
        regbutton.setLayout(null);
        regbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String n=namefield.getText();
                String l=loginfield.getText();
                String p= String.valueOf(passfield.getPassword());
                String t=result.getText();

                User user=new User(null,n,l,p,t);
                manager.addUserToDB(user);


                setVisible(false);
                MainFrame m= new MainFrame();
                m.setVisible(true);
            }
        });

        panel = new JPanel();
        panel.setBounds(20,270,200,150);
        BoxLayout layout2 = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout2);

        wrist=new JTextField();
        wrist.setBorder(BorderFactory.createTitledBorder("Wrist girth"));
        wrist.setAlignmentX(Component.CENTER_ALIGNMENT);

        String[] gen={"Man","Woman"};
        gender=new JComboBox(gen);
        gender.setBorder(BorderFactory.createTitledBorder("Gender"));
        gender.setAlignmentX(Component.CENTER_ALIGNMENT);

        result=new JTextField();
        result.setBorder(BorderFactory.createTitledBorder("Result"));
        result.setAlignmentX(Component.CENTER_ALIGNMENT);

        calc = new JButton("Calculate");
        calc.setFont(new Font("French Script MT", Font.BOLD, 20));
        calc.setBounds(230,376,140, 43);
        calc.setForeground(Color.WHITE);

        calc.setBackground(myNewColor);
        calc.setLayout(null);
        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(gender.getSelectedItem().equals("Man")){
                    Man m=new Man();
                    int n=Integer.parseInt(wrist.getText());
                    result.setText(m.calctype(n));
                }
                else if(gender.getSelectedItem().equals("Woman")){
                    Woman w=new Woman();
                    int n=Integer.parseInt(wrist.getText());
                    result.setText(w.calctype(n));

                }
            }
        });
        //calc.setAlignmentX(Component.CENTER_ALIGNMENT);

        body.add(namefield);
        body.add(loginfield);
        body.add(passfield);

        add(regbutton);
        panel.add(gender);
        panel.add(wrist);

        panel.add(result);

        add(calc);
        add(panel);
        add(header);
        add(body);





    }
}
