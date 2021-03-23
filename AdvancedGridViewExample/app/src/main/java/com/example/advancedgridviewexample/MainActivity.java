package com.example.advancedgridviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adapter.SanPhamAdapter;
import com.example.model.SanPham;

public class MainActivity extends AppCompatActivity {

    GridView gvSanPham;
    SanPhamAdapter sanPhamAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        addEvents();
    }

    private void addViews() {
        gvSanPham = findViewById(R.id.gvSanPham);
        sanPhamAdapter = new SanPhamAdapter(MainActivity.this, R.layout.item);
        sanPhamAdapter.add(new SanPham(R.drawable.saigon, "Sài Gòn"));
        sanPhamAdapter.add(new SanPham(R.drawable.hanoi, "Hà Nội"));
        sanPhamAdapter.add(new SanPham(R.drawable.tiger, "Tiger"));
        sanPhamAdapter.add(new SanPham(R.drawable.heineken, "Heineken"));
        sanPhamAdapter.add(new SanPham(R.drawable.beer333, "Bia 333"));
        sanPhamAdapter.add(new SanPham(R.drawable.sapporo, "Sapporo"));
        sanPhamAdapter.add(new SanPham(R.drawable.larue, "Larue"));
        gvSanPham.setAdapter(sanPhamAdapter);
    }

    private void addEvents() {
        gvSanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SanPham sp = sanPhamAdapter.getItem(i);
                showDetail(sp);
            }
        });
    }

    private void showDetail(SanPham sp) {
        setContentView(R.layout.single_item);
        TextView txtTen = findViewById(R.id.txtTenSP);
        ImageView imgHinh = findViewById(R.id.imgHinh);
        Button btnBack = findViewById(R.id.btnBack);
        txtTen.setText(sp.getTen());
        imgHinh.setImageResource(sp.getHinh());
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_main);
                addViews();
                addEvents();
            }
        });
    }


}
