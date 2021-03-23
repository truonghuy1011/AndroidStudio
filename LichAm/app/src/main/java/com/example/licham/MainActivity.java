package com.example.licham;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_change;
    EditText txt_year;
    TextView txt_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_change=findViewById(R.id.btn_change);
        txt_result=findViewById(R.id.txt_result);
        txt_year=findViewById(R.id.txt_year);
    }

    public void xuLy(View view) {
        String []arrCan = {"Canh","Tân","Nhâm","Quý","Giáp","Ất","Bính","Đinh","Mậu","Kỷ"};
        String []arrChi = {"Thân","Dậu","Tuất","Hợi","Tý","Sửu","Dần","Mẹo","Thìn","Tỵ","Ngọ","Mùi"};
        int namduong = Integer.parseInt(txt_year.getText().toString());
        String can = arrCan[namduong%10];
        String chi = arrChi[namduong%12];
        txt_result.setText(can+" "+chi);
    }
}
