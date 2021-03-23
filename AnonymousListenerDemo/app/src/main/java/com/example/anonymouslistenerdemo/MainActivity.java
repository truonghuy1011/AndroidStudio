package com.example.anonymouslistenerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnGreen,btnBlue;
    TextView txtColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
        addView1();
    }



    private void addView() {
        btnGreen=findViewById(R.id.btnGreen);
        btnBlue=findViewById(R.id.btnBlue);
        txtColor=findViewById(R.id.txtColor);
    }

    View.OnClickListener myEvent=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.btnGreen){
                txtColor.setBackgroundColor(Color.GREEN);
            }
            if(v.getId()==R.id.btnBlue){
                txtColor.setBackgroundColor(Color.BLUE);
            }
        }
    };
    private void addView1() {
        btnGreen.setOnClickListener(myEvent);
        btnBlue.setOnClickListener(myEvent);
    }

}
