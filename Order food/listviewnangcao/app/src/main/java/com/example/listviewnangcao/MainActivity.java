package com.example.listviewnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adapter.sanphamadapter;
import com.example.model.sanpham;

public class MainActivity extends AppCompatActivity {
    ListView lvsapha;
    ArrayAdapter<sanpham> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
        addEvent();
    }

    private void addEvent() {
        lvsapha.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sanpham sp = arrayAdapter.getItem(position);
                Toast.makeText(MainActivity.this,sp.getTen(),Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addView() {
        lvsapha = findViewById(R.id.lvsanpham);
        arrayAdapter = new sanphamadapter(MainActivity.this,R.layout.itemlist);
        arrayAdapter.add( new sanpham(R.drawable.coffe,"Cà phê",14000));
        arrayAdapter.add( new sanpham(R.drawable.mustache,"Trà",15000));
        arrayAdapter.add( new sanpham(R.drawable.aa,"Trà chanh",14000));
        arrayAdapter.add( new sanpham(R.drawable.bbb,"Đá xay",14000));
        arrayAdapter.add( new sanpham(R.drawable.ccc,"Trà sữa",14000));
        arrayAdapter.add( new sanpham(R.drawable.ddd,"Trà xanh",14000));
        lvsapha.setAdapter(arrayAdapter);
    }
}
