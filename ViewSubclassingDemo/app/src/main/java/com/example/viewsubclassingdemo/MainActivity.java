package com.example.viewsubclassingdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
        //addEvents();
    }


    public void xuLy(View view) {

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        TextView textView = new TextView(this);
        textView.setTextSize(24);
        textView.setText("utc2");
        linearLayout.addView(textView);

        Button btnBack = new androidx.appcompat.widget.AppCompatButton(this) {
            @Override
            public boolean performClick() {

                setContentView(R.layout.activity_main);
                return super.performClick();
            }
        };
        btnBack.setText("Back");
        btnBack.setLayoutParams(layoutParams);
        linearLayout.addView(btnBack);
        setContentView(linearLayout);
    }




    private void addView() {
        btnShow=findViewById(R.id.btnShow);
    }


}
