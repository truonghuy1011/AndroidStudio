package com.example.ngay14_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.model.SanPham;

public class Shop extends AppCompatActivity {
    ListView lvshop;
    EditText edtName,edtColor;
    Button btnMua;
    ArrayAdapter<SanPham> sanPhamArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        addViews();
        addEvent();
    }

    private void addEvent() {
        lvshop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SanPham sp=sanPhamArrayAdapter.getItem(position);
                edtName.setText(sp.getTenSP());
                edtColor.setText(sp.getMauSac());
            }
        });
        lvshop.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                SanPham sanpham=sanPhamArrayAdapter.getItem(position);
                sanPhamArrayAdapter.remove(sanpham);
                return false;
            }
        });
    }

    private void addViews() {
        lvshop=findViewById(R.id.lvshop);
        btnMua=findViewById(R.id.btnMua);
        edtName=findViewById(R.id.edtName);
        edtColor=findViewById(R.id.edtColor);
        sanPhamArrayAdapter =new ArrayAdapter<SanPham>(Shop.this,android.R.layout.simple_list_item_1);
        lvshop.setAdapter(sanPhamArrayAdapter);
    }

    public void xuLy(View view) {
        SanPham sp=new SanPham();
        sp.setMauSac(edtColor.getText().toString());
        sp.setTenSP(edtName.getText().toString());
        sanPhamArrayAdapter.add(sp);

    }
}
