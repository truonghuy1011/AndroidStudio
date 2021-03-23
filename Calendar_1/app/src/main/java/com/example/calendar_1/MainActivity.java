package com.example.calendar_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtDuong;
    TextView txtAm;
    Button btnChuyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    }




    private void addControls() {

        edtDuong=findViewById(R.id.editText4);
        txtAm=findViewById(R.id.editText5);
        btnChuyen=findViewById(R.id.button);
    }


    public void xuliChuyen(View view) {
        String []arrCan={"Canh","Tân","Nhâm","Quý","Giáp","Ất","Bính","Đinh","Mậu","Kỷ"};
        String []arrChi={"Thân","Dậu","Tuất","Hợi","Tý","Sửu","Dần","Mẹo","Thìn","Tỵ","Ngọ","Mùi"};
        int namDuong=Integer.parseInt(edtDuong.getText().toString());
        String can=arrCan[namDuong%10];
        String chi=arrChi[namDuong%12];
        txtAm.setText(can+" "+chi);
    }
}
