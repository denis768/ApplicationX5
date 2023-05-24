package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends Activity {
    private EditText barcodeEditText, quantityEditText;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MainActivity2 mainActivity2=new MainActivity2();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        barcodeEditText = (EditText) findViewById(R.id.barcodeEditText);
        quantityEditText = (EditText) findViewById(R.id.quantityEditText);
        addButton = (Button) findViewById(R.id.addButton);
        barcodeEditText.setText(getIntent().getStringExtra("barcode"));

        addButton.setOnClickListener(v -> {
            MainActivity2 mainActivity21 =new MainActivity2();
            Data data=new Data();
            // Получаем введенные значения штрих-кода и качества
            long barcode = Long.parseLong(barcodeEditText.getText().toString());
            String quantity = quantityEditText.getText().toString();

            // Добавляем элемент в TreeMap
            Data.products.put(barcode, quantity);
            data.addProduct(barcode,quantity);

            // Выводим сообщение об успешном добавлении
            Toast.makeText(MainActivity4.this, "Штрих-код успешно добавлен!", Toast.LENGTH_SHORT).show();

            // Очищаем поля ввода
            barcodeEditText.setText("");
            quantityEditText.setText("");
            finish();
        });
    }
}