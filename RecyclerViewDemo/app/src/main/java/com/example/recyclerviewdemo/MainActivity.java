package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.adapter.SanPhamAdapter;
import com.example.model.SanPham;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
    }

    private void addViews() {
        recyclerView=findViewById(R.id.rcvFood);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
//        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,layoutManager.getOrientation());
//        recyclerView.addItemDecoration(dividerItemDecoration);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        Drawable drawable= ContextCompat.getDrawable(getApplicationContext(),R.drawable.custom_divider);
        dividerItemDecoration.setDrawable(drawable);
        recyclerView.addItemDecoration(dividerItemDecoration);

        ArrayList<SanPham> dsSP=new ArrayList<>();
        dsSP.add(new SanPham(R.drawable.cocacola,"Cocacola",15000));
        dsSP.add(new SanPham(R.drawable.donuts,"Bánh donuts",16000));
        dsSP.add(new SanPham(R.drawable.garan,"Gà rán",20000));
        dsSP.add(new SanPham(R.drawable.pizza,"Pizza",25000));
        dsSP.add(new SanPham(R.drawable.sinhto,"Sinh tố",35000));
        dsSP.add(new SanPham(R.drawable.spaghetti,"Spaghetti",45000));

        SanPhamAdapter sanPhamAdapter=new SanPhamAdapter(dsSP,getApplicationContext());
        recyclerView.setAdapter(sanPhamAdapter);
    }
}
