package com.company;

import java.net.*;
import java.io.*;

public class ServerThread extends Thread{

    Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run(){
        try{
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());


            String message = "";
            while( (message = (String)inputStream.readObject()) != null ){
                System.out.println(message);

            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

