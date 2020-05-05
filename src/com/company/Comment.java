package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class Comment extends JFrame {
    private JPanel header;
    private JLabel comment;
    private JButton send;
    private JTextArea text;
    private JButton back;

    private String message="";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Comment(){

        setTitle("Man Of Steel");
        setSize(600,530);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // BoxLayout layout2 = new BoxLayout(panel, BoxLayout.Y_AXIS);
        setLayout(null);

        header = new JPanel();
        Color myNewColor = new Color(46, 51, 72);
        header.setBackground(myNewColor);
        header.setBounds(0, 0, 600, 100);
        header.setLayout(null);

        comment = new JLabel("Comment");
        comment.setFont(new Font("French Script MT", Font.BOLD, 70));
        comment.setForeground(Color.WHITE);
        comment.setBounds(190, 20, 300, 80);
        header.add(comment);

        text=new JTextArea();
        text.setBounds(100,130,400,300);
        text.setLayout(null);



        send=new JButton("Send");
        send.setFont(new Font("French Script MT", Font.BOLD, 20));
        send.setLayout(null);
        send.setBounds(400,440,100, 40);
        send.setBackground(myNewColor);
        send.setForeground(Color.WHITE);
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               setMessage(text.getText());
                try{
                    Socket socket  = new Socket("192.168.8.101", 6001);
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    Date date = new Date();
                    outputStream.writeObject(" at "+date+": "+getMessage());
                }catch(Exception b){
                    b.printStackTrace();
                }
                JOptionPane.showMessageDialog(null,"Your review has been sent succesfully");
                text.setText("");
            }
        });

        back=new JButton("Back");
        back.setFont(new Font("French Script MT", Font.BOLD, 20));
        back.setLayout(null);
        back.setBounds(100,440,100, 40);
        back.setBackground(myNewColor);
        back.setForeground(Color.WHITE);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Training t=new Training();
                t.setVisible(true);

            }
        });

        add(header);
        add(text);
        add(back);
        add(send);



    }}
