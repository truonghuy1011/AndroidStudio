package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.baitapmot.R;
import com.example.model.SanPham;

public class Shopping extends AppCompatActivity {
Button mua;
EditText ten,mau;
ListView lvSanPham;
ArrayAdapter<SanPham> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        addView();
        addEvent();
    }

    private void addView() {
        ten = findViewById(R.id.edtTen);
        mau = findViewById(R.id.edtMau);
        mua = findViewById(R.id.btnMua);
        lvSanPham = findViewById(R.id.lvSanPham);
        arrayAdapter = new ArrayAdapter<SanPham>(Shopping.this,android.R.layout.simple_list_item_1);
        lvSanPham.setAdapter(arrayAdapter);
    }

    private void addEvent() {
        mua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              xulychonmua();
            }
        });
        lvSanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SanPham sp = arrayAdapter.getItem(position);
                ten.setText(sp.getTenSP());
                mau.setText(sp.getMausac());
            }

        });
        lvSanPham.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                SanPham sp = arrayAdapter.getItem(position);
                arrayAdapter.remove(sp);
                return false;
            }
        });
    }

    private void xulychonmua() {
        SanPham sp = new SanPham();
        sp.setTenSP(ten.getText().toString());
        sp.setMausac(mau.getText().toString());
        arrayAdapter.add(sp);
    }

}
