package com.example.toastdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnTShort, btnTLong, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addView();
        addEvent();
    }

    private void addEvent() {
        btnTShort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Wellcome", Toast.LENGTH_SHORT).show();
            }
        });

        btnTLong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast toast= Toast.makeText(MainActivity.this, "Wellcome Hồ Chí Minh City", Toast.LENGTH_LONG);
//                toast.setGravity(Gravity.CENTER, 0, 30);
//                toast.show();

                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_container));

                TextView text = layout.findViewById(R.id.textView);
                text.setText("Welcome To UTC 2");

                Toast t = new Toast(getApplicationContext());
                t.setGravity(Gravity.CENTER, 0, 30);
                t.setDuration(Toast.LENGTH_LONG);

                t.setView(layout);
                t.show();
            }
        });
    }

    private void addView() {
        btnTShort = findViewById(R.id.btnTShort);
        btnTLong = findViewById(R.id.btnTLong);
        button2 = findViewById(R.id.button2);
    }

    private void xuLyMoDialog2(){
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.setCanceledOnTouchOutside(false);

        ImageView imgOk = dialog.findViewById(R.id.imgOk);
        imgOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageView imgCancel =  dialog.findViewById(R.id.imgCancel);
        imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyCustomDialog myCustomDialog = new MyCustomDialog(MainActivity.this);
                myCustomDialog.show();
            }
        });
    }

    public void xuLyMoDialog(View view) {
//        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
//        builder.setTitle("Xác Nhận Thoát!!!");
//        builder.setMessage("Bạn có chắc muốn thoát không?");
//        builder.setIcon(android.R.drawable.ic_dialog_info);
//
//        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                finish();
//            }
//        });
//
//        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();;
//            }
//        });
//
//        AlertDialog dialog = builder.create();
//        dialog.setCanceledOnTouchOutside(false);
//        dialog.show();

        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.setCanceledOnTouchOutside(false);

        ImageView imgOk = dialog.findViewById(R.id.imgOk);
        imgOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageView imgCancel =  dialog.findViewById(R.id.imgCancel);
        imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    @Override
    public void onBackPressed() {
        xuLyMoDialog2();
    }
}
