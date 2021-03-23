package com.example.ngay14_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showClickDrink(View view) {
        Intent intent=new Intent(MainActivity.this,ListViewcoban.class);
        startActivity(intent);
    }

    public void showClickFood(View view) {
        Intent intent=new Intent(MainActivity.this,Food.class);
        startActivity(intent);
    }

    public void showClickShop(View view) {
        Intent intent=new Intent(MainActivity.this,Shop.class);
        startActivity(intent);
    }


}
