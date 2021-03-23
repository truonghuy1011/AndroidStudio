package com.example.ngay14_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class ListViewcoban extends AppCompatActivity {
    ListView lvdrink;
    String []drinks={"coca-cola","pepsi","DrThanh","Bo huc","Coffee","Milk","Trasua","Tea","Orange"};
    ArrayAdapter<String> Arrayadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_viewcoban);
        addViews();
        addEvent();
    }

    private void addEvent() {
        lvdrink.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewcoban.this,drinks[position],Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addViews() {
        lvdrink=findViewById(R.id.lvdrink);
        Arrayadapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,drinks);
        lvdrink.setAdapter(Arrayadapter);
    }


}
