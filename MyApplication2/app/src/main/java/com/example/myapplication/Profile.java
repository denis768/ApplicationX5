package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class Profile extends Activity {

    Switch switch1;
    Button button2;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        switch1 = (Switch) findViewById(R.id.switch1);
        button2 = (Button) findViewById(R.id.button2);
        textView3 = (TextView) findViewById(R.id.textView3);
    }
}