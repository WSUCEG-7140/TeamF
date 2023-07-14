package WrightFlightManager.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class PassengerViewtoGUI extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2;
    Container con;

    PassengerViewtoGUI()
    {
        super("Passenger View");
        setSize(500,540);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        con = getContentPane();

        l1 = new JLabel("Passenger ID:");
        l2 = new JLabel("Passenger Name:");
        l3 = new JLabel("Passport No:");
        l4 = new JLabel("Flight No:");
        l5 = new JLabel("Age:");
        l6 = new JLabel("Seat No:");

        t1 = new JTextField("");
        t2 = new JTextField("");
        t3 = new JTextField("");
        t4 = new JTextField("");
        t5 = new JTextField("");
        t6 = new JTextField("");

        b1 = new JButton("Add");
        b2 = new JButton("Cancel");

        l1.setBounds(50,50,150,20);
        l2.setBounds(50,100,150,20);
        l3.setBounds(50,150,150,20);
        l4.setBounds(50,200,150,20);
        l5.setBounds(50,250,150,20);
        l6.setBounds(50,300,150,20);

        t1.setBounds(250,50,150,20);
        t2.setBounds(250,100,150,20);
        t3.setBounds(250,150,150,20);
        t4.setBounds(250,200,150,20);
        t5.setBounds(250,250,150,20);
        t6.setBounds(250,300,150,20);

        b1.setBounds(200,400,80,30);
        b2.setBounds(300,400,80,30);

        con.add(l1);
        con.add(l2);
        con.add(l3);
        con.add(l4);
        con.add(l5);
        con.add(l6);

        con.add(t1);
        con.add(t2);
        con.add(t3);
        con.add(t4);
        con.add(t5);
        con.add(t6);

        con.add(b1);
        con.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {

        if(ae.getSource().equals(b1))
        {
            //apply insert command
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            JOptionPane.showMessageDialog(null,"Passenger added successfully");
        }

        if(ae.getSource().equals(b2))
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
        }
    }
}
