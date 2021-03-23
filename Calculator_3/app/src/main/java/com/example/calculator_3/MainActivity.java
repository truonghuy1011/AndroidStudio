package com.example.calculator_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvExpression,tvResult;
    TextView tvClear,tvDivide,tvSeven,tvEight,tvNine,tvMul,
            tvFour,tvFive,tvSix,tvMinus,tvOne,tvTwo,tvThree,tvPlus,tvEquals,tvZero;
    private final char ADDITION='+';
    private final char SUBTRACTION='-';
    private final char MULTIPLICATION='*';
    private final char DIVISION='/';
    private final char EQU=0;
    private double val1=Double.NaN;
    private double val2;
    private char ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        connectView();
        tvZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvExpression.setText(tvExpression.getText().toString()+"0");
            }
        });
        tvOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvExpression.setText(tvExpression.getText().toString()+"1");
            }
        });
        tvTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvExpression.setText(tvExpression.getText().toString()+"2");
            }
        });
        tvThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvExpression.setText(tvExpression.getText().toString()+"3");
            }
        });
        tvFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvExpression.setText(tvExpression.getText().toString()+"4");
            }
        });
        tvFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvExpression.setText(tvExpression.getText().toString()+"5");
            }
        });
        tvSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvExpression.setText(tvExpression.getText().toString()+"6");
            }
        });
        tvSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvExpression.setText(tvExpression.getText().toString()+"7");
            }
        });
        tvEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvExpression.setText(tvExpression.getText().toString()+"8");
            }
        });
        tvNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvExpression.setText(tvExpression.getText().toString()+"9");
            }
        });
        tvPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectView();
                ACTION=ADDITION;
                tvResult.setText(String.valueOf(val1)+'+');
                tvExpression.setText(null);
            }
        });
        tvMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectView();
                ACTION=SUBTRACTION;
                tvResult.setText(String.valueOf(val1)+'-');
                tvExpression.setText(null);
            }
        });
        tvMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectView();
                ACTION=MULTIPLICATION;
                tvResult.setText(String.valueOf(val1)+'*');
                tvExpression.setText(null);
            }
        });
        tvDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectView();
                ACTION=DIVISION;
                tvResult.setText(String.valueOf(val1)+'/');
                tvExpression.setText(null);
            }
        });
        tvEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectView();
                ACTION=EQU;
                tvResult.setText(tvResult.getText().toString()+String.valueOf(val2)+'='+String.valueOf(val1));
                tvExpression.setText(null);
            }
        });

        tvClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvExpression.getText().length()>0){
                    CharSequence name=tvExpression.getText().toString();
                    tvExpression.setText(name.subSequence(0,name.length()-1));
                }
                else {
                    val1=Double.NaN;
                    val2=Double.NaN;
                    tvExpression.setText(null);
                    tvResult.setText(null);
                }
            }
        });


    }

    private void connectView() {
        if (!Double.isNaN(val1)){
            val2=Double.parseDouble(tvExpression.getText().toString());

            switch (ACTION){
                case ADDITION:
                    val1=val1+val2;
                    break;
                case SUBTRACTION:
                    val1=val1-val2;
                    break;
                case MULTIPLICATION:
                    val1=val1*val2;
                    break;
                case DIVISION:
                    val1=val1/val2;
                    break;
                case EQU:
                    break;
            }

        }
        else {
            val1=Double.parseDouble(tvExpression.getText().toString());
        }
    }

    private void addViews() {
        tvExpression=findViewById(R.id.tvExpression);
        tvResult=findViewById(R.id.tvResult);
        tvOne=findViewById(R.id.tvOne);
        tvTwo=findViewById(R.id.tvTwo);
        tvThree=findViewById(R.id.tvThree);
        tvFour=findViewById(R.id.tvFour);
        tvFive=findViewById(R.id.tvFive);
        tvSix=findViewById(R.id.tvSix);
        tvSeven=findViewById(R.id.tvSeven);
        tvEight=findViewById(R.id.tvEight);
        tvNine=findViewById(R.id.tvNine);
        tvZero=findViewById(R.id.tvZero);
        tvClear=findViewById(R.id.tvClear);
        tvDivide=findViewById(R.id.tvDivide);
        tvMul=findViewById(R.id.tvMul);
        tvPlus=findViewById(R.id.tvPlus);
        tvMinus=findViewById(R.id.tvMinus);
        tvEquals=findViewById(R.id.tvEquals);

    }


}

