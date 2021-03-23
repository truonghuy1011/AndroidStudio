package com.example.baitapmot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class listofdrinks extends AppCompatActivity {
    ListView lvdrinks;
    String [] drinks = {"Cocacola","pepsi"};
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listofdrinks);
        addView();
        addEvent();
    }

    private void addEvent() {
        lvdrinks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(listofdrinks.this,drinks[position],Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addView() {
        lvdrinks = findViewById(R.id.lvDrinks);
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,drinks);
        lvdrinks.setAdapter(arrayAdapter);
    }
}
