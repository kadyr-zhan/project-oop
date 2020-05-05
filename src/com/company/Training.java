package com.company;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Training extends JFrame {
    private JPanel header;
    private JLabel training;
    private JPanel bodyleft;
    private JButton arms;
    private JButton legs;
    private JButton abc;
    private JButton nutrition;
    private JTextArea text;
    private JButton comment;

    public Training(){

        DBManager manager=new DBManager();
        manager.connect();

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

        training = new JLabel("Training");
        training.setFont(new Font("French Script MT", Font.BOLD, 70));
        training.setForeground(Color.WHITE);
        training.setBounds(190, 20, 300, 80);
        header.add(training);

        bodyleft = new JPanel();
        bodyleft.setBounds(50,150,200,200);
        BoxLayout layout2 = new BoxLayout(bodyleft, BoxLayout.Y_AXIS);
        bodyleft.setLayout(layout2);

        arms=new JButton("Arms");
        arms.setFont(new Font("French Script MT", Font.BOLD, 20));
        arms.setBounds(220,310,150, 20);
        arms.setBackground(myNewColor);
        arms.setForeground(Color.WHITE);
        arms.setMaximumSize(new Dimension(Integer.MAX_VALUE, arms.getMinimumSize().height));
        arms.setAlignmentX(Component.CENTER_ALIGNMENT);
        arms.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<Main.users.size();i++){
                    String a="Arms";
                    String s=manager.BodyType(Main.users.get(0));
                    Main.users.get(0).setBodyType(s);
                    text.setText(manager.train(Main.users.get(0),a));
                }
            }
        });

        abc=new JButton("ABS");
        abc.setFont(new Font("French Script MT", Font.BOLD, 20));
        abc.setBounds(220,310,150, 20);
        abc.setBackground(myNewColor);
        abc.setForeground(Color.WHITE);
        abc.setMaximumSize(new Dimension(Integer.MAX_VALUE, abc.getMinimumSize().height));
        abc.setAlignmentX(Component.CENTER_ALIGNMENT);
        abc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a="ABS";
                String s=manager.BodyType(Main.users.get(0));
                Main.users.get(0).setBodyType(s);
                text.setText(manager.train(Main.users.get(0),a));
            }
        });

        legs=new JButton("Legs");
        legs.setFont(new Font("French Script MT", Font.BOLD, 20));
        legs.setBounds(220,310,150, 20);
        legs.setBackground(myNewColor);
        legs.setForeground(Color.WHITE);
        legs.setMaximumSize(new Dimension(Integer.MAX_VALUE, legs.getMinimumSize().height));
        legs.setAlignmentX(Component.CENTER_ALIGNMENT);
        legs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a="Legs";
                String s=manager.BodyType(Main.users.get(0));
                Main.users.get(0).setBodyType(s);
                text.setText(manager.train(Main.users.get(0),a));
            }
        });

        nutrition=new JButton("Nutrition");
        nutrition.setFont(new Font("French Script MT", Font.BOLD, 20));
        nutrition.setBounds(220,310,150, 20);
        nutrition.setBackground(myNewColor);
        nutrition.setForeground(Color.WHITE);
        nutrition.setMaximumSize(new Dimension(Integer.MAX_VALUE, nutrition.getMinimumSize().height));
        nutrition.setAlignmentX(Component.CENTER_ALIGNMENT);
        nutrition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s=manager.BodyType(Main.users.get(0));
                Main.users.get(0).setBodyType(s);
                text.setText(manager.nutrition(Main.users.get(0)));
            }
        });


        text=new JTextArea();
        //text.setBounds(300,130,250,300);
        text.setLayout(null);
        JScrollPane scroll=new JScrollPane(text,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(300,130,250,300);

        comment=new JButton("Comment");
        comment.setFont(new Font("French Script MT", Font.BOLD, 20));
        comment.setLayout(null);
        comment.setBounds(450,440,100, 40);
        comment.setBackground(myNewColor);
        comment.setForeground(Color.WHITE);
        comment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Comment c=new Comment();
                c.setVisible(true);
            }
        });



        bodyleft.add(arms);
        bodyleft.add(Box.createVerticalGlue());
        bodyleft.add(abc);
        bodyleft.add(Box.createVerticalGlue());
        bodyleft.add(legs);
        bodyleft.add(Box.createVerticalGlue());
        bodyleft.add(nutrition);

        add(comment);
        add(header);
        add(bodyleft);
        //add(text);
        add(scroll);


    }

}
