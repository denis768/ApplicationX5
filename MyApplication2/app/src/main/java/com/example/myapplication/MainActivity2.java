package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.TreeMap;

public class MainActivity2 extends Activity implements View.OnClickListener {
    public String text;
    Button scanBtn;
    TextView messageText, messageFormat;
    static Button AddBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        scanBtn = findViewById(R.id.Scan);
        messageText = findViewById(R.id.Content);
        messageFormat = findViewById(R.id.Format);
        AddBtn = findViewById(R.id.AddBtn);

        scanBtn.setOnClickListener(this);
        AddBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity4.class);
            intent.putExtra("barcode", messageFormat.getText().toString());
            startActivity(intent);
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
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (intentResult != null) {
            if (intentResult.getContents() == null) {
                Toast.makeText(getBaseContext(), "Exit", Toast.LENGTH_SHORT).show();
            } else {
                messageFormat.setText(intentResult.getContents());
                text = messageFormat.getText().toString();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
        if (Data.products.containsKey(Long.parseLong(text))){
            AddBtn.setVisibility(View.INVISIBLE);
            messageText.setText(Data.products.get(Long.parseLong(text)));
            Toast.makeText(this, "Товар найден, смотри описание", Toast.LENGTH_LONG).show();
        }else {
            AddBtn.setVisibility(View.VISIBLE);
            messageText.setText(null);
            Toast.makeText(this, "Товар не найден вы можете его добавить", Toast.LENGTH_LONG).show();
        }
    }
}
