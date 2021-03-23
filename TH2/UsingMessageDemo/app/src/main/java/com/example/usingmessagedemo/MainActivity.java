package com.example.usingmessagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText edtNumberofViews;
    Button btnDraw;
    TextView txtPercent;
    LinearLayout layoutViews;
    ProgressBar pbPercent;
    int numb=0,percent,value;
    Random random=new Random();

    LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(200,LinearLayout.LayoutParams.WRAP_CONTENT);

    Handler handler

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkViews();
        addEvents();
    }

    private void addEvents() {
        btnDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawUI();
            }
        });
    }


    private void drawUI() {
        layoutViews.removeAllViews();
        numb=Integer.parseInt(edtNumberofViews.getText().toString());
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=numb;i++){
                    Message message=handler.obtaiMessager();
                    message.arg1=i*100/numb;
                    handler.sendMessage(message);
                    SystemClock.sleep(100);
                }
            }
        });
    }

    private void linkViews() {
        edtNumberofViews=findViewById(R.id.edtNumberofViews);
        btnDraw=findViewById(R.id.btnDraw);
        txtPercent=findViewById(R.id.txtPercent);
        layoutViews=findViewById(R.id.layoutViews);
    }

}
