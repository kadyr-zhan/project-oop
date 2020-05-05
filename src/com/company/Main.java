package com.company;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.LayoutManager;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Main {

    public static ArrayList<User> users=new ArrayList<>();

    public static void main(String[] args) {

        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);

        try{
            ServerSocket server = new ServerSocket(6001);

            while(true){
                System.out.println("Wait...");
                Socket socket = server.accept();
                System.out.println("Client connected");

                ServerThread parallelSocket = new ServerThread(socket);
                parallelSocket.start();
            }
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
