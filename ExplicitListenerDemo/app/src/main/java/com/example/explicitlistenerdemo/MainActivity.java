package com.example.explicitlistenerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btnAndroid,btnIos;
    ImageView imv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAndroid=findViewById(R.id.btnAndroid);
        btnIos=findViewById(R.id.btnIos);
        imv=findViewById(R.id.imvPic);
        btnAndroid.setOnLongClickListener(new MyEvent());
        btnIos.setOnLongClickListener(new MyEvent());
        btnAndroid.setOnClickListener(new MyEvent());
        btnIos.setOnClickListener(new MyEvent());
    }

    class MyEvent implements View.OnClickListener,View.OnLongClickListener {
        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.btnAndroid){
                imv.setImageResource(R.drawable.android_icon);
            }
            if (v.getId()==R.id.btnIos){
                imv.setImageResource(R.drawable.ios_icon);

            }
        }

        @Override
        public boolean onLongClick(View v) {
            if(v.equals(btnAndroid)){
                imv.setVisibility(v.INVISIBLE);
            }
            return false;
        }
    }
}
