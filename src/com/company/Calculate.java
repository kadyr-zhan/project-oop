package com.company;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculate extends JFrame {

    private JPanel header;
    private JTextField wrist;
    private JComboBox gender;
    private JTextField result;
    private JButton calc;
    private JButton train;
    private JPanel panel;
    private JLabel calculate;

    public Calculate(){


        setTitle("Man Of Steel");
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // BoxLayout layout2 = new BoxLayout(panel, BoxLayout.Y_AXIS);
        setLayout(null);

        header = new JPanel();
        Color myNewColor = new Color(46, 51, 72);
        header.setBackground(myNewColor);
        header.setBounds(0, 0, 600, 100);
        header.setLayout(null);

        calculate = new JLabel("Calculation");
        calculate.setFont(new Font("French Script MT", Font.BOLD, 70));
        calculate.setForeground(Color.WHITE);
        calculate.setBounds(170, 20, 300, 80);
        header.add(calculate);

        panel = new JPanel();
        panel.setBounds(200,150,200,150);
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
        calc.setBounds(220,310,150, 20);
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

        train= new JButton("Let's Train");
        train.setFont(new Font("French Script MT", Font.BOLD, 20));
        train.setBounds(220,340,150, 20);
        train.setForeground(Color.WHITE);
        train.setBackground(myNewColor);
        train.setLayout(null);
        //train.setAlignmentX(Component.CENTER_ALIGNMENT);
        train.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                Training t=new Training();
                t.setVisible(true);
            }
        });

        panel.add(gender);
        panel.add(wrist);

        panel.add(result);

        add(header);
        add(panel);
        add(calc);
        add(train);





    }
}
