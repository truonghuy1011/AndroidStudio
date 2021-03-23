package com.example.intentdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    TextView txtN;
    Button btnXuLi;
    Intent intent=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addViews();
        addEvents();
    }

    private void addEvents() {
        btnXuLi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhUS();
            }


        });
    }
    private void tinhUS() {
        int n=Integer.parseInt(txtN.getText().toString());
        ArrayList<Integer>ds=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if (n%i==0){
                ds.add(i);
            }
        }
        intent.putExtra("dsUS",ds);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }

    private void addViews() {
        txtN=findViewById(R.id.txtN);
        btnXuLi=findViewById(R.id.btnXuli);

        intent=getIntent();
        txtN.setText(intent.getIntExtra("N",0)+"");
    }
}
