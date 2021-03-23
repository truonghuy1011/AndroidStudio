package com.example.aysnctaskdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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
    private void linkViews() {
        edtNumberofViews=findViewById(R.id.edtNumberofViews);
        btnDraw=findViewById(R.id.btnDraw);
        txtPercent=findViewById(R.id.txtPercent);
        layoutViews=findViewById(R.id.layoutViews);
        pbPercent=findViewById(R.id.pbPercent);
    }

    private void drawUI() {
        int numb=Integer.parseInt(edtNumberofViews.getText().toString());
        MyAsyncTask myAsyncTask=new MyAsyncTask();
        myAsyncTask.execute(numb,3,7,8);

    }


    class MyAsyncTask extends AsyncTask<Integer,Integer,Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            layoutViews.removeAllViews();
            txtPercent.setText("0");
            pbPercent.setProgress(0);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            //Update UI
            int percent=values[0];
            int value=values[1];
            txtPercent.setText(percent+"%");
            pbPercent.setProgress(percent);
            ImageButton imageButton=new ImageButton(MainActivity.this);

            if (value%2==0){
                imageButton.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_android_yellow_24dp));

            }
            else {
                imageButton.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_android_black_24dp));
            }
            imageButton.setLayoutParams(layoutParams);
            layoutViews.addView(imageButton);
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            int numb=integers[0];
            int percent,value;
            for(int i=1;i<=numb;i++){
                percent=i*100/numb;
                value=random.nextInt(100);
                publishProgress(percent,value);
                SystemClock.sleep(100);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            txtPercent.setText("DONE");
        }
    }
}
