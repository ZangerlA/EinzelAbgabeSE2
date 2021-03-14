package com.example.einzelabgabe_se2_zangerl;

import android.app.Activity;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import android.view.View;
import android.widget.TextView;

public class TCPClient extends Activity implements Runnable  {

    private String message;
    private String answer;
    private TextView view;

    public TCPClient(String message, TextView view){
        this.message = message;
        this.view = view;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket("se2-isys.aau.at", 53212);
            DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outToServer.writeBytes(message +"\n");
            this.answer = inFromServer.readLine();
            runOnUiThread(() -> view.setText(answer));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
