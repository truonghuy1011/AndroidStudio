package com.example.baitapmot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.Shopping;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void douong(View view) {
        Intent intent = new Intent(MainActivity.this,listofdrinks.class);
        startActivity(intent);
    }

    public void doan(View view) {
        Intent intent = new Intent(MainActivity.this,listoffood.class);
        startActivity(intent);
    }

    public void sanpham(View view) {
        Intent intent = new Intent(MainActivity.this, Shopping.class);
        startActivity(intent);
    }
}
