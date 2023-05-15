package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity3 extends Activity {

    Switch switch1;
    Button button2;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        switch1 = (Switch) findViewById(R.id.switch1);
        button2 = (Button) findViewById(R.id.button2);
        textView3 = (TextView) findViewById(R.id.textView3);
    }
}