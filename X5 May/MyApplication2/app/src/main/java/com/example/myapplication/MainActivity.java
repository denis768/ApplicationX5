package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextTextEmailAddress;
    EditText editTextTextPassword;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTextEmailAddress = (EditText) findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = (EditText) findViewById(R.id.editTextTextPassword);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        });

//        SharedPreferences sharedPreferences=("MyPrefs", MODE_PRIVATE);
//        String username=sharedPreferences.getString("username", "");
//        String password=sharedPreferences.getString("password", "");
//        if (username.equals(editTextTextEmailAddress)&&password.equals(editTextTextPassword){
//            Toast.makeText(this,"done", Toast.LENGTH_SHORT).show();
//        }
//        else{
//            Toast.makeText(this,"not", Toast.LENGTH_SHORT).show();
//        }
    }
}