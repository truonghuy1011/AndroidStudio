package com.example.activitylistenerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener{
    Button btnAndroid,btnIos;
    ImageView imv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAndroid=findViewById(R.id.btnAndroid);
        btnIos=findViewById(R.id.btnIos);
        imv=findViewById(R.id.imvPic);

        btnAndroid.setOnClickListener(this);
        btnIos.setOnClickListener(this);
        btnAndroid.setOnLongClickListener(this);
        btnIos.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnAndroid){
            imv.setImageResource(R.drawable.android_icon);
        }
        if(v.getId()==R.id.btnIos){
            imv.setImageResource(R.drawable.ios_icon);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if(v.getId()==R.id.btnAndroid){
            imv.setVisibility(v.INVISIBLE);
        }
        if(v.getId()==R.id.btnIos){
            imv.setVisibility(v.INVISIBLE);
        }
        return false;
    }
}
