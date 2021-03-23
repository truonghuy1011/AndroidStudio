package com.example.checkboxdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Android extends AppCompatActivity {
    ImageView imPic;
    ImageButton btnChangePic,btnClose;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android);
        addViews();
    }

    private void addViews() {
        imPic=findViewById(R.id.imPic);
        btnChangePic=findViewById(R.id.btnChangePic);
        btnClose=findViewById(R.id.btnClose);
    }

    public void xuLyDoiHinh(View view) {
        if(imPic.getTag()==null || imPic.getTag().equals("ios")){
            imPic.setImageResource(R.drawable.android);
            imPic.setTag("android");

        }
        else if(imPic.getTag().equals("android")){
            imPic.setImageDrawable(getResources().getDrawable(R.drawable.ios));
            imPic.setTag("ios");
        }

    }

    public void xuLyDong(View view) {
        finish();
    }
}
