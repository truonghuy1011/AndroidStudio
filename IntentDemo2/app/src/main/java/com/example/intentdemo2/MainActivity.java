package com.example.intentdemo2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtSoNguyen;
    Button btnTimUS;
    TextView txtKetQua;

    public static final  int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        addEvents();

    }

    private void addEvents() {
        btnTimUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moManHinhTimUS();
            }
        });
    }
    private void moManHinhTimUS(){
        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
        intent.putExtra("N",Integer.parseInt(edtSoNguyen.getText().toString()));
        startActivityForResult(intent,REQUEST_CODE);
    }

    private void addViews() {
        edtSoNguyen=findViewById(R.id.edtSoNguyen);
        btnTimUS=findViewById(R.id.btnTimUS);
        txtKetQua=findViewById(R.id.txtKetQua);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE&&resultCode== Activity.RESULT_OK){
            ArrayList<Integer>ds=data.getIntegerArrayListExtra("dsUS");
            txtKetQua.setText("");
            for (int i:ds)
                txtKetQua.append(i+"\n");
        }
    }




}
