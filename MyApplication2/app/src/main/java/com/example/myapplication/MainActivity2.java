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
    public TreeMap<Integer, String> products = new TreeMap<>();
    Button scanBtn;
    TextView messageText, messageFormat;
    Button AddBtn;

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
            startActivity(intent);
        });
//        Set<Map.Entry<Integer, String>> set = products.entrySet();
//        // Итерируем по каждому элементу
//        for (Map.Entry<Integer, String> entry : set) {
//            int barcode = entry.getKey();
//            String quantity = entry.getValue();
//            System.out.println("Штрих-код: " + barcode + ", Количество: " + quantity);
//        }
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
                messageFormat.setText(intentResult.getContents());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    // Добавление элементов в TreeMap
    public void addProduct(int barcode, String quantity) {
        products.put(barcode, quantity);
    }

    // Получение элементов из TreeMap
    public TreeMap<Integer, String> getProducts() {
        return products;
    }


}
