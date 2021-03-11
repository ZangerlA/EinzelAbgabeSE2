package com.example.einzelabgabe_se2_zangerl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.sendButton);
        btn.setOnClickListener(v -> {
            EditText text = findViewById(R.id.inputFieldMatNr);
            TCPClient client = new TCPClient(text.getText().toString());
            new Thread(client).start();
        });

    }

    public void displayAnswer(String msg) {
        runOnUiThread(() -> {
            TextView view = findViewById(R.id.outputField);
            view.setText(msg);
        });
    }
}