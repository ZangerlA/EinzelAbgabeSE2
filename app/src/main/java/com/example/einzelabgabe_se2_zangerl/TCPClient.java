package com.example.einzelabgabe_se2_zangerl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient implements Runnable {

    private String message;
    private String answer;

    public TCPClient(String message){
        this.message = message;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket("se2-isys.aau.at", 53212);
            DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outToServer.writeBytes(message);
            this.answer = inFromServer.readLine();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getAnswer() {
        return this.answer;
    }
}
