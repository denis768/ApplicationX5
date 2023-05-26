package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddBarcode extends Activity {
    private EditText barcodeEditText, quantityEditText;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_barcode);

        barcodeEditText = (EditText) findViewById(R.id.barcodeEditText);
        quantityEditText = (EditText) findViewById(R.id.quantityEditText);
        addButton = (Button) findViewById(R.id.addButton);
        barcodeEditText.setText(getIntent().getStringExtra("barcode"));

        addButton.setOnClickListener(v -> {
            Data data = new Data();
            // Получаем введенные значения штрих-кода и качества
            long barcode = Long.parseLong(barcodeEditText.getText().toString());
            String quantity = quantityEditText.getText().toString();

            // Добавляем элемент в TreeMap
            data.addProduct(barcode, quantity, AddBarcode.this);

            // Выводим сообщение об успешном добавлении
            Toast.makeText(AddBarcode.this, "Штрих-код успешно добавлен!", Toast.LENGTH_SHORT).show();

            // Очищаем поля ввода
            barcodeEditText.setText("");
            quantityEditText.setText("");
            finish();
        });
    }
}