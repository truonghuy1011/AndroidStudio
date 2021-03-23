package com.example.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.model.SinhVien;

public class Sub1Activity extends AppCompatActivity {
    TextView txtHienThi;
    int a;
    double b;
    boolean c;
    String d;
    SinhVien e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);
        addViews();
        getData();
        showData();
    }

    private void showData() {
        txtHienThi.setText("");
        txtHienThi.append("a="+ a +"\n");
        txtHienThi.append("b="+ b +"\n");
        txtHienThi.append("c="+ c +"\n");
        txtHienThi.append("d="+ d +"\n");
        txtHienThi.append("e="+ e);
    }

    private void getData() {
        Intent intent=getIntent();
         a=intent.getIntExtra("a",0);
         b=intent.getDoubleExtra("b",0.0);
         c=intent.getBooleanExtra("c",false);
         d=intent.getStringExtra("d");

         e=(SinhVien) intent.getSerializableExtra("e");

    }

    private void addViews() {
         txtHienThi=findViewById(R.id.txtHienThi);
//
//        Intent intent=getIntent();
//        int a=intent.getIntExtra("a",0);
//        double b=intent.getDoubleExtra("b",0.0);
//        boolean c=intent.getBooleanExtra("c",false);
//        String d=intent.getStringExtra("d");
//
//        SinhVien e=(SinhVien) intent.getSerializableExtra("e");
//
//        txtHienThi.setText("");
//        txtHienThi.append("a="+ a +"\n");
//        txtHienThi.append("b="+ b +"\n");
//        txtHienThi.append("c="+ c +"\n");
//        txtHienThi.append("d="+ d +"\n");
//        txtHienThi.append("e="+ e);
    }
}
