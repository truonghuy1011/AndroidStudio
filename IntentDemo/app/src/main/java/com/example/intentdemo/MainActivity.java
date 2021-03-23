package com.example.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.model.SinhVien;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void xuliGuitructiep(View view) {
        Intent intent=new Intent(MainActivity.this,Sub1Activity.class);
        intent.putExtra("a",8);
        intent.putExtra("b",6.8);
        intent.putExtra("c",true);
        intent.putExtra("d","Welcome UTC2");

        SinhVien sv=new SinhVien(1,"Hiep Nguyen","9999999999");
        intent.putExtra("e",sv);

        startActivity(intent);
    }

    public void xuliBundle(View view) {
        Intent intent=new Intent(MainActivity.this,Sub2Activity2.class);

        Bundle bundle=new Bundle();
        bundle.putInt("a",8);
        bundle.putDouble("b",6.8);
        bundle.putBoolean("c",true);
        bundle.putString("d","Welcome UTC2");

        SinhVien sv=new SinhVien(2,"James","0999999999");
        bundle.putSerializable("e",sv);

        intent.putExtra("myBundle",bundle);

        startActivity(intent);

    }
}
