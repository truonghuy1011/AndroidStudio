package com.example.toastdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
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
    Button btnShort,btnLong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        addEvents();
    }

    private void addViews() {
        btnShort=findViewById(R.id.btnShort);
        btnLong=findViewById(R.id.btnLong);
    }

    private void addEvents() {
        btnShort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Welcome to UTC2", Toast.LENGTH_SHORT).show();
            }
        });
        btnLong.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //          Toast t = Toast.makeText(MainActivity.this, "Welcome to UTC2",Toast.LENGTH_LONG );
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_layout_container));
                TextView text = layout.findViewById(R.id.textView2);
                text.setText("Welcome to UTC2");
                Toast t = new Toast(getApplicationContext());
                t.setGravity(Gravity.CENTER,0,30);
                t.setDuration(Toast.LENGTH_LONG);
                t.setView(layout);
                t.show();

            }
        });
    }

    public void MoDialog(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_layout_container));
        builder.setTitle("Xác  nhận thoát!");
        builder.setMessage("Bạn có chắc muốn thoát?");
        builder.setIcon(android.R.drawable.ic_dialog_info);
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

    }


    public void xuliMoDialog(View view) {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.custom);
        dialog.setCanceledOnTouchOutside(false);
        Button btnOK = dialog.findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button btnCancel = dialog.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
