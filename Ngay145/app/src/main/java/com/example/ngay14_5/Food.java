package com.example.ngay14_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Food extends AppCompatActivity {
    ListView lvfood;
    String []foods;
    ArrayAdapter<String> Arrayadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        addViews();
        addEvent();
    }

    private void addEvent() {
        lvfood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Food.this,foods[position],Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addViews() {
        lvfood=findViewById(R.id.lvfood);
        foods=getResources().getStringArray(R.array.myFood);
        Arrayadapter=new ArrayAdapter<String>(Food.this,android.R.layout.simple_expandable_list_item_1,foods);
        lvfood.setAdapter(Arrayadapter);
    }
}
