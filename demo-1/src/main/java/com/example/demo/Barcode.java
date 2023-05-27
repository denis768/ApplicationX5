package com.example.demo;

import java.util.TreeMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class Barcode {
	private long barcode;
    private String quantity;
    static TreeMap<Long, String> products = new TreeMap<>();
    static {
        products.put(9556091108145l, "Молоко, упаковка TetraPak, класс экологичности 3");
        products.put(9785090795845l, "Шоколад, упаковка Бумага, класс экологичности 5");
    }

    @RequestMapping("/send")
    public Boolean send(@RequestParam Long barcode, @RequestParam String quantity) {
        products.put(barcode, quantity);
        System.out.println(barcode);
        return true;
    }

    // Запрос информации о продукте
    @RequestMapping("/get")
    public ResponseEntity<Barcode> getProduct(@RequestParam Long barcode) {
        if (products.containsKey(barcode)) {
            Barcode product = new Barcode();
            product.setBarcode(barcode);
            product.setQuantity(products.get(barcode));
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}