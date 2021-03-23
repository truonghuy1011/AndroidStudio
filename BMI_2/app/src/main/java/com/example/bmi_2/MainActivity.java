package com.example.bmi_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtWeight,edtHeight;
    TextView txtResult;
    Button btnNhap;
    String BMIresult,kq;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();

    }

    private void addViews() {
        edtHeight=findViewById(R.id.edtHeight);
        edtWeight=findViewById(R.id.edtWeight);
        txtResult=findViewById(R.id.txtResult);
        btnNhap=findViewById(R.id.btnNhap);
    }

    public void ketquaCando(View view) {
        float weightValue=Float.parseFloat(edtWeight.getText().toString());
        float heightValue=Float.parseFloat(edtHeight.getText().toString())/100;
        float BMI=weightValue/(heightValue*heightValue);

        if(BMI<16){
            BMIresult="Gầy độ III";
        }
        else if(16<=BMI && BMI<17){
            BMIresult="Gầy độ II";
        }
        else  if (17<=BMI && BMI<18.5){
            BMIresult="Gầy độ I";
        }
        else if (18.5<=BMI && BMI<25){
            BMIresult="Bình thường";
        }
        else if (25<=BMI && BMI<30){
            BMIresult="Thừa cân";
        }
        else if (30<=BMI && BMI<35){
            BMIresult="Béo phì loại I";
        }
        else if (35<=BMI && BMI<40){
            BMIresult="Béo phì độ II";
        }
        else if (BMI>40){
            BMIresult="Béo phì độ III";
        }
        kq="Nhận xét\n"+BMI+"\n"+BMIresult;
        txtResult.setText(kq);


//
    }
}
