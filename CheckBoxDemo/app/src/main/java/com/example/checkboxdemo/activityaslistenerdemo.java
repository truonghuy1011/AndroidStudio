package com.example.checkboxdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class activityaslistenerdemo extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener{
    Button btnIos,btnAndroid;
    ImageView imv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityaslistenerdemo);

        btnIos=findViewById(R.id.btnIos);
        btnAndroid=findViewById(R.id.btnAndroid);
        imv=findViewById(R.id.imageView);

        btnIos.setOnClickListener(this);
        btnAndroid.setOnClickListener(this);
        btnAndroid.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnIos){
            imv.setImageResource(R.drawable.ios);
        }
        else if (v.getId()==R.id.btnAndroid){
            imv.setImageResource(R.drawable.android);
        }


    }

    @Override
    public boolean onLongClick(View v) {
        if(v.getId()==R.id.btnAndroid){
            imv.setImageResource((R.drawable.android));

        }
        else if(v.getId()==R.id.btnIos){
            imv.setImageResource(R.drawable.ios);
        }
        return false;
    }
}
