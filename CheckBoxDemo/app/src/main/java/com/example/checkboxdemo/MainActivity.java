package com.example.checkboxdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    CheckBox chkFilm,chkFPT,chkClip;
    Button btnConfilm;
    TextView txtKetqua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add();
        ;
    }

    private void add() {
        chkFilm=findViewById(R.id.chkFilm);
        chkClip=findViewById(R.id.chkClip);
        chkFPT=findViewById(R.id.chkFPT);
        btnConfilm=findViewById(R.id.btnConfirm);
        txtKetqua=findViewById(R.id.txtKetqua);
    }


    public void xuLyXacNhan(View view) {
        String kq="Bạn đã chon:";
        if(chkFilm.isChecked()){
            kq=chkFilm.getText().toString();
        }
        if (chkFPT.isChecked()){
            kq+=chkFPT.getText().toString();
        }
        if(chkClip.isChecked()){
            kq+=chkClip.getText().toString();
        }
        txtKetqua.setText(kq);
    }
}

