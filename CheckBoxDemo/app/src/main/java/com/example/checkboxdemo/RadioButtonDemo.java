package com.example.checkboxdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RadioButtonDemo extends AppCompatActivity {
    RadioButton rbtTuongdoitot, rbtTot, rbtRattot, rbtTuyetvoi;
    Button btnConfilm;
    TextView txtKetqua;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button_demo);
        addViews2();
    }


    private void addViews2() {
        rbtTuongdoitot = findViewById(R.id.rbtTuongdoitot);
        rbtRattot = findViewById(R.id.rbtRattot);
        rbtTot = findViewById(R.id.rbtTot);
        rbtTuyetvoi = findViewById(R.id.rbtTuyetvoi);
        btnConfilm = findViewById(R.id.btnConfirm);
        txtKetqua = findViewById(R.id.txtKetqua);
    }

    /*private void addViews() {

    }*/

    /*public void xuly(View view) {

    }*/

    public void xacnhan(View view) {
        String kq = "";
        if (rbtTuyetvoi.isChecked()) {
            kq = rbtTuyetvoi.getText().toString();
        } else if (rbtTot.isChecked()) {
            kq += rbtTot.getText().toString();
        } else if (rbtRattot.isChecked()) {
            kq += rbtRattot.getText().toString();
        } else if (rbtTuongdoitot.isChecked()) {
            kq += rbtTuongdoitot.getText().toString();

            RadioGroup group = findViewById(R.id.danhgia);
            int id = group.getCheckedRadioButtonId();
            CharSequence s;
            if (id > 0) {
                RadioButton radioButton = findViewById(id);
                s = radioButton.getText();

            }


        }
        txtKetqua.setText("Bạn đã đánh giá:"+kq);
    }
}