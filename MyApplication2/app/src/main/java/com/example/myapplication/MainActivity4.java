package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.TreeMap;

public class MainActivity4 extends Activity {
    private EditText barcodeEditText, quantityEditText;
    private Button addButton;
    private TreeMap<String, Integer> products = new TreeMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        barcodeEditText = (EditText) findViewById(R.id.barcodeEditText);
        quantityEditText = (EditText) findViewById(R.id.quantityEditText);
        addButton = (Button) findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получаем введенные значения штрих-кода и количества
                String barcode = quantityEditText.getText().toString();
                int quantity = Integer.parseInt(barcodeEditText.getText().toString());

                // Добавляем элемент в TreeMap
                products.put(barcode, quantity);

                // Выводим сообщение об успешном добавлении
                Toast.makeText(MainActivity4.this, "Штрих-код успешно добавлен!", Toast.LENGTH_SHORT).show();

                // Очищаем поля ввода
                barcodeEditText.setText("");
                quantityEditText.setText("");
            }
        });
    }
}