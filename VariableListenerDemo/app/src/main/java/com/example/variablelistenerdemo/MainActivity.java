package com.example.variablelistenerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btnShow,btnHide;
    ImageView imv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShow=findViewById(R.id.btnShow);
        btnHide=findViewById(R.id.btnHide);
        imv=findViewById(R.id.imvPic);
        btnShow.setOnLongClickListener(new MyEvent());
        btnHide.setOnLongClickListener(new MyEvent());
        btnShow.setOnClickListener(new MyEvent());
        btnHide.setOnClickListener(new MyEvent());
    }


    class MyEvent implements View.OnClickListener,View.OnLongClickListener {
        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.btnShow){
                imv.setImageResource(R.drawable.android);
            }
            else if (v.getId()==R.id.btnHide){
                imv.setImageResource(R.drawable.ios);
            }
        }

        @Override
        public boolean onLongClick(View v) {
            if (v.equals(btnShow)){
                imv.setVisibility(v.INVISIBLE);
            }
            return false;
        }
    }
}




