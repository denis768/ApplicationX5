package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    Button scanBtn;
    TextView messageText, messageFormat;
    Button AddBtn;
    boolean f_is;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        scanBtn = findViewById(R.id.Scan);
        messageText = findViewById(R.id.Content);
        messageFormat = findViewById(R.id.Format);
        AddBtn = findViewById(R.id.AddBtn);

        scanBtn.setOnClickListener(this);
        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> list = new ArrayList<>();
                list.add("1234567890");
                list.add("0987654321");
                list.add("7554546779");
                list.add("9556091108145");
                f_is = list.contains(messageText);
                if (list.contains(messageText)) {
                    Toast.makeText(MainActivity2.this, "true", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity2.this, "false", Toast.LENGTH_SHORT).show();
                }
            }
//            public int linearSearch(int[] array, int elementToSearch) {
//                for (int i = 0; i < array.length; i++) {
//                    if (array[i] == elementToSearch) {
//                        return i;
//                    }
//                }
//                return -1;
//            }
        });
    }

    @Override
    public void onClick(View v) {
        IntentIntegrator intentIntegrator = new IntentIntegrator(this);
        intentIntegrator.setPrompt("Наведите камеру на QR или штрих код");
//        intentIntegrator.setOrientationLocked(true);
        intentIntegrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (intentResult != null) {
            if (intentResult.getContents() == null) {
                Toast.makeText(getBaseContext(), "Exit", Toast.LENGTH_SHORT).show();
            } else {
                messageText.setText(intentResult.getContents());
                messageFormat.setText(intentResult.getFormatName());

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
