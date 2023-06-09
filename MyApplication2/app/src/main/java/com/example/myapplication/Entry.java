package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Entry extends Activity {

    EditText editTextTextEmailAddress;
    EditText editTextTextPassword;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry);
        editTextTextEmailAddress = (EditText) findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = (EditText) findViewById(R.id.editTextTextPassword);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}