package com.example.baitapmot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class listoffood extends AppCompatActivity {
    ListView lvfood;
    ArrayAdapter<String> arrayAdapter;
    String [] danhsach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listoffood);
        addView();
        addEvent();

    }

    private void addEvent() {
        lvfood.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(listoffood.this,danhsach[position],Toast.LENGTH_LONG).show();
                return false;
            }
        });

    }

    private void addView() {
        lvfood = findViewById(R.id.lvFood);
        danhsach = getResources().getStringArray(R.array.danhsach);
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,danhsach);
        lvfood.setAdapter(arrayAdapter);
    }
}
