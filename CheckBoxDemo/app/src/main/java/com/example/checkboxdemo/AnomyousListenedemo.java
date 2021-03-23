package com.example.checkboxdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AnomyousListenedemo extends AppCompatActivity {
    Button btnGreen,btnBlue;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anomyous_listenedemo);
        addViews();
        addEvents();
    }

    private void addEvents() {
        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView.setBackgroundColor(Color.GREEN);
            }
        });
        btnBlue.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                txtView.setBackgroundColor(Color.BLUE);
                return false;
            }
        });


    }


    private void addViews() {
        btnBlue=findViewById(R.id.btnBlue);
        btnGreen=findViewById(R.id.btnGreen);
        txtView=findViewById(R.id.txtView);

    }
}
