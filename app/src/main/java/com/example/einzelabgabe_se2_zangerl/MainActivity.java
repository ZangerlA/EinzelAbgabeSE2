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
            TextView view = findViewById(R.id.outputField);
            TCPClient client = new TCPClient(text.getText().toString(), view);
            new Thread(client).start();
        });

    }
}