package com.company;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MainFrame extends JFrame {
    private JPanel header;
    private JLabel auth;
    private JPanel body;
    private JTextField loginfield;
    private JPasswordField passfield;
    private JButton enter;
    private JLabel regist;

    public MainFrame() {

        DBManager manager=new DBManager();
        manager.connect();

        setTitle("Man Of Steel");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        header = new JPanel();
        Color myNewColor = new Color(46, 51, 72);
        header.setBackground(myNewColor);
        header.setBounds(0, 0, 600, 100);
        header.setLayout(null);

        auth = new JLabel("Authorization");
        auth.setFont(new Font("French Script MT", Font.BOLD, 70));
        auth.setForeground(Color.WHITE);
        auth.setBounds(150, 20, 340, 80);
        header.add(auth);

        body = new JPanel();
        body.setBounds(200, 150, 200, 200);
        body.setLayout(new GridLayout(4, 1));

        TitledBorder login;
        login = BorderFactory.createTitledBorder("Login");
        TitledBorder pass;
        pass = BorderFactory.createTitledBorder("Password");

        loginfield = new JTextField();
        loginfield.setBounds(0, 50, 300, 20);
        loginfield.setBorder(login);

        passfield = new JPasswordField();
        passfield.setEchoChar('*');
        passfield.setSize(300, 20);
        passfield.setBorder(pass);

        enter = new JButton("Enter");
        enter.setFont(new Font("French Script MT", Font.BOLD, 20));
        enter.setSize(40, 20);
        enter.setForeground(Color.WHITE);
        enter.setBackground(myNewColor);
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            String l=loginfield.getText();
            String p= String.valueOf(passfield.getPassword());


            User user=new User(l,p);

            if(manager.login(user)){

                Main.users.add(new User(l,p));
                setVisible(false);
                Training t=new Training();
                t.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Incorrect login and password");
            }

            }
        });

        regist = new JLabel("Don't have an account?");
        regist.setFont(new Font("French Script MT", Font.ITALIC, 20));
        regist.setVerticalAlignment(JLabel.CENTER);
        regist.setHorizontalAlignment(JLabel.CENTER);
        regist.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                setVisible(false);
                Registration r= new Registration();
                r.setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                regist.setForeground(Color.RED);
                //regist.setFont(new Font("French Script MT", Font., 20));
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                regist.setForeground(Color.BLACK);
            }
        });


        body.add(loginfield);
        body.add(passfield);
        body.add(enter);
        body.add(regist);

        add(body);
        add(header);

    }
}

