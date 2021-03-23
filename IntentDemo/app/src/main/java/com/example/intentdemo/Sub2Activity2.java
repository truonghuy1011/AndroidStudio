package com.example.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.model.SinhVien;

public class Sub2Activity2 extends AppCompatActivity {
    TextView txtHienThi;
    int a;
    double b;
    boolean c;
    String d;
    SinhVien e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub22);
        addViews();
        getDataBundle();
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

    private void getDataBundle() {
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("myBundle");
        a=bundle.getInt("a",0);
        b=bundle.getDouble("b",0.0);
        c=bundle.getBoolean("c",false);
        d=bundle.getString("d");
        e=(SinhVien) bundle.getSerializable("e");

    }

    private void addViews() {
        txtHienThi=findViewById(R.id.txtHienThi);

    }
}
